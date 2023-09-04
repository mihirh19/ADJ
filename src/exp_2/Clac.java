package exp_2;

public class Clac {

    @FunctionalInterface
    interface MathOperation{
        int operation(int m, int n);
    }

    public int operate(int m, int n, MathOperation mathOperation){
        return mathOperation.operation(m, n);
    }

    private void addition(int m, int n){
        MathOperation additionOp = (int a, int b) -> a + b;
        System.out.println("Addition of " + m + " and " + n + " is " + operate(m, n, additionOp));
    }

    private void subtraction(int m, int n){
        MathOperation subtractionOp = (int a, int b) -> a - b;
        System.out.println("Subtraction of " + m + " and " + n + " is " + operate(m, n, subtractionOp));
    }

    private void multiplication(int m, int n){
        MathOperation multiplicationOp = (int a, int b) -> a * b;
        System.out.println("Multiplication of " + m + " and " + n + " is " + operate(m, n, multiplicationOp));
    }

    private void division(int m, int n){
        MathOperation divisionOp = (int a, int b) -> a / b;
        System.out.println("Division of " + m + " and " + n + " is " + operate(m, n, divisionOp));
    }


    public static void main(String[] args) {
        Clac clac = new Clac();
        clac.addition(10, 20);
        clac.subtraction(10, 20);
        clac.multiplication(10, 20);
        clac.division(10, 20);
    }
}

