package org.ei.drishti.dto.form;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class FormSubmissionDTO
{
  @JsonProperty
  private String anmId;
  @JsonProperty
  private String instanceId;
  @JsonProperty
  private String entityId;
  @JsonProperty
  private String formName;
  @JsonProperty
  private String formInstance;
  @JsonProperty
  private String clientVersion;
  @JsonProperty
  private String serverVersion;
  @JsonProperty
  private String formDataDefinitionVersion;
  
  public FormSubmissionDTO(String anmId, String instanceId, String entityId, String formName, String formInstance, String clientVersion, String formDataDefinitionVersion)
  {
    this.anmId = anmId;
    this.instanceId = instanceId;
    this.entityId = entityId;
    this.formName = formName;
    this.formInstance = formInstance;
    this.clientVersion = clientVersion;
    this.formDataDefinitionVersion = formDataDefinitionVersion;
  }
  
  public FormSubmissionDTO withServerVersion(String version) {
    serverVersion = version;
    return this;
  }
  
  public String anmId() {
    return anmId;
  }
  
  public String instanceId() {
    return instanceId;
  }
  
  public String entityId() {
    return entityId;
  }
  
  public String formName() {
    return formName;
  }
  
  public String instance() {
    return formInstance;
  }
  
  public String clientVersion() {
    return clientVersion;
  }
  
  public String formDataDefinitionVersion() {
    return formDataDefinitionVersion;
  }
  
  public String serverVersion() {
    return serverVersion;
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
