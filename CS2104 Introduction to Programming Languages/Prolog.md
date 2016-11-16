# Prolog
Prolog is a logic programming language which is untyped.

## Syntax

### Atoms, Terms and Variabls
- Atoms are constants (starts with lower-case letter). E.g. `cat`, `neil`, `john`, `5`, `-1`
- Variables start with upper-case letter or underscore. E.g.
`X`, `Y`, `Y2`, `Result`, `_var`, `_1`
- Terms are used to form tree-like data structures. E.g.
`node(node(dog,nil),leaf(cat))`,
`cons(2,nil)`, `cons(cat,cons(1,nil))`

One can mix terms with variables. E.g.
`node(X,Y)`, `cons(2,T)`

### Relations vs Functions
- Prolog allows relations to be specified.
- This is facilitated by unification mechanism

Let's look at a simple arithmetic relation in Prolog.

Checking
```Prolog
add(5, 4, 9). /* true */
```

Addition / Subtraction
```Prolog
add(5, 4, R). /* R would be 9 */
add(5, Y, 9). /* Y would be 4 */
```

Enumeration
```Prolog
add(X, Y, 9). /* X and Y would be all natural numbers that make up 9 */
```

As one can see, by defining relationships, we can write very powerful programs.

#### Defining relationships with Prolog

Let's model a family tree with simple relationships.

```Prolog
father(X, mary). /* Who is the father of mary? */
```

`,` denotes conjunction, i.e. and

```Prolog
mother(eva, C).            /* Who are the child(ren) of eva? */
mother(eva, C), female(C). /* Who are the daughter(s) of eva? */
```

`;` denotes disjunction, i.e. or

```Prolog
parent(X,Y) :- father(X,Y); mother(X,Y). /* A parent is either a father or mother of Y */
```

`\==` denotes negation, i.e. not

```Prolog
sibling(X,Y) :- parent(Z,X), parent(Z,Y), X \== Y. /* A sibling is not X him/herself */
```

Relations can be recursive

```Prolog
ancestor(X,Y) :- parent(X,Y).
ancestor(X,Y) :- parent(X,Z),ancestor(Z,Y).
```

### Unification
The process of matching items with variables is known as unification.
Once a variable become bound, it cannot be changed.
This is essentially a single-assignment property.

E.g.
```Prolog
?- f(g(a,X),X) = f(Y, b).
```
```
   f                         f
  / \                       / \
  g  |  is equivalent to   Y   b
 / \ |
a    X
```
so `X = b`, `Y = g(a, b)`

### Resolution
Resolution is the process of answering a query.

Pattern-matching is a special case of unification.

Resolution makes heavy use of variable renaming to match results to queries.

#### Arithmetic
Evaluated by the `is` operator

Second argument must be a ground expression (no variables)

```Prolog
X is 3 + 4. % Succeeds
7 is X + 4. % Fails
```

Relations `>`, `<`, `>=`, `=<`, `=\=`, `=:=` compares the two arithmetic expressions.

##### Factorial

```Prolog
/* Factorial using a relation.
 * Definition does not allow first argument to be unknown. */
fact(0,1).
fact(N, R) :- N > 0, M is N - 1,
              fact(M,R1), R is N * R1.
```

##### Select
List membership can be implemented as:

```Prolog
select(X, [X|_]).
sel(X, [_|T]) :- sel(X, T)
```

#### Negation as Failure
Prolog is based on close world assumption.

> Close world assumption: Whatever that can be proven is true, or otherwise assumed to be false.

> Open world assumption: Things that can be proven as false is false. Otherwise they are unknown.

Negation as failure is sound only if clauses are complete.

#### Cut to limit backtracking
`!` operator denotes a cut, acts like a `if/else` pattern

```Prolog
# example of inefficient algo
remDupl([],[]).
remDupl([H|T],R) :- sel(H,T), remDupl(T,R).
remDupl([H|T],[H|R]) :- not(sel(H,T)), remDupl(T,R).

# using cut to improve performance
remDup([],[]).
remDup([H|T],R) :- sel(H,T), !, remDup(T,R).
remDup([H|T],[H|R]) :- remDup(T,R).
```

If `sel(H,T)` succeeds, the program will not go to `remDup(T,R)`, thus saving calculations.

### Finite Constraint
Some basic constraints
```Prolog
X #> 3. % X in 4..sup
X #\= 10. % X in inf..9\/11..sup
```

> sup means infinite

```Prolog
cfact(0,1).
cfact(N,R) :- N#>0, M #= N-1,
              R #= N*R1, cfact(M,R1).
```

Finite constraint is powerful.

#### Labeling for finite constraints
[Label](http://www.swi-prolog.org/pldoc/man?predicate=labeling/2) is a library which can be used to provide some concrete answers which prolog doesn't give (only in ranges, etc).
This [stackoverflow post](http://stackoverflow.com/questions/27216247/i-dont-understand-what-label-does-in-prolog) explains it indepth.

> Singlequotes in Prolog are always atoms.