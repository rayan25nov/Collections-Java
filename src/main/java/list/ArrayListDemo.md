# 📋 Java ArrayList Complete Guide

<style>
  strong {
    color: #9929EA;
    font-weight: 600;
  }
  
  .badge {
    display: inline-block;
    padding: 0.25em 0.6em;
    font-size: 0.75em;
    font-weight: 700;
    line-height: 1;
    text-align: center;
    white-space: nowrap;
    vertical-align: baseline;
    border-radius: 0.375rem;
    margin: 0.2em;
  }
  
  .badge-java { background-color: #f89820; color: white; }
  .badge-collections { background-color: #28a745; color: white; }
  .badge-performance { background-color: #dc3545; color: white; }
</style>

<div class="badge badge-java">☕ Java</div>
<div class="badge badge-collections">📚 Collections</div>
<div class="badge badge-performance">⚡ Performance</div>

---

## 📑 Table of Contents

1. [🔍 Overview](#-overview)
2. [📋 List Interface](#-list-interface)
3. [🚀 ArrayList](#-arraylist)
4. [⚙️ Internal Working](#️-internal-working)
    - [🏗️ Initial Capacity](#️-initial-capacity)
    - [➕ Adding Elements](#-adding-elements)
    - [❌ Removing Elements](#-removing-elements)
5. [💡 Key Features](#-key-features)
6. [⚡ Performance Characteristics](#-performance-characteristics)

---

## 🔍 Overview

The **List interface** in Java is part of the `java.util` package and is a sub-interface of the **Collection interface**. It provides a way to store an **ordered collection of elements** (known as a sequence). Lists allow for precise control over where elements are inserted and **can contain duplicate elements**.

The List interface is implemented by several classes in the Java Collection Framework, such as **ArrayList**, **LinkedList**, **Vector**, and **Stack**.

---

## 📋 List Interface

```java
public interface List<E> extends Collection<E>
```

**Key characteristics:**
- 🔢 **Indexed access** - Elements can be accessed by their position
- 🔄 **Allows duplicates** - Same element can appear multiple times
- 📐 **Ordered collection** - Maintains insertion order
- 🎯 **Positional operations** - Insert, remove, and access elements at specific positions

---

## 🚀 ArrayList

An **ArrayList** is a **resizable array implementation** of the List interface. Unlike arrays in Java, which have a fixed size, an **ArrayList can change its size dynamically** as elements are added or removed. This flexibility makes it a popular choice when the number of elements in a list isn't known in advance.

### ✨ Key Advantages
- 🔧 **Dynamic resizing** - Automatically grows and shrinks
- ⚡ **Fast random access** - O(1) time complexity for get/set operations
- 💾 **Memory efficient** - No memory waste for unused slots (with trimToSize())
- 🔄 **Implements List interface** - Compatible with all List operations

---

## ⚙️ Internal Working

Unlike a regular array, which has a fixed size, an ArrayList can **grow and shrink** as elements are added or removed. This dynamic resizing is achieved by creating a new array when the current array is full and copying the elements to the new array.

### 🏗️ Initial Capacity

When you create an ArrayList, it has an **initial capacity** (default is **10**). The capacity refers to the size of the internal array that can hold elements before needing to resize.

```java
// Default capacity of 10
ArrayList<Integer> list1 = new ArrayList<>();

// Custom initial capacity
ArrayList<Integer> list2 = new ArrayList<>(20);
```

### ➕ Adding Elements

When we add an element to an ArrayList, the following steps occur:

#### 1. 🔍 **Check Capacity**
Before adding the new element, ArrayList checks if there is enough space in the internal array (`elementData`). If the array is full, it needs to be resized.

#### 2. 📈 **Resize if Necessary**
If the internal array is full, the ArrayList will:
- Create a new array with a **larger capacity** (usually **1.5 times** the current capacity)
- Copy all elements from the old array to the new array
- Replace the old array reference with the new array

#### 3. ✅ **Add the Element**
The new element is then added to the internal array at the appropriate index, and the size counter is incremented.

```java
// Growth formula: newCapacity = oldCapacity + (oldCapacity >> 1)
// Example: 10 → 15 → 22 → 33 → 49...
```

### ❌ Removing Elements

When removing an element from an ArrayList:

#### 1. 🎯 **Check Bounds**
The ArrayList first checks if the index is within the valid range (0 ≤ index < size).

#### 2. 🗑️ **Remove the Element**
The element is removed, and all elements to the right of the removed element are **shifted one position to the left** to fill the gap.

#### 3. 📉 **Reduce Size**
The size counter is decremented by 1, and the last position is set to null to help garbage collection.

```java
// Before removal: [A, B, C, D, E]
// Remove index 2:  [A, B, _, D, E] → [A, B, D, E, null]
//                      ↑ Shift left    ↑ Size reduced
```

---

## 💡 Key Features

| Feature | Description | Example |
|---------|-------------|---------|
| 🔢 **Indexed Access** | Access elements by position | `list.get(2)` |
| 🔄 **Dynamic Sizing** | Automatically grows/shrinks | `list.add()`, `list.remove()` |
| 🎯 **Insertion Control** | Insert at specific positions | `list.add(1, element)` |
| 🔍 **Search Operations** | Find elements by value | `list.contains()`, `list.indexOf()` |
| 📦 **Bulk Operations** | Add/remove multiple elements | `list.addAll()`, `list.removeAll()` |

---

## ⚡ Performance Characteristics

| Operation | Time Complexity | Notes |
|-----------|----------------|--------|
| 🎯 **Access (get/set)** | O(1) | Direct array access |
| ➕ **Add (at end)** | O(1) amortized | May trigger resize |
| ➕ **Add (at index)** | O(n) | Requires shifting elements |
| ❌ **Remove (by index)** | O(n) | Requires shifting elements |
| ❌ **Remove (by value)** | O(n) | Search + shift operations |
| 🔍 **Search (contains)** | O(n) | Linear search |
| 🔄 **Iteration** | O(n) | Visit each element once |

### 📊 Space Complexity
- **Space**: O(n) where n is the number of elements
- **Growth factor**: ~1.5x when capacity is exceeded
- **Memory overhead**: Temporary double space during resize operations

---

> 💡 **Pro Tip**: Use `ArrayList.trimToSize()` after bulk operations to optimize memory usage by reducing the internal array size to match the actual number of elements.