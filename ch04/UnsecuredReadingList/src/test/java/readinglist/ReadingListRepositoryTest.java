package readinglist;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ReadingListRepositoryTest {

  @Autowired
  private ReadingListRepository repo;
  
  @Test
  @Transactional
  @Rollback(false)
  public void saveABook() throws Exception {
    assertEquals(0, repo.findAll().size());
    
    Book book = new Book();
    book.setTitle("TITLE");
    book.setDescription("DESCRIPTION");
    book.setAuthor("AUTHOR");
    book.setIsbn("1234567890");
    book.setReader("reader");    
    Book saved = repo.save(book);

    Book found = repo.findById(saved.getId()).orElse(null);
    assertEquals(saved.getId(), found.getId());
    assertEquals("TITLE", found.getTitle());
    assertEquals("DESCRIPTION", found.getDescription());
    assertEquals("AUTHOR", found.getAuthor());
    assertEquals("1234567890", found.getIsbn());
    assertEquals("reader", found.getReader());
  }
  
}
