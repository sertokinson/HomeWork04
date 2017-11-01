import java.util.Comparator;

class MyComparator<T> implements Comparator<T> {

    public int compare(T a, T b){
        return a.toString().compareTo(b.toString());
    }
}
