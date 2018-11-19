// Question 295 Find Median from Data Stream

class MedianFinder {
    PriorityQueue<Integer> small, large;
    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        large.offer(num);
        small.offer(-large.poll());
        if (large.size() < small.size()) {
            large.offer(-small.poll());
        }
    }
    
    public double findMedian() {
        if (large.size() > small.size()) {
            return (double) large.peek();
        } else {
            return (large.peek()) / 2.0 - (small.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */