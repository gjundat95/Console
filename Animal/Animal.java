package Animal;

public abstract class Animal 
{
	private double weight;
	private double height;
	private String kind;
	private String name;
	
	public Animal(double weight, double height, String kind, String name) {
		super();
		this.weight = weight;
		this.height = height;
		this.kind = kind;
		this.name = name;
	}
	
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

	public void printAnimal() 
	{
		
		
	}
	
}
