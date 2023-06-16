import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author fanyanpeng
 * @date 2023/3/8 18:02
 */
public class t295 {

    public static void main(String[] args){

        MedianFinder obj =new MedianFinder();
        int[] ints = new int[]{1,2,3};
        for(int i:ints){
            obj.addNum(i);
            double param_2 = obj.findMedian();
            System.out.println(param_2);
        }

    }
}

class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
    PriorityQueue<Integer> maxHead = new PriorityQueue<>(Comparator.reverseOrder());

    public MedianFinder() {

    }

    public void addNum(int num) {
        // 若最小堆中没有数据，则插入最小堆。
        if(minHeap.size()==0){
            minHeap.add(num);
            return;
        }
        int minHeapMin = minHeap.peek();
        // 若数字大于最小堆的数字，插入最小堆
        if(num>=minHeapMin){
            minHeap.add(num);
        }
        // 若数字小于最小堆，插入最大堆
        if(num<minHeapMin){
            maxHead.add(num);
        }
        //若当前最大堆数量比最小堆数量大，则将最大堆的一个取出来，放到最小堆。
        if(maxHead.size()>minHeap.size()){
            minHeap.add(maxHead.poll());
        }

        if(minHeap.size() > maxHead.size()+1){
            maxHead.add(minHeap.poll());
        }

    }


    public double findMedian() {
        if(maxHead.size()==0){
            return 1.0* minHeap.peek();
        }
        // 若最小堆和最大堆数量相等，则返回平均值
        if(minHeap.size() == maxHead.size()){
            return 1.0*(minHeap.peek()+ maxHead.peek())/2;
        }
        // 若最小堆比最大堆数量多一个，则返回最小堆的最小值。
        if(minHeap.size() == maxHead.size()+1){
            return 1.0* minHeap.peek();
        }
        return 0.0;

    }
}
