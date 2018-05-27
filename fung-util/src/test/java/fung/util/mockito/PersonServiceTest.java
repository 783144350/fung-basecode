package fung.util.mockito;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PersonServiceTest {

    private PersonDao mockDao;
    private PersonService personService;

    @Before
    public void setUp() throws Exception {
        mockDao = mock(PersonDao.class);
        when(mockDao.getPerson(1)).thenReturn(new Person(1, "Person"));
        when(mockDao.update(isA(Person.class))).thenReturn(true);

        personService = new PersonService(mockDao);
    }

    @Test
    public void testUpdate() throws Exception {
//        boolean result = personService.update(1, "new name");
//        assertTrue("must true", result);
        verify(mockDao, times(1)).getPerson(eq(1));
        verify(mockDao, times(1)).update(isA(Person.class));
    }
}