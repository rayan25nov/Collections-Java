# Java Collections — Quick Methods Reference

> **Purpose:** A concise cheat sheet to remember method names across Collection, List, Queue, Set, and Map.

---

## Collection Interface (Root)
> All classes in `java.util`. Default capacity = 10, grows by **50%** → `currentCapacity * (3/2) + 1`
> `Collection` is an **interface** — you cannot instantiate it directly. You always create an object of its implementing classes (ArrayList, LinkedList, HashSet, etc.) and assign it to either the interface type or the class type.

```java
// Using interface type as reference (more flexible, preferred)
Collection<String> col = new ArrayList<>();
Collection<Integer> col2 = new HashSet<>();

// Using concrete class type (gives access to class-specific methods)
ArrayList<String> list = new ArrayList<>();
```

| Method | What it does |
|--------|-------------|
| `add(Object obj)` | Appends element to the end |
| `add(int index, Object obj)` | Inserts element at specified index |
| `addAll(Collection c)` | Appends all elements of another collection |
| `addAll(int index, Collection c)` | Inserts all elements of another collection at index |
| `remove(Object obj)` | Removes first occurrence of the element |
| `remove(int index)` | Removes element at specified index |
| `removeAll(Collection c)` | Removes all elements that exist in `c` |
| `retainAll(Collection c)` | Keeps only elements that exist in `c`, removes rest |
| `clear()` | Removes all elements |
| `size()` | Returns number of elements |
| `contains(Object obj)` | Returns `true` if element exists |
| `containsAll(Collection c)` | Returns `true` if all elements of `c` exist |
| `isEmpty()` | Returns `true` if collection is empty |
| `iterator()` | Returns an `Iterator` to traverse elements |
| `toArray()` | Converts collection to an array |

---

## List Interface
> Indexed, allows duplicates, allows null, insertion order maintained.
> `List` is an **interface** — assign implementing class objects to it.

```java
List<String> list1 = new ArrayList<>();      // most common
List<String> list2 = new LinkedList<>();
List<String> list3 = new Vector<>();
```

**Extra methods on top of Collection:**

| Method | What it does |
|--------|-------------|
| `get(int index)` | Fetches element at specified index |
| `set(int index, Object obj)` | **Replaces** element at specified index with new value |
| `indexOf(Object obj)` | Returns index of first occurrence (-1 if not found) |
| `lastIndexOf(Object obj)` | Returns index of last occurrence (-1 if not found) |
| `subList(int from, int to)` | Returns a portion of the list (from inclusive, to exclusive) |
| `listIterator()` | Returns a `ListIterator` (can traverse both directions) |

```java
// set() — the one easy to forget (not put()!)
ArrayList<String> list = new ArrayList<>();
list.add("Apple");
list.set(0, "Mango");  // Replaces "Apple" with "Mango"
```

---

## ArrayList
> Not synchronized → fast. Grows by **50%**.

**Object Creation:**
```java
ArrayList<String> list = new ArrayList<>();               // default capacity 10
ArrayList<String> list = new ArrayList<>(20);            // custom initial capacity
ArrayList<String> copy = new ArrayList<>(existingList);  // copy from another collection
```

**Constructors:**

| Constructor | What it does |
|-------------|-------------|
| `ArrayList()` | Default capacity = 10 |
| `ArrayList(int initialCapacity)` | Custom initial capacity |
| `ArrayList(Collection c)` | Copies another collection into this list |

---

## Vector
> Synchronized → slow. Grows by **100%**.

**Object Creation:**
```java
Vector<String> v = new Vector<>();          // default capacity 10
Vector<String> v = new Vector<>(20);       // custom initial capacity
Vector<String> v = new Vector<>(list);     // copy from another collection
```

**Extra methods (legacy):**

| Method | What it does |
|--------|-------------|
| `addElement(Object obj)` | Same as `add()` |
| `elementAt(int index)` | Same as `get()` |
| `removeElement(Object obj)` | Same as `remove()` |
| `firstElement()` | Returns first element |
| `lastElement()` | Returns last element |
| `capacity()` | Returns current allocated capacity (not size) |

---

## LinkedList
> Implements both **List + Queue**. Grows by **50%**.

