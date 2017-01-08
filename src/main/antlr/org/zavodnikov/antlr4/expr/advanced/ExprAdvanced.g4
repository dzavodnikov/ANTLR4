// Define a grammar called ExprAdvanced.
grammar ExprAdvanced;


@header {
    package org.zavodnikov.antlr4.expr.advanced;
}


// Import rules from another file.
import CommonLexerRules;


// Parser rules (starts with lowercase letter).
prog    : stat+ ;
                                        // Labels definitions.
stat    : expr NL                       # print
        | ID '=' expr NL                # assign
        | NL                            # blank
        ;
                                        // If you are using labels, you should add label for EACH alternative.
expr    : expr op = (MUL | DIV) expr    # MulDiv
        | expr op = (ADD | SUB) expr    # AddSub
        | INT                           # Int
        | ID                            # Id
        | '(' expr ')'                  # Parens
        ;


// Lexer rules (starts with UPPERCASE letter).
MUL     : '*' ;
DIV     : '/' ;
ADD     : '+' ;
SUB     : '-' ;

/*
ID      : [a-z]+ ;                      // Match lower-case identifiers.
INT     : [0-9]+ ;
WS      : [ \t\r\n]+ -> skip ;
*/
