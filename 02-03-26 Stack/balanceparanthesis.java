import java.util.*;
class Node {
    char data;
    Node next;
    Node(char data) {
        this.data = data;
        this.next = null;
    }
}
class Stack {
    Node top;
    Stack() {
        top = null;
    }
    void push(char ch) {
        Node newNode = new Node(ch);
        newNode.next = top;
        top = newNode;
    }
    char pop() {
        if (top == null)
            return '#';
        char val = top.data;
        top = top.next;
        return val;
    }
    boolean isEmpty() {
        return top == null;
    }
}
public class balanceparanthesis{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack stack = new Stack();   
        boolean balance = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    balance = false;
                    break;
                }
                char pop = stack.pop();
                if ((ch == ')' && pop != '(') ||
                    (ch == '}' && pop != '{') ||
                    (ch == ']' && pop != '[')) {
                    balance = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty())
            balance = false;

        if (balance)
            System.out.print("Balanced");
        else
            System.out.print("Not Balanced");
    }
}