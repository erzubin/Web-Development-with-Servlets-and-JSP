package nearestairport;

public class airportBean {

	String airport;
	double latitude;
	double longitude;
	public airportBean(String airport,double latitude,double longitude)
	{
		this.airport=airport;
		this.latitude=latitude;
		this.longitude=longitude;
	}
	public String getAirport() {
		return airport;
	}
	public double getLatitude() {
		return latitude;
	}
	public double getLongitude() {
		return longitude;
	}

}
