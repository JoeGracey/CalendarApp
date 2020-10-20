import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {

        int selectedYear = 2020;
        int selectMonth = 2;

        Calendar calendarObject = new GregorianCalendar();
        int calendarDay = calendarObject.get(Calendar.DATE);
        int calendarMonth = calendarObject.get(Calendar.MONTH);
        int calendarYear = calendarObject.get(Calendar.YEAR);

        // Count the months
        GregorianCalendar gregorianCalendarObject = new GregorianCalendar(selectedYear,
                selectMonth, 1);
        int days = gregorianCalendarObject.getActualMaximum(Calendar.DATE);
        int startInWeek = gregorianCalendarObject.get(Calendar.DAY_OF_WEEK);

        // Count the weeks
        gregorianCalendarObject = new GregorianCalendar(selectedYear, selectMonth, days);
        int totalWeeks = gregorianCalendarObject.getActualMaximum(Calendar.WEEK_OF_MONTH);

        int count = 1; // Count the days
        for(int i = 1; i <= totalWeeks; i++) {

            for(int j = 1; j <= 7; j++) {

            }
            System.out.print(i + " ");
        }
        System.out.println(totalWeeks);

    }
}
