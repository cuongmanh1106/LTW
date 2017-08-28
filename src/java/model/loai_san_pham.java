
package model;


public class loai_san_pham {
    private int ma_loai;
    private String ten_loai;
    private String mo_ta;
    private int ma_loai_cha;
    
    public loai_san_pham() {
        this.ma_loai = 0;
        this.ten_loai = "";
        this.mo_ta = "";
        this.ma_loai_cha = 9;
    }

    public loai_san_pham(int ma_loai, String ten_loai, String mo_ta, int ma_loai_cha) {
        this.ma_loai = ma_loai;
        this.ten_loai = ten_loai;
        this.mo_ta = mo_ta;
        this.ma_loai_cha = ma_loai_cha;
    }

    public int getMa_loai() {
        return ma_loai;
    }

    public void setMa_loai(int ma_loai) {
        this.ma_loai = ma_loai;
    }

    public String getTen_loai() {
        return ten_loai;
    }

    public void setTen_loai(String ten_loai) {
        this.ten_loai = ten_loai;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public int getMa_loai_cha() {
        return ma_loai_cha;
    }

    public void setMa_loai_cha(int ma_loai_cha) {
        this.ma_loai_cha = ma_loai_cha;
    }

    @Override
    public String toString() {
        return "loai_san_pham{" + "ma_loai=" + ma_loai + ", ten_loai=" + ten_loai + ", mo_ta=" + mo_ta + ", ma_loai_cha=" + ma_loai_cha + '}';
    }
    
    
    
    
    
}
