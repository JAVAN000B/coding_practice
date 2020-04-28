/**
 * @Classname equalNumber
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class equalNumber {

    public int findN(int[] list, int begin, int finish){
        if (begin>finish) return -1;
        int mid = begin&finish+((begin^finish)>>1);
        if (list[mid]==mid) return mid;
        else {
            int result;
            if (list[mid]<mid){
                result = findN(list,mid+1,finish);
            }else {
                result = findN(list, begin, mid-1);
            }
            return result;
        }
    }

}
