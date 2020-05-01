import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Classname StackQueue
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class StackQueue {
    Stack<Integer> stackIn = new Stack<Integer> ();
    Stack<Integer> stackOut = new Stack<Integer> ();
    Queue<Integer> queueIn = new LinkedList<>();
    Queue<Integer> queueOut = new LinkedList<> ();
    int exchangeSize = 5;
    public StackQueue(){

    }

    public void queueAdd(int num){
        stackIn.push(num);
    }

    public int queuePoll(){
        if (stackOut.isEmpty()){
            for (int i = 0; i < exchangeSize; i++) {
                if (stackIn.isEmpty()) break;
                int tmp = stackIn.pop();
                stackOut.push(tmp);
            }
        }
        return stackOut.pop();
    }

    public void stackAdd(int num){
        queueIn.add(num);
    }

    public int stackPop(){
        int target = 0;
        while (!queueIn.isEmpty()){
            int tmp = queueIn.poll();
            if (!queueIn.isEmpty()){
                queueOut.add(tmp);
            }else{
                target = tmp;
            }

        }
        return target;
    }

    public static void main(String[] args) {
        StackQueue structure = new StackQueue();
        structure.queueAdd(100);
        structure.queueAdd(2);
        System.out.println(structure.queuePoll());
        structure.stackAdd(1);
        structure.stackAdd(2);
        System.out.println(structure.stackPop());
    }

}
