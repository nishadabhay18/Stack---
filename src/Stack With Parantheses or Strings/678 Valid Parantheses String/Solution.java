class Solution {
    // RECURSION TC->O(3^n) SC->O(n)
    public boolean checkValidString(String str) {
        int n = str.length();
        return helper(str, 0, 0);
    }
    public boolean helper(String str, int idx, int count){
        int n=str.length();
        if(count<0) return false;
        if(idx == n) return count == 0 ? true : false;
        if(str.charAt(idx) == '(') return helper(str, idx+1, count+1);
        if(str.charAt(idx) == ')') return helper(str, idx+1, count-1);
        return helper(str, idx+1, count+1) || helper(str, idx+1, count-1) || helper(str, idx+1, count);
    }

    // RECURSION + MEMOIZATION TC->O(n*n) SC->O(n*n)+O(n)
    public boolean checkValidString(String str) {
        int n=str.length();
        Boolean[][] dp = new Boolean[n][n];
        return helper(str, 0, 0, dp);
    }
    public boolean helper(String str, int idx, int count, Boolean[][] dp){
        int n=str.length();
        if(count<0) return false;
        if(idx == n) return count == 0 ? true : false;
        if(dp[idx][count] != null) return dp[idx][count];
        if(str.charAt(idx) == '(') return dp[idx][count] = helper(str, idx+1, count+1, dp);
        if(str.charAt(idx) == ')') return dp[idx][count] = helper(str, idx+1, count-1, dp);
        return dp[idx][count] = helper(str, idx+1, count+1, dp) || helper(str, idx+1, count-1, dp) || helper(str, idx+1, count, dp);
    }

    // TC->O(n) SC->O(1) Greedily
    public boolean checkValidString(String str){
        int n=str.length();
        int min=0, max=0;
        for(int i=0; i<n; i++){
            if(str.charAt(i) == '(') min++; max++;
            else if(str.charAt(i) == ')') min--; max--;
            else min--; max++;
            if(min<0) min=0;
            if(max<0) return false;
        }
        return (min == 0);
    }
}