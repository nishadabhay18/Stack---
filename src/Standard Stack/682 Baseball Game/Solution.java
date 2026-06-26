class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        for(String op:operations){
            switch(op){
                case "C":
                    st.pop();
                    break;
                case "D":
                    st.push(st.peek()*2);
                    break;
                case "+":
                    int top=st.pop();
                    int secondTop=st.pop();
                    int topest=top+secondTop;
                    st.push(secondTop);
                    st.push(top);
                    st.push(topest);
                    break;
                default:
                    st.push(Integer.parseInt(op));
                    break;
            }
        }
        int ans=0;
        while(st.size()!=0){
            int top=st.pop();
            ans+=top;
        }
        return ans;
    }
}