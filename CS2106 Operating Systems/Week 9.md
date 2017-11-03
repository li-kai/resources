# Page Checking

## Accessing Page X

1.  Check if page X is valid in page table (memory resident)
1. If
    - Valid, access physical memory location. Done.
    - Invalid, continue
1. If not valid, throw page fault
1. Locate page X in secondary storage
1. Load page X into a physical memory
1. Update table
1. Go to step 1

## Justification

If memory access results in page fault most of the time, it causes thrashing as secondary storage access time is much higher than physical memory access time.

But thrashing is unlikely due to Locality Principles, most code spend time on relatively small part of code.

- Temporal Locality: Memory address is likely to be used again
- Spatial Locality: Memory address close to a used location is also likely to be used

### Page Table Sturcture

Page table information is kept with the process information and takes up physical memory space (RAM).

Modern computer systems provide huge logical memory space. Hence huge page table.

Problems:
    - High overhead
    - Fragmented page table as page table occupies several memory pages

#### Direct Paging

Keep all entries in a single table, with 2^p pages with p bits to specify each page.

E.g. Virtual Address: 32 bits. Page Size: 4KB (2^12 bits). Page Table Entry: 2 bytes.<br/>
P = 32 -12 = 20. Page table size = 2^20 * 2 bytes = 2MB

#### 2 Level Paging

Split page table into chunks called Page Tablets. Then have an additional table called a Page Directory.

Now the virtual adress looks like [page dir # | page # | offset ].

M bits to address 2^M of all page tablets.

Advantages

E.g. Virtual Address: 32 bits. Page Size: 4KB (2^12 bits). Page Table Entry: 2 bytes. <br/>
P = 32 -12 = 20. Number of page director entries = 2^30 / 2^11 = 2^9. Overhead = 2^9 * 2 = 1KB. <br/>
Total overhead = 1KB + 12KB = 13KB.

#### Inverted Table

Inverted Page Table, invert the frame number with index in page table.

Virtual Memory Address looks like [ page id | page # | offset ].

Inverted Page Table looks like [PID | P]

### Page Replacement Algorithms

If there is no physical memory frame during a page fault, we need to kick out a page to be replaced.

A good algorithm should reduce the total number of page faults.

#### Optimal Page Replace (OPT)

Time | Memory Reference | Frame | Next Use Time | Fault
- | - | - | - | -
1 | 2 | 2 | 3 | Y
2 | 3 | 2 3 | 3 9 | Y
3 | 2 | 2 3 | 6 9 | N
4 | 1 | 2 3 1 | 6 9 | Y
5 | 5 | 2 3 5 | 6 9 8 | Y
6 | 2 | 2 3 5 | 10 9 8 | N

Unfeasible as you don't know when it will be used next time.

#### First In First Out (FIFO)

Kills off the oldest inserted page.

Time | Memory Reference | Frame | Loaded Time | Fault
- | - | - | - | -
1 | 2 | 2 | 1 | Y
2 | 3 | 2 3 | 1 2 | Y
3 | 2 | 2 3 | 1 2 | N
4 | 1 | 2 3 1 | 1 2 4 | Y
5 | 5 | 5 3 1 | 5 2 4 | Y
6 | 2 | 5 2 1 | 5 6 4 | Y

FIFO violates intuition: If physical frame increases, page fault should decrease.<br/>
In fact, page faults can increase with physical frame.

#### Least Recently Used (LRU)

Time | Memory Reference | Frame | Last Use Time | Fault
- | - | - | - | -
1 | 2 | 2 | 1 | Y
2 | 3 | 2 3 | 1 2 | Y
3 | 2 | 2 3 | 3 2 | N
4 | 1 | 2 3 1 | 3 2 4 | Y
5 | 5 | 2 5 1 | 3 5 4 | Y
6 | 2 | 5 2 1 | 6 5 4 | N

Implementing is not easy due to need of timer.

##### Approaches

1. Use a counter, increment when accessing, but needs heavy calculation
1. Use a "stack", when page X is referenced, move to top of "stack", replacing removes bottom of "stack".

#### Second-Chance Page Replacement (CLOCK)

In linked-list implementation, contain a reference bit for each page. When it is referenced before, give it 1. When the OS wants to kill it, set it to 0 to give it a "second chance". When OS sees a reference bit 0, kill it off.

Time | Memory Reference | Frame | Loaded at time | Reference Bit | Oldest Page | Fault
- | - | - | - | - | - | -
1 | 2 | 2 | 1 | 0 | 2 | Y
2 | 3 | 2 3 | 1 2 | 0 0 | 2 | Y
3 | 2 | 2 3 | 1 2 | 1 0 | 2 | N
4 | 1 | 2 3 1 | 1 2 4 | 1 0 0 | 2 | Y
5 | 5 | 2 5 1 | 5 5 4 | 0 0 0 | 1 | Y
6 | 2 | 2 5 1 | 5 5 4 | 1 0 0 | 1 | N

### Page Allocation Algorithms

- The implicit assumption for page replacement
algorithms discussed:
    - Victim page are selected among pages of the
process that causes page fault
    - Known as local replacement
- If victim page can be chosen among all
physical frames:
    - Process P can take a frame from Process Q by
evicting Q's frame during replacement!
    - Known as global replacement

Insufficient physical frame -> Thrashing

Hard to find right number of frames,
- global replacement
    + Thrashing process "steals" page from other process
    + Causing other process to thrash as well (cascading thrashing)

- local replacement
    + Thrashing a limited to one process
    + But might steal I/O from other processes

Observation that some set of pages will be referenced is constant due to locality.

Transient region - working set changing in size <br/>
Stable region - working set remains constant for some time

Accuracy of region is affected by delta, if too small, we might miss pages in locality, if too big, we might capture pages from different locality.

Given a time frame, OS might be able to allocate suitable amount of frames for process as needed.

