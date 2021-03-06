/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import repositorios.AcessoBD;
import repositorios.ExportarClientePreferencial;
import repositorios.ExportarCreditoRotativo;
import repositorios.ExportarFamiliaProduto;
import repositorios.ExportarFornecedor;
import repositorios.ExportarFornecedorContato;
import repositorios.ExportarMercadologico;
import repositorios.ExportarProdutoFornecedor;
import repositorios.ExportarProdutos;

/**
 *
 * @author fabio
 */
public class ExportacaoVR extends javax.swing.JInternalFrame {
public static int tamanho;
public static int progresso;
    /**
     * Creates new form ExportacaoVR
     */
    public ExportacaoVR() {
        Tarefa();
        initComponents();
        esconderComponentes();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelCreditoRotativo = new javax.swing.JPanel();
        jCheckBox15 = new javax.swing.JCheckBox();
        jProgressBar15 = new javax.swing.JProgressBar();
        jLabelCredRot = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanelFamiliaProduto = new javax.swing.JPanel();
        jCheckBox12 = new javax.swing.JCheckBox();
        jProgressBar12 = new javax.swing.JProgressBar();
        jLabelFamProd = new javax.swing.JLabel();
        jPanelMercadologico = new javax.swing.JPanel();
        jCheckBoxMerc = new javax.swing.JCheckBox();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabelMerc = new javax.swing.JLabel();
        jPanelProdutoFornecedor = new javax.swing.JPanel();
        jCheckBox14 = new javax.swing.JCheckBox();
        jProgressBar14 = new javax.swing.JProgressBar();
        jLabelProdFornec = new javax.swing.JLabel();
        jPanelFornecedorContato = new javax.swing.JPanel();
        jCheckBox13 = new javax.swing.JCheckBox();
        jProgressBar13 = new javax.swing.JProgressBar();
        jLabelFornecContato = new javax.swing.JLabel();
        jPanelFornecedor = new javax.swing.JPanel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jProgressBar9 = new javax.swing.JProgressBar();
        jLabelFornec = new javax.swing.JLabel();
        jPanelProduto = new javax.swing.JPanel();
        jCheckBoxProduto = new javax.swing.JCheckBox();
        jProgressBar10 = new javax.swing.JProgressBar();
        jLabelProd = new javax.swing.JLabel();
        jPanelCliente = new javax.swing.JPanel();
        jCheckBox11 = new javax.swing.JCheckBox();
        jProgressBar11 = new javax.swing.JProgressBar();
        jLabelCliPref = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setTitle("Exportar banco VR");
        setFrameIcon(null);
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jPanelCreditoRotativo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cr??dito Rotativo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanelCreditoRotativo.setAutoscrolls(true);

        jCheckBox15.setText("Ativo");
        jCheckBox15.setEnabled(false);

        jLabelCredRot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N

        javax.swing.GroupLayout jPanelCreditoRotativoLayout = new javax.swing.GroupLayout(jPanelCreditoRotativo);
        jPanelCreditoRotativo.setLayout(jPanelCreditoRotativoLayout);
        jPanelCreditoRotativoLayout.setHorizontalGroup(
            jPanelCreditoRotativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCreditoRotativoLayout.createSequentialGroup()
                .addComponent(jCheckBox15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar15, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelCredRot)
                .addContainerGap())
        );
        jPanelCreditoRotativoLayout.setVerticalGroup(
            jPanelCreditoRotativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCreditoRotativoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCreditoRotativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCredRot)
                    .addComponent(jCheckBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCreditoRotativoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jProgressBar15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jButton1.setText("Exportar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanelFamiliaProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fam??lia Produto", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanelFamiliaProduto.setAutoscrolls(true);

        jCheckBox12.setText("Ativo");
        jCheckBox12.setEnabled(false);

        jLabelFamProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N

        javax.swing.GroupLayout jPanelFamiliaProdutoLayout = new javax.swing.GroupLayout(jPanelFamiliaProduto);
        jPanelFamiliaProduto.setLayout(jPanelFamiliaProdutoLayout);
        jPanelFamiliaProdutoLayout.setHorizontalGroup(
            jPanelFamiliaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFamiliaProdutoLayout.createSequentialGroup()
                .addComponent(jCheckBox12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar12, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelFamProd)
                .addContainerGap())
        );
        jPanelFamiliaProdutoLayout.setVerticalGroup(
            jPanelFamiliaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFamiliaProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFamiliaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFamProd)
                    .addComponent(jCheckBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFamiliaProdutoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jProgressBar12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanelMercadologico.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mercadol??gico", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanelMercadologico.setAutoscrolls(true);

        jCheckBoxMerc.setText("Ativo");
        jCheckBoxMerc.setEnabled(false);

        jLabelMerc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N

        javax.swing.GroupLayout jPanelMercadologicoLayout = new javax.swing.GroupLayout(jPanelMercadologico);
        jPanelMercadologico.setLayout(jPanelMercadologicoLayout);
        jPanelMercadologicoLayout.setHorizontalGroup(
            jPanelMercadologicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMercadologicoLayout.createSequentialGroup()
                .addComponent(jCheckBoxMerc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelMerc)
                .addContainerGap())
        );
        jPanelMercadologicoLayout.setVerticalGroup(
            jPanelMercadologicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMercadologicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMercadologicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMerc)
                    .addComponent(jCheckBoxMerc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelMercadologicoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanelProdutoFornecedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Produto Fornecedor", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanelProdutoFornecedor.setAutoscrolls(true);

        jCheckBox14.setText("Ativo");
        jCheckBox14.setEnabled(false);

        jLabelProdFornec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N

        javax.swing.GroupLayout jPanelProdutoFornecedorLayout = new javax.swing.GroupLayout(jPanelProdutoFornecedor);
        jPanelProdutoFornecedor.setLayout(jPanelProdutoFornecedorLayout);
        jPanelProdutoFornecedorLayout.setHorizontalGroup(
            jPanelProdutoFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdutoFornecedorLayout.createSequentialGroup()
                .addComponent(jCheckBox14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar14, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelProdFornec)
                .addContainerGap())
        );
        jPanelProdutoFornecedorLayout.setVerticalGroup(
            jPanelProdutoFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdutoFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProdutoFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProdFornec)
                    .addComponent(jCheckBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelProdutoFornecedorLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jProgressBar14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanelFornecedorContato.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fornecedor Contato", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanelFornecedorContato.setAutoscrolls(true);

        jCheckBox13.setText("Ativo");
        jCheckBox13.setEnabled(false);

        jLabelFornecContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N

        javax.swing.GroupLayout jPanelFornecedorContatoLayout = new javax.swing.GroupLayout(jPanelFornecedorContato);
        jPanelFornecedorContato.setLayout(jPanelFornecedorContatoLayout);
        jPanelFornecedorContatoLayout.setHorizontalGroup(
            jPanelFornecedorContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFornecedorContatoLayout.createSequentialGroup()
                .addComponent(jCheckBox13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar13, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelFornecContato)
                .addContainerGap())
        );
        jPanelFornecedorContatoLayout.setVerticalGroup(
            jPanelFornecedorContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFornecedorContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFornecedorContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFornecContato)
                    .addComponent(jCheckBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFornecedorContatoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jProgressBar13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanelFornecedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fornecedor", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanelFornecedor.setAutoscrolls(true);

        jCheckBox9.setText("Ativo");
        jCheckBox9.setEnabled(false);

        jLabelFornec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N

        javax.swing.GroupLayout jPanelFornecedorLayout = new javax.swing.GroupLayout(jPanelFornecedor);
        jPanelFornecedor.setLayout(jPanelFornecedorLayout);
        jPanelFornecedorLayout.setHorizontalGroup(
            jPanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFornecedorLayout.createSequentialGroup()
                .addComponent(jCheckBox9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar9, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelFornec)
                .addContainerGap())
        );
        jPanelFornecedorLayout.setVerticalGroup(
            jPanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFornec)
                    .addComponent(jCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFornecedorLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jProgressBar9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanelProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Produto", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanelProduto.setAutoscrolls(true);

        jCheckBoxProduto.setText("Ativo");
        jCheckBoxProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxProdutoActionPerformed(evt);
            }
        });

        jLabelProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N

        javax.swing.GroupLayout jPanelProdutoLayout = new javax.swing.GroupLayout(jPanelProduto);
        jPanelProduto.setLayout(jPanelProdutoLayout);
        jPanelProdutoLayout.setHorizontalGroup(
            jPanelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdutoLayout.createSequentialGroup()
                .addComponent(jCheckBoxProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar10, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelProd)
                .addContainerGap())
        );
        jPanelProdutoLayout.setVerticalGroup(
            jPanelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProd)
                    .addComponent(jCheckBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelProdutoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jProgressBar10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente Preferencial", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanelCliente.setAutoscrolls(true);

        jCheckBox11.setText("Ativo");
        jCheckBox11.setEnabled(false);

        jLabelCliPref.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N

        javax.swing.GroupLayout jPanelClienteLayout = new javax.swing.GroupLayout(jPanelCliente);
        jPanelCliente.setLayout(jPanelClienteLayout);
        jPanelClienteLayout.setHorizontalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteLayout.createSequentialGroup()
                .addComponent(jCheckBox11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar11, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelCliPref)
                .addContainerGap())
        );
        jPanelClienteLayout.setVerticalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCliPref)
                    .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelClienteLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jProgressBar11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanelProdutoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanelCreditoRotativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanelProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanelMercadologico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanelFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanelFamiliaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanelFornecedorContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelMercadologico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelFamiliaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelFornecedorContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelProdutoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelCreditoRotativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         try {
        ExportarMercadologico exp1 = new ExportarMercadologico();
        ExportarProdutos exp2 =  new ExportarProdutos();
        ExportarFamiliaProduto exp3 = new ExportarFamiliaProduto();
        ExportarProdutoFornecedor exp4 = new ExportarProdutoFornecedor();
        ExportarFornecedor exp5 = new ExportarFornecedor();
        ExportarClientePreferencial exp6 = new ExportarClientePreferencial();
        ExportarFornecedorContato exp7 = new ExportarFornecedorContato();
        ExportarCreditoRotativo exp8 = new ExportarCreditoRotativo();
        
       
                exp1.exportar();      
                Thread.sleep(200);
                jLabelMerc.setEnabled(true);
               
            exp2.exportar();
            Thread.sleep(200);
            jLabelProd.setEnabled(true);
          
            
            exp3.exportar();
            Thread.sleep(200);
            jLabelFamProd.setEnabled(true);
        
            exp4.exportar();
            Thread.sleep(200);
            jLabelProdFornec.setEnabled(true);
            
            exp5.exportar();
             Thread.sleep(200);
            jLabelFornec.setEnabled(true);
           
       
            exp6.exportar();
              Thread.sleep(200);
            jLabelCliPref.setEnabled(true);
          
            
            exp7.exportar();
             jLabelFornecContato.setEnabled(true);
             Thread.sleep(200);
             
            exp8.exportar();
            jLabelCredRot.setEnabled(true);
            Thread.sleep(20000);
            
            JOptionPane.showMessageDialog(null, "Exporta????o conclu??da com sucesso!", "Aten????o", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(ExportacaoVR.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExportacaoVR.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
        Logger.getLogger(ExportacaoVR.class.getName()).log(Level.SEVERE, null, ex);
    }
           
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBoxProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxProdutoActionPerformed
        // TODO add your handling code here:
          AcessoBD.ativos = 1; 
    }//GEN-LAST:event_jCheckBoxProdutoActionPerformed
 public void esconderComponentes(){
      jLabelMerc.setEnabled(false);
      jLabelCredRot.setEnabled(false);
      jLabelFamProd.setEnabled(false);
      jLabelFornec.setEnabled(false);
      jLabelFornecContato.setEnabled(false);
      jLabelProd.setEnabled(false);
      jLabelProdFornec.setEnabled(false);
      jLabelCliPref.setEnabled(false);
   }
   public  void Tarefa(){
            
        Timer timer1 = new Timer();
        int delay = 100;   // delay de 2 seg.
        int interval = 1000;  // intervalo de 1 seg.       

        timer1.scheduleAtFixedRate(new TimerTask() {
        public void run() {
         jPanel1.repaint();
        }
        }, delay, interval);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JCheckBox jCheckBoxMerc;
    private javax.swing.JCheckBox jCheckBoxProduto;
    private javax.swing.JLabel jLabelCliPref;
    private javax.swing.JLabel jLabelCredRot;
    private javax.swing.JLabel jLabelFamProd;
    private javax.swing.JLabel jLabelFornec;
    private javax.swing.JLabel jLabelFornecContato;
    private javax.swing.JLabel jLabelMerc;
    private javax.swing.JLabel jLabelProd;
    private javax.swing.JLabel jLabelProdFornec;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCliente;
    private javax.swing.JPanel jPanelCreditoRotativo;
    private javax.swing.JPanel jPanelFamiliaProduto;
    private javax.swing.JPanel jPanelFornecedor;
    private javax.swing.JPanel jPanelFornecedorContato;
    private javax.swing.JPanel jPanelMercadologico;
    private javax.swing.JPanel jPanelProduto;
    private javax.swing.JPanel jPanelProdutoFornecedor;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar10;
    private javax.swing.JProgressBar jProgressBar11;
    private javax.swing.JProgressBar jProgressBar12;
    private javax.swing.JProgressBar jProgressBar13;
    private javax.swing.JProgressBar jProgressBar14;
    private javax.swing.JProgressBar jProgressBar15;
    private javax.swing.JProgressBar jProgressBar9;
    // End of variables declaration//GEN-END:variables
}
