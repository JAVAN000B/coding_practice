import java.util.Arrays;
import java.util.Stack;

/**
 * @Classname matrixPath
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class matrixPath {
    public matrixPath(){}
    public boolean hasPath(String[] target, String[][] matrix){
        if (target == null||matrix==null||matrix.length<1){
            return false;
        }else {
            if (matrix[0].length < 1) return false;
        }
        Integer[][] view = new Integer[matrix.length][matrix[0].length];
        Stack<String> stack = new Stack<String> ();
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (Integer[] integers : view) {
                    Arrays.fill(integers, 0);
                }
                stack.push(matrix[i][j]);
                view[i][j] = 1;
                int th = 0;
                while (!stack.isEmpty()){
                    String current = stack.pop();
                    if (current.equals(target[th])){
                        if (i>0 && view[i-1][j]==0){
                            stack.push(matrix[i-1][j]);
                        }
                        if (i<matrix.length-1&&view[i+1][j]==0){
                            stack.push(matrix[i+1][j]);
                        }
                        if (j>0 && view[i][j-1]==0){
                            stack.push(matrix[i][j-1]);
                        }
                        if (j < matrix[i].length-1 && view[i][j+1]==0) {
                            stack.push(matrix[i][j+1]);
                        }
                        th++;
                    }
                    if (th==target.length) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] matrix = {{"A","B"},{"C","D"}};
        matrixPath machine = new matrixPath();
        boolean isHas = machine.hasPath(new String[]{"D", "B"},matrix);
        System.out.println(isHas);
    }

}
