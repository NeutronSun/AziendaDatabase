import java.util.*;
/**
 * Programma in java che simula le funzioni di un ipotetico database di una azienda
 * @author Lorenzo Sanseverino 5DSA
 */
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
			System.out.println("4| Get all workes and all departmentsss");
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
				dataBase.addAffiliation();
				break;

				case 4:
				dataBase.printAllWorkers();
				break;
				
				case 5:
				dataBase.getWorkersAndDays();
				break;

				default:
					System.out.println("Command Not Found");

			}
		}

	}

}
