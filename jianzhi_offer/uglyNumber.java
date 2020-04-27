/**
 * @Classname uglyNumber
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class uglyNumber {

    public int findNthUglyNumber(int n) {
        if (n<1) return 0;
        if (n==1) return 1;
        int[] uglyList = new int[n];
        uglyList[0] = 1;
        int currentIndex = 0;
        int twoTarget = uglyList[0];
        int threeTarget = uglyList[0];
        int fiveTarget = uglyList[0];
        while (uglyList[n-1]==0){
            currentIndex++;
            uglyList[currentIndex] = findMin(twoTarget,threeTarget,fiveTarget);
            while (twoTarget*2<=uglyList[currentIndex]){
                twoTarget ++;
            }
            while (threeTarget*3<=uglyList[currentIndex]){
                threeTarget ++;
            }
            while (fiveTarget*5<=uglyList[currentIndex]){
                fiveTarget ++;
            }

        }
        return uglyList[n-1];
    }

    public int findNthUglyNumber2(int n) {
        if (n<1) return 0;
        if (n==1) return 1;
        int[] uglyList = new int[n];
        uglyList[0] = 1;
        int currentIndex = 0;
        int twoTarget = 0;
        int threeTarget = 0;
        int fiveTarget = 0;
        while (uglyList[n-1]==0){
            currentIndex++;
            uglyList[currentIndex] = findMin(uglyList[twoTarget],uglyList[threeTarget],uglyList[fiveTarget]);
            while (uglyList[twoTarget]*2<=uglyList[currentIndex]){
                twoTarget ++;
            }
            while (uglyList[threeTarget]*3<=uglyList[currentIndex]){
                threeTarget ++;
            }
            while (uglyList[fiveTarget]*5<=uglyList[currentIndex]){
                fiveTarget ++;
            }

        }
        return uglyList[n-1];
    }

    public int findMin(int a, int b, int c){
        int d = Math.min(a*2,b*3);
        return Math.min(d,c*5);
    }

    public static void main(String[] args) {
        uglyNumber machine = new uglyNumber();
        int value =machine.findNthUglyNumber(1500);
        int value2 = machine.findNthUglyNumber2(1500);
        System.out.println(value+","+value2);
    }

}
