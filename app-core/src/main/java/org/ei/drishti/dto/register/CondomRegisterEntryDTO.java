package org.ei.drishti.dto.register;

import org.codehaus.jackson.annotate.JsonProperty;

public class CondomRegisterEntryDTO
{
  @JsonProperty
  private String ecNumber;
  @JsonProperty
  private String wifeName;
  @JsonProperty
  private String husbandName;
  @JsonProperty
  private String village;
  @JsonProperty
  private String subCenter;
  @JsonProperty
  private String wifeAge;
  @JsonProperty
  private String caste;
  @JsonProperty
  private String religion;
  @JsonProperty
  private String numberOfLivingMaleChildren;
  @JsonProperty
  private String numberOfLivingFemaleChildren;
  @JsonProperty
  private String wifeEducationLevel;
  @JsonProperty
  private String husbandEducationLevel;
  @JsonProperty
  private CondomFPDetailsDTO fpDetails;
  
  public CondomRegisterEntryDTO() {}
  
  public String ecNumber() {
    return ecNumber;
  }
  
  public String wifeName() {
    return wifeName;
  }
  
  public String husbandName() {
    return husbandName;
  }
  
  public String village() {
    return village;
  }
  
  public String subCenter() {
    return subCenter;
  }
  
  public String wifeAge() {
    return wifeAge;
  }
  
  public String caste() {
    return caste;
  }
  
  public String religion() {
    return religion;
  }
  
  public String numberOfLivingMaleChildren() {
    return numberOfLivingMaleChildren;
  }
  
  public String numberOfLivingFemaleChildren() {
    return numberOfLivingFemaleChildren;
  }
  
  public String wifeEducationLevel() {
    return wifeEducationLevel;
  }
  
  public String husbandEducationLevel() {
    return husbandEducationLevel;
  }
  
  public CondomFPDetailsDTO fpDetails() {
    return fpDetails;
  }
  
  public CondomRegisterEntryDTO withEcNumber(String ecNumber) {
    this.ecNumber = ecNumber;
    return this;
  }
  
  public CondomRegisterEntryDTO withWifeName(String wifeName) {
    this.wifeName = wifeName;
    return this;
  }
  
  public CondomRegisterEntryDTO withHusbandName(String husbandName) {
    this.husbandName = husbandName;
    return this;
  }
  
  public CondomRegisterEntryDTO withVillage(String village) {
    this.village = village;
    return this;
  }
  
  public CondomRegisterEntryDTO withSubCenter(String subCenter) {
    this.subCenter = subCenter;
    return this;
  }
  
  public CondomRegisterEntryDTO withWifeAge(String wifeAge) {
    this.wifeAge = wifeAge;
    return this;
  }
  
  public CondomRegisterEntryDTO withCaste(String caste) {
    this.caste = caste;
    return this;
  }
  
  public CondomRegisterEntryDTO withReligion(String religion) {
    this.religion = religion;
    return this;
  }
  
  public CondomRegisterEntryDTO withNumberOfLivingMaleChildren(String numberOfLivingMaleChildren) {
    this.numberOfLivingMaleChildren = numberOfLivingMaleChildren;
    return this;
  }
  
  public CondomRegisterEntryDTO withNumberOfLivingFemaleChildren(String numberOfLivingFemaleChildren) {
    this.numberOfLivingFemaleChildren = numberOfLivingFemaleChildren;
    return this;
  }
  
  public CondomRegisterEntryDTO withWifeEducationLevel(String wifeEducationLevel) {
    this.wifeEducationLevel = wifeEducationLevel;
    return this;
  }
  
  public CondomRegisterEntryDTO withHusbandEducationLevel(String husbandEducationLevel) {
    this.husbandEducationLevel = husbandEducationLevel;
    return this;
  }
  
  public CondomRegisterEntryDTO withFpDetails(CondomFPDetailsDTO fpDetails) {
    this.fpDetails = fpDetails;
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
