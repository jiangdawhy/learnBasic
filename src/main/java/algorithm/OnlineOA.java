package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OnlineOA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int rules_count = sc.nextInt();
        String skip = sc.nextLine();
        String s = sc.nextLine();
        List<int[]> rules = new ArrayList<>();

        for(int i = 0; i < rules_count; i++){
            int char_count = sc.nextInt();
            int score = sc.nextInt();
            int[] tmp = new int[2];
            tmp[0] = char_count;
            tmp[1] = score;
            rules.add(tmp);
        }

        String[] arr = s.split("0");
        int ans = 0;
        for(String tmp : arr){
            ans += helper(tmp.length(), rules);

        }
        System.out.println(ans);





    }

    public static int helper(int len, List<int[]> rules){
        int dp[] = new int[len + 1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < rules.size(); j++){
                int count = rules.get(j)[0];
                int score = rules.get(j)[1];
                if(i - count >= 0){
                    dp[i] = Math.max(dp[i], score + dp[i - count]);
                }
            }
        }
        return dp[dp.length - 1];
    }
}
