package br.com.desafio.xml.desafioxml.domain;

import br.com.desafio.xml.desafioxml.entity.Slc0001Modelo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TA_SISMSG", schema = "DESAFIO_XML")
public class Sismsg implements Serializable {

    private static final long serialVersionUID = -1293318366978481486L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SISMSG")
    @SequenceGenerator(name = "SQ_SISMSG", schema = "DESAFIO_XML", sequenceName = "SQ_SISMSG",
            allocationSize = 1)
    @Column(name = "ID_SISMSG", nullable = false)
    private Long idSismsg;

    @Column(name = "ID_SLC0001")
    private Long idSlc0001;

    @JoinColumn(name = "ID_SLC0001", referencedColumnName = "ID_SLC0001", insertable = false, updatable = false)
    @OneToOne
    private Slc0001 slc0001;

    @JsonIgnore
    @OneToOne(mappedBy = "sismsg", fetch = FetchType.LAZY)
    private Slc0001Modelo slc0001Modelo;

    public Long getIdSismsg() {
        return idSismsg;
    }

    public void setIdSismsg(Long idSismsg) {
        this.idSismsg = idSismsg;
    }

    public Long getIdSlc0001() {
        return idSlc0001;
    }

    public void setIdSlc0001(Long idSlc0001) {
        this.idSlc0001 = idSlc0001;
    }

    @XmlElement(name = "SLC0001", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public Slc0001 getSlc0001() {
        return slc0001;
    }

    public void setSlc0001(Slc0001 slc0001) {
        this.slc0001 = slc0001;
    }

    public Slc0001Modelo getSlc0001Modelo() {
        return slc0001Modelo;
    }

    public void setSlc0001Modelo(Slc0001Modelo slc0001Modelo) {
        this.slc0001Modelo = slc0001Modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sismsg sismsg = (Sismsg) o;
        return Objects.equals(idSismsg, sismsg.idSismsg) &&
                Objects.equals(idSlc0001, sismsg.idSlc0001) &&
                Objects.equals(slc0001, sismsg.slc0001) &&
                Objects.equals(slc0001Modelo, sismsg.slc0001Modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSismsg, idSlc0001, slc0001, slc0001Modelo);
    }

    @Override
    public String toString() {
        return "Sismsg{" +
                "idSismsg=" + idSismsg +
                ", idSlc0001=" + idSlc0001 +
                ", slc0001=" + slc0001 +
                ", slc0001Modelo=" + slc0001Modelo +
                '}';
    }
}
