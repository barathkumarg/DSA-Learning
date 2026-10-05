# The Complete MAANG DSA & Algorithms Playbook (Python Edition)

> A comprehensive, interview-ready guide with **verbal concept explanations**, **step-by-step traversals**, **ASCII visualizations**, and **LeetCode practice URLs** in each section. Covers everything needed to crack DSA rounds at Meta, Amazon, Apple, Netflix, and Google.

---

## Table of Contents

1. [How to Use This Guide](#1-how-to-use-this-guide)
2. [Complexity Analysis & Big-O Notation](#2-complexity-analysis--big-o-notation)
3. [Python Essentials for DSA](#3-python-essentials-for-dsa)
4. [Arrays & Strings](#4-arrays--strings)
5. [Hashing & Hash Maps](#5-hashing--hash-maps)
6. [Two Pointers](#6-two-pointers)
7. [Sliding Window](#7-sliding-window)
8. [Binary Search](#8-binary-search)
9. [Linked Lists](#9-linked-lists)
10. [Stacks & Queues](#10-stacks--queues)
11. [Trees & Binary Trees](#11-trees--binary-trees)
12. [Heaps & Priority Queues](#12-heaps--priority-queues)
13. [Graphs](#13-graphs)
14. [Recursion & Backtracking](#14-recursion--backtracking)
15. [Dynamic Programming](#15-dynamic-programming)
16. [Greedy Algorithms](#16-greedy-algorithms)
17. [Union Find (Disjoint Set Union)](#17-union-find-disjoint-set-union)
18. [Bit Manipulation](#18-bit-manipulation)
19. [Intervals & Merge Intervals](#19-intervals--merge-intervals)
20. [Tries](#20-tries)
21. [Matrix Manipulation](#21-matrix-manipulation)
22. [Top 130 LeetCode Problem Checklist](#22-top-130-leetcode-problem-checklist)
23. [Interview Strategy & Behavioral Tips](#23-interview-strategy--behavioral-tips)

---

## 1. How to Use This Guide

Each topic opens with a **verbal explanation** of *why* the concept exists and *when* to reach for it, followed by:
- **Core Concepts** – the theory you must know
- **Visualization** – ASCII diagrams showing the data structure/algorithm in action
- **Traversal Walkthrough** – step-by-step execution trace
- **Python Implementation** – idiomatic code
- **Time/Space Complexity** – what interviewers expect
- **LeetCode Practice** – direct URLs (each section is self-contained; a final checklist without URLs is at the end for progress tracking)

---

## 2. Complexity Analysis & Big-O Notation

### Why This Matters

Before you write a single line of code in an interview, the interviewer wants to know *how well* your solution scales. Big-O is the universal language for talking about performance — it strips away hardware, language, and constant factors, leaving only the growth rate as input size `n` grows. At MAANG scale, an O(n²) solution that works fine on 100 test cases will collapse on 10 million real users. Knowing Big-O isn't academic trivia; it's the difference between an engineer who ships scalable systems and one who doesn't. Every interview at every top company will ask you to derive and justify the time and space complexity of your solution.

### Visualization: Growth Rates

```
Operations
    ^
    |                                             n!
    |                                            /
    |                                       2^n
    |                                      /
    |                                   n^2
    |                                 /
    |                             n log n
    |                           /
    |                       n
    |                   /
    |             log n
    |_________/________________________> Input size (n)
```

### Traversal: How to Derive Big-O

**Objective:** Systematically determine the asymptotic runtime and memory growth of an algorithm by analyzing loops, recursion trees, and input reductions.
- **Input:** Loop constructs, halving loops, or recurrence relations (e.g. $T(n) = 2T(n/2) + O(n)$)
- **Expected Output:** Asymptotic Big-O complexity (e.g. $O(n)$, $O(n^2)$, $O(\log n)$, $O(n \log n)$)

```
RULE 1: Sequential loops  ->  O(n)
    for i in range(n):        # n iterations
        do_work()             # O(1)

RULE 2: Nested loops  ->  Multiply
    for i in range(n):        # n
        for j in range(n):    # n
            do_work()         # O(n * n) = O(n^2)

RULE 3: Halving  ->  O(log n)
    while n > 1:              # log2(n) iterations
        n = n // 2

RULE 4: Recursion  ->  Recurrence relation
    T(n) = 2*T(n/2) + O(n)    # -> O(n log n)
```

### Amortized Analysis Example: Dynamic Array

```
Appending elements to a Python list:

Step 1: [1]                 capacity=1  (full)
Step 2: [1,2,_]             resize to 4, copy 1 element     -> 1 work
Step 3: [1,2,3,_]           capacity=4
Step 4: [1,2,3,4]           (full)
Step 5: [1,2,3,4,5,_,_,_]   resize to 8, copy 4 elements    -> 4 work
...
Amortized cost per append = O(1)
```

**Practice:** [LeetCode – warm up with any Easy problem](https://leetcode.com/problemset/all/?difficulty=EASY)

---

## 3. Python Essentials for DSA

### Why This Matters

Python's built-in data structures (`list`, `dict`, `set`, `deque`, `heapq`) are battle-tested and highly optimized. In an interview, you should *never* reimplement a hash map or a heap from scratch — that wastes 30 minutes and shows poor judgment. Instead, fluency with these built-ins lets you focus your mental energy on the algorithm, not the plumbing. Mastering which structure to reach for (and its time complexity) is the difference between a clean 20-line solution and a tangled 60-line one.

### 3.1 Visualization: Data Structure Operations

```
+-----------+-----------+-----------+-----------+
| Structure |  Access   |  Search   | Insert/Del|
+-----------+-----------+-----------+-----------+
| Array     |   O(1)    |   O(n)    |   O(n)    |
| HashMap   |    -      |  O(1)*    |  O(1)*    |
| HashSet   |    -      |  O(1)*    |  O(1)*    |
| LinkedList|   O(n)    |   O(n)    |   O(1)    |
| Stack     |   O(n)    |   O(n)    |   O(1)    |
| Queue     |   O(n)    |   O(n)    |   O(1)    |
| Heap      |  O(1)min  |   O(n)    |  O(log n) |
| BST(bal.) | O(log n)  | O(log n)  |  O(log n) |
+-----------+-----------+-----------+-----------+
* amortized / average case
```

### 3.2 Traversal: `deque` operations

```
deque = [1, 2, 3, 4]

appendleft(0):    [0, 1, 2, 3, 4]        O(1)
popleft():        [1, 2, 3, 4]           returns 0, O(1)
append(5):        [1, 2, 3, 4, 5]        O(1)
pop():            [1, 2, 3, 4]           returns 5, O(1)
```

### 3.3 Traversal: `heapq` insertion

```
Min-Heap insertion of [5, 1, 3, 2]:

  push(5):        push(1):        push(3):        push(2):
      5               1               1               1
                     /               / \             / \
                    5               5   3           2   3
                                                   /
                                                  5

  pop() -> 1:    heapified:
      2               2
     / \             / \
    5   3           3   5

Heap array representation: [1, 2, 3, 5]  (parent < children)
```

### 3.4 Essential Code

```python
from collections import deque, defaultdict, Counter
import heapq

# List
arr = [1, 2, 3]; arr.append(4); arr.pop()          # O(1) end ops
arr.pop(0)                                          # O(n) front op (avoid)

# Dict / Set
d = {'a': 1}; d.get('b', 0); 'a' in d              # O(1) avg
s = {1, 2}; s.add(3); s.discard(4)                 # O(1) avg

# Deque
dq = deque([1,2,3]); dq.appendleft(0); dq.popleft() # O(1)

# Counter / defaultdict
freq = Counter("abracadabra")                       # Counter({'a':5,'b':2,...})
dd = defaultdict(int); dd['x'] += 1

# Heap
h = []; heapq.heappush(h, 5); heapq.heappop(h)      # O(log n)
heapq.heapify([3,1,4])                              # O(n)
```

**Practice:** [LeetCode – Python Warm-up (Easy)](https://leetcode.com/problemset/all/?difficulty=EASY)

---

## 4. Arrays & Strings

### Why This Matters

Arrays are the foundation of nearly every algorithm. They map directly to memory, giving O(1) random access — the fastest possible lookup. Almost every complex data structure (heaps, hash tables, tries) is built *on top* of arrays. In interviews, ~40% of problems are array/string problems in disguise, and most other problems use arrays as their input format. Mastering array manipulation — prefix sums, two-pointers, in-place modification, Kadane's algorithm — is non-negotiable. If you're weak on arrays, you're weak on everything downstream.

### Core Concepts
Contiguous memory, O(1) index access. Strings in Python are immutable — every modification creates a new string, so prefer `list` + `join` for heavy edits.

### Visualization: Array in Memory

```
Index:    0    1    2    3    4    5
        +----+----+----+----+----+----+
Value:  | 10 | 20 | 30 | 40 | 50 | 60 |
        +----+----+----+----+----+----+
Address:1000 1004 1008 1012 1016 1020
         ^
   arr[0] = 1000 + 0*4 = 1000  (O(1) access)
   arr[3] = 1000 + 3*4 = 1012
```

### Traversal: Prefix Sum

**Objective:** Precompute cumulative sums in $O(n)$ time so any contiguous range sum query $[L..R]$ can be calculated in $O(1)$ time ($prefix[R+1] - prefix[L]$) without re-looping through the array.
- **Input:** `nums = [3, 1, 4, 1, 5, 9]`, query range `[L=2, R=4]`
- **Expected Output:** `10` (calculated as `prefix[5] - prefix[2] = 14 - 4 = 10`)

```
nums   = [3, 1, 4, 1, 5, 9]
prefix = [0, 3, 4, 8, 9,14,23]
          ^  ^  ^  ^  ^  ^  ^
          p0 p1 p2 p3 p4 p5 p6

Range sum [2..4] = prefix[5] - prefix[2] = 14 - 4 = 10
Check: 4 + 1 + 5 = 10  ✓
```

### Traversal: Kadane's Algorithm (Maximum Subarray Sum)

**Objective:** Find the maximum contiguous subarray sum in $O(n)$ time and $O(1)$ space by deciding at each index whether to extend the running subarray or start a new subarray fresh from the current number.
- **Input:** `nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]`
- **Expected Output:** `6` (produced by contiguous subarray `[4, -1, 2, 1]`)

```
nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Step  i  num  cur_sum=max(num,cur+num)  max_sum
 0    0  -2   -2                        -2
 1    1   1   max(1, -1)    = 1          1
 2    2  -3   max(-3, -2)   = -2         1
 3    3   4   max(4, 2)     = 4          4
 4    4  -1   max(-1, 3)    = 3          4
 5    5   2   max(2, 5)     = 5          5
 6    6   1   max(1, 6)     = 6          6   <- best
 7    7  -5   max(-5, 1)    = 1          6
 8    8   4   max(4, 5)     = 5          6
```

### Traversal: Kadane's Algorithm (Subarray Selection & Boundary Tracking)

**Objective:** Track candidate window start (`temp_start`) and optimal boundaries (`[start..end]`) to isolate and extract the actual contiguous elements that produce the maximum subarray sum.
- **Input:** `nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]`
- **Expected Output:** `Subarray: [4, -1, 2, 1]`, `Indices: [3..6]`, `Max Sum: 6`

```
Boundary logic:
- If num > cur_sum + num: restart candidate window (temp_start = i)
- If cur_sum > max_sum: update best window (start = temp_start, end = i)

Step  i  num  cur_sum  max_sum  temp_start  [start..end]  best subarray so far
 0    0  -2   -2       -2       0           [0..0]        [-2]
 1    1   1    1        1       1 (reset)   [1..1]        [1]
 2    2  -3   -2        1       1           [1..1]        [1]
 3    3   4    4        4       3 (reset)   [3..3]        [4]
 4    4  -1    3        4       3           [3..3]        [4]
 5    5   2    5        5       3           [3..5]        [4, -1, 2]
 6    6   1    6        6       3           [3..6]        [4, -1, 2, 1]  <- best
 7    7  -5    1        6       3           [3..6]        [4, -1, 2, 1]
 8    8   4    5        6       3           [3..6]        [4, -1, 2, 1]

Selected subarray elements: nums[3:7] -> [4, -1, 2, 1] (Sum: 6)
```

### Traversal: Two-Pointer Move Zeroes

**Objective:** Shift all non-zero elements to the front of the array in-place in $O(n)$ time and $O(1)$ space while preserving their relative ordering, leaving all zeros at the end.
- **Input:** `nums = [0, 1, 0, 3, 12]`
- **Expected Output:** `[1, 3, 12, 0, 0]`

```
nums = [0, 1, 0, 3, 12]

i=0, num=0:  j=0  no swap              [0, 1, 0, 3, 12]
i=1, num=1:  swap j=0,i=1 -> j=1       [1, 0, 0, 3, 12]
i=2, num=0:  no swap                   [1, 0, 0, 3, 12]
i=3, num=3:  swap j=1,i=3 -> j=2       [1, 3, 0, 0, 12]
i=4, num=12: swap j=2,i=4 -> j=3       [1, 3, 12, 0, 0]
```

### Code
```python
def build_prefix(nums):
    prefix = [0] * (len(nums) + 1)
    for i, num in enumerate(nums):
        prefix[i+1] = prefix[i] + num
    return prefix

# Kadane's Algorithm - Maximum Subarray Sum (O(n) time, O(1) space)
def max_subarray(nums):
    max_sum = cur_sum = nums[0]
    for num in nums[1:]:
        cur_sum = max(num, cur_sum + num)
        max_sum = max(max_sum, cur_sum)
    return max_sum

# Kadane's Algorithm - Subarray Elements Selection (O(n) time, O(1) extra space)
def max_subarray_with_elements(nums):
    max_sum = cur_sum = nums[0]
    start = end = temp_start = 0

    for i in range(1, len(nums)):
        if nums[i] > cur_sum + nums[i]:
            cur_sum = nums[i]
            temp_start = i  # restart candidate window
        else:
            cur_sum += nums[i]  # extend current window

        if cur_sum > max_sum:
            max_sum = cur_sum
            start = temp_start
            end = i

    return max_sum, nums[start : end + 1]

def move_zeroes(nums):
    j = 0
    for i in range(len(nums)):
        if nums[i] != 0:
            nums[j], nums[i] = nums[i], nums[j]
            j += 1
```

### LeetCode Practice
- [1. Two Sum](https://leetcode.com/problems/two-sum/)
- [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
- [238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)
- [283. Move Zeroes](https://leetcode.com/problems/move-zeroes/)
- [15. 3Sum](https://leetcode.com/problems/3sum/)
- [11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/)
- [42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)
- [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

---

## 5. Hashing & Hash Maps

### Why This Matters

Hash maps are the single most powerful weapon in an interview. They turn O(n) "search through everything" operations into O(1) "just look it up" operations — often collapsing an O(n²) brute force into O(n). Whenever you hear "find a pair," "count occurrences," "detect duplicates," or "have I seen this before?", your first instinct should be: *hash map*. Almost every MAANG interview features at least one hash map problem, and many "hard" problems are hard only because the hash map insight is non-obvious.

### Core Concepts
Hash maps provide **O(1) average** insertion, deletion, and lookup. Collisions are resolved internally by the language (Python uses open addressing). Worst case is O(n) per op, but that's astronomically rare and almost never discussed in interviews.

### Visualization: Hash Function

```
  Key        Hash Function         Bucket
  ---        -------------         ------
"apple"  ->  hash() % 5 = 2   ->   [ 2 ] "apple"
"banana" ->  hash() % 5 = 0   ->   [ 0 ] "banana"
"cherry" ->  hash() % 5 = 4   ->   [ 4 ] "cherry"
"date"   ->  hash() % 5 = 2   ->   [ 2 ] "apple" -> "date" (collision chain)
                                    [ 1 ] empty
                                    [ 3 ] empty
```

### Traversal: Two Sum with Hash Map

**Objective:** Find indices of two numbers that sum up to `target` in $O(n)$ time using a hash map to check whether the required complement (`target - num`) has been seen in $O(1)$ time.
- **Input:** `nums = [2, 7, 11, 15]`, `target = 9`
- **Expected Output:** `[0, 1]` (indices of elements 2 and 7)

```
nums = [2, 7, 11, 15], target = 9

Step  i  num  complement=target-num  seen (before)   result?
 0    0   2   7                     {}               no; seen={2:0}
 1    1   7   2                     {2:0}            YES -> [0, 1]
```

### Traversal: Subarray Sum Equals K

**Objective:** Count all contiguous subarrays whose sum equals `k` in $O(n)$ time by tracking running prefix sums and their frequencies in a hash map.
- **Input:** `nums = [1, 1, 1]`, `k = 2`
- **Expected Output:** `2` (subarrays `nums[0..1]` and `nums[1..2]`)

```
nums = [1, 1, 1], k = 2

prefix_count = {0: 1}
i=0, num=1: cur=1  count += pc[-1]=0   pc[1]++  -> pc={0:1, 1:1}
i=1, num=1: cur=2  count += pc[0] =1   pc[2]++  -> count=1
i=2, num=1: cur=3  count += pc[1] =1   pc[3]++  -> count=2
```

### Code
```python
def two_sum(nums, target):
    seen = {}
    for i, num in enumerate(nums):
        if target - num in seen:
            return [seen[target - num], i]
        seen[num] = i
    return []

def subarray_sum(nums, k):
    prefix_count = defaultdict(int); prefix_count[0] = 1
    cur = count = 0
    for num in nums:
        cur += num
        count += prefix_count[cur - k]
        prefix_count[cur] += 1
    return count
```

### LeetCode Practice
- [1. Two Sum](https://leetcode.com/problems/two-sum/)
- [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/)
- [128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)
- [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)
- [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)
- [146. LRU Cache](https://leetcode.com/problems/lru-cache/)
- [242. Valid Anagram](https://leetcode.com/problems/valid-anagram/)

---

## 6. Two Pointers

### Why This Matters

Two-pointers is the art of replacing nested loops with two coordinated indices. It's the classic "linear scan for a quadratic problem." When a problem involves a **sorted array** and asks you to find a pair, a triplet, or a partition, two-pointers often gives you O(n) where brute force gives O(n²). Even on unsorted data, fast/slow pointers can detect cycles and find middles in linked lists. This pattern appears in ~20% of all FAANG interview problems — you cannot afford to miss it.

### Core Concepts
Use two indices that move in a coordinated way through the data. Variants: opposite ends (both move inward), same direction (fast/slow), or on separate arrays.

### Visualization: Opposite-End Pointers

```
Sorted: [1, 2, 4, 7, 11, 15],  target = 13

  L->                                <-R
  [1, 2, 4, 7, 11, 15]   sum = 1+15 = 16 > 13  -> R--
   L->                            <-R
  [1, 2, 4, 7, 11, 15]   sum = 1+11 = 12 < 13  -> L++
      L->                        <-R
  [1, 2, 4, 7, 11, 15]   sum = 2+11 = 13 == 13 ✓
```

### Traversal: Same-Direction (Remove Duplicates)

**Objective:** Remove duplicate values from a sorted array in-place in $O(n)$ time and $O(1)$ space using a write pointer and read pointer, returning the count of unique elements.
- **Input:** `nums = [1, 1, 2, 2, 3]` (sorted)
- **Expected Output:** `k = 3`, with first 3 elements modified in-place to `[1, 2, 3]`

```
nums = [1, 1, 2, 2, 3]

j=1 (write pointer)
i=1: nums[1]=1 == nums[0]=1  -> skip
i=2: nums[2]=2 != nums[1]=1  -> nums[j=1]=2, j=2   [1, 2, 2, 2, 3]
i=3: nums[3]=2 == nums[2]=2  -> skip
i=4: nums[4]=3 != nums[3]=2  -> nums[j=2]=3, j=3   [1, 2, 3, 2, 3]
Result: k=3, first 3 elements [1, 2, 3]
```

### Traversal: Floyd's Cycle Detection

**Objective:** Determine whether a cycle exists in $O(n)$ time and $O(1)$ space using a slow pointer (1 step) and a fast pointer (2 steps).
- **Input:** Linked list with a cycle: `1 -> 2 -> 3 -> 4 -> 5 -> 3` (or `... -> 6 -> 3`)
- **Expected Output:** `True` (cycle detected when fast catches slow; cycle starts at node `3`)

```
List: 1 -> 2 -> 3 -> 4 -> 5 -> 3 (cycle back to 3)

Step  slow  fast   meet?
 0     1     1
 1     2     3
 2     3     5
 3     4     4     YES! cycle detected
```

### Code
```python
def two_sum_sorted(nums, target):
    l, r = 0, len(nums) - 1
    while l < r:
        s = nums[l] + nums[r]
        if s == target: return [l + 1, r + 1]
        elif s < target: l += 1
        else: r -= 1
    return []

def remove_duplicates(nums):
    if not nums: return 0
    j = 1
    for i in range(1, len(nums)):
        if nums[i] != nums[i-1]:
            nums[j] = nums[i]; j += 1
    return j
```

### LeetCode Practice
- [167. Two Sum II](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
- [15. 3Sum](https://leetcode.com/problems/3sum/)
- [11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/)
- [42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)
- [26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
- [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
- [75. Sort Colors](https://leetcode.com/problems/sort-colors/)

---

## 7. Sliding Window

### Why This Matters

Sliding window is the go-to technique for any problem involving a **contiguous subarray or substring** with a constraint. The naive approach re-scans the window from scratch at each position — O(n²). Sliding window cleverly reuses work: when the window moves one step right, you add one element and remove one element — O(1) work per step, giving O(n) total. This is *the* pattern for "longest substring without repeating characters," "minimum window substring," and dozens of others. If a problem says "contiguous," think sliding window immediately.

### Core Concepts
Maintain a window `[left, right]` and expand/shrink it based on a validity condition. Fixed-size windows slide; variable-size windows grow until invalid, then shrink.

### Visualization: Fixed Window

```
nums = [1, 3, 2, 6, -1, 4, 1, 8, 2], k = 5

Window size 5:
  [1  3  2  6 -1] 4  1  8  2      sum=11
   1 [3  2  6 -1  4] 1  8  2      sum=14  (+4, -1)
   1  3 [2  6 -1  4  1] 8  2      sum=12  (+1, -3)
   1  3  2 [6 -1  4  1  8] 2      sum=18  (+8, -2)
   1  3  2  6 [-1 4  1  8  2]     sum=14  (+2, -6)
```

### Traversal: Longest Substring Without Repeating Characters

**Objective:** Find the length of the longest contiguous substring containing all distinct characters in $O(n)$ time using a variable-size sliding window with a hash map of character indices.
- **Input:** `s = "abcabcbb"`
- **Expected Output:** `3` (length of longest non-repeating substring `"abc"`)

```
s = "abcabcbb"

Step  right  char  window       left   max_len
 0     0     a     "a"          0      1
 1     1     b     "ab"         0      2
 2     2     c     "abc"        0      3
 3     3     a     "bca"        1      3   (dup 'a', move left past old 'a')
 4     4     b     "cab"        2      3
 5     5     c     "abc"        3      3
 6     6     b     "cb"         5      3
 7     7     b     "b"          7      3
Result = 3
```

### Code
```python
def length_of_longest_substring(s):
    char_index = {}; left = max_len = 0
    for right, ch in enumerate(s):
        if ch in char_index and char_index[ch] >= left:
            left = char_index[ch] + 1
        char_index[ch] = right
        max_len = max(max_len, right - left + 1)
    return max_len
```

### LeetCode Practice
- [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
- [76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)
- [424. Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)
- [567. Permutation in String](https://leetcode.com/problems/permutation-in-string/)
- [438. Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)
- [239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)

---

## 8. Binary Search

### Why This Matters

Binary search is the fastest way to search — O(log n) means that for 1 billion items, you need only 30 comparisons. But binary search is more than just "find X in a sorted array." The real power is **binary search on the answer**: when a problem asks to find the minimum or maximum value satisfying some monotonic condition, you can binary search the *answer space* itself. This advanced use is a favorite at MAANG because it tests whether you can recognize monotonicity in disguise. Off-by-one bugs are legendary here — write the loop carefully.

### Core Concepts
Requires a **sorted** array or a **monotonic predicate**. Standard loop invariant: `[l, r]` contains the answer; shrink the range based on the mid comparison.

### Visualization: Classic Binary Search

```
Sorted: [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
target = 7

Iteration 1:
  [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
   L              M                 R       (mid=9 > 7 -> R=mid-1)

Iteration 2:
  [1, 3, 5, 7, 9]
   L     M     R                            (mid=5 < 7 -> L=mid+1)

Iteration 3:
  [7, 9]
   L M R                                    (mid=7 == 7 -> FOUND at index 3)
```

### Traversal: Lower Bound

**Objective:** Find the index of the first element in a sorted array that is greater than or equal to `target` in $O(\log n)$ time by repeatedly halving the search space.
- **Input:** `nums = [1, 3, 3, 3, 5, 7]`, `target = 3`
- **Expected Output:** `1` (first index where `nums[i] >= 3`)

```
nums = [1, 3, 3, 3, 5, 7], target = 3
Find first index where nums[i] >= 3

 l=0, r=6: mid=3, nums[3]=3 >= 3 -> r=3
 l=0, r=3: mid=1, nums[1]=3 >= 3 -> r=1
 l=0, r=1: mid=0, nums[0]=1 <  3 -> l=1
 l=1, r=1: return 1  (first occurrence of 3)
```

### Traversal: Binary Search on Answer (Koko Eating Bananas)

**Objective:** Find the minimum feasible rate/value within a bounded search range in $O(\log(\text{range}) \cdot \text{check})$ time using monotonic predicate search.
- **Input:** `piles = [3, 6, 7, 11]`, `h = 8`
- **Expected Output:** `4` (minimum integer eating speed `k` to finish within `8` hours)

```
piles = [3, 6, 7, 11], h = 8

Search space [1, 11] for minimum speed:
 speed=1:  hours = 3+6+7+11 = 27 > 8   -> not enough
 speed=6:  hours = 1+1+2+2  = 6  <=8   -> possible! try smaller
 speed=3:  hours = 1+2+3+4  = 10 > 8   -> too slow
 speed=4:  hours = 1+2+2+3  = 8  <=8   -> possible! try smaller
 speed=5:  hours = 1+2+2+3  = 8  <=8   -> possible
 ...eventually converges to 4
```

### Code
```python
def binary_search(nums, target):
    l, r = 0, len(nums) - 1
    while l <= r:
        mid = l + (r - l) // 2
        if nums[mid] == target: return mid
        elif nums[mid] < target: l = mid + 1
        else: r = mid - 1
    return -1

def lower_bound(nums, target):
    l, r = 0, len(nums)
    while l < r:
        mid = (l + r) // 2
        if nums[mid] < target: l = mid + 1
        else: r = mid
    return l
```

### LeetCode Practice
- [704. Binary Search](https://leetcode.com/problems/binary-search/)
- [35. Search Insert Position](https://leetcode.com/problems/search-insert-position/)
- [33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)
- [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
- [875. Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/)
- [1011. Capacity to Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/)
- [4. Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)

---

## 9. Linked Lists

### Why This Matters

Linked lists trade random access for cheap insertions and deletions. They model dynamic sequences where you rarely look up by index but frequently add or remove in the middle — think a browser's back/forward history, an LRU cache, or an operating system's process queue. Interviews love them because they test **pointer manipulation** — you must mentally track what `curr.next` and `prev` point to at every step. Getting pointer reversal right on a whiteboard is a rite of passage. Floyd's tortoise-and-hare cycle detection is a classic that shows up everywhere.

### Core Concepts
Each node stores `val` and `next`. Access is O(n); insert/delete at a known position is O(1). Dummy heads simplify edge cases.

### Visualization: Singly Linked List

```
head
 |
 v
+------+     +------+     +------+     +------+
|  1   | --> |  2   | --> |  3   | --> |  4   | --> None
+------+     +------+     +------+     +------+
 val  next    val next     val next     val next
```

### Traversal: Reversing a Linked List

**Objective:** Reverse the link direction of all nodes in a singly linked list in-place in $O(n)$ time and $O(1)$ space using three pointers (`prev`, `curr`, `next`).
- **Input:** `head = 1 -> 2 -> 3 -> 4 -> None`
- **Expected Output:** `4 -> 3 -> 2 -> 1 -> None` (new head node with value `4`)

```
Initial:  1 -> 2 -> 3 -> 4 -> None

prev=None, curr=1
  Save next=2; 1.next=None; prev=1; curr=2      1 -> None
  Save next=3; 2.next=1;    prev=2; curr=3      2 -> 1 -> None
  Save next=4; 3.next=2;    prev=3; curr=4      3 -> 2 -> 1 -> None
  Save next=None; 4.next=3; prev=4; curr=None   4 -> 3 -> 2 -> 1 -> None

Return prev=4 (new head)
```

### Traversal: Floyd's Cycle Detection

**Objective:** Determine whether a cycle exists in $O(n)$ time and $O(1)$ space using a slow pointer (1 step) and a fast pointer (2 steps).
- **Input:** Linked list with a cycle: `1 -> 2 -> 3 -> 4 -> 5 -> 3` (or `... -> 6 -> 3`)
- **Expected Output:** `True` (cycle detected when fast catches slow; cycle starts at node `3`)

```
List: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 3 (cycle to 3)

Step  slow  fast   meet?
 0     1     1     -
 1     2     3     -
 2     3     5     -
 3     4     3     -
 4     5     5     YES (fast caught slow at 5)

Find cycle start:
  slow=head=1, fast=5 (met point)
  slow=2, fast=6
  slow=3, fast=3  -> cycle starts at node 3
```

### Code
```python
class ListNode:
    def __init__(self, val=0, next=None):
        self.val, self.next = val, next

def reverse_list(head):
    prev, curr = None, head
    while curr:
        nxt = curr.next
        curr.next = prev
        prev, curr = curr, nxt
    return prev

def merge_two_lists(l1, l2):
    dummy = tail = ListNode()
    while l1 and l2:
        if l1.val <= l2.val:
            tail.next, l1 = l1, l1.next
        else:
            tail.next, l2 = l2, l2.next
        tail = tail.next
    tail.next = l1 or l2
    return dummy.next
```

### LeetCode Practice
- [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)
- [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
- [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
- [142. Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)
- [876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)
- [19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
- [143. Reorder List](https://leetcode.com/problems/reorder-list/)
- [23. Merge K Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)
- [138. Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/)

---

## 10. Stacks & Queues

### Why This Matters

Stacks and queues are the simplest containers with *rules*. A stack's LIFO behavior matches any "undo" or "most recent first" scenario — function calls, browser back buttons, bracket matching, expression evaluation. A queue's FIFO behavior matches "fair service" or "level by level" scenarios — BFS, task scheduling, rate limiting. The **monotonic stack** is the killer application: it finds "next greater/smaller element" in O(n), which appears in dozens of interview problems (stock spans, histogram area, temperature waits). Master the monotonic stack and you unlock a whole category.

### Core Concepts
- **Stack**: LIFO. Use Python `list` (append/pop).
- **Queue**: FIFO. Use `collections.deque` (appendleft/popleft).
- **Monotonic stack**: keep elements in sorted order to answer range queries in O(1) amortized.

### Visualization: Stack (LIFO) vs Queue (FIFO)

```
STACK (Last In First Out):
  push(1):  [1]
  push(2):  [1, 2]
  push(3):  [1, 2, 3]   <- top
  pop():    [1, 2]      returns 3

QUEUE (First In First Out):
  enqueue(1):  [1]           front -> back
  enqueue(2):  [1, 2]
  enqueue(3):  [1, 2, 3]
  dequeue():   [2, 3]        returns 1
```

### Traversal: Valid Parentheses

**Objective:** Validate that all opening brackets are closed by their corresponding matching brackets in the correct LIFO order in $O(n)$ time using a stack.
- **Input:** `s = "{[()]}"`
- **Expected Output:** `True` (all bracket pairs match and close in correct LIFO order)

```
s = "{[()]}"

char  stack             action
 {    ['{']             push
 [    ['{','[']         push
 (    ['{','[','(']     push
 )    ['{','[']         pop '(' matches
 ]    ['{']             pop '[' matches
 }    []                pop '{' matches
End: stack empty -> TRUE
```

### Traversal: Monotonic Stack (Daily Temperatures)

**Objective:** Find the distance to the next warmer temperature (next greater element) for each day in $O(n)$ time using a monotonic decreasing stack of indices.
- **Input:** `temps = [73, 74, 75, 71, 69, 72, 76, 73]`
- **Expected Output:** `[1, 1, 4, 2, 1, 1, 0, 0]`

```
temps = [73, 74, 75, 71, 69, 72, 76, 73]

Step i  temp  stack (indices)     result updates
 0    0   73   [0]                 -
 1    1   74   [1]                  res[0] = 1-0 = 1  (73 -> 74)
 2    2   75   [2]                  res[1] = 2-1 = 1  (74 -> 75)
 3    3   71   [2,3]                -
 4    4   69   [2,3,4]              -
 5    5   72   [2,5]                res[4]=1, res[3]=2 (71->72 at i=5)
 6    6   76   [6]                  res[5]=1, res[2]=4 (75->76 at i=6)
 7    7   73   [6,7]                -
Remaining in stack -> 0
Result = [1, 1, 4, 2, 1, 1, 0, 0]
```

### Code
```python
def is_valid(s):
    stack, mapping = [], {')': '(', '}': '{', ']': '['}
    for ch in s:
        if ch in mapping:
            if not stack or stack.pop() != mapping[ch]: return False
        else: stack.append(ch)
    return not stack

def daily_temperatures(temps):
    result, stack = [0] * len(temps), []
    for i, t in enumerate(temps):
        while stack and t > temps[stack[-1]]:
            j = stack.pop(); result[j] = i - j
        stack.append(i)
    return result
```

### LeetCode Practice
- [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
- [155. Min Stack](https://leetcode.com/problems/min-stack/)
- [739. Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)
- [496. Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/)
- [84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)
- [232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)

---

## 11. Trees & Binary Trees

### Why This Matters

Trees model hierarchical data — file systems, organizational charts, HTML DOM, database indexes, and compiler syntax trees. Binary trees specifically underpin balanced BSTs (which power `std::map`, database indexes, and sorted sets) and heaps. Interviews test trees constantly because they naturally demand **recursion** — a tree is defined recursively as "a node plus two subtrees," and every tree algorithm mirrors that definition. Mastering tree traversals (inorder, preorder, postorder, BFS) is the gateway to graph algorithms, since graphs are just trees with cycles.

### Core Concepts
- **Binary Tree**: each node has ≤ 2 children.
- **BST**: left subtree < node < right subtree; inorder gives sorted order.
- **Balanced BST**: height O(log n) — enables O(log n) search/insert.

### Visualization: Binary Tree

```
            1
          /   \
         2     3
        / \   / \
       4   5 6   7
      /
     8

Height = 4
Depth of node 5 = 2
Leaf nodes = 8, 5, 6, 7
```

### Traversal: All DFS Traversals

**Objective:** Systematically visit every node in a binary tree in $O(n)$ time across Preorder (Root-L-R), Inorder (L-Root-R), and Postorder (L-R-Root) sequences.
- **Input:** Binary tree: root `1`, left child `2` (children `4, 5`), right child `3`
- **Expected Output:** `Inorder: [4, 2, 5, 1, 3]`, `Preorder: [1, 2, 4, 5, 3]`, `Postorder: [4, 5, 2, 3, 1]`

```
Tree:
            1
          /   \
         2     3
        / \
       4   5

Inorder   (L, Root, R): 4, 2, 5, 1, 3
Preorder  (Root, L, R): 1, 2, 4, 5, 3
Postorder (L, R, Root): 4, 5, 2, 3, 1
```

### Traversal: Level Order (BFS)

**Objective:** Traverse a binary tree level-by-level from top to bottom and left to right in $O(n)$ time using a FIFO queue.
- **Input:** Binary tree: root `1`, children `2, 3`, grandchildren `4, 5`
- **Expected Output:** `[[1], [2, 3], [4, 5]]`

```
Queue evolution:
  Start: [1]                           result=[]
  Pop 1, add children 2,3: [2,3]       result=[[1]]
  Pop 2, add 4,5: [3,4,5]              result=[[1],[2]]
  Pop 3: [4,5]                         result=[[1],[2,3]]
  Pop 4: [5]                           result=[[1],[2,3],[4]]
  Pop 5: []                            result=[[1],[2,3],[4,5]]
```

### Traversal: BST Search

**Objective:** Locate a target value in a Binary Search Tree in $O(h)$ time (where $h$ is tree height) by branching left or right using the BST ordering invariant.
- **Input:** BST rooted at `8` (containing nodes `1, 3, 4, 6, 7, 8, 10, 13, 14`), `target = 7`
- **Expected Output:** Target node `7` found in 3 comparisons (`8 -> 3 -> 6 -> 7`)

```
BST:
            8
          /   \
         3     10
        / \      \
       1   6      14
          / \    /
         4   7  13

Search for 7:
  Start at 8: 7 < 8 -> go left
  At 3:     7 > 3 -> go right
  At 6:     7 > 6 -> go right
  At 7:     7 == 7 -> FOUND (3 comparisons for 9 nodes -> O(log n))
```

### Code
```python
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val, self.left, self.right = val, left, right

def inorder(root):
    result = []
    def dfs(node):
        if not node: return
        dfs(node.left); result.append(node.val); dfs(node.right)
    dfs(root); return result

def level_order(root):
    if not root: return []
    result, queue = [], deque([root])
    while queue:
        level = []
        for _ in range(len(queue)):
            node = queue.popleft()
            level.append(node.val)
            if node.left: queue.append(node.left)
            if node.right: queue.append(node.right)
        result.append(level)
    return result

def is_valid_bst(root):
    def validate(node, low, high):
        if not node: return True
        if not (low < node.val < high): return False
        return validate(node.left, low, node.val) and validate(node.right, node.val, high)
    return validate(root, float('-inf'), float('inf'))
```

### LeetCode Practice
- [94. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)
- [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)
- [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
- [226. Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)
- [98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)
- [230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)
- [236. LCA of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
- [543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)
- [297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)
- [105. Construct Binary Tree from Preorder & Inorder](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

---

## 12. Heaps & Priority Queues

### Why This Matters

Heaps answer one question extremely well: *"What's the smallest (or largest) element right now?"* — in O(1) peek and O(log n) update. When a problem says "Kth largest," "top K," "merge K sorted lists," or "median from a stream," a heap is almost always the answer. Without a heap, finding the Kth largest element requires sorting (O(n log n)) or a partial sort; with a heap, it's O(n log K) — much faster when K is small. Heaps are the Swiss Army knife of streaming and top-K problems.

### Core Concepts
- **Min-Heap**: smallest element at root. Python's `heapq` is a min-heap.
- **Max-Heap**: negate values (Python has no built-in max-heap).
- Operations: push O(log n), pop O(log n), peek O(1), heapify O(n).

### Visualization: Min-Heap

```
        [1]           <- root = minimum
       /   \
     [3]   [2]
     / \   /
   [7] [4][5]

Array representation: [1, 3, 2, 7, 4, 5]
Parent(i) = (i-1)/2
Left(i)   = 2i + 1
Right(i)  = 2i + 2
```

### Traversal: Heapify (Build Heap) — Bottom Up

**Objective:** Transform an arbitrary array into a valid heap in-place in $O(n)$ linear time by sifting down nodes starting from the lowest non-leaf level up to the root.
- **Input:** `nums = [4, 8, 2, 5, 9, 1]`
- **Expected Output:** `[1, 5, 2, 8, 9, 4]` (valid min-heap array where parent $\le$ children)

```
Start: [4, 8, 2, 5, 9, 1]

Start from last non-leaf (i=2), sift down:
  swap 2 and 1  -> [4, 8, 1, 5, 9, 2]
i=1, sift down 8:
  swap 8 and 5  -> [4, 5, 1, 8, 9, 2]
i=0, sift down 4:
  swap 4 and 1  -> [1, 5, 4, 8, 9, 2]
  sift 4 down: swap 4 and 2 -> [1, 5, 2, 8, 9, 4]

Final min-heap: [1, 5, 2, 8, 9, 4]
```

### Traversal: Kth Largest with Min-Heap

**Objective:** Track the $k$ largest elements seen so far in a stream or collection in $O(n \log k)$ time and $O(k)$ space using a min-heap of fixed size $k.
- **Input:** `nums = [3, 2, 1, 5, 6, 4]`, `k = 2`
- **Expected Output:** `5` (the 2nd largest element in the array)

```
nums = [3, 2, 1, 5, 6, 4], k = 2

Build min-heap of size 2:
  push 3: [3]
  push 2: [2, 3]
  push 1: 1 < 2 (top), so pop and push: [2, 3]
  push 5: 5 > 2, pop-push: [3, 5]
  push 6: 6 > 3, pop-push: [5, 6]
  push 4: 4 < 5, skip

Result = heap top = 5  (2nd largest)
```

### Code
```python
import heapq

def find_kth_largest(nums, k):
    min_heap = nums[:k]
    heapq.heapify(min_heap)
    for num in nums[k:]:
        if num > min_heap[0]:
            heapq.heapreplace(min_heap, num)
    return min_heap[0]

def merge_k_lists(lists):
    heap = []
    for i, node in enumerate(lists):
        if node: heapq.heappush(heap, (node.val, i, node))
    dummy = tail = ListNode()
    while heap:
        val, i, node = heapq.heappop(heap)
        tail.next = node; tail = tail.next
        if node.next: heapq.heappush(heap, (node.next.val, i, node.next))
    return dummy.next
```

### LeetCode Practice
- [215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)
- [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)
- [973. K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)
- [23. Merge K Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)
- [295. Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)
- [621. Task Scheduler](https://leetcode.com/problems/task-scheduler/)

---

## 13. Graphs

### Why This Matters

Graphs are the most general data structure — they model any *relationship*: social networks, road maps, dependency trees, recommendation systems, and even web links. Almost every "network" or "connection" problem reduces to graph traversal. BFS finds shortest paths in unweighted graphs; DFS explores connectivity and detects cycles; topological sort orders dependencies; Dijkstra finds shortest paths with weights. At MAANG, graph problems are extremely common in system-design-adjacent coding rounds (scheduling, dependency resolution, recommendation graphs). If you can't BFS/DFS fluently, you'll fail at least one round.

### Core Concepts
- **Adjacency list**: `graph = {node: [neighbors]}` — the default.
- **Adjacency matrix**: `matrix[i][j] = weight` — for dense graphs.
- **BFS**: shortest path in unweighted graphs; level order.
- **DFS**: connectivity, cycle detection, topological sort.

### Visualization: Adjacency List

```
Graph:
    0 --- 1
    |   / |
    | /   |
    2 --- 3

Adjacency list:
  0: [1, 2]
  1: [0, 2, 3]
  2: [0, 1, 3]
  3: [1, 2]
```

### Traversal: BFS vs DFS on Same Graph

**Objective:** Compare level-by-level shortest-path expansion (BFS) versus branch-deep exploration (DFS) on an unweighted graph in $O(V + E)$ time.
- **Input:** Unweighted graph rooted at `1`, edges `(1,2), (1,3), (1,4), (2,5), (4,6)`
- **Expected Output:** `BFS: [1, 2, 3, 4, 5, 6]`, `DFS: [1, 2, 5, 3, 4, 6]`

```
          1
        / | \
       2  3  4
       |     |
       5     6

BFS (level by level):  1 -> 2, 3, 4 -> 5, 6
  Queue evolution: [1] | [2,3,4] | [3,4,5] | [4,5] | [5,6] | [6]

DFS (depth first):     1 -> 2 -> 5 -> 3 -> 4 -> 6
  Stack evolution: [1] | [2,3,4] | [5,3,4] | [3,4] | [4] | [6]
```

### Traversal: Number of Islands

**Objective:** Count connected components of land (`'1'`) in a 2D grid in $O(R \times C)$ time by sinking visited land cells using DFS/BFS.
- **Input:** $4 \times 4$ binary grid with `'1'`s (land) and `'0'`s (water)
- **Expected Output:** `4` (number of disconnected land island components)

```
Grid:
  1 1 0 0
  0 1 0 1
  1 0 0 1
  0 0 1 0

Step 1: Hit (0,0)=1, DFS flood-fills -> count=1
Step 2: Hit (1,3)=1, DFS flood-fills -> count=2
Step 3: Hit (2,0)=1, DFS -> count=3
Step 4: Hit (3,2)=1, DFS -> count=4
Result = 4 islands
```

### Traversal: Topological Sort (Course Schedule)

**Objective:** Find a valid linear ordering of dependent tasks (DAG) or detect cyclic dependency deadlock in $O(V + E)$ time using Kahn's algorithm (in-degree queue).
- **Input:** Prerequisite dependencies: `0 -> 1`, `0 -> 2`, `1 -> 3`, `2 -> 3` (4 courses)
- **Expected Output:** `[0, 1, 2, 3]` (valid topological sequence with no circular deadlocks)

```
Prerequisites: [1<-0, 2<-0, 3<-1, 3<-2]
  0 -> 1, 0 -> 2, 1 -> 3, 2 -> 3

indegree = [0, 1, 1, 2]
queue = [0]; order = []

Pop 0 -> order=[0]; reduce indegree of 1, 2 to 0 -> queue=[1,2]
Pop 1 -> order=[0,1]; indegree[3]=1
Pop 2 -> order=[0,1,2]; indegree[3]=0 -> queue=[3]
Pop 3 -> order=[0,1,2,3]
Result: valid order [0, 1, 2, 3]
```

### Traversal: Dijkstra's Algorithm

**Objective:** Compute the shortest path distances from a single source vertex to all reachable vertices in a non-negative weighted graph in $O((V + E) \log V)$ time using a priority queue.
- **Input:** Weighted graph with source `0`, edges `(0,1,w=4), (0,2,w=1), (1,3,w=2), (2,3,w=5)`
- **Expected Output:** `dist = [0, 4, 1, 6]` (minimum distances from source `0` to nodes `0, 1, 2, 3`)

```
Graph with weights:
    0 --4-- 1
    |       |
    1       2
    |       |
    2 --5-- 3

dist = [0, inf, inf, inf], heap = [(0,0)]

Pop (0,0): neighbors 1(w=4), 2(w=1)
  dist[1]=4, dist[2]=1  -> heap=[(1,2),(4,1)]
Pop (1,2): neighbors 0, 3(w=5)
  dist[3]=6  -> heap=[(4,1),(6,3)]
Pop (4,1): neighbor 3, new=6 (no improvement)
Pop (6,3): done
Result: dist = [0, 4, 1, 6]
```

### Code
```python
def bfs(graph, start):
    visited, queue, order = {start}, deque([start]), []
    while queue:
        node = queue.popleft(); order.append(node)
        for nb in graph[node]:
            if nb not in visited:
                visited.add(nb); queue.append(nb)
    return order

def num_islands(grid):
    if not grid: return 0
    rows, cols, count = len(grid), len(grid[0]), 0
    def dfs(r, c):
        if r < 0 or r >= rows or c < 0 or c >= cols or grid[r][c] != '1': return
        grid[r][c] = '0'
        dfs(r+1, c); dfs(r-1, c); dfs(r, c+1); dfs(r, c-1)
    for r in range(rows):
        for c in range(cols):
            if grid[r][c] == '1':
                count += 1; dfs(r, c)
    return count

def dijkstra(n, graph, start):
    dist = [float('inf')] * n; dist[start] = 0
    heap = [(0, start)]
    while heap:
        d, node = heapq.heappop(heap)
        if d > dist[node]: continue
        for nb, w in graph[node]:
            if d + w < dist[nb]:
                dist[nb] = d + w; heapq.heappush(heap, (dist[nb], nb))
    return dist
```

### LeetCode Practice
- [200. Number of Islands](https://leetcode.com/problems/number-of-islands/)
- [133. Clone Graph](https://leetcode.com/problems/clone-graph/)
- [207. Course Schedule](https://leetcode.com/problems/course-schedule/)
- [417. Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/)
- [127. Word Ladder](https://leetcode.com/problems/word-ladder/)
- [269. Alien Dictionary](https://leetcode.com/problems/alien-dictionary/)
- [743. Network Delay Time](https://leetcode.com/problems/network-delay-time/)
- [994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)

---

## 14. Recursion & Backtracking

### Why This Matters

Recursion is the "divide and conquer" mindset — solve a problem by solving smaller versions of it. Trees, graphs, sorting (merge sort, quicksort), and DP all lean on it. Backtracking is recursion's systematic search: you explore a possibility, and if it fails, you *undo* it and try the next. This is how you solve "generate all subsets," "find all permutations," "solve sudoku," "place N queens," or "search for a path in a maze." MAANG loves backtracking because it tests whether you can think in terms of **decision trees** — and it's a great filter for sloppy implementers who forget to undo their choices.

### Core Concepts
- **Recursion**: base case + recursive call on a smaller input.
- **Backtracking**: choose → explore → un-choose. The "un-choose" step is what makes it backtracking.
- **Pruning**: cut off branches that can't possibly lead to a valid solution.

### Visualization: Recursion Tree for Subsets

```
nums = [1, 2, 3]

                     []                     <- start
                  /  |  \
               [1]  [2]  [3]                <- choose 1st
              /  \    \
           [1,2][1,3] [2,3]                 <- choose 2nd
            |
         [1,2,3]                            <- choose 3rd

All subsets: [], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]
```

### Visualization: N-Queens (4x4 partial)

```
Board state at row=2 (successful placement):
   . Q . .      row 0: col 1
   . . . Q      row 1: col 3
   Q . . .      row 2: col 0
   . . . .      row 3: pending

Constraint sets:
  cols       = {1, 3, 0}
  diag1 (r-c)= {-1, -2, 2}
  diag2 (r+c)= {1, 4, 2}
```

### Traversal: Backtracking on Permutations

**Objective:** Enumerate all $n!$ unique permutations of a list of distinct elements by recursively choosing unused elements, exploring, and backtracking (unchoosing).
- **Input:** `nums = [1, 2, 3]`
- **Expected Output:** `[[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]` (all 6 unique permutations)

```
nums = [1, 2, 3]

path=[]                choose 1
path=[1]               choose 2
path=[1,2]             choose 3
path=[1,2,3]  -> OUTPUT [1,2,3]
path=[1,2]             un-choose 3
path=[1]               un-choose 2, choose 3
path=[1,3]             choose 2
path=[1,3,2]  -> OUTPUT [1,3,2]
... continues for all 6 permutations
```

### Code
```python
def subsets(nums):
    result = []
    def bt(start, path):
        result.append(path[:])
        for i in range(start, len(nums)):
            path.append(nums[i])
            bt(i + 1, path)
            path.pop()
    bt(0, [])
    return result

def permute(nums):
    result = []
    def bt(path):
        if len(path) == len(nums): result.append(path[:]); return
        for num in nums:
            if num not in path:
                path.append(num); bt(path); path.pop()
    bt([])
    return result

def combination_sum(candidates, target):
    result = []
    def bt(start, path, remaining):
        if remaining == 0: result.append(path[:]); return
        if remaining < 0: return
        for i in range(start, len(candidates)):
            path.append(candidates[i])
            bt(i, path, remaining - candidates[i])
            path.pop()
    bt(0, [], target)
    return result
```

### LeetCode Practice
- [78. Subsets](https://leetcode.com/problems/subsets/)
- [46. Permutations](https://leetcode.com/problems/permutations/)
- [39. Combination Sum](https://leetcode.com/problems/combination-sum/)
- [17. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
- [79. Word Search](https://leetcode.com/problems/word-search/)
- [51. N-Queens](https://leetcode.com/problems/n-queens/)
- [131. Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)

---

## 15. Dynamic Programming

### Why This Matters

DP is the hardest topic for most candidates — and the highest-leverage one to master. It applies whenever a problem has **overlapping subproblems** (you solve the same subproblem many times) and **optimal substructure** (the optimum of a big problem is composed of optima of smaller ones). Naive recursion blows up exponentially; DP memoizes or tabulates to bring it down to polynomial. DP appears in ~15% of MAANG interviews, and it's the pattern that most often separates "pass" from "hire." If you can recognize DP (words like "number of ways," "minimize cost," "can we reach") and state the recurrence, you're golden.

### Core Concepts
- **Top-down (memoization)**: recursion + cache.
- **Bottom-up (tabulation)**: iterative table fill.
- **State**: what parameters uniquely identify a subproblem.
- **Transition**: how a state depends on smaller states.

### Visualization: DP Table (Climbing Stairs)

```
n = 5

dp[0]=1, dp[1]=1
dp[i] = dp[i-1] + dp[i-2]

Index:  0  1  2  3  4  5
dp:     1  1  2  3  5  8
            ^  ^  ^  ^
            sum of prev two
Answer: dp[5] = 8
```

### Visualization: DP Table (Unique Paths 3x3)

```
Grid:         DP table (paths to reach cell):
  . . .        1  1  1
  . . .        1  2  3
  . . .        1  3  6

dp[i][j] = dp[i-1][j] + dp[i][j-1]
Answer = dp[2][2] = 6
```

### Visualization: LCS Table

```
text1 = "abcde", text2 = "ace"

     ""  a  c  e
  ""  0  0  0  0
  a   0  1  1  1
  b   0  1  1  1
  c   0  1  2  2
  d   0  1  2  2
  e   0  1  2  3   <- LCS length = 3 ("ace")
```

### Traversal: Coin Change

**Objective:** Compute the minimum number of coins needed to make up a target amount in $O(S \times n)$ time using 1D dynamic programming (bottom-up tabulation).
- **Input:** `coins = [1, 2, 5]`, `amount = 11`
- **Expected Output:** `3` (minimum coins required: `5 + 5 + 1 = 11`)

```
coins = [1, 2, 5], amount = 11

dp = [inf, inf, ..., inf]  (size 12); dp[0] = 0

Fill:
  coin=1: dp[1]=1, dp[2]=2, ..., dp[11]=11
  coin=2: dp[2]=min(2, 1)=1, dp[3]=2, dp[4]=2, ...
  coin=5: dp[5]=min(5, 1)=1, dp[6]=2, dp[10]=2, dp[11]=min(11, 3)=3
Answer: dp[11] = 3  (5+5+1)
```

### Code
```python
def climb_stairs(n):
    if n <= 2: return n
    a, b = 1, 2
    for _ in range(3, n + 1):
        a, b = b, a + b
    return b

def coin_change(coins, amount):
    dp = [float('inf')] * (amount + 1); dp[0] = 0
    for coin in coins:
        for i in range(coin, amount + 1):
            dp[i] = min(dp[i], dp[i - coin] + 1)
    return dp[amount] if dp[amount] != float('inf') else -1

def longest_common_subsequence(t1, t2):
    m, n = len(t1), len(t2)
    dp = [[0] * (n + 1) for _ in range(m + 1)]
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if t1[i-1] == t2[j-1]: dp[i][j] = dp[i-1][j-1] + 1
            else: dp[i][j] = max(dp[i-1][j], dp[i][j-1])
    return dp[m][n]
```

### LeetCode Practice
- [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
- [198. House Robber](https://leetcode.com/problems/house-robber/)
- [213. House Robber II](https://leetcode.com/problems/house-robber-ii/)
- [322. Coin Change](https://leetcode.com/problems/coin-change/)
- [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)
- [1143. Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/)
- [139. Word Break](https://leetcode.com/problems/word-break/)
- [62. Unique Paths](https://leetcode.com/problems/unique-paths/)
- [72. Edit Distance](https://leetcode.com/problems/edit-distance/)
- [416. Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)

---

## 16. Greedy Algorithms

### Why This Matters

Greedy is the "just take the best option at each step" approach — simple, fast, and surprisingly powerful *when the problem permits it*. A greedy algorithm never reconsiders past choices; it commits to a locally optimal move and trusts that this leads to a global optimum. The catch: greedy doesn't always work. Knowing *when* greedy is valid (exchange argument, matroid structure) separates a novice from a pro. Problems like interval scheduling, Huffman coding, minimum spanning trees, and coin change (some variants) have elegant greedy solutions that beat DP in both time and code complexity.

### Core Concepts
- Greedy choice property: a local optimum is part of some global optimum.
- Optimal substructure: optimal solution contains optimal sub-solutions.
- Prove correctness via **exchange argument** or induction — interviewers love this.

### Visualization: Activity Selection / Non-Overlapping Intervals

```
Intervals: [1,3], [2,4], [3,5], [4,6], [5,7]
After sorting by end time:
  [1,3], [2,4], [3,5], [4,6], [5,7]

Pick [1,3]                        end=3
Next start >= 3? [2,4] no
Next start >= 3? [3,5] yes -> pick end=5
Next start >= 5? [4,6] no
Next start >= 5? [5,7] yes -> pick
Result: [1,3], [3,5], [5,7]  (3 intervals)
```

### Traversal: Jump Game

**Objective:** Determine if the last index is reachable in $O(n)$ time and $O(1)$ space by greedily maintaining the maximum reachable index so far.
- **Input:** `nums = [2, 3, 1, 1, 4]`
- **Expected Output:** `True` (last index `4` is reachable from start)

```
nums = [2, 3, 1, 1, 4]

i  nums[i]  max_reach  i>max_reach?
0   2       max(0,2)=2  no
1   3       max(2,4)=4  no
2   1       max(4,3)=4  no
3   1       max(4,4)=4  no
4   4       max(4,8)=8  no
Result: TRUE (can reach end)
```

### Traversal: Gas Station

**Objective:** Find the unique starting gas station that allows completing a clockwise circuit in $O(n)$ time and $O(1)$ space using a greedy single-pass net-deficit check.
- **Input:** `gas = [1, 2, 3, 4, 5]`, `cost = [3, 4, 5, 1, 2]`
- **Expected Output:** `3` (starting at station index `3` allows a complete circular tour)

```
gas  = [1, 2, 3, 4, 5]
cost = [3, 4, 5, 1, 2]

i=0: net=-2  total=-2  cur=-2 -> reset start=1, cur=0
i=1: net=-2  total=-4  cur=-2 -> reset start=2, cur=0
i=2: net=-2  total=-6  cur=-2 -> reset start=3, cur=0
i=3: net=+3  total=-3  cur=+3
i=4: net=+3  total=0   cur=+6
total >= 0 -> answer = start = 3
```

### Code
```python
def can_jump(nums):
    max_reach = 0
    for i, jump in enumerate(nums):
        if i > max_reach: return False
        max_reach = max(max_reach, i + jump)
    return True

def can_complete_circuit(gas, cost):
    total = cur = start = 0
    for i in range(len(gas)):
        diff = gas[i] - cost[i]
        total += diff; cur += diff
        if cur < 0: start = i + 1; cur = 0
    return start if total >= 0 else -1

def erase_overlap_intervals(intervals):
    intervals.sort(key=lambda x: x[1])
    count, end = 0, float('-inf')
    for s, e in intervals:
        if s >= end: end = e
        else: count += 1
    return count
```

### LeetCode Practice
- [55. Jump Game](https://leetcode.com/problems/jump-game/)
- [45. Jump Game II](https://leetcode.com/problems/jump-game-ii/)
- [134. Gas Station](https://leetcode.com/problems/gas-station/)
- [435. Non-Overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)
- [763. Partition Labels](https://leetcode.com/problems/partition-labels/)
- [122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

---

## 17. Union Find (Disjoint Set Union)

### Why This Matters

Union-Find answers one specific question incredibly fast: *"Are these two things in the same group?"* It shines when groups are being **merged over time** — think of a social network where friendships form, and you want to know if two users are in the same friend circle. Without union-find, you'd re-run graph traversal after every merge (O(n) each). With path compression and union by rank, each operation is nearly O(1) amortized. It's used in Kruskal's MST, cycle detection in undirected graphs, image segmentation, and grouping problems (accounts merge, redundant connections). Simple to code, deceptively powerful.

### Core Concepts
- **Find(x)**: returns x's group representative (root).
- **Union(x, y)**: merge the two groups.
- **Path compression**: flatten the tree as you `find` — near-constant time.
- **Union by rank**: attach smaller tree under larger to keep trees shallow.

### Visualization: Union-Find Tree

```
Initial: each node is its own parent
  0  1  2  3  4

union(0,1):   0<-1  2  3  4      parent[1]=0
union(2,3):   0<-1  2<-3  4      parent[3]=2
union(1,3):   0<-1<-2<-3  4      parent[2]=0 (root of 3 was 2, root of 2 = 0)

find(3):
  parent[3]=2 -> parent[2]=0 -> parent[0]=0 (root)
  With path compression: set parent[3]=0, parent[2]=0
```

### Traversal: Redundant Connection

**Objective:** Identify the edge that creates a cycle in an undirected graph in near $O(n)$ time using Disjoint Set Union (Union-Find) with path compression.
- **Input:** `edges = [[1, 2], [1, 3], [2, 3]]`
- **Expected Output:** `[2, 3]` (the edge whose addition creates an undirected cycle)

```
edges = [[1,2], [1,3], [2,3]]

Union(1,2): roots 1,2 -> merge. parent[2]=1
Union(1,3): roots 1,3 -> merge. parent[3]=1
Union(2,3): roots both 1 (find(2)=1, find(3)=1) -> CYCLE!
Result: [2, 3] is the redundant edge
```

### Code
```python
class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [0] * n
        self.components = n
    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    def union(self, x, y):
        rx, ry = self.find(x), self.find(y)
        if rx == ry: return False
        if self.rank[rx] < self.rank[ry]: rx, ry = ry, rx
        self.parent[ry] = rx
        if self.rank[rx] == self.rank[ry]: self.rank[rx] += 1
        self.components -= 1
        return True
```

### LeetCode Practice
- [323. Number of Connected Components](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
- [261. Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/)
- [684. Redundant Connection](https://leetcode.com/problems/redundant-connection/)
- [721. Accounts Merge](https://leetcode.com/problems/accounts-merge/)

---

## 18. Bit Manipulation

### Why This Matters

Bits are the rawest form of data. Bit manipulation lets you do things in O(1) that seem impossible — count set bits, find the single non-duplicate, swap two numbers without a temp, check power-of-two, iterate over subsets via bitmasks. In interviews, bit problems are rare but distinctly test low-level fluency. XOR's self-inverse property (`a ^ a = 0`) is the star: it makes "find the element appearing once among duplicates" trivial. Bitmask DP (subset enumeration) is also a powerful tool for problems with small state spaces.

### Core Concepts
- XOR `^`: `a ^ a = 0`, `a ^ 0 = a` — commutative and associative.
- `x & (x-1)`: clears the lowest set bit.
- `x & (-x)`: isolates the lowest set bit.
- `x >> 1` divides by 2; `x << 1` multiplies by 2.

### Visualization: Bitwise Operations

```
a = 12 = 1 1 0 0
b = 10 = 1 0 1 0

a & b  = 1 0 0 0 = 8       AND
a | b  = 1 1 1 0 = 14      OR
a ^ b  = 0 1 1 0 = 6       XOR
~a     = ...111 0011       NOT (two's complement)
a << 1 = 1 1 0 0 0 = 24    Left shift (×2)
a >> 1 = 0 1 1 0   = 6     Right shift (÷2)
```

### Traversal: Counting Bits (Brian Kernighan)

**Objective:** Count set bits (1s) in an integer in $O(\text{set bits})$ time by repeatedly clearing the lowest set bit using `n &= (n - 1)`.
- **Input:** `n = 13` (binary `1101`)
- **Expected Output:** `3` (total number of set bits / 1s)

```
n = 13 = 1101

Iteration 1: n=1101, n-1=1100, n & (n-1) = 1100  count=1
Iteration 2: n=1100, n-1=1011, n & (n-1) = 1000  count=2
Iteration 3: n=1000, n-1=0111, n & (n-1) = 0000  count=3
Iteration 4: n=0000, loop ends

Total set bits = 3
```

### Traversal: Single Number (XOR)

**Objective:** Find the single non-duplicate number in an array where every other element appears twice in $O(n)$ time and $O(1)$ space using XOR bitwise cancellation ($x \oplus x = 0$).
- **Input:** `nums = [4, 1, 2, 1, 2]`
- **Expected Output:** `4` (the unique number that appears only once)

```
nums = [4, 1, 2, 1, 2]

result = 0
  XOR 4: 0 ^ 4 = 4
  XOR 1: 4 ^ 1 = 5
  XOR 2: 5 ^ 2 = 7
  XOR 1: 7 ^ 1 = 6
  XOR 2: 6 ^ 2 = 4
Result = 4  (the element appearing once)

Why? XOR is commutative & associative:
  4 ^ (1^1) ^ (2^2) = 4 ^ 0 ^ 0 = 4
```

### Code
```python
def single_number(nums):
    result = 0
    for num in nums: result ^= num
    return result

def count_bits(n):
    count = 0
    while n:
        n &= (n - 1); count += 1
    return count

def is_power_of_two(n):
    return n > 0 and (n & (n - 1)) == 0
```

### LeetCode Practice
- [136. Single Number](https://leetcode.com/problems/single-number/)
- [191. Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)
- [338. Counting Bits](https://leetcode.com/problems/counting-bits/)
- [268. Missing Number](https://leetcode.com/problems/missing-number/)
- [190. Reverse Bits](https://leetcode.com/problems/reverse-bits/)
- [371. Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers/)

---

## 19. Intervals & Merge Intervals

### Why This Matters

Interval problems model real-world scheduling: meetings, reservations, CPU time slots, delivery windows. The core insight is almost always *sort by start time*, then sweep left-to-right, merging overlaps or tracking concurrent intervals. This converts chaotic overlap detection into a clean linear scan. Interviewers love interval problems because they mix sorting, greedy thinking, and heap usage — a microcosm of interview skills in one problem. Meeting Rooms II (minimum rooms for all meetings) is a MAANG favorite and requires the "sweep line" or "heap of end times" pattern.

### Core Concepts
- Sort by start (or end, depending on the variant).
- Two intervals overlap iff `a.start < b.end and b.start < a.end`.
- For "max concurrency," use a min-heap of end times.

### Visualization: Merge Intervals

```
Intervals: [1,3], [2,6], [8,10], [15,18]

Sort by start: [1,3], [2,6], [8,10], [15,18]

  1---3
    2-----6        [1,3] and [2,6] overlap (2 <= 3) -> merge to [1,6]

  1-------6
          8--10    [1,6] and [8,10] don't overlap -> keep [1,6]

  1-------6   8--10   15----18
                    no overlap -> keep all
Result: [[1,6], [8,10], [15,18]]
```

### Traversal: Insert Interval

**Objective:** Insert a new interval into a sorted list of non-overlapping intervals and merge overlapping intervals in $O(n)$ time.
- **Input:** `intervals = [[1, 3], [6, 9]]`, `newInterval = [2, 5]`
- **Expected Output:** `[[1, 5], [6, 9]]` (intervals merged into non-overlapping list)

```
intervals = [[1,3], [6,9]], newInterval = [2,5]

Phase 1: add intervals ending before new starts
  [1,3].end=3 >= 2 -> stop
Phase 2: merge overlapping
  [1,3] overlaps with [2,5]: newInterval = [min(1,2), max(3,5)] = [1,5]
  [6,9].start=6 > 5 -> stop
  Append [1,5]  -> result = [[1,5]]
Phase 3: add remaining
  result = [[1,5], [6,9]]
```

### Traversal: Meeting Rooms II

**Objective:** Determine the minimum number of conference rooms required to hold all scheduled meetings in $O(n \log n)$ time using two pointers on sorted start and end arrays.
- **Input:** `intervals = [[0, 30], [5, 10], [15, 20]]`
- **Expected Output:** `2` (minimum conference rooms required concurrently)

```
intervals = [[0,30], [5,10], [15,20]]

Sort by start: [0,30], [5,10], [15,20]

i=0: heap=[30]
i=1: 5 < heap[0]=30 -> conflict, add room. heap=[10, 30]
i=2: 15 > heap[0]=10 -> reuse room, pop then push. heap=[20, 30]

Max rooms needed = heap size = 2
```

### Code
```python
def merge_intervals(intervals):
    intervals.sort(key=lambda x: x[0])
    merged = []
    for interval in intervals:
        if not merged or merged[-1][1] < interval[0]:
            merged.append(interval)
        else:
            merged[-1][1] = max(merged[-1][1], interval[1])
    return merged

def min_meeting_rooms(intervals):
    intervals.sort(key=lambda x: x[0])
    heap = []
    for start, end in intervals:
        if heap and heap[0] <= start: heapq.heappop(heap)
        heapq.heappush(heap, end)
    return len(heap)
```

### LeetCode Practice
- [56. Merge Intervals](https://leetcode.com/problems/merge-intervals/)
- [57. Insert Interval](https://leetcode.com/problems/insert-interval/)
- [435. Non-Overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)
- [253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/)
- [452. Minimum Number of Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)

---

## 20. Tries

### Why This Matters

Tries (prefix trees) are the data structure behind **autocomplete, spell-checkers, and IP routing**. When you need to answer prefix-based queries — "do any words start with 'app'?" — a hash map can't help you without scanning every key. A trie stores words character-by-character down a tree, so prefix lookups are O(length of prefix) regardless of how many words are stored. This makes them essential for search suggestions (Google autocomplete), dictionary word games (Boggle, Word Search II), and efficient string matching. If a problem mentions "prefix," "starts with," or "all words matching a pattern," a trie is your answer.

### Core Concepts
- Each node represents a character; children are a map from char → node.
- `is_end` marks word boundaries.
- Both insert and search are O(L) where L is word length.

### Visualization: Trie Structure

```
Insert: "cat", "car", "card", "care", "dog"

                    root
                   /    \
                  c      d
                  |      |
                  a      o
                  |      |
                  t/r    g (end)
                 / \
                (t) r
                    |
                    d/e
                   / \
                 (d) (e)

Legend:  (t) = end of word marker
Words: cat, car, card, care, dog
Prefix "car" matches: car, card, care
```

### Traversal: Insert + Search "card"

**Objective:** Insert strings and look up prefixes or whole words in $O(L)$ time (where $L$ is word length) using a Trie (prefix tree).
- **Input:** Inserted words: `["cat", "car", "card", "care", "dog"]`; queries: `search("car")`, `search("ca")`, `starts_with("ca")`
- **Expected Output:** `search("car") -> True`, `search("ca") -> False`, `starts_with("ca") -> True`

```
insert("card"):
  root -> c (new)
       -> a (new)
       -> r (new)
       -> d (new, mark is_end=True)

search("car"):
  root -> c -> a -> r  (is_end=True)
  Return True

search("ca"):
  root -> c -> a       (is_end=False)
  Return False (prefix only)

starts_with("ca"):
  root -> c -> a       (both exist)
  Return True
```

### Code
```python
class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
    def insert(self, word):
        node = self.root
        for ch in word:
            if ch not in node.children:
                node.children[ch] = TrieNode()
            node = node.children[ch]
        node.is_end = True
    def search(self, word):
        node = self.root
        for ch in word:
            if ch not in node.children: return False
            node = node.children[ch]
        return node.is_end
    def starts_with(self, prefix):
        node = self.root
        for ch in prefix:
            if ch not in node.children: return False
            node = node.children[ch]
        return True
```

### LeetCode Practice
- [208. Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)
- [211. Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure/)
- [212. Word Search II](https://leetcode.com/problems/word-search-ii/)
- [648. Replace Words](https://leetcode.com/problems/replace-words/)

---

## 21. Matrix Manipulation

### Why This Matters

A 2D matrix is just an array of arrays — but matrix problems test your ability to reason about **two dimensions simultaneously**. Rotating, spiral-traversing, marking zeroes in-place, and searching sorted matrices all require careful index bookkeeping. These problems are common at MAANG because they closely resemble real work — image processing, game boards, and grid-based simulations. The in-place rotation trick (transpose + reverse) and the "use first row/col as flags" trick for set-matrix-zeroes are elegant optimizations interviewers love to see.

### Core Concepts
- `matrix[i][j]`: row `i`, column `j`.
- For spiral: maintain four boundaries (top, bottom, left, right).
- In-place tricks: transpose + reverse for 90° rotation; first row/col as flags for zeroing.

### Visualization: Matrix Traversals

```
Original:          Spiral:           Rotate 90°:
1  2  3            -> 1,2,3          Transpose:     Reverse rows:
4  5  6            -> 6,9            1 4 7          7 4 1
7  8  9            -> 8,7            2 5 8          8 5 2
                   -> 4,5            3 6 9          9 6 3
                   order: 1,2,3,6,9,8,7,4,5
```

### Traversal: Spiral Order

**Objective:** Traverse all elements of an $M \times N$ matrix in clockwise spiral order in $O(M \times N)$ time by systematically shrinking four boundary walls (`top`, `bottom`, `left`, `right`).
- **Input:** `matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
- **Expected Output:** `[1, 2, 3, 6, 9, 8, 7, 4, 5]`

```
matrix = [[1,2,3],[4,5,6],[7,8,9]]

top=0,bot=2,left=0,right=2

Pass 1 top row: [1,2,3]      top=1
Pass 2 right col: [6,9]      right=1
Pass 3 bot row (reversed): [8,7]    bot=1
Pass 4 left col (reversed): [4]     left=1

Loop again (top=1<=bot=1, left=1<=right=1):
Pass 5 top row: [5]         top=2

Result: [1,2,3,6,9,8,7,4,5]
```

### Traversal: Rotate 90°

**Objective:** Rotate an $N \times N$ matrix 90 degrees clockwise in-place in $O(N^2)$ time and $O(1)$ space by transposing across the main diagonal and reversing each row.
- **Input:** `matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]`
- **Expected Output:** `[[7, 4, 1], [8, 5, 2], [9, 6, 3]]` (rotated 90 degrees clockwise in-place)

```
Original:      Transpose:     Reverse each row:
1 2 3          1 4 7          7 4 1
4 5 6    ->    2 5 8    ->    8 5 2
7 8 9          3 6 9          9 6 3
```

### Code
```python
def spiral_order(matrix):
    result = []
    top, bot = 0, len(matrix) - 1
    left, right = 0, len(matrix[0]) - 1
    while top <= bot and left <= right:
        for c in range(left, right + 1): result.append(matrix[top][c])
        top += 1
        for r in range(top, bot + 1): result.append(matrix[r][right])
        right -= 1
        if top <= bot:
            for c in range(right, left - 1, -1): result.append(matrix[bot][c])
            bot -= 1
        if left <= right:
            for r in range(bot, top - 1, -1): result.append(matrix[r][left])
            left += 1
    return result

def rotate(matrix):
    n = len(matrix)
    for i in range(n):
        for j in range(i + 1, n):
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
    for row in matrix:
        row.reverse()
```

### LeetCode Practice
- [54. Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)
- [48. Rotate Image](https://leetcode.com/problems/rotate-image/)
- [73. Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/)
- [74. Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)
- [79. Word Search](https://leetcode.com/problems/word-search/)

---


### Time Management (45 min interview)

```
+----------------------+---------+
| Phase                | Minutes |
+----------------------+---------+
| Understand + clarify |   5     |
| Plan approach        |   5     |
| Code                 |  20     |
| Test & edge cases    |  10     |
| Optimize / discuss   |   5     |
+----------------------+---------+
```

### Pattern Signal Cheat Sheet

| Phrase in problem | Likely pattern |
|---|---|
| "sorted array" + "pair" | Two Pointers |
| "substring" / "subarray" / "contiguous" | Sliding Window |
| "all possible" / "generate all" | Backtracking |
| "minimize the maximum" | Binary Search on Answer |
| "Kth largest" / "top K" | Heap |>
| "connected components" / "groups" | Union-Find |
| "number of ways" / "min/max cost" | Dynamic Programming |
| "prefix" / "autocomplete" | Trie |
| "shortest path" / "levels" | BFS |
| "detect cycle" | DFS / Union-Find |

### STAR Method for Behavioral

```
S - Situation:  Context (project, team, timeframe)
T - Task:       What was your responsibility?
A - Action:     What did YOU specifically do? (use "I", not "we")
R - Result:     Quantified outcome ("reduced latency 40%")

Prepare 5–7 STAR stories covering:
  - Ownership / leadership
  - Conflict resolution
  - Failure + learning
  - Customer obsession
  - Delivering results under pressure
```

### Recommended Study Resources

| Resource | Purpose |
|---|---|
| [LeetCode](https://leetcode.com/problemset/all/) | Solve all 130 problems from the checklist |
| [NeetCode 150](https://neetcode.io/practice) | Curated pattern-based list |
| [Blind 75](https://leetcode.com/list/xi4ci4ig/) | Original MAANG essentials |
| [AlgoMonster](https://algo.monster/) | Visual explanations |
| [VisuAlgo](https://visualgo.net/en) | Interactive data structure animations |

---

> **Final Advice:** Consistency beats intensity. Solve 2–3 problems daily, review your solutions, and focus on **patterns** rather than memorizing individual problems. Use the **verbal explanations** to understand *why* each concept exists, the **visualizations** to build intuition, the **traversals** to trace execution step-by-step, and the **per-section LeetCode URLs** to practice immediately. Good luck! 🚀

---

**How to save this file:**

1. Copy the entire content above.
2. Paste into a text editor (VS Code, Notepad, etc.).
3. Save as `MAANG_DSA_Playbook.md`.
4. Open in any Markdown viewer (VS Code preview, Obsidian, Typora, GitHub).
5. For best viewing, use a Markdown renderer that supports tables, code blocks, and task checkboxes.
