package br.com.desafio.xml.desafioxml.domain;

import br.com.desafio.xml.desafioxml.entity.Slc0001Modelo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TA_BCMSG", schema = "DESAFIO_XML")
@XmlRootElement(name = "BCMSG")
public class Bcmsg implements Serializable {

    private static final long serialVersionUID = -2351407104602378463L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_BCMSG")
    @SequenceGenerator(name = "SQ_BCMSG", schema = "DESAFIO_XML", sequenceName = "SQ_BCMSG",
            allocationSize = 1)
    @Column(name = "ID_BCMSG", nullable = false)
    private Long idBcmsg;

    @Column(name = "IDENTD_EMISSOR")
    private Long identdEmissor;
    @Column(name = "IDENTD_DESTINATARIO")
    private Long identdDestinatario;
    @OneToMany(mappedBy = "bcmsg", fetch = FetchType.LAZY)
    private List<GrupoSeq> grupoSeq;
    @Column(name = "DOM_SIST")
    private String domSist;
    @Column(name = "NUOP")
    private String nuop;

    @JsonIgnore
    @OneToOne(mappedBy = "bcmsg", fetch = FetchType.LAZY)
    private Slc0001Modelo slc0001Modelo;

    public Bcmsg() {
        grupoSeq = new ArrayList<>();
    }

    public Long getIdBcmsg() {
        return idBcmsg;
    }

    public void setIdBcmsg(Long idBcmsg) {
        this.idBcmsg = idBcmsg;
    }

    @XmlElement(name = "IdentdEmissor", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public Long getIdentdEmissor() {
        return identdEmissor;
    }

    public void setIdentdEmissor(Long identdEmissor) {
        this.identdEmissor = identdEmissor;
    }

    @XmlElement(name = "IdentdDestinatario", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public Long getIdentdDestinatario() {
        return identdDestinatario;
    }

    public void setIdentdDestinatario(Long identdDestinatario) {
        this.identdDestinatario = identdDestinatario;
    }

    @XmlElement(name = "Grupo_Seq", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public List<GrupoSeq> getGrupoSeq() {
        return grupoSeq;
    }

    public void setGrupoSeq(List<GrupoSeq> grupoSeq) {
        this.grupoSeq = grupoSeq;
    }

    @XmlElement(name = "DomSist", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public String getDomSist() {
        return domSist;
    }

    public void setDomSist(String domSist) {
        this.domSist = domSist;
    }

    @XmlElement(name = "NUOp", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public String getNuop() {
        return nuop;
    }

    public void setNuop(String nuop) {
        this.nuop = nuop;
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
        Bcmsg bcmsg = (Bcmsg) o;
        return Objects.equals(idBcmsg, bcmsg.idBcmsg) &&
                Objects.equals(identdEmissor, bcmsg.identdEmissor) &&
                Objects.equals(identdDestinatario, bcmsg.identdDestinatario) &&
                Objects.equals(grupoSeq, bcmsg.grupoSeq) &&
                Objects.equals(domSist, bcmsg.domSist) &&
                Objects.equals(nuop, bcmsg.nuop) &&
                Objects.equals(slc0001Modelo, bcmsg.slc0001Modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBcmsg, identdEmissor, identdDestinatario, grupoSeq, domSist, nuop, slc0001Modelo);
    }

    @Override
    public String toString() {
        return "Bcmsg{" +
                "idBcmsg=" + idBcmsg +
                ", identdEmissor=" + identdEmissor +
                ", identdDestinatario=" + identdDestinatario +
                ", grupoSeq=" + grupoSeq +
                ", domSist='" + domSist + '\'' +
                ", nuop='" + nuop + '\'' +
                ", slc0001Modelo=" + slc0001Modelo +
                '}';
    }
}
