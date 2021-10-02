import java.util.Scanner;

/**
 * Classe aziendona che gestisce tutte le altre classi(a scopo di memorizzazione dei dati)
 * @author Lorenzo Sanseverino 5DSA
 */
public class Impiegato {
	
	private int id;
	private String name;	
	private float salary;
	private static int cont = 0;
	
	{cont++;}
	public Impiegato(int x, String a, float y) {
		id = x;
		name = a;
		salary = y;
	}

	public Impiegato(){
		Scanner in = new Scanner(System.in);
		this.id = (cont-1);
		System.out.println("pls enter name");
		this.name = in.next();
		System.out.println("pls enter salry");
		this.salary = in.nextFloat();
	}


	public void print(){
		System.out.println("Id: " + id + " Name: " + name + " salary: " + salary);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
}
