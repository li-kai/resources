# Processess

## Concurrent Execution
- Logical concept to cover multitasked process
- There are
    1) virtual parallelism
    1) physical parallelism

## Simplistic Concurrency Model
Using timeslicing to achieve "fake parallelism"

## Interleaved execution (context switch)

Process itself enforces interleaving. The OS will step in.

OS will do context switching.

OS has a scheduler that makes the decision. Has an algorithm.

## Scheduling

Scheduling is not clear cut. Different requirements, also different ways to allocate by environment.

Exists certain criteria to evaluate the scheduler.

### Process behavior

CPU Activity
Compution, Compute Bound Process spend most time here

IO Activity
Interupt to handle user I/O input

#### Types of processing env

1) Batch processing
    No user, no interaction
2) Interactive (or Multiprogramming)
    With activer user interacting, should be responsive
3) Real time
    Dead line to meet
    Usually periodic process

#### Criterias

- Fairness
    Should get a fair share of CPU time, based on per process or per user basis. Meaning, no starvation.
- Balance
    All parts of the computing system should be utilized
- Turnaround time
    Total time taken from start to finish, related to waiting time waiting for CPU
- Throughput
    Number of tasks finished per unit time
- CPU utilization
    Percentage of time when CPU is working on a task
- Response time
    Time between request and response
- Predictability
    Variation in response time, lesser variation == more predictable

#### When to perform scheduling
Two types
- Non-preemptive (Cooperative)
    A process stayed scheduled until it blocks OR gives up CPU voluntarily
- Preemptive
    A process is given a fixed time quota to run, can volunteer to give up

### Scheduling a process

Process Control Board (PCB)
Keeps context of
- ID
- Memory
- Hardware (pointers, etc)

Copied over for every PID

#### Batch processing

E.g. Supercomputers

Non-preemptive scheduling is predominant

- First Come First Served (FCFS)
    + Guaranteed to have no starvation, always be served
    - Convoy effect
    Waiting time is number of process unit time in front of it.
- Shortest Job First (SJF)
    Allow shortest job to run first
    Guess future CPU time bassed on previous CPU-Bound phases (Exponential Average)
- Shortest Remaining Time (SRT)
    Variation of SJF, using remaining time, but is preemptive
    Allow the task with the shortest remaining time (meaning expected - already ran time)
    Stop task if a shortest remaining time, starvation is possible

#### Interactive System

Ensures good response time

Timer interrupt = Interrupt that goes off periodically (based on hardware clock)
Ensures that OS cannot be intercepted

Timer interval (typically 1ms to 10ms)
Different from below because this is the one that OS follows

Time quantum (basically a tick)
- Execution duration given to a process
- Could be constant or variable among the processes
- Large rang eof values (commonly 5ms to 100ms)

- Round Robin
    Tasks are stored in a FIFO queue
    Big quantum: Better CPU utilization but longer waiting
    Small quantum: Bigger overhead
    Time before a task get CPU is bounded by (n - 1)q
    Response time guarantee
- Priority Scheduling
    Low priority process can starve, hack: decrease priority after every quantum
    Hard to guarantee or control the exact amount of CPU time given to a process using priority
    Priority inversion: Low priority holds key resources.
    E.g. Cleaner holds key to office for CEO, CTO
- Multive-level Feedback Queue (MLFQ)
    Adapative, learns the process behavior
    Minimizes both responsive time for IO and turnaround time for CPU
    Basic rules
    - Priority(A) > Priority(B) -> A runs
    - Priority(A) == Priority(B) -> A and B runs in RR
    - New job -> Highest Priority
    - Job fully utilizes time slice -> priority reduced
    - Job gives up / blocks -> retain priority
- Lottery scheduling
    Give out "lottery tickets" for processes.
