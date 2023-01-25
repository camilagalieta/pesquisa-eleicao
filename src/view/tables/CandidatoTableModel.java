package view.tables;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Candidato;

public class CandidatoTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private static final int COL_NOME = 0;
	private static final int COL_PARTIDO = 1;
	private static final int COL_FICHA_LIMPA = 2;
	
	private List<Candidato> valores;
	
	public CandidatoTableModel(List<Candidato> valores) {
		this.valores = new ArrayList<Candidato>(valores);
	}

	public CandidatoTableModel(Candidato candidato) {
	}

	public int getRowCount() {
		return valores.size();
	}

	public int getColumnCount() {
		return 3;
	}
	
	public String getColumnName(int column) {
		if (column == COL_NOME) return "Nome do Candidato";
		if (column == COL_PARTIDO) return "Partido do Candidato";
		if (column == COL_FICHA_LIMPA) return "Situação do Candidato"; 
		return "";
	}
	
	public Object getValueAt(int row, int column) {
		Candidato candidato = valores.get(row);
		
		if (column == COL_NOME) {
			return candidato.getNome();
		}
		else if (column == COL_PARTIDO) {
			return candidato.getPartido();
		}
		else if (column == COL_FICHA_LIMPA) {
			return candidato.getFichaLimpa();
		}
		return null;
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Candidato candidato = valores.get(rowIndex);
		if (columnIndex ==  COL_NOME) {
			candidato.setNome(aValue.toString());
		}
		else if (columnIndex == COL_PARTIDO) {
			candidato.setPartido(aValue.toString());
		}
		else if (columnIndex == COL_FICHA_LIMPA) {
			candidato.setFichaLimpa((boolean) aValue);
			}
		}
	public Class <?> getColumnClass(int columnIndex){
		return String.class;
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	
	public Candidato get(int row) {
		return valores.get(row);
	}
}
