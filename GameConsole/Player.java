package GameConsole;

public class Player 
{
	public String name;
	public int dame;
	public int health;
	public int run;
	public int level;
	
	// Khởi Tạo Player
	public Player()
	{
		name= "Knight";
		dame = 10;
		health = 20;
		run = 3;
		level = 0;
	}
	
	
	// Player đánh nhau
	public void GoMap(Monsters mon)
	{
		// Khi người chạy chậm hơn quái
		if(run < mon.run)
		{
			// Trả lời câu hỏi
			do{
				// Trả lời đúng thì đánh quái
				if(Quick.Answer())
				{
					// Danh quai
					mon.health = mon.health -dame;
					// Hien thong tin
					System.out.println("Mau nguoi: "+health);
					System.out.println("Ten Quai: "+mon.name+" ---Mau Quai: "+mon.health);
					if(mon.health <=0 )
					{
						System.out.println(mon.name+" đã bị người giết.");
						level++;
						break;
					}
				}else // Trả lời sai thì bị quái đánh
				{
					// Danh nguoi 
					health = health -mon.dame;
					// Hien thong tin
					System.out.println("Mau nguoi: "+health);
					System.out.println("Ten Quai: "+mon.name+" ---Mau Quai: "+mon.health);
					if(health <=0)
					{
						System.out.println("Người đã bị "+mon.name+" giết.");
						break;
					}
				}
				
			}while(health >= 0 || mon.health >=  0);
			
		}
		else // Người Chạy Nhanh hơn quái
		{
				if(mon.dame > health) // Gặp con dame khỏe chạy mất dép
				{
					do{
						
						if(Quick.Answer())
						{
							System.out.println("Chạy thoát khỏi Turtle :D");
							break;
						}else
						{
							// Danh nguoi 
							health = health -mon.dame;
							// Hien thong tin
							System.out.println("Mau nguoi: "+health);
							System.out.println("Ten Quai: "+mon.name+" ---Mau Quai: "+mon.health);
							if(health <=0)
							{
								System.out.println("Người đã bị: "+mon.name+" giết.");
								break;
							}
						}
						
					}while(health >= 0 || mon.health >=  0);
				}
				else // Gặp Con dame yếu thì chiến
				{
					do{
						
						if(Quick.Answer())
						{
							// Danh quai
							mon.health = mon.health -dame;
							// Hien thong tin
							System.out.println("Mau nguoi: "+health);
							System.out.println("Ten Quai: "+mon.name+" ---Mau Quai: "+mon.health);
							if(mon.health <=0 )
							{
								System.out.println(mon.name+" đã bị người giết.");
								level++;
								break;
							}
						}else
						{
							// Danh nguoi 
							health = health -mon.dame;
							// Hien thong tin
							System.out.println("Mau nguoi: "+health);
							System.out.println("Ten Quai: "+mon.name+" ---Mau Quai: "+mon.health);
							if(health <=0)
							{
								System.out.println("Người đã bị: "+mon.name+" giết.");
								break;
							}
						}
						
					}while(health >= 0 || mon.health >=  0);
				}
		}
		
		
	}

	
	
}
