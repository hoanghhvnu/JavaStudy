package hoanghh.study.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.Interval;
import org.joda.time.PeriodType;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date now = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		now = c.getTime();
		//
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			Date spe = dateFormat.parse("2015/03/17 00:00:00");
			String out = DateUtils.humanReadableDuration(spe, now);
			System.out.println(out);
			// // System.out.println(spe.compareTo(now));
			// // Interval inter = new Interval(spe.getTime(), now.getTime());
			// // System.out.println(inter.toDuration());
			// // Duration dur = new Duration(spe.getTime(), now.getTime());
			// long duration = now.getTime() - spe.getTime();
			// duration /= 1000;
			// duration /= 60;
			// duration /= 60;
			// duration /= 24;
			// System.out.println(duration);
			//
			// // dur.plus(Duration.standardDays(dur.getStandardDays()));
			// // System.out.println(dur.getStandardHours() + "hours");
		} catch (ParseException e) {
			// log.error("unknown exception", e);
			e.printStackTrace();
		}

	}

}
