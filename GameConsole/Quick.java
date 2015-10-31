package GameConsole;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quick 
{
	static Scanner input = new Scanner(System.in);
	
	public static boolean Answer()
	{
		int a = rand(1,100);
		int b = rand(1,100);
		int kq = a+b;
		
		    
			System.out.println("Trả lời câu hỏi để đánh quái:");
			System.out.println(a+" + "+b+"=");
			String quick = input.nextLine();
			// Kiem tra cau tra loi
			if(KiemTraSo(quick))
			{
				if(kq == Integer.parseInt(quick))
				{
					System.out.println("Bạn đã trả lời đúng.");
					return true;
				}
				System.out.println("Oh,Sai rồi.");
					
				
			}
			// Nhap so 0 de thoat
			if(Integer.parseInt(quick) == 0)
			{
				return false;
				
			}
		
		return false;
		
	}
	
	/*
	 * Hàm random, trả lại kiểu int
	 */
	private static int rand(int min, int max)
	{
		Random rand = new Random();
		int range = max - min +1;
		int randomNum = min + rand.nextInt(range);
		return randomNum;
		
	}
	/*
	 * Kiem tra xem ky tu nhap vao phai la so khong
	 */
	public static boolean KiemTraSo(String st)
	{
		 //Way3 
        Pattern pattern = Pattern.compile("\\d*"); 
        Matcher matcher = pattern.matcher(st); 
        if (matcher.matches()) 
            return true;
        return false;
        
	}
}
