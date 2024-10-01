package com.datos;

public class Paciente {
    private String nombre;
    private String apellido;
    private int documento;
    private int edad;
    private String sexo;
    private Triaje triaje;
    private Atencion atencion;

    public Paciente(String nombre, String apellido, int documento, int edad, String sexo, Triaje Triaje, Atencion atencion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.edad = edad;
        this.sexo = sexo;
        this.triaje = Triaje;
        this.atencion = atencion;
    }

    public Paciente() {
    }

    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the documento
     */
    public int getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(int documento) {
        this.documento = documento;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the triaje
     */
    public Triaje getTriaje() {
        return triaje;
    }

    /**
     * @param triaje the triaje to set
     */
    public void setTriaje(Triaje triaje) {
        this.triaje = triaje;
    }
    
    /**
     * @return the atencion
     */
    public Atencion getAtencion() {
        return atencion;
    }

    /**
     * @param atencion the atencion to set
     */
    public void setAtencion(Atencion atencion) {
        this.atencion = atencion;
    }
}
