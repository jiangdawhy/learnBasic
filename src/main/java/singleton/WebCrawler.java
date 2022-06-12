package singleton;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import sun.net.www.http.HttpClient;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WebCrawler {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,3,4,5,5,7,7,9,10,56,32,48,22,14,16,13,14};
        int buckets = 3;
        List<Integer> bucket1 = new ArrayList<>();
        List<Integer> bucket2 = new ArrayList<>();
        List<Integer> bucket3 = new ArrayList<>();
        //取模, 放入不同的桶中, 桶的数量取决于内存的大小
        for (int i : arr) {
            if(i % buckets == 0) bucket1.add(i);
            else if(i % buckets == 1) bucket2.add(i);
            else bucket3.add(i);
        }
        //相同元素在同一个桶中, 对每个桶进行排序, 遇到相同的元素取出, 放入一个公共的桶中
        List<Integer> ans = new ArrayList<>();
        Collections.sort(bucket1);
        Collections.sort(bucket2);
        Collections.sort(bucket3);

        generateAnswer(ans, bucket1);
        generateAnswer(ans, bucket2);
        generateAnswer(ans, bucket3);

        for (Integer i : ans) {
            System.out.println(i);
        }
    }

    private static void generateAnswer(List<Integer> ans, List<Integer> bucket) {
        int pre = bucket.get(0);
        boolean isBreak = true;
        for(int i = 1; i < bucket.size(); i++){
            //遇到了重复的元素, 放入答案中  1,1,1,2,3
            if(isBreak && bucket.get(i).equals(pre)){
                ans.add(pre);
                isBreak = false;
            }else{
                isBreak = true;
                pre = bucket.get(i);
            }
        }

    }
}
