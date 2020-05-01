/**
 * @Classname StringNumber
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class StringNumber {


    public boolean checkint(String target){
        if(target == null||target.length()==0) return false;
      int i = 0;
      int first = 0;
      int second = 0;
      int third = 0;
      while (i < target.length()) {
          if (target.charAt(i)=='+'||target.charAt(i)=='-'){
              if (first==0){
                  first++;
                  i++;
              }else {
                  return false;
              }
          }else {
              break;
          }
      }
      while (i<target.length()){
          if (target.charAt(i)>='0'&&target.charAt(i)<='9'){
              i++;
          } else if(target.charAt(i)=='.'){
              if (second ==0){
                  second++;
                  i++;
              }else return false;
          } else if (target.charAt(i)=='e'){
              if (third==0){
                  third++;
                  i++;
                  if (target.charAt(i)=='+'||target.charAt(i)=='-') i++;
              }else return false;
          }
      }
      return true;
    }

    public static void main(String[] args) {
        StringNumber string = new StringNumber();
        boolean result = string.checkint("+3.4e+5e");
        System.out.println(result);
    }

}
