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
[1 .. 10] -- [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
[1, 3 .. 10] -- [1, 3, 5, 7, 9]
[1, 4 .. ] -- [1, 4, 7, 10, ... (infinite sequence)
```

String is also just a shorthand for list of chars. So `"hello"` is `['h', 'e', 'l', 'l', 'o']` underneath. As such, you can use list operators on strings. E.g.

```Haskell
"hello" ++ " world" -- "hello world"`
```

## Type Classes
Equality between types are easy except when involving functions. Using type classes removes this difficulty.

Type classes provide a structed way to control Ad-hoc polymorphism. Ad-hoc polymorphism, or function overloading, allows one to define functions that take in different types but have the same name.

## Class Extension
Haskell supports the notion of extending from some base type class.

```Haskell
class (Eq a) => Ord a where
    (<),(<=),(>=),(>) :: a -> a -> Bool
    max, min          :: a -> a -> a
```

This allows us to do operations like this

```Haskell
quicksort :: (Ord a) => [a] -> [a]
```

without having to define multiple quicksort for different numerical types.

### Some more classes:
Class `Enum` supports sugar for arithmetic sequences:
```Haskell
class (Enum a)
    enumFromThen :: a -> a -> [a]
    fromEnum :: a -> Int
    toEnum :: Int -> a
```

The `Show` class are for types that can be converted to character string.

```Haskell
class Show where
    show :: a -> String
    shows :: a -> String -> String
    show x = shows x ""
```

The `Read` class transforms text into data structures.

```Haskell
class Read a
    reads :: String -> [(a,String)]
```

### Numbers
Haskell has a variety of ways to constuct numbers.

- The `Num` class provides basic operations like `+`, `abs`.
- Division is supported in `Integral` while `/` is supported by `Fractional` class.
- `Floating` class contains trigonometric, logarithmic and exponential functions.
- The `RealFrac` subclass of `Fractional` and `Real` provides proper fractions and rounding operations.

Yep, you can have fractions as real data structures in Haskell.

### Arrays
Arrays are pretty useful, and can be accessed with `!` instead of `[]` in many popular languages. E.g.:

```Haskell
squares = array (1,100) [(i,i*i) | i <- [1..100]]
squares ! 7 -- 49
```

As Haskell has lazy-evaluation, we can define arrays recursively.

```Haskell
fibs :: Int -> Array Int Integer
fibs n = a where a = array (0,n) [(0,1),(1,1)]++
                    [(i, a!(i-2)+a!(i-1) | i <- [2..n]]
```

### Monads
Joining simple component in robust ways by encapsulating values of a data type and outputing a new type. The computation follows a set of predicates called moand laws.

#### I/O Operations
A pure value can be converted into an action by return, but not the converse.

```Haskell
x + print y -- Illegal
```
IO operations are Haskell values that can be passed to functions.

We can construct a list of operations in a monad, then execute them in series by running them.

```Haskell
sequence_ :: [IO ()] -> IO ()
sequence_ = foldr (>>) (return ())
```

Exceptions are also monads.
















