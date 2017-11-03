import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> i = new MyLinkedList<>();
      //  i.add(1);
    //    i.add(5, 3);
       // print(i);
    //    System.out.println(i.remove(6));

      //  print(i);
     /*   i.remove(1);
        print(i);*/
        List<Integer>list=new LinkedList<>();
        list.add(1);
        list.add(2);
      //  System.out.println(list.remove(0));
        i.addAll(list);
       // print(i);
        for (Integer integer:i) {
            System.out.print(integer+" ");
        }
    }

    public static void print(MyLinkedList<?> c) {
        for (int j = 0; j < c.size; j++)
            System.out.print(c.get(j) + " ");
        System.out.println();
    }
}
