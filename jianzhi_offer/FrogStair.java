/**
 * @Classname FrogStair
 * @Description TODO
 * @Author Minghui Sun, Fengjie Gu
 * @Version 1.0
 */
public class FrogStair {
    int[] FrogChoice = {1,2};
    public FrogStair(){

    }

    public int TotalMethod(int totalOfStairs) {
        if (totalOfStairs ==0) return 0;
        for (int i = 0; i < FrogChoice.length; i++){
            if (totalOfStairs == FrogChoice[i]) return i+1;
        }
        return TotalMethod(totalOfStairs-1)+TotalMethod(totalOfStairs-2);
    }

    //空间换时间，不用每次重复运算.
    public int totalWithExtraSpace(int totalOfStairs){
        if (totalOfStairs ==0) return 0;
        for (int i = 0; i < FrogChoice.length; i++){
            if (totalOfStairs == FrogChoice[i]) return i+1;
        }
        int[] result = new int[totalOfStairs];
        for (int i = 0; i < FrogChoice.length; ++i) {
           result[i] = FrogChoice[i];
        }
        return totalResult(result,totalOfStairs-1);
    }

    public int totalResult(int[] result, int n){
        if (result[n]!= 0) return result[n];
        return totalResult(result, n-2)+ totalResult(result,n-1);
    }

    public static void main(String[] args) {
        FrogStair test = new FrogStair();
        System.out.println(test.TotalMethod(10));
        System.out.println(test.totalWithExtraSpace(9));
    }

}
