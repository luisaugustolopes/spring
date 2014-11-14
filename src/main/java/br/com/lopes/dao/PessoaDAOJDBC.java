package br.com.lopes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.lopes.model.Pessoa;
import br.com.lopes.model.PessoaFisica;

@Transactional
@Repository
public class PessoaDAOJDBC {

	
	@Autowired
	DataSource dataSource;
	
	public void insert(Pessoa pessoa){
				
		final String sql = "insert into pessoa (id, nome, email,tipo) values (?,?,?,?)";
		
		PreparedStatement statement;
		try {
			statement = dataSource.getConnection().prepareStatement(sql);
			statement.setLong(1, pessoa.getId());
			statement.setString(2, pessoa.getNome());
			statement.setString(3, pessoa.getEmail());
			statement.setString(4, pessoa.getTipo());
			
			statement.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String insertFisica = "insert into fisica (id,cpf,datanascimento,sexo)";
		
	}
	
	public int getTotalClientes() {
		
		int resultado = 0;
		
		try {
			String sql = "select count(*) qtde from pessoa";			
			
			PreparedStatement statement = dataSource.getConnection().prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			resultado = resultSet.getInt("qtde");
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return resultado;
	}
	
	

}
