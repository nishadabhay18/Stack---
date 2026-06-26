class Solution {
    // TC-> O(n) SC-> O(n)
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        ans[n-1] = 0;
        st.push(heights[n-1]);
        for(int i=n-2; i>=0; i--){
            while(st.size() > 0 && heights[i] > st.peek()){
                ans[i]++;
                st.pop();
            }
            if(st.size() != 0) ans[i]++;
            st.push(heights[i]);
        }
        return ans;
    }
}