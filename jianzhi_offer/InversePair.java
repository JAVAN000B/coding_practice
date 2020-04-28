/**
 * @Classname InversePair
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class InversePair {

    public int countInversePair(int[] list ) {
        if (list==null||list.length <1) return 0;
        int[] tmp = new int[list.length];
        int count = InverseCore(list,tmp,0,list.length-1);
        return count;
    }

    private int InverseCore(int[] list, int[] tmp, int start, int end) {
        if (start<end){
            int mid = (start+end)/2;
            int left = InverseCore(list,tmp,start,mid);
            int right = InverseCore(list,tmp,mid+1,end);
            int leftLast = mid;
            int rightLast = end;
            int count = 0;
            int Index = end;
            while (leftLast>=start&&rightLast>=mid+1){
                if (list[leftLast]>list[rightLast]){
                    tmp[Index--] = list[leftLast--];
                    count+=rightLast-mid;
                }else {
                    tmp[end--] = list[rightLast--];
                }
            }
            while (leftLast>=start){
                tmp[Index--] = list[leftLast--];
            }
            while (rightLast>mid){
                tmp[Index--] = list[rightLast--];
            }
            int k =start;
            for (; k <= end; ++k) {
                list[k] = tmp[k];
            }
            return count+left+right;
        }
        tmp[start] = list[start];
        return 0;
    }

    public static void main(String[] args) {
        int[] list = {7,5,6,4};
        InversePair machine = new InversePair();
        int count= machine.countInversePair(list);
        System.out.println(count);
    }

}
