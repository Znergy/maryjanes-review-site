import org.sql2o.*;
import java.util.*;

public class Stoner {
  private int id;
  private String name;
  private String favorite_strain;

  public Stoner(String name, String favorite_strain) {
    this.name = name;
    this.favorite_strain = favorite_strain;
  }

  public String getName() {
    return this.name;
  }

  public String getFavoriteStrain() {
    return this.favorite_strain;
  }

  public int getId() {
    return this.id;
  }

  @Override
  public boolean equals(Object object) {
    if(!(object instanceof Stoner)) {
      return false;
    } else {
      Stoner stoner = (Stoner) object;
      return this.getName().equals(stoner.getName()) && this.getFavoriteStrain().equals(stoner.getFavoriteStrain())
      && this.getId() == stoner.getId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stoners (name, favorite_strain) VALUES (:name, :favorite_strain);";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("favorite_strain", this.favorite_strain)
      .executeUpdate()
      .getKey();
    }
  }

  public static List<Stoner> all() {
    String sql = "SELECT id, name, favorite_strain FROM stoners;";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Stoner.class);
    }
  }

  public static Stoner find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stoners WHERE id = :id;";
      Stoner stoner = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Stoner.class);
      return stoner;
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM stoners WHERE id = :id;";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }


}
