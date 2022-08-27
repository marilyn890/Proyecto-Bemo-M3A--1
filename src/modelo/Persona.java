package modelo;

/**
 *
 * @author Abel Gomez
 */
public class Persona {

    private int prs_ID;
    private String prs_cedula;
    private String prs_nombre1;
    private String prs_nombre2;
    private String prs_apellido1;
    private String prs_apellido2;
    private String prs_direccion;
    private String prs_telefono;
    private String prs_email;

    public Persona() {
    }
    
    

    public Persona(int prs_ID, String prs_cedula, String prs_nombre1, String prs_nombre2, String prs_apellido1, String prs_apellido2, String prs_direccion, String prs_telefono, String prs_email) {
        this.prs_ID = prs_ID;
        this.prs_cedula = prs_cedula;
        this.prs_nombre1 = prs_nombre1;
        this.prs_nombre2 = prs_nombre2;
        this.prs_apellido1 = prs_apellido1;
        this.prs_apellido2 = prs_apellido2;
        this.prs_direccion = prs_direccion;
        this.prs_telefono = prs_telefono;
        this.prs_email = prs_email;
    }
    
    

    public int getPrs_ID() {
        return prs_ID;
    }

    public void setPrs_ID(int prs_ID) {
        this.prs_ID = prs_ID;
    }

    public String getPrs_cedula() {
        return prs_cedula;
    }

    public void setPrs_cedula(String prs_cedula) {
        this.prs_cedula = prs_cedula;
    }

    public String getPrs_nombre1() {
        return prs_nombre1;
    }

    public void setPrs_nombre1(String prs_nombre1) {
        this.prs_nombre1 = prs_nombre1;
    }

    public String getPrs_nombre2() {
        return prs_nombre2;
    }

    public void setPrs_nombre2(String prs_nombre2) {
        this.prs_nombre2 = prs_nombre2;
    }

    public String getPrs_apellido1() {
        return prs_apellido1;
    }

    public void setPrs_apellido1(String prs_apellido1) {
        this.prs_apellido1 = prs_apellido1;
    }

    public String getPrs_apellido2() {
        return prs_apellido2;
    }

    public void setPrs_apellido2(String prs_apellido2) {
        this.prs_apellido2 = prs_apellido2;
    }

    public String getPrs_direccion() {
        return prs_direccion;
    }

    public void setPrs_direccion(String prs_direccion) {
        this.prs_direccion = prs_direccion;
    }

    public String getPrs_telefono() {
        return prs_telefono;
    }

    public void setPrs_telefono(String prs_telefono) {
        this.prs_telefono = prs_telefono;
    }

    public String getPrs_email() {
        return prs_email;
    }

    public void setPrs_email(String prs_email) {
        this.prs_email = prs_email;
    }

    @Override
    public String toString() {
        return "Persona{" + "prs_ID=" + prs_ID + ", prs_cedula=" + prs_cedula + ", prs_nombre1=" + prs_nombre1 + ", prs_nombre2=" + prs_nombre2 + ", prs_apellido1=" + prs_apellido1 + ", prs_apellido2=" + prs_apellido2 + ", prs_direccion=" + prs_direccion + ", prs_telefono=" + prs_telefono + ", prs_email=" + prs_email + '}';
    }

   
  
    
    

}
