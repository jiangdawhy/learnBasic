package singleton;

/**
 * 饿汉式 直接新建一个对象
 * 最简单的写法 没有线程安全问题
 */
public class S1 {
    private static S1 s1 = new S1();
    private S1(){ }
    public static S1 getInstance(){
        return s1;
    }

    public static void main(String[] args) {
        S1 i1 = S1.getInstance();
        S1 i2 = S1.getInstance();
        System.out.println(i1 == i2);
    }
}
