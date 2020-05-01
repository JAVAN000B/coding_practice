/**
 * @Classname findDifferentNumber
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class findDifferentNumber {

    public int findN(int[] list,int begin, int end, int target){
        if (begin>end) return -1;
        int mid = (begin&end)+((begin^end)>>1);
        if (mid == list[mid]){
            target = findN(list, mid+1, end, target);
        }else {
            if (mid == 0||list[mid-1] == mid-1){
                target = mid;
                return target;
            }
            target= findN(list, begin, mid-1,target);
        }
        return target;
    }

    public static void main(String[] args) {
        int[] list={0,1,2,3,4,5};
        findDifferentNumber machine = new findDifferentNumber();
        int count = machine.findN(list,0,list.length-1,-1);
        System.out.println(count);
    }

}
