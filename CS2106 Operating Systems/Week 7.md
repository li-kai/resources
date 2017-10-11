# Memory

CPU registers (~1ns)

CPU Cache (~10ns)

RAM (~100ns)

Hard Disk (~10ms)

## Transient Data

Valid only for limited duration

e.g. Parameters, local variable

## Persistent Data

Valid for entire run of the program

e.g. files

# Managing Memory

OS handles
- Allocation
- Management for process
- Protect memory
- Provide memory related calls
- Manage its own memory

## Without abstraction

Benefits
Execution is transparent
Access is easy

Disadvantage
Two processes have access to same memory region and may tamper with each other

## Using Address Relocation

Recalculate memory references during loading

```asm
lw $1 [4096]
// into
lw $1 [12096]
```

Disadvantage
Slow loading time
Not easy to distinguish memory reference from normal integer constant

## Using Base + Limit registers

Using a special register known as Base Register.
During *compilation* time, calculate new address with Base Register.
Then during loading time, Base Register is now the new address of the process memory space.


Use another special register known as Limit Register. If program access outside of limit, we throw error (segmentation fault).

Disadvantage

We now have to do 2 calcuations for every load & store.

## Using Logical Address

Program's view of memory space may map to different view of address.

# Memory Partitioning

## Fixed Partitioning

OS occupies a small portion.

Physical memory is split into fixed number of partitions

Disadvantage

If process only uses a small portion of allocated memory, there is wastage known as internal fragmentation

## Variable-Size Partition

OS allocates and tracks memory space
OS performs splitting and merging when necessary

OS maintains a linked list of memory sizes.

1) Run best-fit algo to find perfect fit for memory
2) Run first-fit algo to find first memory able to fit
3) Run worst-fit algo to find largest memory able to fit

Disadvantage

External fragmentation - many tiny holes

### Merging and Compaction

Merging: Merge neighbouring empty memories together

O(1)

Compaction: Move occupied partitions over to form one contiguous memory, leaving no holes.

O(n^2)

### Buddy System

1. Partition splitting
1. Fast lookup of free partition
1. Partition de-allocation and coalescind

Repeatedly split your memory of 2^k size into half.

#### Algorithm

1. Start from 0
1. Form array of k blocks given 2^k memory
1. Each block is a linked list, each node containing 2^index size
1. Find `index = ceil(log(requested memory))`
1. Go to index in array
1. Keep looking for free block in link list, and increment index if not available

```python
memory_size = 512
k = Math.log(512)
memory = [linkList for i in range(k)]

def findMem(size_requested):
    block = null
    index = Math.ceil(Math.log(size_requested))
    while (block == null):
        if (element in memory[index]):
            allocate_memory()
        else:
            index += 1

    if (block.size / 2 > size_requested):
        first, second = block.split()

        memory[index - 1].add(first)
        memory[index - 1].add(second)

        block = first

    return block
```

Runtime Analysis
Allocation: O(n) ? O(1)
Deallocation: O(1)
Merging: O(n^2)
