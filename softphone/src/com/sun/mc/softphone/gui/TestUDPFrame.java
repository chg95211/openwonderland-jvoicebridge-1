package com.sun.mc.softphone.gui;

import java.io.IOException;

import java.util.Timer;
import java.util.TimerTask;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TestUDPFrame.java
 *
 * Created on Jan 7, 2010, 11:49:25 AM
 */

/**
 *
 * @author jp
 */
public class TestUDPFrame extends javax.swing.JFrame implements UDPTesterListener {

    /** Creates new form TestUDPFrame */
    public TestUDPFrame() {
        initComponents();
	getRootPane().setDefaultButton(testButton);
	setVisible(true);
    }

    public TestUDPFrame(int port, int duration) {
        initComponents();
	getRootPane().setDefaultButton(testButton);
	setVisible(true);

	UDPPortTextField.setText(String.valueOf(port));
	durationTextField.setText(String.valueOf(duration));

	startTest(port, duration);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        testButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UDPPortTextField = new javax.swing.JTextField();
        durationTextField = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("UDP Port Tester");

        testButton.setText("Test");
        testButton.setEnabled(false);
        testButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("UDP Port:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Seconds to Test:");

        UDPPortTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                UDPPortTextFieldKeyReleased(evt);
            }
        });

        durationTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                durationTextFieldKeyReleased(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(statusLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(cancelButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(45, 45, 45))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 30, Short.MAX_VALUE)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(durationTextField)
                                    .add(UDPPortTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .add(testButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(30, 30, 30)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(UDPPortTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(durationTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .add(18, 18, 18)
                .add(statusLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(31, 31, 31)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(testButton)
                    .add(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void testButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testButtonActionPerformed
	int port;

	try {
	    port = Integer.parseInt(UDPPortTextField.getText());
	} catch (NumberFormatException e) {
	    statusLabel.setText("Invalid port number");
	    return;
	}

	int seconds;

	try {
	    seconds = Integer.parseInt(durationTextField.getText());
	} catch (NumberFormatException e) {
	    statusLabel.setText("Invalid number of seconds");
	    return;
	}

	startTest(port, seconds);
    }

    private UDPTester udpTester;

    private void startTest(int port, final int seconds) {
	try {
	    if (udpTester != null) {
		udpTester.done();
	    }

            udpTester = new UDPTester(this, port, seconds);

	    /*
	     * This message must be in this format for listeners to parse!
	     */
	    System.out.println("TestUDPPort:" + port + ":" + seconds);

	    testButton.setEnabled(false);

	    Timer timer = new Timer();

	    timer.schedule(new TimerTask() {
		public void run() {
		    testButton.setEnabled(true);
		    udpTester.done();
		}
	    }, (seconds + 1) * 1000);
	} catch (IOException e) {
	    statusLabel.setText("IOException:  " + e.getMessage());
	}
    }//GEN-LAST:event_testButtonActionPerformed

    private void UDPPortTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UDPPortTextFieldKeyReleased
	testButton.setEnabled(UDPPortTextField.getText().length() > 0 &&
	    durationTextField.getText().length() > 0);
    }//GEN-LAST:event_UDPPortTextFieldKeyReleased

    private void durationTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_durationTextFieldKeyReleased
	testButton.setEnabled(UDPPortTextField.getText().length() > 0 &&
	    durationTextField.getText().length() > 0);
    }//GEN-LAST:event_durationTextFieldKeyReleased

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    public void status(String status) {
	statusLabel.setText(status);
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestUDPFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField UDPPortTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField durationTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton testButton;
    // End of variables declaration//GEN-END:variables

}