**Object Creation:**
```java
LinkedList<String> ll = new LinkedList<>();         // empty linked list
LinkedList<String> ll = new LinkedList<>(list);    // copy from another collection

// Can also be referenced as List or Queue
List<String>  ll = new LinkedList<>();
Queue<String> ll = new LinkedList<>();
```

**Queue-specific methods (on top of all List methods):**

| Method | What it does |
|--------|-------------|
| `peek()` | Retrieves head element, does **not** remove it |
| `poll()` | Retrieves head element **and removes** it |
| `offer(Object obj)` | Adds element to the tail |
| `peekFirst()` / `peekLast()` | Retrieves first/last without removing |
| `pollFirst()` / `pollLast()` | Retrieves and removes first/last |
| `addFirst(Object obj)` | Inserts at the beginning |
| `addLast(Object obj)` | Inserts at the end |

```java
// peek vs poll
LinkedList<Integer> ll = new LinkedList<>();
ll.add(1); ll.add(2);
ll.peek();  // returns 1, size stays 2
ll.poll();  // returns 1, size becomes 1
```

---

## Queue Interface — PriorityQueue
> Auto-sorted (min-heap by default). No null. No heterogeneous data. Not indexed.

**Object Creation:**
```java
// Default — min-heap (smallest element at head)
PriorityQueue<Integer> pq = new PriorityQueue<>();

// Max-heap — largest element at head (using Comparator)
PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());

// Custom initial capacity
PriorityQueue<Integer> pq = new PriorityQueue<>(20);

// With lambda for custom objects (see Comparator + Lambda section below)
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
```

> ✅ `Queue` is an interface — you can also reference it as `Queue<Integer> pq = new PriorityQueue<>();`

| Method | What it does |
|--------|-------------|
| `add(Object obj)` | Inserts element (throws exception if fails) |
| `offer(Object obj)` | Inserts element (returns false if fails) |
| `peek()` | Retrieves smallest element, does **not** remove |
| `poll()` | Retrieves smallest element **and removes** it |
| `remove()` | Removes head (throws exception if empty) |
| `contains(Object obj)` | Checks if element exists |
| `size()` | Returns number of elements |

---

## Set Interface
> Not indexed, no duplicates, allows null (except TreeSet). Grows by **50%**.
> `Set` is an **interface** — assign implementing class objects to it.

```java
Set<String> set1 = new HashSet<>();        // no order
Set<String> set2 = new LinkedHashSet<>();  // insertion order
Set<String> set3 = new TreeSet<>();        // sorted order
```

| Method | What it does |
|--------|-------------|
| `add(Object obj)` | Adds element (ignored if duplicate) |
| `remove(Object obj)` | Removes specified element |
| `contains(Object obj)` | Checks if element exists |
| `size()` | Returns number of elements |
| `isEmpty()` | Checks if set is empty |
| `addAll(Collection c)` | Union — adds all elements of `c` |
| `retainAll(Collection c)` | Intersection — keeps only common elements |
| `removeAll(Collection c)` | Difference — removes elements present in `c` |
| `iterator()` | Returns iterator (use for-each since not indexed) |

```java
// Traversing a Set (no index, so use for-each)
HashSet<String> set = new HashSet<>();
set.add("A"); set.add("B");
for (String s : set) {
    System.out.println(s);
}
```

**Set Variants:**

| Class | Order | Null | Sorted |
|-------|-------|------|--------|
| `HashSet` | No order | Allowed (1 null) | No |
| `LinkedHashSet` | Insertion order | Allowed (1 null) | No |
| `TreeSet` | Sorted order | ❌ Not allowed | Yes (auto) |

**Object Creation for each variant:**
```java
HashSet<String>       hs  = new HashSet<>();
LinkedHashSet<String> lhs = new LinkedHashSet<>();
TreeSet<String>       ts  = new TreeSet<>();

// Copy constructor — available for all three
HashSet<String> hs2 = new HashSet<>(existingCollection);
TreeSet<Integer> ts  = new TreeSet<>(Comparator.reverseOrder()); // custom sort for TreeSet
```

---

## Map Interface
> Stores key-value pairs. Keys are unique. **Not** a subtype of Collection.
> `Map` is an **interface** — assign implementing class objects to it.

