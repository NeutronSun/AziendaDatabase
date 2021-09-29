public class Dipartimento {
	
	private String name;
	private String teleNumber;
	private int manager;
	
	
	public Dipartimento(String a, String b, int x) {
		name = a;
		teleNumber = b;
		manager = x;
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
	
}



