# Find Median from Data Stream
class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int total;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
        minHeap = new PriorityQueue<>();
        total = 0;
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        if(minHeap.size() > maxHeap.size())
        maxHeap.add(minHeap.poll());

        total += 1;
    }
    
    public double findMedian() {
        if((total & 1) == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }else{
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */