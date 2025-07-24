package comparator;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Custom String Comparator - sorts by length in descending order
 */
class StringComparator implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        return Integer.compare(second.length(), first.length());
    }
}

/**
 * Custom Integer Comparator - sorts in descending order
 */
class IntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer first, Integer second) {
        return Integer.compare(second, first);
    }
}

/**
 * Student class with proper encapsulation and toString method
 */
class Student {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', age=%d}", name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

/**
 * Comprehensive demonstration of Java Comparator usage
 * Shows various ways to sort collections using different approaches
 */
public class ComparatorDemo {

    public static void main(String[] args) {
        System.out.println("=== Java Comparator Demonstration ===\n");

        demonstrateCustomComparatorClasses();
        demonstrateLambdaExpressions();
        demonstrateMethodReferences();
        demonstrateMultipleSortingCriteria();
        demonstrateCollectionsSortMethod();
        demonstrateAdvancedComparatorFeatures();
    }

    /**
     * Demonstrates sorting using custom Comparator classes
     */
    private static void demonstrateCustomComparatorClasses() {
        System.out.println("1. Custom Comparator Classes:");
        System.out.println("--------------------------------");

        // String sorting by length (descending)
        List<String> names = new ArrayList<>(Arrays.asList("Abhishek", "Neha", "Ravi", "Gaurav"));
        System.out.println("Original strings: " + names);
        names.sort(new StringComparator());
        System.out.println("Sorted by length (desc): " + names);

        // Integer sorting (descending)
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 20, 3, 9, 5));
        System.out.println("Original numbers: " + numbers);
        numbers.sort(new IntegerComparator());
        System.out.println("Sorted descending: " + numbers);
        System.out.println();
    }

    /**
     * Demonstrates sorting using lambda expressions
     */
    private static void demonstrateLambdaExpressions() {
        System.out.println("2. Lambda Expressions:");
        System.out.println("----------------------");

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 20, 3, 9, 5));
        List<String> names = new ArrayList<>(Arrays.asList("Abhishek", "Neha", "Ravi", "Gaurav"));

        // Sort numbers in ascending order
        numbers.sort((a, b) -> Integer.compare(a, b));
        System.out.println("Numbers ascending: " + numbers);

        // Sort strings by length (ascending)
        names.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("Strings by length (asc): " + names);

        // Alternative: Using built-in comparators
        numbers.sort(Integer::compareTo);
        names.sort(Comparator.comparing(String::length));
        System.out.println("Using method references - Numbers: " + numbers);
        System.out.println("Using method references - Names: " + names);
        System.out.println();
    }

    /**
     * Demonstrates sorting custom objects using method references
     */
    private static void demonstrateMethodReferences() {
        System.out.println("3. Sorting Custom Objects:");
        System.out.println("--------------------------");

        List<Student> students = Arrays.asList(
                new Student("Rayan", 24),
                new Student("Ravi", 32),
                new Student("Gaurav", 24),
                new Student("Anita", 28)
        );

        System.out.println("Original students:");
        students.forEach(System.out::println);

        // Sort by age (descending)
        List<Student> sortedByAge = students.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getAge(), s1.getAge()))
                .collect(Collectors.toList());

        System.out.println("\nSorted by age (descending):");
        sortedByAge.forEach(student ->
                System.out.printf("Name: %-8s | Age: %d%n", student.getName(), student.getAge())
        );
        System.out.println();
    }

    /**
     * Demonstrates multiple sorting criteria using Comparator.comparing()
     */
    private static void demonstrateMultipleSortingCriteria() {
        System.out.println("4. Multiple Sorting Criteria:");
        System.out.println("-----------------------------");

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Rayan", 24),
                new Student("Ravi", 32),
                new Student("Gaurav", 24),
                new Student("Anita", 24),
                new Student("Bob", 32)
        ));

        // Sort by age first, then by name
        Comparator<Student> multiCriteriaComparator =
                Comparator.comparing(Student::getAge)
                        .thenComparing(Student::getName);

        students.sort(multiCriteriaComparator);

        System.out.println("Sorted by age (asc), then by name (asc):");
        students.forEach(student ->
                System.out.printf("Name: %-8s | Age: %d%n", student.getName(), student.getAge())
        );

        // Sort by age descending, then by name ascending
        students.sort(Comparator.comparing(Student::getAge, Comparator.reverseOrder())
                .thenComparing(Student::getName));

        System.out.println("\nSorted by age (desc), then by name (asc):");
        students.forEach(student ->
                System.out.printf("Name: %-8s | Age: %d%n", student.getName(), student.getAge())
        );
        System.out.println();
    }

    /**
     * Demonstrates using Collections.sort() method
     */
    private static void demonstrateCollectionsSortMethod() {
        System.out.println("5. Using Collections.sort():");
        System.out.println("----------------------------");

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Rayan", 24),
                new Student("Ravi", 32),
                new Student("Gaurav", 24)
        ));

        // Using Collections.sort with custom comparator
        Collections.sort(students, Comparator.comparing(Student::getName).reversed());

        System.out.println("Sorted by name (descending) using Collections.sort():");
        students.forEach(System.out::println);
        System.out.println();
    }

    /**
     * Demonstrates advanced Comparator features
     */
    private static void demonstrateAdvancedComparatorFeatures() {
        System.out.println("6. Advanced Comparator Features:");
        System.out.println("--------------------------------");

        List<String> words = Arrays.asList("apple", "Banana", "cherry", "Date", null, "elderberry");

        // Handle null values and case-insensitive sorting
        Comparator<String> nullSafeComparator =
                Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER);

        words.sort(nullSafeComparator);
        System.out.println("Null-safe, case-insensitive sort: " + words);

        // Natural order with nulls first
        List<Integer> numbersWithNull = Arrays.asList(5, null, 2, 8, null, 1);
        numbersWithNull.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println("Numbers with nulls first: " + numbersWithNull);

        // Reverse natural order
        List<String> fruits = Arrays.asList("apple", "banana", "cherry");
        fruits.sort(Comparator.reverseOrder());
        System.out.println("Fruits in reverse order: " + fruits);
        System.out.println();
    }
}