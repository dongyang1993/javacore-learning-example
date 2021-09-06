package org.core.bean;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigDecimal;
import java.util.Arrays;

public class Order {

    private Long orderNum;

    private String name;

    private String address;

    private String phone;

    private BigDecimal money;

    @JsonProperty("type")
//    @JsonIgnore
    private PayEnum payType;

    public Order() {
    }

    public Order(Long orderNum, String name, String address, String phone, BigDecimal money, PayEnum payType) {
        this.orderNum = orderNum;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.money = money;
        this.payType = payType;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public PayEnum getPayType() {
        return payType;
    }

    @JsonGetter("OL")
    public String getPayTypeJSON() {
        return payType.getName();
    }

    public void setPayType(PayEnum payType) {
        this.payType = payType;
    }

    @JsonSetter("OL")
    public void setPayTypeJSON(String payType) {
        this.payType = Arrays.stream(PayEnum.values()).filter(n -> n.getName().equals(payType)).findAny().orElse(null);
    }
}
