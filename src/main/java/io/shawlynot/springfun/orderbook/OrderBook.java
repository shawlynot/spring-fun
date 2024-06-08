package io.shawlynot.springfun.orderbook;

import org.springframework.stereotype.Controller;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

@Controller
public class OrderBook {

    private static final Comparator<LimitOrder> COMPARE_LIMIT_ORDERS = Comparator.comparingLong(LimitOrder::getPrice);
    private final PriorityBlockingQueue<LimitOrder> buys = new PriorityBlockingQueue<>(128, COMPARE_LIMIT_ORDERS.reversed());
    private final PriorityBlockingQueue<LimitOrder> sells = new PriorityBlockingQueue<>(128, COMPARE_LIMIT_ORDERS);

    public PriorityBlockingQueue<LimitOrder> getBuys() {
        return buys;
    }
    public PriorityBlockingQueue<LimitOrder> getSells() {
        return sells;
    }

    public void limitBuy(long price, long quantity, long id) {
        //add to journal

        long quatityremaining = quantity;
        while (!sells.isEmpty() && sells.peek().getPrice() <= price && quatityremaining > 0) {
            LimitOrder lowestSell = sells.peek();
            if (lowestSell.getQuantity() <= quatityremaining) {
                quatityremaining -= lowestSell.getQuantity();
                //remove from order book
                sells.poll();
            } else {
                lowestSell.setQuantity(lowestSell.getQuantity() - quatityremaining);
                quatityremaining = 0;
            }
        }
        if (quatityremaining > 0) {
            buys.add(new LimitOrder(quatityremaining, price, id));
        }
    }

    public void limitSell(long price, long quantity, long id) {
        //add to journal

        long quatityremaining = quantity;
        while (!buys.isEmpty() && buys.peek().getPrice() >= price && quatityremaining > 0) {
            LimitOrder highestBuy = buys.peek();
            if (highestBuy.getQuantity() <= quatityremaining) {
                quatityremaining -= highestBuy.getQuantity();
                buys.poll();
            } else {
                highestBuy.setQuantity(highestBuy.getQuantity() - quatityremaining);
                quatityremaining = 0;
            }
        }
        if (quatityremaining > 0) {
            sells.add(new LimitOrder(quatityremaining, price, id));
        }
    }
}
