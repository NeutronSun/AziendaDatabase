import java.util.*;
public class Main {

	public static void main(String[] args) {
		int n;
		Scanner in = new Scanner(System.in);
		aziendona dataBase = new aziendona();
		dataBase.setDefault();
		while(true) {
			System.out.println("1| Add worker");
			System.out.println("2| Add department");
			System.out.println("3| Add affilation");
			System.out.println("4| Get all workes");
			System.out.println("5| Get workers who works in a specific day");
			n = in.nextInt();
			switch(n){

				case 1:
				dataBase.addWorker();
				break;

				case 2:
				dataBase.addDepartment();
				break;

				case 3:
				dataBase.addReport();
				break;

				case 4:
				dataBase.printAllWorkers();
				break;
				
				case 5:
				dataBase.getWorkersAndDays();
				break;

				default:
					System.out.println("error 404");

			}
		}

	}

}
