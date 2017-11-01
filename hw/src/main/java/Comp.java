class Comp<T> implements Comparable<T> {
    T min;
    T max;

    Comp( T min,T max) {
        this.min=min;
        this.max=max;
    }

    @Override
    public int compareTo(T obj) {
        Comp entry = (Comp) obj;
        return 0;
    }

}