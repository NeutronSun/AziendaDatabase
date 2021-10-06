import java.util.Scanner;
/**
 * Classe dipartimento che gestisce tutti i dati relativi ad un singolo dipartimento
 * @author Lorenzo Sanseverino 5DSA
 */
public class Dipartimento {
	/**
	 * nome del dipartimento
	 */
	private String name;
	/**
	 * numero di telefono del dipartimento
	 */
	private String teleNumber;
	/**
	 * id del manager di quel dipartimento
	 */
	private int manager;
	/**
	 * id del dipartimento
	 */
	private int idDeparment;
	/**
	 * contatore statico che si incrementa ad ogni istanzazione della classe
	 */
	private static int cont = 0;

	{cont++;}
	

	/**
	 * costruttore con valori di default della classe
	 * @param a
	 * nome diparimento
	 * @param b
	 * numero di telefono
	 * @param x
	 * id del manager
	 * @param y
	 * id dipartimento
	 */
	public Dipartimento(String a, String b, int x, int y) {
		name = a;
		teleNumber = b;
		manager = x;
		idDeparment = y;
	}


	/**
	 * Costruttore in cui l'utente dalla classe {@link aziendona} seleziona il dirigente del dipartimento e lo passa come parametro
	 * @param idW
	 * id del lavoratores
	 */
	public Dipartimento(int idW){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter name department");
		String a = in.next();
		String b = "";
		do{
			System.out.println("Enter telenumber department(10 digits)");
			b = in.next();
		}while(b.length() != 10);
		this.name = a;
		this.teleNumber = b;
		this.manager = idW;
		this.idDeparment = (cont - 1);
	}

	/**
	 * stampa tutti i dati del dipartimento
	 */
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



