
import	java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname KMinNumber
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class KMinNumber {

    public void findKMin(int[] list,int k){
        if (list == null||list.length<1) return;
        int begin = 0;
        int end = list.length-1;
        int pivot = partion(list,begin,end);
        while (pivot!= k){
            if (pivot>k)pivot = partion(list,begin,pivot-1);
            else pivot = partion(list,pivot+1,end);
        }
        for (int i = 0; i < pivot; ++i) {
            System.out.println(list[i]);
        }

    }

    public int partion(int[]list, int begin,int end) {
        int pivot = list[begin];
        int pivotIndex = begin;
        int i = begin+1;
        while (i <= end){
            if (list[i]<pivot){
                pivotIndex++;
                int tmp = list[i];
                list[i] = list[pivotIndex];
                list[pivotIndex] = tmp;
            }
            i++;
        }
        list[begin] = list[pivotIndex];
        list[pivotIndex] = pivot;
    return pivotIndex;
    }

    public ArrayList<Integer> findKMinAlter(int[] list,int k){
        if (list==null||list.length<1||k<1)return null;
        PriorityQueue<Integer> maxHeap =new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int count = 0;
        int i = 0;
        while (list.length>i) {
            if (count++<k) maxHeap.add(list[i]);
            else {
                if (maxHeap.peek()>list[i]){
                    maxHeap.poll();
                    maxHeap.add(list[i]);
                }
            }
            i++;
        }
        return new ArrayList<Integer>(maxHeap);
    }

    public static void main(String[] args) {
        KMinNumber machine = new KMinNumber();
        int[] list = {1,2,3,4,5,87,9768,32,1,2,435,2};
        machine.findKMin(list,2);
        ArrayList<Integer> result =machine.findKMinAlter(list,2);
        System.out.println("finish!!!");
    }

}
