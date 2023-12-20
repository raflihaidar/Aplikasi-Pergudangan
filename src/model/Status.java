package model;

public class Status {

    private int kode;
    private String status;
    
     public Status(int kode){
       this.kode = kode;
    }
    
    public Status(){
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
