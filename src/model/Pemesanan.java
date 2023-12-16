package model;

public class Pemesanan {

    private int id;
    private int idUser;
    private int idDistributor;
    private int total;
    private Status status = new Status();
    private String tanggal;

    public Pemesanan(int id, int idUser, int idDistributor, int total, String tanggal, int status) {
        this.id = id;
        this.idUser = idUser;
        this.idDistributor = idDistributor;
        this.total = total;
        this.tanggal = tanggal;
        this.status.setKode(status);
    }

    public Pemesanan(int id, int idDistributor, int total) {
        this.id = id;
        this.idDistributor = idDistributor;
        this.total = total;
    }

    public Pemesanan(int idUser) {
        this.idUser = idUser;
    }

    public Pemesanan() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdDistributor() {
        return idDistributor;
    }

    public void setIdDistributor(int idDistributor) {
        this.idDistributor = idDistributor;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        System.out.println(status.getStatus());
        return status.getStatus();
    }

    public void setStatus(String status) {
        this.status.setStatus(status);
    }

}
