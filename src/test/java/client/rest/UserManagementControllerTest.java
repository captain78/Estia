package client.rest;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import edu.uoa.estia.domain.User;

public class UserManagementControllerTest {
	
	 @Test
	  public void testRequestByUserID() {
		String userID = "1";
		
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();

	    ResponseEntity<User> entity = template.getForEntity(
	        "http://localhost/estia/services/users/"+userID, User.class);

	    assertNotNull(entity);
	    assertEquals(HttpStatus.OK, entity.getStatusCode());
	    User user = entity.getBody();
	    assertNotNull(user);
	    assertEquals(userID, user.getId().toString());
	   
	  }
}
