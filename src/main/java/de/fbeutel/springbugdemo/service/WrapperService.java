package de.fbeutel.springbugdemo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import de.fbeutel.springbugdemo.model.Bar;
import de.fbeutel.springbugdemo.model.Foo;
import de.fbeutel.springbugdemo.model.SpecificIdAware;
import de.fbeutel.springbugdemo.model.Wrapper;
import de.fbeutel.springbugdemo.repository.WrapperRepository;

@Service
public class WrapperService {

  private final WrapperRepository wrapperRepository;

  public WrapperService(final WrapperRepository wrapperRepository) {
    this.wrapperRepository = wrapperRepository;
  }

  @PostConstruct
  public void initData() {
    this.wrapperRepository.deleteAll();
    this.wrapperRepository.insert(Wrapper.builder()
      .id(new ObjectId().toString())
      .type("foo")
      .data(Foo.builder()
        .fooName("foooo")
        .specificId("4711")
        .build())
      .build());
    this.wrapperRepository.insert(Wrapper.builder()
      .id(new ObjectId().toString())
      .type("bar")
      .data(Bar.builder()
        .barName("barrrr")
        .build())
      .build());

    this.wrapperRepository.insertRawJson("{\n" +
      "  \"_id\": \"4711\",\n" +
      "  \"type\": \"unknownType\",\n" +
      "  \"data\": {\n" +
      "    \"irrelevant\": \"data\",\n" +
      "    \"_class\": \"de.fbeutel.UnknownClass\"\n" +
      "  }\n" +
      "}");
  }

  public List<Wrapper<? extends SpecificIdAware>> findAll() {
    return wrapperRepository.findAll();
  }
}
