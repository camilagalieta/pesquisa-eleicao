package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Candidato;
import model.CandidatoXPesquisa;
import model.Pesquisa;
import util.ConnectionUtil;

public class CandidatoXPesquisaDao {
	private static CandidatoXPesquisaDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static CandidatoXPesquisaDao getInstance() {
		if (instance == null) {
			instance = new CandidatoXPesquisaDao();
		}
		return instance;
		
	}
	
	public void salvar(CandidatoXPesquisa cxp) throws SQLException {
			String sql = "insert into candidato_pesquisa (candidato_id, pesquisa_id, voto) value (?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cxp.getCandidato().getId());
			pstmt.setInt(2, cxp.getPesquisa().getId());
			pstmt.setInt(3, cxp.getVotos());
			pstmt.execute();
			
	}
	

	public void atualizar(CandidatoXPesquisa cxp) {
		
		try {
			String sql = "update candidato_pesquisa set id = ?, votos = ?, candidato_id = ?, pesquisa_id = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cxp.getId());
			pstmt.setInt(2, cxp.getVotos());
			pstmt.setObject(3, cxp.getCandidato());
			pstmt.setObject(4, cxp.getPesquisa());
			pstmt.setInt(5, cxp.getId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idCxp) {
		
		try {
			String sql = "delete from candidato_pesquisa where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, idCxp);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<CandidatoXPesquisa> listar() {
		List<CandidatoXPesquisa> listaCandidatoXPesquisa = new ArrayList();

		try {
			String sql = "select * from candidato_pesquisa";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				CandidatoXPesquisa cxp = new CandidatoXPesquisa();
				cxp.setId(rs.getInt("id"));
				cxp.setVotos(rs.getInt("votos"));

				String sqlCandidato = "select * from candidato where id = ?";
				PreparedStatement stmtCandidato = con.prepareStatement(sqlCandidato);
				stmtCandidato.setInt(1, rs.getInt("candidato_id"));
				ResultSet rsCandidato = stmtCandidato.executeQuery();
				rsCandidato.next();

				Candidato c = new Candidato();
				c.setId(rsCandidato.getInt("id"));
				c.setNome(rsCandidato.getString("nome"));
				c.setPartido(rsCandidato.getString("partido"));
				c.setFichaLimpa(rsCandidato.getBoolean("ficha_limpa"));

				String sqlPesquisa = "select * from pesquisa where id = ?";
				PreparedStatement stmtPesquisa = con.prepareStatement(sqlPesquisa);
				stmtPesquisa.setInt(1, rs.getInt("pesquisa_id"));
				ResultSet rsPesquisa = stmtPesquisa.executeQuery();
				rsPesquisa.next();

				Pesquisa p = new Pesquisa();
				p.setId(rsPesquisa.getInt("id"));
				p.setInstituto(rsPesquisa.getString("instituto"));
				p.setData(rsPesquisa.getString("data_pesquisa"));
				p.setLocal(rsPesquisa.getString("local_pesquisa"));
				p.setIdadeMedia(rsPesquisa.getInt("media_idade"));
				p.setTipoPesquisa(rsPesquisa.getString("tipo_pesquisa"));
				p.setFormatoPesquisa(rsPesquisa.getString("formato_pesquisa"));

				cxp.setCandidato(c);
				cxp.setPesquisa(p);

				listaCandidatoXPesquisa.add(cxp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaCandidatoXPesquisa;
	}
}
