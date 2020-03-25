import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Recursion {

    public void recursionDate(BufferedReader reader) throws IOException, ParseException {
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd.MM.yyyy");
        int days1 = -1;
        int days2 = -1;
        boolean firstTen = false;
        boolean secondTen = false;

        while (firstTen == false) {
            System.out.println("Enter two date intervals with a difference of no more than 10 days");
            System.out.println("Enter the first interval (after every date push ENTER):");
            Date dataFirst = dataFormat.parse(reader.readLine());
            Date dataSecond = dataFormat.parse(reader.readLine());

            long millSeconds1 = dataSecond.getTime() - dataFirst.getTime();
            days1 = (int) (millSeconds1 / (24 * 60 * 60 * 1000));
            System.out.println("Difference between two days: " + days1);
            if ((days1 >= 0) && (days1 < 11)) firstTen = true;
            if(days1 < 0) System.out.println("Error: difference can't be less then 0.");
            if (days1 > 10) System.out.println("Please, enter 10-days-interval (:");
        }

        while (secondTen == false) {
            System.out.println("Enter the second interval (after every date push ENTER):");
            Date dataThird = dataFormat.parse(reader.readLine());
            Date dataFourth = dataFormat.parse(reader.readLine());

            long millSeconds2 = dataFourth.getTime() - dataThird.getTime();
            days2 = (int) (millSeconds2 / (24 * 60 * 60 * 1000));
            System.out.println("Difference between two days: " + days2);

            if ((days2 >= 0) && (days2 < 11)) secondTen = true;
            if (days2 < 0) System.out.println("Error: difference can't be less then 0.");
            if (days2 > 10) System.out.println("Please, enter 10-days-interval (:");
        }

        if ((days1 == 0) || (days1 == 1)) {
            System.out.println("" + days1 + "! = 1");
        } else {
            factorial(days1);
            System.out.println("" + days1 + "! = " + factorial(days1));
        }

        if ((days2 == 0) || (days2 == 1)) {
            System.out.println("" + days2 + "! = 1");
        } else {
            factorial(days2);
            System.out.println("" + days2 + "! = " + factorial(days2));
        }
    }

    public static int factorial (int n) {
        if (n == 0 || n == 1) return 1;
        else return n * factorial(n - 1);
    }
}
