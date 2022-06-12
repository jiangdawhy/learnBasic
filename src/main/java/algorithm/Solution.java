package algorithm;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static String[] permutation(String s) {
        if(s == null || s.length() == 0) return new String[0];
        boolean[] visited = new boolean[s.length()];
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(ans, sb, s, visited);

        String[] res = new String[ans.size()];
        for(int i = 0; i < ans.size(); i++) res[i] = ans.get(i);

        return res;
    }

    private static void helper(List<String> ans, StringBuilder sb, String s, boolean[] visited){
        if(sb.length() == s.length()){
            String tmp = sb.toString();
            ans.add(tmp);
            return;
        }

        for(int i = 0; i < s.length(); i++){
            if(!visited[i]){
                sb.append(s.charAt(i));
                visited[i] = true;
                helper(ans, sb, s, visited);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);

        
    }
}