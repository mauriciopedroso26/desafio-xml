package br.com.desafio.xml.desafioxml.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

@Entity
@Table(name = "TA_GRUPO_SEQ", schema = "DESAFIO_XML")
public class GrupoSeq {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_GRUPO_SEQ")
    @SequenceGenerator(name = "SQ_GRUPO_SEQ", schema = "DESAFIO_XML", sequenceName = "SQ_GRUPO_SEQ",
            allocationSize = 1)
    @Column(name = "ID_GRUPO_SEQ", nullable = false)
    private Long idGrupoSeq;
    @Column(name = "NUM_SEQ")
    private Long numSeq;
    @Column(name = "INDR_CONT")
    private String indrCont;

    @Column(name = "ID_BCMSG")
    private Long idBcmsg;

    @JsonIgnore
    @JoinColumn(name = "ID_BCMSG", referencedColumnName = "ID_BCMSG", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Bcmsg bcmsg;

    public Long getIdGrupoSeq() {
        return idGrupoSeq;
    }

    public void setIdGrupoSeq(Long idGrupoSeq) {
        this.idGrupoSeq = idGrupoSeq;
    }

    @XmlElement(name = "NumSeq", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public Long getNumSeq() {
        return numSeq;
    }

    public void setNumSeq(Long numSeq) {
        this.numSeq = numSeq;
    }

    @XmlElement(name = "IndrCont", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public String getIndrCont() {
        return indrCont;
    }

    public void setIndrCont(String indrCont) {
        this.indrCont = indrCont;
    }

    public Long getIdBcmsg() {
        return idBcmsg;
    }

    public void setIdBcmsg(Long idBcmsg) {
        this.idBcmsg = idBcmsg;
    }

    public Bcmsg getBcmsg() {
        return bcmsg;
    }

    public void setBcmsg(Bcmsg bcmsg) {
        this.bcmsg = bcmsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoSeq grupoSeq = (GrupoSeq) o;
        return Objects.equals(numSeq, grupoSeq.numSeq) &&
                Objects.equals(indrCont, grupoSeq.indrCont);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numSeq, indrCont);
    }

    @Override
    public String toString() {
        return "GrupoSeq{" +
                "numSeq=" + numSeq +
                ", indrCont='" + indrCont + '\'' +
                '}';
    }
}
