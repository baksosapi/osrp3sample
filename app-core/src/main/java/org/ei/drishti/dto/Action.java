package org.ei.drishti.dto;

import java.util.Map;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;

public class Action
{
  @JsonProperty
  private String caseID;
  @JsonProperty
  private Map<String, String> data;
  @JsonProperty
  private String actionTarget;
  @JsonProperty
  private String actionType;
  @JsonProperty
  private String timeStamp;
  @JsonProperty
  private Boolean isActionActive;
  @JsonProperty
  private Map<String, String> details;
  
  public Action(String caseID, String actionTarget, String actionType, Map<String, String> data, String timeStamp, Boolean isActionActive, Map<String, String> details)
  {
    this.caseID = caseID;
    this.data = data;
    this.timeStamp = timeStamp;
    this.actionTarget = actionTarget;
    this.actionType = actionType;
    this.isActionActive = isActionActive;
    this.details = details;
  }
  
  public Action() {}
  
  public String caseID()
  {
    return caseID;
  }
  
  public String target() {
    return actionTarget;
  }
  
  public String type() {
    return actionType;
  }
  
  public Boolean isActionActive() {
    return isActionActive;
  }
  
  public String index() {
    return timeStamp;
  }
  
  public String get(String key) {
    return (String)data.get(key);
  }
  
  public Map<String, String> data() {
    return data;
  }
  
  public Map<String, String> details() {
    return details;
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
