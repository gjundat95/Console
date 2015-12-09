package QuanLySinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuanLySinhVien 
{
	private Scanner input = new Scanner(System.in);
	public List<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	private int n;
	
	public void NhapSinhVien()
	{
		System.out.println("Nhap So Luong Sinh Vien:");
		n = Integer.parseInt(input.nextLine());
		for(int i = 0; i<n ; i++)
		{
			SinhVien sinhVien = new SinhVien();
			sinhVien.Nhap();
			dsSinhVien.add(sinhVien);
		}
	}
	
	public void XuatSinhVien()
	{
		for(SinhVien sv : dsSinhVien)
		{
			sv.Xuat();
		}
	}
	
	/*
	 * Tìm kiếm theo tên bằng regex
	 */
	public void TimTen()
	{
		System.out.print("Moi Nhap Ten Can Tim Kiem: ");
		String text = input.nextLine();
		text = text.trim();
		String regex = text+"$";
		Pattern pattern = Pattern.compile(regex);
		for (int i = 0; i < n; i++)
		{
			Matcher matcher = pattern.matcher(dsSinhVien.get(i).hoten);
			if(matcher.find())
			{
				dsSinhVien.get(i).Xuat();
			}
		}
		System.out.println("Tim Xong.");
	}
	
	/*
	 * Tìm họ bằng Regex
	 */
	public void TimHo()
	{
		System.out.print("Xin moi nhap ho can tim kiem: ");
		String text = input.nextLine();
		text = text.trim();
		String regex = "^"+text;
		Pattern pattern = Pattern.compile(regex);
		for(SinhVien sv : dsSinhVien)
		{
			Matcher matcher = pattern.matcher(sv.hoten);
			if(matcher.find())
			{
				sv.Xuat();
			}
		}
		System.out.println("Tim kiem xong.");
	}
	
	public void XapXepTheoTuoi()
	{
		SinhVien temp;
		
		for(int i = 0; i < n; i++)
		{
			for(int j = i+1; j < n-1; j++)
			{
				if(dsSinhVien.get(i).tuoi > dsSinhVien.get(j).tuoi)
				{
					temp = dsSinhVien.get(i);
					dsSinhVien.set(i, dsSinhVien.get(j));
					dsSinhVien.set(j, temp);
				}
			}
		}
		
	}
	/*
	 * Xắp xếp theo phương thức sort của arraylist
	 */
	public void XapXepTheoDiem1()
	{
		dsSinhVien.sort(new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) 
			{
				return (int)(o1.tongdiem - o2.tongdiem);
			}
			
		});
	}
	/*
	 * Xắp xếp điểm theo lambda 
	 */
	public void XapXepTheoTuoi1()
	{
		dsSinhVien.sort((o1,o2)->(int)(o1.tongdiem-o2.tongdiem));
		dsSinhVien.forEach((sv)->sv.Xuat());
	}
	/*
	 * Xắp xếp tên theo lambda	 
	 */
	public void XapXepTheoTen()
	{
		dsSinhVien.sort((o1,o2)->o1.hoten.compareTo(o2.hoten));
		dsSinhVien.forEach((sv)->sv.Xuat());
	}
	
	public void XapXepTheoDiem()
	{
		Collections.sort(dsSinhVien,new Comparator<SinhVien>() 
		{
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				
				double value = o1.tongdiem - o2.tongdiem;
				if(value == 0 )
				{
					int tuoi = o1.tuoi - o2.tuoi;
					if(tuoi==0)
					{
						return 0;
					}
					return tuoi;
				}
				else
				{
					return (int)value;
				}
			}
		});
		
	}
}
