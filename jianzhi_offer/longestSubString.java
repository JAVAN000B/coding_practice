/**
 * @Classname longestSubString
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class longestSubString {

    public int longestLength(String str) {
        int currentLen = 1;
        int MaxLen = 0;
        int length = str.length();
        int[] alphabets = new int[26];
        for (int i = 0; i < 26; ++i) alphabets[i] = -1;
        int j = 0;
        while (j < length){
            int visited = str.charAt(j) - 'a';
            if (alphabets[visited]<0){
                alphabets[visited] = j;
                currentLen++;
            }else {
                if (j-alphabets[visited]>currentLen)
                    currentLen++;
                else currentLen =1;
            }
            if (currentLen>MaxLen) MaxLen = currentLen;
            j++;
        }

        return MaxLen;
    }


}
