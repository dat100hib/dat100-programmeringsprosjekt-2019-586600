package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;

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

		double min;

		// TODO - START
		
		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		return min;

		// throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		
		double[] latitudes = new double [gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		
		return latitudes;
		
		// throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START
		
		double[] longitudes = new double [gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		
		return longitudes;

		// throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {
	
		double latitude1 = gpspoint1.getLatitude();
		double longitude1 = gpspoint1.getLongitude();
		
		double latitude2 = gpspoint2.getLatitude();
		double longitude2 = gpspoint2.getLongitude();
		

			double a, c, d;

			// TODO - START
			
			double bredde1, bredde2, lengde1, lengde2, deltabredde, deltalengde;
			final double R = 6371000;
			
			bredde1 = toRadians(latitude1); 
			bredde2 = toRadians(latitude2);
			lengde1 = toRadians (longitude1);
			lengde2 = toRadians (longitude2);
			
			deltabredde = bredde2 - bredde1;
			deltalengde = lengde2 - lengde1;
			
			a = pow(sin(deltabredde/2), 2) + cos(bredde1) * cos(bredde2) * pow(sin(deltalengde/2), 2);
			
			c = 2 * atan2(sqrt(a), sqrt(1-a));
			
			d = R * c;
			
			return d;

			// TODO - SLUTT

	}


	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START

		secs = gpspoint2.getTime() - gpspoint1.getTime();

		// m/s
		speed = distance(gpspoint1, gpspoint2) / secs;

		// km/t
		speed = (speed * 60 * 60) / 1000;

		// TODO - SLUTT

		return speed;
	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START
		
		int hours = secs /3600;
		int reminder = secs % 3600;
		int minutes = reminder / 60;
		int seconds = (reminder % 60);
		//int remainingSecs = secs % 60 % 60;
		
		String hh = (hours < 10 ? "0" : "") + hours;
		String mm= (minutes <10 ? "0" : "") + minutes;
		String ss = (seconds < 10 ? "0" : "") + seconds;
		timestr = "  " +  hh + TIMESEP  + mm + TIMESEP + ss;
		
		//System.out.println(hours + " " + min + " " + remainingSecs );
		
		return timestr;
		
		// throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str = "";

		// TODO - START
		String strtemp = String.format("%.2f", d);
		
		for (int i = 0; i < 10 - strtemp.length(); i++) {
			str = str + " ";
		} 
		
		return str;

		// TODO - SLUTT
		
	}
}
