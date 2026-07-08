class Solution {
    // TC-> O(n) SC-> O(n)
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums)-sumSubarrayMins(nums);
    }
    public long sumSubarrayMaxs(int[] nums){
        int n = nums.length;
        int[] pge = new int[n];
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        pge[0] = -1;
        st.push(0);
        for(int i=1; i<n; i++){
            while(st.size() != 0 && nums[st.peek()] < nums[i]) st.pop();
            if(st.size() == 0) pge[i] = -1;
            else pge[i] = st.peek();
            st.push(i);
        }
        st.clear();
        nge[n-1] = n;
        st.push(n-1);
        for(int i=n-2; i>=0; i--){
            while(st.size() != 0 && nums[st.peek()] <= nums[i]) st.pop();
            if(st.size() == 0) nge[i]=n;
            else nge[i]=st.peek();
            st.push(i);
        }
        long result=0;
        for(int i=0; i<n; i++){
            int left = i-pge[i], right = nge[i]-i;
            result += (long) nums[i] * left * right;
        }
        return result;
    }
    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
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
            int left = i-pse[i], right = nse[i]-i;
            result += (long) arr[i] * left * right;
        }
        return result;
    }
}