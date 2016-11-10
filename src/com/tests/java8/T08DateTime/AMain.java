package com.tests.java8.T08DateTime;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AMain {

	public static void main(String[] main) {
		// Get the system clock as UTC offset.
		// Clock provides access to the current instant, date and time using a time-zone.
		// Clock can be used instead of System.currentTimeMillis() and TimeZone.getDefault().
		final Clock clock = Clock.systemUTC();
		
		System.out.println(clock.instant()); // 2016-11-10T22:21:44.972Z
		
		System.out.println(clock.millis()); // 1478816505402
		
		
		// Get the local date and local time.
		// LocaleDate holds only the date part without a timezone in the ISO-8601 calendar system.
		final LocalDate date = LocalDate.now();
		final LocalDate dateFromClock = LocalDate.now(clock);
		
		System.out.println(date); // 2016-11-10
		
		System.out.println(dateFromClock); // 2016-11-10
		
		// Get the local date and local time.
		// LocaleTime holds only the time part without time-zone in the ISO-8601 calendar system.
		final LocalTime time = LocalTime.now();
		final LocalTime timeFromClock = LocalTime.now(clock);
		
		System.out.println(time); // 20:24:05.189
		
		System.out.println(timeFromClock); // 22:24:05.189
		
		
		// Get the local date/time.
		// LocalDateTime combines together LocaleDate and LocalTime and holds a date with time but without a time-zone in the ISO-8601 calendar system.
		final LocalDateTime datetime = LocalDateTime.now();
		final LocalDateTime datetimeFromClock = LocalDateTime.now(clock);
		
		System.out.println(datetime); // 2016-11-10T20:26:35.195
		
		System.out.println(datetimeFromClock); // 2016-11-10T20:26:35.195
		
		
		// Get the zoned date/time.
		// If case you need a date/time for particular timezone, the ZonedDateTime is here to help.
		// It holds a date with time and with a time-zone in the ISO-8601 calendar system.
		final ZonedDateTime zonedDatetime = ZonedDateTime.now();
		final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now(clock);
		final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
		
		System.out.println(zonedDatetime); // 2016-11-10T20:28:45.439-02:00[America/Sao_Paulo]
		System.out.println(zonedDatetimeFromClock); // 2016-11-10T22:28:45.439Z
		System.out.println(zonedDatetimeFromZone); // 2016-11-10T14:28:45.443-08:00[America/Los_Angeles]
		
		
		// Get duration between two dates.
		final LocalDateTime from = LocalDateTime.of(2016, Month.DECEMBER, 18, 0, 0, 0);
		final LocalDateTime to = LocalDateTime.of(2017, Month.DECEMBER, 18, 23, 59, 59);
		final Duration duration = Duration.between(from, to);
		
		System.out.println("Duration in days: " + duration.toDays());
		System.out.println("Duration in hours: " + duration.toHours());
	}
}