package TieuLuanCuoiKi;

public class HangDienMay extends HangHoa{
    private int tGBaoHanh;
    private double congSuatKW;
    public double getCongSuatKW() {
        return congSuatKW;
    }
    public int gettGBaoHanh() {
        return tGBaoHanh;
    }
    @Override
    public double getThue() 
    {
        return getDonGia()*0.1;
    }
 
    public HangDienMay(){}
    public HangDienMay(String tenHang, String loaiHang, String maHang, int soLuongTonKho, double donGia, int tGBaoHanh, double congSuatKW) {
        super(tenHang, loaiHang, maHang, soLuongTonKho, donGia);
        this.tGBaoHanh = tGBaoHanh;
        this.congSuatKW = congSuatKW;
    }
 
    
    @Override
    public String getDanhGia() {
        String vote = "Rong";
        if(getSoLuongTonkho() < 3)
        {
            vote = "Hang ban chay";
        }
        return vote;
    }
 
    @Override
    public String toString() {
        return super.toString()+ 
        "\nTime bao hanh (thang/month): " +gettGBaoHanh()+ 
        "\nCong Suat kw: " +getCongSuatKW()+".000 KW"+
        "\nThue: "+getThue()+ 
        "\nVote Hang Dien May: " +getDanhGia();
    }
    
}
