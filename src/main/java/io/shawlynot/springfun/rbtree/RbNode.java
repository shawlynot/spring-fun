package io.shawlynot.springfun.rbtree;

import java.util.Objects;

public final class RbNode<T extends Comparable<T>> {
    private T item;
    private RbNode<T> left;
    private RbNode<T> right;
    private RbColour colour;

    public RbNode(
            T item,
            RbNode<T> left,
            RbNode<T> right,
            RbColour colour
    ) {
        this.item = item;
        this.left = left;
        this.right = right;
        this.colour = colour;
    }

    public T item() {
        return item;
    }

    public RbNode<T> left() {
        return left;
    }

    public RbNode<T> right() {
        return right;
    }

    public RbColour colour() {
        return colour;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setLeft(RbNode<T> left) {
        this.left = left;
    }

    public void setRight(RbNode<T> right) {
        this.right = right;
    }

    public void setColour(RbColour colour) {
        this.colour = colour;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (RbNode) obj;
        return Objects.equals(this.item, that.item) &&
                Objects.equals(this.left, that.left) &&
                Objects.equals(this.right, that.right) &&
                Objects.equals(this.colour, that.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, left, right, colour);
    }

    @Override
    public String toString() {
        return "RbNode[" +
                "item=" + item + ", " +
                "left=" + left + ", " +
                "right=" + right + ", " +
                "colour=" + colour + ']';
    }


}
