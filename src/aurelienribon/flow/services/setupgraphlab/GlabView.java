package aurelienribon.flow.services.setupgraphlab;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class GlabView extends javax.swing.JPanel {
    public GlabView() {
        initComponents();
    }

	public void appendCommand(String cmd) {
		if (!consoleArea.getText().isEmpty()) consoleArea.append("\n\n");
		consoleArea.append("> " + cmd);
		consoleArea.setCaretPosition(consoleArea.getText().length());
	}

	public void appendAnswer(String txt) {
		if (!consoleArea.getText().isEmpty()) consoleArea.append("\n\n");
		consoleArea.append(txt);
		consoleArea.setCaretPosition(consoleArea.getText().length());
	}

	public void clear() {
		consoleArea.setText("");
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        consoleArea = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        consoleArea.setColumns(20);
        consoleArea.setEditable(false);
        consoleArea.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        consoleArea.setRows(5);
        consoleArea.setTabSize(4);
        jScrollPane1.setViewportView(consoleArea);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea consoleArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
