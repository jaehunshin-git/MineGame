import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class VectorPrac {
    static class MyLinkedList {
        int data = 0;
        MyLinkedList next;
        MyLinkedList head;

        MyLinkedList(int data) {
            this.data = data;
            this.next = null;
            this.head = null;
        }

        MyLinkedList() {
            this.next = null;
            this.head = null;
        }

        void addFirst(int data) {
            MyLinkedList temp = new MyLinkedList(data);
            MyLinkedList current = this.head;

            if (this.head == null) {
                this.head = temp;
            }
            else {
                temp.next = current;
                this.head = temp;
            }
        }

        void addLast(int data) {
            MyLinkedList temp = new MyLinkedList(data);
            MyLinkedList current = this.head;
            if (this.head == null) {
                this.head = temp;
            }
            else {
                while(current.next != null) {
                    current = current.next;
                }
                current.next = temp;
            }
        }
        void removeFirst() {

        }

        void removeLast() {

        }

        void getFirst() {

        }

        void getLast() {

        }

        void printList() {
            MyLinkedList current = this.head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /*ArrayList<String> arr1 = new ArrayList<String>();

        arr1.add("ccc");
        arr1.add("ddd");
        arr1.add("aaa");

        System.out.println(arr1.get(1));

        arr1.add("ddd");
        System.out.println(arr1.get(1));

        arr1.remove(1);
        System.out.println(arr1.get(1));

        System.out.println(arr1.size());

        Collections.sort(arr1);

        for (String s : arr1) {
            System.out.println(s);
        }*/
        MyLinkedList my = new MyLinkedList();
        my.addLast(1);
        my.addLast(2);
        my.addLast(3);
        my.printList();


    }
}
