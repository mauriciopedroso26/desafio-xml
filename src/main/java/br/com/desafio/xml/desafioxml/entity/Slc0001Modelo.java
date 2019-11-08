package br.com.desafio.xml.desafioxml.entity;

import br.com.desafio.xml.desafioxml.domain.Bcmsg;
import br.com.desafio.xml.desafioxml.domain.Sismsg;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TA_SLC0001_MODELO", schema = "DESAFIO_XML")
@XmlRootElement(name = "DOC", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
public class Slc0001Modelo implements Serializable {

    private static final long serialVersionUID = 1708879132860366023L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SLC0001_MODELO")
    @SequenceGenerator(name = "SQ_SLC0001_MODELO", schema = "DESAFIO_XML", sequenceName = "SQ_SLC0001_MODELO",
            allocationSize = 1)
    @Column(name = "ID_SLC0001_MODELO", nullable = false)
    private Long idSlc0001Modelo;

    @Column(name = "ID_BCMSG")
    private Long idBcmsg;

    @JoinColumn(name = "ID_BCMSG", referencedColumnName = "ID_BCMSG", insertable = false, updatable = false)
    @OneToOne
    private Bcmsg bcmsg;

    @Column(name = "ID_SISMSG")
    private Long idSismsg;

    @JoinColumn(name = "ID_SISMSG", referencedColumnName = "ID_SISMSG", insertable = false, updatable = false)
    @OneToOne
    private Sismsg sismsg;

    public Long getIdSlc0001Modelo() {
        return idSlc0001Modelo;
    }

    public void setIdSlc0001Modelo(Long idSlc0001Modelo) {
        this.idSlc0001Modelo = idSlc0001Modelo;
    }

    public Long getIdBcmsg() {
        return idBcmsg;
    }

    public void setIdBcmsg(Long idBcmsg) {
        this.idBcmsg = idBcmsg;
    }

    @XmlElement(name = "BCMSG", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public Bcmsg getBcmsg() {
        return bcmsg;
    }

    public void setBcmsg(Bcmsg bcmsg) {
        this.bcmsg = bcmsg;
    }

    public Long getIdSismsg() {
        return idSismsg;
    }

    public void setIdSismsg(Long idSismsg) {
        this.idSismsg = idSismsg;
    }

    @XmlElement(name = "SISMSG", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public Sismsg getSismsg() {
        return sismsg;
    }

    public void setSismsg(Sismsg sismsg) {
        this.sismsg = sismsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slc0001Modelo that = (Slc0001Modelo) o;
        return Objects.equals(idSlc0001Modelo, that.idSlc0001Modelo) &&
                Objects.equals(bcmsg, that.bcmsg) &&
                Objects.equals(sismsg, that.sismsg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSlc0001Modelo, bcmsg, sismsg);
    }

    @Override
    public String toString() {
        return "Slc0001Modelo{" +
                "idSlc0001=" + idSlc0001Modelo +
                ", bcmsg=" + bcmsg +
                ", sismsg=" + sismsg +
                '}';
    }
}
