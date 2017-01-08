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

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.zavodnikov.antlr4.expr.advanced.ExprAdvancedParser.AddSubContext;
import org.zavodnikov.antlr4.expr.advanced.ExprAdvancedParser.AssignContext;
import org.zavodnikov.antlr4.expr.advanced.ExprAdvancedParser.ExprContext;
import org.zavodnikov.antlr4.expr.advanced.ExprAdvancedParser.IdContext;
import org.zavodnikov.antlr4.expr.advanced.ExprAdvancedParser.IntContext;
import org.zavodnikov.antlr4.expr.advanced.ExprAdvancedParser.MulDivContext;
import org.zavodnikov.antlr4.expr.advanced.ExprAdvancedParser.ParensContext;
import org.zavodnikov.antlr4.expr.advanced.ExprAdvancedParser.PrintContext;

/**
 * All methods called by tree walker.
 *
 * @author Dmitry Zavodnikov (d.zavodnikov@gmail.com)
 */
public class ExprListener extends ExprAdvancedBaseListener {

    private final Map<String, Integer>            memory      = new HashMap<>();

    private final Map<ParserRuleContext, Integer> expressions = new HashMap<>();

    private int                                   result;

    private void throwUnknownExpression(final ExprContext expr) {
        throw new RuntimeException(String.format("Unknown expression %s!", expr.getText()));
    }

    public int getResult() {
        return this.result;
    }

    @Override
    public void exitPrint(final PrintContext ctx) {
        final ExprContext expr = ctx.expr();
        if (this.expressions.containsKey(expr)) {
            this.result = this.expressions.get(expr);
        } else {
            throwUnknownExpression(expr);
        }
    }

    @Override
    public void exitAssign(final AssignContext ctx) {
        final String id = ctx.ID().getText();
        final ExprContext expr = ctx.expr();
        if (this.expressions.containsKey(expr)) {
            final Integer value = this.expressions.get(expr);
            this.memory.put(id, value);
        } else {
            throwUnknownExpression(expr);
        }
    }

    @Override
    public void exitMulDiv(final MulDivContext ctx) {
        final ExprContext leftExpr = ctx.expr(0);
        final ExprContext rightExpr = ctx.expr(1);
        if (this.expressions.containsKey(leftExpr)) {
            if (this.expressions.containsKey(rightExpr)) {
                final int leftValue = this.expressions.get(leftExpr);
                final int rightValue = this.expressions.get(rightExpr);

                int result;
                if (ctx.op.getType() == ExprAdvancedParser.MUL) {
                    result = leftValue * rightValue;
                } else {
                    result = leftValue / rightValue;
                }
                this.expressions.put(ctx, result);
            } else {
                throwUnknownExpression(rightExpr);
            }
        } else {
            throwUnknownExpression(leftExpr);
        }
    }

    @Override
    public void exitAddSub(final AddSubContext ctx) {
        final ExprContext leftExpr = ctx.expr(0);
        final ExprContext rightExpr = ctx.expr(1);
        if (this.expressions.containsKey(leftExpr)) {
            if (this.expressions.containsKey(rightExpr)) {
                final int leftValue = this.expressions.get(leftExpr);
                final int rightValue = this.expressions.get(rightExpr);

                int result;
                if (ctx.op.getType() == ExprAdvancedParser.ADD) {
                    result = leftValue + rightValue;
                } else {
                    result = leftValue - rightValue;
                }
                this.expressions.put(ctx, result);
            } else {
                throwUnknownExpression(rightExpr);
            }
        } else {
            throwUnknownExpression(leftExpr);
        }
    }

    @Override
    public void exitInt(final IntContext ctx) {
        this.expressions.put(ctx, Integer.parseInt(ctx.getText()));
    }

    @Override
    public void exitId(final IdContext ctx) {
        final String id = ctx.ID().getText();
        if (this.memory.containsKey(id)) {
            this.expressions.put(ctx, this.memory.get(id));
        } else {
            throw new RuntimeException(String.format("Unknown variable %s!", id));
        }
    }

    @Override
    public void exitParens(final ParensContext ctx) {
        final ExprContext expr = ctx.expr();
        if (this.expressions.containsKey(expr)) {
            this.expressions.put(ctx, this.expressions.get(expr));
        } else {
            throwUnknownExpression(expr);
        }
    }
}
