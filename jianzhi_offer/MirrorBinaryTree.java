import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname MirrorBinaryTree
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class MirrorBinaryTree {
    static class treeNode{
        int data;
        treeNode left;
        treeNode right;
        treeNode(int data){
            this.data = data;
        }
    }

    public void Mirroring(treeNode root){
        if (root == null) return;
        treeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirroring(root.left);
        Mirroring(root.right);
    }

    public void LoopMirroring(treeNode root){
        if (root == null) return;
        Queue<treeNode > queue = new LinkedList<treeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            treeNode parent = queue.poll();
            if (parent.left != null) {
                queue.add(parent.left);
            }
            if (parent.right != null){
                queue.add(parent.right);
            }
            treeNode tmp = parent.left;
            parent.left = parent.right;
            parent.right = tmp;
        }

    }

    public static void main(String[] args) {
        treeNode[] node = new treeNode[10];//以数组形式生成一棵完全二叉树
        for(int i = 0; i < 10; i++)
        {
            node[i] = new treeNode(i);
        }
        for(int i = 0; i < 10; i++)
        {
            if(i*2+1 < 10)
                node[i].left = node[i*2+1];
            if(i*2+2 < 10)
                node[i].right = node[i*2+2];
        }
        MirrorBinaryTree machine = new MirrorBinaryTree();
        machine.Mirroring(node[0]);
        machine.LoopMirroring(node[0]);
        System.out.println("finish!!!");
    }

}
