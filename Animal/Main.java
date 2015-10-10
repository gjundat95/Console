package Animal;


public class Main {
	
	public static void main(String[] args)
	{
		Dog dog = new Dog();
		Animal cat1 = new Cat();
		Animal dog1 = new Dog();
		
		if(cat1 instanceof Cat)
		{
			System.out.println("Đây là một con mèo.");
			
			((Cat) cat1).inputCat();
			cat1.printAnimal();
		}
		else
		{
			System.out.println("Day khong phai la con meo.");
		}
		
		if(dog1 instanceof Cat)
		{
			System.out.println("Day khong phai la con meo.");
		}
		else
		{
			System.out.println("Đây là một con chó.");
			dog = (Dog)dog1;
			dog.inputDog();
			dog.printAnimal();
		}
	}

}
