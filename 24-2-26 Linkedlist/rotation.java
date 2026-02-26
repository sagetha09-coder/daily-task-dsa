import java.util.*;
class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
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
        newNode.prev=temp;
    }
    void rotate(int k){
        if(head==null || head.next==null||k==0){
            return;
        }
        Node temp=head;
        int len=1;
        while(temp.next!=null){
            temp=temp.next;
            len++;
        }
        Node tail=temp;
        k=k%len;
        if(k==0)
            return;
        temp=head;
        for(int i=0;i<len-k-1;i++){
            temp=temp.next;
        }
        Node newHead=temp.next;
        temp.next=null;
        newHead.prev=null;
        tail.next=head;
        head.prev=tail;
        head=newHead;
        
    }
    void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}
public class rotation{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        while(n>0){
            Linkedlist l=new Linkedlist();
            int t=sc.nextInt();
            int r=sc.nextInt();
        
        for(int i=0;i<t;i++){
            l.insert(sc.nextInt());
        }
        l.rotate(r);
        l.display();
        System.out.println();
        n--;
        }
    }
}