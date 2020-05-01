import java.util.Queue;

import	java.util.Deque;
import	java.util.LinkedList;
/**
 * @Classname queueMax
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class queueMax {
    Queue<Integer> queue = new LinkedList();
    Deque<Integer> maxQueue = new LinkedList<> ();

    public int max(){
        if (maxQueue.isEmpty()) return -1;
        return maxQueue.getFirst();
    }

    public void push_back(int data){
        queue.add(data);
        if (maxQueue.isEmpty())
            maxQueue.addFirst(data);
        else{
            while (!maxQueue.isEmpty()){
                if (maxQueue.getLast()<=data) {
                    maxQueue.removeLast();
                }else break;
            }
            maxQueue.addLast(data);
        }
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int num = queue.poll();
        if (num ==maxQueue.getFirst()) maxQueue.removeFirst();
        return num;

    }

}