```java
Map<String, Integer> map1 = new HashMap<>();         // no order, fast
Map<String, Integer> map2 = new LinkedHashMap<>();   // insertion order
Map<String, Integer> map3 = new TreeMap<>();         // sorted by key
Map<String, Integer> map4 = new Hashtable<>();       // synchronized (legacy)
```

| Method | What it does |
|--------|-------------|
| `put(K key, V value)` | Inserts or **updates** a key-value pair |
| `get(Object key)` | Returns value for the key (null if not found) |
| `remove(Object key)` | Removes the key-value pair |
| `containsKey(Object key)` | Returns `true` if key exists |
| `containsValue(Object value)` | Returns `true` if value exists |
| `size()` | Returns number of key-value pairs |
| `isEmpty()` | Checks if map is empty |
| `keySet()` | Returns a `Set` of all keys |
| `values()` | Returns a `Collection` of all values |
| `entrySet()` | Returns a `Set` of all key-value pairs (`Map.Entry`) |
| `putAll(Map m)` | Copies all pairs from another map |
| `clear()` | Removes all pairs |
| `getOrDefault(key, defaultVal)` | Returns value or a default if key not found |
| `putIfAbsent(key, value)` | Inserts only if key does not already exist |
| `replace(key, value)` | Replaces value only if key already exists |

```java
// put() for Map — remember it's put(), not add() or set()
HashMap<String, Integer> map = new HashMap<>();
map.put("Apple", 1);
map.put("Apple", 5);  // Updates value to 5 (not a duplicate key error)
map.get("Apple");     // returns 5
```

---

## Looping Over a Map — All 3 Ways

### 1. Loop using `keySet()` — when you only need keys (or use key to get value)
```java
for (String key : map.keySet()) {
    System.out.println(key + " = " + map.get(key));
}
```

### 2. Loop using `values()` — when you only need values
```java
for (Integer value : map.values()) {
    System.out.println(value);
}
```

### 3. Loop using `entrySet()` — **best way** when you need both key and value
```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}
```

> ✅ Prefer `entrySet()` over `keySet()` when you need both key and value — it avoids the extra `map.get(key)` lookup on every iteration.

---

## Map.Entry Interface
> Represents a single key-value pair inside a Map. You get `Map.Entry` objects from `entrySet()`.

| Method | What it does |
|--------|-------------|
| `getKey()` | Returns the key of this entry |
| `getValue()` | Returns the value of this entry |
| `setValue(V value)` | Updates the value of this entry directly |

---

**Map Variants:**

| Class | Order | Null Key | Null Value | Synchronized | Sorted |
|-------|-------|----------|------------|--------------|--------|
| `HashMap` | No order | 1 allowed | Allowed | No (fast) | No |
| `LinkedHashMap` | Insertion order | 1 allowed | Allowed | No | No |
| `TreeMap` | Sorted by key | ❌ No | Allowed | No | Yes |
| `Hashtable` | No order | ❌ No | ❌ No | Yes (slow) | No |

**Object Creation for each variant:**
```java
HashMap<String, Integer>       hm  = new HashMap<>();
LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
TreeMap<String, Integer>       tm  = new TreeMap<>();
Hashtable<String, Integer>     ht  = new Hashtable<>();

// Copy constructor — available for all
HashMap<String, Integer> hm2 = new HashMap<>(existingMap);

// TreeMap with custom key sort
TreeMap<String, Integer> tm = new TreeMap<>(Comparator.reverseOrder());
```

---

## Collections Class (Utility)
> `java.util.Collections` — works on List type collections.

| Method | What it does |
|--------|-------------|
| `Collections.sort(list)` | Sorts list in ascending order |
| `Collections.sort(list, comparator)` | Sorts with custom comparator |
| `Collections.reverse(list)` | Reverses the list |
| `Collections.shuffle(list)` | Randomly shuffles elements |
| `Collections.min(collection)` | Returns minimum element |
| `Collections.max(collection)` | Returns maximum element |
| `Collections.frequency(collection, obj)` | Returns count of occurrences of `obj` |
| `Collections.binarySearch(list, key)` | Binary search (list must be sorted first) |
| `Collections.unmodifiableList(list)` | Returns a read-only view of the list |
| `Collections.synchronizedList(list)` | Returns thread-safe version of the list |
| `Collections.nCopies(n, obj)` | Returns list with `n` copies of `obj` |

