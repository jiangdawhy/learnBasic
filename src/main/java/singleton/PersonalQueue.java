package singleton;

import java.util.ArrayDeque;
import java.util.Deque;

public class PersonalQueue {
    public static void main(String[] args) {
        //dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + nums[i][j]
    }

    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();

    public int get(){
        if(!stack2.isEmpty()) return stack2.removeLast();
        else{
            if(stack1.isEmpty()) return -1; //抛出异常
            while(!stack1.isEmpty()) stack2.addLast(stack1.removeLast());
        }
        return stack2.removeLast();
    }

    public void push(int num){
        stack1.addLast(num);
    }





}
