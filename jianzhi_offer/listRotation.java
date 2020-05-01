/**
 * @Classname listRotation
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class listRotation {
    public listRotation(){}

    public int findMin(int[] list){
        if (list == null||list.length <=0) return 0;
        if (list[0]<list[list.length - 1]) return list[0];
        if (list[0]==list[list.length - 1]){
             int mid = (list[0]+ list[list.length - 1])/2;
             if (mid == list[0]) {
                 int min = list[0];
                 for (int i = 1; i < list.length; ++i) {
                     if (list[i] < min){
                         min = list[i];
                     }
                 }
                 return min;
             } else return RotationMin(list);
        }
        return RotationMin(list);
    }

    public int RotationMin(int[] list){
        int topPointer = 0;
        int tailPointer = list.length - 1;
        int midPointer;
        while (tailPointer>topPointer){
            midPointer = (topPointer+tailPointer)/2;
            if (list[midPointer]>list[topPointer]){
                topPointer = midPointer;
            }else {
                tailPointer = midPointer;
            }
            if (tailPointer-1 == topPointer) break;
        }
        return list[tailPointer];
    }

    public static void main(String[] args) {
        int[] list = {3,4,5,1,2};
        listRotation machine = new listRotation();
        int min = machine.findMin(list);
        System.out.println(min);
    }

}
