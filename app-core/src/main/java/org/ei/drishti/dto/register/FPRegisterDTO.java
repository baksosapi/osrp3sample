package org.ei.drishti.dto.register;

import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;





public class FPRegisterDTO
{
  @JsonProperty
  private List<IUDRegisterEntryDTO> iudRegisterEntries;
  @JsonProperty
  private List<CondomRegisterEntryDTO> condomRegisterEntries;
  @JsonProperty
  private List<OCPRegisterEntryDTO> ocpRegisterEntries;
  @JsonProperty
  private List<MaleSterilizationRegisterEntryDTO> maleSterilizationRegisterEntries;
  @JsonProperty
  private List<FemaleSterilizationRegisterEntryDTO> femaleSterilizationRegisterEntries;
  @JsonProperty
  private Integer reportingYear;
  
  public FPRegisterDTO(List<IUDRegisterEntryDTO> iudRegisterEntries, List<CondomRegisterEntryDTO> condomRegisterEntries, List<OCPRegisterEntryDTO> ocpRegisterEntries, List<MaleSterilizationRegisterEntryDTO> maleSterilizationRegisterEntries, List<FemaleSterilizationRegisterEntryDTO> femaleSterilizationRegisterEntries, Integer reportingYear)
  {
    this.iudRegisterEntries = iudRegisterEntries;
    this.condomRegisterEntries = condomRegisterEntries;
    this.ocpRegisterEntries = ocpRegisterEntries;
    this.maleSterilizationRegisterEntries = maleSterilizationRegisterEntries;
    this.femaleSterilizationRegisterEntries = femaleSterilizationRegisterEntries;
    this.reportingYear = reportingYear;
  }
  
  public boolean equals(Object o)
  {
    return EqualsBuilder.reflectionEquals(this, o, new String[0]);
  }
  
  public int hashCode()
  {
    return HashCodeBuilder.reflectionHashCode(this, new String[0]);
  }
  
  public String toString()
  {
    return ToStringBuilder.reflectionToString(this);
  }
}
