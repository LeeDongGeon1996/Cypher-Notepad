package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import config.Language;
import file.FileManager;
import ui.custom.KButton;

public class tt extends JFrame {
	private static final long serialVersionUID = -8901510103598913554L;
	//private JPanel contentPane;
	private Container contentPane;
	private JTable table;
	private KButton btnNew, btnOpen, btnX;
	public static NotepadUI notepadUI;
	private Language lang;
	int mpX, mpY;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tt frame = new tt();
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
	public tt() {
long start = System.currentTimeMillis();
		
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "main UI 실행 시간1 : " + ( end - start )/1000.0 +"초");
		start = System.currentTimeMillis();
		
		Image originFrameImg = new ImageIcon(getClass().getClassLoader().getResource("encrypted_black_crop_bg.png")).getImage();
		Image changedFrameImg = originFrameImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		setIconImage(changedFrameImg);
		
		end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "main UI 실행 시간2 : " + ( end - start )/1000.0 +"초");
		start = System.currentTimeMillis();
		
		setBounds(100, 100, 550, 719);
		this.setLocationRelativeTo(null);
		end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "main UI 실행 시간3-3 : " + ( end - start )/1000.0 +"초");
		start = System.currentTimeMillis();
		
		/*
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		*/
		
		contentPane = this.getContentPane();
		//contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "main UI 실행 시간3-2 : " + ( end - start )/1000.0 +"초");
		start = System.currentTimeMillis();
		this.setUndecorated(true);
		
		end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "main UI 실행 시간3-1 : " + ( end - start )/1000.0 +"초");
		start = System.currentTimeMillis();
		
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0x68217A));

		end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "main UI 실행 시간3 : " + ( end - start )/1000.0 +"초");
		start = System.currentTimeMillis();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(FileManager.getInstance().loadRecentFiles(),
				new String[] { lang.tblName, lang.tblDate, lang.tblSize, lang.tblPath }) {

			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setSelectionBackground(new Color(0x451651));
		table.setSelectionForeground(new Color(0xffffff));
		table.setRowHeight(50);
		
		table.getColumnModel().getColumn(0).setMinWidth(60);
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setMaxWidth(400);
		
		table.getColumnModel().getColumn(1).setMinWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(160);
		table.getColumnModel().getColumn(1).setMaxWidth(160);
		
		table.getColumnModel().getColumn(2).setMinWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setMaxWidth(80);
		
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		TableColumnModel tcmSchedule = table.getColumnModel();
		for (int i = 1; i < tcmSchedule.getColumnCount()-1; i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "main UI 실행 시간 :4 " + ( end - start )/1000.0 +"초");
		start = System.currentTimeMillis();
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);

		JLabel lblRecentFiles = new JLabel(lang.rcntFiles);
		lblRecentFiles.setFont(new Font("Condolas", Font.BOLD, 15));

		// list.
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(10).addComponent(lblRecentFiles)
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblRecentFiles, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGap(4)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)));

		JLabel lblNewLabel = new JLabel("Crypto Notepad");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 39));
		lblNewLabel.setForeground(new Color(0xffffff));

		end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "main UI 실행 시간 5: " + ( end - start )/1000.0 +"초");
		start = System.currentTimeMillis();
		
		btnNew = new KButton();
		btnNew.setText(lang.btnNew);
		btnNew.setFocusPainted(true);
		btnNew.setkAllowGradient(false);
		btnNew.setkAllowTab(false);
		btnNew.setkFillButton(true);
		btnNew.setBorderPainted(false);
		btnNew.setkBorderRadius(50);
		btnNew.setkPressedColor(new Color(0xebcff2));
		btnNew.setkBackGroundColor(new Color(0x9730b0));
		btnNew.setkForeGround(new Color(0xffffff));
		btnNew.setForeground(new Color(0xffffff));
		btnNew.setkHoverColor(new Color(0xffffff));
		btnNew.setkHoverForeGround(new Color(0x68217A));

		btnOpen = new KButton();
		btnOpen.setText(lang.btnOpen);
		btnOpen.setFocusPainted(true);
		btnOpen.setkAllowGradient(false);
		btnOpen.setkAllowTab(false);
		btnOpen.setkFillButton(true);
		btnOpen.setBorderPainted(false);
		btnOpen.setkBorderRadius(50);
		btnOpen.setkPressedColor(new Color(0xebcff2));
		btnOpen.setkBackGroundColor(new Color(0x9730b0));
		btnOpen.setkForeGround(new Color(0xffffff));
		btnOpen.setForeground(new Color(0xffffff));
		btnOpen.setkHoverColor(new Color(0xffffff));
		btnOpen.setkHoverForeGround(new Color(0x68217A));

		JLabel lblSdf = new JLabel("sdf");
		lblSdf.setHorizontalAlignment(SwingConstants.CENTER);
		Image originImg = new ImageIcon(getClass().getClassLoader().getResource("encrypted_white_origin.png")).getImage();
		Image changedImg = originImg.getScaledInstance(71, 90, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(changedImg);
		lblSdf.setIcon(Icon);

		btnX = new KButton();
		btnX.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		btnX.setMargin(new Insets(1, 1, 1, 1));
		btnX.setText("X");
		btnX.setFocusPainted(true);
		btnX.setkAllowGradient(false);
		btnX.setkAllowTab(false);
		btnX.setkFillButton(true);
		btnX.setBorderPainted(false);
		btnX.setkBorderRadius(5);
		btnX.setkPressedColor(new Color(0xebcff2));
		btnX.setkBackGroundColor(new Color(0x9730b0));
		btnX.setkForeGround(new Color(0xffffff));
		btnX.setForeground(new Color(0xffffff));
		btnX.setkHoverColor(new Color(0xffffff));
		btnX.setkHoverForeGround(new Color(0x68217A));
		end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "main UI 실행 시간 :6 " + ( end - start )/1000.0 +"초");
		start = System.currentTimeMillis();

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap(525, Short.MAX_VALUE).addComponent(btnX,
						GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(98)
						.addComponent(lblSdf, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup().addGap(154)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnOpen, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNew, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 235,
										Short.MAX_VALUE))
						.addGap(161)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false).addGroup(gl_panel
								.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup().addGap(73).addComponent(lblSdf,
										GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnX, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)).addGap(23)
						.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(btnOpen, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(22, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "main UI 실행 시간 7: " + ( end - start )/1000.0 +"초");
		start = System.currentTimeMillis();
		
		setVisible(true);
	}

}
