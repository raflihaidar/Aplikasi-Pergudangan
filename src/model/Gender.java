package model;

public class Gender {

    private int kode;
    private String gender;

    public Gender(int kode) {
        this.kode = kode;
    }

    public Gender() {
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
