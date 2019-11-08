package br.com.desafio.xml.desafioxml.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

@Entity
@Table(name = "TA_GRUPO_SLC0001_LIQUID_PRODT", schema = "DESAFIO_XML")
public class GrupoSlc0001LiquidProdt {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_GRUPO_SLC0001_LIQUID_PRODT")
    @SequenceGenerator(name = "SQ_GRUPO_SLC0001_LIQUID_PRODT", schema = "DESAFIO_XML", sequenceName = "SQ_GRUPO_SLC0001_LIQUID_PRODT",
            allocationSize = 1)
    @Column(name = "ID_GRUPO_SLC0001_LIQUID_PRODT", nullable = false)
    private Long idGrupoSlc0001LiquidProdt;

    @Column(name = "IDENTD_LINHA_BILAT")
    private String identdLinhaBilat;
    @Column(name = "TP_DEB_CRED")
    private String tpDebCred;
    @Column(name = "IS_PBIF_CREDTD")
    private Long isPbifCredtd;
    @Column(name = "IS_PBIF_DEBTD")
    private Long isPbifDebtd;
    @Column(name = "VLR_LANC")
    private Double vlrLanc;
    @Column(name = "CNPJ_N_LIQDANT_DEBTD")
    private String cnpjNLiqdantDebtd;
    @Column(name = "NOM_CLI_DEBTD")
    private String nomCliDebtd;
    @Column(name = "CNPJ_N_LIQDANT_CREDTD")
    private String cnpjNLiqdantCredtd;
    @Column(name = "NOM_CLI_CREDTD")
    private String nomCliCredtd;
    @Column(name = "TP_TRANSC_SLC")
    private Long tpTranscSlc;

    @Column(name = "ID_GRUPO_SLC0001_PRODT")
    private Long idGrupoSlc0001Prodt;

