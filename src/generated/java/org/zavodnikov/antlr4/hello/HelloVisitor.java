// Generated from org\zavodnikov\antlr4\hello\Hello.g4 by ANTLR 4.7

    package org.zavodnikov.antlr4.hello;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HelloParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HelloVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HelloParser#all}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAll(HelloParser.AllContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(HelloParser.RContext ctx);
}