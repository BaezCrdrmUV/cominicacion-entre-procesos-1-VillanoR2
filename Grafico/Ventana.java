package Grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Logica.Procesos;

public class Ventana extends JFrame implements ActionListener {

    private JLabel texto;
    private JButton boton;
    private JButton leer;
    private JButton numArchivos;
    private JTextArea cuadro;

    public Ventana() {
        super();
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        this.setTitle("Comunicacion entre Procesos");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        texto = new JLabel();
        boton = new JButton();
        leer = new JButton();
        cuadro = new JTextArea();
        numArchivos = new JButton();

        texto.setText("Seleccione una opción: ");
        texto.setBounds(50, 50, 200, 25);
        boton.setText("Abrir Archivo");
        boton.setBounds(50, 100, 200, 30);
        boton.addActionListener(this);
        leer.setText("Leer Archivo");
        leer.setBounds(50, 130, 200, 30);
        leer.addActionListener(this);
        numArchivos.setText("Numero de Archivos Descriptivos");
        numArchivos.setBounds(50, 160, 250, 30);
        numArchivos.addActionListener(this);
        cuadro.setBounds(50,250,400,100);
        cuadro.disable();

        this.add(texto);
        this.add(boton);
        this.add(leer);
        this.add(cuadro);
        this.add(numArchivos);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        final Procesos procesos = new Procesos();

        if (e.getSource() == boton) {
            try {
                procesos.AbrirArchivo("/Users/villa/Documents/Git/DesarrolloRed/cominicacion-entre-procesos-1-VillanoR2/Archivo.txt");
            } catch (final Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
        if(e.getSource() == leer){
            try {
                cuadro.setText(Procesos.LeerArchivo("/Users/villa/Documents/Git/DesarrolloRed/cominicacion-entre-procesos-1-VillanoR2/Archivo.txt"));
            } catch (final Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            } 
        }
        if(e.getSource() == numArchivos){
            String archivos = null;
            cuadro.setText(Procesos.NumArchivosDescriptivos(archivos));
        }
    }

    public static void main(final String[] args) {
        final Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}