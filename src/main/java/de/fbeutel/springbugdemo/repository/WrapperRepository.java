package de.fbeutel.springbugdemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.fbeutel.springbugdemo.model.SpecificIdAware;
import de.fbeutel.springbugdemo.model.Wrapper;

public interface WrapperRepository extends MongoRepository<Wrapper<? extends SpecificIdAware>, String>, WrapperRepositoryCustom {

}

interface WrapperRepositoryCustom {

  void insertRawJson(String s);
}
