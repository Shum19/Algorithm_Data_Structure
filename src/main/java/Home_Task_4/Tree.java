package Home_Task_4;
/*  1. Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево.
       И реализовать в нем метод добавления новых элементов с балансировкой.

    2. Красно-черное дерево имеет следующие критерии:
        ● Каждая нода имеет цвет (красный или черный)
        ● Корень дерева всегда черный
        ● Новая нода всегда красная
        ● Красные ноды могут быть только левым ребенком
        ● У красной ноды все дети черного цвета

    3. Соответственно, чтобы данные условия выполнялись, после
       добавления элемента в дерево необходимо произвести балансировку, благодаря которой все критерии
       выше станут валидными.
    4. Для балансировки существует 3 операции – левый малый поворот, правый малый поворот и смена цвета.

*/

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class Tree {
    Node root;
    public boolean add(int value){
        if(root != null){
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        }else {
            root = new Node(value);
            root.color = Color.BLACK;
            return true;
        }
    }
    public void printTree(){
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0){
            List <Node> nextLine = new ArrayList<>();
            for (Node node : line) {
                if (node != null) {
                    System.out.print(node.toString() + " ");
                    nextLine.add(node.leftChild);
                    nextLine.add(node.rightChild);
                }
            }
            System.out.println();
            line = nextLine;
        }
    }
    private boolean addNode(Node node, int value){
        if (node.value == value) {
            return false;
        } else{
            if (node.value > value){
                if (node.leftChild != null){
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                }else {
                    node.leftChild = new Node(value);
                    return true;
                }
            }else {
                if (node.rightChild != null){
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                }else {
                    node.rightChild = new Node(value);
                    return true;
                }
            }

        }

    }

    private Node rebalance(Node node){
        Node result = node;
        boolean needReBalance;
        do {
            needReBalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)){
                needReBalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED){
                needReBalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                result.rightChild != null && result.rightChild.color == Color.RED){
                needReBalance = true;
                colorSwap(result);
            }

        }
        while (needReBalance);
        return result;
    }
    private Node leftSwap(Node node){
        Node leftChild = node.leftChild;
        Node btwnChild = node.rightChild;
        leftChild.rightChild = node;
        node.leftChild = btwnChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;

    }
    private Node rightSwap(Node node){
        Node rightChild = node.rightChild;
        Node btwnChild = node.leftChild;
        rightChild.leftChild = node;
        node.rightChild = btwnChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }
    private void colorSwap(Node node){
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }
    public boolean contains(int value){
        Node node = getNode(this.root, value);
        return node !=null;
    }
    private Node getNode(Node node, int value){
        if(node.value == value ){
            return node;
        }else {
            if (node.value > value) {
                if (node.leftChild != null) return getNode(node.leftChild, value);
                else return null;
            } else {
                if (node.rightChild != null) return getNode(node.rightChild, value);
                else return null;
            }
        }
    }


    private class Node{
        private int value;
        private Node rightChild;
        private Node leftChild;
        private Color color;
        Node(int _value){
            this.value = _value;
            this.color = Color.RED;
        }

        @Override
        public String toString() {
            return value  + "-" + color;
        }

    }
    enum Color{RED, BLACK}
}
