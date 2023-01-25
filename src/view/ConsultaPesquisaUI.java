package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.PesquisaController;
import model.Pesquisa;
import view.tables.PesquisaTableModel;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaPesquisaUI extends JInternalFrame {
	private JTable jtPesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaPesquisaUI frame = new ConsultaPesquisaUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaPesquisaUI() {
		setTitle("Consulta Pesquisa");
		setBounds(100, 100, 818, 500);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pesquisa pesquisa = new PesquisaTableModel(new PesquisaController().listar()).get(jtPesquisa.getSelectedRow());
				
				try {
					new PesquisaController().excluir(pesquisa.getId());
					JOptionPane.showMessageDialog(null, "Pesquisa excluida com sucesso!");
					jtPesquisa.setModel(new PesquisaTableModel(new PesquisaController().listar()));
					
				} catch (Exception eep) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir pesquisa!");
				}
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pesquisa pesquisa = new PesquisaTableModel(new PesquisaController().listar()).get(jtPesquisa.getSelectedRow());
				
				CadastroPesquisaUI cadPesquisaUI = new CadastroPesquisaUI();
				cadPesquisaUI.setPesquisaEdicao(pesquisa);
				cadPesquisaUI.setVisible(true);
				getParent().add(cadPesquisaUI, 0);
				}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtPesquisa.setModel(new PesquisaTableModel(new PesquisaController().listar()));
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(393, Short.MAX_VALUE)
					.addComponent(btnAtualizar)
					.addGap(18)
					.addComponent(btnEditar)
					.addGap(18)
					.addComponent(btnExcluir)
					.addGap(18)
					.addComponent(btnCancelar)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 786, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnExcluir)
						.addComponent(btnEditar)
						.addComponent(btnAtualizar))
					.addGap(40))
		);
		
		jtPesquisa = new JTable();
		jtPesquisa.setModel(new PesquisaTableModel(new PesquisaController().listar()));
		scrollPane.setViewportView(jtPesquisa);
		getContentPane().setLayout(groupLayout);

	}
}
