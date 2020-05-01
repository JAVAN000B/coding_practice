/**
 * @Classname PlusByBitOperation
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class PlusByBitOperation {

    public int addSpecial(int a, int b) {
        int sum,carry;
        do {
            sum = a^b;
            carry =(a&b)>>1;
            a= sum;
            b = carry;
        }while (carry!=0);
        return sum;
    }
}
