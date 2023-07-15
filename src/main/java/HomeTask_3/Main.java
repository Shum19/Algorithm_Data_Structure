package HomeTask_3;

public class Main {
    public static void main(String[] args) {
        LnkdList list = new LnkdList();
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(32);
        list.add(56);
        list.add(-6);
        list.add(90);

        list.printLnkList();
        list.reverseList();
        list.printLnkList();
        System.out.println(list.getSize());


    }
}
