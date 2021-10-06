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
	ArrayList <Impiegato>listWorker;
	/**
	 * ArrayList contenente tutti i dipartimenti({@link Dipartimento})
	 */
	ArrayList <Dipartimento> listDepartment;
	/**
	 * ArrayList contentente tutte le afferenze dei lavorati con uno specifico dipartimento({@link Afferenza})
	 */
	ArrayList <Afferenza> listAff;
	

	/**
	 * Costruttore della classe
	 */
	public aziendona() {
		listWorker = new ArrayList<Impiegato>();
		listDepartment = new ArrayList<Dipartimento>();
		listAff = new ArrayList<Afferenza>();
	}
	
	/**
	 * Metodo che crea 3 lavorati e 2 dipartimenti(con le afferenze) di default, per una esecuzione piu' semplice
 	 */
	public void setDefault() {
		listWorker.add(new Impiegato(0,"Mario", 1000));
		listWorker.add(new Impiegato(1,"Valerio", 2000));
		listWorker.add(new Impiegato(2,"Edoardo", 3000));
		listDepartment.add(new Dipartimento("a1", "3298236955", 1, 0));
		listDepartment.add(new Dipartimento("a2", "3298236956", 2, 1));
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			listAff.add(new Afferenza(df.parse("01/01/2017"), df.parse("01/09/2021"), 0, 0));
			listAff.add(new Afferenza(df.parse("14/02/2016"), df.parse("23/10/2020"), 1, 0));
			listAff.add(new Afferenza(df.parse("01/12/2013"), df.parse("27/01/2021"), 2, 1));
		}catch (ParseException e) {e.printStackTrace();}
	}
	
	/**
	 * Metodo che consente l'inserimento di un lavoratore
	 */
	public void addWorker() {
		System.out.println("---------------------");
		listWorker.add(new Impiegato());
		System.out.println("---------------------");
	}
	
	/**
	 * Metodo che consente l'inserimento di un dipartimento con relativa afferenza al dipendente/dirigente
	 */
	public void addDepartment() {
		if(!areNotAssigned()) {
			System.out.println("there are no workers avaible");
			return;
		}
		System.out.println("---------------------");
		Scanner in = new Scanner(System.in);
		printNotAssigned();
		System.out.println("Enter id worker(manager)");
		int x = in.nextInt();
		System.out.println("---------------------");
		listDepartment.add(new Dipartimento(x));
		System.out.println("---------------------\nAdd the Affilation");
		listAff.add(new Afferenza(listDepartment.size()-1, x));

	}
	

	/**
	 * metodo che afferisce un dipendente ad una relativa azienda
	 */
	public void addAffiliation(){
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
		for(Dipartimento dep : listDepartment) 
			dep.print();
		System.out.println("Enter name Department");
		int idD = 0;
		while(true){
			idD = in.nextInt();
			if(checkId(idD, 2))
				break;
			System.out.println("Department doesn't exist");
		}
		//costruttore afferenza
		listAff.add(new Afferenza(idD, id));

	}
	
	/**
	 * stampa tutti i lavorati che non sono stati ancora assegnati ad un dipartimento(non afferiti)
	 */
	public void printNotAssigned() {
		boolean isAvailable = true;
		for(Impiegato wk : listWorker) {	
			for(Afferenza af : listAff) {
				if(wk.getId() == af.getIdWorker())
				isAvailable = false;
			}
			for(Dipartimento dep : listDepartment){
				if(wk.getId() == dep.getManager())
				isAvailable = false;
			}
			if(isAvailable) 
				wk.print();

			isAvailable = true;
		}

	}
	
	/**
	 * metodo che scorre {@link aziendona#listWorker}
	 * @return
	 * true se c'e' almeno un lavore disponibile, falso nel caso contrario
	 * 
	 */
	public boolean areNotAssigned(){
		boolean isAvailable = true;
		for(Impiegato wk : listWorker) {							
			for(Afferenza af : listAff) {
				if(wk.getId() == af.getIdWorker())
					isAvailable = false;
			}
			for(Dipartimento dep : listDepartment){
				if(wk.getId() == dep.getManager())
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
	 * e tutt i dipartimenti con i rispettivi dati
	 */
	public void printAllWorkers(){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for(Afferenza af : listAff) {
			System.out.print(listWorker.get(af.getIdWorker()).getName() + "("+ af.getIdWorker() +") has been working since " + df.format(af.getDayOne()) + " as");
			if(isAEmployee(af.getIdWorker()))
				System.out.print(" a manager");
			else
				System.out.print(" a worker");
			
			System.out.println(" for " + listDepartment.get(af.getIdDeparment()).getName() + " listDepartment");
		}

		System.out.println("------------------------------------------");
		for(Dipartimento dep : listDepartment)
			dep.print();
		System.out.println("");
	}

	/**
	 * Metodo che ti dice se un i-esimo lavoratore e' un impiegato o un dirigente
	 * @param id
	 * id del lavoratore
	 * @return
	 * true se il lavoratore e' un dirigente, false se non lo e'
	 */
	public boolean isAEmployee(int id){
		for(Dipartimento dep : listDepartment){
			if(id == dep.getManager())
				return true;
		}
		return false;
	}

	/**
	 * Controlla se l'id inserito e' presente in {@link aziendona#listWorker} o {@link aziendona#listDepartment}
	 * @param id
	 * id da controllare
	 * @param cs
	 * il caso, ossia in quale arraylist controllare 1:{@link aziendona#listWorker}| 2:{@link aziendona#listDepartment}
	 * @return
	 * true se l'id e' presente, false se non lo e'
	 */
	public boolean checkId(int id, int cs){
		switch(cs){
			
			case 1:
				for(Afferenza af : listAff){
					if(id == af.getIdWorker())
					return true;
				}
				return false;

			case 2:
				for(Dipartimento dep : listDepartment){
					if(id == dep.getIdDeparment())
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
		for(Dipartimento dep : listDepartment)
			dep.print();
		
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
			for(Afferenza af : listAff){
				if((/*contition 1*/ af.getDayOne().getTime() - dateS.getTime()) < 0 
				&& (/*contition 2*/af.getDayEnd().getTime() - dateS.getTime()) > 0 
				&& /*contition 3*/listDepartment.get(idN).getName().equals(listDepartment.get(af.getIdDeparment()).getName())){

				System.out.println(listWorker.get(af.getIdWorker()).getName() + " has worked in this day.");
				cont++;
				}
			}
			if(cont == 0)
			System.out.println("Nobody has worked in this day");
		}catch (ParseException e){}
		
		
	}


	
}
