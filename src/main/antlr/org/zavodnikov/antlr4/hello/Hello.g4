// Define a grammar called Hello.
grammar Hello;


@header {
    package org.zavodnikov.antlr4.hello;
}


// Parser rules (starts with lowercase letter).
all     : r+ ;
r       : 'hello' ID ;              // Match keyword hello followed by an identifier.


// Lexer rules (starts with UPPERCASE letter).
ID      : [a-z]+ ;                  // Match lower-case identifiers.
WS      : [ \t\r\n]+ -> skip ;      // Skip spaces, tabs, newlines.
