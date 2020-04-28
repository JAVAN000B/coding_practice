/**
 * @Classname occurence
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class occurence {
    public int findOccurence(int[] list, int target){
        if (list == null||list.length <1) return 0;
        int count = 0;
        int length = list.length;
        int start = 0;
        int end = list.length-1;
        while (start<=end){
            int mid = (start&end)+((start^end)>>1);
            int currentValue = list[mid];
            if (currentValue == target){
                count++;
                int former = mid-1;
                int after = mid + 1;
                while (former>=0){
                    if (list[former]==target){
                        count++;
                        former--;
                    }else break;
                }
                while (after<=length-1){
                    if (list[after] == target){
                        count++;
                        after++;
                    }else break;
                }
                return count;
            }
            if (currentValue>target){
                end = mid - 1;
            }else start = mid+1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] list = {1,2,3,4,5};
        occurence machine = new occurence();
        int count = machine.findOccurence(list,1);
        System.out.println(count);
    }

}
