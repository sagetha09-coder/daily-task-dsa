import java.util.Scanner;
class Node {
    char data;
    Node next;
    Node(char data) {
        this.data = data;
        this.next = null;
    }
}
class StackLL {
    Node top;  
    StackLL() {
        top = null;
    }
    void push(char ch ) {
        Node newNode = new Node(ch);
        newNode.next = top;
        top = newNode;
    }
    char pop(){
        if(top==null){
           return'\0';
        }
        char ch = top.data;
        top=top.next;
        return ch;
    }
    boolean isEmpty(){
        return top==null;
    }
}
public class revstring{
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    StackLL stack=new StackLL();
    String str=sc.nextLine();
    for(int i=0;i<str.length();i++){
        stack.push(str.charAt(i));
    }
    String rev="";
    while(!stack.isEmpty()){
        rev+=stack.pop();
    }
    System.out.print(rev);
}
}