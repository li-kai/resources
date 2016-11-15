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

## Functional Scala

Advantages of the functional approach:
* Can support code-reuse
* Can support laziness
* Can support data abstraction
* Can support design patterns

### Laziness
Lazy methods are evaluated only when needed, this may speed up calculation when evaluation is expensive.

```Scala
def fn_if_lazy[T](a: Boolean, b: => T, c: => T)
    = if (a) b else c
```

### Genericity
Functional programming also allows us to make functions more generic, by definiting a skeleton then having functions define the process.

For example,
```Scala
def fold[A,B] (xs: List[A]) (z: B)
(op: ((A,B) => B)): B = {
    def aux(xs: List[A]): B =
        xs match {
            case List() => z
            case y::ys => op(y,aux (ys))
        }
    fold(xs)
}
```
can be used in many ways

```Scala
def sum (xs: List[Int]) =
    fold (xs) (0) ((x: Int, y: Int) => x + y)
def prod (xs: List[Int]) =
    fold (xs) (1) ((x: Int, y: Int) => x * y)
```

#### Folding
```
f( f( f( f(z,x1),x2),x3),x4) // fold left
f(x1, f(x2, f(x3, f(x4,z)))) // fold right
```

Fold left is tail recursive, therfore it is typically more efficient due to constant stack space.

Fold left and fold right can be transformed to each other when the reduction `f` operator is associative: `f(a,f(b,c)) = f(f(a,b),c)`

Fold left and right can also be transformed by reversing the list before calling `f`.