import java.util.Arrays;

/**
 * @Classname PokerProblem
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class PokerProblem {
    public boolean isContinous(int[] hands){
        if (hands == null|| hands.length <1) return false;
        Arrays.sort(hands);
        int i = 0;
        int former = -1;
        int totalGap = 0;
        int totalJoker = 0;
        while (i<hands.length){
            if (hands[i] == 0){
                totalJoker++;
                continue;
            }
            if (hands[i] == former)
                return false;
            if (former == -1){
                former = hands[i];
            }
            int gap = hands[i] - former;
            former = hands[i];
            totalGap +=gap;
            i++;
        }
        return (totalJoker>=totalGap);
    }
}
