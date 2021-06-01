package readinglist;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleWebTest {

  @Value("${local.server.port}")
  private int port;

  @Test(expected=HttpClientErrorException.class)
  public void pageNotFound() {
    try {
      RestTemplate rest = new RestTemplate();
      rest.getForObject("http://localhost:{port}/bogusPage", String.class, port);
      fail("Should result in HTTP 404");
    } catch (HttpClientErrorException e) {
      assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
      throw e;
    }
  }
  
  @Test
  public void testRestTemplate() throws Exception {
    
    TestRestTemplate rest = new TestRestTemplate();
    String s = rest.getForObject("http://localhost:{port}/bogusPage", String.class, port);
    System.out.println(s);
    
  }
  
}
