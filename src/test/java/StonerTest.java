import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StonerTest {

  // rule for setUp(connection to DB) and tearDown(clearing DB table data)
  @Rule
  public DatabaseRule database = new DatabaseRule();

  // test for constructor
  @Test
  public void constructor_createsStonerObject_true() {
    Stoner stoner = new Stoner("Creed", "Sativa");
    assertEquals(true, stoner instanceof Stoner);
  }

  // test for name getter
  @Test
  public void getName_returnsName_Creed() {
    Stoner stoner = new Stoner("Creed", "Sativa");
    assertEquals("Creed", stoner.getName());
  }

  // test for id getter
  @Test
  public void getId_returnsId_0() {
    Stoner stoner = new Stoner("Creed", "Sativa");
    assertEquals(0, stoner.getId());
  }

  // test for favorite_strain getter
  @Test
  public void getFavoriteStrain_returnsStrain_Sativa() {
    Stoner stoner = new Stoner("Creed", "Sativa");
    assertEquals("Sativa", stoner.getFavoriteStrain());
  }

  // test for save method (overwrite .equals)
  @Test
  public void save_savesStonerToDatabase_true() {
    Stoner stoner = new Stoner("Creed", "Sativa");
    stoner.save();
    Stoner stoner2 = new Stoner("Creed", "Sativa");
    assertEquals(true ,stoner.equals(stoner2));
  }

}
