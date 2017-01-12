# CS2100 Week 1

## Binary
- 0 and 1 represents states
- Base or radix of the number system is 2

## Digits
In general, X*(base)^pos gives value of any number in the base.

To convert whole number to binary, successively divide by 2, whose remainders  are the answer.

E.g.
43 / 2 = 21 rem 1
21 / 2 = 10 rem 1
10 / 2 = 5  rem 0
5  / 2 = 2  rem 1
2  / 2 = 1  rem 0
1  / 2 - 0  rem 1
Ans = 101011

To convert decimal fractions, repeatively multiply by 2, whose whole number portion is the answer.

0.3125 * 2 = 0.625
0.625  * 2 = 1.25
0.25   * 2 = 0.50
0.5    * 2 = 1.00
Answer = 0.101

### Special Convertions
- Binary -> Octal

Partition in groups of 3
(10 111 011 001. 101 110)2 = (2731.56)8

- Octal -> Binary

Reversed

- Binary -> Hexadecimal

Partition in groups of 4
(101 1101 1001. 1011 1000)2 = (5D9.B8)16

- Hexadecimal -> Binary

Reversed

## Units
1K (kilo) = 2 ^ 10
Note that the unit is Capitalized.

## Memory Addressing
Assume 2^10 bytes and each word contains 4 bytes.
Then byte 5 is at word 2, where you truncate the root binaray (10) in (00000001|01)

## Signed vs Unsigned
Signed contains +-
Unsigned only +

First bit is sign bit. 0 for + and 1 for -.

In a 8 bit system,
largest  = 01111111 = +127
smallest = 11111111 = -127

## 1s Complement
-x = 2^n - x - 1, where n is the n-bit number

E.g. 00001100 = 2^8 - 12 - 1
              = 243
              = 11110011
Or simply, flip every single bit (lol).
> Given that x is negative! Do not flip for positive numbers.

### Range
In a 8 bit system,
largest  = 01111111 = +127
smallest = 10000000 = -127
zeroes = 00000000 = 0
zeroes = 11111111 = -0

## 2s Complement
-x = 2^n - x, where n is the n-bit number

E.g. 00001100 = 2^8 - 12
              = 244
              = 11110100
Or simply, flip every single bit then add 1 to right most digit (even for fractions).
> Given that x is negative! Do not flip for positive numbers.

### Range
In a 8 bit system,
largest  = 01111111 = +127
smallest = 10000000 = -128
zeroes = 00000000 = 0

## Why complement?
Computers are really good at adding, so instead of A - B, we do A + (-B)!

Before minusing B, we change it to 2 complement form so we can add it instead.

### 2s complement addition
1. Perform binary addition on the two numbers.
2. Ignore the carry out of the MSB.
3. Check for overflow. Overflow occurs if the ‘carry in’ and ‘carry out’ of the MSB are different, or if result is opposite sign of A and B.

### 1s complement addition
1. Perform binary addition on the two numbers.
2. If there is a carry out of the MSB, add 1 to the result.
3. Check for overflow. Overflow occurs if result is opposite sign of A and B.

## Excess-X representation
X is known as the bias.
Excess simply starts off from 00...0 bits from smallest value, which is -bias, then counts up.

## Fixed point representation
Binary point can be set at an arbitray point. (Aka digits before x are integers and after x are the fraction part).

## Floating point representation
Instead of making a fixed point, we set an arbitrary index, which allows us to represent very large or small numbers.

### IEEE 754 Floating point
Made of 3 components, where base is assumed to be 2. Two formats of single-precisiion (32 bits) and double-precision (64 bits).

1. Sign
    - 0 for positive, 1 for negative
2. Exponent
    - Represents the power to be applied to mantissa (add 127)
3. Mantissa
    - Normalized by making first bit to be 1

Check year 1 sem 2 MA2213 Week 1 pg 32/33.

## Boolean Algebra
In orders of precedence:
- Not (A')
- And (A · B)
- Or  (A + B)

### Laws

| Law | |  |
|---|---|---|
Identity laws | A + 0 = 0 + A = A | A · 1 = 1 · A = A
Inverse/complement laws | A + A' = 1 | A · A' = 0
Commutative laws | A + B = B + A | A · B = B · A
Associative laws | A + (B + C) = (A + B) + C | A · (B · C) = (A · B) · C
Distributive laws | A · (B + C) = (A · B) + (A · C) | A + (B · C) = (A + B) · (A + C)

### Duality
Duality gives free theorems – “two for the price of one”.

You prove one theorem and the other comes for free! E.g.:

- If (x+y+z)' = x' · y' · z' is valid, then its dual is also valid: (x · y · z)' = x' + y' + z'

- If x + 1 = 1 is valid, then its dual is also valid: x · 0 = 0

### Basic Theorems
| Theorem | | |
|---|---|---|
Idempotency | X + X = X | X · X = X
One element / Zero element | X + 1 = 1 | X · 0 = 0
Involution | ( X' )' = X
Absorption | X + X·Y = X | X·(X + Y) = X
Absorption (variant) | X + X'·Y = X + Y | X·(X' + Y) = X·Y
DeMorgans’ | (X + Y)' = X' · Y' | (X · Y)' = X' + Y'
Concensus | X·Y + X'·Z + Y·Z = X·Y + X'·Z | ( X + Y )·( X' + Z )·( Y + Z ) = ( X + Y )·( X' + Z )

### Standard Forms
- Sum-of-Products (SOP)
    + A product term or a logical sum (OR) of several product terms
    + E.g. x·y' + x'·y·z, A·B + A'·B'
- Product-of-Sums (POS)
    + A sum term or a logical product (AND) of several sum terms
    + E.g. (x+y')·(x'+y+z), (A+B)·(A'+B')

| Expression | SOP? | POS? |
|---|---|---|
| X' · Y + X · Y' + X · Y · Z | ✓ | |
| ( X + Y' ) · ( X' + Y ) · ( X' + Z' ) | | ✓ |
| X' + Y + Z | ✓ | |
| X · ( W' + Y · Z ) | | ✓ |
| X · Y · Z' | | ✓ |
| W · X' · Y + V · ( X · Z + W' ) | ✓ | |
