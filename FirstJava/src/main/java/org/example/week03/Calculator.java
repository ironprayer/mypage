package org.example.week03;

import java.util.Stack;

public class Calculator {

    private AbstractOperation abstractOperation;

    public double calculate(int operand_one, int operand_two){
        return abstractOperation.operate(operand_one, operand_two);
    }

    public double calculate(String expression) {

        String[] expressionSplit = expression.split("");

        Stack<Double> numbers = new Stack<>();
        Stack<String> operators = new Stack<>();

        StringBuilder number = new StringBuilder();
        for(String element : expressionSplit) {

            if(isOperator(element)) {
                String preOperator = operators.empty() ? null : operators.pop();

                if(preOperator == null) {
                    numbers.push(Double.valueOf(number.toString().trim()));
                }
                else if (preOperator.equals("*") || preOperator.equals("/")){
                    setOperator(preOperator);
                    numbers.push(abstractOperation.operate(numbers.pop(), Double.valueOf(number.toString().trim())));
                } else {
                    operators.push(preOperator);
                    numbers.push(Double.valueOf(number.toString().trim()));
                }

                number.delete(0, number.length());
                operators.push(element);
            } else {
                number.append(element);
            }
        }

        if(number.length() != 0 && !number.toString().equals("=")){
            numbers.push(Double.valueOf(number.toString().trim()));
        }

        while(!operators.empty()){
            Double operand_one = numbers.pop();
            Double operand_two = numbers.pop();
            setOperator(operators.pop());
            Double result = abstractOperation.operate(operand_two, operand_one);
            numbers.push(result);
        }

        return numbers.pop();
    }

    private boolean isOperator(String element){
        return element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/");
    }

    private Double toDouble(StringBuilder stringBuilder){
        return Double.valueOf(stringBuilder.toString().trim());
    }

    private void setOperator(String operator){
        if (operator.equals("+")) this.abstractOperation = new AddOperation();
        else if (operator.equals("-")) this.abstractOperation = new SubstractOperation();
        else if (operator.equals("/")) this.abstractOperation = new DvideOperation();
        else if (operator.equals("*")) this.abstractOperation = new MultiplyOperation();
    }
}
