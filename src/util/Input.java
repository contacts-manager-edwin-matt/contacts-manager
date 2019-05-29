package util;
import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    public String getString(String msg){
        System.out.println(msg);
        return scanner.nextLine().trim().toLowerCase();
    }

    // Catch cases when we run getString without params
    public String getString(){
        return getString("Write something: ");
    }

    public boolean yesNo(){
        String input = getString("Type yes/no: ");
        return input.equals("yes") || input.equals("y");
    }

    public int getInt(int min, int max){
        int num = getInt();

        if(num < min || num > max){
            System.out.println("Error outside of the boundaries");
            return getInt(min, max);
        }

        return num;
    }

    public int getInt(){
        return Integer.parseInt(getString("Give me a number: "));
    }

    public double getDouble(){
        return Double.parseDouble(getString("Give me a decimal"));
    }

    public double getDouble(double min, double max){
        double num = getDouble();

        if(num < min || num > max){
            System.out.println("Error outside of the boundaries");
            return getDouble(min, max);
        }

        return num;
    }
}
