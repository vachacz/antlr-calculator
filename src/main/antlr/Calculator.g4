grammar Calculator;

expr:	expr '*' expr # Multiply
    |	expr '/' expr # Devide
    |	expr '+' expr # Add
    |	expr '-' expr # Subtract
    |	'(' expr ')'  # Braces
    |	INT           # Int
    ;

INT     : [0-9]+ ;