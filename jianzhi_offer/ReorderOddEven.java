/**
 * @Classname ReorderOddEven
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class ReorderOddEven {

    public ReorderOddEven(){};

    public void reorder(int[] list){
        if (list==null|| list.length <2) return;
        int i = 0; int j = list.length-1;
        while (i<j){
            if(reorderReason(list[i])){
                i++;
            }else {
                if (reorderReason(list[j])){
                    int tmp = list[i];
                    list[i] = list[j];
                    list[j] = tmp;
                    j--;
                    i++;
                }else {
                    j--;
                }
            }
        }
    }

    public boolean reorderReason(int number){
        if ((number&0x1)!=0) return true;
        return false;
    }

    public static void main(String[] args) {
        ReorderOddEven reorder = new ReorderOddEven();
        int[] list = {1,2,3,4,5,6,7,8,9,10};
        reorder.reorder(list);
        System.out.println("finish!!!");
    }

}
