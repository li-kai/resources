# CS2105 Week 9
### Prolog
- Equality constraints are the easiest to resolve.
- Unification is the mechanism used. 
> Another example of constraint solver is Scala's subtyping system

#### Arithmetic
Evaluated by the `is` operator

Second argument must be a ground expression (no variables)

```prolog
X is 3 + 4. % Succeeds
7 is X + 4. % Fails
```

Relations `>`, `<`, `>=`, `=<`, `=\=`, `=:=` compares the two arithmetic expressions.

###### Factorial

```prolog
/* Factorial using a relation. 
 * Definition does not allow first argument to be unknown. */
fact(0,1).
fact(N, R) :- N > 0, M is N - 1, 
              fact(M,R1), R is N * R1.
```

###### Select
List membership can be implemented as:

```prolog
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
```prolog
# example of inefficient algo
remDupl([],[]).
remDupl([H|T],R) :- sel(H,T), remDupl(T,R).
remDupl([H|T],[H|R]) :- not(sel(H,T)), remDupl(T,R).

# using cut to improve performance
remDup([],[]).
remDup([H|T],R) :- sel(H,T), !, remDup(T,R).
remDup([H|T],[H|R]) :- remDup(T,R).
```

### Finite Constraint
Some basic constraints
```prolog
X #> 3. % X in 4..sup
X #\= 10. % X in inf..9\/11..sup
```

> sup is infinite

```prolog
cfact(0,1).
cfact(N,R) :- N#>0, M #= N-1,
              R #= N*R1, cfact(M,R1).
```

Finite constraint is powerful.

#### Labeling for finite constraints
[Label](http://www.swi-prolog.org/pldoc/man?predicate=labeling/2) is a library which can be used to provide some concrete answers which prolog doesn't give (only in ranges, etc).
This [stackoverflow post](http://stackoverflow.com/questions/27216247/i-dont-understand-what-label-does-in-prolog) explains it indepth.

### Atoms
Singlequotes in Prolog are always atoms.