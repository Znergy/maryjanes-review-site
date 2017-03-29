import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/rose_city_flower_test", null, null);
  }

  @Override
  protected void after() {
    try (Connection con = DB.sql2o.open()) {
      String deleteStonersQuery = "DELETE FROM stoners *;";
      String deleteStrainsQuery = "DELETE FROM strains *;";
      String deleteClassificationsQuery = "DELETE FROM classifications *;";
      con.createQuery(deleteStonersQuery).executeUpdate();
      con.createQuery(deleteStrainsQuery).executeUpdate();
      con.createQuery(deleteClassificationsQuery).executeUpdate();
    }
  }
}
