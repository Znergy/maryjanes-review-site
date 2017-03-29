import org.sql2o.*;
import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

public class StonerTest {

  // rule for setUp(connection to DB) and tearDown(clearing DB table data)
  @Rule
  public DatabaseRule database = new DatabaseRule();

  // test for constructor
  @Test
  public void constructor_createsStonerObject_true() {
    Stoner stoner = new Stoner("Creed", "OG Kush");
    assertEquals(true, stoner instanceof Stoner);
  }

  // test for name getter
  @Test
  public void getName_returnsName_Creed() {
    Stoner stoner = new Stoner("Creed", "OG Kush");
    assertEquals("Creed", stoner.getName());
  }

  // test for id getter (changed to include db)
  @Test
  public void getId_InstantiateWithAnID() {
    Stoner stoner = new Stoner("Dakota", "NoSql Kush");
    stoner.save();
    assertTrue(stoner.getId() > 0);
  }

  // test for favorite_strain getter
  @Test
  public void getFavoriteStrain_returnsStrain_Sativa() {
    Stoner stoner = new Stoner("Creed", "OG Kush");
    assertEquals("OG Kush", stoner.getFavoriteStrain());
  }

  // test for save method (overwrite .equals)
  @Test
  public void save_savesStonerToDatabase_true() {
    Stoner stoner = new Stoner("Creed", "OG Kush");
    stoner.save();
    Stoner stoner2 = new Stoner("Creed", "OG Kush");
    stoner2.save();
    assertEquals(stoner ,Stoner.all().get(0));
    assertEquals(stoner2 ,Stoner.all().get(1));
  }

  // test if save is assigning unique ids
  @Test
  public void save_assignsIdToObject() {
    Stoner stoner = new Stoner("Creed", "OG Kush");
    stoner.save();
    Stoner savedStoner = Stoner.all().get(0);
    assertEquals(stoner.getId(), savedStoner.getId());
  }

  // test for all method (return List<Stoner>)
  @Test
  public void all_returnListOfStoners_2() {
    Stoner tyler = new Stoner("Tyler", "Boss OG");
    tyler.save();
    Stoner jessica = new Stoner("Jessica", "Purple Hindu Kush");
    jessica.save();
    assertEquals(2, Stoner.all().size());
  }

  // test for find method (pass Id and return correct Stoner)
  // we create two Stoner instances to check
  @Test
  public void find_returnsStonerWithSameId_josh() {
    Stoner chris = new Stoner("Chris", "Bubble Kush");
    chris.save();
    Stoner josh = new Stoner("Josh", "JJ Cumber");
    josh.save();
    assertEquals(josh, Stoner.find(josh.getId()));
  }

  // test for delete method (pass id and delete entry)
  @Test
  public void delete_removesStonerWithSameId() {
    Stoner jake = new Stoner("Jake", "Bean Dip");
    jake.save();
    int jakeId = jake.getId();
    jake.delete();
    assertEquals(null, Stoner.find(jakeId));
  }

  // test for updating name
  @Test
  public void update_updatesStonerName() {
    Stoner stoner = new Stoner("Ryan", "OG Kush");
    stoner.save();
    stoner.updateName("Tyler");
    assertEquals("Tyler", Stoner.find(stoner.getId()).getName());
  }

  // test for updating strain
  @Test
  public void update_updatesStonerFavoriteStrain() {
    Stoner stoner = new Stoner("Jacob", "Black Knight");
    stoner.save();
    stoner.updateFavoriteStrain("Forest, Forest Gump");
    assertEquals("Forest, Forest Gump", Stoner.find(stoner.getId()).getFavoriteStrain());
  }
}
