import java.util.*;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<? extends T> source, T o) {
       return source.indexOf(o);
    }

    public static <T> List limit(List<? extends T> source, int size) {
        List<T> s = new ArrayList<>();
        for (int i = 0; i < size; i++)
            s.add(source.get(i));
        return s;
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
       /* int count = 0;
        for (T element2 : c2) {
            for (T element1 : c1)
                if (element1 == element2) {
                    count++;
                    break;
                }
        }
        if (count == c2.size())
            return true;
        else return false;*/
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T element2 : c2) {
            if(c1.contains(element2))
                return true;
        }
        return false;
    }

    public static <T extends Comparable<T>> List range(List<? extends T> list, T min, T max) {
        List<T> list2 = new ArrayList<>();
        Collections.sort(list);
        for (T element : list) {
            if (element.compareTo(min) >= 0 && element.compareTo(max) <= 0)
                list2.add(element);
        }
        return list2;
    }

    public static <T extends Comparable<T>> List range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        List<T> list2 = new ArrayList<>();
        Collections.sort(list);
        for (T element : list) {
            if (comparator.compare(element, min) >= 0 && comparator.compare(element, max) <= 0)
                list2.add(element);
        }
        return list2;
    }


}

