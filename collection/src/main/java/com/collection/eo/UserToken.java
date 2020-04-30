package com.collection.eo;

import java.util.Date;

public class UserToken extends  BaseEo {
    private Integer userId;
    private String ticket;
    private Date expired;
    private Byte status;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "userId=" + userId +
                ", ticket='" + ticket + '\'' +
                ", expired=" + expired +
                ", status=" + status +
                '}';
    }
}
