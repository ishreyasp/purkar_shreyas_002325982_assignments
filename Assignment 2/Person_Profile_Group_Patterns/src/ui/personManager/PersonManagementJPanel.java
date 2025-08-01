/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.personManager;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Person;
import model.PersonDirectory;

/**
 * Class for PersonManagementJPanel
 * 
 * @author Shreyas Purkar
 */
public class PersonManagementJPanel extends javax.swing.JPanel {
    
    private final PersonDirectory persons;
    private final JPanel userProcessContainer;
    
    /**
     * Creates new form PersonManagementJPanel
     * 
     * @param persons
     * @param userProcessContainer 
     */
    public PersonManagementJPanel(PersonDirectory persons, JPanel userProcessContainer) {
        initComponents();
        
        this.persons = persons;
        this.userProcessContainer = userProcessContainer;
        
        populateDummyPersonData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCreatePerson = new javax.swing.JButton();
        btnListPerson = new javax.swing.JButton();
        btnSeperator = new javax.swing.JSeparator();
        btnSearchPerson = new javax.swing.JButton();
        txtSearchPerson = new javax.swing.JTextField();
        lblErrSearch = new javax.swing.JLabel();

        btnCreatePerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/create.png"))); // NOI18N
        btnCreatePerson.setText("Create Person");
        btnCreatePerson.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreatePerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreatePersonActionPerformed(evt);
            }
        });

        btnListPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/list.png"))); // NOI18N
        btnListPerson.setText("List Person");
        btnListPerson.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListPersonActionPerformed(evt);
            }
        });

        btnSearchPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/search-btn.png"))); // NOI18N
        btnSearchPerson.setText("Search");
        btnSearchPerson.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchPersonActionPerformed(evt);
            }
        });

        txtSearchPerson.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchPersonKeyReleased(evt);
            }
        });

        lblErrSearch.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchPerson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchPerson)
                    .addComponent(btnSeperator)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnListPerson, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreatePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblErrSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCreatePerson, btnListPerson});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnCreatePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnListPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(txtSearchPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblErrSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearchPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnListPerson, txtSearchPerson});

    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method to handle create person button click action
     * 
     * @param evt event 
     */
    private void btnCreatePersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreatePersonActionPerformed
        CreatePersonJPanel panel = new CreatePersonJPanel(persons);
        userProcessContainer.add("CreatePersonJPanel", panel);
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCreatePersonActionPerformed

    /**
     * Method to handle list person button click action
     * 
     * @param evt event
     */
    private void btnListPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListPersonActionPerformed
        ListPersonsJPanel panel = new ListPersonsJPanel(persons, userProcessContainer);
        userProcessContainer.add("ListPersonsJPanel", panel);
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnListPersonActionPerformed

    /**
     * Method to handle search person button click action
     * 
     * @param evt event
     */
    private void btnSearchPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchPersonActionPerformed
        if (txtSearchPerson.getText().isBlank()) {
            lblErrSearch.setText("Enter search value");
            return;
        }
        
        String searchValue = txtSearchPerson.getText();
        Person existingPerson = persons.searchPerson(searchValue);
        
        if (existingPerson != null) {
            ViewPersonJPanel panel = new ViewPersonJPanel(persons, existingPerson);
            userProcessContainer.add("ViewPersonJPanel", panel);
        
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        
        if (existingPerson == null) {
            lblErrSearch.setText("Person not found");
            txtSearchPerson.setText("");
            return;
        }
        
        txtSearchPerson.setText("");
    }//GEN-LAST:event_btnSearchPersonActionPerformed

    private void txtSearchPersonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchPersonKeyReleased
        lblErrSearch.setText("");
    }//GEN-LAST:event_txtSearchPersonKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreatePerson;
    private javax.swing.JButton btnListPerson;
    private javax.swing.JButton btnSearchPerson;
    private javax.swing.JSeparator btnSeperator;
    private javax.swing.JLabel lblErrSearch;
    private javax.swing.JTextField txtSearchPerson;
    // End of variables declaration//GEN-END:variables

    /**
     * Method to load dummy person data
     */
    private void populateDummyPersonData() {        
        Person firstPerson = new Person();
        firstPerson.setFirstName("John");
        firstPerson.setLastName("Doe");
        firstPerson.setAge((byte) 26);
        firstPerson.setSsn("2548-8954-855");
        firstPerson.setHomeAddress("11 Center Street", 
                (short) 3, 
                "Boston", 
                "Massachusetts", 
                02130, 
                3652148790L);
        firstPerson.setWorkAddress("369 Mass Ave", 
                (short) 1, 
                "New York City", 
                "New York", 
                44420, 
                8527419630L);
        
        Person secondPerson = new Person();
        secondPerson.setFirstName("Tony");
        secondPerson.setLastName("Stark");
        secondPerson.setAge((byte) 26);
        secondPerson.setSsn("2548-8954-855");
        secondPerson.setHomeAddress("19 Priesing Street", 
                (short) 3, 
                "Richmond", 
                "Virginia", 
                96230, 
                5752148790L);
        secondPerson.setWorkAddress("201 Armstrong Ave", 
                (short) 1, 
                "Portland", 
                "Maine", 
                85792, 
                8527419630L);
        
        Person thridPerson = new Person();
        thridPerson.setFirstName("Ricky");
        thridPerson.setLastName("Ponting");
        thridPerson.setAge((byte) 26);
        thridPerson.setSsn("2548-8954-855");
        thridPerson.setHomeAddress("11 Center Street", 
                (short) 3, 
                "Boston", 
                "Massachusetts", 
                02130, 
                3652148790L);
        thridPerson.setWorkAddress("369 Mass Ave", 
                (short) 1, 
                "New York City", 
                "New York", 
                44420, 
                8527419630L);
        
        Person fourthPerson = new Person();
        fourthPerson.setFirstName("Tommy");
        fourthPerson.setLastName("Johnson");
        fourthPerson.setAge((byte) 26);
        fourthPerson.setSsn("2548-8954-855");
        fourthPerson.setHomeAddress("11 Center Street", 
                (short) 3, 
                "Boston", 
                "Massachusetts", 
                02130, 
                3652148790L);
        fourthPerson.setWorkAddress("369 Mass Ave", 
                (short) 1, 
                "New York City", 
                "New York", 
                44420, 
                8527419630L);
        
        Person fifthPerson = new Person();
        fifthPerson.setFirstName("Daniel");
        fifthPerson.setLastName("Thomson");
        fifthPerson.setAge((byte) 26);
        fifthPerson.setSsn("2548-8954-855");
        fifthPerson.setHomeAddress("11 Center Street", 
                (short) 3, 
                "Boston", 
                "Massachusetts", 
                02130, 
                3652148790L);
        fifthPerson.setWorkAddress("369 Mass Ave", 
                (short) 1, 
                "New York City", 
                "New York", 
                44420, 
                8527419630L);
        
        persons.addPerson(firstPerson);
        persons.addPerson(secondPerson);
        persons.addPerson(thridPerson);
        persons.addPerson(fourthPerson);
        persons.addPerson(fifthPerson);
    }
}