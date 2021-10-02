import java.util.Scanner;

public class Dipartimento {
	
	private String name;
	private String teleNumber;
	private int manager;
	private int idDeparment;
	private static int cont = 0;

	{cont++;}
	
	public Dipartimento(String a, String b, int x, int y) {
		name = a;
		teleNumber = b;
		manager = x;
		idDeparment = y;
	}

	public Dipartimento(int idW){
		Scanner in = new Scanner(System.in);
		System.out.println("pls enter departen nam");
		String a = in.next();
		System.out.println("Inserire numero dipartimento");
		String b = in.next();
		this.name = a;
		this.teleNumber = b;
		this.manager = idW;
		this.idDeparment = (cont - 1);
	}


	public void print(){
		System.out.println("Id: " + idDeparment + " |name: " + name + " |tele: " + teleNumber);
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



