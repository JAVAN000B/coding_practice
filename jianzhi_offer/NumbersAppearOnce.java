import java.util.Objects;

/**
 * @Classname NumbersAppearOnce
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class NumbersAppearOnce {

    public void findUniqueNums(int list[]){
        if (list == null||list.length <1) return;
        int exclusiveOR = 0;
        for (int i = 0; i < list.length; i++){
            exclusiveOR ^=list[i];
        }
        int indexBit = 0;
        while (((exclusiveOR&1)==0)&&exclusiveOR>0){
            exclusiveOR >>=1;
            indexBit++;
        }
        int num1 = 0; int num2 = 0;
        for (int num:list
             ) {
            if ((num>>indexBit&1)==0) num1^=num;
            else num2^=num;
        }
        System.out.println(num1 + ","+num2);
    }

    public int findLonelyNumber(int[] list, int repeat){
        if (list == null||repeat<2||list.length<1) return -1;
        int[] bitSum = new int[32];
        for (int i = 0; i < list.length; ++i) {
            int bitMask = 1;
            for (int j = 31; j >=0 ; --j) {
                int bit = list[i]&bitMask;
                if (bit!=0){
                    bitSum[j]+=1;
                }
                bitMask<<=1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; ++i){
            result = result<<1;
            result +=bitSum[i]%repeat;
        }
        return result;
    }

    public static void main(String[] args) {
        NumbersAppearOnce machine = new NumbersAppearOnce();
        int[] list = {11,11,1,1,22,33,22,33,6};
        machine.findUniqueNums(list);
        int[] list2 = {11,11,11,2,2,2,3,3,3,1};
        int result = machine.findLonelyNumber(list,2);
        System.out.println(result);
    }

}
