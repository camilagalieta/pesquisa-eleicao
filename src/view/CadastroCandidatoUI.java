package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;

import model.Candidato;
import controller.CandidatoController;
import java.awt.Scrollbar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CadastroCandidatoUI extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtPartido;
	private Candidato candidato;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCandidatoUI frame = new CadastroCandidatoUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastroCandidatoUI() throws Exception {
		
		setSelected(true);
		setTitle("Cadastro Candidato");
		setClosable(true);
		setBounds(100, 100, 615, 293);
		
		JPanel jpCadastroCandidato = new JPanel();
		jpCadastroCandidato.setBorder(new TitledBorder(null, "Dados Candidato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(85, 87, 83)));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if (candidato != null && candidato.getId() > 0) {
						candidato.setNome(txtNome.getText());
						candidato.setPartido(txtPartido.getText());
						new CandidatoController().atualizar(candidato);
						JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
					} else {
					
					Candidato candidato = new Candidato();
					candidato.setNome(txtNome.getText());
					candidato.setPartido(txtPartido.getText());
					candidato.setFichaLimpa(isSelected);
					
					
					new CandidatoController().salvar(candidato);
					JOptionPane.showMessageDialog(null, "Candidato salvo com sucesso!");
					}
					dispose(); 
				} catch (Exception esc) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar candidato!");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jpCadastroCandidato, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadastroCandidato, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(15))
		);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		txtNome = new JTextField();
		txtNome.setHorizontalAlignment(SwingConstants.LEFT);
		txtNome.setColumns(10);
		
		JLabel lblPartido = new JLabel("Partido:");
		
		txtPartido = new JTextField();
		txtPartido.setColumns(10);
		
		JLabel lblFichaLimpa = new JLabel("Ficha Limpa? ");
		
		JComboBox cbFichaLimpa = new JComboBox();
		
		cbFichaLimpa.setModel(new DefaultComboBoxModel(new String[] {"", "Sim ", "Não"}));
		cbFichaLimpa.setMaximumRowCount(3);
		cbFichaLimpa.setEditable(true);
		GroupLayout gl_jpCadastroCandidato = new GroupLayout(jpCadastroCandidato);
		gl_jpCadastroCandidato.setHorizontalGroup(
			gl_jpCadastroCandidato.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroCandidato.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_jpCadastroCandidato.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpCadastroCandidato.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFichaLimpa)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbFichaLimpa, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpCadastroCandidato.createSequentialGroup()
							.addComponent(lblPartido)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtPartido, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpCadastroCandidato.createSequentialGroup()
							.addComponent(lblNome)
							.addGap(2)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		gl_jpCadastroCandidato.setVerticalGroup(
			gl_jpCadastroCandidato.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroCandidato.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpCadastroCandidato.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadastroCandidato.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPartido)
						.addComponent(txtPartido, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpCadastroCandidato.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFichaLimpa)
						.addComponent(cbFichaLimpa, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
					.addGap(50))
		);
		
		jpCadastroCandidato.setLayout(gl_jpCadastroCandidato);
		getContentPane().setLayout(groupLayout);

	}
	
	public void setCandidatoEdicao(Candidato candidato) {
		this.candidato = candidato;
		preencheFormulario();
	}
	
	private void preencheFormulario() {
		if(candidato != null) {
			txtNome.setText(candidato.getNome());
			txtPartido.setText(candidato.getPartido());
			
		}
	}
}
