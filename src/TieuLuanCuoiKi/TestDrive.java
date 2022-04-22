package TieuLuanCuoiKi;

public class TestDrive{
    static KhoHang quanLiDanhSachHangHoa = new KhoHang();
    static 
    {
        try 
        {
            quanLiDanhSachHangHoa.duLieuCoSan();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        menu();
    }
    static void menu()
    {
        System.out.println("-------------MENU------------");
        System.out.println("|1.Tim hang theo ma~        |");
        System.out.println("|2.Them hang                |");
        System.out.println("|3.Sua hang hoa             |");
        System.out.println("|4.Xuat hang hoa            |");
        System.out.println("|5.Xoa hang hoa             |");
        System.out.println("|6.Sap xep tang dan theo gia|");
        System.out.println("|7.Sap xep giam dan theo gia|");
        System.out.println("|8.Thong ke                 |");
        System.out.println("-----------------------------");
        System.out.print("Nhap Chuc Nang tu 1>8: ");
        String n = KhoHang.chu.nextLine();
        
        switch(n)
        {
            case "1": timHang(); 
            break;
            case "2": themHang();
            break;
            case "3": sua(); 
            break;
            case "4": xuatHang();
            break;
            case "5": xoaHang();
            break;
            case "6": sapXepTangDanTheoGia(); 
            break;
            case "7": sapXepGiamDanTheoGia(); 
            break;
            case "8": thongKe(); 
            break;
            default:
            {
                System.out.println("Khong dung du lieu");
                nhanEnterDeTiepTuc();
                menu();
                break;
            } 
            
        }
    }
             
    static void nhanEnterDeTiepTuc()
    {
        System.out.println("Enter de tiep tuc");
        KhoHang.chu.nextLine();
    }
    static void themHang()
    {
        String d=null;
        do{
            quanLiDanhSachHangHoa.them(quanLiDanhSachHangHoa.nhapHangHoaKhongCoMa(quanLiDanhSachHangHoa.nhapMaHangHoa()));
            System.out.print("Nhap (y/n): ");
            d=KhoHang.chu.nextLine();
        }while(d.equalsIgnoreCase("y"));
        nhanEnterDeTiepTuc();
        menu();
    }
    static void xuatHang()
    {
        quanLiDanhSachHangHoa.xuat();
        nhanEnterDeTiepTuc();
        menu();
    }
    static void timHang(){
        String maHang;
        System.out.print("Nhap ma hang can tim: ");
        maHang = KhoHang.chu.nextLine();
        quanLiDanhSachHangHoa.traVeKetQua(quanLiDanhSachHangHoa.timHangTheoMa(maHang));
        nhanEnterDeTiepTuc();
        menu();
    }
    static void xoaHang()
    {
        System.out.print("Nhap ma hang can xoa: ");
        String maHang = KhoHang.chu.nextLine();
        quanLiDanhSachHangHoa.xoa(quanLiDanhSachHangHoa.timHangTheoMa(maHang));
        nhanEnterDeTiepTuc();
        menu();
    }
    static void sua()
    {
        System.out.print("Nhap ma hang can sua: ");
        String maHang = KhoHang.chu.nextLine();
        quanLiDanhSachHangHoa.suaHangHoa(maHang);
        nhanEnterDeTiepTuc();
        menu();
    }
    static void sapXepTangDanTheoGia(){
        quanLiDanhSachHangHoa.sapXepTangDanTheoGia();
        nhanEnterDeTiepTuc();
        menu();
    }
    static void sapXepGiamDanTheoGia(){
        quanLiDanhSachHangHoa.sapXepGiamDanTheoGia();
        nhanEnterDeTiepTuc();
        menu();
    }
     
    static void thongKe(){
        quanLiDanhSachHangHoa.thongKe();
        nhanEnterDeTiepTuc();
        menu();
    }
}