/**
 * @Classname theNnumber
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class theNnumber {
    public int nNumberCore(int n, int digit) {
        if (n<0) return -1;
        double totalDigit = 9*Math.pow(10,digit-1)*digit;
        if (totalDigit==9) totalDigit++;
        if (n>totalDigit)
            return nNumberCore((int) (n-totalDigit),++digit);
        else{
            int nth = n%digit;
            int actualNumber = (int) (n /digit+(Math.pow(10,digit-1)));
            for (int i = 0; i <  nth; ++i){
                actualNumber /=10;
            }
            return actualNumber%10;
        }
    }

    public static void main(String[] args) {
        theNnumber machine = new theNnumber();
        int result =machine.nNumberCore(1001,1);
        System.out.println(result);
    }
}
