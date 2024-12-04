package org.core.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.core.bean.Order;
import org.core.bean.PayEnum;

public class Main {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        // 启用默认类型,将类信息写入@class属性
        mapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        // 允许私有字段序列化
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    }

    public static void main(String[] args) throws Exception {
        Order order = new Order();
        order.setName("订单1号");
        order.setPayType(PayEnum.AliPay);
        String json = Jackson2JsonSerializer.serialize(order);
        System.out.println(json);

        Order pp = Jackson2JsonSerializer.deserialize(json);
        System.out.println("");
    }

}
