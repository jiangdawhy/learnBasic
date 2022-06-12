package singleton;

/**
 * 懒汉式  线程安全但是效率特别低
 * synchronized也可以放在方法中, 同理,效率很低.
 */
public class S3 {
    private static S3 s3;
    private S3(){}
    public static S3 getInstance(){
        synchronized (S3.class){
            if(s3 == null){
                s3 = new S3();
            }
        }

        return s3;
    }
}
