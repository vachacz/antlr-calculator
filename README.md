ANTLR calculator
---
This is a demo project which is aimed to demonstrate complete and minimal example of ANTLR.
Project implements parser of simple arithmetic language on natural numbers (greater than zero). 

In order to build:
```
gradle build
```

Please note that ANTLR lexer and parser are generated as a part of the gradle build. 

In order to use:
```$java
Calculator calc = new Calculator();
calc.calculate("1+2+3");
```

Calculator grammar:
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

Example expressions:
```$antlr
1
1+2
5-4
2*3
6/3
(1+2)
(1+2)*3
4+(5-1)
(5+2)*(3-1)
```
