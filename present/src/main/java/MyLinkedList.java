import java.util.Collection;
import java.util.Iterator;

class MyLinkedList<E> implements Iterable<E> {
    int size = 0;
    private Node<E> first;
    private Node<E> last;

    void add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    void add(int index, E e) {
        isBoundOfIndex(index);
        Node<E> newNode;
        if (index == 0) {
            newNode = new Node<>(null, e, first);
            first = newNode;
        } else if (index == size) {
            newNode = new Node<>(last, e, null);
            last.next = newNode;
            last = newNode;

        } else {
            Node<E>f=findByIndex(index);
            newNode = new Node<>(f.prev, e, f);
            f.prev.next = newNode;
        }
        size++;
    }

    E get(int index) {
        return findByIndex(index).item;
    }

    private Node<E> findByIndex(int index) {
        int count = 0;
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        Node<E> l = first;
        Node<E> p;
        while (count++ < index) {
            p = l.next;
            l = p;
        }
        return l;
    }
    E remove(int index){
        isBoundOfIndex(index);
        Node<E>f=findByIndex(index);
        E item= f.item;
        if (index == 0)
            first=first.next;
        else if (index == size-1)
            last=last.prev;
          else {
            f.prev.next=f.next;
            f.next.prev=f.prev;
        }
        size--;
        return item;
    }
    private void isBoundOfIndex(int index){
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
    }
    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator<>(first);
    }

    public boolean addAll(Collection<? extends E> c) {
        if(c.size()==0)
            return false;
        for (E element:c){
            add(element);
        }
        return true;
    }


}