package de.fbeutel.springbugdemo.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.fbeutel.springbugdemo.model.SpecificIdAware;
import de.fbeutel.springbugdemo.model.Wrapper;
import de.fbeutel.springbugdemo.service.WrapperService;

@RestController
@RequestMapping("/wrapper")
public class WrapperRestController {

  private final WrapperService wrapperService;

  public WrapperRestController(final WrapperService wrapperService) {
    this.wrapperService = wrapperService;
  }

  @GetMapping
  public ResponseEntity<List<Wrapper<? extends SpecificIdAware>>> findAll() {
    return ResponseEntity.ok(wrapperService.findAll());
  }
}
