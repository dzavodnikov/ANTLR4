// Generated from org/zavodnikov/antlr4/brackets/Brackets.g4 by ANTLR 4.7

    package org.zavodnikov.antlr4.brackets;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BracketsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BracketsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BracketsParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(BracketsParser.RContext ctx);
	/**
	 * Visit a parse tree produced by {@link BracketsParser#e}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitE(BracketsParser.EContext ctx);
}