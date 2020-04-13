/**
 * @Classname SingletonPatternDemo
 * @Description 饿汉式
 * @Author Minghui Sun,
        * @Version 1.0
        */
public class SingleObject{
    private static SingleObject instance = new SingleObject();
    private SingleObject(){}
    public static SingleObject getInstance() {
        return instance;
    }
}