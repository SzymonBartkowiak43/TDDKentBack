package org.example;

public class Sum implements Expression {
    Expression augend;
    Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to) {
        int amount = augend.reduce(bank,to).amount +
                addend.reduce(bank,to)
                        .amount;
        return new Money(amount,to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }
    public Expression times(int multipler){
        return new Sum(augend.times(multipler), addend.times(multipler));
    }
}
