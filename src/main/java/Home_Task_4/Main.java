package Home_Task_4;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(4);
        tree.add(7);
        tree.add(0);
        tree.add(8);
        tree.add(32);
        tree.add(24);
        tree.add(5);
        tree.add(1);

        System.out.println("4 - " + tree.contains(4));
        System.out.println("7 - " + tree.contains(7));
        System.out.println("0 - " + tree.contains(0));
        System.out.println("8 - " + tree.contains(8));
        System.out.println("32 - " + tree.contains(32));
        System.out.println("24 - " + tree.contains(24));
        System.out.println("5 - " + tree.contains(5));
        System.out.println("1 - " + tree.contains(1));

        tree.printTree();
    }
}
