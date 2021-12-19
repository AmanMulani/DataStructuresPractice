public class Heap<E> {

    int heapSize;
    E[] hArr;

    public Heap(E[] arr) {
        this.heapSize = arr.length;
        this.hArr = arr;
        createHeapFromArr();
    }


    private int compareElements(E obj1, E obj2) {
        return ((Comparable<E>)obj1).compareTo(obj2);
    }


    private void swap(int index1, int index2) {
        E temp = this.hArr[index1];
        this.hArr[index1] = this.hArr[index2];
        this.hArr[index2] = temp;
    } 


    private int getLeftChildIndex(int i) {
        return 2*i+1;
    } 

    private int getRightChildIndex(int i) {
        return 2*i+2;
    } 

    private void createHeapFromArr() {
        
        //The leaf nodes start from later half of the array, since, there cannot exist any left or right child after arr/2, because
        //right child = 2*i + 2 and left child is 2*i+1, and both of them will exceed the size of array if i is greater than or equal to arr/2.
        for(int i = this.hArr.length/2 - 1; i>=0 ; i--) {
            heapify(i);
        }
    }

    private void heapify(int position) {
        int left = getLeftChildIndex(position);
        int right = getRightChildIndex(position);
        int largest = position;

        if(left < this.heapSize && compareElements(this.hArr[left], this.hArr[largest])>0) {
            largest = left;
        }

        if(right < this.heapSize && compareElements(this.hArr[right], this.hArr[largest])>0) {
            largest = right;
        }

        if(largest != position) {
            swap(position, largest);
            heapify(largest);
        }
    }


    public void heapSort() {

        //Starting for the leaf node, exchanging it with the root node.
        int lastLeaf = this.hArr.length - 1;
        for(int i = lastLeaf; i>=0; i--) {
            swap(i, 0);
            this.heapSize--;
            heapify(0);
        }
    }

}