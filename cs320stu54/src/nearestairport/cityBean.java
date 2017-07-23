package nearestairport;

public class cityBean {

	
	int zip;
	String city;
	String state;
	double longitude;
	double latitude;
	int timezone;
	int dst;
	public cityBean(int zip,String city,String state,double longitude,double latitude,int timezone,int dst)
	{
		this.zip=zip;
		this.city=city;
		this.state=state;
		this.longitude=longitude;
		this.latitude=latitude;
		this.timezone=timezone;
		this.dst=dst;
	}
	
	public cityBean(int zip,String city,double longitude,double latitude)
	{
		this.zip=zip;
		this.city=city;
		this.latitude=latitude;
		this.longitude=longitude;
	}
	public int getZip() {
		return zip;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public double getLongitude() {
		return longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public int getTimezone() {
		return timezone;
	}
	public int getDst() {
		return dst;
	}


}
