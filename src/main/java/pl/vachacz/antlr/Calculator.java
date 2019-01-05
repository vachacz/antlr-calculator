package pl.vachacz.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import pl.vachacz.antlr.gen.CalculatorLexer;
import pl.vachacz.antlr.gen.CalculatorParser;

public class Calculator {

    public Integer calculate(String expression) {
        ThrowingErrorListener errorListener = new ThrowingErrorListener();

        CalculatorLexer lexer = new CalculatorLexer(CharStreams.fromString(expression));
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        CalculatorVisitor calculator = new CalculatorVisitor();

        return calculator.visit(parser.expr());
    }

    public static class ThrowingErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
                throws ParseCancellationException {
            throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
        }
    }

}
