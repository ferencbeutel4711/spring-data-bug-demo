package de.fbeutel.springbugdemo.repository;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

public class WrapperRepositoryImpl implements WrapperRepositoryCustom {

  private final MongoTemplate template;

  public WrapperRepositoryImpl(final MongoTemplate template) {
    this.template = template;
  }

  public void insertRawJson(final String s) {
    template.insert(Document.parse(s), "wrapper");
  }
}
