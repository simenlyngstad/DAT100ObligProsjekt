package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {
		this.gpspoints = new GPSPoint[n];
		this.antall = 0;
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {
		
		if(antall < gpspoints.length) {
			return false;
		}
		gpspoints[antall] = gpspoint;
		antall++;
		return true;
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {
		GPSPoint gpspoint;
		gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
		boolean innSetting = insertGPS(gpspoint);
		
		return innSetting;
		
	}
	
	
	public void print() {
		
		System.out.println("====== Konvertert GPS Data - START ======");
		
		// TODO - START
		for (GPSPoint a : gpspoints) {
			System.out.println(a.toString());
		}
		
		
		// TODO - SLUTT
		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
