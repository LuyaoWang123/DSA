# LinkedList
## Table of Contents
- [Description](#description)
- [Algorithm Complexity](#complexity)
- [Practice](#practice)

## Description
*LinkedList*(*search list*)([implementation](/src/main/java/data_structures/linkedlist/DoublyLinkedList.java)) is a data structure that stores elements in linear order. LinkedList is similar to as array, but it accesses element by points: 

+ *Singly linked list*: each element has only ```next``` pointer 
<figure style="text-align: center;">
  <img src="./images/singly.jpg" alt="singly linked list description">
  <figcaption>
    <strong>Figure 1.</strong> singly linked list<br>
  </figcaption>
</figure>

+ *Doubly linked list*: each element has ```next``` and ```pre``` pointers 
<figure style="text-align: center;">
  <img src="./images/doubly.jpg" alt="doubly linked list description">
  <figcaption>
    <strong>Figure 2.</strong> doubly linked list<br>
  </figcaption>
</figure>

For each node $x$ in a linked list, we call:
+ $x\rightarrow pre$: x's *predecessor*
+ $x\rightarrow next$: x's *successor*. 
+ If $x\rightarrow pre$ is null(equivalently, $x$ is the first node in linked list), then node $x$ is *head*; 
+ If $x\rightarrow next$ is null(equivalently, $x$ is the last node in linked list), then node $x$ is *tail*.

Then observe the linked list, if $tail.next$ points to $head$, while $head.pre$ points to the tail like Figure 3, then we have *a circular linked list*!

<figure style="text-align: center;">
  <img src="./images/circular_linked_list.jpg" alt="circular linked list description">
  <figcaption>
    <strong>Figure 3.</strong> circular linked list<br>
  </figcaption>
</figure>

## Complexity
+ `prepend()`: insert a node to head
+ `insert(x,y)`: insert node $x$ immediately after $y$
+ `search(k)`: search node whose data is $k$ in linked list
+ `remove(x)`: remove node $x$ in linked list

| Operation | Time Complexity |
|-----------|-----------------|
| prepend      | $O(1)$          |
| insert       | $O(1)$          |
| search       | $O(n)$          |
| delete       | $O(1)$          |

## Practice