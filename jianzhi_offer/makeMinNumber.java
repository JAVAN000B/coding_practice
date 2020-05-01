
import	java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname makeMinNUmberr
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class makeMinNumber {

    public void printMin(int[] list){
        if (list==null||list.length <1)System.out.println("list empty");
        String[] strings = new String[list.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            strings[i] = String.valueOf(list[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1+o2;
                String c2 = o2+o1;
                return c1.compareTo(c2);
            }
        });
        for (int i = 0; i < list.length; ++i) {
            sb.append(strings[i]);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        makeMinNumber machine = new makeMinNumber();
        machine.printMin(new int[]{1, 3, 5, 2, 7});
    }

}
