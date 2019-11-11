package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSComputer {

	private GPSPoint[] gpspoints;
	
public GPSComputer(String filename) {
	
		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

public GPSComputer(GPSPoint[] gpspoints) {
	this.gpspoints = gpspoints;
}
// tabeller for GPS datapunkter
public int[] time;
public double[] latitude;
public double[] longitude;
public double elevation;

// beregn total distances (i meter)
public double totalDistance() {

	double distance = 0;

	// TODO
	// OPPGAVE - START
	
	for (int i = 0; i < gpspoints.length - 1; i++) {
		distance += GPSUtils.distance(gpspoints[i], gpspoints[i+1]);
	}
	
	// OPPGAVE - SLUTT

	return distance;
}



// beregn totale høydemeter (i meter)
public double totalElevation() {

	double elevation = 0;

	// TODO
	// OPPGAVE - START
	/*
	for (int i = 1; i < elevation.length; i++) {
		if (elevation[i] > elevation [i -1]) {
			elevation = elevation[i] - elevation [i-1];
		}
	}
*/
	// OPPGAVE - SLUTT
	return elevation;
}


// beregn total tiden for hele turen (i sekunder)
public int totalTime() {
	
	int totaltime = 0;
	
	// TODO 
	// OPPGAVE START
	
	totaltime = time[time.length - 1] - time[0];
	
	// OPPGAVE SLUTT
	
	return totaltime;
}


// beregn gjennomsnitshastighets mellom hver av gps punktene
public double[] speeds() {

	double[] speeds = new double[gpspoints.length-1];
	
	// TODO
	// OPPGAVE - START
	
	for (int i =0; i < gpspoints.length -1; i++) {
		speeds[i] = GPSUtils.speed(gpspoints[i],gpspoints[i+1]);
	}
	
	// OPPGAVE - SLUTT
	return speeds;
}


// beregn maximum hastighet km/t
public double maxSpeed() {
	
	double maxspeed = 0;
	
	// TODO
	// OPPGAVE - START
	
	double [] speed2 = speeds();
	for (int i = 0; i < speed2.length -1; i++) {
		if(maxspeed < speed2[i]) {
			maxspeed = speed2[i];
		}
		
	}
			
	// OPPGAVE - SLUTT
	
	return maxspeed;
}


// beregn gjennomsnittshasitiget for hele turen km/t
public double averageSpeed() {

	double average = 0;
	
	// TODO
	// OPPGAVE - START
	
	average = totalDistance()/ totalTime()*3.6;
			
	// OPPGAVE - SLUTT
	
	return average;
}


// conversion factor kph (km/t) to miles per hour (mph)
public static double MS = 0.62;

// beregn kcal gitt weight og tid der kjøres med en gitt hastighet
public double kcal(double weight, int secs, double speed) {

	double kcal = 0;

	// MET: Metabolic equivalent of task angir (kcal x kg-1 x h-1)
	double met = 0;		
	double speedmph = speed * MS;
	
	if (speedmph < 10 )
		met = 4;
		else if (speedmph <=12)
		met = 6;
		else if (speedmph <=14)
			met = 8;
		else if (speedmph <=15)
			met = 10;
		else if (speedmph <=20)
			met = 12;
		else if (speedmph > 20)
			met = 16;
	

	// TODO
	// OPPGAVE START
	
	kcal = met * weight * secs / 3600; 
	
	
	// Energy Expended (kcal) = MET x Body Weight (kg) x Time (h)

	// OPPGAVE SLUTT
	
	return kcal;
}

public double totalKcal(double weight) {

	double totalkcal = 0;
	double [] speeds3= speeds();

	// TODO
	// OPPGAVE - START 
	for (int i = 0; i < speeds3.length - 1; i++){
		totalkcal += kcal(weight, time[i + 1] - time[i], speeds3[i]);
		
		
	}
	
	// Hint: hent hastigheter i speeds tabellen og tider i timestabellen
	// disse er definer i toppen av klassen og lese automatisk inn
	
	// OPPGAVE - SLUTT
	
	return totalkcal;
}

private static double WEIGHT = 80.0;

	// skriv ut statistikk for turen
public void displayStatistics() {
	
	// TODO
	// OPPGAVE - START
			
	System.out.println("Total Time\t: " + GPSUtils.formatTime(totalTime()));
	System.out.printf("Total Distance\t: %.2f\n", totalDistance());
	System.out.printf("Total Elevation\t: %.2f\n", totalElevation());
	System.out.printf("Max Speed\t: %.2f\n", maxSpeed());
	System.out.printf("Average speed\t: %.2f\n", averageSpeed());
	System.out.printf("Total Kcal\t: %.2f \n", totalKcal(WEIGHT));
	// OPPGAVE - SLUT
	}
}
