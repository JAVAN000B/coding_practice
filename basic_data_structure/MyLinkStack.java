/**
 * @Classname MyLinkStack
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class MyLinkStack<E> {
    class Node<E> {
        E data;
        Node<E> next = null;
        public Node(E data){
                this.data = data;
        }
    }

    Node<E> head = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(E data){
        Node<E> newNode = new Node<E> (data);
        newNode.next = head;
        head = newNode;
    }

    public E pop() {
        if (isEmpty()) return null;
        E data = head.data;
        head = head.next;
        return data;
    }

    public E peek() {
        if (isEmpty()) return null;
        return head.data;
    }

    public void minPush(MyLinkStack stack){
        E headData = (E) stack.peek();
        if (isEmpty()) push(headData);
        if ((Integer)headData <= (Integer)peek())push(headData);
    }

    public static void main(String[] args) {
        MyLinkStack<Integer> stack = new MyLinkStack<Integer>();
        MyLinkStack<Integer> minmumStack = new MyLinkStack<Integer>();
        stack.push(1);
        minmumStack.minPush(stack);
        stack.push(2);
        minmumStack.minPush(stack);
        stack.push(3);
        minmumStack.minPush(stack);
        stack.push(4);
        System.out.println(minmumStack.peek());
        stack.pop();
//        System.out.println(stack.peek());
//        stack.pop();
//        System.out.println(stack.peek());

    }

}

