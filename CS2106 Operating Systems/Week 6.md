# Race condition

## Solving race condition

Designate code segment with race condition as critical section
At any point in time, only one process can execute in the critical section

e.g. a toilet has a lock, only one person can use it at a time

- Mutual exclusion
- Progress (able to complete queue)
- Bounded wall (upperbound on time other process can enter critical section before yourself)
- Independence (process cannot prevent others from using resource)

### Symptoms of incorrect synchronization

Deadlock
    All process blocked
    e.g. no one person is willing to give way in a hallway
Livelock
    Process keep changing state to avoid deadlock
    e.g. person moving left and right to give way to other person in a hallway
Starvation
    Process are blocked forever

### Test and Set

Machine instruction to aid sync

`TestAndSet <Register> <MemoryLocation>`

Repeatedly check is lock is unlocked

```c
while( TestAndSet(Lock) == 1 ); // keep checking before next line
```

### Peterson's Algorithm

Turn var
Want var

Indicate want and indicate taking a turn, then wait.
```c
want[0] = 1;
turn = 1;
while (want[1] == 1 && turn == 1);
```

Cons: Busy waiting, low level and not general

### Djikstra's Algorithm

Semaphore

A semaphore S contains an integer value, initialized to non-neg values intially

```c
Wait(S)
// If s <= 0, blocks
// Else, Decrement s
// Also known as P() or Down()
```

```c
Signal(S)
// Increments s
// Wakes up one sleeping process if any
// Also known as V() or Up()
```

#### Properties

Given `S_initial ≥ 0`, then `S_current = S_initial + #signal(S) - #wait(S)`

Binary semaphore is commonly known as mutex (mutal exclusion)

Mutual Exlucsion:
    N_cs = number of process in critical section
         = process that completed wait() but not signal()
    N_cs = #Wait( S ) - #Signal( S )
    S_initial = 1
    S_current = S_initial + #signal(S) - #wait(S)
    S_current + N_cs = 1
    Since S_current ≥ 0 -> N_cs ≤ 1

Deadlock:
    No process stuck at wait means S_current + N_cs = 1
    Contradiction

Starvation:
    P1 is blocked at wait( S )
    ???

