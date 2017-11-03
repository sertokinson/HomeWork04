import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CollectionUtilsTest {

    private List<Integer>integerList=new ArrayList<>();
    private List<String> stringList = new ArrayList<>();
    private List<Integer> integerList2;
    private List<String> stringList2;
    private void fillStringList(){
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
    }
    private void fillIntegerList(){
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
    }

    @Test
    public void range() throws Exception {
        System.out.println(CollectionUtils.range(Arrays.asList(8,1,3,5,6, 4), 3, 6));
        System.out.println(CollectionUtils.range(Arrays.asList("8","1","3","5","6", "4"), "3", "6"));
        System.out.println(CollectionUtils.range(Arrays.asList(8,1,3,5,6, 4), 3, 6,new MyComparator<Integer>()));
    }

    @Test
    public void containsAll() throws Exception {
        newArrayList();
        fillIntegerList();
        Assert.assertTrue(CollectionUtils.containsAll(integerList,integerList2));
        fillStringList();
        Assert.assertTrue(CollectionUtils.containsAll(stringList,stringList2));


    }

    @Test
    public void removeAll() throws Exception {
        newArrayList();
        fillIntegerList();
        CollectionUtils.removeAll(integerList,integerList2);
        fillStringList();
        CollectionUtils.removeAll(stringList,stringList2);
        Assert.assertEquals(integerList.size(),2);
        Assert.assertEquals(stringList.size(),2);
    }
    
    @Test
    public void add() throws Exception {
        CollectionUtils.add(integerList,1);
        Assert.assertEquals(integerList.size(),1);
        CollectionUtils.add(stringList,"1");
        Assert.assertEquals(stringList.size(),1);
    }

    @Test
    public void limit() throws Exception {
        fillIntegerList();
        Assert.assertEquals(CollectionUtils.limit(integerList,2).size(),2);
        fillStringList();
        Assert.assertEquals(CollectionUtils.limit(stringList,2).size(),2);
    }


    @Test
    public void indexOf() throws Exception {
        fillStringList();
        Assert.assertEquals(CollectionUtils.indexOf(stringList,"2"),1);
        fillIntegerList();
        Assert.assertEquals(CollectionUtils.indexOf(integerList,2),1);
    }

    @Test
    public void newArrayList() throws Exception {
        integerList2=CollectionUtils.<Integer>newArrayList();
        integerList2.add(1);
        int i=integerList2.get(0);
        Assert.assertEquals(i,1);
        stringList2=CollectionUtils.<String>newArrayList();
        stringList2.add("1");
        Assert.assertEquals(stringList2.get(0),"1");
    }

    @Test
    public void addAll() throws Exception {
        Integer []array=new Integer[]{1,2,3,2,4};
        String []strings=new String[]{"1","2","3","2","4"};
        fillIntegerList();
        integerList2=new ArrayList<>();
        integerList2.add(2);
        integerList2.add(4);
        CollectionUtils.addAll(integerList2,integerList);
        int index=0;
        for (Integer i:integerList){
            Assert.assertEquals(i,array[index++]);
        }
        fillStringList();
        stringList2=new ArrayList<>();
        stringList2.add("2");
        stringList2.add("4");
        index=0;
        CollectionUtils.addAll(stringList2,stringList);
        for (String s:stringList) {
            Assert.assertEquals(s,strings[index++]);
        }
    }

}