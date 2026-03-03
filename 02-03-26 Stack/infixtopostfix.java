import java.util.*;
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
    void push(char data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
    char pop() {
        if (top == null) return '\0';
        char val = top.data;
        top = top.next;
        return val;
    }
    char peek() {
        if (top == null) return '\0';
        return top.data;
    }
    boolean isEmpty() {
        return top == null;
    }
}
public class infixtopostfix {
    static int priority(char c) {
        if (c == '^') return 3;
        if (c == '*' || c == '/') return 2;
        if (c == '+' || c == '-') return 1;
        return -1;
    }
   
    static String convert(String infix) {
        StackLL stack = new StackLL();
        String postfix = "";
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            if ((ch >= 'a' && ch <= 'z') ||
                (ch >= 'A' && ch <= 'Z') ||
               (ch >= '0' && ch <= '9')) {
                postfix += ch;
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }
                stack.pop(); 
            }
            else {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(ch)) {
                    postfix += stack.pop();
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        return postfix;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infix = sc.nextLine();
        System.out.println( convert(infix));
    }
}
