package TieuLuanCuoiKi;

 
import java.util.Date;

public class HangThucPham extends HangHoa{
    private Date ngaySX;
    private Date ngayHetHan;
    private String nhaCungCap;
 
    public HangThucPham(){}
    public HangThucPham(String tenHang, String loaiHang, String maHang, int soLuongTonKho, double donGia, Date ngaySX, Date ngayHetHan, String nhaCungCap) {
        super(tenHang, loaiHang, maHang, soLuongTonKho, donGia);
        this.ngaySX = ngaySX;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
    }
 
    public Date getNgaySX() {
        return ngaySX;
    }
    public Date getNgayHetHan() {
        return ngayHetHan;
    }
    public String getNhaCungCap() {
        return nhaCungCap;
    }
    @Override
    public double getThue() 
    {
        return getDonGia() * 0.05;
    }
    @Override
    public String getDanhGia() {
        String vote = "Rong";
        if(getSoLuongTonkho() != 0 && ngayHetHan.before(new Date()))
        {
            vote = "Hang kho ban";
        }
        return vote;
    }
 
    @Override
    public String toString() {
        String str1 = KhoHang.simpleDateFormat.format(getNgaySX());
        String str2 = KhoHang.simpleDateFormat.format(getNgayHetHan());   
        return super.toString()+ "\nNgay San Xuat: " +str1+ 
        "\nNgay het han: " +str2+ 
        "\nNha cung cap: "+getNhaCungCap()+ 
        "\nThue: " +getThue() + "0vnđ" +
        "\nVote: " +getDanhGia();
    }

     
    
}
