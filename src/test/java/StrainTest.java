import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StrainTest {

  // rule for setUp(connection to DB) and tearDown(clearing DB table data)
  @Rule
  public DatabaseRule database = new DatabaseRule();

  // test for constructor
  @Test
  public void constructor_createsStrainObject_true() {
    Strain strain = new Strain("Boss OG", 1);
    assertEquals(true, strain instanceof Strain);
  }

  // test for getting name
  @Test
  public void getName_returnsName_Sativa() {
    Strain strain = new Strain("Boss OG", 1);
    assertEquals("Boss OG", strain.getName());
  }

  // test for getting classification id
  @Test
  public void getClassificationId_returnsId() {
    Strain strain = new Strain("Boss OG", 1);
    assertEquals(1, strain.getClassificationId());
  }

  // test for saving new strain to db
  @Test
  public void save_savesStrainObject() {
    Strain strain = new Strain("Boss OG", 1);
    strain.save();
    Strain strain2 = new Strain("Boss OG", 1);
    strain2.save();
    assertEquals(strain, Strain.all().get(0));
    // assertEquals(strain2, Strain.all().get(1));
  }



  // // test for find method
  // @Test
  // public void find_returnStrainObject() {
  //   Strain strain = new Strain("Columbian Coal Miner", 2);
  //   static rain.save();
  //
  // }








}
