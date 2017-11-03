import com.sbt.javaschool.hw.api.*;
import com.sbt.javaschool.hw.impl.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CountMapImlTest {
    private Integer[]integers=new Integer[]{1,2};
    private String[]strings=new String[]{"1","2"};
    private CountMap<Integer> countMapInteger;
    private CountMap<String>  countMapString;
    private Map<Integer,Integer> mapInteger=new HashMap<>();
    private Map<String,Integer> mapString=new HashMap<>();
    private int index;

    private void fillInteger(){
        index=0;
        countMapInteger = new CountMapIml<>();
        countMapInteger.add(1);
        countMapInteger.add(2);
        countMapInteger.add(2);
    }
    private void fillString(){
        index=0;
        countMapString = new CountMapIml<>();
        String string = new String("2");
        countMapString.add("1");
        countMapString.add("2");
        countMapString.add(string);
    }
    @Test
    public void toMap() throws Exception {
        fillInteger();
        for (Object i:countMapInteger.toMap().keySet()) {
            Assert.assertEquals(i,integers[index++]);
        }
        countMapInteger.toMap(mapInteger);
        Assert.assertEquals(mapInteger,countMapInteger.toMap());
        fillString();
        for (Object i:countMapString.toMap().keySet()) {
            Assert.assertEquals(i,strings[index++]);
        }
        countMapString.toMap(mapString);
        Assert.assertEquals(mapString,countMapString.toMap());
    }

    @Test
    public void size() throws Exception {
        fillInteger();
        Assert.assertEquals( countMapInteger.size(),2);
        fillString();
        Assert.assertEquals(countMapString.size(),2);
    }

    @Test
    public void remove() throws Exception {
        fillInteger();
        Assert.assertEquals(countMapInteger.remove(2),2);
        for (Integer i:countMapInteger) {
            Assert.assertEquals(integers[index++],i);
        }
        fillString();
        Assert.assertEquals(countMapString.remove("2"),2);
        index=0;
        for (String s:countMapString) {
            Assert.assertEquals(strings[index++],s);
        }
    }

    @Test
    public void getCount() throws Exception {
        fillInteger();
        Assert.assertEquals(2,countMapInteger.getCount(2));
        fillString();
        Assert.assertEquals(2,countMapString.getCount("2"));
    }


}