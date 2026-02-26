import java.util.Scanner;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class SinglyLinkedList {
    Node head;
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    boolean isPalindrome() {
        if (head == null || head.next == null)
            return true;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null;
        Node curr = slow;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } 
        Node first = head;
        Node second = prev;  
        while (second != null) {
            if (first.data != second.data)
                return false;

            first = first.next;
            second = second.next;
        }
        return true;
    }
}
public class PalindromeSLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SinglyLinkedList list = new SinglyLinkedList();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            list.insert(sc.nextInt());
        }

        if (list.isPalindrome())
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

        
    }
}
