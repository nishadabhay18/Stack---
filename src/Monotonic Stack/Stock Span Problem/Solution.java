class Solution {
    // Function to calculate the span of stock's price for all n days.
    // TC-> O(n) SC-> O(n)
    public ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            while(st.size() > 0 && arr[i] >= arr[st.peek()]) st.pop();
            if(st.size() == 0) ans.add(-1);
            else ans.add(st.peek());
            st.push(i); // In Stack we store indices of array.
        }
        for(int i=0; i<n; i++){
            if(ans.get(i)==-1) ans.set(i, i+1);
            else ans.set(i, i-ans.get(i));
        }
        return ans;
    }
}