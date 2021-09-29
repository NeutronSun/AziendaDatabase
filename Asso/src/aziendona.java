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


		worker.add(new Impiegato(0,"Mario", 1000));
		worker.add(new Impiegato(1,"Valerio", 2000));
		worker.add(new Impiegato(2,"Edoardo", 3000));
		department.add(new Dipartimento("a1", "3298236955", 1));
		department.add(new Dipartimento("a2", "3298236956", 2));
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			aff.add(new Afferenza(df.parse("01/01/2017"), df.parse("01/09/2021"), 0, "a1"));
			aff.add(new Afferenza(df.parse("14/02/2016"), df.parse("23/10/2020"), 1, "a1"));
			aff.add(new Afferenza(df.parse("01/12/2013"), df.parse("27/01/2021"), 2, "a2"));
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
		Scanner in = new Scanner(System.in);
		System.out.println("pls enter departen nam");
		String a = in.next();
		System.out.println("Inserire numero dipartimento");
		String b = in.next();
		getAvaible();
		System.out.println("Inserire id dipendente");
		int x = in.nextInt();
		department.add(new Dipartimento(a, b, x));
	}
	
	public void addReport(){
		Scanner in = new Scanner(System.in);
		getAvaible();
		System.out.println("Inserire id dipendente");
		int x = in.nextInt();
		for(int i = 0; i < department.size(); i++) 
			System.out.println((i) + "|Nome: " + department.get(i).getName());
		System.out.println("Inserire nome dipartimento");
		String a = in.next();
		System.out.println("Inserire data inizio(dd/MM/yyyy)");
		String start = in.next();
		try {
			Date dateS=new SimpleDateFormat("dd/MM/yyyy").parse(start);
			System.out.println("Inserire nome fine(dd/MM/yyyy)");
			String end = in.next();
			Date dateE=new SimpleDateFormat("dd/MM/yyyy").parse(end);
			aff.add(new Afferenza(dateS, dateE, x, a));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public void getAvaible() {
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

	public void getAllWorkers(){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for(int i = 0; i < aff.size(); i++) {
			System.out.print(worker.get(aff.get(i).getIdWorker()).getName() + " has been working since " + df.format(aff.get(i).getDayOne()) + " as");
			if(isAEmployee(i))
				System.out.println(" a manager");
			else
				System.out.println(" a worker");
		}
	}

	public boolean isAEmployee(int id){
		for(int i = 0; i < department.size(); i++){
			if(id == department.get(i).getManager())
				return true;
		}
		return false;
	}


	
}
