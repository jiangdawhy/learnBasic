package singleton;

/**
 * 懒汉式  线程不安全
 * 等于空判断的时候可能进去多个线程
 */
public class S2 {
    private static S2 s2;
    private S2(){}
    public static S2 getInstance(){
        if(s2 == null){
            s2 = new S2();
        }
        return s2;
    }
}
