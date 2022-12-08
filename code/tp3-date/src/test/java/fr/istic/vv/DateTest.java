package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    @Test
    public void testNextDate() {
        int LeapYear = 2016; // 2016 % 4 = 0 and 2016 % 100 != 0 or 2016 % 400 = 0
        int NotLeapYear = 2017; // 2017 % 4 != 0

        Date date = new Date(31, 12, NotLeapYear);
        assertEquals(new Date(1, 1, NotLeapYear + 1), date.nextDate());
        date = new Date(31, 1, NotLeapYear);
        assertEquals(new Date(1, 2, NotLeapYear), date.nextDate());

        int[] monthsWith30Days = {4, 6, 9, 11}; // months with 30 days
        for (int month : monthsWith30Days) {
            date = new Date(30, month, NotLeapYear);
            assertEquals(new Date(1, month + 1, NotLeapYear), date.nextDate());
        }

        int[] monthsWith31Days = {1, 3, 5, 7, 8, 10}; // months with 31 days
        for (int month : monthsWith31Days) {
            date = new Date(31, month, NotLeapYear);
            assertEquals(new Date(1, month + 1, NotLeapYear), date.nextDate());
        }

        date = new Date(28, 2, NotLeapYear);
        assertEquals(new Date(1, 3, NotLeapYear), date.nextDate());
        date = new Date(29, 2, LeapYear);
        assertEquals(new Date(1, 3, LeapYear), date.nextDate());

        date = new Date(15, 11, LeapYear);
        assertEquals(new Date(16, 11, LeapYear), date.nextDate());

        date = new Date(42, 11, NotLeapYear);
        assertNull(date.nextDate());


    }

    @Test
    public void testPreviousDate() {
        int LeapYear = 2016; // 2016 % 4 = 0 and 2016 % 100 != 0 or 2016 % 400 = 0
        int NotLeapYear = 2017; // 2017 % 4 != 0

        Date date = new Date(1, 1, NotLeapYear);
        assertEquals(new Date(31, 12, NotLeapYear - 1), date.previousDate());
        date = new Date(1, 2, NotLeapYear);
        assertEquals(new Date(31, 1, NotLeapYear), date.previousDate());

        int[] monthsAfterMonthWith30Days = {5, 7, 10, 12}; // months after month with 30 days
        for (int month : monthsAfterMonthWith30Days) {
            date = new Date(1, month, NotLeapYear);
            assertEquals(new Date(30, month - 1, NotLeapYear), date.previousDate());
        }

        int[] monthsAfterMonthWith31Days = {2, 4, 6, 8, 9, 11}; // months after month with 31 days
        for (int month : monthsAfterMonthWith31Days) {
            date = new Date(1, month, NotLeapYear);
            assertEquals(new Date(31, month - 1, NotLeapYear), date.previousDate());
        }

        date = new Date(1, 3, NotLeapYear);
        assertEquals(new Date(28, 2, NotLeapYear), date.previousDate());
        date = new Date(1, 3, LeapYear);
        assertEquals(new Date(29, 2, LeapYear), date.previousDate());

        date = new Date(15, 11, LeapYear);
        assertEquals(new Date(14, 11, LeapYear), date.previousDate());

        date = new Date(42, 11, NotLeapYear);
        assertNull(date.previousDate());
    }

    @Test
    public void testCompareTo() {
        Date date1 = new Date(1, 1, 2017);
        Date date2 = new Date(1, 1, 2017);
        assertEquals(0, date1.compareTo(date2));

        date1 = new Date(1, 1, 2017);
        date2 = new Date(1, 1, 2018);
        assertEquals(-1, date1.compareTo(date2));

        date1 = new Date(1, 1, 2018);
        date2 = new Date(1, 1, 2017);
        assertEquals(1, date1.compareTo(date2));


    }

    @Test
    public void testIsLeapYear() {
        int LeapYear = 2016; // 2016 % 4 = 0 and 2016 % 100 != 0 or 2016 % 400 = 0
        int NotLeapYear = 2017; // 2017 % 4 != 0
        assertFalse(Date.isLeapYear(NotLeapYear));
        assertTrue(Date.isLeapYear(LeapYear));
    }

    @Test
    public void testEquals() {
        Date date1 = new Date(1, 1, 2016);
        Date date2 = new Date(1, 1, 2016);
        assertTrue(date1.equals(date2));
        date1 = new Date(1, 1, 2016);
        date2 = new Date(1, 1, 2017);
        assertFalse(date1.equals(date2));
        date1 = new Date(1, 1, 2016);
        date2 = new Date(1, 2, 2016);

        date1 = new Date(1, 1, 2016);
        date2 = null;
        assertFalse(date1.equals(date2));

    }

    @Test
    public void testIsValideDate() {
        assertFalse(Date.isValid(0, 1, 2016));
        assertFalse(Date.isValid(32, 1, 2016));

        assertFalse(Date.isValid(1, 0, 2016));
        assertFalse(Date.isValid(1, 13, 2016));
        assertFalse(Date.isValid(1, 1, -500));
        int notLeapYear = 401; // 401 % 4 = 1 and 401 % 100 = 1 and 401 % 400 = 1
        int leapYear = 400; // 400 % 4 = 0 and 400 % 100 = 0 and 400 % 400 = 0
        assertFalse(Date.isValid(29, 2, notLeapYear));
        assertTrue(Date.isValid(28, 2, notLeapYear));
        assertTrue(Date.isValid(29, 2, leapYear));
        assertFalse(Date.isValid(30, 2, leapYear));
    }


}