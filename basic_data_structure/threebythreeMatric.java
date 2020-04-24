/**
 * @Classname threebythreeMatric
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class threebythreeMatric {
    threebythreeMatric(){}
    public void findPossibleSolution(){
        int[] matrix = {1,2,3,4,5,6,7,8,9};
        insertValue(matrix,0);

    }

    static void swap(int[] c,int index1,int index2){
        int temp=c[index1];
        c[index1]=c[index2];
        c[index2]=temp;
    }

    public void insertValue(int[] list,int i){
        if (i==9){
            if (isRight(list)){
                for (int k = 0; k < list.length; k++) {
                    System.out.print(list[k]);
                }
                System.out.println();
            }
            return;
        }
        for (int j = i; j < list.length; ++j) {
            swap(list,i,j);
            insertValue(list,i+1);
            swap(list,i,j);
        }
    }

    public boolean isRight(int[] a) {
        if (a[0]==a[1]&&a[2]==a[3]&&a[3] == a[4]&&a[4] == a[5]&&a[5] == a[6]&&a[8] == a[7]) return false;
        int sum1, sum2, sum3, sum4, sum5, sum6, sum7, sum8;
        sum1 = a[0] + a[1] + a[2];
        sum2 = a[3] + a[4] + a[5];
        sum3 = a[6] + a[7] + a[8];
        sum4 = a[0] + a[3] + a[6];
        sum5 = a[1] + a[4] + a[7];
        sum6 = a[2] + a[5] + a[8];
        sum7 = a[0] + a[4] + a[8];
        sum8 = a[2] + a[4] + a[6];
        if (sum1 == sum2 && sum1 == sum3 && sum1 == sum4 && sum1 == sum5
                && sum1 == sum6 && sum1 == sum7 && sum1 == sum8) return true;
        return false;
    }


     public static void main(String[] args) {
        threebythreeMatric machine = new threebythreeMatric();
        int[] list = {0,0,0,0,0,0,0,0,0};
        int[] visited = list.clone();
        machine.findPossibleSolution();
    }

}
