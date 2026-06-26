class Solution {
    // TC-> O(n) SC-> O(n)
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        nse[n-1] = -1;
        st.push(prices[n-1]);
        for(int i=n-2; i>=0; i--){
            while(st.size() != 0 && st.peek() > prices[i]) st.pop();
            if(st.size() == 0) nse[i] = -1;
            else nse[i] = st.peek();
            st.push(prices[i]);
        }
        for(int i=0; i<n; i++){
            if(nse[i] != -1) nse[i] = prices[i] - nse[i];
            else nse[i] = prices[i];
        }
        return nse;
    }
}