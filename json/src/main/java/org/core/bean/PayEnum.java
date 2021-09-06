package org.core.bean;

public enum PayEnum {
    AliPay("支付宝"),
    WeiXinPay("微信支付"),
    BestPay("翼支付"),
    YSF("云闪付");

    private final String name;

    PayEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
