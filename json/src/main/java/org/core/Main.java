package org.core;

import org.core.bean.Order;
import org.core.bean.PayEnum;
import org.core.jackson.JacksonUtil;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(10000L, "秦始皇", "骊山", "00795100", BigDecimal.TEN, PayEnum.AliPay);
        String json = JacksonUtil.toJson(order);
        System.out.println(json);
        json = json.replace("支付宝", "");
        Order orderJSON = JacksonUtil.toObject(json, Order.class);
        System.out.println("");
    }
}
