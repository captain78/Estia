package edu.uoa.estia.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.uoa.estia.domain.Message;
import edu.uoa.estia.domain.Property;
import edu.uoa.estia.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"classpath:META-INF/spring/test-data-source.xml", "classpath:META-INF/spring/spring-repository.xml"})
@Transactional
public class MessageRepositoryTest  {
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private PropertyTypeRepository propertyTypeRepository;
	
	@Test
	public void testSave() {
		Message message = new Message();
		message.setMessage("Property is cool");
		
		User user = userRepository.findByUsername("estiauser");
		Property property = new Property();
		property.setUser(user);
		property.setType(propertyTypeRepository.findByType("House"));
		
		propertyRepository.save(property);
	
		message.setProperty(property);
		message.setUser(user);
		
		message = messageRepository.saveAndFlush(message);
		Assert.assertNotNull(message.getId());
	}

}
