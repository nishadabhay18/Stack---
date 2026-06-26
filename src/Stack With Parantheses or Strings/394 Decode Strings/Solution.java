class Solution {
    // TC-> O(n+ o/p size) SC-> O(o/p size)
    public String decodeString(String str) {
        int n = str.length();
        Stack<Integer> num = new Stack<>();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            int ascii = (int)ch;
            int val = ch-'0';
            if(ascii>=48 && ascii<=57){ // for handling double digits
                if(!num.isEmpty() && i>0 && Character.isDigit(str.charAt(i-1))) val = num.pop() * 10 + val;
                num.push(val);
            }
            else if(ch == ']'){
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && st.peek() != '[') sb.append(st.pop());
                st.pop();
                sb.reverse();
                int k = num.pop();
                StringBuilder repeated = new StringBuilder();
                for(int j=0; j<k; j++) repeated.append(sb);
                String rep = repeated.toString();
                for(int x=0; x<rep.length(); x++) st.push(rep.charAt(x));
            }else st.push(ch);
        }
        StringBuilder result = new StringBuilder();
        while(!st.isEmpty()) result.append(st.pop());
        return result.reverse().toString();
    }
}