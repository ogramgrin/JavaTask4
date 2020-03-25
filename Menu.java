import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Menu {
    private static int menu = -1;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String strMenu = "";

    public static void main(String[] args) throws IOException, ParseException, ValidationExeption{

        menu();

        while (menu != 0) {
            strMenu = reader.readLine();
            try {
                menu = Integer.parseInt(strMenu);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter an INTEGER number. ");
            }

            if ((menu > 4) || (menu < 0)) {
                System.out.print("Enter RIGHT value: ");
                menu = -1;
            } else {
                switch (menu) {
                    case 0:
                        return;
                    case 1:
                        HelloWorld helloWorld = new HelloWorld();
                        helloWorld.printHelloWorld();
                        menu = -1;
                        menu();
                        break;
                    case 2:
                        Calculate calculate = new Calculate();
                        calculate.enterNum(reader);
                        menu = -1;
                        menu();
                        break;
                    case 3:
                        Recursion recursion = new Recursion();
                        recursion.recursionDate(reader);
                        menu();
                        break;
                    case 4:
                        Strings strings = new Strings();
                        strings.stringsWork(reader);
                        menu();
                        break;
                }
            }

        }
    }

    public static void menu() {
        System.out.println("");
        System.out.println("0. Exit");
        System.out.println("1. Hello World!");
        System.out.println("2. Calc: sqrt (X) - 6 / Z");
        System.out.println("3. Recursion date");
        System.out.println("4. Strings");
        System.out.print("Choose option: ");
    }
}
