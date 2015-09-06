package QuanLyTienDien;

import java.util.Comparator;

public class QuanLyKhachHangSoft implements Comparator<BienLai> 
{
	@Override
	public int compare(BienLai o1, BienLai o2)
	{
		// Hai obj bằng nhau
		if(o1 == null && o2 == null) 
		return 0;
		// obj1 null, obj2 lớn hơn
		if(o1 == null) 
			return -1;
		// obj2 null, obj1 lớn hơn 
		if(o2 == null) 
			return 1;
		// So sánh số tiền của hai obj
		if(o1.soTien > o2.soTien)
			return 1;
		return -1;
	}
}
