package io.shawlynot.springfun.controller;

public record OrderDTO(
        long price,
        long quantity,
        OrderType orderType,
        OrderSide orderSide
) {
}
