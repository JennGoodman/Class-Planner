package Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrick
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    public HomePage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnViewClassrooms1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnNewClass = new javax.swing.JButton();
        btnNewClassroom = new javax.swing.JButton();
        btnNewBuilding = new javax.swing.JButton();
        btnNewSchedule = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnViewCourses = new javax.swing.JButton();
        btnViewSchedule = new javax.swing.JButton();
        btnViewClassrooms2 = new javax.swing.JButton();
        btnViewBuildings = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();

        btnViewClassrooms1.setText("View Classrooms");
        btnViewClassrooms1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewClassrooms1.setMinimumSize(new java.awt.Dimension(75, 75));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Class-Planner");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Create"));
        jPanel1.setPreferredSize(new java.awt.Dimension(380, 150));

        btnNewClass.setText("New Course");
        btnNewClass.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNewClass.setMinimumSize(new java.awt.Dimension(75, 75));
        btnNewClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewClassMouseClicked(evt);
            }
        });

        btnNewClassroom.setText("New Classroom");
        btnNewClassroom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNewClassroom.setMinimumSize(new java.awt.Dimension(75, 75));
        btnNewClassroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewClassroomActionPerformed(evt);
            }
        });

        btnNewBuilding.setText("New Building");
        btnNewBuilding.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNewBuilding.setMinimumSize(new java.awt.Dimension(75, 75));
        btnNewBuilding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewBuildingActionPerformed(evt);
            }
        });

        btnNewSchedule.setText("New Schedule");
        btnNewSchedule.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNewSchedule.setMinimumSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNewClass, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(btnNewBuilding, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNewClassroom, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNewSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewClass, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewBuilding, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewClassroom, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(123, 123, 123))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("View"));

        btnViewCourses.setText("View Courses");
        btnViewCourses.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewCourses.setMinimumSize(new java.awt.Dimension(75, 75));
        btnViewCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewCoursesMouseClicked(evt);
            }
        });
        btnViewCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewCoursesActionPerformed(evt);
            }
        });

        btnViewSchedule.setText("View Schedule");
        btnViewSchedule.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewSchedule.setMinimumSize(new java.awt.Dimension(75, 75));

        btnViewClassrooms2.setText("View Classrooms");
        btnViewClassrooms2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewClassrooms2.setMinimumSize(new java.awt.Dimension(75, 75));
        btnViewClassrooms2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewClassrooms2ActionPerformed(evt);
            }
        });

        btnViewBuildings.setText("View Buildings");
        btnViewBuildings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewBuildings.setMinimumSize(new java.awt.Dimension(75, 75));
        btnViewBuildings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBuildingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnViewCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewBuildings, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnViewClassrooms2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewBuildings, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewClassrooms2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnQuit.setText("Quit Program");
        btnQuit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQuit.setMinimumSize(new java.awt.Dimension(75, 75));
        btnQuit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnQuitMouseClicked

    private void btnNewClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewClassMouseClicked
        // TODO add your handling code here:
        CreateCourse n = new CreateCourse();
        n.setVisible(true);
    }//GEN-LAST:event_btnNewClassMouseClicked

    private void btnNewBuildingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewBuildingActionPerformed
        // TODO add your handling code here:
        CreateBuilding n = new CreateBuilding();
        n.setVisible(true);
    }//GEN-LAST:event_btnNewBuildingActionPerformed

    private void btnNewClassroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewClassroomActionPerformed
        // TODO add your handling code here:
        CreateClassroom n = new CreateClassroom();
        n.setVisible(true);
    }//GEN-LAST:event_btnNewClassroomActionPerformed

    private void btnViewCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewCoursesMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnViewCoursesMouseClicked

    private void btnViewCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewCoursesActionPerformed
        // TODO add your handling code here:
        ViewCourses n = new ViewCourses();
        n.setVisible(true);
    }//GEN-LAST:event_btnViewCoursesActionPerformed

    private void btnViewBuildingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBuildingsActionPerformed
        ViewBuildings n = new ViewBuildings();
        n.setVisible(true);
    }//GEN-LAST:event_btnViewBuildingsActionPerformed

    private void btnViewClassrooms2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewClassrooms2ActionPerformed
        ViewRooms n = new ViewRooms();
        n.setVisible(true);
    }//GEN-LAST:event_btnViewClassrooms2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewBuilding;
    private javax.swing.JButton btnNewClass;
    private javax.swing.JButton btnNewClassroom;
    private javax.swing.JButton btnNewSchedule;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnViewBuildings;
    private javax.swing.JButton btnViewClassrooms1;
    private javax.swing.JButton btnViewClassrooms2;
    private javax.swing.JButton btnViewCourses;
    private javax.swing.JButton btnViewSchedule;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
