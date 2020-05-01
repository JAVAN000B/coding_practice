/**
 * @Classname TwodimensionMatrixFind
 * @Description 刀削法， 直接一刀切，横着切，竖着切。
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class TwodimensionMatrixFind {
    public boolean biggestFind(int[][] matrix, int target){
        int length = matrix[0].length;
        int width = matrix.length;
        int x = length -1;
        int y = 0;
        while (x>=0 && y<= width-1){
            if (matrix[x][y] > target){
                x--;
            } else if (matrix[x][y] < target){
                y++;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean smallestFind(int[][] matrix, int target){
        int length = matrix[0].length;
        int width = matrix.length;
        int x = 0;
        int y = width-1;
        while (x<length&& y>-1){
            if (matrix[x][y] > target){
                y--;
            } else if (matrix[x][y] < target){
                x++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] fourByFour ={{1,2,3,4},{2,3,4,5},{3,4,5,6},{4,5,6,7}};
        TwodimensionMatrixFind machine = new TwodimensionMatrixFind();
        int length = fourByFour[0].length;
        int width = fourByFour.length;
        boolean isFind = machine.biggestFind(fourByFour,2);
        boolean isFind2 = machine.smallestFind(fourByFour,100);
        System.out.println("finish");
    }
}

//忘记测试数组为空！！
