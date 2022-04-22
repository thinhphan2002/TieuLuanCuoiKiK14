package TieuLuanCuoiKi;

import java.util.Date;

public class HangSanhSu extends HangHoa{
    private String nhaSanXuat;
    private Date ngayNhapKho;

    
    public String getNhaSanXuat() {
        return nhaSanXuat;
    }
    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }
    @Override
    public double getThue() 
    {
        return getDonGia() * 0.1;
    }
 
    public HangSanhSu(){}
    public HangSanhSu(String tenHang, String loaiHang, String maHang, int soLuongTonKho, double donGia, String nhaSanXuat, Date ngayNhapKho) 
    {
        super(tenHang, loaiHang, maHang, soLuongTonKho, donGia);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }
 
    @Override
    public String getDanhGia() {
        String d = "Rong";
        if(getSoLuongTonkho() > 50 && ( new Date().getTime() - ngayNhapKho.getTime() )/100000000 >10)
        {
            d = "Hang ban bi cham(slow)";
        }
        return d;
    }
    @Override
    public String toString() {
        String str = KhoHang.simpleDateFormat.format(getNgayNhapKho());
        return super.toString()+ 
        "\nNha san xuat: " +getNhaSanXuat()+ 
        "\nNgay nhap kho: " +str+ 
        "\nThue: " +getThue()+"00vnđ" +
        "\nVote Hang Sanh Su: " +getDanhGia();
    }
}
