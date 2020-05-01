import java.util.Stack;

/**
 * @Classname nValueBTPath
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class nValueBTPath {
    static class treeNode<Integer>{
        int data;
        treeNode<Integer> left;
        treeNode<Integer> right;

        public treeNode(int data){
            this.data = data;
        }
    }

    public void findAllPath(treeNode root, int nValue, Stack<Integer> stack, int curValue){
        if (root.left == null&& root.right == null){
            stack.push(root.data);
            if (curValue+root.data == nValue){
                Stack<Integer> tmp = new Stack<Integer>();
                while (!stack.isEmpty()) {
                    int value = stack.pop();
                    System.out.println(value);
                    tmp.push(value);
                }
                while (!tmp.isEmpty()){
                    stack.push(tmp.pop());
                }
            }
        }else{
            if (curValue+root.data<nValue){
                stack.push(root.data);
                if (root.left!=null){
                    findAllPath(root.left,nValue,stack,curValue+root.data);
                    stack.pop();
                }
                if (root.right != null){
                    findAllPath(root.right,nValue,stack,curValue+root.data);
                    stack.pop();
                }
            }

        }

    }

    public static void main(String[] args) {
        treeNode[] list = new treeNode[10];
        for (int i = 0; i < 10; i++) {
            list[i] = new treeNode(i);
        }
        for (int j = 0; j < 10; ++j) {
            if (2*j+1<10) list[j].left = list[2*j+1];
            if (2*j+2<10) list[j].right = list[2*j+2];
        }
        list[4].right = new treeNode(7);
        nValueBTPath machine = new nValueBTPath();
        Stack<Integer> stack = new Stack<> ();
        machine.findAllPath(list[0],12,stack,0);

    }

}
