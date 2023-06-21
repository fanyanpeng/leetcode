import java.util.*;

public class T146 {
    public static void main(String[] args){
        Solution146 solution=new Solution146();

        System.out.println(solution);

    }
}

// 146. LRU 缓存
class Solution146 {



}


class LRUCache_3{
    Integer capacity;


    class DeNode{
        int key;
        int value;
        DeNode left;    //时间小的在前面，时间大的在后面
        DeNode right;
    }

    Map<Integer,DeNode> nodeMap=new HashMap<>();
    DeNode head,tail;

    // 添加节点，添加在最右端
    private DeNode addNode(DeNode deNode){
        deNode.right=deNode.left=null;
        if(head==null){ // if no element
            head=tail=deNode;
        }else { // add one to the tail
            tail.right=deNode;
            deNode.left=tail;
            tail = deNode;
        }
        return deNode;
    }

    // 删除节点
    private void removeNode(DeNode node){
        if(head==tail){
            head=tail=null;
            return;
        }
        if(node == head){
            head=head.right;
        } else if(node == tail){
            tail=tail.left;
        } else {
            node.left.right=node.right;
            node.right.left=node.left;
        }
    }


    public LRUCache_3(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if(nodeMap.containsKey(key)){
            DeNode node = nodeMap.get(key);
            removeNode(node);
            addNode(node);
            return node.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(nodeMap.containsKey(key)){
            DeNode node = nodeMap.get(key);
            removeNode(node);
            node.value=value;
            addNode(node);
            return;
        }
        if(nodeMap.size()>=capacity){
            nodeMap.remove(head.key);
            removeNode(head);
        }
        DeNode node=new DeNode();
        node.key=key;
        node.value=value;
        addNode(node);
        nodeMap.put(key,node);
    }
}







// LinkedHash
class LRUCache2{
    Integer capacity;
    LinkedHashMap<Integer,Integer> cache;

    public LRUCache2(int capacity) {
        this.capacity=capacity;
        cache = new LinkedHashMap<Integer,Integer>(capacity,1.0F,true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size()>capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        cache.put(key,value);
    }
}

// 超时版本
class LRUCache1 {

    class ValueTime{
        int key;
        int value;
        int time;
    }
    Integer capacity;
    Map<Integer,ValueTime> cache = new HashMap<>();

    int time;

    public LRUCache1(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        updateTime(key);
        return cache.get(key).value;
    }


    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.get(key).value = value;
        }else {
            if(cache.size()>=capacity){
                cache.remove(getOldest());
            }
            ValueTime valueTime=new ValueTime();
            valueTime.key=key;
            valueTime.value=value;
            cache.put(key,valueTime);
        }
        updateTime(key);
    }

    private int getOldest(){
        return cache.values().stream().min(Comparator.comparingInt(o->o.time)).get().key;
    }

    private void updateTime(int key){
        cache.get(key).time = ++time;
    }
}


// put或者get都算作是更新时间戳。当放入时，需要替换，则寻找时间戳最小的，删除。
class LRUCache {

    class KeyTime{
        int key;
        int time;
    }

    PriorityQueue<KeyTime> keyTimePriorityQueue = new PriorityQueue<>(Comparator.comparingInt(o->o.time));
    Integer capacity;
    Map<Integer,Integer> cache = new HashMap<>();
    Map<Integer,KeyTime> keyTimeMap=new HashMap<>();

    int time;

    public LRUCache(int capacity) {
        this.capacity=capacity;

    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        updateTime(key);
        return cache.get(key);
    }


    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key,value);
            updateTime(key);
            return;
        }

        if(cache.size() >= capacity){ // 已满，需要替换
            KeyTime oldest = keyTimePriorityQueue.poll();
            cache.remove(oldest.key);
            keyTimeMap.remove(oldest.key);
        }

        //然后填充
        updateTime(key);
        cache.put(key,value);


    }

    private void updateTime(int key){
        time++;
        if(!keyTimeMap.containsKey(key)){
            KeyTime keyTime = new KeyTime();
            keyTime.time=time;
            keyTime.key=key;
            keyTimeMap.put(key,keyTime);
            keyTimePriorityQueue.add(keyTime);
        }
        else {
            KeyTime keyTime = keyTimeMap.get(key);
            keyTimePriorityQueue.remove(keyTime);
            keyTimePriorityQueue.add(keyTime);
            keyTime.time=time;
        }
        // 缓存中有，则标记时间
//        keyTimeMap.put(key,time);
    }
}