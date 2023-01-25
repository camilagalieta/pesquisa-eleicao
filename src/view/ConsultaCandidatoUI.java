package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import controller.CandidatoController;
import model.Candidato;
import view.tables.CandidatoTableModel;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaCandidatoUI extends JInternalFrame {
	private JTable jtCandidatos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCandidatoUI frame = new ConsultaCandidatoUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConsultaCandidatoUI() {
		setTitle("Consulta de Candidato");
		setBounds(100, 100, 781, 368);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Candidato candidato = new CandidatoTableModel(new CandidatoController().listar()).get(jtCandidatos.getSelectedRow());
				
				try {
					new CandidatoController().excluir(candidato.getId());
					JOptionPane.showMessageDialog(null, "Candidato excluído com sucesso!");
					jtCandidatos.setModel(new CandidatoTableModel(new CandidatoController().listar()));
					
				} catch (Exception eec) {
					// eecc = 'e'xcessão 'e'xcluindo 'c'andidato
					JOptionPane.showMessageDialog(null, "Erro ao excluir candidato!");
				}
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Candidato candidato = new CandidatoTableModel(new CandidatoController().listar()).get(jtCandidatos.getSelectedRow());
				try {
					CadastroCandidatoUI cadCandidatoUI = new CadastroCandidatoUI();
					cadCandidatoUI.setCandidatoEdicao(candidato);
					cadCandidatoUI.setVisible(true);
					getParent().add(cadCandidatoUI, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtCandidatos.setModel(new CandidatoTableModel(new CandidatoController().listar()));
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(344)
							.addComponent(btnAtualizar)
							.addGap(18)
							.addComponent(btnEditar)
							.addGap(18)
							.addComponent(btnExcluir)
							.addGap(18)
							.addComponent(btnCancelar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 739, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnExcluir)
						.addComponent(btnEditar)
						.addComponent(btnAtualizar))
					.addGap(22))
		);
		
		jtCandidatos = new JTable();
		jtCandidatos.setModel(new CandidatoTableModel(new CandidatoController().listar()));
		scrollPane.setViewportView(jtCandidatos);
		getContentPane().setLayout(groupLayout);

	}

	protected Candidato Candidato(CandidatoTableModel candidatoTableModel) {
		return null;
	}
}
