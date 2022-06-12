package singleton;

/**
 * 静态内部类的方法
 *
 * 当一个类加载的时候 它的静态内部类是不会被加载的
 * 只有当被用到的时候才会加载
 *
 */
public class S5 {

    private S5(){}

    private static class InstanceHolder{
        private static S5 s5 = new S5();
    }
    public static S5 getInstance(){

        return InstanceHolder.s5;
    }
}
