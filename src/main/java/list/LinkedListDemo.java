package list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Comprehensive demonstration of LinkedList operations and performance characteristics.
 * This class showcases various LinkedList methods, their time complexities,
 * and practical usage patterns for different scenarios.
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        // Demonstrate basic LinkedList operations
        demonstrateBasicOperations();

        // Show insertion and deletion operations with performance notes
        demonstrateInsertionAndDeletion();

        // Demonstrate access operations and their performance
        demonstrateAccessOperations();

        // Show collection-based operations
        demonstrateCollectionOperations();

        // Display performance comparison insights
        displayPerformanceInsights();

        // Demonstrate Efficient Iteration
        demonstrateEfficientIteration();

        // Demonstrate Polymorphism
        demonstratePolymorphism();
    }

    /**
     * Demonstrates basic LinkedList creation and element addition
     */
    private static void demonstrateBasicOperations() {
        System.out.println("=== BASIC LINKEDLIST OPERATIONS ===");

        // Create a new LinkedList to store integers
        LinkedList<Integer> numbers = new LinkedList<>();

        // Adding elements to the end of the list - O(1) time complexity
        numbers.add(1);  // LinkedList: [1]
        numbers.add(2);  // LinkedList: [1, 2]
        numbers.add(3);  // LinkedList: [1, 2, 3]

        System.out.println("Initial LinkedList: " + numbers);
        System.out.println("Size: " + numbers.size());
        System.out.println();
    }

    /**
     * Demonstrates insertion and deletion operations with performance analysis
     */
    private static void demonstrateInsertionAndDeletion() {
        System.out.println("=== INSERTION AND DELETION OPERATIONS ===");

        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(10, 20, 30));
        System.out.println("Starting list: " + list);

        // Insertion operations - showcasing LinkedList's strengths
        list.add(0, 25);        // O(n) - Insert at specific index (needs traversal)
        System.out.println("After add(0, 25): " + list);

        list.addLast(40);       // O(1) - Add to end (direct access to tail)
        System.out.println("After addLast(40): " + list);

        list.addFirst(5);       // O(1) - Add to beginning (direct access to head)
        System.out.println("After addFirst(5): " + list);

        // Deletion operations
        Integer removedElement = list.remove(1);  // O(n) - Remove at index (needs traversal)
        System.out.println("Removed element at index 1: " + removedElement);
        System.out.println("After removal: " + list);

        Integer firstRemoved = list.removeFirst();  // O(1) - Remove first element
        System.out.println("Removed first element: " + firstRemoved);
        System.out.println("After removeFirst(): " + list);

        Integer lastRemoved = list.removeLast();   // O(1) - Remove last element
        System.out.println("Removed last element: " + lastRemoved);
        System.out.println("Final list: " + list);

        System.out.println();
    }

    /**
     * Demonstrates access operations and their performance characteristics
     */
    private static void demonstrateAccessOperations() {
        System.out.println("=== ACCESS OPERATIONS ===");

        LinkedList<String> words = new LinkedList<>(Arrays.asList("Java", "Python", "JavaScript", "C++"));
        System.out.println("Word list: " + words);

        // Access operations with performance notes
        String firstWord = words.getFirst();    // O(1) - Direct access to head node
        System.out.println("First word (O(1)): " + firstWord);

        String lastWord = words.getLast();      // O(1) - Direct access to tail node
        System.out.println("Last word (O(1)): " + lastWord);

        String middleWord = words.get(2);       // O(n) - Must traverse from head or tail
        System.out.println("Word at index 2 (O(n)): " + middleWord);

        // Search operations
        boolean containsJava = words.contains("Java");        // O(n) - Linear search
        System.out.println("Contains 'Java': " + containsJava);

        int indexOfPython = words.indexOf("Python");          // O(n) - Linear search
        System.out.println("Index of 'Python': " + indexOfPython);

        int lastIndexOfJava = words.lastIndexOf("JavaScript"); // O(n) - Reverse linear search
        System.out.println("Last index of 'JavaScript': " + lastIndexOfJava);

        System.out.println();
    }

    /**
     * Demonstrates collection-based operations and bulk modifications
     */
    private static void demonstrateCollectionOperations() {
        System.out.println("=== COLLECTION OPERATIONS ===");

        // Create a list of animals using different initialization methods
        LinkedList<String> farmAnimals = new LinkedList<>(Arrays.asList("Dog", "Cat", "Goat", "Cow"));
        System.out.println("Farm animals: " + farmAnimals);

        // Create a list of animals to remove
        LinkedList<String> animalsToRemove = new LinkedList<>(List.of("Cow", "Cat"));
        System.out.println("Animals to remove: " + animalsToRemove);

        // Remove all specified animals - O(n*m) where n is list size, m is removal list size
        boolean removed = farmAnimals.removeAll(animalsToRemove);
        System.out.println("Removal successful: " + removed);
        System.out.println("Remaining animals: " + farmAnimals);

        // Add all elements from another collection
        LinkedList<String> wildAnimals = new LinkedList<>(List.of("Lion", "Tiger", "Elephant"));
        farmAnimals.addAll(wildAnimals);
        System.out.println("After adding wild animals: " + farmAnimals);

        // Remove elements based on condition using removeIf
        farmAnimals.removeIf(animal -> animal.length() > 4);  // Remove animals with names longer than 4 chars
        System.out.println("After removing long names: " + farmAnimals);

        System.out.println();
    }

    /**
     * Demonstrates efficient iteration and modification using ListIterator
     */
    private static void demonstrateEfficientIteration() {
        System.out.println("=== EFFICIENT ITERATION WITH LISTITERATOR ===");

        LinkedList<Integer> numbers = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Original numbers: " + numbers);

        // Use ListIterator for efficient traversal and modification
        ListIterator<Integer> iterator = numbers.listIterator();

        System.out.println("Removing even numbers using ListIterator:");
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove(); // O(1) removal at current position
                System.out.println("  Removed: " + number);
            }
        }

        System.out.println("After removing even numbers: " + numbers);

        // Bidirectional traversal demonstration
        System.out.println("Backward traversal:");
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " ");
        }
        System.out.println();
    }

    /**
     * Demonstrates polymorphism with List interface
     */
    private static void demonstratePolymorphism() {
        System.out.println("=== POLYMORPHISM DEMONSTRATION ===");

        // Using List interface reference - enables polymorphism
        List<String> languages = new LinkedList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");

        System.out.println("Languages (via List interface): " + languages);
        System.out.println("Implementation class: " + languages.getClass().getSimpleName());

        // When using List reference, only List interface methods are available
        // languages.addFirst("JavaScript"); // This would cause compilation error

        // Cast to LinkedList to access specific methods
        if (languages instanceof LinkedList) {
            LinkedList<String> linkedLanguages = (LinkedList<String>) languages;
            linkedLanguages.addFirst("JavaScript");
            System.out.println("After addFirst via cast: " + linkedLanguages);
        }

        System.out.println();
    }

    /**
     * Displays performance characteristics and comparison with ArrayList
     */
    private static void displayPerformanceInsights() {
        System.out.println("=== PERFORMANCE INSIGHTS ===");
        System.out.println("LinkedList Performance Characteristics:");
        System.out.println();

        System.out.println("🏆 LINKEDLIST EXCELS AT:");
        System.out.println("• addFirst() / removeFirst()     - O(1)");
        System.out.println("• addLast() / removeLast()       - O(1)");
        System.out.println("• Insertion at known position    - O(1) with node reference");
        System.out.println("• Deletion at known position     - O(1) with node reference");
        System.out.println("• Stack/Queue operations         - O(1) for push/pop/enqueue/dequeue");

        System.out.println();
        System.out.println("⚠️ LINKEDLIST WEAKNESSES:");
        System.out.println("• get(index) / set(index)        - O(n) - requires traversal");
        System.out.println("• Random access patterns         - Poor cache locality");
        System.out.println("• Memory overhead                - ~2-3x more memory than ArrayList");
        System.out.println("• contains() / indexOf()         - O(n) - linear search required");

        System.out.println();
        System.out.println("💡 WHEN TO USE LINKEDLIST:");
        System.out.println("✅ Frequent insertions/deletions at beginning/middle");
        System.out.println("✅ Stack or Queue implementations");
        System.out.println("✅ Unknown or highly variable list size");
        System.out.println("✅ Rarely need random access by index");

        System.out.println();
        System.out.println("❌ WHEN TO AVOID LINKEDLIST:");
        System.out.println("❌ Frequent random access by index");
        System.out.println("❌ Memory-constrained environments");
        System.out.println("❌ Cache-sensitive applications");
        System.out.println("❌ Need for fast iteration over all elements");
    }
}