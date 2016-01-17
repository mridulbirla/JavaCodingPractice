import java.util.*;

public class MinHeap{

	private List<Integer> heap_array=new ArrayList<Integer>();

	public void printHeap(){
		for (int i = 1; i < heap_array.size(); i++) {
	    int value = heap_array.get(i);
	 	  System.out.print(value+",");
	}
	System.out.println("");
	}

	public int getHeapSize(){
		return heap_array.size();
	}
	public void insertElement(int element){

	}
	public void insertArray(int[] elements){
		int position=1;
		heap_array.add(-100000);
		for(int i=0;i<elements.length;i++){
			heap_array.add(elements[i]);
			if(i!=0){
				bubbleUp(position);
			}
			//printHeap();
			position++;
		}
	}
	public int extractMinimum(){
		int val=heap_array.get(0);
		swapValues(1,heap_array.size()-1);
		heap_array.remove(heap_array.size()-1);
		sinkDown(1);
		return val;
	}
	public void sinkDown(int index){
		if(2*index < heap_array.size()){

		if (heap_array.get(index)> heap_array.get(2*index) || heap_array.get(index)> heap_array.get(2*index +1)){
			
			if (heap_array.get(2*index)<= heap_array.get(2*index +1)){
				swapValues(index,2*index);
				sinkDown(2*index);
			}else if(heap_array.get(2*index) > heap_array.get(2*index +1)) {
				swapValues(index,(2*index +1));
				sinkDown(2*index+1);
			}

		}}

	}
	private void bubbleUp(int pos){
		

		while(pos>=1 && heap_array.get(pos/2) > heap_array.get(pos)){
			swapValues(pos,pos/2);
			pos=pos/2;
		}
	}
	private void swapValues(int index0, int index1){
		Collections.swap(heap_array, index0, index1);
	}

	public static void main(String args[]){

		int[] arr={3,2,2,1,7,8,4,10,16,12};
		MinHeap heap = new MinHeap();

		heap.insertArray(arr);
		heap.printHeap();
		int i=heap.extractMinimum();
		heap.printHeap();
	}

}