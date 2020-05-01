import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname MiddleOfInputStream
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class MiddleOfInputStream {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    });
    int len = 0;
    public void PrintMiddle(){
        if ((len&0x1)== 0)System.out.println(maxHeap.peek()+","+minHeap.peek());
        else System.out.println(maxHeap.size()>minHeap.size()?maxHeap.peek():minHeap.peek());
    }

    public void addElement(int a){
        if ((len&0x1)!= 0){
            if (maxHeap.size()==0) maxHeap.add(a);
            else {
                if (maxHeap.peek()>a) maxHeap.add(a);
                else {
                    if (minHeap.peek()>a) maxHeap.add(a);
                    else {
                        maxHeap.add(minHeap.poll());
                        minHeap.add(a);
                    }
                }
            }
        }else {
            if (minHeap.size() ==0) {
                if (maxHeap.peek() < a) {
                    minHeap.add(a);
                } else {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(a);
                }
            }else {
                if (minHeap.peek()<a) minHeap.add(a);
                else {
                    if (maxHeap.peek()<=a) minHeap.add(a);
                    else {
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(a);
                    }
                }
            }
        }
        len++;
    }

}
