package org.ei.drishti.dto.register;

import java.util.List;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class ECRegisterDTO
{
  @JsonProperty
  private List<ECRegisterEntryDTO> ecRegisterEntries;
  
  public ECRegisterDTO(List<ECRegisterEntryDTO> ecRegisterEntries)
  {
    this.ecRegisterEntries = ecRegisterEntries;
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
