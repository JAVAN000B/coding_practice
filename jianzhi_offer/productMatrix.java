/**
 * @Classname productMatrix
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class productMatrix {
    public int[] GetProductMatrix(int[] list){
        if (list == null||list.length <1) return null;
        int[] product = new int[list.length];
        int[] head = new int[list.length];
        int[] tail = new int[list.length];
        head[0] = 1;
        tail[list.length-1] = 1;
        for (int i = 1; i < list.length; ++i) {
            head[i] =head[i-1]*list[i-1];
        }
        for (int j = list.length - 2; j>-1; --j) {
            tail[j] = tail[j+1]*list[j+1];
        }
        for (int i = 0; i < list.length; ++i) {
            product[i] = head[i]*tail[i];
        }
        return product;
    }

}
