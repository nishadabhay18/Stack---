class FreqStack {
    // TC-> O(log n) SC-> O(n)
    public class Triplet implements Comparable<Triplet>{
        int ele;
        int freq;
        int time;
        Triplet(int ele, int freq, int time){
            this.ele = ele;
            this.freq = freq;
            this.time = time;
        }
        public int compareTo(Triplet t){
            if(this.freq == t.freq) return this.time-t.time;
            return this.freq-t.freq;
        }
    }
    PriorityQueue<Triplet> pq = new PriorityQueue<>(Collections.reverseOrder());
    HashMap<Integer,Integer> mp = new HashMap<>();
    int time = 0;
    public FreqStack() {}
    public void push(int val) {
        if(mp.containsKey(val)) mp.put(val, mp.get(val) + 1);
        else mp.put(val, 1);
        pq.add(new Triplet(val, mp.get(val), time++));
    }

    public int pop() {
        Triplet t = pq.remove();
        mp.put(t.ele, mp.get(t.ele) - 1);
        if(mp.get(t.ele) == 0) mp.remove(t.ele);
        return t.ele;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */