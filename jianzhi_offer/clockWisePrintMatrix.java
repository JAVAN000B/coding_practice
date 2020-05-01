/**
 * @Classname clockWisePrintMatrix
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class clockWisePrintMatrix {
    clockWisePrintMatrix(){}
    public void clockWisePrint(int[][] matrix){
        if (matrix==null || matrix.length<1) return;
        if (matrix[0].length <1) return;
        int direction = 0;
        boolean[][] visited = new boolean[matrix.length+2][matrix[0].length+2];
        for (int i = 0; i < visited.length; ++i) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
        visited[visited.length-1][1] = true;
        visited[visited.length - 2][visited[0].length - 1] = true;
        visited[0][visited[0].length-2] = true;
        int k = 1; int l = 1;
        int count = 0;
        while (count<matrix.length*matrix[0].length-1){
            if (direction == 0){
                if (visited[k + 1][l]){
                    direction++;
                }else {
                    System.out.println(matrix[k-1][l-1]);
                    visited[k][l] = true;
                    count++;
                    k++;
                }
                continue;
            }
            if (direction == 1) {
                if (visited[k][l+1]){
                    direction++;
                }else {
                    System.out.println(matrix[k-1][l-1]);
                    visited[k][l] = true;
                    count++;
                    l++;
                }
                continue;
            }
            if (direction == 2) {
                if (visited[k-1][l]) {
                    direction++;
                }else {
                    System.out.println(matrix[k-1][l-1]);
                    visited[k][l] = true;
                    count++;
                    k--;
                }
                continue;
            }

            if (direction ==3){
                if (visited[k][l-1]) {
                    direction = 0;
                }else {
                    System.out.println(matrix[k-1][l-1]);
                    count++;
                    l--;
                }
                visited[k][l] = true;
            }

        }
        System.out.println(matrix[k-1][l-1]);


    }

    public static void main(String[] args) {
        int[][] matrix = {{1,16,15,14,13},{2,17,24,23,12},{3,18,25,22,11},{4,19,20,21,10},{5,6,7,8,9}};
        clockWisePrintMatrix machine = new clockWisePrintMatrix();
        machine.clockWisePrint(matrix);
    }

}
