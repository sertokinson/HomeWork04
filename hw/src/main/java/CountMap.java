import java.util.Map;

public interface CountMap<E> {

    /**
     * Добавляет элемент в этот контейнер
     * @param o
     */
    void add(E o);

    /**
     * @param o
     * @return количество элементов данного элемента
     */
    int getCount(E o);

    /**
     * Удаляет элемент из контейнера
     * @param o
     * @return Количество добавлений элемента до удаления
     */
    int remove(E o);

    /**
     * @return количество различных элементов
     */
    int size();

    /**
     * Добавляет все элементы из source в текущий контейнер, при совпадении ключей, значения суммируются
     * @param source
     */
    void addAll(CountMap source);

    /**
     * Где ключ - добавленный элемент, значение - количество его добавлений
     * @return java.util.Map.
     */
    Map toMap();

    /**
     * Тот же самый контракт как и toMap(), только вся информация записывается в destination
     * @param destination
     */
    void toMap(Map<E, Integer> destination);

    /**
     * @param i
     * @return элемент по индексу i
     */
    E get(int i);

    /**
     * @return размер контейнера
     */
    int length();
}
