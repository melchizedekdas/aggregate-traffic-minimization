package datastructure;

import beans.AugmentedVertex;

public interface PriorityQueue {
	public boolean isEmpty();
	public void insert(AugmentedVertex node);
	public AugmentedVertex deleteMin();
	public void heapify(AugmentedVertex node);
}
