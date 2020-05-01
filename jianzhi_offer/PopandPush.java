import java.util.Stack;

/**
 * @Classname PopandPush
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class PopandPush {
    public boolean isPopOrder(int[] push, int[] pop) {
        Stack<Integer> stack = new Stack<Integer> ();
        if (push == null|| push.length ==0) return false;
        if (pop ==null || pop.length ==0) return true;
        int pushStart = 0;
        for (int i = 0; i < pop.length; ++i) {
            while (pushStart< push.length){
                stack.push(push[pushStart]);
                pushStart++;
                if (push[pushStart-1]==pop[i]){
                   break;
                }
            }
            int actualpop = stack.pop();
            if (actualpop!=pop[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PopandPush machine = new PopandPush();
        boolean test = machine.isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 1, 2});
        System.out.println(test);
    }

}
