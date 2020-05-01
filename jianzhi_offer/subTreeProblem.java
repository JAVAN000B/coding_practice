/**
 * @Classname subTreeProblem
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class subTreeProblem {
    class treeNode{
        double data;
        treeNode left;
        treeNode right;
    }
    subTreeProblem(){}

    public boolean checkSubTree(treeNode root1, treeNode root2){
        if (root2 == null||root1==null) return false;
        return checkRoot(root1,root2);
    }

    public boolean checkRoot(treeNode root1, treeNode root2){
        if (root1==null||root2==null)return false;
        boolean result = false;
        if (dataEquals(root1,root2)){
            result = checkBranch(root1,root2);
        }
        if (!result) result = checkBranch(root1.left,root2);
        if (!result) result = checkBranch(root1.right, root2);
        return result;
    }

    private boolean checkBranch(treeNode root1, treeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (!dataEquals(root1, root2)) return false;
        return checkBranch(root1.left, root2.left)&&checkBranch(root1.right, root2.right);
    }

    public boolean dataEquals(treeNode root1, treeNode root2){
        double data1 = root1.data;
        double data2 = root2.data;
        return (data1 - data2 > -0.0000001) && (data1 - data2 < 0.0000001);
    }

}
