import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class CountMapImlTest {
    CountMap<Integer> countMapInteger;
    CountMap<String> countMapString;
    @Test
    public void getCount() throws Exception {
        countMapInteger = new CountMapIml<>();
        countMapInteger.add(1);
        countMapInteger.add(2);
        countMapInteger.add(2);
        Assert.assertEquals(2,countMapInteger.getCount(2));
        countMapString = new CountMapIml<>();
        String string = new String("2");
        countMapString.add("1");
        countMapString.add("2");
        countMapString.add(string);
        Assert.assertEquals(2,countMapString.getCount(string));
    }

    @Test
    public void add() throws Exception {
        countMapInteger = new CountMapIml<>();
        countMapInteger.add(1);
        countMapInteger.add(2);
        Integer[]integers=new Integer[]{1,2};
        int index=0;
        for (Integer i:countMapInteger) {
            Assert.assertEquals(integers[index++],i);
        }
        index=0;
        countMapString = new CountMapIml<>();
        countMapString.add("1");
        countMapString.add("2");
        String[]strings=new String[]{"1","2"};
        for (String s:countMapString) {
            Assert.assertEquals(strings[index++],s);
        }
    }

}