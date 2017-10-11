# Lexical Analyzer (Lexer)

Role of the Lexical Analyzer

- Read the input characters of the source
program
- Group characters into lexemes
- Output a sequence of tokens to the parser
- Other tasks:
   + Filtering out comments and whitespace
   + Correlating error messages with source
    program
   + Constructing symbol tables

## Lexer vs Parser

Lexer passes the token to Parser, which handles Semantic Analysis.

- **Separation of concerns** leads to simplicity
of design
- **Compiler efficiency** is improved when
specialized lexical analysis techniques can
be employed
- **Compiler portability** is enhanced when
input-device-specific peculiarities can be
restricted to the lexical analyzer.

## Regular Expression (Regex)

Expression | Description
---|---
`x` | Character x
`\x` | Character x literally
`"x"` | String x literally
`.` | Any character but newline
`^x` | x at the beginning of a line
`x$` | x at the end of a line
`[xy]` | x or y
`[x-z]` | x to z
`[^x]` | Any character but x
`x?` | Optional x
`x*` | 0, 1, 2, ... instances of x
`x+` | 1, 2, 3, ... instances of x
`x{m,n}` | m through n occurrences of x
`xx|yy` | Either xx or yy
`(x)` | x
`x/y` | x but only if followed by y

## Constructing the Automata

1. Convert Regular Expressions to Non-deterministic Finite Automata (NFA)
1. Convert NFA to Deterministic Finite Automata (DFA)
3. Execute the machine to recognize tokens

### Non-deterministic Finite Automata (NFA)

Consists of
1. A finite set of states S
2. An input alphabet  : a set of input symbols
3. A transition function: S x ( [ 2) (S)
4. A start state s0 2 S
5. A set F μ S of accepting/final states

### Deterministic Finite Automata (DFA)

A special case of an NFA where:

- No moves on input ε
- For each state s and input symbol a, there
is exactly one edge out of s labeled a
- Transition function: S x   S

### Conversion between NFA & DFA

Every regular expression (defining a
language) can be converted into an NFA
accepting the same language.

Every NFA can be converted to a DFA
accepting the same language.

A n-state NFA may be converted to a DFA with at most 2n states.

INPUT: A regular expression r over 
- OUTPUT: An NFA N accepting L( r )
- METHOD: Two sets of rules
    + Basis rule: handling subexpressions with no operations
    + Inductive rule: constructing larger NFA’s from the NFA’s for the immediate subexpressions of a given expression

## Glossary of Terms

Token – Tuple of <Token Name, Attribute value><br/>
Attributes used to distinguish lexeme e.g. `<number, 1>` & `<number, 2>`

Pattern – A description of the form that can be
recognized as a token

Lexeme – A sequence of characters matching the
pattern for a token

Token | Informal Description | Sample Lexemes
------|----------------------|---------------
if | characters i, f | if
else | characters e, l, s, e | else
operators | < or > or <= or >= or == or != | <=, !=
id | letter followed by letters and digits | pi, score, D2
number | any numeric constant | 3.14159, 0, 6.02e23
literal | anything but ", surrounded by "'s | "core dumped"
