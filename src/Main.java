import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scannerObject = new Scanner(System.in);
        System.out.print("Enter the Year: ");
        int selectedYear = scannerObject.nextInt();
        System.out.print("Enter the month: ");
        int selectedMonth = scannerObject.nextInt() - 1; // 0 based so July = 7 - 1.

        Calendar calendarObject = new GregorianCalendar();
        int calendarDay = calendarObject.get(Calendar.DATE); // day of the month
        int calendarMonth = calendarObject.get(Calendar.MONTH); // month of the year
        int calendarYear = calendarObject.get(Calendar.YEAR); // which year it is

        GregorianCalendar gregorianCalendarObject = new GregorianCalendar(selectedYear,
                selectedMonth, 1);
        int days = gregorianCalendarObject.getActualMaximum(Calendar.DATE); // days in month
        int startInWeek = gregorianCalendarObject.get(Calendar.DAY_OF_WEEK); // day starting
        // first week

        gregorianCalendarObject = new GregorianCalendar(selectedYear, selectedMonth, days);
        int totalWeeks = gregorianCalendarObject.getActualMaximum(Calendar.WEEK_OF_MONTH); //
        // total week in selectedMonth

        int count = 1; // Count the days

        String[] months = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        System.out.println(months[selectedMonth] + " " + selectedYear);

        System.out.print("Su Mo Tu We Th Fr Sa");

        for(int i = 1; i <= totalWeeks; i++) {
            System.out.println(); // to next line

            for(int j = 1; j <= 7; j++) {

                if(count < startInWeek || (count - startInWeek + 1) > 31) {
                    System.out.print("__");
                    System.out.print(" ");

                } else {

                    if(calendarDay == (count - startInWeek + 1) && calendarMonth == selectedMonth && calendarYear == selectedYear) {
                        System.out.print("'" + convertDateToString((count - startInWeek + 1)) + "'");
                        System.out.print(" ");
                    } else {
                        System.out.print(convertDateToString((count - startInWeek + 1)));
                        System.out.print(" ");
                    }
                }
                count++;
            }
        }
    }

    private static String convertDateToString(int i) {

        String stringDate = Integer.toString(i);

        if(stringDate.length() == 1) {
            stringDate = "0" + stringDate;
            return stringDate;
        }
        return stringDate;
    }
}
