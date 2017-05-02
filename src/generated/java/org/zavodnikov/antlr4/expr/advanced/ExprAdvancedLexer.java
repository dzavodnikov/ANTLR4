// Generated from org\zavodnikov\antlr4\expr\advanced\ExprAdvanced.g4 by ANTLR 4.7

    package org.zavodnikov.antlr4.expr.advanced;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprAdvancedLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, MUL=4, DIV=5, ADD=6, SUB=7, ID=8, INT=9, DBL=10, 
		NL=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "MUL", "DIV", "ADD", "SUB", "DIGIT", "LETTER_LOWER", 
		"LETTER_UPPER", "LETTER", "ID", "INT", "DBL", "NL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'('", "')'", "'*'", "'/'", "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "MUL", "DIV", "ADD", "SUB", "ID", "INT", "DBL", 
		"NL", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ExprAdvancedLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ExprAdvanced.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16\\\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\5\f:\n\f\3\r\6\r=\n\r\r\r\16\r>\3\16\6\16B\n\16\r\16\16"+
		"\16C\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17O\n\17\3\20\5\20"+
		"R\n\20\3\20\3\20\3\21\6\21W\n\21\r\21\16\21X\3\21\3\21\2\2\22\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\2\23\2\25\2\27\2\31\n\33\13\35\f\37\r!\16\3"+
		"\2\6\3\2\62;\3\2c|\3\2C\\\4\2\13\13\"\"\2^\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5%\3\2"+
		"\2\2\7\'\3\2\2\2\t)\3\2\2\2\13+\3\2\2\2\r-\3\2\2\2\17/\3\2\2\2\21\61\3"+
		"\2\2\2\23\63\3\2\2\2\25\65\3\2\2\2\279\3\2\2\2\31<\3\2\2\2\33A\3\2\2\2"+
		"\35N\3\2\2\2\37Q\3\2\2\2!V\3\2\2\2#$\7?\2\2$\4\3\2\2\2%&\7*\2\2&\6\3\2"+
		"\2\2\'(\7+\2\2(\b\3\2\2\2)*\7,\2\2*\n\3\2\2\2+,\7\61\2\2,\f\3\2\2\2-."+
		"\7-\2\2.\16\3\2\2\2/\60\7/\2\2\60\20\3\2\2\2\61\62\t\2\2\2\62\22\3\2\2"+
		"\2\63\64\t\3\2\2\64\24\3\2\2\2\65\66\t\4\2\2\66\26\3\2\2\2\67:\5\23\n"+
		"\28:\5\25\13\29\67\3\2\2\298\3\2\2\2:\30\3\2\2\2;=\5\27\f\2<;\3\2\2\2"+
		"=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?\32\3\2\2\2@B\5\21\t\2A@\3\2\2\2BC\3\2"+
		"\2\2CA\3\2\2\2CD\3\2\2\2D\34\3\2\2\2EF\5\33\16\2FG\7\60\2\2GH\5\33\16"+
		"\2HO\3\2\2\2IJ\5\33\16\2JK\7\60\2\2KO\3\2\2\2LM\7\60\2\2MO\5\33\16\2N"+
		"E\3\2\2\2NI\3\2\2\2NL\3\2\2\2O\36\3\2\2\2PR\7\17\2\2QP\3\2\2\2QR\3\2\2"+
		"\2RS\3\2\2\2ST\7\f\2\2T \3\2\2\2UW\t\5\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2"+
		"\2XY\3\2\2\2YZ\3\2\2\2Z[\b\21\2\2[\"\3\2\2\2\t\29>CNQX\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}