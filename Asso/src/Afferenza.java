import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Afferenza {
	
	private Date dayOne;
	private Date dayEnd;
	private int idWorker;
	private int idDeparment;
	
	
	public Afferenza(Date x, Date y, int z, int xy) {
		dayOne = x;
		dayEnd = y;
		idWorker = z;
		idDeparment = xy;
	}


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
