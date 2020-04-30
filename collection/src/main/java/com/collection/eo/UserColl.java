package com.collection.eo;

public class UserColl extends BaseEo{
    private User user;
    private Goods goods;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "UserColl{" +
                "user=" + user +
                ", goods=" + goods +
                '}';
    }
}
