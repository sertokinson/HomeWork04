public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> i = new MyLinkedList<>();
        i.add(2);
        print(i);
        i.add(3);
        print(i);
        i.remove(1);
        print(i);
    }

    public static void print(MyLinkedList<?> c) {
        for (int j = 0; j < c.size; j++)
            System.out.print(c.get(j)+" ");
        System.out.println(";");
    }
}
