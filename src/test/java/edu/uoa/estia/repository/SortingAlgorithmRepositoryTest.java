package edu.uoa.estia.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.uoa.estia.domain.PropertyType;
import edu.uoa.estia.domain.SortingAlgorithm;
import edu.uoa.estia.domain.UserType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = {"classpath:META-INF/spring/test-data-source.xml", "classpath:META-INF/spring/spring-repository.xml"})
@Transactional
public class SortingAlgorithmRepositoryTest  {
	
	@Autowired
	private SortingAlgorithmRepository sortingAlgorithmRepository;
	
	@Test
	public void testSave() {
		SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
		sortingAlgorithm.setDescription("Bubble Sort");
		Assert.assertNull(sortingAlgorithm.getId());
		sortingAlgorithm = sortingAlgorithmRepository.saveAndFlush(sortingAlgorithm);
		Assert.assertNotNull(sortingAlgorithm.getId());
	}
	
	@Test
	public void testFindAll() {
		Assert.assertEquals(2, sortingAlgorithmRepository.findAll().size());
	}
}
