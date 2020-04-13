/**
 * @Classname MyLinkQueue
 * @Description Java 没有指针反而变坑爹了！！！
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class MyLinkQueue<E> {
    class Node<E>{
        E data;
        Node<E> next = null;
        public Node(E data){
            this.data = data;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void put(E data){
        Node<E> newNode = new Node<E> (data);
        if (isEmpty()) {
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    public E pop() {
        if(isEmpty()) return null;
        E data = head.data;
        head = head.next;
        return data;
    }

    public int size(){
        Node<E> tmp = head;
        int n = 0;
        while(tmp!= null){
            n++;
            tmp = tmp.next;
        }
        return n;
    }

    public static void main(String[] args) {
        MyLinkQueue<Integer> queue = new MyLinkQueue<Integer>();
        queue.put(1);
        queue.put(2);
        queue.put(3);
        queue.put(4);
        //queue.size();
        System.out.println(queue.size());
        queue.pop();
        System.out.println(queue.size());

    }
}
