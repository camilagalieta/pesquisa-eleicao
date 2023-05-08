package controller;

import java.util.List;

import dao.CandidatoDao;
import dao.PesquisaDao;
import model.Pesquisa;

public class PesquisaController {
	
	public void salvar(Pesquisa pesquisa) throws Exception {
		if (pesquisa.getData() == null || pesquisa.getInstituto() == null) {
			throw new Exception("Dados da pesquisa incompletos!"); 
		}
		PesquisaDao.getInstance().salvar(pesquisa);
	}
	
	public void atualizar(Pesquisa pesquisa) throws Exception {
		if (pesquisa.getData() == null || pesquisa.getInstituto() == null) {
			throw new Exception("Dados da pesquisa incompletos!");
		}
		PesquisaDao.getInstance().atualizar(pesquisa); 
	}
	
	public void excluir(int idPesquisa) throws Exception {
		if (idPesquisa == 0) {
			throw new Exception("Nenhuma pesquisa selecionada!");
		}
		PesquisaDao.getInstance().excluir(idPesquisa);
	}
	
	public List<Pesquisa> listar(){
		return PesquisaDao.getInstance().listar();
	}
	
	public Pesquisa pesquisaById(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("o ID da Pesquisa selecionada é nulo!");
		}
		return PesquisaDao.getInstance().pesquisaById(id);
	}

}