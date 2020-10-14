public class Calculator {
    private double operandOne;
    private double operandTwo;
    private String operation;
    private double result;
    
    public Calculator() {

    }

    public void setOperandOne(double number){
        this.operandOne = number;
    }

    public void setOperandTwo(double number){
        this.operandTwo = number;
    }

    public void setOperation(String operation){
        this.operation = operation;
    }

    public void performOperation(){
        if(operation == "+"){
            this.result = this.operandOne + this.operandTwo;
        }

        else if(operation == "-"){
            this.result = this.operandOne - this.operandTwo;
        }

        else {
            System.out.println("please set operand to '+' or '-' ");
        }
    }

    public double getResults(){
        System.out.println(this.result);
        return this.result;
    }
}