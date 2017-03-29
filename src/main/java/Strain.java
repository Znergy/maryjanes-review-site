import org.sql2o.*;

public class Strain {
  private int id;
  private String name;
  private int id_classifications;

  public Strain(String name, int id_classifications) {
    this.name = name;
    this.id_classifications = id_classifications;
  }

  

}
