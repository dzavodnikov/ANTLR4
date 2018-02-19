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
package org.zavodnikov.antlr4.expr.advanced;

import java.util.HashMap;
import java.util.Map;

import org.zavodnikov.antlr4.expr.advanced.ExprAdvancedParser.AddSubContext;
import org.zavodnikov.antlr4.expr.advanced.ExprAdvancedParser.AssignContext;
import org.zavodnikov.antlr4.expr.advanced.ExprAdvancedParser.IdContext;
import org.zavodnikov.antlr4.expr.advanced.ExprAdvancedParser.IntContext;
import org.zavodnikov.antlr4.expr.advanced.ExprAdvancedParser.MulDivContext;
import org.zavodnikov.antlr4.expr.advanced.ExprAdvancedParser.ParensContext;
import org.zavodnikov.antlr4.expr.advanced.ExprAdvancedParser.PrintContext;

/**
 * All methods called by there parent method directly.
 *
 * @author Dmitry Zavodnikov (d.zavodnikov@gmail.com)
 */
public class ExprVisitor extends ExprAdvancedBaseVisitor<Integer> {

    private final Map<String, Integer> memory = new HashMap<>();

    private int result;

    public int getResult() {
        return this.result;
    }

    @Override
    public Integer visitPrint(final PrintContext ctx) {
        this.result = visit(ctx.expr());

        return 0;
    }

    @Override
    public Integer visitAssign(final AssignContext ctx) {
        final String id = ctx.ID().getText();
        final int value = visit(ctx.expr());

        this.memory.put(id, value);

        return value;
    }

    @Override
    public Integer visitMulDiv(final MulDivContext ctx) {
        final int left = visit(ctx.expr(0));
        final int right = visit(ctx.expr(1));
        if (ctx.op.getType() == ExprAdvancedParser.MUL) {
            return left * right;
        } else {
            return left / right;
        }
    }

    @Override
    public Integer visitAddSub(final AddSubContext ctx) {
        final int left = visit(ctx.expr(0));
        final int right = visit(ctx.expr(1));
        if (ctx.op.getType() == ExprAdvancedParser.ADD) {
            return left + right;
        } else {
            return left - right;
        }
    }

    @Override
    public Integer visitInt(final IntContext ctx) {
        return Integer.parseInt(ctx.INT().getText());
    }

    @Override
    public Integer visitId(final IdContext ctx) {
        final String id = ctx.ID().getText();
        if (this.memory.containsKey(id)) {
            return this.memory.get(id);
        } else {
            throw new RuntimeException(String.format("Unknown variable %s!", id));
        }
    }

    @Override
    public Integer visitParens(final ParensContext ctx) {
        return visit(ctx.expr());
    }
}
