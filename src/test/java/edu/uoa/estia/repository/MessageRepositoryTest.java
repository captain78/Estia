package edu.uoa.estia.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.uoa.estia.domain.Message;
import edu.uoa.estia.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"classpath:META-INF/spring/test-data-source.xml", "classpath:META-INF/spring/spring-repository.xml"})
public class MessageRepositoryTest  {
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Test
	public void testMe() {
		Message message = new Message();
	}

}
