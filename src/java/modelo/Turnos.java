/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    , @NamedQuery(name = "Turnos.findByHora", query = "SELECT t FROM Turnos t WHERE t.hora = :hora")
    , @NamedQuery(name = "Turnos.findByFecha", query = "SELECT t FROM Turnos t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "Turnos.findByIdUsuario", query = "SELECT t FROM Turnos t WHERE t.idUsuario = :idUsuario")
    , @NamedQuery(name = "Turnos.findByIdAdministrador", query = "SELECT t FROM Turnos t WHERE t.idAdministrador = :idAdministrador")
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
    @Size(min = 1, max = 8)
    @Column(name = "hora")
    private String hora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAdministrador")
    private int idAdministrador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asistencia")
    private boolean asistencia;
    @JoinColumn(name = "idCanchas", referencedColumnName = "idCanchas")
    @ManyToOne(optional = false)
    private Canchas idCanchas;

    public Turnos() {
    }

    public Turnos(Integer idTurnos) {
        this.idTurnos = idTurnos;
    }

    public Turnos(Integer idTurnos, String hora, Date fecha, int idUsuario, int idAdministrador, boolean asistencia) {
        this.idTurnos = idTurnos;
        this.hora = hora;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.idAdministrador = idAdministrador;
        this.asistencia = asistencia;
    }

    public Integer getIdTurnos() {
        return idTurnos;
    }

    public void setIdTurnos(Integer idTurnos) {
        this.idTurnos = idTurnos;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public Canchas getIdCanchas() {
        return idCanchas;
    }

    public void setIdCanchas(Canchas idCanchas) {
        this.idCanchas = idCanchas;
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
