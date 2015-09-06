package QuanLyTienDien;

import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

public class Main {

	public static void main(String[] args) {
		
		int choose = 0;
		Scanner input = new Scanner(System.in);
		QuanLyKhachHang qlKH = new QuanLyKhachHang();
		qlKH.nhapTTKH();
		qlKH.xuatTTKH(0);
		
		do{
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("----------------------------Chương trình tính tiền điện------------------------------");
			System.out.println("----------Xin mời chọn chức năng để xắp xếp khách hàng theo mục đích của bạn----------");
			System.out.println("Chọn 0: Giữ nguyên danh sách khách hàng. ");
			System.out.println("Chọn 1: Sắp xếp danh sách khách hàng theo số tiền phải trả. ");
			System.out.println("Chọn 2: sắp xếp danh sách khách hàng theo tên khách. ");
			System.out.println("Chọn 3: Sắp xếp danh sách khách hàng theo tên A-Z nếu tên trùng thí xắp xếp theo số tiền.");
			System.out.println("Chọn 4: Exit. ");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			choose = input.nextInt();
		
			switch(choose)
			{
			case 0 : qlKH.xuatTTKH(0);
				break;
			case 1 : qlKH.xuatTTKH(1);
				break;
			case 2 : qlKH.xuatTTKH(2);
				break;
			case 3 : qlKH.xuatTTKH(3);
				break;
			case 4 :
				System.out.println("Cảm ơn bạn đã sử dụng chương trình.");
				break;
			default :
				System.out.println("Bạn đã nhập sai tùy chọn xin mời nhập lại.");
				break;
			}
		}while(choose != 4);
	}
}
