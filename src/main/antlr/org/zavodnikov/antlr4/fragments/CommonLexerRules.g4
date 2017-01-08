lexer grammar CommonLexerRules;


/*
 * This rules do not result in tokens visible to the parser.
 */
fragment DIGIT          : [0-9] ;

fragment LETTER_LOWER   : [a-z] ;
fragment LETTER_UPPER   : [A-Z] ;
fragment LETTER         : LETTER_LOWER
                        | LETTER_UPPER
                        ;

// Identifier.
ID      : LETTER+ ;

// Integer.
INT     : DIGIT+ ;

// Double.
DBL     : INT '.' INT
        | INT '.'
        | '.' INT
        ;


// Newline.
NL      : '\r'? '\n' ;

// Whitespace.
WS      : [ \t]+ -> skip ;

// Separators (skip them all).
//SEP     : (NL | WS) -> skip ; // NOT WORKS!
