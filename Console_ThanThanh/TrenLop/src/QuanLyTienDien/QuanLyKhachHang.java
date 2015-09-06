package QuanLyTienDien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class QuanLyKhachHang 
{
	ArrayList<BienLai> listKhachHang = new ArrayList<BienLai>();
	Scanner input = new Scanner(System.in);
	int n = 0;
	
	/*
	 * Nhập thông tin của n khách hàng
	 * Sau đó thêm từng khách vào mảng ArrayList
	 */
	public void nhapTTKH()
	{
		String tenKhach,maKhach,diaChi;
		float soDienThangTruoc, soDienThangNay;
		
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("-----------------------------------Chương Trình Tính Tiền Điện--------------------------------");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("Nhập vào tổng số khách hàng: ");
		n = Integer.parseInt(input.nextLine());
		
		for(int i = 0; i < n; i++)
		{
			System.out.println("------------------------------------------------------------------------");
			System.out.println("Nhập vào mã khách hàng: ");
			maKhach = input.nextLine();
			System.out.println("Nhập vào tên khách hàng: ");
			tenKhach = input.nextLine();
			System.out.println("Nhập vào địa chỉ khách hàng: ");
			diaChi = input.nextLine();
			System.out.println("Nhập vào số điện tháng trước trên đồng hồ(kWh): ");
			soDienThangTruoc = Integer.parseInt(input.nextLine());
			do{
			System.out.println("Nhập vào số điện tháng này trên đồng hồ(kWh): ");
			soDienThangNay = Integer.parseInt(input.nextLine());
			}while(soDienThangNay <= soDienThangTruoc);
			BienLai bl = new BienLai(maKhach, tenKhach, diaChi, soDienThangTruoc, soDienThangNay);
			listKhachHang.add(bl);
		}
	}

	/*
	 * Xuất thông tin của từng khách và và số tiền phải trả
	 * Đồng thời xắp xếp khách theo tiêu chí nhất định
	 */
	public void xuatTTKH(int soft) 
	{
		if(soft ==0 ) // Không xắp xếp
			prinfKH();
		if(soft == 1) // Xắp xếp theo số điện của khách tăng dần
		{
			Collections.sort(listKhachHang,new QuanLyKhachHangSoft());
			prinfKH();
		}
		if(soft == 2) // So sánh tên của khách hàng và sắp xếp theo A-Z
		{
			// Xắp xếp lại
			Collections.sort(listKhachHang,new Comparator<BienLai>() {
				@Override
				public int compare(BienLai o1, BienLai o2) 
				{
					int value = o1.tenKhach.compareTo(o2.tenKhach);
					return value;
				}
			});
			// Hiển thị
			prinfKH(); 
		}
		if(soft == 3) // So sánh theo tên nếu tên trùng nhau so sánh theo số tien điện tháng này
		{
			// Xắp xếp
			Collections.sort(listKhachHang,new Comparator<BienLai>() {

				@Override
				public int compare(BienLai o1, BienLai o2)
				{
					int value = o1.tenKhach.compareTo(o2.tenKhach);
					// Khi tên của khách khác nhau
					if(value != 0)
						return value;
					// Tên của khách giống nhau so sánh theo số tiền
					if(o1.soTien > o2.soTien)
						return 1;
					return -1;
				}
			});
			// Hiển thị khách
			prinfKH();
		}
		
	}
	public void prinfKH()
	{
		Date dt = new Date();
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("Biên Lai thanh toán tiền điện cho "+n+" khách hàng vào ngày: "+dt.toString());
		for(BienLai bl: listKhachHang)
		{	
			System.out.println("-------------------------------------------------------------------------------------------------");
			BienLai.XuatBienLai(bl);
		}
	}
}
