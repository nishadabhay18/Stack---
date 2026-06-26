class Solution {
    // Function to find if there is a celebrity in the party or not.
    // TC-> O(n) SC-> O(n)
    public int celebrity(int mat[][]) {
        Stack<Integer> st = new Stack<>();
        int n = mat[0].length;
        for(int i=0; i<n; i++) st.push(i);
        while(st.size() > 1){
            int v1 = st.pop();
            int v2 = st.pop();
            if(mat[v1][v2] == 1) st.push(v2);
            else st.push(v1);
        }
        if(st.size() == 0) return -1;
        int potential = st.pop();
        for(int i=0; i<n; i++){
            if(i == potential) continue;
            if(mat[i][potential] == 0) return -1;
        }
        for(int j=0; j<n; j++){
            if(mat[potential][j] == 1) return -1;
        }
        return potential;
    }
}