import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class SelectionSort {
    private SelectionSort() { } // Prevent instantiation

    /**
     * Calculates class average.
     * @param args Command-line arguments (not used).
     */
    public static void main(final String[] args) {

        try {
            // Input file
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);

            // Output file
            PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

            // Process each line
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                // Split into numbers
                String[] parts = line.trim().split(" ");
                int[] numbers = new int[parts.length];

                for (int i = 0; i < parts.length; i++) {
                    numbers[i] = Integer.parseInt(parts[i]);
                }

                // Sort using selection sort
                selectionSort(numbers);

                // Write sorted line to output.txt
                for (int num : numbers) {
                    writer.print(num + " ");
                }
                writer.println(); // new line
            }

            // Close files
            writer.close();
            scanner.close();

            System.out.println("Sorting complete. Check output.txt");

        } catch (FileNotFoundException e) {
            System.out.println("Error: input.txt not found.");
        } catch (IOException e) {
            System.out.println("Error writing to output.txt");
        }
    }

    /**
     * Performs selection sort on an integer array.
     *
     * @param arr The array to sort
     */
    public static void selectionSort(final int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the smallest value in the remaining unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the smallest value with the first unsorted position
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
