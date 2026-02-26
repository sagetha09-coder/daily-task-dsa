
import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class Linkedlist{
    Node head;
    Linkedlist(){
        head=null;
    }
    void insert(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    int endNode(int k){
        Node slow=head;
        Node fast=head;
        for(int i=0;i<k;i++){
        if(fast==null){
            return-1;
        }
        fast=fast.next;
    }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
    return slow.data;
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Linkedlist list=new Linkedlist();
        while (true) { 
            int val=sc.nextInt();
            if(val==-1)
                break;
            list.insert(val);
        }
        int k=sc.nextInt();
        int result=list.endNode( k);
        if(result==-1)
            System.out.println("Invalid position ");
        else
            System.out.print(result);
    }
}