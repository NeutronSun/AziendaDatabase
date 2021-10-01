public class Dipartimento {
	
	private String name;
	private String teleNumber;
	private int manager;
	private int idDeparment;
	
	
	public Dipartimento(String a, String b, int x, int y) {
		name = a;
		teleNumber = b;
		manager = x;
		idDeparment = y;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTeleNumber() {
		return teleNumber;
	}


	public void setTeleNumber(String teleNumber) {
		this.teleNumber = teleNumber;
	}

	public void setManager(int manager){
		this.manager = manager;
	}

	public int getManager() {
		return manager;
	}

	public int getIdDeparment() {
		return idDeparment;
	}
	
}



