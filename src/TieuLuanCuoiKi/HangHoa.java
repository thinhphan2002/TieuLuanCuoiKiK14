package TieuLuanCuoiKi;

public abstract class HangHoa {
    private String tenHang;
    private String loaiHang;
    private String maHang;
    private int soLuongTonkho;
    private double donGia;

    public String getTenHang() 
    {
        return tenHang;
    }
    public String getLoaiHang() 
    {
        return loaiHang;
    }
    public String getMaHang() 
    {
        return maHang;
    }
    public int getSoLuongTonkho() 
    {
        return soLuongTonkho;
    }
    public double getDonGia() 
    {
        return donGia;
    }

    public abstract double getThue();
    public abstract String getDanhGia();
 
    public HangHoa(){}
    public HangHoa(String tenHang, String loaiHang, String maHang, int soLuongTon, double donGia) 
    {
        this.tenHang = tenHang;
        this.loaiHang = loaiHang;
        this.maHang = maHang;
        this.soLuongTonkho = soLuongTon;
        this.donGia = donGia;
    }
 
    
    
 
    @Override
    public String toString() {
        return 
        "\nTen Hang: " +getTenHang()+ 
        "\nLoai Hang: " +getLoaiHang()+ 
        "\nMa Hang: " +getMaHang()+ 
        "\nSo luong ton kho: " +getSoLuongTonkho()+ 
        "\nDon gia: " +getDonGia() +".000vnđ";
    }

}




 
