package br.com.lopes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.lopes.model.Historia;

@Repository
public class HistoriaDAOJDBC {

	@Autowired
	DataSource dataSource;
	
	public Historia getHistoria(long numero){
		
		String sql = "select scrumhistoria.idscrumhistoria "
				+ "        , scrumhistoria.descricao"
				+ "        , scrumhistoria.resumo"				
				+ "        , scrumhistoria.data "
				+ "from   csos.scrumhistoria " 
				+ "where  idscrumhistoria = ?";
		
		Connection connection = null;
		PreparedStatement statement;
		
		Historia historia = null;
		try {			
			
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, numero);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()){			
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(rs.getDate(4));			
				
				historia = new Historia(rs.getLong(1), rs.getString(2), rs.getString(3), calendar);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return historia;
	}
	
}
