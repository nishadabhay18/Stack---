class Solution {
    // TC-> O(n) SC-> O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        nge[n-1]=-1;
        st.push(n-1);
        for(int i=n-2; i>=0; i--){
            int ele = temperatures[i];
            while(st.size() != 0 && ele >= temperatures[st.peek()]) st.pop();
            if(st.size() == 0) nge[i] = -1;
            else nge[i] = st.peek();
            st.push(i);
        }
        for(int i=0; i<n; i++){
            if(nge[i] != -1) nge[i] -= i;
            else nge[i] = 0;
        }
        return nge;
    }
}
