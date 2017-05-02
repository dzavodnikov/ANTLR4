// Generated from org\zavodnikov\antlr4\expr\simple\ExprSimple.g4 by ANTLR 4.7

    package org.zavodnikov.antlr4.expr.simple;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprSimpleParser}.
 */
public interface ExprSimpleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprSimpleParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExprSimpleParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprSimpleParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExprSimpleParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprSimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExprSimpleParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprSimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExprSimpleParser.ExprContext ctx);
}