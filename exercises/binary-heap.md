# Implementing and testing a binary heap

A [*binary heap*](https://en.wikipedia.org/wiki/Binary_heap) is a data structure that contains comparable objects and it is able to efficiently return the lowest element.
This data structure relies on a binary tree to keep the insertion and deletion operations efficient. It is the base of the [*Heapsort* algorithm](https://en.wikipedia.org/wiki/Heapsort).

Implement a `BinaryHeap` class with the following interface:

```java
class BinaryHeap<T> {

    public BinaryHeap(Comparator<T> comparator) { ... }

    public T pop() { ... }

    public T peek() { ... }

    public void push(T element) { ... }

    public int count() { ... }

}
```

A `BinaryHeap` instance is created using a `Comparator` object that represents the ordering criterion between the objects in the heap.
`pop` returns and removes the minimum object in the heap. If the heap is empty it throws a `NotSuchElementException`.
`peek` similar to `pop`, returns the minimum object but it does not remove it from the `BinaryHeap`.
`push` adds an element to the `BinaryHeap`.
`count` returns the number of elements in the `BinaryHeap`.

Design and implement a test suite for this `BinaryHeap` class.
Feel free to add any extra method you may need.

Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-heap](../code/tp3-heap) to complete this exercise.

## Answer

### Answer of exercice 5
##### Question 1

| Cas                           | Input         | Output    |  
| -------------                 |:-------------:|:---------:|
| **push()**                    |               |           |
| Add in empty list             | push(elt)     | No error  |
| Add in full list              | push(elt)     | Copy and size*2 |
| Add in list                   | push(elt)     | No error  |
| **pop()**                     |               |           |
| Delete in empty list          | pop()         |return null|
| Delete in full list           | pop()         | return elt|
| Delete in list                | pop()         | return elt|
| **peek()**                    |               |           |
| Give first elt in a list      | peek()        | return elt|
| Give first elt in a empty list| peek()        | return null|
| **count()**                   |               |           |
| Give valid size               | assertEqual   | return true |
| Give invalid size             | assertEqual   | return false |


#### Question 2 and 3

After implementing the **BinaryHeap** class, we wrote a test class for it. As seen in the course, we have a test method for an associated method of the initial class. After the first implementation of the tests, we obtain a coverage of 87%.  The standard is to have a coverage between 80-85%. 

![](assets/testExos5.png "Test")

![](assets/coverageExos5.png "coverage score")
##### Question 4
We will now use PIT to get a mutation level. This level allows us to know if we can trust our tests. With a Maven project we can use this command :
```
mvn test-compile org.pitest:pitest-maven:mutationCoverage
```
With our project, here is Pittest's report :

![](assets/pitExos5.png "Pit's report")
