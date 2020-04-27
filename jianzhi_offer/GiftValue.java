/**
 * @Classname GiftValue
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class GiftValue {

    public int findMaxValue(int[][]matrix){
        if (matrix == null||matrix.length <1) return 0;
        int[] lastMax = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i==0&j==0)
                    lastMax[j] = matrix[0][0];
                else{
                    if (i==0) lastMax[j] = lastMax[j-1]+matrix[i][j];
                    if (j==0) lastMax[j] = lastMax[j]+matrix[i][j];
                    if (i!=0&&j!=0) lastMax[j] = matrix[i][j]+(Math.max(lastMax[j], lastMax[j - 1]));
                }
            }
        }
        return lastMax[lastMax.length-1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        GiftValue machine = new GiftValue();
        int result = machine.findMaxValue(matrix);
        System.out.println(result);
    }

}
