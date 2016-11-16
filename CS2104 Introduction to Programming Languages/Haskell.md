# Haskell
Things that make Haskell special
- Laziness
- List Comprehension
- Monads
- Type Classes

## Lazy Evaluation
All data constructs and functions are lazy.
#### Infinite data structures
Using lazy evaluation alllows us to define infinite data sturctures.
They can be accessed in a finite way using functions.

> Non-termination / Infinite loop can still arise if we try to access all the elements

If strict evaluation is needed, `!` can be used.

## Layout Rule
Like python with its whitespace to structure code? Haskell uses similar syntax layout rule.

## List Comprehension
`[f x | x <- xs]` is same as `[f(x) for x in xs]` in python, and `(xs).map(f)` in javascript.

Haskell's list comprehension is much more powerful. E.g. `[(x,y) | x <- xs, y <- ys]`

Filter can be written like this:
```Haskell
let xs = [1 .. 6]
[f x | x <- xs, x > 5] -- only 6 will be processed
```

## Arithmetic Sequences and Strings
Arithmetic is simple in Haskell.
```Haskell
[1 .. 10] ) -- [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
[1, 3 .. 10] ) -- [1, 3, 5, 7, 9]
[1, 4 .. ] ) -- [1, 4, 7, 10, ... (infinite sequence)
```

String is also just a shorthand for list of chars. So `"hello"` is `['h', 'e', 'l', 'l', 'o']` underneath. As such, you can use list operators on strings. E.g.

```Haskell
"hello" ++ " world" -- "hello world"`
```

## Type Classes
Advantage, equality between types are easy except for functions. Using type classes allows ability to do so.