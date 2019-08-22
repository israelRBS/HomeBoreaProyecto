package modelo;
public class Asociados {
    
    private int asociado_id;
    private String ante_penal;
    private String ante_poli;
    private String dpiImagen;
    private String especialidad;
    private String foto;
    private byte nivel_acad_id;
    private String usuario_aso;
    private String usuario_contra;

    public Asociados() {
    }

    public Asociados(int asociado_id, String ante_penal, String ante_poli, String dpiImagen, String especialidad, String foto, byte nivel_acad_id, String usuario_aso, String usuario_contra) {
        this.asociado_id = asociado_id;
        this.ante_penal = ante_penal;
        this.ante_poli = ante_poli;
        this.dpiImagen = dpiImagen;
        this.especialidad = especialidad;
        this.foto = foto;
        this.nivel_acad_id = nivel_acad_id;
        this.usuario_aso = usuario_aso;
        this.usuario_contra = usuario_contra;
    }
    
    public int getAsociado_id() {
        return asociado_id;
    }

    public void setAsociado_id(int asociado_id) {
        this.asociado_id = asociado_id;
    }

    public String getAnte_penal() {
        return ante_penal;
    }

    public void setAnte_penal(String ante_penal) {
        this.ante_penal = ante_penal;
    }

    public String getAnte_poli() {
        return ante_poli;
    }

    public void setAnte_poli(String ante_poli) {
        this.ante_poli = ante_poli;
    }

    public String getDpiImagen() {
        return dpiImagen;
    }

    public void setDpiImagen(String dpiImagen) {
        this.dpiImagen = dpiImagen;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public byte getNivel_acad_id() {
        return nivel_acad_id;
    }

    public void setNivel_acad_id(byte nivel_acad_id) {
        this.nivel_acad_id = nivel_acad_id;
    }

    public String getUsuario_aso() {
        return usuario_aso;
    }

    public void setUsuario_aso(String usuario_aso) {
        this.usuario_aso = usuario_aso;
    }

    public String getUsuario_contra() {
        return usuario_contra;
    }

    public void setUsuario_contra(String usuario_contra) {
        this.usuario_contra = usuario_contra;
    }

    @Override
    public String toString() {
        return "Asociados{" + "asociado_id=" + asociado_id + ", ante_penal=" + ante_penal + ", ante_poli=" + ante_poli + ", dpiImagen=" + dpiImagen + ", especialidad=" + especialidad + ", foto=" + foto + ", nivel_acad_id=" + nivel_acad_id + ", usuario_aso=" + usuario_aso + ", usuario_contra=" + usuario_contra + '}';
    }
    
}
