import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data=data;
        next=null;
        prev=null;
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
        if(head==null || head.next==null ||k==0){
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
    for(int i=1;i<k;i++){
        temp=temp.next;
    }
    Node newhead=temp.next;
    temp.next=null;
    newhead.prev=null;
    tail.next=head;
    head.prev=tail;
    head=newhead;
    }

void display(){
    Node temp=head;
    while(temp!=null){
        System.out.print(temp.data+" ");
        temp=temp.next;
    }
}
}
public class left{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Linkedlist list=new Linkedlist();
        while(true){
            int val=sc.nextInt();
            if(val==-1)
            break;
            list.insert(val);
        }
        int k=sc.nextInt();
        list.rotate(k);
        list.display();
    }
}
