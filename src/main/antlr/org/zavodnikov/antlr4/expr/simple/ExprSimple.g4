grammar ExprSimple;


@header {
    package org.zavodnikov.antlr4.expr.simple;
}


prog    : expr+ ;

expr    : expr MUL expr
        | expr DIV expr
        | expr ADD expr
        | expr SUB expr
        | '(' expr ')'
        | INT
        ;


MUL     : '*' ;
DIV     : '/' ;
ADD     : '+' ;
SUB     : '-' ;

INT     : [0-9]+ ;
WS      : [ \t\r\n]+ -> skip ;
