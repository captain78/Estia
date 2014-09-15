package edu.uoa.estia.repository;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.uoa.estia.domain.Akinita;

import com.vividsolutions.jts.geom.Point;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"classpath:test-applicationContext-data.xml"})
@Transactional
public class AkinitaRepositoryTest {
	
	@Autowired
	private AkinitaRepository akinitaRepository;
	
	/*
	@Test
	public void testSave() {
		int numberOfUsers = userRepository.findAll().size();
		user = createJohnDoe();
		Assert.assertNull(user.getId());
		user = userRepository.saveAndFlush(user);
		int expectedNumberOfUsers = numberOfUsers + 1;
		Assert.assertEquals(expectedNumberOfUsers, userRepository.findAll().size());
		Assert.assertNotNull(user);
	}
	
	private User createJohnDoe() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setUsername("johndoe");
		user.setPassword("johndoe");
		user.setEmail("johndoe@gmail.com");
		user.setTelephone("+447123456789");
		user.setType(userTypeRepository.findByType("Enabled"));

		Set<Role> roles = new HashSet<Role>();
		roles.add(roleRepository.findByType("Seller"));
		roles.add(roleRepository.findByType("Lessor"));
		user.setRoles(roles);
		return user;
	}

	@Test
	public void testFindAll() {
		Assert.assertEquals(1, userRepository.findAll().size());
	}
	*/
	
	@Test
	public void testFindByIdioktitis() {
		Akinita ak = akinitaRepository.findByIdioktitis("Alkionis ke Monterno Theatro");
		Assert.assertNotNull(ak);
		Point topo = ak.getTopothesia();
	    Assert.assertNotNull(topo);
	}
	


}
