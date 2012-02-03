package aurelienribon.flow.ui;

import aurelienribon.flow.services.Service;
import aurelienribon.flow.services.ServiceExecutionException;
import aurelienribon.flow.services.ServiceProvider;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.plaf.TabbedPaneUI;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class MainWindow extends javax.swing.JFrame {
	private final Theme theme = new Theme();
	private final ServiceProvider services = new ServiceProvider(this, theme);

    public MainWindow() {
        initComponents();
		modelsPanel.setup(services);

		services.addListener(serviceProviderEventListener);
		services.launchSync(ServiceProvider.SETUP_APP, null);
		services.launchSync(ServiceProvider.SHOW_WELCOME, null);
		services.launchAsync(ServiceProvider.SETUP_GRAPHLAB, null, null);

		tabbedPanel.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) {
				int idx = tabbedPanel.getUI().tabForCoordinate(tabbedPanel, e.getX(), e.getY());
				boolean isMiddle = SwingUtilities.isMiddleMouseButton(e);
				boolean isDoubleLeft = SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2;
				if (idx > -1 && (isMiddle || isDoubleLeft)) tabbedPanel.remove(idx);
			}
		});
    }

	private final ServiceProvider.EventListener serviceProviderEventListener = new ServiceProvider.EventListener() {
		@Override public void serviceCall(String serviceName, Service service, Object input) {}
		@Override public void serviceComplete(String serviceName, Service service) {}
		@Override public void serviceProgressUpdate(String serviceName, Service service, float progress, String description) {}
		@Override public void serviceLog(String serviceName, Service service, String msg) {}
		@Override public void serviceError(String serviceName, Service service, ServiceExecutionException ex) {}
		@Override public void serviceShow(String serviceName, Service service, String title, JPanel panel, Icon icon) {
			tabbedPanel.addTab(title, icon, panel);
			tabbedPanel.setSelectedComponent(panel);
		}
	};

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        modelsPanel = new aurelienribon.flow.ui.modelstree.ModelsPanel();
        perfMonPanel1 = new aurelienribon.flow.ui.perfmon.PerfMonPanel();
        jPanel3 = new javax.swing.JPanel();
        tabbedPanel = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Flow.Synthesis");

        jPanel2.setBackground(theme.MAIN_BACKGROUND_COLOR);

        modelsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        perfMonPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout perfMonPanel1Layout = new javax.swing.GroupLayout(perfMonPanel1);
        perfMonPanel1.setLayout(perfMonPanel1Layout);
        perfMonPanel1Layout.setHorizontalGroup(
            perfMonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        perfMonPanel1Layout.setVerticalGroup(
            perfMonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modelsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(perfMonPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(modelsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(perfMonPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setBackground(theme.MAIN_BACKGROUND_COLOR);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(tabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private aurelienribon.flow.ui.modelstree.ModelsPanel modelsPanel;
    private aurelienribon.flow.ui.perfmon.PerfMonPanel perfMonPanel1;
    private javax.swing.JTabbedPane tabbedPanel;
    // End of variables declaration//GEN-END:variables
}
