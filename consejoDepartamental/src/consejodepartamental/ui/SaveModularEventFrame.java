package consejodepartamental.ui;

import consejodepartamental.entity.Ambiente;
import consejodepartamental.entity.Capitulo;
import consejodepartamental.entity.EventoModalidad;
import consejodepartamental.entity.EventoModular;
import consejodepartamental.entity.Organizador;
import consejodepartamental.entity.TipoEvento;
import consejodepartamental.logic.Controlador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class SaveModularEventFrame extends javax.swing.JFrame {

    /**
     * Creates new form SaveModularEventFrame
     */
    private Controlador controlador;
    private List<Capitulo> capitulos;
    private List<EventoModalidad> modalidades;
    private List<TipoEvento> tipos;
    private List<Ambiente> ambientes;
    private BuscarOrganizadorFrame buscarOrganizadorFrame;
    private List<Organizador> organizadores;
    private String modo;
    private EventoModular editEventoModular;
    private ListModularEventFrame parent;

    public SaveModularEventFrame(ListModularEventFrame parent, EventoModular editEventoModular) {
        initComponents();
        this.controlador = new Controlador();
        this.capitulos = new ArrayList<>();
        this.modalidades = new ArrayList<>();
        this.tipos = new ArrayList<>();
        this.ambientes = new ArrayList<>();
        this.organizadores = new ArrayList<>();

        this.capitulos.add(new Capitulo(0, "-"));
        this.capitulos.addAll(this.controlador.obtenerCapitulos());
        this.organizadorCombo.setModel(new DefaultComboBoxModel(this.capitulos.toArray()));

        this.modalidades.add(new EventoModalidad(0, "-"));
        this.modalidades.addAll(this.controlador.obtenerModalidades());
        this.modalidadCombo.setModel(new DefaultComboBoxModel(this.modalidades.toArray()));

        this.tipos.add(new TipoEvento(0, "-"));
        this.tipos.addAll(this.controlador.obtenerTipos());
        this.tipoCombo.setModel(new DefaultComboBoxModel(this.tipos.toArray()));

        this.ambientes.add(new Ambiente(0, "-"));
        this.ambientes.addAll(this.controlador.obtenerAmbientes());
        this.ambienteCombo.setModel(new DefaultComboBoxModel(this.ambientes.toArray()));

        this.modo = "crear";
        if (editEventoModular != null) {
            this.modo = "editar";
            this.editEventoModular = editEventoModular;
            llenarValoresEventoModular(editEventoModular);
        }

        this.parent = parent;
    }

    private void llenarValoresEventoModular(EventoModular em) {
        if (em != null && em.getCodigo() != 0) {
            EventoModular actualEventoModular = this.controlador.obtenerEventoModularPorCodigo(em.getCodigo());

            if (actualEventoModular.getCod_cap() != 0) {
                this.organizadorCombo.setSelectedIndex(this.capitulos.indexOf(new Capitulo(actualEventoModular.getCod_cap())));
            }

            if (actualEventoModular.getCod_modalidad() != 0) {
                this.modalidadCombo.setSelectedIndex(this.modalidades.indexOf(new EventoModalidad(actualEventoModular.getCod_modalidad())));
            }

            if (actualEventoModular.getCod_tipo() != 0) {
                this.tipoCombo.setSelectedIndex(this.tipos.indexOf(new TipoEvento(actualEventoModular.getCod_tipo())));
            }

            if (actualEventoModular.getId_ambiente() != 0) {
                this.ambienteCombo.setSelectedIndex(this.ambientes.indexOf(new Ambiente(actualEventoModular.getId_ambiente())));
            }

            if (actualEventoModular.getTema() != null) {
                this.temaTextField.setText(actualEventoModular.getTema());
            }

            if (actualEventoModular.getTemario() != null) {
                this.temarioArea.setText(actualEventoModular.getTemario());
            }

            this.cantidadSpinner.setValue(actualEventoModular.getCantidad());
            this.horasSpiner.setValue(actualEventoModular.getHorasTotales());
            this.diasSpinner.setValue(actualEventoModular.getDiaMax());

            this.fechaInicioDate.setDate(actualEventoModular.getInicio());
            this.fechaFinDate.setDate(actualEventoModular.getFin());

            llenarTablaOrganizadores(actualEventoModular.getOrganizadores());
        }
    }

    @Override
    public void dispose() {
        this.controlador.finalizar();
        super.dispose();
    }

    public void llenarTablaOrganizadores(List<Organizador> organizadores) {

        DefaultTableModel tableModel = (DefaultTableModel) this.organizadoresTable.getModel();

        if (organizadores != null && !organizadores.isEmpty()) {
            Object[] cells = new Object[5];
            for (Organizador org : organizadores) {
                if (!this.organizadores.contains(org)) {
                    cells[0] = org.getCip();
                    cells[1] = org.getDni();
                    cells[2] = org.getOrganizador();
                    cells[3] = org.getCelular();
                    cells[4] = org.getCorreo();

                    this.organizadores.add(org);
                    tableModel.addRow(cells);
                }
            }
        }
    }

    private boolean validarCamposObligatorios() {
        return true;
    }

    private boolean validarOrganizadores() {
        if (this.organizadores == null || this.organizadores.isEmpty()) {
            JOptionPane joptionPane = new JOptionPane("Debe ingresar al menos 1 organizador.");
            joptionPane.setMessageType(JOptionPane.WARNING_MESSAGE);
            JDialog dialog = joptionPane.createDialog("Advertencia");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser2 = new javax.swing.JFileChooser();
        jFileChooser3 = new javax.swing.JFileChooser();
        jFileChooser4 = new javax.swing.JFileChooser();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        backgroundPanel = new javax.swing.JPanel();
        tabPanel = new javax.swing.JTabbedPane();
        mainDataPanel = new javax.swing.JPanel();
        organizerLabel = new javax.swing.JLabel();
        modalityLabel = new javax.swing.JLabel();
        enviromentLabel = new javax.swing.JLabel();
        trainingTypeLabel1 = new javax.swing.JLabel();
        temaLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        dateStartLabel = new javax.swing.JLabel();
        dateEndLabel = new javax.swing.JLabel();
        maxQuantityLabel = new javax.swing.JLabel();
        dayMaxLabel = new javax.swing.JLabel();
        totalHoursLabel = new javax.swing.JLabel();
        syllabusLabel = new javax.swing.JLabel();
        tipoCombo = new javax.swing.JComboBox<>();
        organizadorCombo = new javax.swing.JComboBox<>();
        modalidadCombo = new javax.swing.JComboBox<>();
        ambienteCombo = new javax.swing.JComboBox<>();
        temaTextField = new javax.swing.JTextField();
        fechaInicioDate = new com.toedter.calendar.JDateChooser();
        fechaFinDate = new com.toedter.calendar.JDateChooser();
        cantidadSpinner = new javax.swing.JSpinner();
        diasSpinner = new javax.swing.JSpinner();
        horasSpiner = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        temarioArea = new javax.swing.JTextArea();
        imageBtn = new javax.swing.JButton();
        imagenRutaLabel = new javax.swing.JLabel();
        schedulePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        horarioTable = new javax.swing.JTable();
        organizerPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        organizadoresTable = new javax.swing.JTable();
        organizadorBtnPanel = new javax.swing.JPanel();
        agregarOrganizadorBtn = new javax.swing.JButton();
        removerOrganizadorBtn = new javax.swing.JButton();
        guardarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(23, 33, 42));

        tabPanel.setBackground(new java.awt.Color(23, 33, 42));
        tabPanel.setForeground(new java.awt.Color(255, 255, 255));
        tabPanel.setFont(new java.awt.Font("Corbel Light", 0, 14)); // NOI18N

        mainDataPanel.setBackground(new java.awt.Color(23, 33, 42));
        mainDataPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mainDataPanel.setForeground(new java.awt.Color(255, 255, 255));
        mainDataPanel.setFont(new java.awt.Font("Corbel Light", 0, 14)); // NOI18N

        organizerLabel.setFont(new java.awt.Font("Corbel Light", 0, 14)); // NOI18N
        organizerLabel.setForeground(new java.awt.Color(255, 255, 255));
        organizerLabel.setText("Organizadores");

        modalityLabel.setFont(new java.awt.Font("Corbel Light", 0, 14)); // NOI18N
        modalityLabel.setForeground(new java.awt.Color(255, 255, 255));
        modalityLabel.setText("Modalidad");

        enviromentLabel.setFont(new java.awt.Font("Corbel Light", 0, 14)); // NOI18N
        enviromentLabel.setForeground(new java.awt.Color(255, 255, 255));
        enviromentLabel.setText("Ambiente");

        trainingTypeLabel1.setFont(new java.awt.Font("Corbel Light", 0, 14)); // NOI18N
        trainingTypeLabel1.setForeground(new java.awt.Color(255, 255, 255));
        trainingTypeLabel1.setText("Tipo de Capacitación");

        temaLabel.setFont(new java.awt.Font("Corbel Light", 0, 14)); // NOI18N
        temaLabel.setForeground(new java.awt.Color(255, 255, 255));
        temaLabel.setText("Tema");

        imageLabel.setFont(new java.awt.Font("Corbel Light", 0, 14)); // NOI18N
        imageLabel.setForeground(new java.awt.Color(255, 255, 255));
        imageLabel.setText("Imagen");

        dateStartLabel.setFont(new java.awt.Font("Corbel Light", 0, 14)); // NOI18N
        dateStartLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateStartLabel.setText("Fecha Inicio");

        dateEndLabel.setFont(new java.awt.Font("Corbel Light", 0, 14)); // NOI18N
        dateEndLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateEndLabel.setText("Fecha Fin");

        maxQuantityLabel.setFont(new java.awt.Font("Corbel Light", 0, 14)); // NOI18N
        maxQuantityLabel.setForeground(new java.awt.Color(255, 255, 255));
        maxQuantityLabel.setText("Cantidad Max.");

        dayMaxLabel.setFont(new java.awt.Font("Corbel Light", 0, 14)); // NOI18N
        dayMaxLabel.setForeground(new java.awt.Color(255, 255, 255));
        dayMaxLabel.setText("Días Max.");

        totalHoursLabel.setFont(new java.awt.Font("Corbel Light", 0, 14)); // NOI18N
        totalHoursLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalHoursLabel.setText("Horas Totales");

        syllabusLabel.setFont(new java.awt.Font("Corbel Light", 0, 14)); // NOI18N
        syllabusLabel.setForeground(new java.awt.Color(255, 255, 255));
        syllabusLabel.setText("Temario");

        tipoCombo.setEditable(true);

        organizadorCombo.setEditable(true);

        modalidadCombo.setEditable(true);

        ambienteCombo.setEditable(true);

        temaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temaTextFieldActionPerformed(evt);
            }
        });

        fechaInicioDate.setDateFormatString("yyyy-MM-dd");

        fechaFinDate.setDateFormatString("yyyy-MM-dd");

        temarioArea.setColumns(20);
        temarioArea.setRows(5);
        jScrollPane1.setViewportView(temarioArea);

        imageBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/subir.png"))); // NOI18N
        imageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageBtnActionPerformed(evt);
            }
        });

        imagenRutaLabel.setFont(new java.awt.Font("Corbel Light", 0, 12)); // NOI18N
        imagenRutaLabel.setForeground(new java.awt.Color(255, 255, 255));
        imagenRutaLabel.setText("Sin Imagen");

        javax.swing.GroupLayout mainDataPanelLayout = new javax.swing.GroupLayout(mainDataPanel);
        mainDataPanel.setLayout(mainDataPanelLayout);
        mainDataPanelLayout.setHorizontalGroup(
            mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(temaTextField)
                    .addGroup(mainDataPanelLayout.createSequentialGroup()
                        .addGroup(mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(temaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(syllabusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainDataPanelLayout.createSequentialGroup()
                                .addGroup(mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(organizerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(organizadorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainDataPanelLayout.createSequentialGroup()
                                        .addComponent(modalityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(83, 83, 83))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainDataPanelLayout.createSequentialGroup()
                                        .addComponent(modalidadCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tipoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(trainingTypeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(enviromentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ambienteCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(mainDataPanelLayout.createSequentialGroup()
                                .addGroup(mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainDataPanelLayout.createSequentialGroup()
                                        .addComponent(dateStartLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(dateEndLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainDataPanelLayout.createSequentialGroup()
                                        .addComponent(fechaInicioDate, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fechaFinDate, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainDataPanelLayout.createSequentialGroup()
                                        .addComponent(cantidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(diasSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainDataPanelLayout.createSequentialGroup()
                                        .addComponent(maxQuantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dayMaxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalHoursLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(horasSpiner, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(mainDataPanelLayout.createSequentialGroup()
                                        .addComponent(imageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(imagenRutaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 39, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        mainDataPanelLayout.setVerticalGroup(
            mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainDataPanelLayout.createSequentialGroup()
                .addGroup(mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainDataPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(organizerLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(trainingTypeLabel1)
                        .addComponent(enviromentLabel)
                        .addComponent(modalityLabel)))
                .addGap(0, 0, 0)
                .addGroup(mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(organizadorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modalidadCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ambienteCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(temaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(temaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateStartLabel)
                    .addComponent(dateEndLabel)
                    .addComponent(maxQuantityLabel)
                    .addComponent(dayMaxLabel)
                    .addComponent(totalHoursLabel)
                    .addComponent(imageLabel))
                .addGroup(mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainDataPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaInicioDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(imagenRutaLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(mainDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cantidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(diasSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(horasSpiner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(fechaFinDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainDataPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25)
                .addComponent(syllabusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tabPanel.addTab("Datos Principales", mainDataPanel);

        schedulePanel.setBackground(new java.awt.Color(23, 33, 42));
        schedulePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        horarioTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        horarioTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Lunes", null, null, null, null, "", null, "    00:00"},
                {"Martes", null, null, null, null, null, null, "    00:00"},
                {"Miercoles", null, null, null, null, null, null, "    00:00"},
                {"Jueves", null, null, null, null, null, null, "    00:00"},
                {"Viernes", null, null, null, null, null, null, "    00:00"},
                {"Sabado", null, null, null, null, null, null, "    00:00"},
                {"Domingo", null, null, null, null, null, null, "    00:00"}
            },
            new String [] {
                "Dia", "Inicio", "Fin", "Inicio", "Fin", "Inicio", "Fin", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(horarioTable);

        javax.swing.GroupLayout schedulePanelLayout = new javax.swing.GroupLayout(schedulePanel);
        schedulePanel.setLayout(schedulePanelLayout);
        schedulePanelLayout.setHorizontalGroup(
            schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schedulePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(371, Short.MAX_VALUE))
        );
        schedulePanelLayout.setVerticalGroup(
            schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schedulePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(249, Short.MAX_VALUE))
        );

        tabPanel.addTab("Horario", schedulePanel);

        organizerPanel.setBackground(new java.awt.Color(23, 33, 42));
        organizerPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        organizadoresTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CIP", "DNI", "Organizador", "Celular", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(organizadoresTable);
        if (organizadoresTable.getColumnModel().getColumnCount() > 0) {
            organizadoresTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            organizadoresTable.getColumnModel().getColumn(1).setPreferredWidth(8);
            organizadoresTable.getColumnModel().getColumn(2).setPreferredWidth(30);
            organizadoresTable.getColumnModel().getColumn(3).setPreferredWidth(8);
            organizadoresTable.getColumnModel().getColumn(4).setPreferredWidth(8);
        }

        organizadorBtnPanel.setBackground(new java.awt.Color(23, 33, 42));
        organizadorBtnPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        agregarOrganizadorBtn.setBackground(new java.awt.Color(23, 33, 42));
        agregarOrganizadorBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/add.png"))); // NOI18N
        agregarOrganizadorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarOrganizadorBtnActionPerformed(evt);
            }
        });

        removerOrganizadorBtn.setBackground(new java.awt.Color(23, 33, 42));
        removerOrganizadorBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/remove.png"))); // NOI18N
        removerOrganizadorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerOrganizadorBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout organizadorBtnPanelLayout = new javax.swing.GroupLayout(organizadorBtnPanel);
        organizadorBtnPanel.setLayout(organizadorBtnPanelLayout);
        organizadorBtnPanelLayout.setHorizontalGroup(
            organizadorBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(organizadorBtnPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(organizadorBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(removerOrganizadorBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agregarOrganizadorBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        organizadorBtnPanelLayout.setVerticalGroup(
            organizadorBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(organizadorBtnPanelLayout.createSequentialGroup()
                .addComponent(agregarOrganizadorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removerOrganizadorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout organizerPanelLayout = new javax.swing.GroupLayout(organizerPanel);
        organizerPanel.setLayout(organizerPanelLayout);
        organizerPanelLayout.setHorizontalGroup(
            organizerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(organizerPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(organizadorBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        organizerPanelLayout.setVerticalGroup(
            organizerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(organizerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(organizerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(organizadorBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(228, Short.MAX_VALUE))
        );

        tabPanel.addTab("Organizadores", organizerPanel);

        guardarBtn.setText("Guardar");
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(guardarBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelarBtn)
                .addContainerGap())
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarBtn)
                    .addComponent(cancelarBtn))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void temaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_temaTextFieldActionPerformed

    private void imageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageBtnActionPerformed

        JFileChooser imageSelector = new JFileChooser();
        int result = imageSelector.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            String imagePath = imageSelector.getSelectedFile().getAbsolutePath();
            // Aquí puedes hacer lo que desees con la ruta de la imagen seleccionada
            System.out.println("Imagen seleccionada: " + imagePath);
            this.imagenRutaLabel.setText(imagePath);
        }

    }//GEN-LAST:event_imageBtnActionPerformed

    private void agregarOrganizadorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarOrganizadorBtnActionPerformed
        if (this.buscarOrganizadorFrame == null || !this.buscarOrganizadorFrame.isDisplayable()) {
            this.buscarOrganizadorFrame = new BuscarOrganizadorFrame(this);
            this.buscarOrganizadorFrame.setVisible(true);
            this.buscarOrganizadorFrame.setLocationRelativeTo(null);
        } else {
            this.buscarOrganizadorFrame.requestFocus();
        }
    }//GEN-LAST:event_agregarOrganizadorBtnActionPerformed

    private void removerOrganizadorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerOrganizadorBtnActionPerformed

        int rowSelectedIndex = this.organizadoresTable.getSelectedRow();
        if (rowSelectedIndex != -1) {
            DefaultTableModel tableModel = (DefaultTableModel) this.organizadoresTable.getModel();
            int cip = (int) tableModel.getValueAt(rowSelectedIndex, 0);
            if (cip != 0) {
                this.organizadores.remove(new Organizador(cip));
            }
            tableModel.removeRow(rowSelectedIndex);
        }
    }//GEN-LAST:event_removerOrganizadorBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtnActionPerformed
        if (validarCamposObligatorios() && validarOrganizadores()) {
            Capitulo capituloSelected = (Capitulo) this.organizadorCombo.getSelectedItem();
            EventoModalidad modalidadSelected = (EventoModalidad) this.modalidadCombo.getSelectedItem();
            TipoEvento tipoSelected = (TipoEvento) this.tipoCombo.getSelectedItem();
            Ambiente ambienteSelected = (Ambiente) this.ambienteCombo.getSelectedItem();
            String tema = this.temaTextField.getText();
            //String fechaInicio = ((JTextField) this.fechaInicioDate.getDateEditor().getUiComponent()).getText();
            Date fechaInicio = this.fechaInicioDate.getDate();
            //String fechaFin = ((JTextField) this.fechaFinDate.getDateEditor().getUiComponent()).getText();
            Date fechaFin = this.fechaFinDate.getDate();

            int cantidad = (int) this.cantidadSpinner.getValue();
            int diaMax = (int) this.diasSpinner.getValue();
            int horasTotales = (int) this.horasSpiner.getValue();
            String temario = this.temarioArea.getText();

            EventoModular eventoModular = new EventoModular();
            eventoModular.setCod_cap(capituloSelected.getCod_cap());
            eventoModular.setCod_modalidad(modalidadSelected.getCod_modalidad());
            eventoModular.setCod_tipo(tipoSelected.getCod_tipo());
            eventoModular.setId_ambiente(ambienteSelected.getId_ambiente());
            eventoModular.setTema(tema);
            eventoModular.setInicio(fechaInicio);
            eventoModular.setFin(fechaFin);
            eventoModular.setCantidad(cantidad);
            eventoModular.setDiaMax(diaMax);
            eventoModular.setHorasTotales(horasTotales);
            eventoModular.setTemario(temario);

            eventoModular.setOrganizadores(this.organizadores);

            if (this.modo.equals("editar")) {
                eventoModular.setCodigo(this.editEventoModular.getCodigo());
            }

            if (this.controlador.guardarEventoModular(eventoModular)) {
                JOptionPane joptionPane = new JOptionPane("Datos Guardados correctamente.");
                joptionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = joptionPane.createDialog("Confirmación");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
                
                this.parent.refrescarTabla();
                
                this.setVisible(false);
                this.dispose();
            } else {
                JOptionPane joptionPane = new JOptionPane("Error al guardar el Evento Modular.");
                joptionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
                JDialog dialog = joptionPane.createDialog("Error");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_guardarBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarOrganizadorBtn;
    private javax.swing.JComboBox<String> ambienteCombo;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JSpinner cantidadSpinner;
    private javax.swing.JLabel dateEndLabel;
    private javax.swing.JLabel dateStartLabel;
    private javax.swing.JLabel dayMaxLabel;
    private javax.swing.JSpinner diasSpinner;
    private javax.swing.JLabel enviromentLabel;
    private com.toedter.calendar.JDateChooser fechaFinDate;
    private com.toedter.calendar.JDateChooser fechaInicioDate;
    private javax.swing.JButton guardarBtn;
    private javax.swing.JTable horarioTable;
    private javax.swing.JSpinner horasSpiner;
    private javax.swing.JButton imageBtn;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel imagenRutaLabel;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JFileChooser jFileChooser3;
    private javax.swing.JFileChooser jFileChooser4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel mainDataPanel;
    private javax.swing.JLabel maxQuantityLabel;
    private javax.swing.JComboBox<String> modalidadCombo;
    private javax.swing.JLabel modalityLabel;
    private javax.swing.JPanel organizadorBtnPanel;
    private javax.swing.JComboBox<String> organizadorCombo;
    private javax.swing.JTable organizadoresTable;
    private javax.swing.JLabel organizerLabel;
    private javax.swing.JPanel organizerPanel;
    private javax.swing.JButton removerOrganizadorBtn;
    private javax.swing.JPanel schedulePanel;
    private javax.swing.JLabel syllabusLabel;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JLabel temaLabel;
    private javax.swing.JTextField temaTextField;
    private javax.swing.JTextArea temarioArea;
    private javax.swing.JComboBox<String> tipoCombo;
    private javax.swing.JLabel totalHoursLabel;
    private javax.swing.JLabel trainingTypeLabel1;
    // End of variables declaration//GEN-END:variables
}
