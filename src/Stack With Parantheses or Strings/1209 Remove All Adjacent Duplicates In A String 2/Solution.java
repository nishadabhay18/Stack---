class Solution {
    public class Pair{
        char ele;
        int freq;
        Pair(char ele, int freq){
            this.ele = ele;
            this.freq = freq;
        }
        public char getChar(){
            return this.ele;
        }
        public int getCount(){
            return this.freq;
        }
    }
    // TC-> O(n) SC-> O(n)
    public String removeDuplicates(String str, int k) {
        int n = str.length();
        Stack<Pair> st = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(st.size() == 0 || st.peek().getChar() != ch) st.push(new Pair(ch, 1));
            else if(st.size() != 0 && st.peek().getChar() == ch){
                int count=st.peek().getCount() + 1;
                st.pop();
                if(count != k) st.push(new Pair(ch, count));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(st.size() != 0){
            Pair p = st.pop();
            for(int i=0; i<p.freq; i++) sb.append(p.ele);
        }
        return sb.reverse().toString();
    }
}