/**
 * @Classname BinaryTreeserialization
 * @Description TODO
 * @Author Minghui Sun, Fengjie Gu
 * @Version 1.0
 */
public class BinaryTreeSerialization {
    private static int current;

    static class treeNode{
        int data;
        treeNode left;
        treeNode right;
        treeNode(int data){
            this.data = data;
        }
    }

    public String serialize(treeNode root){
        if (root == null) return null;
        StringBuffer sb = new StringBuffer();
        serializeCore(root,sb);
        return sb.substring(0,sb.length()-1);
    }

    private void serializeCore(treeNode root, StringBuffer sb) {
        if (root == null){
            sb.append("$,");
            return;
        }
        sb.append(root.data+",");
        serializeCore(root.left,sb);
        serializeCore(root.right, sb);
    }


    static treeNode Deserialize(String str) {
        if (str == null || str.trim().equals(""))
            return null;

        String[] strs = str.split(",");
        return DeserializeCore(strs);
    }

    private static treeNode DeserializeCore(String[] strs) {
        if (current>=strs.length) return null;
        if (strs[current].equals("$")){
            current++;
            return null;
        }else {
            treeNode node = new treeNode(Integer.parseInt(strs[current]));
            current++;
            node.left = DeserializeCore(strs);
            node.right = DeserializeCore(strs);
            return node;
        }
    }


    public static void main(String[] args) {
        treeNode root = new treeNode(10);
        treeNode left = new treeNode(6);
        treeNode right = new treeNode(12);
        root.left = left;
        root.right = right;
        BinaryTreeSerialization machine = new BinaryTreeSerialization();
        String serialization = machine.serialize(root);
        String[] ser = new String[] {"10","6","$","15","12","7","$"};
        System.out.println(serialization);
        treeNode newRoot = machine.Deserialize(serialization);
        System.out.println("Finish!!!!");
    }


}
