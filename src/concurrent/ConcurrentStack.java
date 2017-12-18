package concurrent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by CS on 2017/12/17.
 */
public class ConcurrentStack<E>{
    private static class Node<E>{
        public final E item;
        public Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

    AtomicReference<Node<E>> top = new AtomicReference<>();

    public void push(E item) {
        Node<E> newHead = new Node<>(item);
        Node<E> old;
        do {
            old = top.get();
            newHead.next = old;
        } while (!top.compareAndSet(old, newHead));
    }

    public E pop() {
        Node<E>old;
        Node<E>newHead;
        do {
            old = top.get();
            if (old == null) {
                return null;
            }
            newHead = old.next;
        }

        while (!top.compareAndSet(old, newHead));
        return old.item;
    }
}
