package FilterString;

import java.util.Scanner;

public class JavaString 
{
	Scanner input = new Scanner(System.in); 
	public String str1;
	public String str2  = "";
	
	/*
	 * Hàm nhập xâu
	 */
	public void InputString()
	{
		System.out.println("Xin moi nhap vao xau: ");
		str1 = input.nextLine();
	}
	
	/*
	 * Chuẩn hóa xâu, cắt bỏ dấu cách
	 */
	public String ChuanHoa(String str1)
	{
		str1 = str1.trim(); // Cắt bỏ dấu cách ở đầu và cuối
		str1 = str1.replaceAll("\\s+"," "); // Thay thế tất cả 2 dấu thành 1 dẫu cách 
		return str1;
	}
	
	/*
	 * Chuẩn hóa xâu viết hoa từ đâu tiên
	 */
	public String VietHoa()
	{
		str1 = ChuanHoa(str1);
		String temp[] = str1.split(" "); // Cắt thành mảng các xâu
		for(int i = 0; i < temp.length; i++)
		{
			str2 += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
			if(i < str1.length() - 1)
			str2 +=" ";	
		}
		return str2;
	}
	
	/*
	 *  Tách số ra khỏi xâu
	 *  
	 */
	
}
