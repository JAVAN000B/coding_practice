
import	java.util.LinkedList;
import	java.util.Queue;
import	java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname MyArrayQueue
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class MyArrayQueue<T> {
    private LinkedList<T> myQueue = new LinkedList<T>();
    private int size = 0;

    public void put(T data){
        myQueue.addLast(data);
        size++;
    }

    public T pop(){
        size--;
        return myQueue.remove(0);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return size;
    }

}
