/**
 * @Classname BSTtoLinkList
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0  ??????
 */
public class BSTtoLinkList {
    static class treeNode{
        int data;
        treeNode left;
        treeNode right;
        treeNode(int data){
            this.data = data;
        }
    }

    public treeNode convertToLinkList(treeNode root){
        if (root == null) return null;
        treeNode current = null;
        treeNode listHead = null;
        convertCore(root,current,listHead);
        return listHead;
    }

    public treeNode convertCore(treeNode root, treeNode current, treeNode listHead){
        if (root==null) return null;
        convertCore(root.left,current, listHead);
        if (current == null){
            current = root;
            listHead = root;
        }else {
            current.right = root;
            root.left = current;
            current = root;
        }
        convertCore(root.right, current ,listHead);
        return listHead;
    }

    public static void main(String[] args) {
        treeNode root = new treeNode(10);
        treeNode left = new treeNode(6);
        treeNode right = new treeNode(12);
        root.left = left;
        right.right = right;
        BSTtoLinkList machine = new BSTtoLinkList();
        treeNode head = machine.convertToLinkList(root);
        System.out.println("finish!!!!!");
    }

}
