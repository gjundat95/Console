package GameConsole;

import java.util.ArrayList;
import java.util.Random;

public class Map 
{
	public ArrayList<Monsters> listMonster = new ArrayList<Monsters>();
	
	/*
	 * Khởi tạo quái và lưu vào trong listMonsters
	 */
	public Map()
	{
		Bird bird = new Bird();
		Lion lion = new Lion();
		Turtle turtle = new Turtle();
		
		listMonster.add(bird);
		listMonster.add(lion);
		listMonster.add(turtle);
	}
	
	/*
	 * Lấy ngẫu nhiên một con quái vất trong listMonsters
	 */
	public Monsters getMonster()
	{
		int rd = rand(0,2);
		return listMonster.get(rd);
	}
	
	/*
	 * Hàm random, trả lại kiểu int
	 */
	private int rand(int min, int max)
	{
		Random rand = new Random();
		int range = max - min +1;
		int randomNum = min + rand.nextInt(range);
		return randomNum;
		
	}
}
