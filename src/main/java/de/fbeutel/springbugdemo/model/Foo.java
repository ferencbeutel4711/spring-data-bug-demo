package de.fbeutel.springbugdemo.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Foo implements SpecificIdAware {

  private final String fooName;
  private final String specificId;
}
