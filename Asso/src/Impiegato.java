public class Impiegato {
	
	private int id;
	private String name;	
	private float salary;
	
	public Impiegato(int x, String a, float y) {
		id = x;
		name = a;
		salary = y;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	void print() {
		System.out.println(id);
	}
	
}
