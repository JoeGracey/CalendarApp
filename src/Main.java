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

        GregorianCalendar gregorianCalendarObject = new GregorianCalendar(selectedYear,
                selectMonth, 1);
        int days = gregorianCalendarObject.getActualMaximum(Calendar.DATE);
        System.out.println(calendarDay);

    }
}
