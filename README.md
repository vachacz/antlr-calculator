ANTLR calculator
---
This is a demo project which is aimed to demonstrate complete and minimal example of ANTLR

In order to build:
```
gradle build
```

In order to use:
```$java
Calculator calc = new Calculator();
calc.calculate("1+2+3");
```

Implemented calculator grammar:
```$antlr
grammar Calculator;

expr:	expr '*' expr # Multiply
    |	expr '/' expr # Devide
    |	expr '+' expr # Add
    |	expr '-' expr # Subtract
    |	'(' expr ')'  # Braces
    |	INT           # Int
    ;

INT     : [0-9]+ ;
```