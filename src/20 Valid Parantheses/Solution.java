class Solution {
    // TC-> O(n) SC-> O(n)
    public boolean isValid(String str) {
        Stack <Character> st = new Stack<>();
        int n= str.length();
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(ch =='(' || ch=='[' || ch=='{') st.push(ch);
            else if (st.size()>0){
                char dh= st.peek();
                if(ch== ')'){
                    if(dh=='(') st.pop();
                    else return false;
                }
                else if(ch ==']'){
                    if(dh=='[') st.pop();
                    else return false;
                }
                else{
                    if(dh=='{') st.pop();
                    else return false;
                }
            }
            else return false;
        }
        if(st.size()!=0) return false;
        return true;
    }
}