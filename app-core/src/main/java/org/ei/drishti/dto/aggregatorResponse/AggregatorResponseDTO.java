package org.ei.drishti.dto.aggregatorResponse;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class AggregatorResponseDTO
{
  @JsonProperty
  private String indicator;
  @JsonProperty
  private Integer nrhm_report_indicator_count;
  
  public AggregatorResponseDTO(String indicator, Integer nrhm_report_indicator_count)
  {
    this.indicator = indicator;
    this.nrhm_report_indicator_count = nrhm_report_indicator_count;
  }
  
  public String indicator() {
    return indicator;
  }
  
  public Integer count() {
    return nrhm_report_indicator_count;
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
