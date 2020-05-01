/**
 * @Classname BitOperation
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class BitOperation {
    public BitOperation() {

    }
    public int Count1Bit(int num) {
        int count = 0;
        int flag = 1;
        while (flag!=0){
            if ((flag&num)!=0){
                count++;
            }
            flag=flag<<1;
        }
        return count;
    }

    public int MinusBitCount(int num){
        int count = 0;
        while (num!=0){
            num = (num-1)&num;
            count++;
        }
        return count;
    }

    public boolean if2n(int num){
        int count = 0;
        while (num!=0){
            if (count>1) break;
            num = (num-1)&num;
            count++;
        }
        return count == 1;
    }

    public int CountChange(int a, int b){
        int c = a^b;
        return MinusBitCount(c);
    }

    public static void main(String[] args) {
        BitOperation bitOperation = new BitOperation();
        int count= bitOperation.Count1Bit(10);
        int count2 = bitOperation.MinusBitCount(10);
        boolean count3 = bitOperation.if2n(4);
        System.out.println(count);
        System.out.println(count2);
        System.out.println(count3);
    }
}
