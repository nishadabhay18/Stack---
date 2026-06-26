class Solution {
    // TC-> O(n) SC-> O(n)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        // In NSE we dont push -1 instead of push length bcoz while calculating area it will through wrong index.
        int[] nse = new int[n];
        st.push(n-1);
        nse[n-1] = n;
        for(int i=n-2; i>=0; i--){
            while(st.size() > 0 && heights[st.peek()] >= heights[i]) st.pop();
            if(st.size() == 0) nse[i]=n;
            else nse[i] = st.peek();
            st.push(i);
        }
        while(st.size() > 0) st.pop();
        int[] pse = new int[n];
        st.push(0);
        pse[0] = -1;
        for(int i=1; i<n; i++){
            while(st.size()>0 && heights[st.peek()] >= heights[i]) st.pop();
            if(st.size() == 0) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }
        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int area = heights[i] * (nse[i] - pse[i] - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}