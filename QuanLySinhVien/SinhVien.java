package QuanLySinhVien;

import java.util.Scanner;

public class SinhVien 
{
	Scanner input = new Scanner(System.in);
	
	public String hoten;
	public int tuoi;
	public double tongdiem;
	
	public void Nhap()
	{
		System.out.println("============================================");
		System.out.print("Nhap Ho Ten: ");
		hoten = input.nextLine();
		System.out.print("Nhap Tuoi: ");
		tuoi = Integer.parseInt(input.nextLine());
		System.out.print("Nhap Tong Diem: ");
		tongdiem = Double.parseDouble(input.nextLine());
		
	}
	
	public void Xuat()
	{
		System.out.println("============================================");
		System.out.println("Ho Ten: "+hoten);
		System.out.println("Tuoi: "+tuoi);
		System.out.println("Tong Diem: "+tongdiem);
	}
}
