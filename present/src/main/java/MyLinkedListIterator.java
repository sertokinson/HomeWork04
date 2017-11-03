import java.util.Iterator;

public class MyLinkedListIterator<E> implements Iterator<E> {
    Node<E> first;

    public MyLinkedListIterator(Node<E> first) {
        this.first = first;
    }

    @Override
    public boolean hasNext() {
        return first!=null;
    }

    @Override
    public E next() {
        E item=first.item;
        first=first.next;
        return item;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();

    }
}
