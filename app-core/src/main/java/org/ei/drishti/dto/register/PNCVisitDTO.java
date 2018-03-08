package org.ei.drishti.dto.register;

import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class PNCVisitDTO
{
  @JsonProperty
  private String date;
  @JsonProperty
  private String person;
  @JsonProperty
  private String place;
  @JsonProperty
  private String difficulties;
  @JsonProperty
  private String abdominalProblems;
  @JsonProperty
  private String vaginalProblems;
  @JsonProperty
  private String urinalProblems;
  @JsonProperty
  private String breastProblems;
  @JsonProperty
  private List<Map<String, String>> childrenDetails;
  
  public PNCVisitDTO() {}
  
  public PNCVisitDTO withDate(String date)
  {
    this.date = date;
    return this;
  }
  
  public PNCVisitDTO withPerson(String person) {
    this.person = person;
    return this;
  }
  
  public PNCVisitDTO withPlace(String place) {
    this.place = place;
    return this;
  }
  
  public PNCVisitDTO withDifficulties(String difficulties) {
    this.difficulties = difficulties;
    return this;
  }
  
  public PNCVisitDTO withAbdominalProblems(String abdominalProblems) {
    this.abdominalProblems = abdominalProblems;
    return this;
  }
  
  public PNCVisitDTO withVaginalProblems(String vaginalProblems) {
    this.vaginalProblems = vaginalProblems;
    return this;
  }
  
  public PNCVisitDTO withUrinalProblems(String urinalProblems) {
    this.urinalProblems = urinalProblems;
    return this;
  }
  
  public PNCVisitDTO withBreastProblems(String breastProblems) {
    this.breastProblems = breastProblems;
    return this;
  }
  
  public PNCVisitDTO withChildrenDetails(List<Map<String, String>> childrenDetails) {
    this.childrenDetails = childrenDetails;
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
    return ToStringBuilder.reflectionToString(this);
  }
}
