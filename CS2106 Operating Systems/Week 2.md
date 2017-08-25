## Hardware utilization

## Process Management

OS be able to switch from program A to B

Process: Currently executing program (running), also Task/Job

### Recap: Sample program and assembly code

C program -> memory assembly code + ram

Therefore, we always need processor, memory and i/o for a program.

Memory for code looks like this:

[ assembly code | global data variables | free ]


### Low level function calls

-> Can we simply store function as data?

No, because scope is different. Imagine merge sort with same i,j, wow O(log n).

2 problems

1) Control flow, passing parameters to other funcs
1) Data storage, need to capture return result

Hence, we introduce - stack memory!

#### Stack memory

Used only to support function invocations.

It is:

- Dynamically allocated
- Require a stack pointer to keep track of size
- As stack size grows, stack pointer value goes down (reverse direction of numeration)

Given, an example

```js
function f() {
    g();
}
```

When we first invoke f(), a stack frame for f() is allocated.
Each new invocation in f() adds a stack frame for g() on top of the stack frame.
When g() invokation finish, f().

When memory usage exceeds due to infinite function call, program will crash.

##### Stack frame

Includes:

- parameters
- local variables (e.g. intermediate calc results)
- return PC
- other info

There is no single function call convention.

###### Setup

Caller: pass parameters with registers and/or stack
Caller: save return PC on stack

Callee: save old Stack Pointer (to call back function), save registers used by callee
Callee: allocate space for function
Callee: execute code

###### Teardown

Callee: place return result on stack (if present), restore saved register
Callee: restore saved SP, effectively deallocating itself

Caller: utilize return result
Caller: continues

###### Frame pointer

We can't use stack pointer because it keeps moving due to execution of the program (hence increasing/decreasing stack size).

Frame pointer is static.

#### Heap Memory

Dynamic variable allocation

### Process Id & State

PID is unique among processes

#### 5-state process model

= Create (allocate memory) => New state = admit => Ready state <= switch: scheduled / release => Running state = event wait => Terminated state

Need a Ready Queue and Blocked Queue for multiple processes. These are more like sets than actual queues.

#### Process table

A list of necessary information for processes.
These are called Process Blocks, which then allocate them into memory accordingly.
