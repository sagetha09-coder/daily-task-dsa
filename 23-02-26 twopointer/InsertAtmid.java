import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;   
    }
}
class LinkedList {
    Node head;
    LinkedList() {
        head = null;
    }
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
    void Mid(int data) {
        Node newNode=new Node(data);
        if (head == null) {  
            return;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;          
            fast = fast.next.next;     
        }
        newNode.next=slow.next;
        slow.next=newNode;
    }
void display(){
    if(head==null){
        return;
    }
    Node temp=head;
    while(temp!=null){
        System.out.print(temp.data+" ");
        temp=temp.next;
    }
}
}

public class InsertAtmid{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        LinkedList list = new LinkedList();

        for (int i = 0; i < n; i++) {
            list.insert(sc.nextInt());
        }
        int val=sc.nextInt();
        list.Mid(val);
        list.display();
    }
}
