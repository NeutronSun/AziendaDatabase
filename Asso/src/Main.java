import java.util.*;
public class Main {

	public static void main(String[] args) {
		int n;
		Scanner in = new Scanner(System.in);
		aziendona smurfing = new aziendona();
		smurfing.setDefault();
		while(true) {
			System.out.println("1| Add worker");
			System.out.println("2| Add department");
			System.out.println("3| Add affilation");
			System.out.println("4| Get all workes");
			System.out.println("5| Get workers who works at least n days");
			n = in.nextInt();
			switch(n){

				case 1:
				smurfing.addWorker();
				break;

				case 2:
				smurfing.addDepartment();
				break;

				case 3:
				smurfing.addReport();
				break;

				case 4:
				smurfing.getAllWorkers();
				break;
				
				case 5:
				smurfing.getWorkersAndDays();
				break;

			}
		}

	}

}
