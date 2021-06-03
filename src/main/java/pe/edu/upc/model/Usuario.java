package pe.edu.upc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nombres", length = 45, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 45, nullable = false)
    private String apellidos;

    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    private int rol;

    @Column(name = "genero", nullable = false, length = 1)
    private char genero;

    private int peso;
    private int estatura;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento", nullable = false, length = 45)
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date fecha_nacimiento;

    private int imc;
    private int kcal_recomendado;
    private int estado_suscripcion;
    private int creditos;

    @Column(name = "email", nullable = false, length = 25)
	private String email;
	@Column(name = "password", nullable = false, length = 25)
	private String password;

    @ManyToOne
    @JoinColumn(name = "idObjNutricional", nullable = false)
    private ObjetivoNutricional objetivoNutricional;

    public Usuario(){
        super();
    }

    public Usuario(int idUsuario, String nombres, String apellidos, String telefono, int rol, char genero, int peso,
            int estatura, Date fecha_nacimiento, int imc, int kcal_recomendado, int estado_suscripcion, int creditos,
            String email, String password, ObjetivoNutricional objetivoNutricional) {
        super();
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.rol = rol;
        this.genero = genero;
        this.peso = peso;
        this.estatura = estatura;
        this.fecha_nacimiento = fecha_nacimiento;
        this.imc = imc;
        this.kcal_recomendado = kcal_recomendado;
        this.estado_suscripcion = estado_suscripcion;
        this.creditos = creditos;
        this.email = email;
        this.password = password;
        this.objetivoNutricional = objetivoNutricional;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getImc() {
        return imc;
    }

    public void setImc(int imc) {
        this.imc = imc;
    }

    public int getKcal_recomendado() {
        return kcal_recomendado;
    }

    public void setKcal_recomendado(int kcal_recomendado) {
        this.kcal_recomendado = kcal_recomendado;
    }

    public int getEstado_suscripcion() {
        return estado_suscripcion;
    }

    public void setEstado_suscripcion(int estado_suscripcion) {
        this.estado_suscripcion = estado_suscripcion;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ObjetivoNutricional getObjetivoNutricional() {
        return objetivoNutricional;
    }

    public void setObjetivoNutricional(ObjetivoNutricional objetivoNutricional) {
        this.objetivoNutricional = objetivoNutricional;
    }

    

}
