package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;


public class GPSDataConverter {


	public static int toSeconds(String timestr) {
		
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

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;

		// TODO - START ;
		int time = toSeconds(timeStr);
		double latitude = Double.parseDouble(latitudeStr);
		double longitude = Double.parseDouble(longitudeStr);
		double elevation = Double.parseDouble(elevationStr);
		
		gpspoint = new GPSPoint(time, latitude, longitude, elevation);
		
		return gpspoint;
		

		// OPPGAVE - SLUTT ;
	    
	}
	
}