---

## Iterator
> `java.util.Iterator` — used to traverse any Collection (List, Set, Queue) one element at a time. Since Set and Queue are not indexed, `iterator()` is the standard way to loop through them programmatically (other than for-each).

**How to get an Iterator:**
```java
Iterator<String> it = collection.iterator();
```

**Methods:**

| Method | What it does |
|--------|-------------|
| `hasNext()` | Returns `true` if there are more elements to iterate, `false` otherwise |
| `next()` | Returns the next element and moves the cursor forward |
| `remove()` | Removes the **last element returned** by `next()` from the collection (safe removal during iteration) |

```java
ArrayList<String> list = new ArrayList<>();
list.add("A"); list.add("B"); list.add("C");

Iterator<String> it = list.iterator();
while (it.hasNext()) {           // check if next element exists
    String val = it.next();      // fetch the next element
    if (val.equals("B")) {
        it.remove();             // safely removes "B" during iteration
    }
}
```

> ⚠️ Always call `hasNext()` before `next()` — calling `next()` when no elements remain throws `NoSuchElementException`.

---

## ListIterator
> `java.util.ListIterator` — extended version of Iterator, only works with **List**. Can traverse in **both directions**.

**How to get a ListIterator:**
```java
ListIterator<String> lit = list.listIterator();
```

**Methods (in addition to Iterator methods):**

| Method | What it does |
|--------|-------------|
| `hasNext()` | Returns `true` if there are more elements in forward direction |
| `next()` | Returns next element, moves cursor forward |
| `hasPrevious()` | Returns `true` if there are elements in backward direction |
| `previous()` | Returns previous element, moves cursor backward |
| `nextIndex()` | Returns index of the element that `next()` would return |
| `previousIndex()` | Returns index of the element that `previous()` would return |
| `add(Object obj)` | Inserts element at the current cursor position |
| `set(Object obj)` | Replaces the last element returned by `next()` or `previous()` |
| `remove()` | Removes last element returned by `next()` or `previous()` |

---

## Arrays Class (Utility)
> `java.util.Arrays` — utility class for working with **arrays**. Commonly used alongside collections when converting between arrays and lists.

| Method | What it does |
|--------|-------------|
| `Arrays.sort(arr)` | Sorts array in ascending order |
| `Arrays.sort(arr, from, to)` | Sorts a range of the array (from inclusive, to exclusive) |
| `Arrays.binarySearch(arr, key)` | Binary search on a sorted array, returns index |
| `Arrays.equals(arr1, arr2)` | Returns `true` if both arrays are equal element by element |
| `Arrays.fill(arr, value)` | Fills entire array with specified value |
| `Arrays.fill(arr, from, to, value)` | Fills a range of the array with specified value |
| `Arrays.copyOf(arr, newLength)` | Copies array into new array of given length (truncates or pads with 0/null) |
| `Arrays.copyOfRange(arr, from, to)` | Copies a slice of the array into a new array |
| `Arrays.toString(arr)` | Returns a readable string like `[1, 2, 3]` (for printing arrays) |
| `Arrays.asList(arr)` | Converts array to a **fixed-size** List (cannot add/remove, only set) |

```java
// Arrays.asList — common gotcha: you can't add or remove from this list
String[] arr = {"A", "B", "C"};
List<String> list = Arrays.asList(arr);   // fixed size!
// To get a fully mutable list:
List<String> mutableList = new ArrayList<>(Arrays.asList(arr));
```

---

## Immutable Collection Factory Methods (Java 9+)
> Quick ways to create **read-only** collections. Cannot add, remove, or update after creation.

| Method | What it does |
|--------|-------------|
| `List.of(e1, e2, ...)` | Creates an immutable List |
| `Set.of(e1, e2, ...)` | Creates an immutable Set (no duplicates allowed) |
| `Map.of(k1,v1, k2,v2, ...)` | Creates an immutable Map (up to 10 pairs) |
| `Map.ofEntries(Map.entry(k,v), ...)` | Creates an immutable Map with more than 10 pairs |
| `Map.entry(key, value)` | Creates a single immutable `Map.Entry` |
| `List.copyOf(collection)` | Creates an immutable copy of a collection |
| `Set.copyOf(collection)` | Creates an immutable copy as a Set |
| `Map.copyOf(map)` | Creates an immutable copy of a Map |

