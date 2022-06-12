package singleton;

/**
 * 懒汉式  双锁 线程安全效率高
 * 双重锁可能还要考虑 s4要不要加 volatile的问题
 * https://juejin.cn/post/6844903772892692487
 */
public class S4 {
    private static S4 s4;
    private S4(){}
    public static S4 getInstance(){
        if(s4 == null){
            synchronized (S4.class){
                //这里要判断空, 因为有可能其他线程已经过了第一个判断条件
                //而这时候如果不在这加判断的话, 会再new一个新的对象
                if(s4 == null){
                    s4 = new S4();
                }
            }
        }


        return s4;
    }
}
