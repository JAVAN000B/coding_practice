/**
 * @Classname listAll
 * @Description TODO
 * @Author Minghui Sun, Fengjie Gu
 * @Version 1.0
 */
public class listAll {
    public listAll(){}

    public void showAll(int n){
        if (n<=0) return;
        String[] outcome = new String[n+1];
        for (int i = 0; i < n+1; ++i) {
            outcome[i] = "0";
        }
        Insert(outcome,1,n);
    }

    private void Insert(String[] outcome, int cur,int n) {
        if (cur == n + 1){
            int count =0;
            for (int i = 0; i < outcome.length ; i++) {
                if (count==0){
                    if (!outcome[i].equals("0")){
                        count++;
                        System.out.print(outcome[i]);
                    }
                } else {
                    System.out.print(outcome[i]);
                }

            }
            System.out.println();
            return;
        }
        for (int i = 0; i < 10; i++){
            outcome[cur] = Integer.toString(i);
            Insert(outcome, cur+1,n);
        }
    }

    //打印数字
    private void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; ++i) {
            if(isBeginning0 && number[i]!='0'){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    public void bigNumPlus(String[] a, String[] b) {
        int aLen= a.length;
        int bLen = b.length;
        if (aLen<=0 || bLen<= 0) return;
        int standardLen = (aLen>bLen)? aLen+1:bLen+1;
        String[] newA= addHead(standardLen, a);
        String[] newB = addHead(standardLen,b);
        String[] result = newB.clone();
        PlusCore(newA,newB,standardLen-1,false, result);
    }

    private String[] addHead(int standardLen, String[] origin) {
        int i = standardLen;
        int j = origin.length;
        String[] later = new String[i];
        while (i>0){
            if (j>0){
                later[i-1] = origin[j-1];
                j--;
            }else {
                later[i-1] = "0";
            }
            i--;
        }
        return later;
    }

    private void PlusCore(String[] a, String[] b, int cur, boolean isover, String[] result) {
        if (cur == -1){
            int count = 0;
            for (int i = 0; i < result.length; ++i) {
                if (count==0){
                    if (!result[i].equals("0")){
                        System.out.print(result[i]);
                        count++;
                    }
                } else {
                    System.out.print(result[i]);
                }
            }
            return;
        }
        Integer value = Integer.parseInt(a[cur])+Integer.parseInt(b[cur])+(isover?1:0);
        if (value>=10){
            isover = true;
            value -= 10;
        } else {
            isover = false;
        }
        result[cur] =value.toString();
        PlusCore(a,b,--cur,isover,result);
    }


    public static void main(String[] args) {
        listAll ListAll = new listAll();
        //ListAll.showAll(100);
        ListAll.bigNumPlus(new String[]{"1", "9","7","5","9"}, new String[]{"1", "8"});
    }

}
