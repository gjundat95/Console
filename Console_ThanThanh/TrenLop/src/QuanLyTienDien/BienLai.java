package QuanLyTienDien;

public class BienLai extends KhachHang
{
	public float soDienThangTruoc;
	public float soDienThangNay;
	public final float heSoDien = 3500;
	public float soTien;
	
	/*
	 * Khởi tạo một đối tượng BienLai
	 */
	public BienLai(String _mK , String _tK, String _dC, float _sDTT, float _sDTN)
	{
		maKhach = _mK;
		tenKhach = _tK;
		diaChi = _dC;
		soDienThangNay = _sDTN;
		soDienThangTruoc = _sDTT;
		soTien = (soDienThangNay - soDienThangTruoc) * heSoDien;
	}
	
	/*
	 * Xuất biên lai cho một khách hàng
	 */
	public static void XuatBienLai(BienLai bl)
	{
		System.out.println("Tên Khách: "+bl.tenKhach);
		System.out.println("Địa chỉ: "+bl.diaChi);
		System.out.println("Số điện tháng này: "+(bl.soDienThangNay - bl.soDienThangTruoc) +" kWh");
		System.out.println("Số tiền mà ông/bà "+bl.tenKhach+" phải trả là: "+bl.soTien+" VND");
		System.out.println("Số tiền phải trả chưa có thuế  VAT");
		
	}
}
