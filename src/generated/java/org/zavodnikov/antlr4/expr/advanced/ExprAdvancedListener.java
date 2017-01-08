// Generated from org/zavodnikov/antlr4/expr/advanced/ExprAdvanced.g4 by ANTLR 4.6

    package org.zavodnikov.antlr4.expr.advanced;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprAdvancedParser}.
 */
public interface ExprAdvancedListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprAdvancedParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExprAdvancedParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprAdvancedParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExprAdvancedParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link ExprAdvancedParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrint(ExprAdvancedParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link ExprAdvancedParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrint(ExprAdvancedParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ExprAdvancedParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ExprAdvancedParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ExprAdvancedParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ExprAdvancedParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link ExprAdvancedParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(ExprAdvancedParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link ExprAdvancedParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(ExprAdvancedParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ExprAdvancedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(ExprAdvancedParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ExprAdvancedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(ExprAdvancedParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ExprAdvancedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(ExprAdvancedParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ExprAdvancedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(ExprAdvancedParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link ExprAdvancedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(ExprAdvancedParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link ExprAdvancedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(ExprAdvancedParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Id}
	 * labeled alternative in {@link ExprAdvancedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(ExprAdvancedParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link ExprAdvancedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(ExprAdvancedParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link ExprAdvancedParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(ExprAdvancedParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link ExprAdvancedParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(ExprAdvancedParser.IntContext ctx);
}