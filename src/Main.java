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
        int calendarDay = calendarObject.get(Calendar.DATE);
        int calendarMonth = calendarObject.get(Calendar.MONTH);
        int calendarYear = calendarObject.get(Calendar.YEAR);

        // TESTING //
        System.out.println(calendarDay + " (day of the month)");
        System.out.println(calendarMonth + " (month of the year)");
        System.out.println(calendarYear + " (which year it is)");
        // TESTING //

        GregorianCalendar gregorianCalendarObject = new GregorianCalendar(selectedYear,
                selectedMonth, 1);
        int days = gregorianCalendarObject.getActualMaximum(Calendar.DATE);
        int startInWeek = gregorianCalendarObject.get(Calendar.DAY_OF_WEEK);

        // TESTING //
        System.out.println(days + " (days in the current month)");
        System.out.println(startInWeek + " (day starting the first week)");
        // TESTING //

        gregorianCalendarObject = new GregorianCalendar(selectedYear, selectedMonth, days);
        int totalWeeks = gregorianCalendarObject.getActualMaximum(Calendar.WEEK_OF_MONTH);

        // TESTING //
        System.out.println(totalWeeks + " (total weeks in selectedMonth)");
        // TESTING //

        int count = 1; // Count the days
        for(int i = 1; i <= totalWeeks; i++) {
            System.out.println(); // to next line

            for(int j = 1; j <= 7; j++) {

                if(count < startInWeek || (count - startInWeek + 1) > 31) {
                    System.out.print("__");
                    System.out.print(" ");

                } else {

                    if(calendarDay == (count - startInWeek + 1) && calendarMonth == selectedMonth && calendarYear == selectedYear) {
                        System.out.print("'" + getDay((count - startInWeek + 1)) + "'");
                        System.out.print(" ");
                    } else {
                        System.out.print(getDay((count - startInWeek + 1)));
                        System.out.print(" ");
                    }
                }
                count++;
            }
        }
    }

    private static String getDay(int i) {

        String sDate = Integer.toString(i);

        if(sDate.length() == 1) {
            sDate = "0" + sDate;
            return sDate;
        }
        return sDate;
    }
}
