package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max;

		max = da[0];

		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}

		return max;
	}

	public static double findMin(double[] da) {

		// TODO - START

		double min;

		min = da[0];

		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		return min;

		// TODO - SLUTT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START

		double[] latitudes = new double[gpspoints.length];

		for (int i = 0; i < gpspoints.length; i++) {

			latitudes[i] = gpspoints[i].getLatitude();
		}
		return latitudes;

		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START

		double[] longitudes = new double[gpspoints.length];

		for (int i = 0; i < gpspoints.length; i++) {

			longitudes[i] = gpspoints[i].getLongitude();
		}
		return longitudes;

		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius i meter

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		// TODO - START

		double d, a, c;
		double latitude1, longitude1, latitude2, longitude2;

		latitude1 = toRadians(gpspoint1.getLatitude());
		longitude1 = toRadians(gpspoint1.getLongitude());

		latitude2 = toRadians(gpspoint2.getLatitude());
		longitude2 = toRadians(gpspoint2.getLongitude());

		double latD = latitude2 - latitude1;
		double lonD = longitude2 - longitude1;

		a = Math.pow(Math.sin(latD / 2), 2)
				+ Math.cos(latitude1) * Math.cos(latitude2) * Math.pow(Math.sin(lonD / 2), 2);

		c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		d = R * c;

		return d;

		// TODO - SLUTT
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START

		secs = gpspoint2.getTime() - gpspoint1.getTime();

		double distance = GPSUtils.distance(gpspoint2, gpspoint1);
		speed = (distance / secs) * 3.6;

		return speed;

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START

		int timer, minutter, sekunder;

		timer = secs / 3600;
		minutter = (secs % 3600) / 60;
		sekunder = (secs % 3600) % 60;

		timestr = formatTimeNumber(timer) + TIMESEP + formatTimeNumber(minutter) + TIMESEP + formatTimeNumber(sekunder);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < TEXTWIDTH; i++) {
			sb.append(' ');
		}

		return sb.substring(timestr.length()) + timestr;

		// TODO - SLUTT

	}

	private static int TEXTWIDTH = 10;

	// Gjør tid om til tekst

	public static String formatTimeNumber(int n) {

		String FormatTime;

		if (n < 10) {

			FormatTime = "0" + n;
			return FormatTime;

		} else {

			FormatTime = Integer.toString(n);
			return FormatTime;

		}
	}

	public static String formatDouble(double d) {

		String str;

		// TODO - START

		DecimalFormat df = new DecimalFormat("#.##");

		df.setRoundingMode(RoundingMode.CEILING);
		str = df.format(d);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < TEXTWIDTH; i++) {
			sb.append(' ');
		}

		return sb.substring(str.length()) + str;

		// TODO - SLUTT
	}

}
