import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class CountMapIml<E> implements CountMap<E>, Iterable<E> {

    private E[] a, b;
    private int index = 0;
    private Map<E, Integer> m = new HashMap<>();

    @Override
    public void add(E o) {
        index++;
        a = (E[]) new Object[index];
        if (b != null) {
            System.arraycopy(b,0,a,0,b.length);
        }
        a[index - 1] = o;
        b = a;
    }

    @Override
    public int getCount(E o) {
        int count = 0;
        for (E e:a) {
            if(e.equals(o))
                count++;
        }
        return count;
    }

    @Override
    public int remove(E o) {
        b = (E[]) new Object[a.length - 1];
        int j = 0, count = getCount(o);
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(o))
                i++;
            b[j++] = a[i];
        }
        index--;
        a = b;
        return count;
    }

    @Override
    public int size() {
        int count = 0;
        b = (E[]) new Object[a.length];
        System.arraycopy(a,0,b,0,a.length);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                count++;
                for (int j = i + 1; j < a.length; j++)
                    if (a[i].equals(a[j]))
                        a[j] = null;
            }
        }
        a = b;
        return count;
    }

    @Override
    public void addAll(CountMap source) {
        int f;
        for (int i = 0; i < a.length; i++) {
            f = 0;
            for (int j = 0; j < source.length(); j++)
                if (source.get(j) == a[i]) {
                    m.put((E) a[i], getCount((E) a[i]) + source.getCount(source.get(j)));
                    f = 1;
                }
            if (f == 0) m.put((E) a[i], getCount((E) a[i]));
        }
        for (int i = 0; i < source.length(); i++) {
            for (int j = 0; j < a.length; j++)
                if (source.get(i) == a[j]) {
                    source.remove(a[j]);
                    break;
                }
            m.put((E) source.get(i), source.getCount(source.get(i)));
        }
    }


    @Override
    public Map toMap() {
        if (m.size() == 0)
            for (E e:a) {
                m.put(e, getCount(e));
            }
        return m;
    }

    @Override
    public void toMap(Map<E, Integer> destination) {
        for (E e:a) {
            destination.put(e, getCount(e));
        }
    }

    public E get(int i) {
        return a[i];
    }

    public int length() {
        return a.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new CountMapIterator<>(a);
    }
}