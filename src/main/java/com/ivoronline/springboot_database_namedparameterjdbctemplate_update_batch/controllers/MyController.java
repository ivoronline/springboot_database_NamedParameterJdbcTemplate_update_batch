package com.ivoronline.springboot_database_namedparameterjdbctemplate_update_batch.controllers;

import com.ivoronline.springboot_database_namedparameterjdbctemplate_update_batch.dto.PersonDTO;
import com.ivoronline.springboot_database_namedparameterjdbctemplate_update_batch.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired private MyService myService;

  //=========================================================================================================
  // UPDATE
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/update")
  public int[] update() {
    int[]  success = myService.update(createRecords());
    return success;
  }

  //=========================================================================================================
  // CREATE RECORDS
  //=========================================================================================================
  public List<PersonDTO> createRecords() {

    //CREATE RECORDS TO INSERT
    PersonDTO       jack    = new PersonDTO(1, "John  New", 11);
    PersonDTO       jill    = new PersonDTO(2, "Bill  New", 22);
    PersonDTO       susan   = new PersonDTO(3, "Susan New", 33);

    //CREATE LIST
    List<PersonDTO> records = new ArrayList<>();
                    records.add(jack);
                    records.add(jill);
                    records.add(susan);

    //RETURN LIST
    return records;

  }

}

