package org.ei.drishti.dto;

public enum AlertStatus {
  upcoming("upcoming"),  normal("normal"),  urgent("urgent"),  inProcess("inProcess"),  complete("complete");
  
  private String value;
  
  private AlertStatus(String value) {
    this.value = value;
  }
  
  public static AlertStatus from(String alertStatus) {
    return valueOf(alertStatus);
  }
  
  public String value() {
    return value;
  }
}
