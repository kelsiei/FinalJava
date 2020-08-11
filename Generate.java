import java.sql.SQLException;

public interface Generate {
    public abstract void generateTable() throws SQLException, ClassNotFoundException;
}
