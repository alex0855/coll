package com.collection.controller.pay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.collection.eo.Order;
import com.collection.service.OrderService;
import com.collection.vo.AlipayVo;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

//import lombok.extern.slf4j.Slf4j;
//import lombok.extern.slf4j.XSlf4j;

/**
 * @Auther: zhaoxinguo
 * @Date: 2018/8/30 15:11
 * @Description: 支付宝后台接口
 */

@Controller
@RequestMapping(value = "/alipay")
public class AlipayController extends PayBaseController {

    @Autowired
    private OrderService orderService;

    private  final Logger log= LoggerFactory.getLogger(AlipayController.class);
    /**
     * 支付网站扫码支付接口-统一下单支付接口
     * @return
     * @throws AlipayApiException
     */
    @ResponseBody
    @GetMapping("/pay")
    private String alipayPay(AlipayVo vo) throws AlipayApiException {
        //这个应该是从前端端传过来的，这里为了测试就从后台写死了
//        vo.setOut_trade_no(UUID.randomUUID().toString().replace("-", ""));
//        vo.setTotal_amount("0.01");
//        vo.setSubject("nelson-test-title");
//        vo.setProduct_code("FAST_INSTANT_TRADE_PAY"); //这个是固定的
        String json = new Gson().toJson(vo);
        log.info("json: {}", json);

        AlipayClient alipayClient = new DefaultAlipayClient(gateway_url, app_id, merchant_private_key, "json",charset,alipay_public_key,sign_type);
        // 设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);
        alipayRequest.setBizContent(json);
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        log.info("result: {}", result);
        return result; //这里生成一个表单，会自动提交
    }

    /**
     * 支付宝服务器异步通知页面
     * @param request
     * @param out_trade_no 商户订单号
     * @param trade_no 支付宝交易凭证号
     * @param trade_status 交易状态
     * @return
     * @throws AlipayApiException
     */
    @PostMapping("/notify")
    public String alipayNotify(HttpServletRequest request, String out_trade_no, String trade_no, String trade_status, Model model) throws AlipayApiException, ParseException  {
        Map<String, String> params = getParamsMap(request);
//        ObjectMapper objectMapper = new ObjectMapper();
        log.info("notify params: {}", JSONObject.toJSON(params));
//        log.info("notify params: {}", objectMapper.writeValueAsString(params));
        // 验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, alipay_public_key, charset, sign_type);
        log.info("notify signVerified: {}", signVerified);
        if (signVerified) {
            Order order = new Order();
            out_trade_no = params.get("out_trade_no");
            String total_amount = params.get("total_amount");
            trade_no = params.get("trade_no");
            String gmt_payment = params.get("gmt_payment");
            order.setOrderNumber(out_trade_no);
            order.setPayStatus((byte)1);//已付款
            order.setTradeStatus((byte)1);//已结算
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            order.setPayTime(sdf.parse(gmt_payment));
            order.setOrderTradeId(trade_no);
            orderService.updateByOrderNumber(order);
            //处理你的业务逻辑，更细订单状态等
            model.addAttribute("tradeId",trade_no);
            return "/back/paysuccess";
        } else {
            log.info("验证失败,不去更新状态");
            return "/back/500";
        }
    }

    /**
     * 支付宝服务器同步通知页面
     * @param request
     * @param out_trade_no 商户订单号
     * @param trade_no 支付宝交易凭证号
     * @param total_amount 交易状态
     * @return
     * @throws AlipayApiException
     */
    @GetMapping("/return")
    public String alipayReturn(HttpServletRequest request, String out_trade_no,String trade_no,String total_amount) throws AlipayApiException{
        Map<String, String> params = getParamsMap(request);
        log.info("return params: {}", JSONObject.toJSON(params));

        // 验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, alipay_public_key, charset, sign_type);
        log.info("return signVerified: {}", signVerified);

        if (signVerified) {

            return "/back/paysuccess";
        } else {
            log.info("验证失败,不去更新状态");
            return "/back/500";
        }
    }

    @ResponseBody
    private Map<String, String> getParamsMap(HttpServletRequest request) {
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            try {
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                params.put(name, valueStr);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return params;
    }

}
