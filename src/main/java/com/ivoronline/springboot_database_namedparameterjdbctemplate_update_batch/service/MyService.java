package com.ivoronline.springboot_database_namedparameterjdbctemplate_update_batch.service;

import com.ivoronline.springboot_database_namedparameterjdbctemplate_update_batch.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  //=========================================================================================================
  // UPDATE
  //=========================================================================================================
  public int[] update(List<PersonDTO> records) {

    String sql = "UPDATE PERSON SET NAME = :name, age = :age WHERE ID = :id"; //DTO Properties

    SqlParameterSource[] parameters = SqlParameterSourceUtils.createBatch(records.toArray());

    return namedParameterJdbcTemplate.batchUpdate(sql, parameters);

  }

}
