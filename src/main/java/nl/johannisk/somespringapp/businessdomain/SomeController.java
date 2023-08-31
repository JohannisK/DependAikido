package nl.johannisk.somespringapp.businessdomain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SomeController {

  @GetMapping("{someId}")
  public List<String> getBySomeId(@PathVariable String someId, JdbcTemplate jdbcTemplate) {
    String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES where id=" + someId;
    return jdbcTemplate.query(query, (rs, rowNum) -> rs.getString(0));
  }
}
