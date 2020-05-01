/**
 * @Classname lastNumIncircle
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class lastNumIncircle {

    public int lastOne(int n , int m) {
        if (n<1||m<1) return -1;
        int last = 0;
        for (int i = 2; i <=  n; ++i) {
            last = (last+m)%i;
        }
        return last;
    }

    public static void main(String[] args) {
        lastNumIncircle machine = new lastNumIncircle();
        int result = machine.lastOne(8,3);
        System.out.println(result);
    }

}
