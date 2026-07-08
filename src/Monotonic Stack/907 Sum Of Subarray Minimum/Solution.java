class Solution {
    // TC-> O(n) SC-> O(n)
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = (long)1e9 + 7;
        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        // Previous Smaller Element (strictly smaller)
        pse[0] = -1;
        st.push(0);
        for(int i=1; i<n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            if (st.isEmpty()) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }
        st.clear();
        // Next Smaller Element (smaller or equal)
        nse[n-1] = n;
        st.push(n-1);
        for (int i=n-2; i>=0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if (st.isEmpty()) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        long result = 0;
        for (int i=0; i<n; i++) {
            int left = i-pse[i];
            int right = nse[i]-i;
            long contribution = (long) arr[i] * left * right;
            result = (result + contribution) % mod;
        }
        return (int) result;
    }
}