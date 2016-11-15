## Declarative Programming
* Say what you want to compute and let computer find how to compute it
* Function focused
* Stateless programming with no update of data structures (immutable)

### Functions as first-class citizens
Functions then, also act as values

```Scala
def add(x: Int,y: Int) = x + y
```

To write Scala in a declarative manner, recursion must be used in order to loop. As a result, result type must be explicitly declared.

```Scala
def fact(n: Int): Int =
    if (n == 1) 1
    else n * fact(n - 1)
```

#### Anonymous Functions
Functions without names.

```Scala
((x: Int) => x * x)
```

#### Tupled and Curried Functions
Tupled functions take in a series of inputs at once, like regular functions.

Curried functions can take in arguments and may either return a result or another function that takes the next argument. This allows partial application of functions.

```Scala
def add(x: Int,y: Int) = x + y // Tupled
def addC(x:Int) (y:Int) = x + y // Curried
```

> Curried functions are called that way because it was furthered by Haskell Curry.

### List
Common data structures in other languages. Empty lists return `Nil`.

```Scala
def append[A](xs: List[A],ys: List[A]): List[A] =
    xs match {
        case Nil => ys
        case x::xs => x::append[A](xs, ys)
    }
```
