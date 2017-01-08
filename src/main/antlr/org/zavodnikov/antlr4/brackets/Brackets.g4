grammar Brackets;


@header {
    package org.zavodnikov.antlr4.brackets;
}


r   : e+
    ;

e   : e e
    | '(' e ')'
    | '[' e ']'
    | '()'
    | '[]'
    ;


WS  : [ \t\r\n]+ -> skip
    ;