    @JsonIgnore
    @JoinColumn(name = "ID_GRUPO_SLC0001_PRODT", referencedColumnName = "ID_GRUPO_SLC0001_PRODT", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GrupoSlc0001Prodt grupoSlc0001Prodt;

    public Long getIdGrupoSlc0001LiquidProdt() {
        return idGrupoSlc0001LiquidProdt;
    }

    public void setIdGrupoSlc0001LiquidProdt(Long idGrupoSlc0001LiquidProdt) {
        this.idGrupoSlc0001LiquidProdt = idGrupoSlc0001LiquidProdt;
    }

    @XmlElement(name = "IdentdLinhaBilat", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public String getIdentdLinhaBilat() {
        return identdLinhaBilat;
    }

    public void setIdentdLinhaBilat(String identdLinhaBilat) {
        this.identdLinhaBilat = identdLinhaBilat;
    }

    @XmlElement(name = "TpDeb_Cred", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public String getTpDebCred() {
        return tpDebCred;
    }

    public void setTpDebCred(String tpDebCred) {
        this.tpDebCred = tpDebCred;
    }

    @XmlElement(name = "ISPBIFCredtd", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public Long getIsPbifCredtd() {
        return isPbifCredtd;
    }

    public void setIsPbifCredtd(Long isPbifCredtd) {
        this.isPbifCredtd = isPbifCredtd;
    }

    @XmlElement(name = "ISPBIFDebtd", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public Long getIsPbifDebtd() {
        return isPbifDebtd;
    }

    public void setIsPbifDebtd(Long isPbifDebtd) {
        this.isPbifDebtd = isPbifDebtd;
    }

    @XmlElement(name = "VlrLanc", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public Double getVlrLanc() {
        return vlrLanc;
    }

    public void setVlrLanc(Double vlrLanc) {
        this.vlrLanc = vlrLanc;
    }

    @XmlElement(name = "CNPJNLiqdantDebtd", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public String getCnpjNLiqdantDebtd() {
        return cnpjNLiqdantDebtd;
    }

    public void setCnpjNLiqdantDebtd(String cnpjNLiqdantDebtd) {
        this.cnpjNLiqdantDebtd = cnpjNLiqdantDebtd;
    }

    @XmlElement(name = "NomCliDebtd", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public String getNomCliDebtd() {
        return nomCliDebtd;
    }

    public void setNomCliDebtd(String nomCliDebtd) {
        this.nomCliDebtd = nomCliDebtd;
    }

    @XmlElement(name = "CNPJNLiqdantCredtd", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public String getCnpjNLiqdantCredtd() {
        return cnpjNLiqdantCredtd;
    }

    public void setCnpjNLiqdantCredtd(String cnpjNLiqdantCredtd) {
        this.cnpjNLiqdantCredtd = cnpjNLiqdantCredtd;
    }

    @XmlElement(name = "NomCliCredtd", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public String getNomCliCredtd() {
        return nomCliCredtd;
    }

    public void setNomCliCredtd(String nomCliCredtd) {
        this.nomCliCredtd = nomCliCredtd;
    }

    @XmlElement(name = "TpTranscSLC", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public Long getTpTranscSlc() {
        return tpTranscSlc;
    }

    public void setTpTranscSlc(Long tpTranscSlc) {
        this.tpTranscSlc = tpTranscSlc;
    }

    public Long getIdGrupoSlc0001Prodt() {
        return idGrupoSlc0001Prodt;
    }

    public void setIdGrupoSlc0001Prodt(Long idGrupoSlc0001Prodt) {
        this.idGrupoSlc0001Prodt = idGrupoSlc0001Prodt;
    }

    public GrupoSlc0001Prodt getGrupoSlc0001Prodt() {
        return grupoSlc0001Prodt;
    }

    public void setGrupoSlc0001Prodt(GrupoSlc0001Prodt grupoSlc0001Prodt) {
        this.grupoSlc0001Prodt = grupoSlc0001Prodt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoSlc0001LiquidProdt that = (GrupoSlc0001LiquidProdt) o;
        return Objects.equals(identdLinhaBilat, that.identdLinhaBilat) &&
                Objects.equals(tpDebCred, that.tpDebCred) &&
                Objects.equals(isPbifCredtd, that.isPbifCredtd) &&
                Objects.equals(isPbifDebtd, that.isPbifDebtd) &&
                Objects.equals(vlrLanc, that.vlrLanc) &&
                Objects.equals(cnpjNLiqdantDebtd, that.cnpjNLiqdantDebtd) &&
                Objects.equals(nomCliDebtd, that.nomCliDebtd) &&
                Objects.equals(cnpjNLiqdantCredtd, that.cnpjNLiqdantCredtd) &&
                Objects.equals(nomCliCredtd, that.nomCliCredtd) &&
                Objects.equals(tpTranscSlc, that.tpTranscSlc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identdLinhaBilat, tpDebCred, isPbifCredtd, isPbifDebtd, vlrLanc, cnpjNLiqdantDebtd,
                nomCliDebtd, cnpjNLiqdantCredtd, nomCliCredtd, tpTranscSlc);
    }

    @Override
    public String toString() {
        return "GrupoSlc0001LiquidProdt{" +
                "identdLinhaBilat='" + identdLinhaBilat + '\'' +
                ", tpDebCred='" + tpDebCred + '\'' +
                ", ispbifCredtd=" + isPbifCredtd +
                ", ispbifDebtd=" + isPbifDebtd +
                ", vlrLanc=" + vlrLanc +
                ", cnpjNLiqdantDebtd='" + cnpjNLiqdantDebtd + '\'' +
                ", nomCliDebtd='" + nomCliDebtd + '\'' +
                ", cnpjNLiqdantCredtd='" + cnpjNLiqdantCredtd + '\'' +
                ", nomCliCredtd='" + nomCliCredtd + '\'' +
                ", tpTranscSlc=" + tpTranscSlc +
                '}';
    }
}
