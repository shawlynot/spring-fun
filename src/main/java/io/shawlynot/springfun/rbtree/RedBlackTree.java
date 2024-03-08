package io.shawlynot.springfun.rbtree;

import java.util.List;

import static io.shawlynot.springfun.rbtree.RbColour.BLACK;

public class RedBlackTree<T extends Comparable<T>> {

    private RbNode<T> root;

    boolean insert(T item) {
        if (root == null) {
            root = new RbNode<>(item, null, null, BLACK);
        }
        return false;
    }

    boolean delete(T item) {
        return false;
    }

    boolean contains(T item) {
        return false;
    }

    // return iterator
    List<T> getAll() {
        return null;
    }

    private void rotateLeft(RbNode<T> node) {
        var a = node.left();
        var gamma = node.right();
        var alpha = a.left();
        var beta = a.right();

        node.setLeft(beta);
        node.setRight(gamma);
        a.setRight(node);
        a.setLeft(alpha);
    }

    private void rotateRight(RbNode<T> node) {
        var b = node.right();
        var alpha = node.left();
        var beta = b.left();
        var gamma = b.right();

        node.setLeft(alpha);
        node.setRight(beta);
        b.setLeft(node);
        b.setRight(gamma);
    }

}
