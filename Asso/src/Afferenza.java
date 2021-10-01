import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;

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
