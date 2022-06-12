package singleton;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        int[] arr = {4,8,10,3,2,-10,99};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    private static void quickSort(int[] arr, int left, int right){
        if(left < right){
            int pIdx = partition(arr, left, right);
            quickSort(arr, left, pIdx - 1);
            quickSort(arr, pIdx + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        if(left < right){
            int less = left - 1;
//只有随机快排的平均时间复杂度是O(nlogn)

            Random r = new Random();
            int randomIdx = left + r.nextInt(right - left);
            swap(arr, randomIdx, right);
            int x = arr[right];
            for(int i = left; i <= right - 1; i++){
                if(arr[i] < x){
                    less++;
                    swap(arr, less, i);
                }
            }
            swap(arr, less + 1, right);
            return less + 1;
        }
        return -1;
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
