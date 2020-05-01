/**
 * @Classname maxSubMatrix
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class maxSubMatrix {

    public int MaxSub(int[] list) {
        if (list == null||list.length<1) return 0;
        int currentSum = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int value : list) {
            if (currentSum <= 0)
                currentSum = value;
            else
                currentSum += value;
            if (currentSum > maxValue)
                maxValue = currentSum;
        }
        return maxValue;
    }
}
