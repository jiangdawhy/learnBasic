package whatever;

import java.io.*;
import java.util.List;

public class readImg {
    public static void main(String[] args) throws IOException {
        int[] arr = {4,202,24,15,13,14,56,201,18,40,213,1,5,12,21,23,26,28,30,36,42,43,67,142,178,280,269};
        String sourceStr = "C:\\Users\\Hongyi Wang\\Desktop\\new\\whole\\";
        String destStr = "C:\\Users\\Hongyi Wang\\Desktop\\new\\tmp\\";
        for(int i : arr){
            String tmp = i + ".jpg";
            File source = new File(sourceStr + tmp);
            File dest = new File(destStr + tmp);
            copyFileUsingStream(source, dest);
        }

    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
