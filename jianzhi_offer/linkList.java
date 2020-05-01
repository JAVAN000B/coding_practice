import java.util.Stack;
/**
 * @Classname linkList
 * @Description TODO
 * @Author Minghui Sun
 * @Version 1.0
 */
public class linkList<T> {
    class Node<T> {
        T data;
        Node<T> next;
        Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }
    }

    Node<T> root = new Node<T> (null, null);
    public boolean isEmpty(){
        return root.next == null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public Node<T> getLast(Node<T> current) {
        while (current.next != null){
            current = current.next;
        }
        return current;
    }

    public Node<T> add(T data) {
        Node<T> right = getLast(root);
        Node<T> newNode = new Node<T> (data,null);
        right.next = newNode;
        return newNode;
    }

    public void reversePrint(Node<T> cur){
        if (cur.next != null){
            reversePrint(cur.next);
        }
        System.out.println(cur.data);
    }

    public void StackReversePrint(Node<T> root){
        Stack<T> stack = new Stack<T> ();
        Node<T> cur = root;
        while (cur.next != null) {
            cur = cur.next;
            stack.add(cur.data);
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        linkList<Integer> linkList = new linkList<Integer> ();
        linkList.add(1);
        linkList.add(2);
        linkList.add(3);
        linkList.add(4);
        linkList.reversePrint(linkList.root);
        linkList.StackReversePrint(linkList.root);
    }
}
