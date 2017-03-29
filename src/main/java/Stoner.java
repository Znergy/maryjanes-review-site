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
      return this.getName().equals(stoner.getName()) && this.getFavoriteStrain().equals(stoner.getFavoriteStrain());
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stoners (name, favorite_strain) VALUES (:name, :favorite_strain);";
      con.createQuery(sql)
      .addParameter("name", this.name)
      .addParameter("favorite_strain", this.favorite_strain)
      .executeUpdate();
    }
  }

  public static List<Stoner> all() {
    String sql = "SELECT id, name, favorite_strain FROM stoners;";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Stoner.class);
    }
  }



}
