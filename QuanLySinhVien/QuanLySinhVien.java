package QuanLySinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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
	public void XapXepTheoDiem2()
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
