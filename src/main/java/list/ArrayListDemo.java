package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Comprehensive demonstration of ArrayList operations and different List implementations.
 * This class showcases various ArrayList methods, performance characteristics,
 * and comparisons with other List implementations.
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        // Initialize ArrayList and demonstrate basic operations
        demonstrateBasicOperations();

        // Show different List implementations and their characteristics
        demonstrateDifferentListTypes();

        // Show advanced operations
        demonstrateAdvancedOperations();

        // Display performance characteristics
        displayPerformanceNotes();
    }

    /**
     * Demonstrates basic ArrayList operations: add, get, size, iteration, contains
     */
    private static void demonstrateBasicOperations() {
        System.out.println("=== BASIC ARRAYLIST OPERATIONS ===");

        // Create a new ArrayList to store integers
        ArrayList<Integer> numbers = new ArrayList<>();

        // Adding elements to the list
        numbers.add(1);  // Add at the end
        numbers.add(2);  // Add at the end
        System.out.println("After adding 1 and 2: " + numbers);

        // Accessing elements by index (0-based indexing)
        System.out.println("Element at index 1: " + numbers.get(1));

        // Getting the size of the list
        System.out.println("Size of the list: " + numbers.size());

        // Iterating through the list using enhanced for loop
        System.out.println("Iterating through elements:");
        for (int number : numbers) {
            System.out.println("  " + number);
        }

        // Checking if list contains specific elements
        System.out.println("Contains 1: " + numbers.contains(1));
        System.out.println("Contains 5: " + numbers.contains(5));

        System.out.println();
    }

    /**
     * Demonstrates different List implementations and their mutability characteristics
     */
    private static void demonstrateDifferentListTypes() {
        System.out.println("=== DIFFERENT LIST IMPLEMENTATIONS ===");

        // Arrays.asList() - Creates a fixed-size list backed by an array
        // Can modify existing elements but cannot add/remove elements
        List<String> daysOfWeek = Arrays.asList("Monday", "Tuesday", "Wednesday");
        System.out.println("Arrays.asList() result: " + daysOfWeek);
        System.out.println("Class type: " + daysOfWeek.getClass().getSimpleName());

        // Uncommenting the next line would throw UnsupportedOperationException
        // daysOfWeek.add("Thursday"); // Cannot add elements

        // You can modify existing elements:
        daysOfWeek.set(0, "Friday");
        System.out.println("After setting index 0 to Friday: " + daysOfWeek);

        // List.of() - Creates an immutable list (Java 9+)
        // Cannot modify, add, or remove elements
        List<Integer> immutableNumbers = List.of(9, 2, 6);
        System.out.println("List.of() result: " + immutableNumbers);

        // Uncommenting the next line would throw UnsupportedOperationException
        // immutableNumbers.set(1, 12); // Cannot modify elements
        // immutableNumbers.add(4);     // Cannot add elements

        // Creating a mutable ArrayList from another collection
        ArrayList<Integer> mutableList = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println("Mutable ArrayList from Arrays.asList: " + mutableList);
        System.out.println("Class type: " + mutableList.getClass().getSimpleName());

        System.out.println();
    }

    /**
     * Demonstrates advanced ArrayList operations: insert, remove, modify, merge
     */
    private static void demonstrateAdvancedOperations() {
        System.out.println("=== ADVANCED ARRAYLIST OPERATIONS ===");

        ArrayList<Integer> workingList = new ArrayList<>(Arrays.asList(10, 20, 30));
        System.out.println("Initial list: " + workingList);

        // Removing element by index
        Integer removedElement = workingList.remove(1); // Removes element at index 1
        System.out.println("After removing index 1 (removed: " + removedElement + "): " + workingList);

        // Inserting element at specific index
        workingList.add(1, 25); // Insert 25 at index 1
        System.out.println("After inserting 25 at index 1: " + workingList);

        // Modifying element at specific index
        workingList.set(0, 15); // Replace element at index 0 with 15
        System.out.println("After setting index 0 to 15: " + workingList);

        // Removing element by value (removes first occurrence)
        boolean wasRemoved = workingList.remove(Integer.valueOf(25));
        System.out.println("After removing value 25 (success: " + wasRemoved + "): " + workingList);

        // Adding all elements from another collection
        List<Integer> additionalNumbers = List.of(40, 50, 60);
        workingList.addAll(additionalNumbers);
        System.out.println("After adding collection [40, 50, 60]: " + workingList);

        // Converting ArrayList to array
        Integer[] arrayFromList = workingList.toArray(new Integer[0]);
        System.out.println("Converted to array: " + Arrays.toString(arrayFromList));

        // Sorting the list
        Collections.sort(workingList);
        System.out.println("After sorting: " + workingList);

        // Optimizing memory usage
        workingList.trimToSize(); // Reduces capacity to match current size
        System.out.println("Memory optimized with trimToSize()");

        System.out.println();
    }

    /**
     * Displays performance characteristics and time complexity information
     */
    private static void displayPerformanceNotes() {
        System.out.println("=== ARRAYLIST PERFORMANCE CHARACTERISTICS ===");
        System.out.println("Time Complexity Analysis:");
        System.out.println("• Access by index: O(1) - Constant time");
        System.out.println("• Adding at end: O(1) amortized - May need to resize array");
        System.out.println("• Adding at specific index: O(n) - Must shift elements");
        System.out.println("• Removing by index: O(n) - Must shift elements after removal");
        System.out.println("• Removing by value: O(n) - Must search then shift elements");
        System.out.println("• Searching (contains): O(n) - Linear search through elements");
        System.out.println("• Iteration: O(n) - Must visit each element once");

        System.out.println("\nSpace Complexity:");
        System.out.println("• O(n) where n is the number of elements");
        System.out.println("• Dynamic resizing: grows by ~50% when capacity exceeded");

        System.out.println("\nBest Use Cases:");
        System.out.println("• Frequent random access to elements by index");
        System.out.println("• Adding elements primarily at the end");
        System.out.println("• When you need a resizable array");

        System.out.println("\nAvoid When:");
        System.out.println("• Frequent insertions/deletions in the middle");
        System.out.println("• Need thread-safe operations (use Vector or Collections.synchronizedList)");
    }
}