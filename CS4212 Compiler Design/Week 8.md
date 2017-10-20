# Code Generation

Primary purpose

1. Instruction selection
1. Register allocation and assignments
1. Instruction ordering

## Instruction conversion

Naive translation may lead to inefficient code.

```asm
ST a, R0
LD R0, a
```

### Use of registers

Fastest computational units but scarce resource

Register allocation: Allocate registers to variables

Registers assignment: Which register should I use

### Addressing modes

- Direct addressing: l-value of a variable x
- Variable-indexed address: LD R1, a(r)
- Integer-indexed address: LD R1, 100(R2)
- Indirect addressing: LD R1, *100(R2)
- Constant addressing: #100

### Measuring Cost of Program

- Length of compilation time
- Size of target program
- Runtime of target program
- Memory usage
- Energy consumption

#### Simple costing scheme

Using cost with instructions, with each instruction having a cost associated. Instructions involving memory allocation or constant have additional cost of 1.

Instruction | Cost
- | -
`LD R0, R1` | 1
`LD r0, mem` | 1 + 1
`LD r1, *100(R2)` | 1 + 1

#### Stack allocation

Increment stack pointer every subsequent procedure call

```
ADD SP, SP, #caller.recordsize
ST *SP, #here + 16 // 16 is n * length of instruction
BR callee.codeArea
```

## Glossary of Terms

RISC
: Reduced instruction set computer

CISC
: Complex instruction set computer
