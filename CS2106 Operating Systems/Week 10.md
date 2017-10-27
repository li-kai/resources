## Hard Disks

One disk consists of multiple platers.

All platers can be read at the same time.

As the hard disk rotates, it can read the circumference of the disk, forming what is known as a track.

As your radius is larger as you travel further, you can read more of the disk as it spins. This portion that can be read is known as a sector. Multiple sectors are known as cluster.

We should aim to store information in the cluster as they are closer together.

## File System

Abstraction on top of the physical media, which is a high level resource management scheme. This enables protection and sharing between processes.

## General Criteria

Self-Contained. Information stored on a media is enough to describe the entire organization. Aka "plug-and-play", cross-platform file system.

Persistent. Information stored beyond lifetime of OS and processes.

Efficient. Provides good management of free and used space. Minimum overhead for bookkeeping information.

## Memory Management vs File System Management

Detail | Memory Management | File System Management
- | - | -
Underlying Storage | RAM | Hard Disk
Access Speed | Constant | Variable disk I/O
Unit of Addressing | Physical memory address | Disk sector
Usage | Address space for process (Implicit) | Non-volatile data (Explicit)
Organization | Paging/Segmentation | Many different FS (ext, FAT, HFS)

## File System Abstraction

### File

Logical unit of information

An abstract data type with data and metadata (file attributes)

### Permission

Unix - [User|Admin|Everyone] in 3 x 3 bits. `chmod 777 <file>`

Windows - Known as ACL, allows you to set user, specific user, group, specific group and so on.

### Structure

- Array of bytes (contiguous)

- Fixed length records (think array of objects, non contiguous)

- Variable length records (Flexible by harder to locate a record)

#### Access Methods

- Sequential Access - read in order, starting from beginning. Cannot skip but can be rewound.<br/>Used in tape.
- Random Access - data can be read in any order<br/>Methods like `read` and `seek` are available.
- Direct Access - used for fixed-length records which allow random access to any record.

### File Operations as System Calls

Provides protection, concurrent and efficient access

`open` returns an integer, which allows you to pass to `read` and `write`, to indicate how many bytes to read & write.

#### Information kept for an opened file

- File Pointer: Current location **in** the file
- Disk Location: Actual location of file in disk

Two approaches to keep information
- System-wide open-file table
- Per-process open-file table

#### File Operations (Unix)

For every process's PCB:

We keep a file descriptor table, which links to open file table. That way each process is kept from reading every file.

Case 2: Two processes using same file descriptor, but only offset will change.

## Directory

A logical grouping of files

- Single Level: Outdated
- Tree Structure
- Directed Acyclic Graph (DAG): Alias using hardlink / symlink
- General Graph: symlink

Symbolic link: simply a path name to file, disadvantage is more space needed
