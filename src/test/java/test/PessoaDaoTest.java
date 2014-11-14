package test;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.lopes.dao.PessoaDAOJDBC;
import br.com.lopes.model.PessoaFisica;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
"file:src/main/webapp/WEB-INF/spring/spring-servlet.xml"
})
public class PessoaDaoTest {

	@Autowired
	PessoaDAOJDBC dao;
	
	Logger logger = Logger.getLogger(getClass());
	
	@Test
	public void insert() {
	
		PessoaFisica fisica = new PessoaFisica();
		fisica.setNome("Luís");
		fisica.setEmail("teste");
		fisica.setTipo("F");
		
		dao.insert(fisica);
		
		
		//Assert.assertTrue(dao.getTotalClientes() > 0);
		
		
	}
	
	
	
}
