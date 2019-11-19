public class Calculator {

    public int adding(int first, int second) {
        int sum = first + second;
        return sum;
    }

    public int multiply(int first, int second) {
        int sum = first * second;
        return sum;
    }

    public double division(int first, int second) {
        double sum = first / second;
        return sum;
    }

    public boolean checkMyKeno(int howManyNumbers){
        return howManyNumbers == myHiddenArray().length;
    }

    private int[] myHiddenArray() {
        int[] myKenoNumbers = new int[]{44, 1, 36, 11, 89, 37};
        return myKenoNumbers.clone();
    }
}