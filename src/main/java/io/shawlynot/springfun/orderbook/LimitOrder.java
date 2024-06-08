package io.shawlynot.springfun.orderbook;

public class LimitOrder {
    private final long price;
    private final long id;
    private long quantity;


    public LimitOrder(long quantity, long price, long id) {
        this.price = price;
        this.id = id;
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }
}
