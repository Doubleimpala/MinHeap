import java.util.ArrayList;
class MinHeap {
  public static ArrayList<Integer> heap = new ArrayList<Integer>();
  public static int inserted = 0;
  public static void insert(int insertMe) {    
    int store;
    if(heap.isEmpty()){
      heap.add(insertMe);
      inserted++;
      return;
    }
    heap.add(insertMe);
    inserted++;
    if(heap.get(inserted) < heap.get((inserted-1)/2)){
      store = heap.get((inserted-1)/2);
      heap.set((inserted-1)/2, heap.get(inserted));
      heap.set(inserted, store);
      inserted = (inserted-1)/2;
    }
  }
  public static int delete(){
    int curr = 0;
    int removed = heap.remove(0);
    int stored;
    heap.add(0,heap.remove(inserted));
    if(heap.get(curr)>heap.get(2*curr+1)){
      stored = heap.get(2*curr+1);
      heap.set(2*curr+1, heap.get(curr));
      heap.set(curr, stored);
      curr = 2*curr+1;
      return removed;
    } else if(heap.get(curr) > heap.get(2*curr+2)){
      stored = heap.get(2*curr+2);
      heap.set(2*curr+2, heap.get(curr));
      heap.set(curr, stored);
      curr = 2*curr+2;
      return removed;
    } else{
      return removed;
    }
  }
  public static int peek(){
    return heap.get(0);
  }
}