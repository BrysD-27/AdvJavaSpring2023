// Bryson Davis
// CS-2463-TW01S
// 4-30-2023

import java.util.Random;
import java.util.Scanner;


public class LinkedList {
    public Node head = null;
    public Node tail = null;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    public void displayLL() {
        long startTime=System.currentTimeMillis();
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        long endTime=System.currentTimeMillis()-startTime;
        System.out.println("\n" + "Time: "+endTime+" ms");
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

  

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Random rnd = new Random();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        
        int nodes = input.nextInt();
        for(int i=0;i<nodes;i++) {
            list.insert(rnd.nextInt(100));
        }
        list.displayLL();
        System.out.println("Number of node(s): "+nodes);
    }
}