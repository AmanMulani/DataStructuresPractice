public class HeapMain {

    public static void main(String[] args) {

        Integer arr[] = {4, 10, 3, 5, 1};

        Heap<Integer> heap = new Heap<Integer>(arr);

        heap.heapSort();

        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}