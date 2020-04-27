/**
 * @Classname convertNumsToStr
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class convertNumsToStr {

    public int convert(int[] list){
        if (list == null||list.length<1) return 0;
        int i = list.length-1;
        int[] ints=new int[list.length];
        while (i >0) {
            int count = 0;
            if (i<list.length-1){
                count = ints[i+1];
            }else {
                count = 1;
            }
            if (i<list.length-1){
                int tmp = list[i+1]+list[i]*10;
                if (tmp>0&&tmp<26&&list[i]!=0){
                    if (i<list.length-2){
                        count+= ints[i+2];
                    }else {
                        count++;
                    }
                }
            }
            ints[i] = count;
            i--;
        }
        return ints[0];
    }



}
