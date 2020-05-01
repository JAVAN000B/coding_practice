/**
 * @Classname diceProblem
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class diceProblem {
    public double[] possibilitiesIterators(int n) {
        if (n<1) return null;
        double totalPossible = Math.pow(6,n);
        double[] list = new double[n*5+1];
        IteratorCore(1,0,list,n+1);
        for (double occurence:list
             ) {
            occurence /=totalPossible;
        }
        return list;

    }

    public void IteratorCore(int kth, int totalValue, double[] list, int n){
        if (kth == n){
            list[totalValue-n-1]++;
            return;
        }
        for (int i = 1; i < 7;++i){
            IteratorCore(kth+1,totalValue+i,list,n);
        }
    }

    public double[] possibilitiesLoop(int n){
        if (n<1) return null;
        double[][] list = new double[2][];
        list[0] = new double[6*n+1];
        list[1] = new double[n*6+1];
        int flag = 0;
        for (int i = 1; i < 7; ++i) {
            list[flag][i] = 1;
        }
        for (int j = 2; j <= n; ++j) {
            for (int i = 0; i < j; ++i) {
                list[1-flag][j] = 0;
            }
            for (int i = j; i < 7*j; i++) {
                list[1-flag][i] = 0;
                for (int k = 1; k <=i&&k<=6; k++) {
                    list[1-flag][i] +=list[1-flag][i-k];
                }
            }
            flag = 1-flag;
        }
        double total = Math.pow(6,n);
        double[] result = new double[5*n+1];
        for (int i = n; i <= 6*n; ++i) {
            result[i-n] = list[flag][i];
        }
        return result;
    }


}
