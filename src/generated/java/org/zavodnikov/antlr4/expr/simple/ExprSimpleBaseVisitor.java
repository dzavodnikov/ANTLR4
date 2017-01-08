// Generated from org/zavodnikov/antlr4/expr/simple/ExprSimple.g4 by ANTLR 4.6

    package org.zavodnikov.antlr4.expr.simple;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link ExprSimpleVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class ExprSimpleBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements ExprSimpleVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitProg(ExprSimpleParser.ProgContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitExpr(ExprSimpleParser.ExprContext ctx) { return visitChildren(ctx); }
}