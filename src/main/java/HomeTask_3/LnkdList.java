package HomeTask_3;

//Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).

public class LnkdList {
    private Node root;
    private int size;
    public void reverseList(){
        Node cur = root;
        Node tailNode = null;
        Node tmp;

        while (cur != null) {
//          временая переменная для дальнейшего переключениия счетчиика
            tmp = cur.next;

//          смена сестами значений в циикле
            cur.next = tailNode; // Меняем следующее значение в спискее на null;
            tailNode = cur; // в хвост ставим текущее значение
            root = cur;

            cur = tmp;
           }
    }
    private class Node{
        int value;
        Node next;
        Node(int _value){
            this.value = _value;
        }
        Node (int _value, Node _next){
            this.value = _value;
            this.next = _next;
        }
    }
    public void printLnkList(){
        Node currentNode = this.root;
        while (currentNode != null){
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public void add(int value){
        if (this.root == null){
            this.root = new Node(value);
            this.size = 1;
        }else {
            Node currentNode = this.root;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = new Node(value);
            this.size++;
        }
    }
    public int getSize(){
        return this.size;
    }
}
