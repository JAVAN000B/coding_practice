import java.util.Stack;

/**
 * @Classname minStack
 * @Description TODO
 * @Author Minghui Sun,
 */
public class minStack {
    minStack(){}
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer> ();

    public void minAdd(int data){
        stack1.add(data);
        if (stack2.isEmpty())
            stack2.add(data);
        else
            if (stack2.peek()>data)
                stack2.add(data);
    }

    public int findMin(){
       return stack2.peek();
    }

    public int pop(){
        int pop = stack1.pop();
        if (stack2.peek()==pop) stack2.pop();
        return pop;
    }

}
