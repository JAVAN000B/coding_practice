/**
 * @Classname findNMoreThanHalf
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class findNMoreThanHalf {
    public int findMiddle(int[] list){
        if (list == null) return -1;
        if (list.length<1) return -1;
        int middleIndex = list.length>>1;
        int start = 0;
        int end =list.length;
        int pivotIndex = partition(list,start,end);
        while (pivotIndex!=middleIndex){
            if (pivotIndex>middleIndex) pivotIndex = partition(list,start,pivotIndex);
            else pivotIndex = partition(list,pivotIndex+1,end);
        }
        if(!ifOverHalf(list,pivotIndex)) return -1;
        return list[pivotIndex];
    }
    public int partition(int[] list,int start, int end){
        int pivot = list[start];
        int pivotIndex = start;
        for (int i = pivotIndex+1; i < end; ++i) {
            if (list[i] < pivot){
                pivotIndex++;
                int tmp = list[i];
                list[i] = list[pivotIndex];
                list[pivotIndex] = tmp;
            }
        }
        list[start] = list[pivotIndex];
        list[pivotIndex] = pivot;
        return pivotIndex;
    }

    public boolean ifOverHalf(int[] list, int pivotIndex){
        int pivot = list[pivotIndex];
        int count = 0;
        for (int i = 0; i < list.length; ++i) {
            if (list[i] == pivot) count++;
        }
        return count*2>list.length;
    }

    public int findOverHalf(int[] list){
        if (list==null||list.length<1) return -1;
        int length = list.length;
        int half = length/2;
        int count = 1;
        int value = list[0];
        int i = 1;
        while (i<length){
            if (count>half)break;
            if (list[i]!=value) count--;
            if (count==0){
                value = list[i];
                count++;
            }
            i++;
        }
        count = 0;
        for (int item : list) {
            if (item == value) count++;
        }
        if (count*2<=length) return -1;
        return value;
    }

    public static void main(String[] args) {
        int[] list = {3,3,3,3,3,3,3,3,5,4,1,1,2};
        findNMoreThanHalf machine = new findNMoreThanHalf();
        int test = machine.findMiddle(list);
        int test2 = machine.findOverHalf(list);
        System.out.println(test2);
    }
}
