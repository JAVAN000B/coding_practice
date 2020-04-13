import java.util.Arrays;

/**
 * @Classname MyArrayStack
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class MyArrayStack<E>  {

    private Object[] stack;
    private int size;

    public MyArrayStack(){
        stack = new Object[10];
    }

    public boolean isempty(){
        return size==-1;
    }

    public E peek(){
        if (isempty()){
            return null;
        }
        return (E) stack[size-1];
    }

    public E pop(){
        E value = peek();
        size--;
        stack[size] = null;
        return value;
    }

    public E push(E value){
        ensureCapacity(size+1);
        size++;
        stack[size-1] = value;
        return value;
    }

    private void ensureCapacity(int size){
        int len = stack.length;
        if (size > len){
            stack = Arrays.copyOf(stack,len+len);
        }
    }

    public static void main(String[] args) {
        MyArrayStack<Integer> stack = new MyArrayStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }



}
