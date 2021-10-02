import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Classe aziendona che gestisce tutte le altre classi(a scopo di memorizzazione dei dati)
 * @author Lorenzo Sanseverino 5DSA
 */
public class aziendona {
	/**
	 * ArrayList contenente tutti i lavorati({@link Impiegato})
	 */
	ArrayList <Impiegato>worker;
	/**
	 * ArrayList contenente tutti i dipartimenti({@link Dipartimento})
	 */
	ArrayList <Dipartimento> department;
	/**
	 * ArrayList contentente tutte le afferenze dei lavorati con uno specifico dipartimento({@link Afferenza})
	 */
	ArrayList <Afferenza> aff;
	

	/**
	 * Costruttore della classe
	 */
	public aziendona() {
		worker = new ArrayList<Impiegato>();
		department = new ArrayList<Dipartimento>();
		aff = new ArrayList<Afferenza>();

	}
	
	/**
	 * Metodo che crea 3 lavorati e 2 dipartimenti(con le afferenze) di default, per una esecuzione piu' semplice
 	 */
	public void setDefault() {
		worker.add(new Impiegato(0,"Mario", 1000));
		worker.add(new Impiegato(1,"Valerio", 2000));
		worker.add(new Impiegato(2,"Edoardo", 3000));
		department.add(new Dipartimento("a1", "3298236955", 1, 0));
		department.add(new Dipartimento("a2", "3298236956", 2, 1));
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			aff.add(new Afferenza(df.parse("01/01/2017"), df.parse("01/09/2021"), 0, 0));
			aff.add(new Afferenza(df.parse("14/02/2016"), df.parse("23/10/2020"), 1, 0));
			aff.add(new Afferenza(df.parse("01/12/2013"), df.parse("27/01/2021"), 2, 1));
		}catch (ParseException e) {e.printStackTrace();}
	}
	
	/**
	 * Metodo che consente l'inserimento di un lavoratore
	 */
	public void addWorker() {
		worker.add(new Impiegato());
	}
	
	/**
	 * Metodo che consente l'inserimento di un dipartimento con relativa afferenza al dipendente/dirigente
	 */
	public void addDepartment() {
		if(!areNotAssigned()) {
			System.out.println("there are no workers avaible pls hire some onme");
			return;
		}
		Scanner in = new Scanner(System.in);
		printNotAssigned();
		System.out.println("Enter id worker");
		int x = in.nextInt();
		department.add(new Dipartimento(x));
		aff.add(new Afferenza(department.size()-1, x));

	}
	

	/**
	 * metodo che afferisce un dipendente ad una relativa azienda
	 */
	public void addReport(){
		if(!areNotAssigned()) {
			System.out.println("there are no workers avaible pls hire some onme");
			return;
		}

		//input dati lavoratore
		Scanner in = new Scanner(System.in);
		printNotAssigned();
		System.out.println("Enter name worker");
		int id = in.nextInt();
		//input dati dipartimento
		for(int i = 0; i < department.size(); i++) 
			department.get(i).print();
		System.out.println("Enter name Department");
		int idD = 0;
		while(true){
			idD = in.nextInt();
			if(checkId(idD, 2))
				break;
			System.out.println("Department doesn't exist");
		}
		//costruttore afferenza
		aff.add(new Afferenza(idD, id));

	}
	
	/**
	 * stampa tutti i lavorati che non sono stati ancora assegnati ad un dipartimento(non afferiti)
	 */
	public void printNotAssigned() {
		boolean isAvailable = true;
		for(int i = 0; i < worker.size(); i++) {
			for(int j = 0; j < aff.size(); j++) {
				if(worker.get(i).getId() == aff.get(j).getIdWorker())
				isAvailable = false;
			}
			for(int j = 0; j < department.size(); j++){
				if(worker.get(i).getId() == department.get(j).getManager())
				isAvailable = false;
			}
			if(isAvailable) {
				worker.get(i).print();
			}
			isAvailable = true;
		}

	}
	
	/**
	 * metodo che scorre {@link aziendona#worker}
	 * @return
	 * true se c'e' almeno un lavore disponibile, falso nel caso contrario
	 * 
	 */
	public boolean areNotAssigned(){
		boolean isAvailable = true;
		for(int i = 0; i < worker.size(); i++) {
			for(int j = 0; j < aff.size(); j++) {
				if(worker.get(i).getId() == aff.get(j).getIdWorker())
				isAvailable = false;
			}
			for(int j = 0; j < department.size(); j++){
				if(worker.get(i).getId() == department.get(j).getManager())
				isAvailable = false;
			}
			if(isAvailable)
				return true;
			
			isAvailable = true;
		}
		return false;
	}

	/**
	 * Metodo che stampa tutti i lavorati, per quale dipartimento lavorano e per quale dipartimento
	 */
	public void printAllWorkers(){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for(int i = 0; i < aff.size(); i++) {
			System.out.print(worker.get(aff.get(i).getIdWorker()).getName() + "("+ aff.get(i).getIdWorker() +") has been working since " + df.format(aff.get(i).getDayOne()) + " as");
			if(isAEmployee(i))
				System.out.print(" a manager");
			else
				System.out.print(" a slave");
			
			System.out.println(" for " + department.get(aff.get(i).getIdDeparment()).getName() + " department");
		}
	}

	/**
	 * Metodo che ti dice se un i-esimo lavoratore e' un impiegato o un dirigente
	 * @param id
	 * id del lavoratore
	 * @return
	 * true se il lavoratore e' un dirigente, false se non lo e'
	 */
	public boolean isAEmployee(int id){
		for(int i = 0; i < department.size(); i++){
			if(id == department.get(i).getManager())
				return true;
		}
		return false;
	}

	/**
	 * Controlla se l'id inserito e' presente in {@link aziendona#worker} o {@link aziendona#department}
	 * @param id
	 * id da controllare
	 * @param cs
	 * il caso, ossia in quale arraylist controllare 1:{@link aziendona#worker}| 2:{@link aziendona#department}
	 * @return
	 * true se l'id e' presente, false se non lo e'
	 */
	public boolean checkId(int id, int cs){
		switch(cs){
			
			case 1:
				for(int i = 0; i < aff.size(); i++){
					if(id == aff.get(i).getIdWorker())
					return true;
				}
				return false;

			case 2:
				for(int i = 0; i < department.size(); i++){
					if(id == department.get(i).getIdDeparment())
					return true;
				}
				return false;
		}
		return true;
	}
	
	/**
	 * metodo che stampa tutti i lavoratori che hanno lavorato in una specifica data in uno specifico dipartimento
	 */
	public void getWorkersAndDays() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Scanner in = new Scanner(System.in);
		int idN = 0;
		

		System.out.println("Choose a department");
		for(int i = 0; i < department.size(); i++){
			department.get(i).print();
		}
		
		while(true){
			idN = in.nextInt();
			if(checkId(idN, 2))
				break;
			System.out.println("Department doesn't exist");
		}

		System.out.println("Enter the date(dd/MM/yyyy)");
		String start = in.next();
		int cont = 0;
		try {
			Date dateS=df.parse(start);
			for(int i  = 0; i < aff.size(); i++){
				if((/*contition 1*/ aff.get(i).getDayOne().getTime() - dateS.getTime()) < 0 
				&& (/*contition 2*/aff.get(i).getDayEnd().getTime() - dateS.getTime()) > 0 
				&& /*contition 3*/department.get(idN).getName().equals(department.get(aff.get(i).getIdDeparment()).getName())){

				System.out.println(worker.get(aff.get(i).getIdWorker()).getName() + " has worked in this day.");
				cont++;
				}
			}
			if(cont == 0)
			System.out.println("Nobody has worked in this day...Hire better workes man");
		}catch (ParseException e){}
		
		
	}


	
}
