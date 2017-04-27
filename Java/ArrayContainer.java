package Algo.Test;

class ArrayContainer implements Comparable<ArrayContainer> {
	int[] arr;
	int index;
 
	public ArrayContainer(int[] arr, int index) {
		this.arr = arr;
		this.index = index;
	}
 
	@Override
	public int compareTo(ArrayContainer arrContainer) {
		return this.arr[this.index] - arrContainer.arr[arrContainer.index];
	}
}
