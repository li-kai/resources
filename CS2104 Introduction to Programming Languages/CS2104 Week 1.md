# Deep dive into Scala

## Classes

```Scala
class Lesson(startTime: Int, endTime: Int) {
    var start: Int = startTime
    var end: Int = endTime
    def move(startTime: Int, endTime: Int) {
        start = startTime
        end = endTime
    }
    override def toString(): String
        = start + " to " + end;
}

```

## Types

### Primitives
Primitives are built in types of languages that are usually directly implemented in hardware. Common examples would be boolean, integer, string and array. As they are implemented on the hardware level, they are usually fast and great for performance.

```Scala
val isHappy: Boolean = true
val age: Int = 21
val name: String = "John"
```

### Ordinal Types
Ordinal types are simply enums in commonly found in Java. It is a finite enumeration of distinct values. Ordinal types provide type safety, limiting values so compilers can catch errors early.

```Scala
sealed trait Weekends
case object Sat extends Weekends
case object Sun extends Weekends
```

In Scala, it is done through sealed case objects and they can only be extended within in a single file.

### Record Types
Record types are a collection of values of different types. Those familiar with C will recognise this as structs.

```Scala
class Student(n: String,y: Int) {
    val name = n
    val year = y
}
```

Records in Scala are simply objects without functions.

### Structure Types
Closely related to Record types, these are simply records with that allow partial specification of fields.

```Scala
def addressSir(person: { def name: String }) =
    "Sir " + person.name

addressSir(new { def name = "John" }) // "Sir John"

```
### Tuple Types
Tuples are simply record types that are grouped by position rather than field names.

```Scala
val student = (“John”, 2016)
student._1 // "John"
```

### Pointer Types
Pointers are meant to capture the address of an
object value. They are not available in Scala as each object type is already implemented as a
pointer (pass by reference).

### Union Types
Union types store different type of values at different times/instances. As they must accommodate for the largest type, they take up more space.

```Scala
abstract class UData
case class I(value: Int) extends UData
case class F(value: Float) extends UData
case class S(value: String) extends Udata
```

### Product Types
Records belong to product types, they  are analogous to logical conjunction.

```Scala
type Pair[A, B] = (A, B)
```

### Sum Types
Union, ordinals and algebraic data type belongs to sum types and they are analogous to logical disjunction. Untyped languages essentially sums different types together.

```Scala
type Any = Int | Float | ... | Array | Object
```

## Language Constructs
Language constructs are features used to build programs.

Examples of constructs:
* Blocks, Conditional, Sequences,
* Exceptions, Loops, Calls

### Binders
Binders are a special class of constructs which declare new identifiers and their possible values, binders have lexical scope.

Examples of name binders:
* Local declarations
* Method declaration (parameters)
* Pattern-Matching

### Pattern Matching
The powerful syntax that simplifies branch conditionals.
```Scala
val color = input match {
  case "red" ⇒ (255, 0, 0)
  case "green" ⇒ (0, 255, 0)
  case "blue" ⇒ (0, 0, 255)
  case _ ⇒ println("No such color"); 0 // _ denotes wildcard
}
```

## Exceptions
Exceptions are used to make code more robust by
signalling error scenarios. Exceptions are case-classes in Scala.

```Scala
try {
    val f = new FileReader("input.txt")
} catch {
    case ex: FileNotFoundException => println("Missing file exception")
    case ex: IOException => println("IO Exception")
}
```

## Recursion
Recursion is a powerful way to reason logic. As does every CS course, we introduce the recursion factorial method.

```Scala
def fact(n: Int) {
    if (n <= 0) 1
    else n * fact(n - 1)
}
```
There is no mutation and thus this method is pure. However, this method requires exponential stack space.

### Tail-recursion
Unlike recursion, each result of the recursion is stored and passed around, so it requires less stack space.

```Scala
def fact(accum: Int, n: Int): Int = {
  if (n == 1)
    return accum
  fact(n * accum, n - 1)
}
```

## Pure and Impure
Pure operations do not allow variables to be re-assigned after initial binding. These tend to be expression-oriented.

Impure operations allow values of variable to change and tend to be statement-oriented.

```Scala
// Pure
val x = 1
val x = x + 1 // new x

// Impure
var x = 1
x = x + 1 // x reference same but value changed
```

## Evaluation Order

### Strict Evaluation
* Evaluate eagerly
* Evaluate left-to-right order

```Scala
val x = 1 < 2 // x = true
```

### Lazy Evaluation
* Evaluate only when needed
* Create suspension (to denote unevaluated value)
* Terminates more often but are more costly to execute and makes debugging harder

```Scala
lazy val x = 1 < 2 // x = 1 < 2
```

### Speculative Evaluation
* Advanced evaluation (that may be discarded)
* Better for parallelism

## Typing
### Strongly typed
* Every expression has a type
* Advantage – more secure code
* Disadvantage – annotation efforts

### Weakly typed
* Some type errors at run-time
* Uses casting
* e.g. void*

### Untyped
* Support some universal type
* Advantage – write faster code
* Disadvantage – may have errors at runtime

## Terminology
Expressions
* Computes a result and may have effects

Statements
* Executed for their effects
* A special case of expression

Side-effects
* Modifies some state or has an observable interaction with calling functions or the outside world
* Printing, for example, is a side-effect because it modifies the terminal output

Pure
* Methods with no side-effects