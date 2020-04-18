/**
 * @Classname cutRoles
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class cutRoles {
    public cutRoles(){}
    public int maxMultiply(int role){
        if (role<2) return 0;
        if (role < 3) return 1;
        if (role < 4) return 2;
        int max = 0;
        int[] products = new int[role+1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for (int i = 4; i < role+1; ++i) {
            max = 0;
            for (int j = 1; j <= i/2; j++) {
                int value = products[j]*products[i-j];
                if (max<value){
                    max = value;
                }
            }
            products[i] = max;
        }
        max = products[role];
        return max;
    }

    public int greedyMax(int role) {
        if (role<2) return 0;
        if (role < 3) return 1;
        if (role < 4) return 2;
        int max =1;
        while (role>=5){
            role -=3;
            max *= 3;
        }
        max *=role;

        return max;
    }

    public static void main(String[] args) {
        cutRoles cutRole = new cutRoles();
        int max = cutRole.maxMultiply(8);
        int max2 = cutRole.greedyMax(8);
        System.out.println(max);
        System.out.println(max2);
    }

}
