import java.io.BufferedReader;
import java.io.IOException;

public class Calculate {

    public void enterNum (BufferedReader reader) throws IOException {
        System.out.println("Enter INTEGER values X, Z:");
        System.out.print("X = ");
        String strX = reader.readLine();
        String strZ;
        int X = 0;
        int Z = -1;
        boolean isIntX = false;
        boolean isIntZ = false;

        while (isIntX == false) {
            try {
                X = Integer.parseInt(strX);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter an INTEGER number. ");
                System.out.print("X = ");
                strX = reader.readLine();
            }
            if (X < 0) {
                System.out.println("Enter POSITIVE number. Try one more time (:");
                System.out.print("X = ");
                strX = reader.readLine();
            }
            if (X >= 0) isIntX = true;
        }

        System.out.print("Z = ");
        strZ = reader.readLine();

        while (isIntZ == false) {
            try {
                Z = Integer.parseInt(strZ);
                isIntZ = true;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter an INTEGER number. ");
                System.out.print("Z = ");
                strZ = reader.readLine();
            }
        }

        while (Z == 0) {
            System.out.println("Enter NOT NULL number. Try one more time (:");
            System.out.print("Z = ");
            Z = Integer.parseInt(reader.readLine());
        }
        calc(X, Z);
    }

    public static void calc(int X, int Z) {
        // sqrt(X) - 6/Z
        double result = Math.sqrt(X) - 6.0 / Z;
        System.out.format("sqrt (%d) - 6 / %d) = %.3f", X, Z, result);
        System.out.println("");
    }
}
