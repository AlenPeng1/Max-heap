package example2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MaxHeapDriver {
    public static void main(String[] args) {
        Heap heap = new Heap(101);

        // Load integers from the text file
        int[] values = loadIntegersFromFile("C:\\Users\\alenp\\eclipse-workspace\\example2\\data.txt");

        // Max-heap using sequential insertions
        for (int value : values) {
            heap.add(value);
        }

        // Output the first 10 integers of the array and the number of swaps 
        outputToFile("output.txt", "Heap built using sequential insertions: " + arrayToString(heap.getHeapArray(), 10));
        outputToFile("output.txt", "Number of swaps in the heap creation: " + heap.getSwaps());

        // Loops 10 removals on the heap
        for (int i = 0; i < 10; i++) {
            heap.remove();
        }

        // Output the first 10 integers of the resulting array after removals
        outputToFile("output.txt", "Heap after 10 removals: " + arrayToString(heap.getHeapArray(), 10));

        // Create a max-heap using the optimal method
        heap.heapOptimalMethod(values);

        // Output the first 10 integers of the array and the number of swaps performed
        outputToFile("output.txt", "Heap built using optimal method: " + arrayToString(heap.getHeapArray(), 10));
        outputToFile("output.txt", "Number of swaps in the heap creation: " + heap.getSwaps());

        // Loops 10 removals on the heap
        for (int i = 0; i < 10; i++) {
            heap.remove();
        }

        // Output the first 10 integers of the resulting array after removals
        outputToFile("output.txt", "Heap after 10 removals: " + arrayToString(heap.getHeapArray(), 10));
    }

    private static int[] loadIntegersFromFile(String filename) {
        int[] values = new int[101];
        try {
            Scanner scanner = new Scanner(new File(filename));
            int index = 0;
            while (scanner.hasNextLine() && index < 101) {
                values[index] = Integer.parseInt(scanner.nextLine());
                index++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return values;
    }

    private static void outputToFile(String filename, String content) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(content + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String arrayToString(int[] array, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(array[i]);
            if (i != count - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}