# Motivation for Thread

Thread invented to overcome problems with creating a new process (expensive due to copying context)

## Basic Idea

Single thread of control -> Only one instruction of the whole program is executing at one time

More threads of control get added to process (aka imagine adding assembly code to a queue)

Threads can share

- Text, Data, Heap

- OS Context: Process id, other resources like files, etc.


### Multithreaded Process

Duplicate registers and stack

Benefits:
- Economy
- Resource sharing
- Responsiveness
- Scalability

### Thread Models

#### Run within User Mode:

User models in runtime system, can bring threads to all OS

- Can configure runtime systems to run different algorithms (MLFQ, FCFS).
- Flexible and Fast

#### Run within Kernel Mode:

OS is able to switch context within OS's process priority

Less flexible and not as cheap as it is now a system call.

#### Hybrid Mode:

Have both kernel and user threads. OS schedules kernel threads but user thread can bind to a kernel thread.

Can limit the concurrency of any process/user

Hardware can now run multiple threads at the same time, known as Simultaneous Multi Threading (SMT), or Hyperthreading.

### POSIX Threads

pthread

- Defined by IEEE
- But implementation is not specified
- Therefore some is user, some is kernel threaded

Pass in `*void` (a pointer without type), and returns one

When you exit, it kills all threads (even currently running ones)

`pthread_join` to wait for threads to join back

### Shared memory

Independent but piece of memory is shared.

Advantages:
    Efficient & Ease of use
Disadvantages:
    Synchronization and Difficulty of Implementation

Memory via pointer

### Message Passing

Process P1 prepares a message M and sends it to P2
P2 receives message from P1

> Message have to be stored in kernel memory space

#### Direct Communication

Need to explicitly name the other party
- One link per pair of communicating processes
- Need to know identity of the other party

#### Indirect Communication

Messages are sent/recieved from storage (known as port or mailbox)

Advantages
- Portable
- Easier sync

Disadvantages
- Inefficient
- Harder to use

##### Synchronization Behavior

Blocking Primitives (Sync):
    P1 Send(1)

    wait until P2
    responds

    continues

Non-Blocking Primitives (Async):
    P1 Send(1)

    continues

### Pipes

Communication channels

stdin (commonly linked to keyboard)
stdout (commonly linked to screen)
stderr (commonly linked to screen)

Producer-Consumer relationship

Implemented with cirular bounded byte buffer with implicit sync.

### Unix Signal

Asynchronous noficiation regarding an event

Essentially a software interrupt.

