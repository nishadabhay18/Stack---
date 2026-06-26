class Solution {
    // TC-> O(n) SC-> O(1)
    public List<String> buildArray(int[] target, int num) {
        List<String> ans = new ArrayList<>();
        int i = 0, current = 1;
        while(i < target.length){
            ans.add("Push");
            if(current == target[i]) i++;
            else ans.add("Pop");
            current++;
        }
        return ans;
    }
}