package Lab1;
import java.util.Scanner;
public class DaysInMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = 0;
        int year;
        while (true) {
            System.out.print("Enter month: ");
            String input = sc.nextLine().trim().toLowerCase();
            switch (input) {
                case "1": case "jan": case "jan.": case "january":
                    month = 1; break;
                case "2": case "feb": case "feb.": case "february":
                    month = 2; break;
                case "3": case "mar": case "mar.": case "march":
                    month = 3; break;
                case "4": case "apr": case "apr.": case "april":
                    month = 4; break;
                case "5": case "may":
                    month = 5; break;
                case "6": case "jun": case "jun.": case "june":
                    month = 6; break;
                case "7": case "jul": case "jul.": case "july":
                    month = 7; break;
                case "8": case "aug": case "aug.": case "august":
                    month = 8; break;
                case "9": case "sep": case "sep.": case "september":
                    month = 9; break;
                case "10": case "oct": case "oct.": case "october":
                    month = 10; break;
                case "11": case "nov": case "nov.": case "november":
                    month = 11; break;
                case "12": case "dec": case "dec.": case "december":
                    month = 12; break;
                default:
                    System.out.println("Try again.");
                    continue;
            }
            break;
        }
        while (true) {
            System.out.print("Enter year: ");
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                if (year >= 0) break;
            } else {
                sc.next();
            }
            System.out.println("Try again.");
        }
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) 
                            || (year % 400 == 0);
        int days;
        switch (month) {
            case 2:
                days = isLeapYear ? 29 : 28;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            default:
                days = 31;
        }
        System.out.println("Number of days: " + days);
    }
}