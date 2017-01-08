// Generated from org/zavodnikov/antlr4/expr/simple/ExprSimple.g4 by ANTLR 4.6

    package org.zavodnikov.antlr4.expr.simple;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprSimpleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprSimpleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprSimpleParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ExprSimpleParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprSimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ExprSimpleParser.ExprContext ctx);
}