# Lambda Calculus
Extremely simple programming language which
captures core aspects of computation and yet allow programs to be treated as mathematical objects.

## Syntax

Syntax    | Meaning
----------|----------
`t ::=`   | terms
`x`       | variable
`λ x . t` | abstraction
`t t`     | application

### Conventions
- Parentheses are used to avoid ambiguities.

    e.g. `x y z` can be either `(x y) z` or `x (y z)`.

- Applications associates to the left and bodies of lambdas extend as far as possible.

- Nested lambdas may be collapsed together.

    e.g. `λ x. λ y. x y x` can be written as `λ x y. x y x`

### Scope
An occurrence of variable `x` is said to be bound when it occurs in the body `t` of an abstraction `λ x . t`

An occurrence of `x` is _free_ if it appears in a position where it is not bound by an enclosing abstraction of `x`.

### Alpha Renaming
Alpha renaming is the process of renaming variables in the scope they are bound to.

Correct:
- `λ x. x =`<sub>`a`</sub> `λ y. y`
- `λ y. x y =`<sub>`a`</sub> `λ z. x z`

Wrong:
- `λ y. x y =`<sub>`a`</sub> `λ y. z y`
- `λ y. x y =`<sub>`a`</sub> `λ x. x x`

### Beta Reduction
An application whose LHS is an abstraction, evaluates to the body of the abstraction with parameter substitution. i.e. Evaluating the lambda expression to something simpler.

e.g.
- `(λ x. x y) z ➝`<sub>`b`</sub> ` z y`
- `(λ x. y) z ➝`<sub>`b`</sub> ` y`
- `(λ x. x x) (λ x. x x) ➝`<sub>`b`</sub> ` (λ x. x x) (λ x. x x)`

## Evaluation Strategies

| Evaluation Strategy     | Evaluation Order    | Reduce inside abstractions | Example                                          |
|-------------------------|---------------------|----------------------------|--------------------------------------------------|
| Full Beta Reduction     | any                 | true                       | `id (id (λz. id z))` <br>`id (id (λz.z))` <br>`id (λz.z)` <br>`λz.z` |
| Normal Order Reduction  | leftmost, outermost | true                       | `id (id (λz. id z))` <br>`id (λz. id z))` <br>`λz.id z` <br>`λz.z`   |
| Call by Name Reduction  | leftmost, outermost | false                      | `id (id (λz. id z))` <br>`id (λz. id z))` <br>`λz.id z`        |
| Call by Value Reduction | leftmost, innermost | false                      | `id (id (λz. id z))` <br>`id (λz. id z)` <br>`λz.id z`         |

### Strict vs Non-Strict Languages
Strict languages use call-by-value evalation whereas non-strict may use either call-by-name or call-by-need (not covered)