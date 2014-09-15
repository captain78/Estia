package edu.uoa.estia.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

import edu.uoa.estia.domain.Mytable;

@ContextConfiguration (locations = {"classpath:test-applicationContext-data.xml"})
public class GenericTests {

	@Autowired
	private MytableRepository mytableRepository;

	final GeometryFactory gf = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING));
	
	public void testSave() {
		Mytable p = new Mytable();
		p.setMyint(new Integer(1));
		p.setMytext("my ελληνικό text");
		Point point = gf.createPoint(new Coordinate(1000000,1000000));
		p.setMygeom(point);
		mytableRepository.saveAndFlush(p);
		Mytable mt = mytableRepository.findByMytext("my ελληνικό text");
	}
	
	public void testCrypto(){
		String pwd = "password";
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		System.out.println("Clear—>"+ pwd);
		System.out.println("Encrypted—>"+ encoder.encode(pwd));
		System.out.println("Clear—>"+ pwd);
		System.out.println("Encrypted—>"+ encoder.encode(pwd));
		System.out.println("Clear—>"+ pwd);
		System.out.println("Encrypted—>"+ encoder.encode(pwd));
	}
	
	public void testCrypto1(){
		String ep1 = "b38723751e4f1a513e2b772bbf427118a7c8effb8f7bcec520b96f0b79ae7f52f6642b49f77d9f21";
		String ep2 = "f498fb2a0acbdb5e4fa77406a362b4383ea7b50b047178a270c6b85dc1dc87e5f8d8fbf0de412d30";
	    String ep3 = "968878b236e5f6d617b2c94dc3f63fbbd531058458ee9021de62717312ee0f0fd31b2f9cd716b282";
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		long t1 = System.currentTimeMillis();
		System.out.println("password ep1 : "+encoder.matches("password",ep1));
		long t2 = System.currentTimeMillis();
		System.out.println("ep1 match "+(t2-t1)+"ms");
		System.out.println("password ep2 : "+encoder.matches("password",ep2));
		long t3 = System.currentTimeMillis();
		System.out.println("ep1 match "+(t3-t2)+"ms");
		System.out.println("password ep3 : "+encoder.matches("password",ep3));
		long t4 = System.currentTimeMillis();
		System.out.println("ep1 match "+(t4-t3)+"ms");
	}
	
	
	public void testBCrypto(){
		String pwd = "estiapwd";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("Clear—>"+ pwd);
		System.out.println("Encrypted—>"+ encoder.encode(pwd));
		System.out.println("Clear—>"+ pwd);
		System.out.println("Encrypted—>"+ encoder.encode(pwd));
		System.out.println("Clear—>"+ pwd);
		System.out.println("Encrypted—>"+ encoder.encode(pwd));
	}
	
	public void testBCrypto1(){
		String ep1 = "$2a$10$MeYNNbXY4cu8FVq4zr3i.ubtFHpFRiaf1PJC20.f0NcVbvji1qrzC";
		String ep2 = "$2a$10$yWIJFZnIJsIwwxKWp/I0fut4sjcctHzuOdzXQ6fh0TBZoBJAJTWM2";
	    String ep3 = "$2a$10$8cNuW1ZGcL2nK3my74MFp.3MGgRUexEbGdyIyN7TjRWnfDaOIItei";
	    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		long t1 = System.currentTimeMillis();
		System.out.println("password ep1 : "+encoder.matches("estiapwd",ep1));
		long t2 = System.currentTimeMillis();
		System.out.println("ep1 match "+(t2-t1)+"ms");
		System.out.println("password ep2 : "+encoder.matches("estiapwd",ep2));
		long t3 = System.currentTimeMillis();
		System.out.println("ep1 match "+(t3-t2)+"ms");
		System.out.println("password ep3 : "+encoder.matches("estiapwd",ep3));
		long t4 = System.currentTimeMillis();
		System.out.println("ep1 match "+(t4-t3)+"ms");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericTests gt = new GenericTests();
		gt.testBCrypto1();
	}

}
