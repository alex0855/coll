package com.collection.eo;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class Order extends BaseEo {
    private String orderNumber;
    private User buyer;
    private UserAddress userAddress;
    private Byte tradeStatus;
    private Byte payStatus;
    private BigDecimal orderAmount;
    private BigDecimal payAmount;
    private Date payTime;
    private String orderTradeId;
    private String remark;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public Byte getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(Byte tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public Byte getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getOrderTradeId() {
        return orderTradeId;
    }

    public void setOrderTradeId(String orderTradeId) {
        this.orderTradeId = orderTradeId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", buyer=" + buyer +
                ", userAddress=" + userAddress +
                ", tradeStatus=" + tradeStatus +
                ", payStatus=" + payStatus +
                ", orderAmount=" + orderAmount +
                ", payAmount=" + payAmount +
                ", payTime=" + payTime +
                ", orderTradeId=" + orderTradeId +
                ", remark='" + remark + '\'' +
                '}';
    }
}