```java
List<String> names = List.of("Alice", "Bob", "Charlie");  // immutable
Map<String, Integer> scores = Map.of("Alice", 90, "Bob", 85);  // immutable
```

---

## Comparator (for Custom Sorting)
> `java.util.Comparator` — a **functional interface** used to define custom sort order. Pass it to `Collections.sort()`, `list.sort()`, or directly into `PriorityQueue`, `TreeSet`, `TreeMap` constructors.

**Core rule:** `compare(a, b)` returns:
- **negative** → a comes before b
- **zero** → a and b are equal
- **positive** → b comes before a

| Method | What it does |
|--------|-------------|
| `Comparator.naturalOrder()` | Ascending order (A→Z, 0→9) |
| `Comparator.reverseOrder()` | Descending order (Z→A, 9→0) |
| `Comparator.comparing(keyExtractor)` | Sort by a specific field/property |
| `Comparator.comparingInt(keyExtractor)` | Same but optimized for int fields |
| `Comparator.comparingDouble(keyExtractor)` | Same but optimized for double fields |
| `comparator.reversed()` | Reverses any comparator |
| `comparator.thenComparing(keyExtractor)` | Secondary sort when primary values are equal |

---

## Lambda Expressions with Comparator
> Lambda is a short, anonymous function. Syntax: `(parameters) -> expression`
> Since `Comparator` is a functional interface (has only one method `compare()`), it can be replaced with a lambda.

### Full form (verbose) → Comparator class
```java
// Old way — anonymous class
Comparator<Integer> comp = new Comparator<Integer>() {
    @Override
    public int compare(Integer a, Integer b) {
        return a - b;  // ascending
    }
};
```

### Lambda form (short)
```java
// Same thing, as lambda
Comparator<Integer> comp = (a, b) -> a - b;   // ascending
Comparator<Integer> comp = (a, b) -> b - a;   // descending
```

### Lambda with List — Sorting
```java
List<String> names = Arrays.asList("Charlie", "Alice", "Bob");

// Sort by length ascending
names.sort((a, b) -> a.length() - b.length());

// Sort by length descending
names.sort((a, b) -> b.length() - a.length());

// Sort alphabetically — use compareTo for Strings (not subtraction)
names.sort((a, b) -> a.compareTo(b));         // ascending
names.sort((a, b) -> b.compareTo(a));         // descending

// Using Comparator built-in methods (cleaner)
names.sort(Comparator.comparingInt(String::length));
names.sort(Comparator.comparingInt(String::length).reversed());
names.sort(Comparator.comparingInt(String::length)
           .thenComparing(Comparator.naturalOrder()));  // secondary sort
```

### Lambda with Custom Object Sorting
```java
class Student {
    String name;
    int age;
    // constructor, getters...
}

List<Student> students = new ArrayList<>();

// Sort by age ascending
students.sort((a, b) -> a.age - b.age);

// Sort by name alphabetically
students.sort((a, b) -> a.name.compareTo(b.name));

// Using Comparator.comparing — cleaner for object fields
students.sort(Comparator.comparing(s -> s.name));
students.sort(Comparator.comparingInt(s -> s.age));

// Sort by age, then by name if ages are equal
students.sort(Comparator.comparingInt((Student s) -> s.age)
                        .thenComparing(s -> s.name));
```

---

## Lambda with PriorityQueue
> By default PriorityQueue is a **min-heap** (smallest at head). Use a Comparator/lambda to change ordering.

```java
// Default — min-heap (no comparator needed)
PriorityQueue<Integer> minPQ = new PriorityQueue<>();
minPQ.add(5); minPQ.add(1); minPQ.add(3);
minPQ.peek();  // returns 1

// Max-heap using lambda
PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
// OR using built-in
PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
maxPQ.add(5); maxPQ.add(1); maxPQ.add(3);
maxPQ.peek();  // returns 5

// PriorityQueue of int[] arrays — sort by first element
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
pq.add(new int[]{3, 10});
pq.add(new int[]{1, 20});
pq.peek();  // returns [1, 20] — sorted by index 0

// PriorityQueue of custom objects — sort by a field
PriorityQueue<Student> pq = new PriorityQueue<>((a, b) -> a.age - b.age);
// OR
PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.age));

// PriorityQueue sorted by String length
PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> a.length() - b.length());
```

