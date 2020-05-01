/**
 * @Classname IntPow
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class IntPow {
    IntPow(){}
    public double Power(double x, int exponent){
        if (x==0) return 0;
        if (exponent == 0) return 1;
        if (exponent ==1) return x;
        if (exponent<0) return 1.0/Power(x,-1*exponent);
        double result = Power(x, exponent>>1);
        result*=result;
        if((exponent&0x1)==1) result*=x;
        return result;
    }

    public static void main(String[] args) {
        IntPow intPow = new IntPow();
        Double result= intPow.Power(2,7);
        System.out.println(result);
    }
}
