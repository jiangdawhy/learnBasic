package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class XiaoHongShuOA {
    public static void main(String[] args) {
        //将数组排序所需的最小交换次数

        int[] arr = {1,5,4,3,2};
        // {2,3,5,7}
        int[] arr2 = new int[arr.length];
        for(int i = 0; i < arr.length; i++) arr2[i] = arr[i];

        Arrays.sort(arr2);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr2.length; i++){
            map.put(arr2[i], i);
        }

        int count = 0;
        for(int i = 0; i < arr.length; i++){
            //已经在该在的位置上了  跳过
            if(map.get(arr[i]) == i) continue;

            while(map.get(arr[i]) != i){
                swap(arr, i, map.get(arr[i]));
                count++;
            }
        }

        System.out.println(count);

    }

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
