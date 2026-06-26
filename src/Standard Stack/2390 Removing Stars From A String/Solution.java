class Solution {
    // TC-> O(n) SC-> O(n)
    public String removeStars(String str) {
        int n = str.length();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii >= 97 && ascii <= 122) st.push(ch);
            else st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(st.size() != 0) sb.append(st.pop());
        sb.reverse();
        return sb.toString();
    }
}