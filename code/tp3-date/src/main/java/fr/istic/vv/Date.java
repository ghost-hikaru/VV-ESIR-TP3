package fr.istic.vv;

class Date implements Comparable<Date> {
    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValid(int day, int month, int year) {
        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 0) {
            return false;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        }
        return true;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public Date nextDate() {
        if (isValid(day, month, year)) {
            if (day == 31 && month == 12) {
                return new Date(1, 1, year + 1);
            }
            if (day == 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10)) {
                return new Date(1, month + 1, year);
            }
            if (day == 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
                return new Date(1, month + 1, year);
            }
            if (day == 28 && month == 2 && !isLeapYear(year)) {
                return new Date(1, 3, year);
            }
            if (day == 29 && month == 2 && isLeapYear(year)) {
                return new Date(1, 3, year);
            }
            return new Date(day + 1, month, year);
        }
        return null;
    }

    public Date previousDate() {
        if (isValid(day, month, year)) {
            if (day == 1 && month == 1) {
                return new Date(31, 12, year - 1);
            }
            if (day == 1 && (month == 2 || month == 4 || month == 6 || month == 8 || month == 9 || month == 11)) {
                return new Date(31, month - 1, year);
            }
            if (day == 1 && (month == 5 || month == 7 || month == 10 || month == 12)) {
                return new Date(30, month - 1, year);
            }
            if (day == 1 && month == 3 && !isLeapYear(year)) {
                return new Date(28, 2, year);
            }
            if (day == 1 && month == 3 && isLeapYear(year)) {
                return new Date(29, 2, year);
            }
            return new Date(day - 1, month, year);
        }
        return null;

    }

    public int compareTo(Date other) {
        if (year < other.year) {
            return -1;
        }
        if (year > other.year) {
            return 1;
        }
        if (month < other.month) {
            return -1;
        }
        if (month > other.month) {
            return 1;
        }
        if (day < other.day) {
            return -1;
        }
        if (day > other.day) {
            return 1;
        }
        return 0;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof Date)) {
            return false;
        }
        Date other = (Date) o;
        return day == other.day && month == other.month && year == other.year;
    }
}

