package imed;

public enum Drivers {

	SQLITE("jdbc:sqlite:"),
	MYSQL("");
	
	private String driverName;
	
	private Drivers(String driverName) {
		
		this.driverName = driverName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
}
