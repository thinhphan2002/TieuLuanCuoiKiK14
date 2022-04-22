package TieuLuanCuoiKi;

 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class KhoHang{
    private List<HangHoa> list = new ArrayList<>();
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static Scanner so = new Scanner(System.in);
    public static Scanner chu = new Scanner(System.in);
 
    public void duLieuCoSan() throws ParseException  
    {
        list.add(new HangThucPham("Thit heo ", "Thuc Pham ", "001", 20, 45, simpleDateFormat.parse("3/7/2021"), simpleDateFormat.parse("5/5/2022"), "Thit Heo gia si"));

        list.add(new HangThucPham("Thit ga ", "Thuc Pham ", "002", 20, 35, simpleDateFormat.parse("16/4/2021"), simpleDateFormat.parse("8/4/2022"), "Thit Ga Bao Nam"));

        list.add(new HangThucPham("Ca hoi ", "Thuc Pham ", "003", 20, 40, simpleDateFormat.parse("1/5/2021"), simpleDateFormat.parse("12/8/2022"), "Thit tuoi huu co An Loc"));
        
        list.add(new HangThucPham("Ca chep ", "Thuc Pham ", "004", 50, 35, simpleDateFormat.parse("30/4/2021"), simpleDateFormat.parse("30/3/2022"), "Thit tuoi huu co An Loc"));
        
        list.add(new HangDienMay("iPhone ", "Dien May ", "005", 25, 500, 12, 100));

        list.add(new HangDienMay("Laptop ", "Dien May ", "006", 25, 600, 32, 150));
        
        list.add(new HangDienMay("Tivi ", "Dien May ", "007", 40, 4.000, 32, 170));
        
        list.add(new HangSanhSu("Bat ", "Sanh Su ", "008", 300, 35, "Gom su Tay Giang", simpleDateFormat.parse("9/9/2022")));
        
        list.add(new HangSanhSu("Am tra ", "Sanh Su ", "009", 200, 350, "Gom su Tay Giang", simpleDateFormat.parse("27/3/2022")));
        
        list.add(new HangSanhSu("Lo cam hoa ", "Sanh Su ", "010", 200, 400, "Gom su Tay Giang", simpleDateFormat.parse("4/7/2022")));

        list.add(new HangSanhSu("Do tho cung ", "Sanh Su ", "011", 50, 500, "Gom su Tay Giang", simpleDateFormat.parse("1/1/2022")));
    }
 
    public HangHoa nhapHangHoaKhongCoMa(String maHang)
    {
        HangHoa hangHoa = null;
        try {
            String tenHang=null; 
            do{
                System.out.print("Ten hang: ");
                tenHang = chu.nextLine();
                if(tenHang.equalsIgnoreCase("")){
                    System.out.println("Ten hang khong duoc rong");
                }
            }while(tenHang.equalsIgnoreCase(""));
            int soLuongTonKho=0; 
            do{
                System.out.print("So luong con: ");
                soLuongTonKho = so.nextInt();
                if(soLuongTonKho<0){
                    System.out.println("So luong hang ton trong kho phai >=0");
                }
            }while(soLuongTonKho<0);
            
            
            double donGia=0.0; 
            do{
                System.out.print("Don gia: ");
                donGia = so.nextDouble();
                if(donGia<=0){
                    System.out.println("Don gia phai lon hon > 0");
                }
            }while(donGia<=0);
            int number=0; 
            do{
                System.out.print("Loai hang: 1 (Thuc Pham) | 2 (Dien May) | 3 (Sanh su) : ");
                number = so.nextInt();
                if(number!=1 && number!=2 && number!=3){
                    System.out.println("Khong hop le, nhap lai");
                }
            }while(number!=1 && number!=2 && number!=3);
            if(number==1) 
            {
                String loaiHang="Thuc Pham";
                Date ngaySX=null;
                Date ngayHetHan=null;
                do{
                    System.out.print("Ngay san xuat (dd/mm/yyyy): ");
                    ngaySX = simpleDateFormat.parse(chu.nextLine());
                    System.out.print("Ngay het han (dd/mm/yyyy): ");
                    ngayHetHan = simpleDateFormat.parse(chu.nextLine());
                    if(ngayHetHan.before(ngaySX)){
                        System.out.println("ngày hết hạn phải sau hoặc là ngày sản xuất");
                    }
                }while(ngayHetHan.before(ngaySX));
                System.out.print("Nha cung cap: ");
                String nhaCungCap = chu.nextLine();
                hangHoa = new HangThucPham(tenHang, loaiHang, maHang, soLuongTonKho, donGia, ngaySX, ngayHetHan, nhaCungCap);
            }
            else if(number==2) 
            {
                String loaiHang="dien may";
                int tGBaoHanh;
                do{
                    System.out.print("Time bao hanh (thang/month): ");
                    tGBaoHanh = so.nextInt();
                    if(tGBaoHanh<0){
                        System.out.println("time bao hanh phai >=0");
                    }
                }while(tGBaoHanh<0);
                double congSuatKW;
                do{
                    System.out.print("Cong suat(KW): ");
                    congSuatKW = so.nextDouble();
                    if(congSuatKW<=0){
                        System.out.println("Cong suat phai >0");
                    }
                }while(congSuatKW<=0);
                hangHoa = new HangDienMay(tenHang, loaiHang, maHang, soLuongTonKho, donGia, tGBaoHanh, congSuatKW);
            }
            else
            {
                String loaiHang="Sanh su";
                System.out.print("Nha san xuat: ");
                String nhaSanXuat = chu.nextLine();
                System.out.print("Ngay nhap kho (dd/mm/yyyy): ");
                Date ngayNhapKho = simpleDateFormat.parse(chu.nextLine());
                hangHoa = new HangSanhSu(tenHang, loaiHang, maHang, soLuongTonKho, donGia, nhaSanXuat, ngayNhapKho);
            
            }
        } catch (Exception e) {
            so=new Scanner(System.in);
            System.out.println("Chuong trinh loi hoac co the nguoi su dung nhap chu cai, khong duoc nhap chu cai chi duoc nhap so!!");
            e.printStackTrace();
        }
        return hangHoa;
    }
    public void them(HangHoa hangHoa)
    {
        if(hangHoa!=null){
            this.list.add(hangHoa);
        }
    }
    public boolean kiemTraMaHangTrung(String maHang){
        boolean kt = false;
        for (HangHoa hangHoa : list) {
            if( hangHoa.getMaHang().equals(maHang)){
                kt=true;
            }
        }
        return kt;
    }
 
    public void xuat()
    {
        for(HangHoa hangHoa : list)
        {
            System.out.println(hangHoa);
            System.out.println();
        }
    }
 
    public HangHoa timHangTheoMa(String maHang)
    {
        HangHoa hangHoa = null;
        for(HangHoa hangHoa2 : list)
        {
            if(hangHoa2.getMaHang().toString().equalsIgnoreCase(maHang))
            {
                hangHoa = hangHoa2;
            }
        }
        if(hangHoa==null){
            System.out.println("Not find");
        }
        return hangHoa;
    }
    public void traVeKetQua(HangHoa hangHoa)
    {
        if(hangHoa!=null){
            System.out.println(hangHoa);
        }
    }
 
    public void xoa(HangHoa hangHoa)
    {
        if(hangHoa!=null){
            System.out.println("Da xoa");
        }
        this.list.remove(hangHoa);
    }
    public String nhapMaHangHoa(){
        String maHang=null; 
        boolean kiemTraMa=true;
        do{
            try {
                System.out.print("Ma hang: ");
                maHang = chu.nextLine();
                kiemTraMa=kiemTraMaHangTrung(maHang);
                if(maHang.equalsIgnoreCase("")){
                System.out.println("Ma hang ko duoc rong");
                }
                else if(kiemTraMa==true){
                    System.out.println("Ma hang nay da nhap!!, hay thu ma khac");
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }while(maHang.equalsIgnoreCase("") || kiemTraMa==true);
        return maHang;
    }
    public int timViTriHangHoa(HangHoa hangHoa)
    {
        int viTri = -1;
        viTri = this.list.indexOf(hangHoa);
        return viTri;
    }
    public void suaHangHoa(String maHang)
    {
        int viTri= timViTriHangHoa(timHangTheoMa(maHang));
        if(viTri == -1)
        {
            System.out.println(" Not find ");
        }
        else
        {
            HangHoa hangHoa = nhapHangHoaKhongCoMa(maHang);
            if(hangHoa!=null){
                this.list.set(viTri, hangHoa);
                System.out.println("Da sua");
            }
        }
    }
 
    public void sapXepTangDanTheoGia(){ 
        Comparator<HangHoa> comp = new Comparator<HangHoa>(){
            public int compare(HangHoa o1, HangHoa o2) {
                return Double.compare(o1.getDonGia(), o2.getDonGia());
            }
        };
        Collections.sort(list, comp);
        System.out.println("Da sap xep");
    }
    public void sapXepGiamDanTheoGia(){
        sapXepTangDanTheoGia();
        Collections.reverse(list);
    }
 
 
    public void thongKe(){
        int matHangThucPham=0;
        int matHangDienMay=0;
        int matHangSanhSu=0;
        double giaTriHangThucPham=0;
        double giaTriHangDienMay=0;
        double giaTriHangSanhSu=0;
        int tonHangThucPham=0;
        int tonHangDienMay=0;
        int tonHangSanhSu=0;
        int danhGiaHangThucPham=0;
        int danhGiaHangDienMay=0;
        int danhGiaHangSanhSu=0;
        for(HangHoa hangHoa : list)
        {
            if(hangHoa instanceof HangDienMay)
            {
                matHangDienMay += 1;
                giaTriHangDienMay += hangHoa.getDonGia()*hangHoa.getSoLuongTonkho()*1.1;
                tonHangDienMay += hangHoa.getSoLuongTonkho();
                if(!hangHoa.getDanhGia().equalsIgnoreCase("Rong")){
                    danhGiaHangDienMay +=1;
                }
            }
            else if(hangHoa instanceof HangSanhSu)
            {
                matHangSanhSu += 1;
                giaTriHangSanhSu += hangHoa.getDonGia()*hangHoa.getSoLuongTonkho()*1.1;
                tonHangSanhSu += hangHoa.getSoLuongTonkho();
                if(!hangHoa.getDanhGia().equalsIgnoreCase("Rong")){
                    danhGiaHangSanhSu +=1;
                }
            }
            else{
                matHangThucPham += 1;
                giaTriHangThucPham += hangHoa.getDonGia()*hangHoa.getSoLuongTonkho()*1.05;
                tonHangThucPham += hangHoa.getSoLuongTonkho();
                if(!hangHoa.getDanhGia().equalsIgnoreCase("Rong")){
                    danhGiaHangThucPham +=1;
                }
            }
        }
        System.out.println("==== Hang Thuc Pham ====");
        System.out.println("Tong so luong mat hang: "+matHangThucPham);
        System.out.println("Tong gia tri: "+giaTriHangThucPham);
        System.out.println("Tong so luong hang ton: "+tonHangThucPham);
        System.out.println("Tong so luong hang bi vote kho ban: "+danhGiaHangThucPham);
        System.out.println("==== Hang Dien May ====");
        System.out.println("Tong so luong mat hang: "+matHangDienMay);
        System.out.println("Tong gia tri: "+giaTriHangDienMay);
        System.out.println("Tong so luong hang ton: "+tonHangDienMay);
        System.out.println("Tong so luong hang vote ban duoc: "+danhGiaHangDienMay);
        System.out.println("==== Hang Sanh Su ====");
        System.out.println("Tong so luong mat hang: "+matHangSanhSu);
        System.out.println("Tong gia tri: "+giaTriHangSanhSu);
        System.out.println("Tong so luong hang ton: "+tonHangSanhSu);
        System.out.println("Tong so hang vote ban cham(slow): "+danhGiaHangSanhSu);
    }
}
