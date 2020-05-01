/**
 * @Classname SumEqualS
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class SumEqualS {
    public int[] twoSumS(int[] orderList, int target){
        if (orderList == null||orderList.length<1) return null;
        int[] result = new int[2];
        int head = 0;
        int tail = orderList.length-1;
        while (head < tail){
            if (orderList[head]+orderList[tail] == target){
                result[0] = orderList[head];
                result[1] = orderList[tail];
                return result;
            }
            if (orderList[head]+orderList[tail] > target){
                tail--;
            }else
                head++;
        }
        return null;
    }

    public void continuousSumS(int target){
        int[] list = new int[target];
        list[0] =1;
        list[1] = 2;
        if (target<3) return;
        int head = 0;
        int sum = 3;
        int length = 2;
        int next = 2;
        while (length > 1){
            if (sum == target){
                for (int i = head; i < length; ++i) {
                    System.out.print(list[i]+",");
                }
                System.out.println();
            }
            if (sum<target){
                list[next] = list[next-1]+1;
                sum += list[next];
                next++;
                length++;
            }else {
                list[head] = 0;
                head++;
                sum-=list[head-1];
                length--;
            }
        }
    }

}
