# Leetcode Practice

| Category | Problem | Thoughts | Understanding |
|----------|---------|----------|--------------|
| Brute force | Problem | Thoughts | understand |
|  | 3380. Maximum Area Rectangle With Point Constraints I | string serilize + (2 loop compare one with all others)2 corner represent rect | iterate through each potential; check this potential works or not |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
| Array | Problem | Thoughts | understand |
|  | 1. Two Sum | HashMap  ( target-nums[i], i) | know target -> find pairs |
|  | 15. 3Sum | One loop + 2sum. (check repetition between i and l, l and r) | know target -> find tuplet |
|  | 1726. Tuple with Same Product | 2 loop + hashmap store the result of multiplication, then #pairs choose 2, for each tuple, there are 8 ways to arrange |  |
|  | 3371. Identify the Largest Outlier in an Array | target = prefix[i] + suffix[i]; target - nums[i], i. (i and j are not exchangable, so loop 2 direcrions) | know target -> find unsymmtric pair |
|  | 88. Merge Sorted Array | fill from back to start(edge: short length -> out of bounds  |  |
|  | 27. Remove Element | if ( nums[i] != val ) nums[ptr++] = nums[i]; |  |
|  | 26. Remove Duplicates from Sorted Array | if (nums[i] != nums[i-1]) nums[ptr++] = nums[i]; i starts from 1 | followed by 75 |
|  | 80. Remove Duplicates from Sorted Array II | if (nums[i[ != nums[ptr - 2]) nums[ptr++] = nums[i]; ptr maintain array | needs to be non-decreasing |
|  | 169. Majority Element | sort, return nums[n/2] |  |
|  | 189. Rotate Array | reverse [0, n-1], then reverse [0, k-1], [k, n-1]  |  |
|  | 55. Jump Game | nums[i] + i >= target ? update target : do nothing |  |
|  | 45. Jump Game II | far is the cur step's furthst we can go, if far reach the boundary n -1, then stop) |  |
|  | 274. H-Index | 1. n - i means that there are total i elements till the end. n - i -1 means we are deducting one non-legal; 2. binary, needs l & r overlap -> judge it again, l should always land on ideal interval's left boundary inx |  |
|  | 380. Insert Delete GetRandom O(1) | Deleting a, then all pairs (val ,inx) after a will change. to avoid that put the last element to deleted element(edge: first do a exchange then remove as removed might be the last element, if first do a remove then can't exchange) |  |
|  | 238. Product of Array Except Self | corner case: from right to left, do not directly mul[i] = mul[i+1] * nums[i+1], as mul will be multiply twice |  |
|  | 912. Sort an Array |  |  |
|  | Selection sort | unstable O(n^2 / 2), choose min element from [j, n), replace it with i |  |
|  | Insertion sort | stable O(n^2 / 4), for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) swap(j, j-1) |  |
|  | Bubble sort | stable |  |
|  | Quick Sort | (unstable: 3a,3b,2, nlogn, worst case n^2) <br>1. Intro-7.1(classy, tle as when they have repeated elements at the back of the array, they need to be consistently swaped(but for while they skip if equal, reducing O(3n)->O(n)).  <br>2. for two while, we wanna always goes into while and check pivot including as we wanna get the correct left and right pointer to the correct place after comparing every element |  |
|  | Merge Sort | (stable, nlogn, worst case nlogn) <br>divide and conquer |  |
|  | Heap sort |  (unstable, nlgn)<br>1. heapify(i, recursively exchange with children who is larger than i)<br>2. do recursively heapify from last second level(inx is n/2 - 1)<br>3. move the heap's top element to the last element |  |
|  | Counting sort | (stable, n+k, worst case n^2)<br>1. keep frequency of all elements;<br>2. add up all frequency from least element to the highest element to get the index + 1 of each element in result array;<br>3. shift -1 to get the index in the result array |  |
|  | Cyclic sort | 287. Find the Duplicate Number / 268.<br>needs to be mapped from 1 to n, or from 0 to n |  |
|  | 3397. Maximum Number of Distinct Elements After Operations |  |  |
|  | 2439. Minimize Maximum of Array | prefix, always atmorized with previous subarray |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
| LinkedList | Problem | Thoughts | Understanding |
|  | 61. Rotate List | 1.To close the linked list into the ring<br>2.To break the ring after the new tail and just in front of the new head. |  |
|  | 143. Reorder List | 1. find mid point in linkedlist<br>2. reverse linkedlist;<br>3. merge 2 linkedlist in place |  |
|  | 142. Linked List Cycle II | cycle in linkedlsit |  |
|  | 287. Find the Duplicate Number | cycle in array |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
| Hash | Problem | Thoughts | Understand |
|  | 49. Group Anagrams | sorted string as hashkey | group multi elements by stringfy  |
|  | 73. Set Matrix Zeroes | keep 0's row/col in hashset / initalize in 0-th row/col | memorize repeated index |
|  | 128. Longest Consecutive Sequence | !set.contains(nums[i] - 1) | find unique consecutive(avoid repetition) |
|  | 138. Copy List with Random Pointer | intervaving / store copied node in hashmap | record unique node |
|  | 133. Clone Graph | store copied node in hashmap |  |
|  | 460. LFU Cache |  |  |
|  | 41. First Missing Positive | use index as the hash key. <br>negative means present. 1-n-1 sotres. 0 store n |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
| Two pointer | Problem | Thoughts | Understand |
|  | 11. Container With Most Water | out -> in; maxArea | max area(parallel) |
|  | 42. Trapping Rain Water | outer needs to >= inner. (first update max, then compare max - cur) ?? seq or max jumpping down | smooth |
|  | 121. Best Time to Buy and Sell Stock | first update min, cur - min ?? seq or max jumpping upwards  | max difference between any 2 elements |
|  | 122. Best Time to Buy and Sell Stock II | first update min, cur - min | all positive distance sum |
|  | 3381. Maximum Subarray Sum With Length Divisible by K | no constrains on out/in (compre cur, then update pre) | max differences(size k) between any 2 groups |
|  | 84. Largest Rectangle in Histogram | record the min(left boundary), calculate the length*min |  |
|  | 680. Valid Palindrome II | using 2 pointer twice would be fine, once found unproper, return 2 pointer's result |  |
|  | 2422. Merge Operations to Turn Array Into a Palindrome | 1. using leftSum, and rightSum to keep twoSides;<br>2. if equal, FIRST update pointer, then update val;<br>3. <, FIRST update left, then update val;<br>4. >, FIRST uodate right ptr, then update val;<br>core: sum is [], so to calculate the next sum, need to first update pointer then update val |  |
|  | 1813. Sentence Similarity III | 1. either 1 chunk on left or right; or 2 chunk both on the left or right;<br>2. can use 2 deque to keep left and right;<br>2. can also use 2 pointer to check if shorter words are located at the two ends | two pointer to locate if data locate on two end |
|  | 75. Sort Colors | 3 pointer, p0 in the left, p2 in the right. and a current pointer used to iterate through the array; <br>being stuck: know p0 and p2, but did not came up with special curr ptr;<br>NOTE: ptr/counter can be sperate with other ptrs |  |
|  | 1237. Find Positive Integer Solution for a Given Equation |  |  |
|  | 3284. Sum of Consecutive Subarrays | for each i, think about it as the end of a consecutive subarray, add the ctn * nums[i] as the cur sum, then accumuate the cur sum to res;<br>special case: when appear /\ or \/, the peek itself will be recalculated again; <br>        // 1 [1] <br>        // 1 + 2 * 2. [1,2], [2]<br>        // 1 + 2 * 2 + 3 * 3 [1,2,3], [2,3], [3]<br>being stuck: not sure how  pre element like 1 is carried from sum to res, thought it is omitted, but it is carried by accumate opperation |  |
|  |  |  |  |
|  |  |  |  |
| Sliding Window | Problem | Thoughts | Understand |
|  | 3. Longest Substring Without Repeating Characters | first element that cause repeatition -> shrink the window | max length of subarray(all elements satisfying 1 contrain) |
|  | 209. Minimum Size Subarray Sum | using while, as this is variant window |  |
|  | 1100. Find K-Length Substrings With No Repeated Characters | first element that cause repetition with window size k | #fixed length of subarray(all elements satisfying 2 constrains) |
|  | 159. Longest Substring with At Most Two Distinct Characters | first element that cause the window has 2+1 distinct char -> shrink the window | (sliding window + hash) |
|  | 340. Longest Substring with At Most K Distinct Characters | first element that cause the window has k + 1 distinct char -> shrink the window |  |
|  | 424. Longest Repeating Character Replacement | first element that cause the window r - l + 1 - maxFre > k  |  |
|  | 567. Permutation in String |  |  |
|  | 438. Find All Anagrams in a String | first element that make window's fre = cur string's fre(transform of 567) |  |
|  | 76. Minimum Window Substring | permutation sequence(transform of 567) |  |
|  | 155. Min Stack (monotoic queue) | left is not moving, 239 left is moving, so 239 need to store potential min/max, 155 only stores the current min/max |  |
|  | 239. Sliding Window Maximum | 1. sliding window + heap(easy-O(nlgn)); 2. sliding window + Monotonic - matain decreasing seq in the window(O(n)) | max element in each fixed length of sub array  |
|  | 395. Longest Substring with At Least K Repeating Characters | using the uniqueness as constrains. uniqueness iterate from 1 to maxUniqueness |  |
|  | 1151. Minimum Swaps to Group All 1's Together | sliding window constrains: the number of all 1s. as long as the length of window exceed total ones |  |
|  |  |  |  |
|  |  |  |  |
| Stack | Problem | Thoughts | Understand |
|  | minstack | min val will not be removed in advance, this guarantees that if the min val is removed, all potential min is removed as well; but if we are allowed to remove this min before potential elements removed, then we also need to record the potential removed elements |  |
|  | 716. Max Stack | when wanna index and val be a pair, and when the val has been removed, index should still keep untouched, choose array[val, inx] instead of direcrtly using list as remove val will change all its following inx (use treeset when they are never equal instead of heap as treeset use comparator for equals and compare)  |  |
|  | Daily Temperatures | follow by minstack, calculate dis between first element that's larger/equal than it | diff between i and the first element that's larger/smaller than i. |
|  | Car Fleet | store the increasing(make sure they do not meet) seq of time. if decreasing, not in stack |  |
|  | 84. Largest Rectangle in Histogram | 1. better brute force, also need to calculate the current height, so j = i instead of j=i+1 |  |
|  | 227. Basic Calculator II | use a '+' as inital operations. then once a number finished, calculate this number based on last operation |  |
|  | 735. Asteroid Collision |  |  |
|  | 394. Decode String | corner case: k[string], when k does not show up, k should be default to 1 |  |
|  | 856. Score of Parentheses | 1.()<br>2.AB = A+B<br>3. (A) = 2* A |  |
|  | 962. Maximum Width Ramp | track the strict decreasing seq, then the ptr on the right would always compare with the smaller and closer one |  |
|  | 32. Longest Valid Parentheses |  |  |
|  |  |  |  |
|  |  |  |  |
| Binary Search | Problem | Thoughts | Understand |
|  | 718. Maximum Length of Repeated Subarray | find length via bs -> Arrays.toString as Hashkey for matching |  |
|  | 1011. Capacity To Ship Packages Within D Days | stuck: as long as you start adding, the days would start from 1 |  |
|  | 875. Koko Eating Bananas |  |  |
|  | 69. Sqrt(x) |  |  |
|  | 528. Random Pick with Weight | prefix sum + need to find the first element that 's  >= than the target;  |  |
|  | 162. Find Peak Element | binary search sometimes [) -> might be better for squeeze the range(squeeze l and r, while(l < r)), sometimes [](might be better to find target. <br>eg. once found nums[m] > nums[m+1], means we can squeeze to m |  |
|  | 658. Find K Closest Elements | Fuzzy binary search, find the first element that's larget than that(or smaller than that);<br>then compare it with the element right next to it, then we can get the smallest |  |
|  | 1231. Divide Chocolate | if we wanna make l moving to the right, it is not a good idea to l = m as this may cause tle, it is always moving r = m |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
| Heap | Problem | Thoughts | Understand |
|  | 215. Kth Largest Element in an Array | while ( heap.size > k) poll | optimal k elements |
|  | 347. Top K Frequent Elements |  |  |
|  | 253. Meeting Rooms II | pre.end > cur.start => re-enter heap; ow pre is finished, poll | number of the list(where interval has no overlap) |
|  | 358. Rearrange String k Distance Apart | HashMap frequency. maxFreHeap(ava), minInxHeap(unava). minInx determine k, maxFre determine which letter to use |  |
|  | 2402. Meeting Rooms III | add a unused priorityqueue |  |
|  | 2530. Maximal Score After Applying K Operations |  |  |
|  | 499. The Maze III |  |  |
|  |  |  |  |
|  |  |  |  |
| Backtracking | Problem | Thoughts | Understand |
|  | Generate Parentheses | contrains about goes into each traverse level, time complexity: Calaten number + Stirling number |  |
|  | 113. Path Sum II | backtracking + targetSum |  |
|  | 437. Path Sum III | backtracking + prefix sum |  |
|  | 416. Partition Equal Subset Sum | recursion + memoization(instead of passing remaining to children, pass to n-1) |  |
|  | 79. Word Search | each letter has 3 directions to go. O(N*3^L) |  |
|  | 39. Combination Sum |  |  |
|  | 40. Combination Sum II | how to avoid repetition in combination?<br>1. sort<br>2. nums[i] == nums[i=1] continue(skip) |  |
|  | 140. Word Break II | each word is either chosen or not. O(N*2^M)<br>for (String word : wordDict) {<br>            if (curS.startsWith(word)) { <br>                ....<br>      }<br>} |  |
|  | 473. Matchsticks to Square | must sort to do the optimization;<br>use backtracking to track the sides of each possible square. (each stick can be placed to each side)->means <br>each sticks[i] has 4 choices.<br>difference between 39, pre vals in 39 can be reused, but here each val can be used only once. <br>so for single elements(idx = i), the combo it can choose is in side 0, 1, 2 or 3; instead of the rest n - i elements |  |
|  | 62. Unique Paths | backtrack + memo |  |
|  | 63. Unique Paths II | backtrack + memo only 2 directions, using memo as the path is not up to other condition  |  |
|  | 980. Unique Paths III | backtrack + remove memo, as the current path not only depends on the down and right<br>but also depends on if others cells visited or not. you can:<br>1. check all grid to see if has visited all cells;<br>2. use a variables to track non-obscle |  |
|  | 89. Gray Code | 1. Did a mask + iterate through the list reversely |  |
|  | 490. The Maze | 1. Set visited before entering the directions as if we try some directions and fianlly go back to this visited position, that's a fail<br>2. Use a while to keep going until the new cell is not legal |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
| DP | Problem | Thoughts | Understand |
|  | 70. Climbing Stairs | dp[i] = dp[i-1] + dp[i-2], no collision |  |
|  | 213. House Robber II | just 2 subproblem, from [1, n-1] or [0, n-2] |  |
|  | 337. House Robber III | on the tree, 3 situations + memo as left and right might be reused:<br>1. cur + children's children;<br>2. max(left + right's children, right + left's children)<br>3. left + right |  |
|  | 5. Longest Palindromic Substring | 1. inialize len1;<br>2. initalize len2;<br>3. s.charAt(j) == s.charAt(i) && palind[i + 1][j - 1]) |  |
|  | 650. 2 Keys Keyboard | recursion relation is around the current #operations<br>either 1 operation(paste pre) or  2 operations(copy cur + paste cur);<br>then use memo to remember the res |  |
|  | 1259. Handshakes That Don't Cross | divide a circle into 2 parts, if having 2i people<br>1. choose 2 people handshake;<br>2. all left 2j can't shake with right (2i - 2 - 2j) -> simplify to dp[j] * dp[i - j - 1] |  |
|  | 10. Regular Expression Matching | if you wanna if(!A && B || A && !B) which is ^, we can return if (A) return B? |  |
|  | 3418. Maximum Amount of Money Robot Can Earn | Besides recording x and y, also recording how many operations does it use(the thrid dimentions)<br>recurrence relation:<br>1. dp[i][j][k]=max(dp[i-1][j][k] + coins[i][j], dp[i][j-1][k] + coins[i][j], dp[i-1][j][k+1], dp[i][j-1][k+1]<br>for this status(represented by i,j) if we are using it, then we have 2 value to compare; if we are not using it, still 2 value |  |
|  | 494. Target Sum | for the current index, keep track of the remain sum. |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
| Bfs | Problem | Thoughts | Understand |
|  | 200. Number of island | regular bfs<br>1. update seen in-place<br>2. update seen using seen[][]<br>3. update seen using hashset |  |
|  | 694. Number of Distinct Islands | regular bfs + hash pattern. as the way to iterate different is the same(i and j are fixed)<br>(x - originX, y - originY) as the pattern region | HashSet first call hashcode of the element, then call equals |
|  | 695. Max Area of Island | if you can't modify the gragh, use seen, or visited[] |  |
|  | 1245. Tree Diameter | use bfs to find the furthest node, then use the furthest node to find another further node, which will be the answer |  |
|  | 752. Open the Lock | using bfs + level tranversal to each char in the string<br>(each char has 2 choices, either -1 or +1 |  |
|  | 785. Is Graph Bipartite? | 2 coloring problem, using bfs or dfs |  |
|  | 934. Shortest Bridge | take a chunk as the center, then expand it level by level(graph level tranversal) | find the shortest distance for 2 patterns |
|  | Rotten Orange | take different points as center, then expand it level by level(graph level tranversal |  |
|  | 127. Word Ladder |  |  |
|  | 815. Bus Routes |  |  |
|  | 909. Snakes and Ladders | 1.peel onion, while the lader/snake is the same level as board[x][y] = -1;<br>2. strech out the x and y to 1 d array by restore boardToList[cellIdx][r or c] |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
| DFS | Problem | Thoughts | Understand |
|  | 1466. Reorder Routes to Make All Paths Lead to the City Zero |  |  |
|  | 802. Find Eventual Safe States |  |  |
|  |  |  |  |
| Topological Sort | Problem | Thoughts | Understand |
|  | 269. Alien Dictionary | Topological sort.<br>Build the relationship according to the words<br>Then use indegree and bfs to solve it |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
| Math | Problem | Thoughts | Understand |
|  | 1071. Greatest Common Divisor of Strings | gcd:<br>private int gcd(int a, int b) {<br>        if (a == 0) return b;<br>        return gcd(b % a, a);<br>} | similar thoughts as intersection of 2 linkedlist |
|  | 365. Water and Jug Problem | (ax + by ) % gcd (x, y) == 0? where target = ax + by if it is legal |  |
|  | 204. Count Primes | for (int i = 2; i <= (int) Math.sqrt(n); i++) {<br>            if (prime[i]) {<br>                for (int c = i * i; c < n; c += i) {<br>                    prime[c] = false;<br>                }<br>            }<br>        } |  |
|  | 1183. Maximum Number of Ones | for each square(3*3 example), the number of ones would be <br>[1 + (height - (r + 1)) / sideLength] * [1 + (width - (c + 1)) / sideLength] |  |
|  |  |  |  |
|  |  |  |  |
| Trie | Problem | Thoughts | Understand |
|  | 648. Replace Words | being stuck: when searching prefix. check if childen is null or is true |  |
|  | 588. Design In-Memory File System | replace boolean isEnd to string content |  |
|  | 642. Design Search Autocomplete System | use trie node and heap |  |
|  |  |  |  |
| Treee | Problem | Thoughts | Understand |
|  | 1530. Number of Good Leaf Nodes Pairs | post order traversal; first left, then right, then deal with the node itself |  |
|  | 96. Unique Binary Search Trees I | 1. divide into different category; (0(left),2(right)), (1(left), 1(right)), (2(left), 0(right))<br>2. math formula |  |
|  | 95. Unique Binary Search Trees II | 1. using divide and conquer;<br>2. for a number i, left sub tree is from [s, i - 1], right sub tree is from [i + 1, e] |  |
|  | 255. Verify Preorder Sequence in Binary Search Tree | use stack to simulate preorder trverse, then for a num, compare all num smaller than it, pop it and track<br>the min level. as we pop, the last being poped would be the largest, while num is supposed to > largest on the stack |  |
|  |  |  |  |
| MST | Problem | Thoughts | Understand |
|  | 1584. Min Cost to Connect All Points | prim/kruskal |  |
|  |  |  |  |
|  |  |  |  |
| Union Find | Problem | Thoughts | Understand |
|  | 305. Number of Islands II | Union Find<br>1. making 2d into 1d as parent. <br>2. everytime, we are inserting a node, see if this node can be union to existed land |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
| Simulation | Problem | Thoughts | Understand |
|  | 289. Game of Life |  |  |
|  |  |  |  |
|  |  |  |  |
| Miscellaneous | Problem | Thoughts | Understand |
|  | 1980. Find Unique Binary String | Cantor's Diagonal Argument-ans will differ from every string in at least one position |  |
|  |  |  |  |
| TreeSet | Problem | Thoughts | Understand |
| treeSet use NavigatableSet and red-black tree internally, contains, remove all require LogN, but pq might require O(N) for contain and remoce. pq only cares about the optimal while others order not matters. but treeset maintain a golobally sorted sequence |  |  |  |
