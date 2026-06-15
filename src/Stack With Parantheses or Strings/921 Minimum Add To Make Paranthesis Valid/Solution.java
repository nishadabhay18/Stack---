class Solution {
    // TC-> O(n) SC-> O(n)
    public int minAddToMakeValid(String str) {
        int n = str.length();
        int count = 0;
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(ch == ')'){
                if(st.size() != 0 && st.peek() == '(') st.pop();
                else st.push(ch);
            }else st.push(ch);
        }
        return st.size();
    }

    // TC-> O(n) SC-> O(1)
    public int minAddToMakeValid(String str) {
        int n = str.length();
        int open = 0, add = 0;
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(ch == '(') open++;
            else{
                if(open>0) open--;
                else add++;
            }
        }
        return add+open;
    }
}