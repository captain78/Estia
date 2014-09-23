package edu.uoa.estia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vividsolutions.jts.geom.Point;

import edu.uoa.estia.domain.Property;
import edu.uoa.estia.domain.PropertyType;

@Repository
@Transactional(readOnly = true) 
public interface PropertyRepository extends JpaRepository<Property, Integer> {

	Property findByUserId(Integer userid);
	
	Property findByType(PropertyType type);
	
	Property findByType(String type);
	
	Property findByTopothesia(Point topothesia);
	

}