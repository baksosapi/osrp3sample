package org.ei.drishti.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class LocationDTO
{
  @JsonProperty
  private String sub_center;
  @JsonProperty
  private String phc;
  @JsonProperty
  private String taluka;
  @JsonProperty
  private String district;
  @JsonProperty
  private String state;
  
  public LocationDTO(String sub_center, String phc, String taluka, String district, String state)
  {
    this.state = state;
    this.district = district;
    this.taluka = taluka;
    this.phc = phc;
    this.sub_center = sub_center;
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
