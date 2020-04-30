package com.collection.util;

import com.collection.eo.User;
import org.springframework.stereotype.Component;

@Component
public class HostHolder {
    private User user;

    public void clear() {
        this.user=null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "HostHolder{" +
                "user=" + user +
                '}';
    }
}
