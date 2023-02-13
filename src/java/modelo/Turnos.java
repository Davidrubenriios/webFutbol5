/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DAVID
 */
@Entity
@Table(name = "turnos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turnos.findAll", query = "SELECT t FROM Turnos t")
    , @NamedQuery(name = "Turnos.findByIdTurnos", query = "SELECT t FROM Turnos t WHERE t.idTurnos = :idTurnos")
    , @NamedQuery(name = "Turnos.findByFecha", query = "SELECT t FROM Turnos t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "Turnos.findByNombre", query = "SELECT t FROM Turnos t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Turnos.findByApellido", query = "SELECT t FROM Turnos t WHERE t.apellido = :apellido")
    , @NamedQuery(name = "Turnos.findByCgoArea", query = "SELECT t FROM Turnos t WHERE t.cgoArea = :cgoArea")
    , @NamedQuery(name = "Turnos.findByTelefono", query = "SELECT t FROM Turnos t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "Turnos.findByAsistencia", query = "SELECT t FROM Turnos t WHERE t.asistencia = :asistencia")})
public class Turnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTurnos")
    private Integer idTurnos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CgoArea")
    private int cgoArea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asistencia")
    private boolean asistencia;

    public Turnos() {
    }

    public Turnos(Integer idTurnos) {
        this.idTurnos = idTurnos;
    }

    public Turnos(Integer idTurnos, String fecha, String nombre, String apellido, int cgoArea, int telefono, boolean asistencia) {
        this.idTurnos = idTurnos;
        this.fecha = fecha;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cgoArea = cgoArea;
        this.telefono = telefono;
        this.asistencia = asistencia;
    }

    public Integer getIdTurnos() {
        return idTurnos;
    }

    public void setIdTurnos(Integer idTurnos) {
        this.idTurnos = idTurnos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCgoArea() {
        return cgoArea;
    }

    public void setCgoArea(int cgoArea) {
        this.cgoArea = cgoArea;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTurnos != null ? idTurnos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turnos)) {
            return false;
        }
        Turnos other = (Turnos) object;
        if ((this.idTurnos == null && other.idTurnos != null) || (this.idTurnos != null && !this.idTurnos.equals(other.idTurnos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Turnos[ idTurnos=" + idTurnos + " ]";
    }
    
}
