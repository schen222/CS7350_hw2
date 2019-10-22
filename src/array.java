import java.util.Arrays;

public class array {

//    private static long startTime = System.currentTimeMillis();
//    private static long startTime = System.nanoTime();
    private int sum_array[] =new int[10];

    public array(){
//        int number[] = new int[]{4,8,10,12};
        int number[] = new int[]{100000000};
        int max = 9, min = 2;
        int range = max - min + 1;

        for(int i = 0; i < number.length; i++){
            long startTime = System.nanoTime();
            initial();
            int array[] = new int[number[i]];
            for(int j = 0; j < number[i]; j++){
                int random = min + (int)(Math.random() * range);
                array[j] = random;
                sum_array[random]++;
            }
            System.out.println("when n = " + Integer.toString(number[i]));
            for(int k = min; k <= max; k++){
                System.out.println("Number " +Integer.toString(k) + " Appears " + Integer.toString(sum_array[k]) + " times");
            }

            long endTime = System.nanoTime();
            System.out.println("It took " + (endTime - startTime) + " nanoseconds");

            System.out.println();
//            insertion_sort(array);
            heap(array);
        }

//        long endTime = System.currentTimeMillis();
//        long endTime = System.nanoTime();
//        System.out.println("It took " + (endTime - startTime) + " nanoseconds");
    }

    public void initial(){
        Arrays.fill(sum_array,0);
    }

//    public void insertion_sort(int array[]){
//        for(int index = 0; index < array.length; index++){
//            int buffer = array[index];
//            int before_index = index - 1;
//            while(before_index >= 0 && array[before_index] > array[index]){
//                array[before_index + 1] = array[before_index];
//                before_index--;
//            }
//            array[before_index + 1] = buffer;
//        }
//    }

    public void heap(int arr[]){
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        array M = new array();
    }
}

