
## Stack architecture

Operands are implicitly on top of the stack.
Cannot operate on memory.

Advantages:

- Operands are pushed to stack, no need to guarantee operands are present
- No need for brackets (stack-based operations)

```
e.g.
x = y + z
-> push y
-> push z
-> execute add
-> pop x
```

## Accumulator architecture

One operand is implicitly in the accumulator (a register)

Used in GPU (vector processes)

Advantages:

- Requires only one register, theoretically

```
e.g.
x = y + z
ld acc, y
add z
store x
```

## General Purpose register architecture

Only explicit operands

- Register-memory architecture
    - (one operand in memory)
- Register-register architecture (load-store architecture)


```
e.g.
x = y + z
ld R1, y
ld R2, z
add R3, R1, R2
store R3, x
```

## Memory-memory architecture

All operands are in memory

Advantages:

- No need to load into register

# CPU to RAM

Busses are wires to connect components

CPUs contains Memory Address Register (MAR)
Bunch of D-flip-flops leading to memory addresses

Memory sends n-bit data to Memory Data Register (MDR) in CPU

k bits, can produce 2^k addressable locations, height of RAM
That is why 32bit architecture can only use 4gb memory

n bits, size to data bus, width of RAM

## Data bus

Always sends data of n-bits.

## Address bus

### Memory Content: Endianness

#### Big-endian:
Store most significant byte in lowest address (bottom of memory)

#### Little-endian:
Store least significant byte in lowest address (bottom of memory)

### Addressing modes
Register
- Operand is in a register
- e.g. `add $r1, $r2, $r3`

Immediate

- Operand is specified in the instruction directly
- e.g. `add $r1, $r2, 100`

Displacement

- Memory in in address calculated as base + offset
- e.g. `add $r4, 3($r1)`
- Not j-mode