## Terminology
Syntax
* Concerned with the form of a program
* How expressions, types, declarations and commands are formed
* Analogy: Grammar in human languages

Semantics
* Concerned with the meaning of a program
* How programs should behave when executed on computers
* Analogy: Nouns in human languages

# Computer Language Parsing

## Language Syntax
* Sentences are called expressions
* Words are called tokens
* Grammar rules describe both tokens and statement

A _Lexical Analyzer_ recognizes character sequence and produces token sequence.

This token sequence is then passed to a _Parser_ that produces a statement representation, usually parse trees.

Example, `let x = 5` would be turned into `["let"; "x"; "="; "5"]` through a lexical analyzer and then into `[Key "let"; Id "x"; Key "="; NumI 5]` through a parser.

## Abstract Syntax Tree

### Context-Free Grammars
Requires:
* A set of terminal symbols (tokens or constants)
* A set of non-terminal symbols
* One (non-terminal) start symbol
* A set of grammar (rewriting) rules of the form

#### Backus-Naur Form
BNF is a common notation to define context-free grammars

```EBNF
<digit> ::= 0 | 1 | 2 | 3 | 5 | 6 | 7 | 8 | 9
<integer> ::= <digit> | <digit> <integer>
```

#### Extended Backus-Naur Form
EBNF is a more compact notation to define the syntax; provides some shortcuts for repetition

```EBNF
<digit> ::= 0 | 1 | 2 | 3 | 5 | 6 | 7 | 8 | 9
<integer> ::= <digit> { <digit> }
```

Notation       | Meaning
---------------|---------------
`<x>`          | nonterminal x
`<x> ::= Body` | `<x>` is defined by Body
`<x>|<y>`      | either `<x>` or `<y>` (choice)
`<x> <y>`      | the sequence `<x>` followed by
`{<x>}`        | sequence of zero or more occurrences of `<x>`
`{<x>} +`      | sequence of one or more occurrences of `<x>`
`[<x>]`        | zero or one occurrence of `<x>`

## Writing a parser
Let's define a simple variable that takes in only alphabets using regex.

```Scala
def variable = """[a-zA-Z]+""".r ^^ Var
```

There are many flavors of parsers in the Scala library, and each of them does something different. The StdTokenParsers provided very sensible defaults for words and that allowed registering and reserving of keywords for the parser.

```Scala
class LambdaParser extends StdTokenParsers {
  type Tokens = StdLexical
  val lexical = new StdLexical
  lexical.reserved ++= Seq("let", "in")
  lexical.delimiters ++= Seq("λ", ".", "(", ")")
}
```

The regexp parser is the easiest to work with because of regex's flexibility and power.

### Parser Syntax
#### `~`
Example usage:
```Scala
for x ~ in ~ y
```
`for fruit in basket` would pass, and `x` would be capture `fruit` and `y` would capture `basket`

#### `|`
Example usage:
```
" ~ text ~ " | ' ~ text ~ '
```
`"Joseph said 'Hello'"` would pass, and `text` would be capture `Joseph said 'Hello'`, resorting to parsing the second option only first the first failed.

#### `~>` and `<~`
Example usage:
```Scala
await ~> promise <~ end
```
`await readFile() end` would pass, and `promise` would be capture `readFile()`. This is particularly useful if you just want the content between `~>` and `<~`, removing syntatic sugar.

#### `>>`
Example usage:
```Scala
def number:Parser[Int] = """[/d]+""".r >> toInt
```
`15` would pass, and `toInt` function would be applied to `15`, turning it into an `Int` type for the parser to process. Note that this it not a string parser annotation but rather an operator in the *actual scala syntax*.
