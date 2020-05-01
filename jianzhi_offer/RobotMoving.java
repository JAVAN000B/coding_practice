/**
 * @Classname RobotMoving
 * @Description TODO
 * @Author Minghui Sun, Fengjie Gu
 * @Version 1.0
 */
public class RobotMoving {
    public RobotMoving(){

    }

    public int countMoving(int limit, int rows, int cols) {
        if (limit < 0 || rows<0 || cols<0) return 0;
        int[][] visited = new int[rows][cols];
        return countCore(visited,limit,0,0,rows,cols);
    }

    public int countCore(int[][] visited, int limit, int x, int y, int rows, int cols){
        if (x < 0 ||y < 0 || x >= rows || y >= cols || x+y > limit) return 0;
        visited[x][y] = 1;
        int c1 = 0,c2 = 0,c3 = 0,c4 =0;
        if(x>1 && visited[x-1][y] !=1){
            c1 = countCore(visited,limit,x-1,y,rows,cols);
        }
        if (x<rows-1 && visited[x+1][y] !=1){
            c2 = countCore(visited,limit,x+1,y,rows, cols);
        }
        if (y>1 && visited[x][y-1]!= 1){
            c3 = countCore(visited, limit, x, y-1, rows, cols);
        }
        if (y<cols - 1 && visited[x][y+1] != 1){
            c4 = countCore(visited, limit, x, y+1, rows, cols);
        }
        return 1+c1+c2+c3+c4;
    }

    public static void main(String[] args) {
        RobotMoving robotMoving = new RobotMoving();
        int count = robotMoving.countMoving(10,5,6);
        System.out.println(count);
    }

}
