/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2012-2018 Dmitry Zavodnikov
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
package org.zavodnikov.antlr4.expr.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zavodnikov.antlr4.expr.simple.ExprSimpleParser.ExprContext;
import org.zavodnikov.antlr4.expr.simple.ExprSimpleParser.ProgContext;

/**
 * All methods called by tree walker.
 *
 * @author Dmitry Zavodnikov (d.zavodnikov@gmail.com)
 */
public class ExprListener extends ExprSimpleBaseListener {

    private final Map<ExprContext, Integer> expressions = new HashMap<>();

    private final List<Integer> results = new ArrayList<>();

    public int getResult() {
        if (this.results.isEmpty()) {
            throw new RuntimeException("No any expressions!");
        }

        return this.results.get(this.results.size() - 1);
    }

    @Override
    public void exitExpr(final ExprContext ctx) {
        Integer res = null;

        switch (ctx.expr().size()) {
            case 2:
                final ExprContext leftExpr = ctx.expr(0);
                final ExprContext rightExpr = ctx.expr(1);

                final Integer leftInt = this.expressions.get(leftExpr);
                final Integer rightInt = this.expressions.get(rightExpr);

                if (ctx.MUL() != null) {
                    res = leftInt * rightInt;
                    break;
                }
                if (ctx.DIV() != null) {
                    res = leftInt / rightInt;
                    break;
                }
                if (ctx.ADD() != null) {
                    res = leftInt + rightInt;
                    break;
                }
                if (ctx.SUB() != null) {
                    res = leftInt - rightInt;
                    break;
                }

                throw new RuntimeException(String.format("Can not correct parse string '%s'!", ctx.getText()));

            case 1:
                final ExprContext expr = ctx.expr().get(0);

                res = this.expressions.get(expr);

                break;

            case 0:
                res = Integer.parseInt(ctx.INT().getText());

                break;

            default:
                throw new RuntimeException(String.format("Unknown stuation with expression: %s!", ctx.getText()));
        }

        this.expressions.put(ctx, res);
    }

    @Override
    public void exitProg(final ProgContext ctx) {
        for (final ExprContext expr : ctx.expr()) {
            this.results.add(this.expressions.get(expr));
        }
    }
}
