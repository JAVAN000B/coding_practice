/**
 * @Classname StringModify
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class StringModify {

    //自带的方法
    public String ReplaceFunction(StringBuilder str){
        return str.toString().replace(" ","%20");
    }

    //额外的空间
    public String SpaceModify(StringBuilder str){
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < str.length() ; i++) {
            if (str.charAt(i) == ' '){
                newString.append("%20");
            }else {
                newString.append(str.charAt(i));
            }
        }
        return newString.toString();
    }

    //如果输入值是个char【】 并且有足够的额外空间可以使用双指针从后往前添加，虽然java里没有指针这种东西，大嘘


    public int[] mergeTwoList(int[] A, int[] B){
        int[] newList = new int[A.length+B.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i<A.length && j <B.length){
            if (A[i] <B[j]){
                newList[k] = A[i];
                k++;
                i++;
            }
            newList[k] = B[j];
            k++;
            j++;
        }

        while (i<A.length){
            newList[k] = A[i];
            i++;
            k++;
        }

        while (j<B.length){
            newList[k] = B[j];
            j++;
            k++;
        }
        return newList;
    }
    //简化版本
    public static int[] merge(int[] a, int[] b) {

        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length)
            answer[k++] = a[i] < b[j] ? a[i++] :  b[j++];

        while (i < a.length)
            answer[k++] = a[i++];


        while (j < b.length)
            answer[k++] = b[j++];

        return answer;
    }


    //带佬写法
    public static int[] mergeShort(int[] a, int[] b) {
        int[] answer = new int[a.length + b.length];
        int i = a.length - 1, j = b.length - 1, k = answer.length;
        while (k > 0)
            answer[--k] = (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--]; //？？？？
        return answer;
    }


}
