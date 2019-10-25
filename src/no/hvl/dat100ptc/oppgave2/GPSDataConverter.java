package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;


public class GPSDataConverter {


	private static int toSeconds(String timestr) {
		
		int secs;
		int hr, min, sec;
		
		// TODO
		// OPPGAVE - START
		
		hr = Integer.parseInt(timestr.substring(12, 13));
		min = Integer.parseInt(timestr.substring(15, 16));
		sec = Integer.parseInt(timestr.substring(18, 19));
	
		secs = sec + min * 60 + hr * 60 * 60;
		
		return secs;

		// OPPGAVE - SLUTT
		
	}

	public static GPSPoint convert(int[] time2, double[] latitude2, double[] longitude2, double[] elevation2) {

		GPSPoint gpspoint;

		// TODO - START ;
		int time = toSeconds(time2);
		double latitude = Double.parseDouble(latitude2);
		double longitude = Double.parseDouble(longitude2);
		double elevation = Double.parseDouble(elevation2);
		
		gpspoint = new GPSPoint(time, latitude, longitude, elevation);
		
		return gpspoint;
		

		// OPPGAVE - SLUTT ;
	    
	}
	
}
