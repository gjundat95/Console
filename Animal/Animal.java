package Animal;

public abstract class Animal 
{
	private double weight;
	private double height;
	private String kind;
	private String name;
	
	// Van co the khoi tao duoc neu biet dung
	public Animal(double weight, double height, String kind, String name) {
		super();
		this.weight = weight;
		this.height = height;
		this.kind = kind;
		this.name = name;
	}
	// Dung ham khoi tao mot doi tuong ma khong muon truyen bien vao cho doi tuong do
	public Animal()
	{
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	// Phuong thuc hien thi
	public void printAnimal() 
	{
		
		
	}
	
}
