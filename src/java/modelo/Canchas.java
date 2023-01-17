/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DAVID
 */
@Entity
@Table(name = "canchas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Canchas.findAll", query = "SELECT c FROM Canchas c")
    , @NamedQuery(name = "Canchas.findByIdCanchas", query = "SELECT c FROM Canchas c WHERE c.idCanchas = :idCanchas")
    , @NamedQuery(name = "Canchas.findByTipoDeCancha", query = "SELECT c FROM Canchas c WHERE c.tipoDeCancha = :tipoDeCancha")
    , @NamedQuery(name = "Canchas.findByPrecio", query = "SELECT c FROM Canchas c WHERE c.precio = :precio")})
public class Canchas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCanchas")
    private Integer idCanchas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipoDeCancha")
    private String tipoDeCancha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCanchas")
    private List<Turnos> turnosList;

    public Canchas() {
    }

    public Canchas(Integer idCanchas) {
        this.idCanchas = idCanchas;
    }

    public Canchas(Integer idCanchas, String tipoDeCancha, int precio) {
        this.idCanchas = idCanchas;
        this.tipoDeCancha = tipoDeCancha;
        this.precio = precio;
    }

    public Integer getIdCanchas() {
        return idCanchas;
    }

    public void setIdCanchas(Integer idCanchas) {
        this.idCanchas = idCanchas;
    }

    public String getTipoDeCancha() {
        return tipoDeCancha;
    }

    public void setTipoDeCancha(String tipoDeCancha) {
        this.tipoDeCancha = tipoDeCancha;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<Turnos> getTurnosList() {
        return turnosList;
    }

    public void setTurnosList(List<Turnos> turnosList) {
        this.turnosList = turnosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCanchas != null ? idCanchas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Canchas)) {
            return false;
        }
        Canchas other = (Canchas) object;
        if ((this.idCanchas == null && other.idCanchas != null) || (this.idCanchas != null && !this.idCanchas.equals(other.idCanchas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Canchas[ idCanchas=" + idCanchas + " ]";
    }
    
}
