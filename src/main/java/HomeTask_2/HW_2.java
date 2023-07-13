package HomeTask_2;

import java.util.Arrays;
import java.util.Random;

public class HW_2 {
    public static void main(String[] args) {
        int[] arr = RandomArray(4);
        PrintArray(arr);
        System.out.println();
        PrintArray(sort(arr));


    }

    public static int [] sort(int array[]){
        for (int i = array.length/2 - 1; i >=0; i--){
            Heapify(array, array.length, i);
        }
        for (int i = array.length-1; i >= 0; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            Heapify(array, i, 0);
        }
        return array;
    }

    public static void Heapify(int array[], int heapSize, int rootIndex){
        int largest = rootIndex;
        int leftChild = 2*rootIndex + 1;
        int rightChild = 2*rootIndex +2;
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
        if (rightChild < heapSize && array[rightChild] > array[largest]){
            largest = rightChild;
        }
        if (largest != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            Heapify(array, heapSize, largest);
        }

    }

    public static void PrintArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public  static int[] RandomArray(int size){
        int [] array = new int [size];
        for (int i = 0; i < size; i++){
            int random = new Random().nextInt(0, 11);
            array[i] = random;
        }
        return array;
    }
}





