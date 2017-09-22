// Problem 346 Moving Average From Data Stream

class MovingAverage {
    Queue<Integer> q;
    double sum;
    int len;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList<>();
        len = size;
    }
    
    public double next(int val) {
        if(q.size() == len){
            sum = sum - q.poll();
        }
        q.offer(val);
        sum += val;
        return sum/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */