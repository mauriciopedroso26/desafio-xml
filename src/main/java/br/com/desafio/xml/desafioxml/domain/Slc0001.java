package br.com.desafio.xml.desafioxml.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TA_SLC0001", schema = "DESAFIO_XML")
public class Slc0001 implements Serializable {

    private static final long serialVersionUID = -8916263565743242290L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SLC0001")
    @SequenceGenerator(name = "SQ_SLC0001", schema = "DESAFIO_XML", sequenceName = "SQ_SLC0001",
            allocationSize = 1)
    @Column(name = "ID_SLC0001", nullable = false)
    private Long idSlc0001;
    @Column(name = "COD_MSG")
    private String codMsg;
    @Column(name = "NUM_CTRL_SLC")
    private String numCtrlSLC;
    @Column(name = "ISPBIF")
    private Long ispbif;
    @Column(name = "TP_INF")
    private String tpInf;
    @OneToMany(mappedBy = "slc0001", fetch = FetchType.LAZY)
    private List<GrupoSlc0001Liquid> grupoSlc0001Liquid;
    @Column(name = "DT_HR_SLC")
    private String dtHrSlc;
    @Column(name = "DT_MOVTO")
    private String dtMovto;

    @JsonIgnore
    @OneToOne(mappedBy = "slc0001", fetch = FetchType.LAZY)
    private Sismsg sismsg;

    public Slc0001() {
        grupoSlc0001Liquid = new ArrayList<>();
    }


    public Long getIdSlc0001() {
        return idSlc0001;
    }

    public void setIdSlc0001(Long idSlc0001) {
        this.idSlc0001 = idSlc0001;
    }

    @XmlElement(name = "CodMsg", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public String getCodMsg() {
        return codMsg;
    }

    public void setCodMsg(String codMsg) {
        this.codMsg = codMsg;
    }

    @XmlElement(name = "NumCtrlSLC", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public String getNumCtrlSLC() {
        return numCtrlSLC;
    }

    public void setNumCtrlSLC(String numCtrlSLC) {
        this.numCtrlSLC = numCtrlSLC;
    }

    @XmlElement(name = "ISPBIF", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public Long getIspbif() {
        return ispbif;
    }

    public void setIspbif(Long ispbif) {
        this.ispbif = ispbif;
    }

    @XmlElement(name = "TpInf", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public String getTpInf() {
        return tpInf;
    }

    public void setTpInf(String tpInf) {
        this.tpInf = tpInf;
    }

    @XmlElement(name = "Grupo_SLC0001_Liquid", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public List<GrupoSlc0001Liquid> getGrupoSlc0001Liquid() {
        return grupoSlc0001Liquid;
    }

    public void setGrupoSlc0001Liquid(List<GrupoSlc0001Liquid> grupoSlc0001Liquid) {
        this.grupoSlc0001Liquid = grupoSlc0001Liquid;
    }

    @XmlElement(name = "DtHrSLC", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public String getDtHrSlc() {
        return dtHrSlc;
    }

    public void setDtHrSlc(String dtHrSlc) {
        this.dtHrSlc = dtHrSlc;
    }

    @XmlElement(name = "DtMovto", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public String getDtMovto() {
        return dtMovto;
    }

    public void setDtMovto(String dtMovto) {
        this.dtMovto = dtMovto;
    }

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
        Slc0001 slc0001 = (Slc0001) o;
        return Objects.equals(idSlc0001, slc0001.idSlc0001) &&
                Objects.equals(codMsg, slc0001.codMsg) &&
                Objects.equals(numCtrlSLC, slc0001.numCtrlSLC) &&
                Objects.equals(ispbif, slc0001.ispbif) &&
                Objects.equals(tpInf, slc0001.tpInf) &&
                Objects.equals(grupoSlc0001Liquid, slc0001.grupoSlc0001Liquid) &&
                Objects.equals(dtHrSlc, slc0001.dtHrSlc) &&
                Objects.equals(dtMovto, slc0001.dtMovto) &&
                Objects.equals(sismsg, slc0001.sismsg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSlc0001, codMsg, numCtrlSLC, ispbif, tpInf, grupoSlc0001Liquid, dtHrSlc, dtMovto, sismsg);
    }

    @Override
    public String toString() {
        return "Slc0001{" +
                "idSlc0001=" + idSlc0001 +
                ", codMsg='" + codMsg + '\'' +
                ", numCtrlSLC='" + numCtrlSLC + '\'' +
                ", ispbif=" + ispbif +
                ", tpInf='" + tpInf + '\'' +
                ", grupoSlc0001Liquid=" + grupoSlc0001Liquid +
                ", dtHrSlc='" + dtHrSlc + '\'' +
                ", dtMovto='" + dtMovto + '\'' +
                ", sismsg=" + sismsg +
                '}';
    }
}
