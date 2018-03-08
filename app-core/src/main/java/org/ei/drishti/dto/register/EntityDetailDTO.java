package org.ei.drishti.dto.register;

import org.codehaus.jackson.annotate.JsonProperty;

public class EntityDetailDTO
{
  @JsonProperty
  private String entityId;
  @JsonProperty
  private String entityType;
  @JsonProperty
  private String thayiCardNumber;
  @JsonProperty
  private String ecNumber;
  @JsonProperty
  private String anmIdentifier;
  
  public EntityDetailDTO() {}
  
  public String anmIdentifier()
  {
    return anmIdentifier;
  }
  
  public String entityID() { return entityId; }
  
  public String entityType()
  {
    return entityType;
  }
  
  public String thayiCardNumber() {
    return thayiCardNumber;
  }
  
  public String ecNumber() {
    return ecNumber;
  }
  
  public EntityDetailDTO withThayiCardNumber(String thayiCardNumber) {
    this.thayiCardNumber = thayiCardNumber;
    return this;
  }
  
  public EntityDetailDTO withECNumber(String ecNumber) {
    this.ecNumber = ecNumber;
    return this;
  }
  
  public EntityDetailDTO withEntityID(String entityId) {
    this.entityId = entityId;
    return this;
  }
  
  public EntityDetailDTO withANMIdentifier(String anmIdentifier) {
    this.anmIdentifier = anmIdentifier;
    return this;
  }
  
  public EntityDetailDTO withEntityType(String type) {
    entityType = type;
    return this;
  }
  
  public boolean equals(Object o) {
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
