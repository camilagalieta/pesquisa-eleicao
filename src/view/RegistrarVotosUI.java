package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.CandidatoController;
import controller.CandidatoXPesquisaController;
import controller.PesquisaController;
import dao.CandidatoDao;
import dao.PesquisaDao;
import model.Candidato;
import model.CandidatoXPesquisa;
import model.Pesquisa;
import util.ComboBoxCandidatoItem;
import util.ComboBoxPesquisaItem;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarVotosUI extends JInternalFrame {
	private JComboBox cbCandidatoSelect;
	private JComboBox cbPesquisaSelect;
	private JTextField txtQtdVotos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarVotosUI frame = new RegistrarVotosUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public RegistrarVotosUI() {
		setBounds(100, 100, 435, 440);
		
		JLabel lblCandidato = new JLabel("Candidato");
		
		
		JComboBox cbCandidato = new JComboBox();
		CandidatoDao candidatos = new CandidatoDao();
		
		for (Candidato candidato: candidatos.listar()) {
			ComboBoxCandidatoItem itemC = new ComboBoxCandidatoItem(candidato.getId(), candidato.getNome());
			cbCandidato.addItem(itemC);
			
		}
		
		JLabel lblPesquisa = new JLabel("Pesquisa");
		
		JComboBox cbPesquisa = new JComboBox();
		
		PesquisaDao pesquisas = new PesquisaDao();
		
		for (Pesquisa pesquisa: pesquisas.listar()) {
			ComboBoxPesquisaItem itemP = new ComboBoxPesquisaItem(pesquisa.getId(), pesquisa.getInstituto());
			cbPesquisa.addItem(itemP);
		}
		
		
		JLabel lblVotos = new JLabel("Votos");
		
		txtQtdVotos = new JTextField();
		txtQtdVotos.setColumns(10);
		
		JLabel lblQtd = new JLabel("QTD");
		
		JButton btnAdicionar = new JButton("Adicionar");
		
		JButton btnSalvar = new JButton("Salvar");
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Integer idCandidato = null;
					
				try {
					Object selectedItemC = cbCandidato.getSelectedItem();
					ComboBoxCandidatoItem modelItemC = (ComboBoxCandidatoItem) selectedItemC; 
					idCandidato = modelItemC.getKey();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
				Integer idPesquisa = null;
				
				try {
					Object selectedItemP = cbPesquisa.getSelectedItem();
					ComboBoxPesquisaItem modelItemP = (ComboBoxPesquisaItem) selectedItemP; 
					idPesquisa = modelItemP.getKey();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
				try {
					String qtdVotos = txtQtdVotos.getText();
					Integer votos = Integer.valueOf(qtdVotos);
				
					Candidato candidato = new CandidatoController().candidatoById(idCandidato);
					Pesquisa pesquisa = new PesquisaController().pesquisaById(idPesquisa);
					CandidatoXPesquisa cxp = new CandidatoXPesquisa();
					cxp.setCandidato(candidato);
					cxp.setPesquisa(pesquisa);
						
					cxp.setVotos(votos);
					new CandidatoXPesquisaController().salvar(cxp); 
					
				} catch (Exception ex){
					JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup (
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCandidato, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbCandidato, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblQtd)
									.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblVotos)))
								.addGap(30)
								.addComponent(txtQtdVotos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAdicionar))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(lblPesquisa, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(cbPesquisa, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(48, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(83)
					.addComponent(btnSalvar)
					.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
					.addComponent(btnCancelar)
					.addGap(74))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCandidato, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbCandidato, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbPesquisa, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPesquisa, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblQtd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblVotos))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtQtdVotos, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnAdicionar)))
					.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addGap(32))
		);
		getContentPane().setLayout(groupLayout);
		
	}
}
