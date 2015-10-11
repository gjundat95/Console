package DaGiac;
import java.util.Scanner;
public class DaGiac
{
	Scanner input = new Scanner(System.in);
	public int soCanh;
	public int chuVi;
	public int[] dodaiCanh; // Khai bao mang chua do dai cac canh
	
	// Cha bao gio su dung den
	public DaGiac(int _soCanh)
	{
		this.soCanh = _soCanh;
	}
	
	// Nap chong contructor, cai nay lai hay su dung
	public DaGiac()
	{
		
	}
	
	public void nhapCanhDG()
	{
		System.out.println("Nhap vao tong so canh cua da giac: ");
		this.soCanh = Integer.parseInt(input.nextLine());
		dodaiCanh = new int[soCanh]; // Khoi tao mang do dai cac canh
		for(int i = 0; i < soCanh; i++)
		{
			System.out.println("Nhap vao canh thu "+(i+1)+":");
			dodaiCanh[i] = Integer.parseInt(input.nextLine());
		}
	}
	
	public void hienThiChuVi()
	{
		int temp = 0;
		// chay theo kieu foreach trong c#
		for(int chieuDaiCanh : dodaiCanh)
		{
			temp += chieuDaiCanh;
		}
		System.out.println("Chu vi cua da giac la: "+temp);
	}
	
}
