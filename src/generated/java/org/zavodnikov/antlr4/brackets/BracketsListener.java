// Generated from org\zavodnikov\antlr4\brackets\Brackets.g4 by ANTLR 4.7

    package org.zavodnikov.antlr4.brackets;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BracketsParser}.
 */
public interface BracketsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BracketsParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(BracketsParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link BracketsParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(BracketsParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link BracketsParser#e}.
	 * @param ctx the parse tree
	 */
	void enterE(BracketsParser.EContext ctx);
	/**
	 * Exit a parse tree produced by {@link BracketsParser#e}.
	 * @param ctx the parse tree
	 */
	void exitE(BracketsParser.EContext ctx);
}