package org.ei.drishti.dto.register;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class IUDFPDetailsDTO
{
  @JsonProperty
  private String fpAcceptanceDate;
  @JsonProperty
  private String iudPlace;
  @JsonProperty
  private String lmpDate;
  @JsonProperty
  private String uptResult;
  
  public IUDFPDetailsDTO(String fpAcceptanceDate, String iudPlace, String lmpDate, String uptResult)
  {
    this.fpAcceptanceDate = fpAcceptanceDate;
    this.iudPlace = iudPlace;
    this.lmpDate = lmpDate;
    this.uptResult = uptResult;
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
