/**
 * @Classname findBSTNnumber
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class findBSTNnumber {
    int count = 0;
    static class treeNode{
        int data;
        treeNode left;
        treeNode right;
        treeNode(int data){
            this.data = data;
        }
    }

    public treeNode findNth(treeNode root,int count){
        if (count < 1||root==null) return null;
        this.count = count;
        return findNthCore(root);
    }

    public treeNode findNthCore(treeNode root) {
        treeNode ans = null;
        if (root.left!=null){
            ans = findNthCore(root.left);
        }
        if (ans == null){
            if (count==1)
                ans = root;
            count--;
        }
        if (ans ==null&&root.right != null){
            ans = findNthCore(root.right);
        }
        return ans;
    }

    public static void main(String[] args) {
        findBSTNnumber machine = new findBSTNnumber();
        treeNode root = new treeNode(10);
        treeNode left = new treeNode(6);
        treeNode right = new treeNode(12);
        root.left = left;
        root.right = right;
        treeNode target = machine.findNth(root,3);
        System.out.println(target.data);
    }


}
