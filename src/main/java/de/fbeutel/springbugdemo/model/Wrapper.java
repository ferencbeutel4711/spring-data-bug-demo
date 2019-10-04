package de.fbeutel.springbugdemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Builder;
import lombok.Value;

@Value
@Document("wrapper")
@Builder(toBuilder = true)
public class Wrapper<T extends SpecificIdAware> {

  @Id
  private final String id;
  private final String type;

  @JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
    property = "type",
    defaultImpl = UntypedData.class)
  @JsonSubTypes({
                  @JsonSubTypes.Type(value = Foo.class, name = "foo"),
                  @JsonSubTypes.Type(value = Bar.class, name = "bar")
                })
  private final T data;
}
