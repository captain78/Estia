package edu.uoa.estia.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.uoa.estia.domain.UserTypeCodes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"classpath:META-INF/spring/test-data-source.xml", "classpath:META-INF/spring/spring-repository.xml"})
@Transactional
public class UserTypeCodeRepositoryTest  {
	
	@Autowired
	private UserTypeCodeRepository userTypeCodeRepository;
	
	@Test
	public void testSave() {
		UserTypeCodes userTypeCode = new UserTypeCodes();
		userTypeCode.setType("User Type X");
		userTypeCodeRepository.saveAndFlush(userTypeCode);
	}

}
