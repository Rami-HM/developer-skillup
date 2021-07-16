package testcase;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class TestJdbcEnc {
	
	protected Logger logger = LogManager.getLogger(this.getClass());
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
		pbeEnc.setPassword("tmzkdlvmffotvha"); // PBE 값(XML PASSWORD설정)
		
	    String url = pbeEnc.encrypt("jdbc:log4jdbc:postgresql://172.16.114.51:5432/portal?currentSchema=horizon_base2");
	    String username = pbeEnc.encrypt("horizon_user");
	    String password = pbeEnc.encrypt("qwer1234");
	 
	    System.out.println("암호화 url : " + url);
	    System.out.println("암호화 username : " + username);
	    System.out.println("암호화 password : " + password);
	    
	    System.out.println("복호화 url : " + pbeEnc.decrypt("r7PYnrQnAgCCMlOt60ze4FMrQ7nXSN0Ty9zR7t+x7yvtK4xL0hrsTr0blrTW57JM9/gkEFFzo7E04QH5SmyzRI1gpc4btw47NFBUmwf0vOXg0Lit9rwHgMO5DcUL1jvQ"));
	    System.out.println("복호화 username : " + pbeEnc.decrypt(username));
	    System.out.println("복호화 password : " + pbeEnc.decrypt(password));
		
	}

}
