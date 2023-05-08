package controller;

import java.sql.SQLException;
import java.util.List;

import dao.CandidatoDao;
import model.Candidato;

public class CandidatoController {
	
	public Long salvar(Candidato candidato) throws Exception {
		if (candidato.getNome() == null || candidato.getNome().length() < 3 || candidato.getPartido() == null) {
			throw new Exception("Nome do candidato e/ou Partido inválidos!"); 
		}
		return CandidatoDao.getInstance().salvar(candidato);
	}
	
	public void atualizar(Candidato candidato) throws Exception {
		if (candidato.getNome() == null || candidato.getNome().length() < 3 || candidato.getPartido() == null) {
			throw new Exception("Nome do candidato e/ou partido inválidos!");
		}
		CandidatoDao.getInstance().atualizar(candidato); 
	}
	
	public void excluir(int idCandidato) throws Exception {
		if (idCandidato == 0) {
			throw new Exception("Nenhum candidato selecionado!");
		}
		CandidatoDao.getInstance().excluir(idCandidato);
	}
	
	public List<Candidato> listar(){
		return CandidatoDao.getInstance().listar();
	}
	
	public Candidato candidatoById(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("Id do candidato é nulo!");
		} 
		return CandidatoDao.getInstance().candidatoById(id);		
	}
}