import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        String expression; //выражение для input
        //NumberReader.getInteger();
        Scanner reader = new Scanner(System.in);
        System.out.println("Input:");

        expression = reader.next();

        StringCalc(String.valueOf(expression));
    }
    public static void StringCalc(String input) {
        String a = null;//=0; //переменная а
        String b = null;//=0; // переменная b
        int convA = 0;
        int convB = 0;
        int rezult = 0;
        int countWhile = 0;
        boolean isError = false; //переполнение операндов
        boolean isErrorSystemNumber = false; // Разные системы счисления
        boolean isErrorNotMath = false; // не математическая операция
        boolean isErrorNegative = false; // Отрицательное значение
        boolean isRim = false; // 
        String oper = null;
        String rezultRim = null;
        Scanner operandArray = new Scanner( input );
        operandArray.useDelimiter("");
        while ( operandArray.hasNext() ){//Int
            countWhile++;
            if(a == null) a = operandArray.next();
            else if(oper == null){ oper = operandArray.next();}
            else if(b == null){ b = operandArray.next();}
                else{ // в массиве больше чем 2 операнда
                isError = true;
                operandArray.next();
            }
        }
        if(countWhile == 1){
            isErrorNotMath = true;
        }
        if (isErrorNotMath) {
            System.out.println("Output: ");
            System.out.println("throws Exception //т.к. строка не является математической операцией");
            System.exit(1);
        }
    //проверка римских цифр
        String[] numeralsRim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",  "X"};
        String[] numeralsArab = {"1", "2", "3", "4", "5", "6", "7", "8", "9",  "10"};
        if (a.contains("I") || a.contains("V") || a.contains("X")){
            for (int i = 0; i < numeralsRim.length; i++) {

                if ( a.equals(numeralsRim[i])){
                    convA = Integer.parseInt(numeralsArab[i]);
                }
            }
            if(b.contains("I") || b.contains("V") || b.contains("X")){
                for (int i = 0; i < numeralsRim.length; i++) {
                    if (b.equals(numeralsRim[i])){
                        convB = Integer.parseInt(numeralsArab[i]);
                    }
                }
                isRim = true;
            }
            else{
                isErrorSystemNumber = true; //второй операнд арабская цирфа
            }


        }
        else{
            if(b.contains("I") || b.contains("V") || b.contains("X")){
                isErrorSystemNumber = true; //второй операнд арабская цирфа
            }

        }
/*        else{
            convA = Integer.parseInt(a);
        }
        if (b.contains("I") || b.contains("V") || b.contains("X")){
            for (int i = 0; i <= numeralsRim.length; i++) {
                if (b.equals(numeralsRim[i])){
                    convB = Integer.parseInt(numeralsArab[i]);
                }
            }

        }
        else{
            convB = Integer.parseInt(b);
        }*/
        if(isRim){
            if(isError){
                System.out.println("Output: ");
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            } else if (isErrorNegative) {
                System.out.println("Output: ");
                System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
            } else if (isErrorSystemNumber) {
                System.out.println("Output: ");
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
            }
             else {
                if( convA > 10 || convB > 10){
                    System.out.println("Output: ");
                    System.out.println("throws Exception //т.к. один из операндов > 10");
                    System.exit(1);
                }
                if (oper.equals("+")) {
                    rezult = convA + convB;
                } else if (oper.equals("-")) {
                    rezult = convA - convB;
                } else if (oper.equals("/")) {
                    rezult = convA / convB;
                } else if (oper.equals("*")) {
                    rezult = convA * convB;
                } else {
                    System.out.println("Error operation");
                }
              rezultRim = String.valueOf(rezult);
              for(int i = 0; i < numeralsArab.length; i++){
                if (rezultRim.equals(numeralsArab[i])){
                    System.out.println("Output: ");
                    System.out.println(numeralsRim[i]);
                }
              }
            }
        }
        else{
            if( convA > 10 || convB > 10){
                System.out.println("Output: ");
                System.out.println("throws Exception //т.к. один из операндов > 10");
                System.exit(1);
            }
            if(isError){
                System.out.println("Output: ");
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            } else if (isErrorNegative) {
                System.out.println("Output: ");
                System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
            } else if (isErrorSystemNumber) {
                System.out.println("Output: ");
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
            } else if (isErrorNotMath) {
                System.out.println("Output: ");
                System.out.println("throws Exception //т.к. строка не является математической операцией");
            } else {
                if (oper.equals("+")) {
                    rezult = convA + convB;
                } else if (oper.equals("-")) {
                    rezult = convA - convB;
                } else if (oper.equals("/")) {
                    rezult = convA / convB;
                } else if (oper.equals("*")) {
                    rezult = convA * convB;
                } else {
                    System.out.println("Error operation");
                }
                System.out.println("Output: ");
                System.out.println(rezult);
            }
        }
    }
}