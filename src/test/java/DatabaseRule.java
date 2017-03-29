import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/maryjanes_review_site_test", null, null);
  }

  public void tearDown() {
    try (Connection con = DB.sql2o.open()) {
      String deleteStonersQuery = "DELETE FROM stoners *;";
      String deleteFlavorsQuery = "DELETE FROM flavors *;";
      String deleteStrainsQuery = "DELETE FROM strains *;";
      con.createQuery(deleteStonersQuery).executeUpdate();
      con.createQuery(deleteFlavorsQuery).executeUpdate();
      con.createQuery(deleteStrainsQuery).executeUpdate();
    }
  }
}
