package org.ei.drishti.dto.register;

import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class CondomFPDetailsDTO
{
  @JsonProperty
  private String fpAcceptanceDate;
  @JsonProperty
  private List<Map<String, String>> refills;
  
  public CondomFPDetailsDTO(String fpAcceptanceDate, List<Map<String, String>> refills)
  {
    this.fpAcceptanceDate = fpAcceptanceDate;
    this.refills = refills;
  }
  
  public boolean equals(Object o)
  {
    return org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(this, o, new String[0]);
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
