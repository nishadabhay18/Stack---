class Solution {
    // TC-> O(n) SC-> O(n)
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            int curr = asteroids[i];
            boolean destroyed = false;
            while(st.size() != 0 && st.peek()>0 && asteroids[i]<0){ // now can collide
                if(Math.abs(curr) > Math.abs(st.peek())){
                    st.pop();
                    continue;
                }
                else if(Math.abs(curr) == Math.abs(st.peek())) st.pop();
                destroyed = true;
                break;
            }
            if(destroyed == false) st.push(curr);
        }
        int[] ans = new int[st.size()];
        for(int i=ans.length-1; i>=0; i--) ans[i] = st.pop();
        return ans;
    }
}