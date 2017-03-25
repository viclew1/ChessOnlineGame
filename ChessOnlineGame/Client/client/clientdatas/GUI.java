package client.clientdatas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import client.GUIListener;

/**
 *
 * @author vicle
 */
public class GUI extends JFrame implements ModelListener{

	private GUIListener listener;
	private int tailleCase=50;
	private Model model;


	/**
	 * Creates new form GUI
	 */

	public GUI(GUIListener listener, Model model) {
		initComponents();
		setListener(listener);
		this.model=model;
		addDisconnectOnClose();
	}

	private void addDisconnectOnClose()
	{
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				int result = JOptionPane.showConfirmDialog(null, "Are you sure to close this window?", "Closing?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				System.out.println(result);
				if (result == JOptionPane.YES_OPTION)
				{
					if (model.isConnected())
						listener.notifyConnection(model.getName());
					System.exit(0);
				}
			}
		});
	}

	public void setListener(GUIListener listener) {
		this.listener = listener;
	}

	private void initComponents() {

		connectPanel = new javax.swing.JPanel();
		connectButton = new javax.swing.JButton();
		userName = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		status = new javax.swing.JLabel();
		finderPanel = new javax.swing.JPanel();
		findGame = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		gamePanel = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		plateau = new Plateau(this, tailleCase);
		turnInfo = new javax.swing.JButton();
		playedInfos = new javax.swing.JPanel(new BorderLayout());
		jLabel4 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		connectPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		connectButton.setText("Connect");
		connectButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				connectButtonActionPerformed(evt);
			}
		});

		userName.setText("user name");

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
		jLabel1.setText("Connection");

		javax.swing.GroupLayout connectPanelLayout = new javax.swing.GroupLayout(connectPanel);
		connectPanel.setLayout(connectPanelLayout);
		connectPanelLayout.setHorizontalGroup(
				connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(connectPanelLayout.createSequentialGroup()
						.addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
						.addComponent(connectButton)
						.addGap(48, 48, 48))
				.addGroup(connectPanelLayout.createSequentialGroup()
						.addComponent(jLabel1)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		connectPanelLayout.setVerticalGroup(
				connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(connectPanelLayout.createSequentialGroup()
						.addComponent(jLabel1)
						.addGap(20, 20, 20)
						.addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(connectButton))
						.addContainerGap(68, Short.MAX_VALUE))
				);

		connectButton.getAccessibleContext().setAccessibleName("connectButton");

		status.setText(" ");

		finderPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		findGame.setText("Find a game");
		findGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				findGameActionPerformed(evt);
			}
		});

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
		jLabel2.setText("Game finder");

		javax.swing.GroupLayout finderPanelLayout = new javax.swing.GroupLayout(finderPanel);
		finderPanel.setLayout(finderPanelLayout);
		finderPanelLayout.setHorizontalGroup(
				finderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(finderPanelLayout.createSequentialGroup()
						.addGroup(finderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel2)
								.addGroup(finderPanelLayout.createSequentialGroup()
										.addGap(70, 70, 70)
										.addComponent(findGame)))
						.addContainerGap(73, Short.MAX_VALUE))
				);
		finderPanelLayout.setVerticalGroup(
				finderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(finderPanelLayout.createSequentialGroup()
						.addComponent(jLabel2)
						.addGap(30, 30, 30)
						.addComponent(findGame)
						.addContainerGap(47, Short.MAX_VALUE))
				);

		gamePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
		jLabel3.setText("Game");

		javax.swing.GroupLayout plateauLayout = new javax.swing.GroupLayout(plateau);
		plateau.setLayout(plateauLayout);
		plateauLayout.setHorizontalGroup(
				plateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 500, Short.MAX_VALUE)
				);
		plateauLayout.setVerticalGroup(
				plateauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 500, Short.MAX_VALUE)
				);

		turnInfo.setActionCommand("turnInfo");
		turnInfo.setEnabled(false);

		javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
		gamePanel.setLayout(gamePanelLayout);
		gamePanelLayout.setHorizontalGroup(
				gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gamePanelLayout.createSequentialGroup()
						.addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(gamePanelLayout.createSequentialGroup()
										.addComponent(jLabel3)
										.addGap(0, 65, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
										.addGap(0, 0, Short.MAX_VALUE)
										.addComponent(turnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(18, 18, 18)
						.addComponent(plateau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		gamePanelLayout.setVerticalGroup(
				gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(gamePanelLayout.createSequentialGroup()
						.addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(gamePanelLayout.createSequentialGroup()
										.addComponent(jLabel3)
										.addGap(152, 152, 152)
										.addComponent(turnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(gamePanelLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(plateau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		playedInfos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		playedInfos.setPreferredSize(new Dimension(283, gamePanel.getPreferredSize().height));

		jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
		jLabel4.setText("Infos");
		jLabel4.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel4.setVerticalAlignment(SwingConstants.TOP);

		playedInfos.add(jLabel4);


		/*javax.swing.GroupLayout playedInfosLayout = new javax.swing.GroupLayout(playedInfos);
	        playedInfos.setLayout(playedInfosLayout);
	        playedInfosLayout.setHorizontalGroup(
	            playedInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(playedInfosLayout.createSequentialGroup()
	                .addComponent(jLabel4)
	                .addGap(0, 168, Short.MAX_VALUE))
	        );
	        playedInfosLayout.setVerticalGroup(
	            playedInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(playedInfosLayout.createSequentialGroup()
	                .addComponent(jLabel4)
	                .addContainerGap(283, Short.MAX_VALUE))
	        );*/

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addGap(20, 20, 20)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(connectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(finderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(playedInfos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(21, 21, 21)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(connectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(finderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(playedInfos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
						.addComponent(status))
				);

		pack();

		findGame.setEnabled(false);
	}

	private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
		if (listener != null) {
			final String name = userName.getText();
			new Thread () {
				public void run () {
					listener.notifyConnection(name);
				}
			}.start();
		}
	}                                             

	private void findGameActionPerformed(java.awt.event.ActionEvent evt) {                                         
		if (listener != null) {
			new Thread () {
				public void run () {
					listener.notifyFinder();
				}
			}.start();
		}
	}        


	/**
	 * @param args the command line arguments
	 */
	// Variables declaration - do not modify                     
	private javax.swing.JButton connectButton;
	private javax.swing.JPanel connectPanel;
	private javax.swing.JButton findGame;
	private javax.swing.JButton turnInfo;
	private JPanel playedInfos;
	private javax.swing.JPanel finderPanel;
	private javax.swing.JPanel gamePanel;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private Plateau plateau;
	private javax.swing.JLabel status;
	private javax.swing.JTextField userName;
	// End of variables declaration   



	@Override
	public void updateStatus(String status) {
		if (status == null) {
			this.status.setText("");
		} else {
			this.status.setText(status);
		}
	}

	@Override
	public void updateConnection(String status) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				if (model.isConnected()) {
					connectButton.setText("disconnect");
					userName.setEnabled(false);
					findGame.setEnabled(true);
				}
				else {
					findGame.setEnabled(false);
					userName.setEnabled(true);
					connectButton.setText("connect");
				}
				updateStatus(status);
			}
		});

	}



	@Override
	public void updateChessGame(String status) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				plateau.setPieces(model);
				plateau.updatePlateau();
				updateStatus(status);
			}
		});
	}


	@Override
	public void updateSearchingGame(String status) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				if (model.isSearching()) findGame.setText("cancel");
				else findGame.setText("Find a game");
				updateStatus(status);
			}
		});
	}

	@Override
	public void requestMove(int x, int y, int x2, int y2) {
		listener.requestMove(x,y,x2,y2);
	}

	@Override
	public void updateMove(String status, int x, int y, int x2, int y2) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				plateau.unselectAll();
				updateStatus(status);
				playedInfos.add(new InformationUI(x, y, x2, y2));
				playedInfos.revalidate();
				playedInfos.repaint();
				plateau.updatePlateau();
			}
		});
	}



}
