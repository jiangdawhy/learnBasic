package singleton;

/**
 * enum 类型保证单例并且可以防止反序列化
 */
public enum S6 {
    INSTANCE;

    public static S6 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(S6.INSTANCE.hashCode());
            }).start();
        }
    }
}
