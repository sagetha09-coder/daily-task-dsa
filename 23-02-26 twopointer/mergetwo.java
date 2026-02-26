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
    void display(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    Node merge(Node head1,Node head2){
        Node dummy=new Node(0);
        Node tail=dummy;
        while(head1!=null  && head2!=null){
        if(head1.data<=head2.data){
            tail.next=head1;
            head1=head1.next;
        }else{
            tail.next=head2;
            head2=head2.next;
        }
        tail=tail.next;
    }
    if(head1!=null){
        tail.next=head1;
    }else{
        tail.next=head2;
    }
    return dummy.next;
}
}
public class mergetwo{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Linkedlist list1=new Linkedlist();
        Linkedlist list2=new Linkedlist();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            list1.insert(sc.nextInt());
        }
        for(int i=0;i<n;i++){
            list2.insert(sc.nextInt());
        }
        Node mergeHead=list1.merge(list1.head,list2.head);
        list1.display(mergeHead);
    }
}