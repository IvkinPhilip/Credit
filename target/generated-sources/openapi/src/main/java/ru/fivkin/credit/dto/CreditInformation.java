package ru.fivkin.credit.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;

/**
 * CreditInformation
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CreditInformation  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("firstname")
  private String firstname;

  @JsonProperty("last name")
  private String lastName;

  @JsonProperty("sumCredit")
  private Double sumCredit;

  @JsonProperty("interestRate")
  private Double interestRate;

  @JsonProperty("loanPeriod")
  private Integer loanPeriod;

  @JsonProperty("dateCredit")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate dateCredit;

  public CreditInformation firstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  /**
   * Get firstname
   * @return firstname
  */
  @ApiModelProperty(value = "")
  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public CreditInformation lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  */
  @ApiModelProperty(value = "")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public CreditInformation sumCredit(Double sumCredit) {
    this.sumCredit = sumCredit;
    return this;
  }

  /**
   * Get sumCredit
   * @return sumCredit
  */
  @ApiModelProperty(value = "")
  public Double getSumCredit() {
    return sumCredit;
  }

  public void setSumCredit(Double sumCredit) {
    this.sumCredit = sumCredit;
  }

  public CreditInformation interestRate(Double interestRate) {
    this.interestRate = interestRate;
    return this;
  }

  /**
   * Get interestRate
   * @return interestRate
  */
  @ApiModelProperty(value = "")
  public Double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(Double interestRate) {
    this.interestRate = interestRate;
  }

  public CreditInformation loanPeriod(Integer loanPeriod) {
    this.loanPeriod = loanPeriod;
    return this;
  }

  /**
   * Get loanPeriod
   * @return loanPeriod
  */
  @ApiModelProperty(value = "")
  public Integer getLoanPeriod() {
    return loanPeriod;
  }

  public void setLoanPeriod(Integer loanPeriod) {
    this.loanPeriod = loanPeriod;
  }

  public CreditInformation dateCredit(LocalDate dateCredit) {
    this.dateCredit = dateCredit;
    return this;
  }

  /**
   * Get dateCredit
   * @return dateCredit
  */
  @ApiModelProperty(value = "")
  public LocalDate getDateCredit() {
    return dateCredit;
  }

  public void setDateCredit(LocalDate dateCredit) {
    this.dateCredit = dateCredit;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditInformation creditInformation = (CreditInformation) o;
    return Objects.equals(this.firstname, creditInformation.firstname) &&
        Objects.equals(this.lastName, creditInformation.lastName) &&
        Objects.equals(this.sumCredit, creditInformation.sumCredit) &&
        Objects.equals(this.interestRate, creditInformation.interestRate) &&
        Objects.equals(this.loanPeriod, creditInformation.loanPeriod) &&
        Objects.equals(this.dateCredit, creditInformation.dateCredit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastName, sumCredit, interestRate, loanPeriod, dateCredit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditInformation {\n");
    
    sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    sumCredit: ").append(toIndentedString(sumCredit)).append("\n");
    sb.append("    interestRate: ").append(toIndentedString(interestRate)).append("\n");
    sb.append("    loanPeriod: ").append(toIndentedString(loanPeriod)).append("\n");
    sb.append("    dateCredit: ").append(toIndentedString(dateCredit)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

