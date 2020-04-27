import java.util.HashMap;

/**
 * @Classname uniqueChar
 * @Description TODO
 * @Author Minghui Sun, Fengjie Gu
 * @Version 1.0
 */
//不要用hashmap，hashmap默认按照ASCII的顺序排列，找到的不一定是你Sring顺序里的第一个只出现一次的值！！
public class uniqueChar {
    public char findUniqueChar(String str){
        char result = 0;
        if(str == null || str.trim().length()==0)return '0';
        HashMap map = new HashMap<Character, Integer>(256);
        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (map.containsKey(c)){
                Integer count = (Integer) map.get(c);
                map.put(c,count+1);
            }else {
                map.put(c,1);
            }
            i++;
        }
        if(!map.containsValue(1)) return '0';
        for (Object key:map.keySet()){
            if (map.get(key).equals(1))
                result = (char) key;
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        uniqueChar machine = new uniqueChar();
        char result = machine.findUniqueChar("gooale");
        System.out.println(result);
    }

}
