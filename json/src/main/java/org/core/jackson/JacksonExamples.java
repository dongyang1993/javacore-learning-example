package org.core.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.core.bean.Order;
import org.core.bean.PayEnum;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class JacksonExamples {

    @Test
    public void test01() throws Exception{
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
        Order order = new Order();
        order.setName("订单1号");
        order.setPayType(PayEnum.AliPay);
        order.setPrivateProperty("privateProperty");
        order.setCreateTime(LocalDateTime.now());
        byte[] bytes = serializer.serialize(order);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));

        Order pp = serializer.deserialize(bytes);
        System.out.println("");
    }

}
