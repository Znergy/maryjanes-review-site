import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StrainTest {

  // rule for setUp(connection to DB) and tearDown(clearing DB table data)
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void constructor_createsStrainObject_true() {
    Strain sativa = new Strain("Sativa", 1);
    assertEquals(true, sativa instanceof Strain);
  }
}
