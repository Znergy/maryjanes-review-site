import org.sql2o.*;
import java.util.*;

public class Strain {
  private int id;
  private String name;
  private int id_classifications;

  public Strain(String name, int id_classifications) {
    this.name = name;
    this.id_classifications = id_classifications;
  }

  public String getName() {
    return this.name;
  }

  public int getClassificationId() {
    return this.id_classifications;
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO strains (name, id_classifications) VALUES (:name, :id_classifications);";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("id_classifications", this.id_classifications)
      .executeUpdate()
      .getKey();
    }
  }

  public static List<Strain> all() {
    String sql = "SELECT id, name, id_classifications FROM strains;";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Strain.class);

    }
  }
}
