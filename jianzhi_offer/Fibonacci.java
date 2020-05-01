/**
 * @Classname Fibonacci
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class Fibonacci {
    public Fibonacci(){

    }

    public Integer IteratorsN(Integer n){
        if (n== 0 || n==1) return n;
        return IteratorsN(n-1)+ IteratorsN(n-2);

    }

    public long RepeatN(int n){
        long n1 = 0;
        long n2 = 1;
        long num = 0;
        for (int i = 1; i < n; i++) {
            num = n1+n2;
            n1 = n2;
            n2 = num;
        }
        return num;
    }

    public static void main(String[] args) {
        Fibonacci machine = new Fibonacci();
        //System.out.println(machine.IteratorsN(100)); //太久了8
        System.out.println(machine.RepeatN(100));
    }

}
