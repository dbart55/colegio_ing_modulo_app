/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package consejodepartamental.ui;

import consejodepartamental.entity.Capitulo;
import consejodepartamental.entity.EventoModalidad;
import consejodepartamental.entity.EventoModular;
import consejodepartamental.entity.Organizador;
import consejodepartamental.entity.TipoEvento;
import consejodepartamental.entity.Usuario;
import consejodepartamental.logic.Controlador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Diego
 */
public class ListModularEventFrame extends javax.swing.JFrame {

    private Controlador controlador;
    private DefaultTableModel tableModel;
    private List<Capitulo> capitulos;
    private List<EventoModalidad> modalidades;
    private List<TipoEvento> tipos;
    private List<EventoModular> eventosModulares;
    private SaveModularEventFrame saveModularEventFrame;

    public ListModularEventFrame() {
        initComponents();

        this.controlador = new Controlador();
        this.capitulos = new ArrayList<>();
        this.modalidades = new ArrayList<>();
        this.tipos = new ArrayList<>();

        this.capitulos.add(new Capitulo(0, "Todos"));
        this.capitulos.addAll(this.controlador.obtenerCapitulos());
        this.capituloCombo.setModel(new DefaultComboBoxModel(this.capitulos.toArray()));

        this.modalidades.add(new EventoModalidad(0, "Todos"));
        this.modalidades.addAll(this.controlador.obtenerModalidades());
        this.modalityCombo.setModel(new DefaultComboBoxModel(this.modalidades.toArray()));

        this.tipos.add(new TipoEvento(0, "Todos"));
        this.tipos.addAll(this.controlador.obtenerTipos());
        this.tipoEventoCombo.setModel(new DefaultComboBoxModel(this.tipos.toArray()));

        this.tableModel = (DefaultTableModel) this.eventoModularTable.getModel();

    }

    public void llenarTabla() {
        String codeOrTema = this.codeTextField.getText();
        System.out.println("code " + codeOrTema);
        Capitulo capituloSelected = (Capitulo) this.capituloCombo.getSelectedItem();
        System.out.println("capituloSelected " + capituloSelected);

        EventoModalidad modalidadSelected = (EventoModalidad) this.modalityCombo.getSelectedItem();
        System.out.println("modalidadSelected " + modalidadSelected);

        TipoEvento tipoSelected = (TipoEvento) this.tipoEventoCombo.getSelectedItem();
        System.out.println("tipoSelected " + tipoSelected);

        this.eventosModulares = this.controlador.obtenerEventosModulares(codeOrTema, capituloSelected, modalidadSelected, tipoSelected);

        DefaultTableModel tableModel = (DefaultTableModel) this.eventoModularTable.getModel();
        tableModel.setRowCount(0); //limpiar la tabla

        Object cells[] = new Object[10];

        for (EventoModular em : this.eventosModulares) {
            cells[0] = em.getCodigo();
            cells[1] = em.getModalidadNombre();
            cells[2] = em.getCapituloNombre();
            cells[3] = em.getTipoNombre();
            cells[4] = em.getTema();
            cells[5] = em.getCantidad();
            cells[6] = em.getInicio();
            cells[7] = em.getFin();
            cells[8] = em.getHoras();
            cells[9] = em.getLugar();
            tableModel.addRow(cells);
        }

        this.eventoModularTable.setModel(tableModel);
    }

    @Override
    public void dispose() {
        this.controlador.finalizar();
        super.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        codeTextField = new javax.swing.JTextField();
        capituloLabel = new javax.swing.JLabel();
        codeLabel = new javax.swing.JLabel();
        capituloCombo = new javax.swing.JComboBox<>();
        modalityLabel = new javax.swing.JLabel();
        tipoEventoCombo = new javax.swing.JComboBox<>();
        tipoEventoLabel = new javax.swing.JLabel();
        modalityCombo = new javax.swing.JComboBox<>();
        statusCheck = new javax.swing.JCheckBox();
        buttonPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventoModularTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(23, 33, 42));

        capituloLabel.setFont(new java.awt.Font("Corbel Light", 0, 16)); // NOI18N
        capituloLabel.setForeground(new java.awt.Color(255, 255, 255));
        capituloLabel.setLabelFor(capituloCombo);
        capituloLabel.setText("Organizadores");

