/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Contributor(s):
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2006 Sun
 * Microsystems, Inc. All Rights Reserved.
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 */

package org.netbeans.modules.profiler.attach.panels;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.openide.util.NbBundle;

/**
 *
 * @author  Jaroslav Bachorik
 */
@NbBundle.Messages({
    "TargetSettingsWizardPanelUI_SelectHostOsString=<Select Host OS & JVM>"
})
public class RemoteAttachSettingsPanelUI extends javax.swing.JPanel implements DocumentListener {
  private class HostOsComboBoxModel extends DefaultComboBoxModel {
    public HostOsComboBoxModel() {
      super();
    }
    public HostOsComboBoxModel(Object[] objects) {
      super(objects);
      this.insertElementAt(Bundle.TargetSettingsWizardPanelUI_SelectHostOsString(), 0);
      this.fireIntervalAdded(this, 0, 0);
      this.setSelectedItem(this.getElementAt(0));
    }
    public void setSelectedItem(Object anObject) {
      super.setSelectedItem(anObject);
      if (!anObject.equals(Bundle.TargetSettingsWizardPanelUI_SelectHostOsString())) {
        if (getElementAt(0).equals(Bundle.TargetSettingsWizardPanelUI_SelectHostOsString())) {
          removeElementAt(0);
          this.fireIntervalRemoved(this, 0, 0);
        }
      }
    }
  }
  private RemoteAttachSettingsPanel.Model model;
  private HostOsComboBoxModel comboModel;
  
  /**
   * Creates new form RemoteAttachSettingsPanelUI
   */
  public RemoteAttachSettingsPanelUI(RemoteAttachSettingsPanel.Model model) {
    this.model = model; // MUST be the first statement in constructor
    comboModel = new HostOsComboBoxModel(model.getAvailableOsList());
    initComponents();
    
    this.model.setRemoteOs((String)comboHostOs.getSelectedItem());
  }
  
  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hintPanel = new org.netbeans.modules.profiler.attach.panels.components.ResizableHintPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textHostname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboHostOs = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(500, 400));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/netbeans/modules/profiler/attach/panels/Bundle"); // NOI18N
        hintPanel.setHint(bundle.getString("TargetSettingsWizardPanelUI_RemotePacksHelpString")); // NOI18N
        hintPanel.setMinimumSize(new java.awt.Dimension(0, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(RemoteAttachSettingsPanelUI.class, "TargetSettingsWizardPanelUI_ProvideRemoteConfigString"))); // NOI18N

        jLabel2.setLabelFor(textHostname);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, bundle.getString("TargetSettingsWizardPanelUI_HostNameString")); // NOI18N

        textHostname.getDocument().addDocumentListener(this);
        textHostname.setPreferredSize(new java.awt.Dimension(200, 24));
        textHostname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textHostnameKeyTyped(evt);
            }
        });

        jLabel3.setLabelFor(comboHostOs);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, bundle.getString("TargetSettingsWizardPanelUI_HostOsString")); // NOI18N

        comboHostOs.setModel(getHostOsModel());
        comboHostOs.setMaximumSize(new java.awt.Dimension(250, 19));
        comboHostOs.setMinimumSize(new java.awt.Dimension(160, 19));
        comboHostOs.setPreferredSize(new java.awt.Dimension(200, 24));
        comboHostOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboHostOsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboHostOs, javax.swing.GroupLayout.Alignment.LEADING, 0, 408, Short.MAX_VALUE)
                    .addComponent(textHostname, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textHostname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addComponent(comboHostOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        textHostname.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(RemoteAttachSettingsPanelUI.class, "RemoteAttachSettingsPanelUI.textHostname.AccessibleContext.accessibleDescription")); // NOI18N
        comboHostOs.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(RemoteAttachSettingsPanelUI.class, "RemoteAttachSettingsPanelUI.comboHostOs.AccessibleContext.accessibleDescription")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(hintPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hintPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
        );

        hintPanel.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(RemoteAttachSettingsPanelUI.class, "RemoteAttachSettingsPanelUI.hintPanel.AccessibleContext.accessibleName")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents
  
    private void comboHostOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboHostOsActionPerformed
      this.model.setRemoteOs(comboHostOs.getSelectedItem().toString());
    }//GEN-LAST:event_comboHostOsActionPerformed
    
    private void textHostnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textHostnameKeyTyped
          }//GEN-LAST:event_textHostnameKeyTyped
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboHostOs;
    private org.netbeans.modules.profiler.attach.panels.components.ResizableHintPanel hintPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField textHostname;
    // End of variables declaration//GEN-END:variables
  
  public ComboBoxModel getHostOsModel() {
    return comboModel;
  }
  
  public void removeUpdate(DocumentEvent e) {
    this.model.setRemoteHost(textHostname.getText());
  }
  
  public void insertUpdate(DocumentEvent e) {
    this.model.setRemoteHost(textHostname.getText());
  }
  
  public void changedUpdate(DocumentEvent e) {
    this.model.setRemoteHost(textHostname.getText());
  }
  
  public void refresh() {
    if (model.getRemoteOs() != null)
      comboHostOs.setSelectedItem(model.getRemoteOs());
    textHostname.setText(model.getRemoteHost());
  }
}