> ⚠️ For Strings and Objects, always use `.compareTo()` or `Comparator.comparing()` — never use subtraction on Strings.
> For integers, `a - b` works but can overflow if values are very large. Safer: `Integer.compare(a, b)`

---

## String Utility Methods (Commonly Used with Collections)
> These come up constantly when processing collections of Strings.

| Method | What it does |
|--------|-------------|
| `str.length()` | Returns number of characters |
| `str.charAt(index)` | Returns character at given index |
| `str.substring(from)` | Returns substring from index to end |
| `str.substring(from, to)` | Returns substring (from inclusive, to exclusive) |
| `str.indexOf(str)` | Returns index of first occurrence of substring (-1 if not found) |
| `str.contains(str)` | Returns `true` if string contains the substring |
| `str.startsWith(prefix)` | Returns `true` if string starts with prefix |
| `str.endsWith(suffix)` | Returns `true` if string ends with suffix |
| `str.equals(str2)` | Compares content (use this, not `==`) |
| `str.equalsIgnoreCase(str2)` | Compares content ignoring case |
| `str.toLowerCase()` | Converts to lowercase |
| `str.toUpperCase()` | Converts to uppercase |
| `str.trim()` | Removes leading and trailing whitespace |
| `str.strip()` | Same as trim() but Unicode-aware (Java 11+) |
| `str.replace(old, new)` | Replaces all occurrences of a character/string |
| `str.replaceAll(regex, new)` | Replaces using regex pattern |
| `str.split(delimiter)` | Splits string into array by delimiter |
| `str.isEmpty()` | Returns `true` if length is 0 |
| `str.isBlank()` | Returns `true` if empty or only whitespace (Java 11+) |
| `str.toCharArray()` | Converts string to `char[]` array |
| `str.valueOf(obj)` | Converts any type to String (static method) |
| `String.join(delim, list)` | Joins list elements into one string with delimiter |
| `str.compareTo(str2)` | Compares lexicographically (returns 0 if equal, negative/positive otherwise) |
| `str.intern()` | Returns canonical representation from String pool |

```java
// String.join — very useful for printing collection contents
List<String> names = List.of("Alice", "Bob", "Charlie");
String result = String.join(", ", names);  // "Alice, Bob, Charlie"
```

---

## Objects Utility Class
> `java.util.Objects` — null-safe utility methods. Avoids NullPointerException in common operations.

| Method | What it does |
|--------|-------------|
| `Objects.equals(a, b)` | Null-safe equality check — no NPE if either is null |
| `Objects.isNull(obj)` | Returns `true` if obj is null |
| `Objects.nonNull(obj)` | Returns `true` if obj is not null |
| `Objects.requireNonNull(obj)` | Throws NPE with no message if obj is null |
| `Objects.requireNonNull(obj, "msg")` | Throws NPE with custom message if obj is null |
| `Objects.toString(obj)` | Returns `obj.toString()` or `"null"` safely |
| `Objects.toString(obj, default)` | Returns `obj.toString()` or `default` if null |
| `Objects.hash(a, b, c, ...)` | Generates combined hash code from multiple fields |

```java
// Objects.equals — safe even when one side is null
String s = null;
System.out.println(Objects.equals(s, "hello")); // false — no NPE
System.out.println(s.equals("hello"));           // NullPointerException!
```

---

## Math Utility Class
> `java.lang.Math` — no import needed. Common math operations used in collection processing.

| Method | What it does |
|--------|-------------|
| `Math.max(a, b)` | Returns the larger of two values |
| `Math.min(a, b)` | Returns the smaller of two values |
| `Math.abs(a)` | Returns absolute value (removes negative sign) |
| `Math.pow(base, exp)` | Returns base raised to the power of exp (returns double) |
| `Math.sqrt(a)` | Returns square root (returns double) |
| `Math.floor(a)` | Rounds down to nearest integer (returns double) |
| `Math.ceil(a)` | Rounds up to nearest integer (returns double) |
| `Math.round(a)` | Rounds to nearest integer (returns long) |
| `Math.random()` | Returns random double between 0.0 (inclusive) and 1.0 (exclusive) |
| `Math.log(a)` | Returns natural logarithm (base e) |
| `Math.log10(a)` | Returns base-10 logarithm |

