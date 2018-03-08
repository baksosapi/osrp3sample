package org.ei.drishti.dto.register;

import java.util.Map;
import org.codehaus.jackson.annotate.JsonProperty;

public class ChildRegisterEntryDTO
{
  @JsonProperty
  private String thayiCardNumber;
  @JsonProperty
  private String wifeName;
  @JsonProperty
  private String husbandName;
  @JsonProperty
  private String village;
  @JsonProperty
  private String subCenter;
  @JsonProperty
  private String wifeDOB;
  @JsonProperty
  private String dob;
  @JsonProperty
  private Map<String, String> immunizations;
  @JsonProperty
  private Map<String, String> vitaminADoses;
  
  public ChildRegisterEntryDTO() {}
  
  public ChildRegisterEntryDTO withThayiCardNumber(String thayiCardNumber)
  {
    this.thayiCardNumber = thayiCardNumber;
    return this;
  }
  
  public ChildRegisterEntryDTO withWifeName(String wifeName) {
    this.wifeName = wifeName;
    return this;
  }
  
  public ChildRegisterEntryDTO withHusbandName(String husbandName) {
    this.husbandName = husbandName;
    return this;
  }
  
  public ChildRegisterEntryDTO withVillage(String village) {
    this.village = village;
    return this;
  }
  
  public ChildRegisterEntryDTO withSubCenter(String subCenter) {
    this.subCenter = subCenter;
    return this;
  }
  
  public ChildRegisterEntryDTO withWifeDOB(String wifeDOB) {
    this.wifeDOB = wifeDOB;
    return this;
  }
  
  public ChildRegisterEntryDTO withDOB(String DOB) {
    dob = DOB;
    return this;
  }
  
  public ChildRegisterEntryDTO withImmunizations(Map<String, String> immunizations) {
    this.immunizations = immunizations;
    return this;
  }
  
  public ChildRegisterEntryDTO withVitaminADoses(Map<String, String> vitaminADoses) {
    this.vitaminADoses = vitaminADoses;
    return this;
  }
  
  public boolean equals(Object o)
  {
    return org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(this, o, new String[0]);
  }
  
  public int hashCode()
  {
    return org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode(this, new String[0]);
  }
  
  public String toString()
  {
    return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this);
  }
}
