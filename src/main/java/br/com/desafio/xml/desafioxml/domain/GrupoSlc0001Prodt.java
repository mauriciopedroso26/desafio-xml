package br.com.desafio.xml.desafioxml.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TA_GRUPO_SLC0001_PRODT", schema = "DESAFIO_XML")
public class GrupoSlc0001Prodt {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_GRUPO_SLC0001_PRODT")
    @SequenceGenerator(name = "SQ_GRUPO_SLC0001_PRODT", schema = "DESAFIO_XML", sequenceName = "SQ_GRUPO_SLC0001_PRODT",
            allocationSize = 1)
    @Column(name = "ID_GRUPO_SLC0001_PRODT", nullable = false)
    private Long idGrupoSlc0001Prodt;

    @Column(name = "COD_PRODT")
    private String codProdt;

    @OneToMany(mappedBy = "grupoSlc0001Prodt", fetch = FetchType.LAZY)
    private List<GrupoSlc0001LiquidProdt> grupoSlc0001LiquidProdt;

    @Column(name = "ID_GRUPO_SLC0001_LIQUID")
    private Long idGrupoSlc0001Liquid;

    @JsonIgnore
    @JoinColumn(name = "ID_GRUPO_SLC0001_LIQUID", referencedColumnName = "ID_GRUPO_SLC0001_LIQUID", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GrupoSlc0001Liquid grupoSlc0001Liquid;

    public GrupoSlc0001Prodt() {
        grupoSlc0001LiquidProdt = new ArrayList<>();
    }

    public Long getIdGrupoSlc0001Prodt() {
        return idGrupoSlc0001Prodt;
    }

    public void setIdGrupoSlc0001Prodt(Long idGrupoSlc0001Prodt) {
        this.idGrupoSlc0001Prodt = idGrupoSlc0001Prodt;
    }

    @XmlElement(name = "CodProdt", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public String getCodProdt() {
        return codProdt;
    }

    public void setCodProdt(String codProdt) {
        this.codProdt = codProdt;
    }

    @XmlElement(name = "Grupo_SLC0001_LiquidProdt", namespace="http://www.bcb.gov.br/SPB/SLC0001.xsd")
    public List<GrupoSlc0001LiquidProdt> getGrupoSlc0001LiquidProdt() {
        return grupoSlc0001LiquidProdt;
    }

    public void setGrupoSlc0001LiquidProdt(List<GrupoSlc0001LiquidProdt> grupoSlc0001LiquidProdt) {
        this.grupoSlc0001LiquidProdt = grupoSlc0001LiquidProdt;
    }

    public Long getIdGrupoSlc0001Liquid() {
        return idGrupoSlc0001Liquid;
    }

    public void setIdGrupoSlc0001Liquid(Long idGrupoSlc0001Liquid) {
        this.idGrupoSlc0001Liquid = idGrupoSlc0001Liquid;
    }

    public GrupoSlc0001Liquid getGrupoSlc0001Liquid() {
        return grupoSlc0001Liquid;
    }

    public void setGrupoSlc0001Liquid(GrupoSlc0001Liquid grupoSlc0001Liquid) {
        this.grupoSlc0001Liquid = grupoSlc0001Liquid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoSlc0001Prodt that = (GrupoSlc0001Prodt) o;
        return Objects.equals(codProdt, that.codProdt) &&
                Objects.equals(grupoSlc0001LiquidProdt, that.grupoSlc0001LiquidProdt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codProdt, grupoSlc0001LiquidProdt);
    }

    @Override
    public String toString() {
        return "GrupoSlc0001Prodt{" +
                "codProdt='" + codProdt + '\'' +
                ", grupoSlc0001LiquidProdt=" + grupoSlc0001LiquidProdt +
                '}';
    }
}
