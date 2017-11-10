# FAT

FAT entry contains either
- FREE code
- Block number
- EOF code
- BAD code

FAT | Root Directory | Data Blocks
Parition details | Some directory info | File Information, File Details and Directory Information

## Directory Structure and File Information

Directory: Special type of folder

Data block of a directory

- Directory Entry
    [ File Name - 8 bytes | Extension - 3 bytes | Attributes - 1 bytes | Directory Entry | Creation Date + Time - 4 bytes | First Disk - 2 bytes | File Size in Bytes - 4 bytes ]

## Directory Entries

Look up from Root Directory to find Directory Entries of folder


### Deleting

Lab5 / ex1.c

#### Theoretical

1. Look up Directory Entries
1. Find Lab5, remove ex1.c in it
1. Look up FAT entry, delete entry to FREE
1. Write out data blocks in disk to 0

#### Actual

1. Set first byte of file in Directory Entries to `E5`
1. Look up FAT entry, set entries to FREE

### Calculating Free Space

Count `FREE` in FAT.

## FAT Variants

FAT16 = 64 mb if 1kb block size

Therefore to increase size, we make a cluster (larger block size), then 4kb cluster gives 256mb in FAT16.

However, this naturally leads to internal fragmentation.

### Long File Name Support

Use multiple directory entries for a file with long
file name
+ Use a previously invalid file attribute so non-VFAT applications can ignore these additional entries
+ Use the first byte in the filename to indicate sequence

# Extended-2 File System

Partitions contain

Boot | Block Group 0 | Block Group 0

Block Group contain

Super Block | Group Descriptors | Block bitmap | I-node bitmap | I-node table | Data blocks

### Super Block

- Describe the whole file system
- Includes:
    + Total I-Nodes number, I-Nodes per group
    + Total disk blocks, Disk Blocks per group, etc
- Duplicated in each block group for redundancy

### Group Descriptors
- Describe each of the block group
    + Number of free disk blocks, free I-nodes
    + Location of the bitmaps
- Duplicated in each block group as well

### I-Node Table

Metadata | Data Block Pointers | Reference Count

Not enough data block pointers? Add more indirect blocks as needed.

4 bytes block address, 1KB disk block

This allows 256KB of file at every data block pointer layer.

### Data Descriptors

[ I-Node Number | Entry Size (Offset to next block) | Entry Type | Name Length | Name ]

Everything describe  Parition Details
Data Blocks descript Directory Information

### I-Node Table

I-Node Table[2] = I-Node[15] -> Disk Block 15 ->

REFER TO LECTURE NOTES, too many parts

### Reference Count

Increment when a link is created, and decrement when link deleted

That way you know whether it is possible to remove a file due to hard links
