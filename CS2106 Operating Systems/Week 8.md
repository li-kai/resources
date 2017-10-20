# Dis j o i n t Memory Schemes

## Paging

Make memory into many pages of very small sizes. (4kb)

In the logical memory, although they are sequential, they may not be actually ordered sequentially in the physical memory.

Offset for logical memory is always relative to the frame of physical memory. E.g. 2357 / 1000kb page size = offset 357 from frame.

### Making it work

Logical memory, page table, physical memory

Logical memory allows processes to access memory without knowing underlying set up.

Page table is an array where `pageTable[pageNumber] = frameNumber`.

Physical memory is the actual hardware, split into tiny fixed size frames.

#### Logical Address -> Physical address

1. Keep frame size as a power of 2
1. Physical frame size == Logical page size

Type | Page Number | Offset
- | - | -
Logical address | `p` of (m - n) bits | `d` of n bits
Physical address | `f` | `d` of n bits

Issue: 2 memory loads for accessing physical address
Solution: Use a cache to speed up, known as Translation Look-Aside Buffer (TLB)

Paging removes external fragmentation
- No left-over physical memory region
- All free frame can be used with no wastage

Paging can still have internal fragmentation
- Logical memory space may not be multiple of
page size

### Translation Look-Aside Buffer (TLB)

Modern processors provide specialized on- chip component to support paging. TLB acts as a cache of a few page table entries.

Logical address translation with TLB:
Use page number to search TLB associatively

1. Entry found (TLB-Hit):
    + Frame number is retrieved to generate physical address
1. Entry not found (TLB-Miss):
    + Memory access to access the full page table
    + Retrieved frame number is used to generate physical address and update TLB

### Protection

The basic paging scheme can be easily extended to provide memory protection between processes using:

- Access-Right Bits
- Valid Bit
- Access Right Bits: writable, readable, executable bits

#### Valid bit

Indicates at each page table entry whether it is valid for process to access.<br/>
OS sets this bit and out-of-range access will be caught by OS.

#### Page sharing

Using the same frame in page table enables shared memory region.

Copy on write: Copy paging table, only duplicate memory when attempting to write the memory

## Segmentation

Each segment is mapped to a contiguous physical memory region with a base address and a limit.

The segmentation name is usually represented as a single number known as segment id.

Segmentation has hardware support to make this fast.

Logical address `<SegID, Offset>`: SegID is used to look up `<Base, Limit>` of the segment in a segment table.

- Physical Address PA = Base + Offset
- Offset < Limit for valid access

Pros:
- Each segment is an independent contiguous memory space
- Can grow / shrink independently
- Can be protected / shared independently

Cons:
- Segmentation requires variable-size contiguous memory regions
- can cause external fragmentation

## Segmentation with Paging

Each segment now contains multiple pages and hence their own page table.

`S` | `P` | `D`
- | - | -
Segment number | Page number | Offset
 - | Must be smaller than page limit | -


