package fung.util.mockito;

public interface PersonDao {
    Person getPerson(int id);
    boolean update(Person person);
}
