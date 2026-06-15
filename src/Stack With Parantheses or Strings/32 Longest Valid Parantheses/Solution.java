class Solution {
    // TC-> O(n) SC-> O(n)
    public int longestValidParentheses(String str) {
        int n = str.length();
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(ch == ')' && st.size() == 0) continue;
            else if(ch == '(') st.push(ch);
            else if(st.size() > 0){
                char dh = st.peek();
                if(dh == '(' && ch == ')'){
                    st.pop();
                    count += 2;
                }
            }
        }
        return count;
    }

    // TC-> O(n) SC-> O(n)
    public int longestValidParentheses(String str) {
        int n = str.length();
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxLen = 0;
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(ch == '(') st.push(i);
            else{
                st.pop();
                if(st.size() == 0) st.push(i);
                else maxLen = Math.max(maxLen, i - st.peek());
            }
        }
        return maxLen;
    }
}