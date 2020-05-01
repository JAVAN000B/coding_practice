
import	java.util.ArrayList;/**
 * @Classname BinaryTreeSymmetrial
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class BinaryTreeSymmetrial {
    static class treeNode{
        int data;
        treeNode left;
        treeNode right;
        treeNode(int data){
            this.data = data;
        }
    }
    BinaryTreeSymmetrial(){}

    public boolean ifSymmetrial(treeNode root) {
        if (root == null) return false;
        return ifnodesSymmetrial(root.left, root.right);
    }

    public boolean ifnodesSymmetrial(treeNode node1, treeNode node2){
        if (node1 == null && node2 == null) return true;
        if (node2 == null) return false;
        if (node1 == null) return false;
        if (node1.data ==node2.data) return ifnodesSymmetrial(node1.left,node2.right)&& ifnodesSymmetrial(node1.right, node2.left);
        return false;
    }

    public boolean checkSymmetrial(treeNode root){
        ArrayList<Integer> list =new ArrayList<Integer> ();
        midTraverse(root,list);
        int j =list.size();
        if (j<=1) return false;
        int i = 0;
        j--;
        while (j>i) {
            if (list.get(i) != list.get(j)) return false;
            j--;
            i++;
        }
        return true;
    }

    public void midTraverse(treeNode root, ArrayList<Integer> list){
        if (root == null) return;
        if (root.left!=null) midTraverse(root.left,list);
        list.add(root.data);
        if (root.right != null) midTraverse(root.right,list);
    }

    public static void main(String[] args) {
        BinaryTreeSymmetrial machine = new BinaryTreeSymmetrial();
        treeNode root = new treeNode(8);
        treeNode left = new treeNode(6);
        treeNode right = new treeNode(6);
        treeNode left1 = new treeNode(5);
        treeNode right1 = new treeNode(7);
        treeNode left2 = new treeNode(7);
        treeNode right2 = new treeNode(5);
        root.left =left;
        root.right = right;
        left.left = left1;
        left.right = right1;
        right.left = left2;
        right.right = right2;

        //boolean test = machine.ifSymmetrial(root);
        boolean test2 = machine.checkSymmetrial(root);
        System.out.println(test2);
    }

}
