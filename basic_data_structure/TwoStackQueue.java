import java.util.Stack;

/**
 * @Classname TwoStackQueue
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class TwoStackQueue<T>{
    Stack<T> input = new Stack<T> ();
    Stack<T> output = new Stack<T> ();

    public void put (T data){
        input.push(data);
    }

    public T pop() {
        if (output.isEmpty()){
            while (!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }



}
