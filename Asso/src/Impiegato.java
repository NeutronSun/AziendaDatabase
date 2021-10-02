import java.util.Scanner;

/**
 * Classe impiegato che gestisce la memorizzazione dei dati di un singolo impiegato 
 * @author Lorenzo Sanseverino 5DSA
 */
public class Impiegato {
	
	/**
	 * id del lavoratore
	 */
	private int id;
	/**
	 * nome del lavoratore
	 */
	private String name;
	/**
	 * salario del lavoratore  
	 */	
	private float salary;
	/**
	 * contatore staico che ogni volta che viene istanziata la classe aumenta di 1
	 */
	private static int cont = 0;
	
	{cont++;}

	/**
	 * Costruttore di default 
	 * @param x
	 * id lavoratore
	 * @param a
	 * nome lavoratore
	 * @param y
	 * salario del lavoratore
	 */
	public Impiegato(int x, String a, float y) {
		id = x;
		name = a;
		salary = y;
	}

	/**
	 * Costruttore in cui l'utente seleziona i dati dell'impiegato
	 */
	public Impiegato(){
		Scanner in = new Scanner(System.in);
		this.id = (cont-1);
		System.out.println("pls enter name");
		this.name = in.next();
		System.out.println("pls enter salry");
		this.salary = in.nextFloat();
	}

	/**
	 * stampa tutti i dati dell'impiegato
	 */
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
