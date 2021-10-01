import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class aziendona {
	
	ArrayList <Impiegato>worker;
	ArrayList <Dipartimento> department;
	ArrayList project;
	ArrayList <Afferenza> aff;
	ArrayList partecipation;
	
	public aziendona() {
		worker = new ArrayList<Impiegato>();
		department = new ArrayList<Dipartimento>();
		project = new ArrayList<Progetto>();
		aff = new ArrayList<Afferenza>();
		partecipation = new ArrayList<partecipazione>();

	}
	
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
	

	public void addWorker() {
		Scanner in = new Scanner(System.in);
		int x = worker.size();
		System.out.println("pls enter name");
		String a = in.next();
		System.out.println("pls enter salry");
		float y = in.nextFloat();
		worker.add(new Impiegato(x, a, y));
	}
	
	public void addDepartment() {
		if(!areNotAssigned()) {
			System.out.println("there are no workers avaible pls hire some onme");
			return;
		}
		Scanner in = new Scanner(System.in);
		System.out.println("pls enter departen nam");
		String a = in.next();
		System.out.println("Inserire numero dipartimento");
		String b = in.next();
		printNotAssigned();
		System.out.println("Inserire id dipendente");
		int x = in.nextInt();
		department.add(new Dipartimento(a, b, x, (department.size())));
	}
	
	public void addReport(){
		if(!areNotAssigned()) {
			System.out.println("there are no workers avaible pls hire some onme");
			return;
		}
		Scanner in = new Scanner(System.in);
		printNotAssigned();
		System.out.println("Inserire id dipendente");
		int id = in.nextInt();
		for(int i = 0; i < department.size(); i++) 
			System.out.println((i) + "|Nome: " + department.get(i).getName());
		System.out.println("Inserire nome dipartimento");
		int idD = 0;
		while(true){
			idD = in.nextInt();
			if(checkId(idD, 2))
				break;
			System.out.println("Department doesn't exist");
		}
		System.out.println("Inserire data inizio(dd/MM/yyyy)");
		String start = in.next();
		try {
			Date dateS=new SimpleDateFormat("dd/MM/yyyy").parse(start);
			System.out.println("Inserire nome fine(dd/MM/yyyy)");
			String end = in.next();
			Date dateE=new SimpleDateFormat("dd/MM/yyyy").parse(end);
			aff.add(new Afferenza(dateS, dateE, id, idD));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
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
				System.out.println((i) + "|Id:" + worker.get(i).getId() + "|Name:" + worker.get(i).getName());
			}
			isAvailable = true;
		}

	}
	
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

	public boolean isAEmployee(int id){
		for(int i = 0; i < department.size(); i++){
			if(id == department.get(i).getManager())
				return true;
		}
		return false;
	}


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
	
	
	public void getWorkersAndDays() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Scanner in = new Scanner(System.in);
		int idN = 0;
		

		System.out.println("Choose a department");
		for(int i = 0; i < department.size(); i++){
			System.out.println(i + department.get(i).getName());
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
