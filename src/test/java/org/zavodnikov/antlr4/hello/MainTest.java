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
package org.zavodnikov.antlr4.hello;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.BitSet;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link Main}.
 *
 * @author Dmitry Zavodnikov (d.zavodnikov@gmail.com)
 */
public class MainTest {

    public static final ANTLRErrorListener TEST_ERROR_LISTENER = new ANTLRErrorListener() {

        @Override
        public void syntaxError(final Recognizer<?, ?> recognizer, final Object offendingSymbol, final int line,
                final int charPositionInLine, final String msg, final RecognitionException e) {
            throw new RuntimeException("Syntax Error");
        }

        @Override
        public void reportContextSensitivity(final Parser recognizer, final DFA dfa, final int startIndex,
                final int stopIndex, final int prediction, final ATNConfigSet configs) {
            throw new RuntimeException("Report Context Sensitivity");
        }

        @Override
        public void reportAttemptingFullContext(final Parser recognizer, final DFA dfa, final int startIndex,
                final int stopIndex, final BitSet conflictingAlts, final ATNConfigSet configs) {
            throw new RuntimeException("Report Attempting Full Context");
        }

        @Override
        public void reportAmbiguity(final Parser recognizer, final DFA dfa, final int startIndex, final int stopIndex,
                final boolean exact, final BitSet ambigAlts, final ATNConfigSet configs) {
            throw new RuntimeException("Report Ambiguity");
        }
    };

    @Test
    public void getParserTestError1() {
        final HelloParser parser = Main.getParser("");
        Assert.assertNotNull(parser);

        parser.addErrorListener(MainTest.TEST_ERROR_LISTENER);

        try {
            final ParseTree tree = parser.r();
            assertNotNull(tree);

            fail("No Runtime Exception!");
        } catch (final RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getParserTestError2() {
        final HelloParser parser = Main.getParser("a");
        Assert.assertNotNull(parser);

        parser.addErrorListener(MainTest.TEST_ERROR_LISTENER);

        try {
            final ParseTree tree = parser.r();
            assertNotNull(tree);

            fail("No Runtime Exception!");
        } catch (final RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getParserTestError3() {
        final HelloParser parser = Main.getParser("hello");
        Assert.assertNotNull(parser);

        parser.addErrorListener(MainTest.TEST_ERROR_LISTENER);

        try {
            final ParseTree tree = parser.r();
            assertNotNull(tree);

            fail("No Runtime Exception!");
        } catch (final RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getParserTestError4() {
        final HelloParser parser = Main.getParser("hellob");
        Assert.assertNotNull(parser);

        parser.addErrorListener(MainTest.TEST_ERROR_LISTENER);

        try {
            final ParseTree tree = parser.r();
            assertNotNull(tree);

            fail("No Runtime Exception!");
        } catch (final RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getParserTest1() {
        final HelloParser parser = Main.getParser("hello a");
        assertNotNull(parser);

        final ParseTree tree = parser.r();
        assertNotNull(tree);

        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void getParserTest2() {
        final HelloParser parser = Main.getParser("hello b ");
        assertNotNull(parser);

        final ParseTree tree = parser.r();
        assertNotNull(tree);

        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void getParserTest3() {
        final HelloParser parser = Main.getParser("hello c ccc");
        assertNotNull(parser);

        final ParseTree tree = parser.r();
        assertNotNull(tree);

        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void getParserTest4() {
        final HelloParser parser = Main.getParser("hello d hello");
        assertNotNull(parser);

        final ParseTree tree = parser.r();
        assertNotNull(tree);

        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void getParserTest5() {
        final HelloParser parser = Main.getParser("hello e hello eee");
        assertNotNull(parser);

        final ParseTree tree = parser.r();
        assertNotNull(tree);

        System.out.println(tree.toStringTree(parser));
    }
}
