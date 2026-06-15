class Solution {
    // TC-> O(n) SC-> O(n)
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String s: tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int val2=st.pop(), val1=st.pop();
                switch(s){
                    case "+":
                        st.push(val1+val2);
                        break;
                    case "-":
                        st.push(val1-val2);
                        break;
                    case "*":
                        st.push(val1*val2);
                        break;
                    case "/":
                        st.push(val1/val2);
                        break;
                }
            }else st.push(Integer.parseInt(s));
        }
        return st.pop();
    }
}