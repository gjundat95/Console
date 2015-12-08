package Regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular 
{
	/*
	 * Xu ly xau
	 */
	public void TestRegex()
	{
//		String str1 = "t";
//		boolean temp1 = str1.matches("."); // co mot hay nhieu ky tu
//		System.out.print(""+temp1);
		
//		String str2 = "lanh"; 
//		boolean temp2 = str2.matches("^h.+");
//		System.out.print(""+temp2);		
		
//		String str3 = "nummbert";
//		boolean temp3 = str3.matches("^n.m{1,3}.+t$");
//		System.out.print(""+temp3);
		
//		String str4 = "95jundat";
//		boolean temp4 = str4.matches("^95[jabc][zxy].+");
//		System.out.print(""+temp4);
	}
	
	/*
	 * Xu ly xau
	 */
	public void ValidateRegex()
	{
		String text = "  Ngo   Doan tinh95   ";
		boolean match = text.matches(".*(Doan|Hanh).*");
		System.out.println(""+match);
		
		text = text.trim();
		text = text.replaceAll("\\s+"," ");
		System.out.println(""+text);
	}
	
	/*
	 * xu ly xau voi pattern va matcher
	 */
	public void PositionRagex()
	{
		
		String text = "This \t is a \t\t\t String";
		String regex = "is";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		
		
		while(matcher.find())
		{
		    System.out.print("Start "+matcher.start() +" ");
		    System.out.print("End "+matcher.end()+" ");
		    System.out.println("Groups "+matcher.group()); 
		}
		
	}

	/*
	 * xu ly xau voi lookingAt
	 */
	public void LookingRegex()
	{
		String text1 = "Iran";
		String text2 = "iraq";
		
		String regex = "^I.[ae]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text1);
		// tìm kiếm phần đầu 
		System.out.println("LookingAt: "+matcher.lookingAt());
		// khớp toàn bộ
		System.out.println("Matches :"+matcher.matches());
		
		// reset matcher thêm text mới
		matcher.reset(text2);
		// tìm kiếm phần đầu 
		System.out.println("LookingAt: "+matcher.lookingAt());
		// khớp toàn bộ
		System.out.println("Matches :"+matcher.matches());
		
	}
	
	/*
	 * Xử lý xâu với Group
	 * fb.com/smovies88
	 */
	public void GroupRegex()
	{
		String text = " int a = 5; float b = 6; float c = 9 ;";
		String regex = "(?<TYPE>\\s*(int|float)\\s+[a-z]\\s*)=(?<VALUE>\\s*\\d+\\s*)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		
		while(matcher.find())
		{
			String group = matcher.group();
			System.out.println("Group: "+group);
			System.out.println("Type: "+matcher.group("TYPE"));
			System.out.println("Value: "+matcher.group("VALUE"));
			System.out.println("-------------------");
		}
		
	}

/*
 * tìm tên file trong url
 * 	
 */
	public void FindFileName()
	{
		String TEXT = "<a href='http://HOST/file/FILE1'>File 1</a>"
	              + "<a href='http://HOST/file/FILE2'>File 2</a>";
		
		String regex = "/file/(?<filename>.*?)'>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(TEXT);
		
		while(matcher.find())
		{
			System.out.println("File Name: "+matcher.group("filename"));
		}
	}
	/*
	 * Tìm Số Trong xâu
	 */
	public void FindNumber()
	{
		String text = "ngo do5an 789tinh 1234";
		String regex = "\\d+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		
		while(matcher.find())
		{
			text = text.replace(matcher.group(0),"");
		}
		System.out.println(text);
	}
	/*
	 * Đếm số từ trong xâu kết thúc bằng chữ G không phân biệt hoa thường
	 */
	public void DemSoTu()
	{
		String text = "noG doan tinh";
		String regex = "[gG]\\s";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		int i = 1;
		while(matcher.find())
		{
			System.out.println(""+i);
		}
	}
}
