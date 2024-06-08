package io.shawlynot.springfun.controller;

import io.shawlynot.springfun.orderbook.OrderBook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "exchange")
public class ExchangeController {

    private final OrderBook orderBook;

    private final Random random = new Random();

    public ExchangeController(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    @PostMapping(path = "/order")
    public ResponseEntity<Long> order(@RequestBody OrderDTO order) {
        long id = random.nextLong(Long.MAX_VALUE);
        if (order.orderSide().equals(OrderSide.BUY)) {
            orderBook.limitBuy(order.price(), order.quantity(), id);
        } else {
            orderBook.limitSell(order.price(), order.quantity(), id);
        }
        return ResponseEntity.ok(id);
    }

    @GetMapping(path = "/order")
    public ResponseEntity<List<OrderDTO>> getOrders() {
        var orders = Stream.concat(
                orderBook.getBuys()
                        .stream()
                        .map(order -> new OrderDTO(order.getPrice(), order.getQuantity(), OrderType.LIMIT, OrderSide.BUY)),
                orderBook.getSells()
                        .stream()
                        .map(order -> new OrderDTO(order.getPrice(), order.getQuantity(), OrderType.LIMIT, OrderSide.SELL))
        ).toList();
        return ResponseEntity.ok(orders);
    }
}
