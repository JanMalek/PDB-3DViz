package hlavni;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.UIManager;

/**
 *
 * @author Honza
 */
public class PripojeniKDB extends javax.swing.JDialog {

    private String[] dbCon = {"null","","","","",""};
    
    /**
     * Creates new form PripojeniKDB
     */
    public PripojeniKDB(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader(new File("DBC")));
        } catch (Exception e) {}
        for (int i = 0; (i < 6) && sc.hasNext(); i++) {
            dbCon[i] = sc.nextLine();
        }
        sc.close();
        initComponents();
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        f2_HostName = new javax.swing.JTextField();
        f3_Port = new javax.swing.JTextField();
        f4_SID = new javax.swing.JTextField();
        f5_UserName = new javax.swing.JTextField();
        f6_PW = new javax.swing.JPasswordField();
        savePW = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        testRes = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pøipojení k databázi");

        jPanel2.setLayout(new java.awt.GridBagLayout());

        f2_HostName.setText(dbCon[1]);
        f2_HostName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f2_HostNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 10);
        jPanel2.add(f2_HostName, gridBagConstraints);
        f2_HostName.getAccessibleContext().setAccessibleName("f2_HostName");

        f3_Port.setText(dbCon[2]);
        f3_Port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f3_PortActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 10);
        jPanel2.add(f3_Port, gridBagConstraints);
        f3_Port.getAccessibleContext().setAccessibleName("f3_Port");
        f3_Port.getAccessibleContext().setAccessibleDescription("");

        f4_SID.setText(dbCon[3]);
        f4_SID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f4_SIDActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 10);
        jPanel2.add(f4_SID, gridBagConstraints);
        f4_SID.getAccessibleContext().setAccessibleName("f4_SID");

        f5_UserName.setText(dbCon[4]);
        f5_UserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f5_UserNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 10);
        jPanel2.add(f5_UserName, gridBagConstraints);
        f5_UserName.getAccessibleContext().setAccessibleName("f5_UserName");

        f6_PW.setText(dbCon[5]);
        f6_PW.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 10);
        jPanel2.add(f6_PW, gridBagConstraints);
        f6_PW.getAccessibleContext().setAccessibleName("f6_PW");
        f6_PW.getAccessibleContext().setAccessibleDescription("");

        savePW.setText("save Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 11);
        jPanel2.add(savePW, gridBagConstraints);

        jLabel1.setText("Hostname");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Port");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(jLabel2, gridBagConstraints);

        jLabel3.setText("SID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(jLabel4, gridBagConstraints);

        jLabel6.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(jLabel6, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Connect");
        jButton1.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        jButton1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
        jPanel3.add(jButton1, gridBagConstraints);

        testRes.setText("    ");
        testRes.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel3.add(testRes, gridBagConstraints);

        jButton2.setText("Test");
        jButton2.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        jButton2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				testConnection();
			}
		});
        jPanel3.add(jButton2, gridBagConstraints);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        getAccessibleContext().setAccessibleName("DBconnection");

        pack();
    }// </editor-fold>                        

    private void f2_HostNameActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void f3_PortActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void f4_SIDActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void f5_UserNameActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    /**
     * @param args the command line arguments
     */
    public static void createDialog() {
        try {
        	UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PripojeniKDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PripojeniKDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PripojeniKDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PripojeniKDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PripojeniKDB dialog = new PripojeniKDB(new javax.swing.JFrame(), true);
                Dimension size = new Dimension(320,210);
                dialog.setSize(size);
                dialog.setMinimumSize(size);
                dialog.setMaximumSize(size);
                dialog.setLocationRelativeTo(null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
	private boolean testConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@"+f2_HostName.getText()+":"+f3_Port.getText()+":"+f4_SID.getText(), f5_UserName.getText(),
					f6_PW.getText());
			testRes.setText("  OK  ");
			connection.close();
			saveCred();
			return true;
		} catch (Exception e) {
			testRes.setText("failed");
			e.printStackTrace();
			saveCred();
			return false;
		}
	}
   
    private void connect() {
		try {
			if (!testConnection()) throw new Exception();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@"+f2_HostName.getText()+":"+f3_Port.getText()+":"+f4_SID.getText(), f5_UserName.getText(),
					f6_PW.getText());
			ArrayList<ArrayList<Polygon3D>> budovy = getBudovy(connection);
			connection.close();
			this.dispose();
			new Ramec(budovy).toFront();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    private void saveCred() {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new File("DBC"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		ps.println("null");
		ps.println(f2_HostName.getText());
		ps.println(f3_Port.getText());
		ps.println(f4_SID.getText());
		ps.println(f5_UserName.getText());
		ps.println(savePW.isSelected() ? f6_PW.getText() : "");
		ps.close();
	}
    
	public static ArrayList<ArrayList<Polygon3D>> getBudovy(Connection con) throws SQLException {
		ArrayList<ArrayList<Polygon3D>> budovy = new ArrayList<ArrayList<Polygon3D>>();
		Statement stmt = null;
		String query = "SELECT SDO_UTIL.TO_KMLGEOMETRY(b.GEOM) as kml FROM BUDOVY b";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				budovy.add(getBudovu(rs.getString("kml")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return budovy;
	}
	
	

	private static ArrayList<Polygon3D> getBudovu(String kml) {
		ArrayList<Polygon3D> budova = new ArrayList<Polygon3D>();
		while (true) {
			if (kml.indexOf("<coordinates>") == -1) break;
			budova.add(getPolygon3D(kml.substring(kml.indexOf("<coordinates>")+13,kml.indexOf("</coordinates>")-1)));
			kml = kml.substring(kml.indexOf("</coordinates>")+1);
		}
		return budova;
	}

	private static Polygon3D getPolygon3D(String coorListString) {
		String[] xyzString = coorListString.split(" ");
		Coor[] coorField = new Coor[xyzString.length];
		for (int i = 0; i < xyzString.length; i++) {
			String[] coorStringField = xyzString[i].split(",");
			coorField[i] = new Coor(Float.parseFloat(coorStringField[0]),
					Float.parseFloat(coorStringField[1]),
					Float.parseFloat(coorStringField[2]));
		}
		return new Polygon3D(coorField);
	}

	private javax.swing.JTextField f2_HostName;
    private javax.swing.JTextField f3_Port;
    private javax.swing.JTextField f4_SID;
    private javax.swing.JTextField f5_UserName;
    private javax.swing.JPasswordField f6_PW;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel testRes;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JCheckBox savePW;
}
