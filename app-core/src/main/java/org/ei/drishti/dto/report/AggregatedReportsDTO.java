package org.ei.drishti.dto.report;

import java.util.Map;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;
import org.ei.drishti.dto.LocationDTO;

public class AggregatedReportsDTO
{
  @JsonProperty
  private Map<String, Integer> ind;
  @JsonProperty
  private LocationDTO loc;
  
  public AggregatedReportsDTO(Map<String, Integer> indicatorSummary, LocationDTO loc)
  {
    ind = indicatorSummary;
    this.loc = loc;
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
