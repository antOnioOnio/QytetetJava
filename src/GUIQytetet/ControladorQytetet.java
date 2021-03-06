/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIQytetet;
import modeloqytetet.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author anthonius
 */
public class ControladorQytetet extends javax.swing.JFrame {

    /**
     * Creates new form ControladorQytetet
     */
    private Qytetet modeloQytetet ;

    public ControladorQytetet() {
        initComponents();
    }
    public void actualizarQytetet( Qytetet unQytetet ){
        
        this.modeloQytetet = unQytetet;
      
        this.vistaQytetet3.actualizarQuytetet(modeloQytetet);
        
      
    }
    
    public void habilitarComenzarTurno(){
        this.jbComprar.setEnabled(false);
        this.jbSiguienteJugador.setEnabled(false);    
        this.jbAplicarSorpresa.setEnabled(false);
        if(modeloQytetet.getJugadorActual().isEncarcelado()){
            this.jbSalirCarcelPagando.setEnabled(true);
            this.jbSalirCarcelDado.setEnabled(true);
        }
        else{
            this.jbJugar.setEnabled(true);
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        vistaQytetet2 = new GUIQytetet.VistaQytetet();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jbComprar = new javax.swing.JButton();
        jbJugar = new javax.swing.JButton();
        jbSalirCarcelDado = new javax.swing.JButton();
        jbSiguienteJugador = new javax.swing.JButton();
        jbAplicarSorpresa = new javax.swing.JButton();
        jbSalirCarcelPagando = new javax.swing.JButton();
        vistaQytetet3 = new GUIQytetet.VistaQytetet();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbComprar.setText("Comprar");
        jbComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComprarActionPerformed(evt);
            }
        });

        jbJugar.setText("Jugar");
        jbJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbJugarActionPerformed(evt);
            }
        });

        jbSalirCarcelDado.setText("Salir Carcel Dado");
        jbSalirCarcelDado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirCarcelDadoActionPerformed(evt);
            }
        });

        jbSiguienteJugador.setText("Siguiente");
        jbSiguienteJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSiguienteJugadorActionPerformed(evt);
            }
        });

        jbAplicarSorpresa.setText("Apllicar sorpresa");
        jbAplicarSorpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAplicarSorpresaActionPerformed(evt);
            }
        });

        jbSalirCarcelPagando.setText("Salir Carcel Pagando");
        jbSalirCarcelPagando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirCarcelPagandoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vistaQytetet3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbJugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSiguienteJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAplicarSorpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSalirCarcelPagando, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(jbSalirCarcelDado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(390, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(vistaQytetet3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbJugar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbComprar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSiguienteJugador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAplicarSorpresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSalirCarcelPagando)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSalirCarcelDado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(205, 205, 205))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbJugarActionPerformed
        
        boolean tienePropietario = modeloQytetet.Jugar();
        
        this.jbJugar.setEnabled(false);
        this.jbAplicarSorpresa.setEnabled(false);
        this.jbSiguienteJugador.setEnabled(true);
        
             
        if(modeloQytetet.getJugadorActual().isEncarcelado()){
            this.jbSalirCarcelDado.setEnabled(true);
            this.jbSalirCarcelPagando.setEnabled(true);
        }else{
            this.jbSalirCarcelDado.setEnabled(false);
            this.jbSalirCarcelPagando.setEnabled(false);
        }
        
        if( modeloQytetet.getJugadorActual().getCasillaActual().getTipo() == modeloqytetet.TipoCasilla.CALLE && !tienePropietario){
            JOptionPane.showMessageDialog(this, "Esta libre, quieres comprarla ?");
            this.jbComprar.setEnabled(true);
        }
        else {
            this.jbComprar.setEnabled(false);
        }
        
        if(tienePropietario){
            this.jbComprar.setEnabled(false);
        }
        else if (modeloQytetet.getJugadorActual().getCasillaActual().getTipo() == modeloqytetet.TipoCasilla.JUEZ){
            JOptionPane.showMessageDialog(this,"Juez---> Carcel");
        }
        else if(modeloQytetet.getJugadorActual().getCasillaActual().getTipo() == modeloqytetet.TipoCasilla.SORPRESA){
           JOptionPane.showMessageDialog(this, "Has caido en Sorpresa");
           this.jbAplicarSorpresa.setEnabled(true);
        }       
        else if(modeloQytetet.getJugadorActual().getCasillaActual().getTipo() == modeloqytetet.TipoCasilla.PARKING){
           JOptionPane.showMessageDialog(this, "Has caido en una casilla tipo parking");
        }
        
        this.actualizarQytetet(modeloQytetet);
        this.jbSiguienteJugador.setEnabled(true);
   
    }//GEN-LAST:event_jbJugarActionPerformed

    private void jbSiguienteJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSiguienteJugadorActionPerformed
        // TODO add your handling code here:
        modeloQytetet.siguienteJugador();
        boolean bancarrota = !modeloQytetet.getJugadorActual().tengoSaldo(0);
        if (bancarrota ){
            this.jbSiguienteJugador.setEnabled(false);
            JOptionPane.showMessageDialog(this, "GAME OVER");
            JOptionPane.showMessageDialog(this, modeloQytetet.obtenerRanking());    
        }
        actualizarQytetet(modeloQytetet);
        this.jbJugar.setEnabled(true);
    }//GEN-LAST:event_jbSiguienteJugadorActionPerformed

    private void jbAplicarSorpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAplicarSorpresaActionPerformed
      
    boolean Sorpresa = modeloQytetet.aplicarSorpresa();
        
        this.jbAplicarSorpresa.setEnabled(false);
        
        if(Sorpresa){
            JOptionPane.showMessageDialog(this, "Puedes comprar la propiedad");
            this.jbComprar.setEnabled(true);
        }
        else{
            this.jbComprar.setEnabled(false);
        }
    }//GEN-LAST:event_jbAplicarSorpresaActionPerformed

    private void jbSalirCarcelPagandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirCarcelPagandoActionPerformed
        // TODO add your handling code here:
        boolean resultado = modeloQytetet.intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD);
        this.jbSalirCarcelPagando.setEnabled(false);
        this.jbSalirCarcelDado.setEnabled(false);
        if(resultado){
            JOptionPane.showMessageDialog(this, "Sales de la cárcel");
            this.jbJugar.setEnabled(true);
        }else {
            JOptionPane.showMessageDialog(this, "NO sales de la carcel");
            this.jbSiguienteJugador.setEnabled(true);
        }
        actualizarQytetet(modeloQytetet);    
        
        
    }//GEN-LAST:event_jbSalirCarcelPagandoActionPerformed

    private void jbSalirCarcelDadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirCarcelDadoActionPerformed
        // TODO add your handling code here:
        boolean resultado = modeloQytetet.intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO);
        this.jbSalirCarcelPagando.setEnabled(false);
        this.jbSalirCarcelDado.setEnabled(false);
        if(resultado){
            JOptionPane.showMessageDialog(this, "Sales de la cárcel tirando dado");
        }else{
            JOptionPane.showMessageDialog(this, "No sales de la cárcel");
        }
        actualizarQytetet(modeloQytetet);
        
    }//GEN-LAST:event_jbSalirCarcelDadoActionPerformed

    private void jbComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComprarActionPerformed
        // TODO add your handling code here:
        boolean compro = modeloQytetet.comprarTituloPropiedad();
        this.jbComprar.setEnabled(false);
        
        if(compro){
            JOptionPane.showMessageDialog(this, "Compraste propiedad");
        }else{
            JOptionPane.showMessageDialog(this, "No has comprado.");
        }
    }//GEN-LAST:event_jbComprarActionPerformed

    /**
     * @param args the command line arguments
     */

    
    public static void main(String args[]) {
        
        Qytetet juego = Qytetet.getInstance();
        ControladorQytetet controladorQytetet = new ControladorQytetet();
        CapturaNombreJugadores captura = new CapturaNombreJugadores(controladorQytetet, true);
        ArrayList<String> nombres = captura.obtenerNombres();
        juego.inicializarJuego(nombres);
        Dado.createInstance(controladorQytetet);
        controladorQytetet.actualizarQytetet(juego);
        
        controladorQytetet.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbAplicarSorpresa;
    private javax.swing.JButton jbComprar;
    private javax.swing.JButton jbJugar;
    private javax.swing.JButton jbSalirCarcelDado;
    private javax.swing.JButton jbSalirCarcelPagando;
    private javax.swing.JButton jbSiguienteJugador;
    private GUIQytetet.VistaQytetet vistaQytetet2;
    private GUIQytetet.VistaQytetet vistaQytetet3;
    // End of variables declaration//GEN-END:variables
}
