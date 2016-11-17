# OCaml
OCaml is a pretty old language, with powerful features.

### Mutable Reference
```OCaml
let ptr = ref 10;; (* referencing *)

let v:int = !ptr;; (* dereferencing *)
```

### Records
Records are immutable by default but can choose some fields mutable.

```OCaml
type (`a, `b) pair = {
    mutable first: `a,
    second: `b
};;
```

### Class

```OCaml
class counter =
    object
        val mutable x = 0
        method inc = x <- x + 1
        method get = x
        method set y = x <- y
    end;;
```

In order to access values in a class, you must write a getter.

You can give an explicit nae for the current object, this is akin to `this` object in other languages.

You can inherit in OCaml.

```OCaml
class counter1 =
    object
        inherit [int] counter
        method inc = x <- x + 2
    end;;
```

You can make the class polymorphic

```OCaml
class ['a] buffer init =
    object
        val mutable x :'a = init
        method get = x
        method set y = x <- y
    end;;
```

#### Typing
Classes in OCaml are structurally equivalent if their types and visible methods are exactly the same, even if they do different things.

Therefore, you can pass an object of a class to another class.

If B has more visible type methods than A, then B is a subtype of A. That means you can pass class B objects as class A objects. This is called structural subtyping via "row polymorphism".

```OCaml
let foo3 (v) = (v:>`b buffer) # get;;
(* foo3: `b #buffer -> `b *)
```

#### Cloning
You can shallow clone an object using `Oo.copy` which works with any object type `< .. >`.

#### Functional Objects
As long as there are no mutations of fields, the objects are immutable and functional.

```OCaml
class functional_int y =
    object
        val x = y
        method move (d:int) : functional_int =
            new functional_int (x + d)
    end;;
```

### Virtual Classes and Methods
Virtual classes have undefined methods, and cannot be instantiated. This is equivalent to abstract class and abstract methods in Scala/Java.

### Module
Modules can be used to group types, values, functions, classes, exceptions and even other modules.

You can use qualified names or open a module with `open` keyword to access entities locally.

Modules can declare a signature, with no implementation, akin to interfaces in java and scala. You can also declare a struct which can contain some implementation.

Functors are functions from structures to structures.