
import	java.util.LinkedList;
import	java.util.Queue;/**
 * @Classname PrintBinaryTree
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class PrintBinaryTree {
    static class  treeNode{
        int data;
        treeNode left;
        treeNode right;
        treeNode(int data){
            this.data = data;
        }
    }
    public void printByLevel(treeNode root){
        Queue<treeNode> Queue = new LinkedList<treeNode> ();
        Queue.add(root);
        while (!Queue.isEmpty()){
            treeNode current = Queue.poll();
            System.out.print(current.data+"->");
            if (current.left != null) {
                Queue.add(current.left);
            }
            if (current.right != null){
                Queue.add(current.right);
            }
        }
    }

    public void printByLevelModified(treeNode root){
        Queue<treeNode> Queue = new LinkedList<treeNode> ();
        Queue.add(root);
        int level = 0;
        int rest = 1;
        while (!Queue.isEmpty()){
            treeNode current = Queue.poll();
            System.out.print(current.data+"->");
            if (current.left != null) {
                Queue.add(current.left);
                level++;
            }
            if (current.right != null){
                Queue.add(current.right);
                level++;
            }
            rest--;
            if (rest<1){
                System.out.println();
                rest = level;
                level = 0;
            }
        }
    }

    public void printByLevelModifiedV2(treeNode root){
        Queue<treeNode> Queue = new LinkedList<treeNode> ();
        Queue.add(root);
        int level = 0;
        int levelInclude = 0;
        int rest = 1;
        StringBuilder oneline = new StringBuilder();
        while (!Queue.isEmpty()){
            treeNode current = Queue.poll();
            Integer data = current.data;
            if ((level&0x1)== 0){
                oneline.append(data.toString());
                oneline.append("->");
            }else {
                oneline.insert(0,"->");
                oneline.insert(0,data.toString());
            }
            if (current.left != null) {
                Queue.add(current.left);
                levelInclude++;
            }
            if (current.right != null){
                Queue.add(current.right);
                levelInclude++;
            }
            rest--;
            if (rest<1){
                System.out.println(oneline);
                rest = levelInclude;
                levelInclude = 0;
                level++;
                oneline = new StringBuilder();
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
        PrintBinaryTree machine = new PrintBinaryTree();
        machine.printByLevelModifiedV2(list[0]);
    }

}
