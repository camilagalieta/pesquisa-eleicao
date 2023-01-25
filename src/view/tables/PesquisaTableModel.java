package view.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Pesquisa;

public class PesquisaTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private static final int COL_ID = 0;
	private static final int COL_TIPO = 1;
	private static final int COL_FORMATO = 2;
	
	private List<Pesquisa> valores;

	public PesquisaTableModel(List<Pesquisa> valores) {
		this.valores = new ArrayList<Pesquisa> (valores);
	};
	

	@Override
	public int getRowCount() {
		return valores.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}
	
	public String getColumnName(int column) {
		if (column == COL_ID) return "Pesquisa N°";
		if (column == COL_TIPO) return "Tipo da Pesquisa";
		if (column == COL_FORMATO) return "Formato da Pesquisa";
		return "";
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		Pesquisa pesquisa = valores.get(row);
		if (column == COL_ID)
			return pesquisa.getId();
		else 
			if (column == COL_TIPO)
				return pesquisa.getTipoPesquisa();
		else
			if (column == COL_FORMATO)
				return pesquisa.getFormatoPesquisa();
		return "";
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Pesquisa pesquisa = valores.get(rowIndex);
		if (columnIndex ==  COL_TIPO) 
			pesquisa.setTipoPesquisa(aValue.toString());
		
		else 
			if (columnIndex == COL_FORMATO) 
				pesquisa.setFormatoPesquisa(aValue.toString());
	}
		
	public Class <?> getColumnClass(int columnIndex){
		return String.class;
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	
	public Pesquisa get(int row) {
		return valores.get(row);
	}
}
