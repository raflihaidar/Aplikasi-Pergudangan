package model;

public class Pemesanan {

    private int id;
    private User user = new User();
    private Distributor distributor = new Distributor();
    private int total;
    private Status status = new Status();
    private String tanggal;

    public Pemesanan(int id, int idUser, int idDistributor, int total, String tanggal, int status) {
        this.id = id;
        this.user.setId(idUser);
        this.distributor.setId(idDistributor);
        this.total = total;
        this.tanggal = tanggal;
        this.status.setKode(status);
    }

    public Pemesanan(int id, int idDistributor, int total) {
        this.id = id;
        this.distributor.setId(idDistributor);
        this.total = total;
    }

    public Pemesanan(int idUser) {
        this.user.setId(idUser);
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
        return user.getId();
    }

    public String getUser() {
        return user.getFullName();
    }

    public void setIdUser(int idUser) {
        this.user.setId(idUser);
    }

    public void setUser(String nama) {
        this.user.setFullName(nama);
    }

    public int getIdDistributor() {
        return distributor.getId();
    }

    public String getDistributor() {
        return distributor.getNama();
    }

    public String getAlamatDistributor() {
        return distributor.getAlamat();
    }

    public void setIdDistributor(int idDistributor) {
        this.distributor.setId(idDistributor);
    }

    public void setDistributor(String distributor) {
        this.distributor.setNama(distributor);
    }

    public void setAlamatDistributor(String alamat) {
        this.distributor.setAlamat(alamat);
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
        return status.getStatus();
    }

    public void setStatus(String status) {
        this.status.setStatus(status);
    }

    public int getkodeStatus() {
        return status.getKode();
    }

    public void setKodeStatus(int kode) {
        status.setKode(kode);
    }

}