        codeLabel.setBackground(new java.awt.Color(255, 255, 255));
        codeLabel.setFont(new java.awt.Font("Corbel Light", 0, 16)); // NOI18N
        codeLabel.setForeground(new java.awt.Color(255, 255, 255));
        codeLabel.setLabelFor(codeTextField);
        codeLabel.setText("Codigo o Tema");

        capituloCombo.setEditable(true);

        modalityLabel.setFont(new java.awt.Font("Corbel Light", 0, 16)); // NOI18N
        modalityLabel.setForeground(new java.awt.Color(255, 255, 255));
        modalityLabel.setLabelFor(modalityCombo);
        modalityLabel.setText("Modalidad");

        tipoEventoCombo.setEditable(true);

        tipoEventoLabel.setFont(new java.awt.Font("Corbel Light", 0, 16)); // NOI18N
        tipoEventoLabel.setForeground(new java.awt.Color(255, 255, 255));
        tipoEventoLabel.setLabelFor(tipoEventoCombo);
        tipoEventoLabel.setText("Tipo capacitación");

        modalityCombo.setEditable(true);

        statusCheck.setBackground(new java.awt.Color(23, 33, 42));
        statusCheck.setFont(new java.awt.Font("Corbel Light", 0, 14)); // NOI18N
        statusCheck.setForeground(new java.awt.Color(255, 255, 255));
        statusCheck.setText("Estado");

        buttonPanel.setBackground(new java.awt.Color(23, 33, 42));
        buttonPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        addButton.setBackground(new java.awt.Color(23, 33, 42));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/add.png"))); // NOI18N
        addButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(23, 33, 42));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/remove.png"))); // NOI18N
        deleteButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        updateButton.setBackground(new java.awt.Color(23, 33, 42));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/redo.png"))); // NOI18N
        updateButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        searchButton.setBackground(new java.awt.Color(23, 33, 42));
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/search.png"))); // NOI18N
        searchButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        eventoModularTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Modalidad", "Organizador", "Tipo", "Evento", "Cantidad", "Inicio", "Fin", "Horas", "Lugar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(eventoModularTable);
        if (eventoModularTable.getColumnModel().getColumnCount() > 0) {
            eventoModularTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            eventoModularTable.getColumnModel().getColumn(1).setPreferredWidth(5);
            eventoModularTable.getColumnModel().getColumn(2).setPreferredWidth(30);
            eventoModularTable.getColumnModel().getColumn(3).setPreferredWidth(90);
            eventoModularTable.getColumnModel().getColumn(4).setPreferredWidth(300);
            eventoModularTable.getColumnModel().getColumn(5).setPreferredWidth(5);
            eventoModularTable.getColumnModel().getColumn(6).setPreferredWidth(5);
            eventoModularTable.getColumnModel().getColumn(7).setPreferredWidth(5);
            eventoModularTable.getColumnModel().getColumn(8).setPreferredWidth(5);
            eventoModularTable.getColumnModel().getColumn(9).setPreferredWidth(8);
        }

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(capituloCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(capituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modalityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modalityLabel))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipoEventoLabel)
                            .addGroup(backgroundPanelLayout.createSequentialGroup()
                                .addComponent(tipoEventoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(statusCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 252, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(capituloLabel)
                    .addComponent(modalityLabel)
                    .addComponent(tipoEventoLabel)
                    .addComponent(codeLabel))
                .addGap(0, 0, 0)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capituloCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modalityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoEventoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (this.saveModularEventFrame == null || !this.saveModularEventFrame.isDisplayable()) {
            this.saveModularEventFrame = new SaveModularEventFrame();
            this.saveModularEventFrame.setVisible(true);
            this.saveModularEventFrame.setLocationRelativeTo(null);
        } else {
            this.saveModularEventFrame.requestFocus();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed

    }//GEN-LAST:event_updateButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        llenarTabla();
    }//GEN-LAST:event_searchButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JComboBox<String> capituloCombo;
    private javax.swing.JLabel capituloLabel;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JTextField codeTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTable eventoModularTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> modalityCombo;
    private javax.swing.JLabel modalityLabel;
    private javax.swing.JButton searchButton;
    private javax.swing.JCheckBox statusCheck;
    private javax.swing.JComboBox<String> tipoEventoCombo;
    private javax.swing.JLabel tipoEventoLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
