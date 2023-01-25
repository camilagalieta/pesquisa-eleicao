package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalUI frame = new PrincipalUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PrincipalUI() {
		setTitle("Pesquisa Eleições");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1287, 717);
		
		JMenuBar jbPrincipal = new JMenuBar();
		setJMenuBar(jbPrincipal);
		
		JMenu jmCadastros = new JMenu("Cadastros");
		jbPrincipal.add(jmCadastros);
		
		JMenuItem jmiCadastroCandidato = new JMenuItem("Candidato");
		jmiCadastroCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCandidatoUI cadastroCandidato = null;
				try {
					cadastroCandidato = new CadastroCandidatoUI();
				} catch (Exception esc) {
					esc.printStackTrace();
				}
				cadastroCandidato.setVisible(true);
				contentPane.add(cadastroCandidato, 0);
				
				}
		});
		jmCadastros.add(jmiCadastroCandidato);
		
		JMenuItem jmiCadastroPesquisa = new JMenuItem("Pesquisa");
		jmiCadastroPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPesquisaUI cadastroPesquisa = null;
				try {
					cadastroPesquisa = new CadastroPesquisaUI();
				} catch (Exception esp) {
					esp.printStackTrace();
				}
				cadastroPesquisa.setVisible(true);
				contentPane.add(cadastroPesquisa, 0);
			}
		});
		jmCadastros.add(jmiCadastroPesquisa);
		
		JMenu jmConsultas = new JMenu("Consultas");
		jbPrincipal.add(jmConsultas);
		
		JMenuItem jmiConsultaCandidato = new JMenuItem("Candidato");
		jmiConsultaCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaCandidatoUI consultaCandidatoUI = new ConsultaCandidatoUI();
				consultaCandidatoUI.setVisible(true);
				contentPane.add(consultaCandidatoUI, 0);
				
				
			}
		});
		jmConsultas.add(jmiConsultaCandidato);
		
		JMenuItem jmiConsultaPesquisa = new JMenuItem("Pesquisa");
		jmiConsultaPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaPesquisaUI consultaPesquisaUI = new ConsultaPesquisaUI();
				consultaPesquisaUI.setVisible(true);
				contentPane.add(consultaPesquisaUI, 0);
			}
			
		});
		jmConsultas.add(jmiConsultaPesquisa);
		
		JMenu jmVotos = new JMenu("Votos");
		jbPrincipal.add(jmVotos);
		
		JMenuItem jmiRegistrarVoto = new JMenuItem("Registrar Voto");
		jmiRegistrarVoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarVotosUI registraVotosUI = new RegistrarVotosUI();
				registraVotosUI.setVisible(true);
				contentPane.add(registraVotosUI, 0);
				
			}
		});
		jmVotos.add(jmiRegistrarVoto);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 440, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 253, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
