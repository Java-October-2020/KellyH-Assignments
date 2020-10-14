public class CalcTest {
    public static void main(String[] args) {
        Calculator test = new Calculator();

        test.setOperandOne(10.5);
        test.setOperandTwo(5.2);
        test.setOperation("+");
        test.performOperation();
        test.getResults();

        test.setOperandOne(10);
        test.setOperandTwo(4.333);
        test.setOperation("-");
        test.performOperation();
        test.getResults();
    }
}
