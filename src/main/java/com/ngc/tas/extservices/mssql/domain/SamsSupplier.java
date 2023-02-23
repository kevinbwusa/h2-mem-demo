package com.ngc.tas.extservices.mssql.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A SamsSupplier.
 *
 * @author kwhittington
 */
@Entity
// @Table(name = "[SAMS_2020andbeyond]")
// @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
// @SuppressWarnings("common-java:DuplicatedBlocks")
public class SamsSupplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "SupplierName")
    private String supplierName;

    @Id
    @Column(name = "SapID")
    private String supplierId;

    @Column(name = "AverageScoreColor")
    private String averageScoreColor;

    @Column(name = "AverageScore")
    private BigDecimal averageScore;

    @Column(name = "EffectiveDate", columnDefinition = "nvarchar", nullable = false)
    private String effectiveDate;

    @Column(name = "Sector")
    private String sector;

    @Column(name = "Division")
    private String division;

    @Column(name = "Program")
    private String program;

    public String getSupplierName() {
        return this.supplierName;
    }

    public SamsSupplier supplierName(String supplierName) {
        this.setSupplierName(supplierName);
        return this;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierId() {
        return this.supplierId;
    }

    public SamsSupplier supplierId(String supplierId) {
        this.setSupplierId(supplierId);
        return this;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getAverageScoreColor() {
        return this.averageScoreColor;
    }

    public SamsSupplier averageScoreColor(String averageScoreColor) {
        this.setAverageScoreColor(averageScoreColor);
        return this;
    }

    public void setAverageScoreColor(String averageScoreColor) {
        this.averageScoreColor = averageScoreColor;
    }

    public BigDecimal getAverageScore() {
        return this.averageScore;
    }

    public SamsSupplier averageScore(BigDecimal averageScore) {
        this.setAverageScore(averageScore);
        return this;
    }

    public void setAverageScore(BigDecimal averageScore) {
        this.averageScore = averageScore;
    }

    public String getEffectiveDate() {
        return this.effectiveDate;
    }

    public SamsSupplier effectiveDate(String effectiveDate) {
        this.setEffectiveDate(effectiveDate);
        return this;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getSector() {
        return this.sector;
    }

    public SamsSupplier sector(String sector) {
        this.setSector(sector);
        return this;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getDivision() {
        return this.division;
    }

    public SamsSupplier division(String division) {
        this.setDivision(division);
        return this;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getProgram() {
        return this.program;
    }

    public SamsSupplier program(String program) {
        this.setProgram(program);
        return this;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SamsSupplier)) {
            return false;
        }
        return supplierId != null && supplierId.equals(((SamsSupplier) o).supplierId);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SamsSupplier{" +
            // "id=" + getId() +
            ", supplierName='" + getSupplierName() + "'" +
            ", supplierId='" + getSupplierId() + "'" +
            ", averageScoreColor='" + getAverageScoreColor() + "'" +
            ", averageScore=" + getAverageScore() +
            ", effectiveDate='" + getEffectiveDate() + "'" +
            ", sector='" + getSector() + "'" +
            ", division='" + getDivision() + "'" +
            ", program='" + getProgram() + "'" +
            "}";
    }
}
