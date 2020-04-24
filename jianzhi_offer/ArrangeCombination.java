/**
 * @Classname ArrangeCombination
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class ArrangeCombination {

    public void showWithReplacement(String[]list){
        int length = list.length;
        int current = 0;
        String[] outcome = new String[length];
        for (int i = 0; i < length; ++i) {
            outcome[i] = "0";
        }
        withReplacement(list,0,length,outcome);
    }

    public void withReplacement(String[] list, int current, int length, String[] outcomes){
        if (current == length){
            for (int i = 0; i < length; ++i) {
                System.out.print(outcomes[i]);
            }
            System.out.println();
        }else {
            for (int i = 0; i < length; i++) {
                outcomes[current] = list[i];
                withReplacement(list, current+1,length,outcomes);
            }
        }


    }

    public void showWithOutReplacement(String[] list){
        withOutReplacementCore(list,0);
    }

    public void withOutReplacementCore(String[] list, int current){
        if (current == list.length){
            for (int i = 0; i < list.length; ++i) {
                System.out.print(list[i]);
            }
            System.out.println();
        }else {
            for (int i = current; i <list.length; ++i ){
                swap(list,i,current);
                withOutReplacementCore(list, current+1);
                swap(list,i,current);
            }
        }

    }

    static void swap(String[] c,int index1,int index2){
        String temp=c[index1];
        c[index1]=c[index2];
        c[index2]=temp;
    }

    public void combination(char[] list){
        int length = list.length;
        int current = 0;
        char[] result = new char[length];
        combineCore(list,current,length,result);
    }
    public void combineCore(char[] list, int current,int length, char[] result){
        if (current ==length){
            for (int i = 0; i < length; ++i) {
                System.out.print(result[i]);
            }
            System.out.println();
        }else {
            result[current] = ' ';
            combineCore(list,current+1,length,result);
            result[current] = list[current];
            combineCore(list,current+1,length,result);
            result[current]  = ' ';
        }
    }

    //这什么神仙方法啊
    public static void Combine(char[] c) {
        if (c == null) {
            return;
        }
        int len = c.length;
        boolean[] used = new boolean[len];
        char cache[] = new char[len];
        int result = len;
        while (true) {
            int index = 0;
            while (used[index]) {
                used[index] = false;
                ++result;
                if (++index == len) {
                    return;
                }
            }
            used[index] = true;
            cache[--result] = c[index];
            System.out.print(new String(cache).substring(result) + " ");
        }
    }

    public static void main(String[] args) {
        String[] list = {"A","B","C"};
        ArrangeCombination machine = new ArrangeCombination();
        //machine.showWithReplacement(list);
        machine.showWithOutReplacement(list);
        char[] list2 = {'A','B','C'};
        machine.Combine(list2);
        machine.combination(list2);
    }
}
