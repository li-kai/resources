## Imperative Programming
* Models the real-world (things change)
* Performance considerations (e.g.
hash tables & mutable graphs)

### Mutability
Reference remains the same but value can change.

```Scala
val x = 10
val x = x + 1 // new x

var x = 10
x = x + 1 // same x, value different
```

### Weak Polymorphism
Types of mutable fields must not be polymorphic so that its update and retrieval remains consistent.

In Scala, each mutable value is limited to its scope.

### Loops
Typical imperative syntax.

```Scala
for (i <- 0 to 3) {
    printfn "i = %d\n" i
}
```

There are also iterators over data structures.

```Scala
List(1, 2, 3).foreach((i) => {
    print(i) // 123
})
```

### Arrays

```Scala
val numbers = Array(1, 2, 3, 4)
numbers(3) = 100
println(numbers.deep.mkString(", ")) // "1, 2, 3, 100"
```

### List
Common data structures in other languages. Empty lists return `Nil`.

```Scala
def append[A](xs: List[A],ys: List[A]): List[A] =
    xs match {
        case Nil => ys
        case x::xs => x::append[A](xs, ys)
    }
```

### Memoization
Memoization is the process of reducing redundant evaluation by storing the previously calculated result.

```Scala
val fib_hash = new scala.collection.mutable.HashMap[Int,Int]()
def fib_memo(n: Int): Int =
    if (n <= 1) 1
    else fib_hash.get(n) match {
        case Some(r) => r
        case None =>
            val r = fib_memo (n-1) + fib_memo (n-2)
            fib_hash.+(n->r)
            r
    }
```

Essentially, you are trading off memory space for time.