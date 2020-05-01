import java.util.HashMap;

/**
 * @Classname findDuplicateInList
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class findDuplicateInList {

    public int[] HashTableFind(int[] list){
        int[] duplicate = new int[list.length];
        HashMap comparison = new HashMap();
        for (int i = 0; i < list.length; i++) {
            if (comparison.containsValue(list[i])){
                duplicate[i] = list[i];
            } else {
                comparison.put(i,list[i]);
            }
        }
        return duplicate;
    }

        public boolean ReconstitutionCheck(int[] list){
        for (int i = 0; i <list.length ; i++) {
            if (!(i == list[i])){
                if (list[list[i]] == list[i]){
                    return true;
                }else {
                    int tmp = list[i];
                    list[i] = list[list[i]];
                    list[list[i]] = tmp;
                }
            }
        }
        return false;
    }

    public int getDuplicate(int[] arr) {
        if (arr == null || arr.length <= 0) {
            System.out.println("数组输入无效！");
            return -1;
        }
        for (int a : arr) {
            if (a < 1 || a > arr.length - 1) {
                System.out.println("数字大小超出范围！");
                return -1;
            }
        }
        int low = 1;
        int high = arr.length - 1; // high即为题目的n
        int mid, count;
        while (low <= high) {
            mid = ((high - low) >> 2) + low;
            count = countRange(arr, low, mid);
            if (low == high) {
                if (count > 1)
                    return low;
                else
                    break; // 必有重复，应该不会出现这种情况吧？
            }
            if (count > mid - low + 1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 返回在[low,high]范围中数字的个数
     */
    public int countRange(int[] arr, int low, int high) {
        if (arr == null)
            return 0;

        int count = 0;
        for (int a : arr) {
            if (a >= low && a <= high)
                count++;
        }
        return count;
    }

    public int mergeFind(int[] list){
        if (list==null || list.length <= 0) return -1;
        int top = 0;
        int end = list.length -1;
        int middle = 0;
        while (top <= end){
            middle = ((end - top) >> 2) + top;
            int count = countRange(list,top,middle);
            if (top == end){
                if (count > 1) return top;
                break;
            }
              if (count>middle-top+1){
                  end = middle;
              }else {
                  top = middle+1;
              }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] list = {0,1,2,3,4,5,6};
        findDuplicateInList machine = new findDuplicateInList();
        int[] outcome =  machine.HashTableFind(list);
        boolean outcome2 = machine.ReconstitutionCheck(list);
        System.out.println("finish");
    }
}
