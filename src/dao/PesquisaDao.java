package dao;

import model.Candidato;
import model.Pesquisa;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PesquisaDao {
	
	private static PesquisaDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static PesquisaDao getInstance() {
		if (instance == null) {
			instance = new PesquisaDao();
		}
		return instance;
	}
	
	public void salvar(Pesquisa pesquisa) {
		
		try {
			String sql = "insert into pesquisa (id, instituto, data, local, idadeMedia, tipoPesquisa, formatoPesquisa) values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pesquisa.getId());
			pstmt.setString(2, pesquisa.getInstituto());
			pstmt.setString(3, pesquisa.getData());
			pstmt.setString(4, pesquisa.getLocal());
			pstmt.setInt(5, pesquisa.getIdadeMedia());
			pstmt.setString(6, pesquisa.getTipoPesquisa());
			pstmt.setString(7, pesquisa.getFormatoPesquisa());
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Pesquisa pesquisa) {

		try {
			String sql = "update pesquisa set id = ?, instituto = ?, data = ?, local = ?, idadeMedia = ?, tipoPesquisa= ?, formatoPesquisa = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pesquisa.getId());
			pstmt.setString(2, pesquisa.getInstituto());
			pstmt.setString(3, pesquisa.getData());
			pstmt.setString(4, pesquisa.getLocal());
			pstmt.setInt(5, pesquisa.getIdadeMedia());
			pstmt.setString(6, pesquisa.getTipoPesquisa());
			pstmt.setString(7, pesquisa.getFormatoPesquisa());
			pstmt.setInt(8, pesquisa.getId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idPesquisa) {
		
		try {
			String sql = "delete from pesquisa where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idPesquisa);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Pesquisa> listar(){
		
		List<Pesquisa> listaPesquisas= new ArrayList();
		
		try {
			String sql = "select * from pesquisa";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pesquisa p = new Pesquisa();
				p.setId(rs.getInt("id"));
				p.setInstituto(rs.getString("instituto"));
				p.setData(rs.getString("data"));
				p.setLocal(rs.getString("local"));
				p.setIdadeMedia(rs.getInt("idadeMedia"));
				p.setTipoPesquisa(rs.getString("tipoPesquisa"));
				p.setFormatoPesquisa(rs.getString("formatoPesquisa"));
				listaPesquisas.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaPesquisas;
	}
	
	public Pesquisa pesquisaById(Integer id) throws SQLException {
		String sql = "select * from pesquisa where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		Pesquisa p = new Pesquisa();
		p.setId(rs.getInt("id"));
		p.setInstituto(rs.getString("instituto"));
		p.setData(rs.getString("data"));
		p.setLocal(rs.getString("local"));
		p.setIdadeMedia(rs.getInt("idadeMedia"));
		p.setTipoPesquisa(rs.getString("tipoPesquisa"));
		p.setFormatoPesquisa(rs.getString("formatoPesquisa"));
		return p;
	}
}