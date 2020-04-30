package com.collection.vo;

import com.collection.eo.Ad;
import org.springframework.web.multipart.MultipartFile;

public class AdVo {
    private Ad ad;
    private MultipartFile file;

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
