class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int top = s.pop(); // Remove top element
            sort(s); // Sort the remaining stack
            insertSorted(s, top); // Insert the popped element in sorted order
        }
        return s;
    }
    private void insertSorted(Stack<Integer> s, int element) {
        if (s.isEmpty() || s.peek() <= element) s.push(element);
        else {
            int temp = s.pop();
            insertSorted(s, element);
            s.push(temp);
        }
    }
}