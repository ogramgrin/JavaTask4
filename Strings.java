/*Реализовать ввод 2х строк
        Вывести на экран:
        Совпадают ли они посимвольно
        Если привести к одному регистру, удалить пробелы в начале и в конце + дублирование пробелов.
        Являются ли 1 строка перевёртышем к другой (символы в обратной последовательности)
        Являются ли строки: email'ом, тел. номером, IP-адресом (при помощи RegExp. Cм. https://ihateregex.io/)*/


import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {

    public void stringsWork(BufferedReader reader) throws IOException, ValidationExeption{
        System.out.println("Enter two strings.");
        System.out.printf("First string: ");
        String str1 = reader.readLine();
        System.out.printf("\nSecond string:");
        String str2 = reader.readLine();

        isEqualStrings(str1, str2);
        modificatedStrings(str1, str2);
        isOverturned(str1, str2);
        isEmail(str1, str2);
        isPhoneNumber(str1, str2);
        isIP(str1, str2);
    }

    public void isEqualStrings(String str1, String str2) throws ValidationExeption {
        if (str1.equals(str2)) System.out.println("Strings are equals.");
        else throw new ValidationExeption("Произошла ошибка");
    }

    public void modificatedStrings(String str1, String str2) throws ValidationExeption {
        str1.toLowerCase();
        str2.toLowerCase();
        str1.trim();
        str2.trim();
        str1.replace("  ", " ");
        str2.replace("  ", " ");

        System.out.printf("After some modifications: ");
        if (str1.equals(str2)) System.out.println("Strings are equals.");
        else throw new ValidationExeption("Произошла ошибка");
    }

    public void isOverturned(String str1, String str2) throws ValidationExeption {
        char[] str1Array = str1.toCharArray();
        char[] str2Array = str2.toCharArray();

        for (int i = 0, j = str2.length() - 1; i < str2.length() / 2; i++, j--) {
            if (str1Array[i] != str2Array[j]) System.out.println("They are not overturned");
            else throw new ValidationExeption("Произошла ошибка");
        }

    }

    public void isEmail(String str1, String str2) throws ValidationExeption {
        Pattern patternEmail = Pattern.compile("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+");
        Matcher matStr1 = patternEmail.matcher(str1);
        Matcher matStr2 = patternEmail.matcher(str2);

        if (matStr1.matches()) System.out.println("" + str1 + " is an email.");
        else throw new ValidationExeption("Произошла ошибка");

        if (matStr2.matches()) System.out.println("" + str2 + " is an email.");
        else throw new ValidationExeption("Произошла ошибка");
    }


    public void isPhoneNumber(String str1, String str2) throws ValidationExeption {
        Pattern patternPhone = Pattern.compile("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$");
        Matcher matStr1 = patternPhone.matcher(str1);
        Matcher matStr2 = patternPhone.matcher(str2);

        if (matStr1.matches()) System.out.println("" + str1 + " is a phone number.");
        else throw new ValidationExeption("Произошла ошибка");

        if (matStr2.matches()) System.out.println("" + str2 + " is a phone number.");
        else throw new ValidationExeption("Произошла ошибка");
    }

    public void isIP(String str1, String str2) throws ValidationExeption {
        Pattern patternIP = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
        Matcher matStr1 = patternIP.matcher(str1);
        Matcher matStr2 = patternIP.matcher(str2);

        if (matStr1.matches()) System.out.println("" + str1 + " is an IP");
        else throw new ValidationExeption("Произошла ошибка");

        if (matStr2.matches()) System.out.println("" + str2 + " is an IP");
        else throw new ValidationExeption("Произошла ошибка");
    }
}