```java
// Common pattern: random int between 0 and n-1
int random = (int)(Math.random() * n);
```

---

## Integer / Wrapper Class Utility Methods
> `java.lang.Integer` (and similar for Double, Long, etc.) — commonly used when collections contain numbers.

| Method | What it does |
|--------|-------------|
| `Integer.parseInt(str)` | Converts String to int |
| `Integer.valueOf(str)` | Converts String to Integer object |
| `Integer.toString(num)` | Converts int to String |
| `Integer.toBinaryString(num)` | Converts int to binary string |
| `Integer.toHexString(num)` | Converts int to hex string |
| `Integer.MAX_VALUE` | Largest possible int value (2147483647) |
| `Integer.MIN_VALUE` | Smallest possible int value (-2147483648) |
| `Integer.compare(a, b)` | Returns negative/0/positive (useful in Comparator) |
| `Double.parseDouble(str)` | Converts String to double |
| `Character.isDigit(ch)` | Returns `true` if character is a digit |
| `Character.isLetter(ch)` | Returns `true` if character is a letter |
| `Character.isLetterOrDigit(ch)` | Returns `true` if character is alphanumeric |
| `Character.isUpperCase(ch)` | Returns `true` if character is uppercase |
| `Character.isLowerCase(ch)` | Returns `true` if character is lowercase |
| `Character.toLowerCase(ch)` | Converts character to lowercase |
| `Character.toUpperCase(ch)` | Converts character to uppercase |

---

## Quick Cheat — "What method do I use to...?"

| Goal | Method |
|------|--------|
| Add to List/Set | `add()` |
| Add to Map | `put()` ← not `add()`, not `set()` |
| **Update a value in List** | `set(index, value)` ← not `put()` |
| **Update a value in Map** | `put(key, newValue)` |
| Fetch from List | `get(index)` |
| Fetch from Map | `get(key)` |
| Fetch from Map (with fallback if key missing) | `getOrDefault(key, default)` |
| Add to Map only if key absent | `putIfAbsent(key, value)` |
| Fetch but don't remove (Queue) | `peek()` |
| Fetch and remove (Queue) | `poll()` |
| Check existence in List/Set | `contains(obj)` |
| Check key exists in Map | `containsKey(key)` |
| Check value exists in Map | `containsValue(value)` |
| Keep only common elements | `retainAll()` |
| Remove based on another collection | `removeAll()` |
| Loop over Map (keys only) | `for (K key : map.keySet())` |
| Loop over Map (values only) | `for (V val : map.values())` |
| Loop over Map (key + value both) | `for (Map.Entry<K,V> e : map.entrySet())` → `e.getKey()`, `e.getValue()` |
| Loop over Set/Queue | `for-each` loop or `iterator()` |
| Check if next element exists (Iterator) | `hasNext()` |
| Fetch next element (Iterator) | `next()` |
| Safely remove during iteration | `it.remove()` ← not `list.remove()` |
| Traverse List backwards | `ListIterator` → `hasPrevious()` + `previous()` |
| Sort a list ascending | `Collections.sort(list)` |
| Sort a list descending | `list.sort(Comparator.reverseOrder())` |
| Sort by a field | `list.sort(Comparator.comparing(obj::getField))` |
| Convert array to List (mutable) | `new ArrayList<>(Arrays.asList(arr))` |
| Convert List to array | `list.toArray()` |
| Print array as string | `Arrays.toString(arr)` |
| Null-safe equals | `Objects.equals(a, b)` ← not `a.equals(b)` |
| Check null safely | `Objects.isNull(obj)` / `Objects.nonNull(obj)` |
| Parse String to int | `Integer.parseInt(str)` |
| Convert int to String | `Integer.toString(num)` or `String.valueOf(num)` |
| Join list elements to string | `String.join(", ", list)` |
| Split string into array | `str.split(delimiter)` |
| Largest/smallest of two numbers | `Math.max(a, b)` / `Math.min(a, b)` |
| Absolute value | `Math.abs(a)` |
| Random integer 0 to n-1 | `(int)(Math.random() * n)` |
