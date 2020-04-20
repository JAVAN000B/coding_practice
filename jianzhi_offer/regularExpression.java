/**
 * @Classname regularExpression
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class regularExpression {
    public regularExpression(){}

    public boolean match(String target, String expression){
        if (target == null||expression==null) return false;
        return matchCore(target,expression,0,0);
    }

    private boolean matchCore(String target, String expression, int i, int j) {
        if (i==target.length() && j == expression.length()) return true;
        if (j == expression.length()) return false;
        if (expression.charAt(j)=='.') return matchCore(target, expression,i+1,j+1);
        if (expression.charAt(j)=='*') return matchCore(target, expression, i, j+1) || matchCore(target, expression, i, j-1);
        if (target.charAt(i)==target.charAt(j)) return matchCore(target, expression, i+1, j+1);
        return false;
    }

    public static void main(String[] args) {
        regularExpression Regular = new regularExpression();
        boolean test = Regular.match("a","a*");
        System.out.println("finish!!!");
    }

}
