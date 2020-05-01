/**
 * @Classname postOrderBST
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class postOrderBST {

    public boolean checkifBST(int[] node,int begin,int end){
        if (node == null ) return false;
        while (begin < end){
            if (node[begin]>node[end]){
                break;
            }
            begin++;
        }
        int j = begin;
        while (j < end){
            if (node[j]< node[end]) return false;
            j++;
        }
        boolean left = true;
        if (begin>1){
            left = checkifBST(node,0,begin-1);
        }
        boolean right = true;
        if (begin<end-1){
            right = checkifBST(node,begin,end - 1);
        }
        return (left&&right);
    }

    public static void main(String[] args) {
        int[] list = {7,5,6,9,11,10,8};
        postOrderBST machine = new postOrderBST();
        boolean test = machine.checkifBST(list, 0,list.length-1);
        System.out.println(test);
    }

}
