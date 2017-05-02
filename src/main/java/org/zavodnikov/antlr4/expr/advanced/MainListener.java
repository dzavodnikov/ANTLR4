/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Dmitry Zavodnikov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.zavodnikov.antlr4.expr.advanced;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * @author Dmitry Zavodnikov (d.zavodnikov@gmail.com)
 */
public class MainListener {

    public static int run(final String data) throws IOException {
        CharStream input;
        if (data == null) {
            // Create a CharStream that reads from standard input.
            input = CharStreams.fromStream(System.in);
        } else {
            input = CharStreams.fromString(data);
        }

        // Create a lexer that feeds off of input CharStream.
        final ExprAdvancedLexer lexer = new ExprAdvancedLexer(input);

        // Create a buffer of tokens pulled from the lexer.
        final CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create a parser that feeds off the tokens buffer.
        final ExprAdvancedParser parser = new ExprAdvancedParser(tokens);

        // Begin parsing at "prog" rule.
        final ParseTree tree = parser.prog();

        // Create a generic parse tree walker that can trigger callbacks.
        final ParseTreeWalker walker = new ParseTreeWalker();

        // Walk the tree created during the parse, trigger callbacks.
        final ExprListener listener = new ExprListener();
        walker.walk(listener, tree);
        return listener.getResult();
    }
}
