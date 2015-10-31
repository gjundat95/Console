package GameConsole;

import java.util.Scanner;

public class Main {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		Map map = new Map();
		Player player = new Player();
		System.out.println("Bạn Đã Vào Rừng :D");
		player.GoMap(map.getMonster());

	}
}

