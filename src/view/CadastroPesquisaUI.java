package view;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.PesquisaController;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.Pesquisa;
import javax.swing.DropMode;

public class CadastroPesquisaUI extends JInternalFrame {
	private JTextField txtInstituto;
	private JTextField txtData;
	private JTextField txtLocal;
	private JTextField txtIdadeMedia;
	private JTextField txtTipoPesquisa;
	private JTextField txtFormatoPesquisa;
	private Pesquisa pesquisa;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPesquisaUI frame = new CadastroPesquisaUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastroPesquisaUI() {
		setTitle("Cadastro de Pesquisa");
		setBounds(100, 100, 692, 420);
		
		JPanel jpInfoPesquisa = new JPanel();
		jpInfoPesquisa.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Informa\u00E7\u00F5es da Pesquisa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(85, 87, 83)));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pesquisa pesquisa = new Pesquisa();
				pesquisa.setInstituto(txtInstituto.getText());
				pesquisa.setData(txtData.getText());
				pesquisa.setLocal(txtLocal.getText());
				pesquisa.setIdadeMedia(Integer. parseInt(txtIdadeMedia.getText()));
				pesquisa.setTipoPesquisa(txtTipoPesquisa.getText());
				pesquisa.setFormatoPesquisa(txtFormatoPesquisa.getText());
				
				try {
					new PesquisaController().salvar(pesquisa);
					JOptionPane.showMessageDialog(null, "Pesquisa salva com sucesso!");
					dispose();
				} catch (Exception esp) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar pesquisa!");
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
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(jpInfoPesquisa, GroupLayout.PREFERRED_SIZE, 640, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(144)
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addGap(58)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(jpInfoPesquisa, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(27))
		);
		
		JLabel lblInstituto = new JLabel("Instituto: ");
		
		JLabel lblData = new JLabel("Data: ");
		
		JLabel lblIdadeMdia = new JLabel("Idade Média: ");
		
		JLabel lblTipoDePesquisa = new JLabel("Tipo de Pesquisa:");
		
		JLabel lblFormatoDaPesquisa = new JLabel("Formato da Pesquisa: ");
		
		JLabel lblLocal = new JLabel("Local:");
		
		txtInstituto = new JTextField();
		txtInstituto.setColumns(10);
		
		txtData = new JTextField();
		txtData.setColumns(10);
		
		txtLocal = new JTextField();
		txtLocal.setColumns(10);
		
		txtIdadeMedia = new JTextField();
		txtIdadeMedia.setColumns(10);
		
		txtTipoPesquisa = new JTextField();
		txtTipoPesquisa.setColumns(10);
		
		txtFormatoPesquisa = new JTextField();
		txtFormatoPesquisa.setColumns(10);
		GroupLayout gl_jpInfoPesquisa = new GroupLayout(jpInfoPesquisa);
		gl_jpInfoPesquisa.setHorizontalGroup(
			gl_jpInfoPesquisa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpInfoPesquisa.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpInfoPesquisa.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpInfoPesquisa.createSequentialGroup()
							.addComponent(lblInstituto)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtInstituto, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpInfoPesquisa.createSequentialGroup()
							.addComponent(lblData)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtData, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(lblIdadeMdia)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtIdadeMedia, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpInfoPesquisa.createSequentialGroup()
							.addComponent(lblLocal)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtLocal, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpInfoPesquisa.createSequentialGroup()
							.addComponent(lblTipoDePesquisa)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTipoPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblFormatoDaPesquisa)
							.addGap(3)
							.addComponent(txtFormatoPesquisa, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
					.addContainerGap(25, GroupLayout.PREFERRED_SIZE))
		);
		gl_jpInfoPesquisa.setVerticalGroup(
			gl_jpInfoPesquisa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpInfoPesquisa.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_jpInfoPesquisa.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInstituto, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtInstituto, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_jpInfoPesquisa.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblData, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtData, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdadeMdia, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtIdadeMedia, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpInfoPesquisa.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocal)
						.addComponent(txtLocal, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_jpInfoPesquisa.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoDePesquisa)
						.addComponent(txtTipoPesquisa, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFormatoDaPesquisa)
						.addComponent(txtFormatoPesquisa, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		jpInfoPesquisa.setLayout(gl_jpInfoPesquisa);
		getContentPane().setLayout(groupLayout);

	}

	public void setPesquisaEdicao(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
		preencheFormulario();
		}
	
	public void preencheFormulario() {
		if (pesquisa != null) {
			txtInstituto.setText(pesquisa.getInstituto());
			txtData.setText(pesquisa.getData());
			txtLocal.setText(pesquisa.getLocal());
			txtIdadeMedia.setText(String.valueOf(pesquisa.getIdadeMedia()));
			txtTipoPesquisa.setText(pesquisa.getTipoPesquisa());
			txtFormatoPesquisa.setText(pesquisa.getFormatoPesquisa());
		}
	}
}
