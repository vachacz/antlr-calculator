package pl.vachacz.antlr;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ErrorNode;
import pl.vachacz.antlr.gen.CalculatorBaseVisitor;
import pl.vachacz.antlr.gen.CalculatorParser;

public class CalculatorVisitor extends CalculatorBaseVisitor<Integer> {

    @Override
    public Integer visitAdd(CalculatorParser.AddContext ctx) {
        return visit(ctx.expr(0)) + visit(ctx.expr(1));
    }

    @Override
    public Integer visitBraces(CalculatorParser.BracesContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Integer visitDevide(CalculatorParser.DevideContext ctx) {
        return visit(ctx.expr(0)) / visit(ctx.expr(1));
    }

    @Override
    public Integer visitMultiply(CalculatorParser.MultiplyContext ctx) {
        return visit(ctx.expr(0)) * visit(ctx.expr(1));
    }

    @Override
    public Integer visitSubtract(CalculatorParser.SubtractContext ctx) {
        return visit(ctx.expr(0)) - visit(ctx.expr(1));
    }

    @Override
    public Integer visitInt(CalculatorParser.IntContext ctx) {
        return Integer.parseInt(ctx.INT().getText());
    }


}
