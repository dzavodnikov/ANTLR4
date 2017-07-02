// Generated from org/zavodnikov/antlr4/hello/Hello.g4 by ANTLR 4.7

    package org.zavodnikov.antlr4.hello;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#all}.
	 * @param ctx the parse tree
	 */
	void enterAll(HelloParser.AllContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#all}.
	 * @param ctx the parse tree
	 */
	void exitAll(HelloParser.AllContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(HelloParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(HelloParser.RContext ctx);
}