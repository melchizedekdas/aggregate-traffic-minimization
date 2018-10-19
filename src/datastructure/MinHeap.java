package datastructure;

import java.util.ArrayList;
import java.util.List;

import beans.AugmentedVertex;

public class MinHeap {
	int size=0;
	List<AugmentedVertex> list=new ArrayList<AugmentedVertex>();
	public boolean isEmpty() {
		return size==0;
	}
	public void insert(AugmentedVertex node) {
		if(size<list.size()) {
			list.set(size, node);
			size++;
		}
		else {
			list.add(node);
			size++;
		}
		node.setMinHeapIndex(size);
		heapify(node);
	}
	public AugmentedVertex deleteMin() {
		if(size==0) {
			return null;
		}
		AugmentedVertex node=list.get(0);
		list.set(0, list.get(--size));
		list.get(0).setMinHeapIndex(1);
		heapify(list.get(0));
		return node;
	}
	public void heapify(AugmentedVertex node) {
		int index=node.getMinHeapIndex();
		while((index>1) && (list.get(index/2-1).getValue()>node.getValue())) {
			AugmentedVertex temp= list.get(index/2-1);
			
			node.setMinHeapIndex(index/2);
			list.set(index/2-1,node);
			
			temp.setMinHeapIndex(index);
			list.set(index-1, temp);
			
			index/=2;
		}
		while(index*2<=size) {
			int smallerChildIndex=index*2;
			if(smallerChildIndex<size && list.get(smallerChildIndex).getValue()<list.get(smallerChildIndex-1).getValue()) {
				smallerChildIndex++;
			}
			if(list.get(index-1).getValue()>list.get(smallerChildIndex-1).getValue()) {
				AugmentedVertex temp= list.get(smallerChildIndex-1);
				
				list.get(index-1).setMinHeapIndex(smallerChildIndex);
				list.set(smallerChildIndex-1, list.get(index-1));
				
				temp.setMinHeapIndex(index);
				list.set(index-1, temp);
				
				index=smallerChildIndex;
			}
			else {
				break;
			}
		}
		
	}

}
