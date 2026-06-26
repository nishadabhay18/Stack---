class Solution {
    // TC-> O(n) SC-> O(n)
    public String minRemoveToMakeValid(String str) {
        int open = 0;
        // remove extra ')'
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()) {
            if(ch == '(') {
                open++;
                sb.append(ch);
            }
            else if(ch == ')') {
                if(open > 0) {
                    open--;
                    sb.append(ch);
                }
            }
            else sb.append(ch);
        }
        // remove extra '(' from RIGHT
        StringBuilder result = new StringBuilder();
        for(int i=sb.length()-1; i>=0; i--) {
            char ch = sb.charAt(i);
            if(ch == '(' && open>0) {
                open--;
                continue;
            }
            result.append(ch);
        }
        return result.reverse().toString();
    }
}