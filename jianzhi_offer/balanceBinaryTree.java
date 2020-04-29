/**
 * @Classname balanceBinaryTree
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class balanceBinaryTree {
    private static boolean flag;

    static class treeNode{
        int data;
        treeNode left;
        treeNode right;

        public treeNode(int data) {
            this.data = data;
        }
    }

    public int findDepth(treeNode root) {
        if (root == null) return 0;
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        return left>right ? left+1 : right+1;
    }

    public Boolean ifBalance(treeNode root){
        if (root!=null){
            int left = findDepth(root.left);
            int right = findDepth(root.right);
            if (left != right) return false;
        }else {
            return true;
        }
        return ifBalance(root.left)&&ifBalance(root.right);
    }


    public int ifBalancePostTraverse(treeNode root){
        if (root == null) return 0;
        int left = ifBalancePostTraverse(root.left);
        if (left == -1) return -1;
        int right = ifBalancePostTraverse(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) >= 1 ? -1 : 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        treeNode root = new treeNode(10);
        treeNode left = new treeNode(10);
        treeNode right = new treeNode(10);
        root.left = left;
        root.right = right;

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

        balanceBinaryTree machine = new balanceBinaryTree();
        int result = machine.ifBalancePostTraverse(node[0]);
        System.out.println(result);
    }

}
