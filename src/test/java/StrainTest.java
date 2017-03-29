import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StrainTest {

  // rule for setUp(connection to DB) and tearDown(clearing DB table data)
  @Rule
  public DatabaseRule database = new DatabaseRule();

}
