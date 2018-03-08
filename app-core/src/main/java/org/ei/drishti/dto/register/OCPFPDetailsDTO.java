package org.ei.drishti.dto.register;

import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class OCPFPDetailsDTO
{
  @JsonProperty
  private String fpAcceptanceDate;
  @JsonProperty
  private List<Map<String, String>> refills;
  @JsonProperty
  private String lmpDate;
  @JsonProperty
  private String uptResult;
  
  public OCPFPDetailsDTO(String fpAcceptanceDate, List<Map<String, String>> refills, String lmpDate, String uptResult)
  {
    this.fpAcceptanceDate = fpAcceptanceDate;
    this.refills = refills;
    this.lmpDate = lmpDate;
    this.uptResult = uptResult;
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
