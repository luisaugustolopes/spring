package br.com.lopes.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import br.com.lopes.model.Usuario;
import br.com.lopes.util.JpaUtils;

public class UsuarioDAOJPA {

	
	/**
	 * Busca o usu�rio na base de acordo com o logon, verificando se o mesmo encontra-se ativo
	 * @param usuario
	 * @return 
	 */
	public boolean ativo(Usuario usuario){
		
		boolean ativo;
		
		EntityManager manager = JpaUtils.getEntityManager();
		String sql = "select a from Usuario a where logon = :logon and ativo = 1";
		List<Usuario> results = manager.createQuery(sql,Usuario.class)
								.setParameter("logon", usuario.getLogon())
								.getResultList();
		ativo = !(results.isEmpty());
		manager.close();
		
		return ativo;
	}

	/**
	 * Validar o usu�rio de acordo com o Logon e Senha
	 * @param usuario
	 * @return boolean indicando se validou
	 */
	public boolean validarLoginSenha(Usuario usuario){
		
		boolean b;
		
		EntityManager manager = JpaUtils.getEntityManager();
		String sql = "select a from Usuario a where logon = :logon and senha = :senha";
		List<Usuario> results = manager.createQuery(sql,Usuario.class)
								.setParameter("logon", usuario.getLogon())
								.setParameter("senha", usuario.getSenha())
								.getResultList();
		b = !(results.isEmpty());
		manager.close();
		
		Logger.getLogger(UsuarioDAOJPA.class.getName()).info("Validar login/senha: [" + usuario.getLogon() + '/' + usuario.getSenha() + "]:" + b);
		
		return b;
	}
	
	/**
	 * Inserir usu�rio no sistema, cadastrando na base de dados
	 * @param usuario
	 */
	public void insert(Usuario usuario){

		// Registrar usu�rio na base
		usuario.setDataCriacao(Calendar.getInstance());
		usuario.setAtivo(true);
		usuario.setLogon(usuario.getLogon());
		
		Logger.getLogger(UsuarioDAOJPA.class.getName()).info("Registrar usu�rio: " + usuario.getLogon());
		EntityManager manager = JpaUtils.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(usuario);		
		manager.getTransaction().commit();
		manager.close();
		Logger.getLogger(UsuarioDAOJPA.class.getName()).info("Usu�rio registrado: [" + usuario.getLogon() + ']');		
	}
	
	/**
	 * Atualizar os dados do usu�rio
	 * @param usuario
	 */
	public void update(Usuario usuario){		
		EntityManager manager = JpaUtils.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(usuario);		
		manager.getTransaction().commit();
		manager.close();
	}
	
	/**
	 * Deletar usu�rio do sistema
	 * @param usuario
	 */
	public void delete(Usuario usuario){
		
		EntityManager manager = JpaUtils.getEntityManager();
		manager.getTransaction().begin();
		manager.remove(usuario);		
		manager.getTransaction().commit();
		manager.close();
	}
	
	/**
	 * Busca o usu�rio na base de acordo com o logon 
	 * @param logon
	 * @return usuario
	 */
	public Usuario selecionarUsuarioPorLogon(String logon) {
		
		EntityManager manager = JpaUtils.getEntityManager();
		String sql = "select a from Usuario a where logon = :logon";
		List<Usuario> results = manager.createQuery(sql, Usuario.class)
								.setParameter("logon", logon)
								.getResultList();
		manager.close();
		
		Logger.getLogger(UsuarioDAOJPA.class.getName()).info("Selecionar usuario por logon: [" + logon + "]:");		
		
		if (results.isEmpty()) { return null;}		
		return results.get(0);
	}
	
	/**
	 * Busca o usu�rio na base de acordo com o E-mail 
	 * @param logon
	 * @return usuario
	 */
	public Usuario selecionarUsuarioPorEmail(String email) {
		
		EntityManager manager = JpaUtils.getEntityManager();
		String sql = "select a from Usuario a where email = :email";
		List<Usuario> results = manager.createQuery(sql, Usuario.class)
								.setParameter("email", email)
								.getResultList();
		manager.close();
		
		Logger.getLogger(UsuarioDAOJPA.class.getName()).info("Selecionar usuario por e-mail: [" + email + "]:" + results);		
		
		if (results.isEmpty()) { return null;}		
		return results.get(0);
		
	}
	
	/**
	 * Ativar usu�rio do sistema
	 * @param usuario
	 */
	public void ativarUsuario(Usuario usuario){
		
		usuario.setAtivo(true);
		
		EntityManager manager = JpaUtils.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(usuario);		
		manager.getTransaction().commit();
		manager.close();
		
	}
	
	/**
	 * Desativar usu�rio do sistema
	 * @param usuario
	 */
	public void desativarUsuario(Usuario usuario){
		
		usuario.setAtivo(false);
		
		EntityManager manager = JpaUtils.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(usuario);		
		manager.getTransaction().commit();
		manager.close();
		
	}
	
	/**
	 * Alterar situa��o de usu�rio administrador
	 * @param usuario
	 */
	public void setAdministrador(Usuario usuario, boolean administrador){
		usuario.setAdministrador(administrador);
		
		EntityManager manager = JpaUtils.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(usuario);		
		manager.getTransaction().commit();
		manager.close();
	}
	
	
	public boolean isUsuarioAdministrador(String logon){
		
		Usuario usuario = selecionarUsuarioPorLogon(logon);
						
		return usuario.getAdministrador();
	}
	
	/**
	 * Listagem de todos os usu�rios do sistema
	 * @return
	 */
	public List<Usuario> listaUsuarios(){
		EntityManager manager = JpaUtils.getEntityManager();
		List<Usuario> usuarios = manager.createQuery("select a from Usuario a",Usuario.class).getResultList();
		manager.close();
		
		return usuarios;
	}
	
}
