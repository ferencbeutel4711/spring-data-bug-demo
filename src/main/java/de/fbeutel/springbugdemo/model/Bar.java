package de.fbeutel.springbugdemo.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Bar implements SpecificIdAware {

  private final String barName;

  @Override
  public String getSpecificId() {
    return new StringBuilder().append(barName).reverse().toString();
  }
}
