import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class MyLinkedListTest {
    private MyLinkedList<Integer> integerList = new MyLinkedList<>();
    private Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6};
    private MyLinkedList<String> stringList = new MyLinkedList<>();
    private String[] strings = new String[]{"1", "2", "3", "4", "5", "6"};
    private int element;

    private void fillIntegers(MyLinkedList<Integer> integerList) {
        integerList.add(1);
        integerList.add(2);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(2, 3);
    }

    private void fillStrings(MyLinkedList<String> stringList) {
        stringList.add("1");
        stringList.add("2");
        stringList.add("4");
        stringList.add("5");
        stringList.add("6");
        stringList.add(2, "3");
    }

    @Test
    public void add() throws Exception {
        fillIntegers(integerList);
        int index = 0;
        for (Integer integer : integerList)
            Assert.assertEquals(integer, integers[index++]);
        fillStrings(stringList);
        index = 0;
        for (String string : stringList) {
            Assert.assertEquals(string, strings[index++]);
        }
    }

    @Test
    public void get() throws Exception {
        fillIntegers(integerList);
        element = integerList.get(2);
        Assert.assertEquals(element, 3);
        fillStrings(stringList);
        Assert.assertEquals(stringList.get(2), "3");
    }

    @Test
    public void remove() throws Exception {
        fillIntegers(integerList);
        integerList.remove(3);
        Assert.assertEquals(integerList.size, 5);
        fillStrings(stringList);
        stringList.remove(3);
        Assert.assertEquals(stringList.size, 5);

    }

    @Test
    public void iterator() throws Exception {
        fillIntegers(integerList);
        Iterator it = integerList.iterator();
        element = (int) it.next();
        Assert.assertEquals(element, 1);
        fillStrings(stringList);
        it = stringList.iterator();
        Assert.assertEquals(it.next(), "1");

    }

    @Test
    public void addAll() throws Exception {
        List<Integer> listInteger = new LinkedList<>();
        listInteger.add(1);
        listInteger.add(2);
        integerList.addAll(listInteger);
        Assert.assertEquals(integerList.get(0), listInteger.get(0));
        List<String> listString = new LinkedList<>();
        listString.add("1");
        stringList.addAll(listString);
        Assert.assertEquals(listString.get(0), stringList.get(0));
    }

}