## Partition

Disk partition of hard disk.

Hard disk looks like:

[ Boot Code | Partition Table | Partition 1 | ... | Partition n ]

Each partition looks like:

[ OS Boot Block | Partition Details | Dir structure | Files Info | File Data ]

## File Implementation

Logical view: Collection of logical blocks. When file size is not a multiple of logical block, we may have internal fragmentation.

### Contiguous Block Allocation

Keep track of file and number of blocks allocated.

[file | start | length ]

`+` Easy to access, track <br/>
`-` Only fixed file size or many reallocations

[file | start ] with linked list

`+` Easy to grow, no external fragmentation <br/>
`-` Very slow physically, very slow to reach end of file

[file | start | end ] with linked list

`+` Easy to append <br/>
`-` Still slow physically <br/>
`-` In case of losing a pointer, entire file corrupted

### File Allocation Table (FAT)

[ file | start | length ] with

index | content
- | -
0 | 3
...|
n - 1 |

1. Find file
1. Get start
1. Look up FAT, find index of block
1. Read

`+` Easy to implement, pretty fast, FAT can be in table <br/>
`-` Huge FAT <br/>

### Indexed Allocation

[ file | index block ]

Each index block contains all the pointers for the file, think of a FAT for a single file.

Index block is in hard disk.

`+` Good access, small <br/>
`-` Limited max file size <br/>

### Multilevel Indexed Allocation

[ file | index block ]

Each index block contains all the pointers for the file, think of a FAT for a single file. More levels contain multiple index for multiple files, etc.

Index block is in hard disk.

`+` Good access, small, no max file size <br/>

### Combined scheme

Certain blocks are direct block, some are single level indexed, and more levels as needed.

## Free space management

Need to implement

`allocate`: when file is created or appended

`free`: free disk block to free space list

### Bitmap

Each disk block represented by 1 bit.

`+` Easy to manipulate, small <br/>
`-` Slow <br/>

### Linked list

Keep track of each free disk block at each node.

## Directory Structure

Needs to keep track of files, which maps file name to file information.

### Linked list

Requires a linear search, but we can cache.

### Hash Table

Table of size N

File name is hashed into index K from 0 to N-1.

Usually chained collision resolution is used.

## File System in Action

### `create`

1. Use full pathname to locate the parent directory
    + Search for filename F to avoid duplicates
1. Use free space list to find free disk block(s)
1. Add an entry to parent directory with relevant detail

## Disk I/O scheduling

### Seek

- Looking for track
- 2-10ms
- To find: Sum of all seeks / Number of seeks

### Rotational Latency

- Rotate disk
- Rotation speed 4800 - 15000 rpm
- 12.5ms (4800rpm) to 4ms (15000rpm) per rotation

### Transfer Time

- Time to read to ram
- 9.7 micro second.
- To find: Transfer size / Transfer Rate
    + Transfer size: [X KB / Sector] x [ # of Sectors]

### To optimise disk

Optimise the seeking time.

Algorithm | Pro | Con
- | - | -
FCFS | Easy to implement | Time spent moving disk track
Shortest Seek First | Least time moving | File most needed may be delayed
SCAN (Aka elevator) | Lesser seek time | -
