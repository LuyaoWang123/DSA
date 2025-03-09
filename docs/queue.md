# Queue
## Table of Contents
- [Description](#description)
- [Extention-Deque](#extension-deque)
- [Algorithm Complexity](#complexity)
- [Practice](#practice)
  - [Leetcode 346. Moving Average from Data Stream](#leetcode-346easy-moving-average-from-data-stream)
  
## Description
Queue[(Implementation)](/src/main/java/data_structures/queue/Queue.java) is a data structure that follows **First In, First Out(FIFO)**. Namely, the element being pushed first will be the one that is first popped out.

<figure style="text-align: center;">
  <img src="./images/queue.gif" alt="Queue description">
  <figcaption>
    <strong>Figure 3.</strong> Queue Mechanism(<a href="./slides/queue.pptx">Slides</a>)<br>
  </figcaption>
</figure>

In this mechanism demonstration, we set 
+ $tail = 0$ (where the element reside when enqueue)
+ $head = 0$ (where the element reside when dequeue)
+ $size = 0$ (number of element in the queue)

for queue initialization.

+ If we enqueue one element into queue, (after check overflow), we first assign the value to where $tail$ points, then increment $tail$ by one. We treated the array as circular array, so if $tail$ already hits capacity, we move $tail$ to 0.
+ If we dequeue from queue, (after check underflow), we first store head element to $x$, then increment $head$ by one. Similarly to enqueue, wrap around $head$ when it hits capacity, we move $head$ to 0.

Queue's implementation--first assign value then increment pointer for add operation--follows [Introduction to Algorithm](https://www.google.com/books/edition/Introduction_to_Algorithms_fourth_editio/RSMuEAAAQBAJ?hl=en&gbpv=0). 

## Extension-Deque
If we allow that ```enqueue()``` on both $head$ and $tail$, ```dequeue()``` on both $head$ and $tail$, we will get **deque(double-ended-queue)**. Curious about the [implementation]()?

## Complexity
```enqueue()``` and ```dequeue()``` is the same time complexity for both head and tail.
| Operation | Time Complexity |
|-----------|-----------------|
| enqueue      | O(1)          |
| dequeue       | O(1)          |

## Practice
### [Leetcode 346(Easy). Moving Average from Data Stream](https://leetcode.com/problems/moving-average-from-data-stream/)
#### Description
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:

+ MovingAverage(int size) Initializes the object with the size of the window size.

+ double next(int val) Returns the moving average of the last size values of the stream.

#### Solution
For this problem, as we have a window of fixed length, and we want to keep track of the sum for this window, namely, $\sum_{i=0}^{n} queue[i]$, where $n< size$. The problem is we just want to keep the most recent $size$ elements, so if the element we add to the queue is the $size-th$ element, we will then want to remove the $0-th$ element, so that the queue will only keep the most recent $size$ elements.

Following the idea, we have the code as below:

#### [Code](/src/main/java/data_structures/queue/MovingAverage.java)

#### Complexity
$size$ is the window size, and $n$ is the input size for next, then we will have:

Time Complexity: $O(n)$, this is linear as we need to iterate all input for next processing

Space Complexity: $O(size)$, we are using queue to keep the most recent $size$ elements. As we only need to store the most recent $size$ elements, thus the queue with size $size$ will be enough, leading to space complexity $O(size)$

### [Leetcode 950(Medium). Reveal Cards In Increasing Order](https://leetcode.com/problems/reveal-cards-in-increasing-order/)
#### Description
You are given an integer array deck. There is a deck of cards where every card has a unique integer. The integer on the ith card is $deck[i]$.

You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.

You will do the following steps repeatedly until all cards are revealed:

Take the top card of the deck, reveal it, and take it out of the deck.
If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
If there are still unrevealed cards, go back to step 1. Otherwise, stop.
Return an ordering of the deck that would reveal the cards in increasing order.

Note that the first entry in the answer is considered to be the top of the deck.

#### Solution
For this problem, we want the cards revealed to follow increasing order. Thus, it is easier to start with: we need to sort the input array to get increasing order. Then the requirement also requires that the cards that are revealed need to be increasing, so we can assign the sorted element to the output array when we reveal cards. But how can we assign the sorted element $deck[i]$ to the output array? $output[?] = deck[i]$.


Recall the problem statement: we need to do 2 operations each time: 
+ reveal the cards on top(dequeue), and 
+ Put the next card to the bottom(enqueue)

Then try to fill the blank $?$ seems to be $output[$ index that when we reveal cards $]$. Thus we can use a queue storing index $[0, n-1]$ to simulate the 2 operations above:

+ $output[idxQueue.dequeue()] = deck[i]$
+ $idxQueue.enqueue(idxQueue.dequeue())$

#### [Code](/src/main/java/data_structures/queue/RevealCardsInIncreasing.java)

#### Complexity
$n$ is the size of the input, then we have:

Time complexity: $O(nlogn)$, as we sorted the input array, which is the bottleneck of this algorithm. After sorting, we just iterate the sorted array and assign it to our output by following the simulation, which leads to $O(n)$ time complexity. Thus $O(nlogn + n)=O(nlogn)$

Space complexity: $O(n)$, as we are using the queue with size $n$

### [Leetcode 239(Hard). Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)
#### Description
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

#### Solution
For this problem, we want to maintain a **fixed** window sliding from [0, n - k],
and for each window, we want to know the max value among this window.
Thus we would want to have an output with size n - k + 1.

As we want the max for each window, how could we do that? 
+ **Intuitive approach**: for each window $wdIdx$, where $0\leq wdIdx\leq n - k$, we iterate all 
element in this window to find the max element, namely, 
```
for wdIdx ← 0 to n - k
  res[wdIdx] ← -inf 
  for start ← wdIdx to wdIdx + k - 1 
    res[wdIdx] = max(res[wdIdx], res[start])
```

However, this approach might lead to $O(n^2)$ time complexity.
Is there any way that we can memoize the max value candidate of window $wdIdx$, so that 
when we want to get the max value  of window $j$ where $wdIdx < j <= n - k$, we could use
the candidate already computed in window $wdIdx$?

+  Maintain a non-increasing queue with size $k$, in this way, when we slide the window by 1 each time, 
    + Maintain our non-increasing queue. 
    + Then 
we can check if the max value has been removed as the window moves forward. If so, the queue should dequeue this element, otherwise,
the queue's first element 
will be the max value. 

Following this idea, we will have the code following
#### [Code]
#### Complexity
$n$ is the size of the input
Time complexity: $O(n)$, as each element will be evaluated once.
Space complexity: $O(k)$,  where $k$ is the size of the fixed window. 