package org.example.week03;

public class AddOperation extends AbstractOperation {

    @Override
    public double operate(int operand_one ,int operand_two) {
        return (double)operand_one + operand_two;
    }

    @Override
    public double operate(double operand_one ,double operand_two) {
        return operand_one + operand_two;
    }
}
