package br.com.desafio.xml.desafioxml.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TA_GRUPO_SLC0001_LIQUID", schema = "DESAFIO_XML")
public class GrupoSlc0001Liquid {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_GRUPO_SLC0001_LIQUID")
    @SequenceGenerator(name = "SQ_GRUPO_SLC0001_LIQUID", schema = "DESAFIO_XML", sequenceName = "SQ_GRUPO_SLC0001_LIQUID",
            allocationSize = 1)
    @Column(name = "ID_GRUPO_SLC0001_LIQUID", nullable = false)
    private Long idGrupoSlc0001Liquid;

    @Column(name = "DT_LIQUID")
    private String dtLiquid;
    @Column(name = "NUM_SEQ_CICLO_LIQUID")
    private Long numSeqCicloLiquid;

    @OneToMany(mappedBy = "grupoSlc0001Liquid", fetch = FetchType.LAZY)
    private List<GrupoSlc0001Prodt> grupoSlc0001Prodt;

    @Column(name = "ID_SLC0001")
    private Long idSlc0001;

    @JsonIgnore
    @JoinColumn(name = "ID_SLC0001", referencedColumnName = "ID_SLC0001", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Slc0001 slc0001;

    public GrupoSlc0001Liquid() {
        grupoSlc0001Prodt = new ArrayList<>();
    }

    public Long getIdGrupoSlc0001Liquid() {
        return idGrupoSlc0001Liquid;
    }

    public void setIdGrupoSlc0001Liquid(Long idGrupoSlc0001Liquid) {
        this.idGrupoSlc0001Liquid = idGrupoSlc0001Liquid;
    }

    @XmlElement(name = "DtLiquid", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public String getDtLiquid() {
        return dtLiquid;
    }

    public void setDtLiquid(String dtLiquid) {
        this.dtLiquid = dtLiquid;
    }

    @XmlElement(name = "NumSeqCicloLiquid", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public Long getNumSeqCicloLiquid() {
        return numSeqCicloLiquid;
    }

    public void setNumSeqCicloLiquid(Long numSeqCicloLiquid) {
        this.numSeqCicloLiquid = numSeqCicloLiquid;
    }

    @XmlElement(name = "Grupo_SLC0001_Prodt", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public List<GrupoSlc0001Prodt> getGrupoSlc0001Prodt() {
        return grupoSlc0001Prodt;
    }

    public void setGrupoSlc0001Prodt(List<GrupoSlc0001Prodt> grupoSlc0001Prodt) {
        this.grupoSlc0001Prodt = grupoSlc0001Prodt;
    }

    public Long getIdSlc0001() {
        return idSlc0001;
    }

    public void setIdSlc0001(Long idSlc0001) {
        this.idSlc0001 = idSlc0001;
    }

    public Slc0001 getSlc0001() {
        return slc0001;
    }

    public void setSlc0001(Slc0001 slc0001) {
        this.slc0001 = slc0001;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoSlc0001Liquid that = (GrupoSlc0001Liquid) o;
        return Objects.equals(dtLiquid, that.dtLiquid) &&
                Objects.equals(numSeqCicloLiquid, that.numSeqCicloLiquid) &&
                Objects.equals(grupoSlc0001Prodt, that.grupoSlc0001Prodt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dtLiquid, numSeqCicloLiquid, grupoSlc0001Prodt);
    }

    @Override
    public String toString() {
        return "GrupoSlc0001Liquid{" +
                "dtLiquid='" + dtLiquid + '\'' +
                ", numSeqCicloLiquid=" + numSeqCicloLiquid +
                ", grupoSlc0001Prodt=" + grupoSlc0001Prodt +
                '}';
    }
}
