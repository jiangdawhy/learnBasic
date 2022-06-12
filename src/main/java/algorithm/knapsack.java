package algorithm;

public class knapsack {
    public static void main(String[] args) {
        int limit = 10;
        int[] weight = {2, 3,4,7};
        int[] val = {1,3,5,9};
        int res1 = zeroOneKnapsack(weight, val, limit);
        int res2 = zeroOneKnapsack2(weight, val, limit);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println("--------------");
        int res3 = completeKnapsack(weight, val, limit);
        int res4 = completeKnapsack2(weight, val, limit);
        System.out.println(res3);
        System.out.println(res4);

    }

    public static int zeroOneKnapsack(int[] weights, int[] values, int capacity){
        // 为什么需要加1? 因为需要引用到dp[i - 1][j]这种情况, 需要加一位
        // i 代表第 i 个物品, j 代表当前背包的重量
        // dp[i][j]代表 如果使用第1到第i个物品来拼凑出j重量, 最多能拼出多少钱
        int[][] dp = new int[weights.length + 1][capacity + 1];

        // 用weights[i - 1]和values[i - 1]是因为前面dp数组行和列都多了一位
        // 算当前的重量和物品价值的时候就要相应地减去一位
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j - weights[i - 1] < 0){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                }
            }
        }

        return dp[weights.length][capacity];


    }



    public static int zeroOneKnapsack2(int[] weights, int[] values, int capacity){
        // 这个方法只用一位数组
        int[] dp = new int[capacity + 1];


        for(int i = 1; i <= weights.length; i++){
            for(int j = capacity; j >= 1; j--){
                //不用考虑 j - weights[i - 1] < 0 的情况
                //如果那样的话dp[i][j] = dp[i - 1][j]
                //数据其实已经存在dp[j]中了
                //我们只在有需要的时候覆盖
                if(j >= weights[i - 1])
                    dp[j] = Math.max(dp[j], values[i - 1] + dp[j - weights[i - 1]]);
            }
        }

        return dp[capacity];
    }

    //复杂度为O(n^3)的做法
    public static int completeKnapsack(int[] weights, int[] values, int capacity){

        int[] dp = new int[capacity + 1];

        //加了一层循环, 对每一个物品尽可能地多取
        for(int i = 1; i <= weights.length; i++){
            for(int j = capacity; j >= 1; j--){
               for(int k = 0; k <= j / weights[i - 1]; k++)
                    dp[j] = Math.max(dp[j], k * values[i - 1] + dp[j - k * weights[i - 1]]);
            }
        }

        return dp[capacity];
    }


    //复杂度为O(n^2)的做法
    public static int completeKnapsack2(int[] weights, int[] values, int capacity){

        //dp[i][j] = max(dp[i - 1][j], dp[i][j - w[i]] + c[i])
        //因为物品i能够被取无数次, 所以是dp[i][j - w[i]] + c[i] 而不是 dp[i - 1][j - w[i]] + c[i]

        int[] dp = new int[capacity + 1];


        for(int i = 1; i <= weights.length; i++){
            for(int j = 1; j <=  capacity; j++){
                if(j - weights[i - 1] >= 0)
                    //这个转移方程和01背包完全一样
                    //但是注意到这个的for循环是顺序的而不是逆序的
                    //这次的dp[j - weights[i - 1]]指的是使用1 到 当前物品(i)所能获得的最大值
                    //而01背包的dp[j - weights[i - 1]]指的是使用1 到i-1个物品所能获得的最大值
                    //dp[j]则和01背包一样, 能表示不适用第i个物品, 只使用1 到i-1个物品所能获得的最大值
                    dp[j] = Math.max(dp[j], values[i - 1] + dp[j - weights[i - 1]]);
            }
        }

        return dp[capacity];
    }
}
