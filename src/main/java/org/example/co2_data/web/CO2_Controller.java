package org.example.co2_data.web;

import org.example.co2_data.db.Co2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CO2_Controller {

  @Autowired
  private Co2Repository repository;
}
