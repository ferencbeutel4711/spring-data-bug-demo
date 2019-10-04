package de.fbeutel.springbugdemo.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class UntypedData implements SpecificIdAware {

  @Override
  public String getSpecificId() {
    return null;
  }
}
