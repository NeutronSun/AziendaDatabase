import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
/**
 * Classe Afferenza che gestisce il rapporto lavoratore/dipartimento, memorizzando che lavoratore x ha lavorato in data a-b 
 * per il dipartimento y
 * @author Lorenzo Sanseverino 5DSA
 */ 
public class Afferenza {
	
	/**
	 * data di inzio lavoro
	 */
	private Date dayOne;
	/**
	 * Data di fine del lavoro
	 */
	private Date dayEnd;
	/**
	 * Id del lavoratore
	 */
	private int idWorker;
	/**
	 * Id del dipartimento
	 */
	private int idDeparment;
	
	/**
	 * primo costruttore di default con tutti i parametri per una istanza manuale
	 * @param x
	 * data inzio
	 * @param y
	 * data fine
	 * @param z
	 * id lavoratore
	 * @param xy
	 * id dipartimento
	 */
	public Afferenza(Date x, Date y, int z, int xy) {
		dayOne = x;
		dayEnd = y;
		idWorker = z;
		idDeparment = xy;
	}

	/**
	 * Secondo costruttore in cui e' l'utente ad inserire i vari parametri
	 * @param idD
	 * id dipartimento
	 * @param idW
	 * id lavoratore
	 */
	public Afferenza(int idD, int idW){
		Scanner in = new Scanner(System.in);
		System.out.println("Inserire data inizio(dd/MM/yyyy)");
		String start = in.next();
		try {
			Date dateS=new SimpleDateFormat("dd/MM/yyyy").parse(start);
			System.out.println("Inserire nome fine(dd/MM/yyyy)");
			String end = in.next();
			Date dateE=new SimpleDateFormat("dd/MM/yyyy").parse(end);
			this.dayOne = dateS;
			this.dayEnd = dateE;
			this.idWorker = idW;
			this.idDeparment = idD;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Date getDayOne() {
		return dayOne;
	}


	public void setDayOne(Date dayOne) {
		this.dayOne = dayOne;
	}


	public Date getDayEnd() {
		return dayEnd;
	}


	public void setDayEnd(Date dayEnd) {
		this.dayEnd = dayEnd;
	}


	public int getIdWorker() {
		return idWorker;
	}


	public void setIdWorker(int idWorker) {
		this.idWorker = idWorker;
	}


	public int getIdDeparment() {
		return idDeparment;
	}
	
	
}
