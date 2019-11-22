/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author harsh
 */
class visual extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        for (Vertex A : OOM.G.getV()) {
            g.setColor(Color.black);
            g.fillOval(A.getX() - 12, A.getY() - 12, 24, 24);
        }
        for (Vertex A : OOM.G.getV()) {
            int x = A.getX();
            int y = A.getY();
            for (String B : OOM.G.getEdges().get(A.getName())) {
                int x1 = OOM.G.getVert().get(B).getX();
                int y1 = OOM.G.getVert().get(B).getY();
                g.setColor(Color.red);
//                if(OOM.G.getEdges().get(B).contains(A.getName()))
                g.drawLine(x, y, x1, y1);

//                int dx = x1 - x, dy = y1 - y;
//                double d = 6.5;
//                double h=6.5;
//                int a=(x+x1)/2;
//                int b=(y+y1)/2;
//                double D = Math.sqrt(dx * dx + dy * dy);
//                double xm = D - d, xn = xm, ym = h, yn = -h, xx;
//                double sin = dy / D, cos = dx / D;
//
//                xx = xm * cos - ym * sin + x;
//                ym = xm * sin + ym * cos + y;
//                xm = xx;
//
//                xx = xn * cos - yn * sin + x;
//                yn = xn * sin + yn * cos + y;
//                xn = xx;
//
//                int[] xpoints = {a, (int) xm, (int) xn};
//                int[] ypoints = {b, (int) ym, (int) yn};
//                g.setColor(Color.green);
//                g.fillPolygon(xpoints, ypoints, 3);
            }
        }
        g.setColor(Color.red);
        if (VisualGraphics.From != null) {
            if (VisualGraphics.choice == 2 || VisualGraphics.choice == 6) {
                g.drawOval(VisualGraphics.From.getX() - 15, VisualGraphics.From.getY() - 15, 30, 30);
            }
            if (VisualGraphics.choice == 3 || VisualGraphics.choice == 5) {
                g.setColor(Color.BLUE);
                g.drawOval(VisualGraphics.From.getX() - 15, VisualGraphics.From.getY() - 15, 30, 30);
            }
            if (VisualGraphics.choice == 7) {
                g.setColor(Color.ORANGE);
                g.drawOval(VisualGraphics.From.getX() - 15, VisualGraphics.From.getY() - 15, 30, 30);
            }
        }
        if (VisualGraphics.To != null) {
            if (VisualGraphics.choice == 7) {
                File file = new File("/home/harsh/NetBeansProjects/OOM/src/main/Path");
                try {
                    Scanner scan = new Scanner(file);
                    String s = scan.nextLine();
                    s = s.substring(0, s.length() - 1);
                    String[] inputs = s.split("-->");
                    g.setColor(Color.red);
                    g.drawOval(VisualGraphics.To.getX() - 15, VisualGraphics.To.getY() - 15, 30, 30);
                    g.setColor(Color.green);
                    if (inputs.length > 1) {
                        for (int i = 0; i < inputs.length - 1; i++) {
                            if (!(OOM.G.getVert().containsKey(inputs[i]) && OOM.G.getVert().containsKey(inputs[i + 1]))) {
                                break;
                            }

                            int x = OOM.G.getVert().get(inputs[i]).getX();
                            int y = OOM.G.getVert().get(inputs[i]).getY();
                            int x1 = OOM.G.getVert().get(inputs[i + 1]).getX();
                            int y1 = OOM.G.getVert().get(inputs[i + 1]).getY();
//                            gg.setStroke(new BasicStroke(1.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f, 10.0, 0.0f));

//final static float dash1[] = {10.0f}
gg.setStroke(new BasicStroke(3));
                            gg.drawLine(x, y, x1, y1);

                        }
                    }

                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "Some Error Occured");
                }

            }
        }
    }
}

public class VisualGraphics extends javax.swing.JFrame {

    /**
     * Creates new form VisualGraphics
     */
//    choice=1 //AddVertex
//    choice=2 //AddEdge
//    choice=3 //ModifyVertex
//    choice=4 //DeleteVertex
//    choice=5 //DeleteEdge
    static int choice = 5;
    static Vertex From = null;
    static Vertex To = null;

    public VisualGraphics() {
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

        visual GraphPanel;
        GraphPanel = new visual();
        Label = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        AddV = new javax.swing.JRadioButton();
        DeleteV = new javax.swing.JRadioButton();
        ModifyV = new javax.swing.JRadioButton();
        AddE = new javax.swing.JRadioButton();
        ModifyE = new javax.swing.JRadioButton();
        DeleteE = new javax.swing.JRadioButton();
        ShortPath = new javax.swing.JRadioButton();
        Back = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        GraphPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        GraphPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                GraphPanelMouseDragged(evt);
            }
        });
        GraphPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GraphPanelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GraphPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                GraphPanelMouseReleased(evt);
            }
        });

        Label.setFont(new java.awt.Font("Purisa", 3, 20)); // NOI18N
        Label.setForeground(new java.awt.Color(243, 12, 12));
        Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label.setText("Add Vertex By Clicking on The Panel");
        Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout GraphPanelLayout = new javax.swing.GroupLayout(GraphPanel);
        GraphPanel.setLayout(GraphPanelLayout);
        GraphPanelLayout.setHorizontalGroup(
            GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GraphPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                .addContainerGap())
        );
        GraphPanelLayout.setVerticalGroup(
            GraphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GraphPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(java.awt.Color.gray);
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        AddV.setBackground(java.awt.Color.gray);
        AddV.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        AddV.setSelected(true);
        AddV.setText("AddVertex");
        AddV.setBorder(null);
        AddV.setBorderPainted(true);
        AddV.setContentAreaFilled(false);
        AddV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddV.setFocusPainted(false);
        AddV.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddVActionPerformed(evt);
            }
        });

        DeleteV.setBackground(java.awt.Color.gray);
        DeleteV.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        DeleteV.setText("RemoveVertex");
        DeleteV.setToolTipText("RemoveVertex");
        DeleteV.setBorder(null);
        DeleteV.setBorderPainted(true);
        DeleteV.setContentAreaFilled(false);
        DeleteV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteV.setFocusPainted(false);
        DeleteV.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        DeleteV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteVActionPerformed(evt);
            }
        });

        ModifyV.setBackground(java.awt.Color.gray);
        ModifyV.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        ModifyV.setText("Modify Vertex");
        ModifyV.setToolTipText("ModifyVertex");
        ModifyV.setBorder(null);
        ModifyV.setBorderPainted(true);
        ModifyV.setContentAreaFilled(false);
        ModifyV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ModifyV.setFocusPainted(false);
        ModifyV.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ModifyV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyVActionPerformed(evt);
            }
        });

        AddE.setBackground(java.awt.Color.gray);
        AddE.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        AddE.setText("Add Edge");
        AddE.setToolTipText("AddEdge");
        AddE.setBorder(null);
        AddE.setBorderPainted(true);
        AddE.setContentAreaFilled(false);
        AddE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddE.setFocusPainted(false);
        AddE.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AddE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEActionPerformed(evt);
            }
        });

        ModifyE.setBackground(java.awt.Color.gray);
        ModifyE.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        ModifyE.setText("Modify Edge");
        ModifyE.setToolTipText("ModifyEdge");
        ModifyE.setBorder(null);
        ModifyE.setBorderPainted(true);
        ModifyE.setContentAreaFilled(false);
        ModifyE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ModifyE.setFocusPainted(false);
        ModifyE.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ModifyE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyEActionPerformed(evt);
            }
        });

        DeleteE.setBackground(java.awt.Color.gray);
        DeleteE.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        DeleteE.setText("Remove Edge");
        DeleteE.setToolTipText("Remove Edge");
        DeleteE.setBorder(null);
        DeleteE.setBorderPainted(true);
        DeleteE.setContentAreaFilled(false);
        DeleteE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteE.setFocusPainted(false);
        DeleteE.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        DeleteE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteEActionPerformed(evt);
            }
        });

        ShortPath.setBackground(java.awt.Color.gray);
        ShortPath.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        ShortPath.setText("ShortestPath");
        ShortPath.setToolTipText("Print Shortest Path");
        ShortPath.setBorder(null);
        ShortPath.setBorderPainted(true);
        ShortPath.setContentAreaFilled(false);
        ShortPath.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ShortPath.setFocusPainted(false);
        ShortPath.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ShortPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShortPathActionPerformed(evt);
            }
        });

        Back.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        Back.setText("Back");
        Back.setToolTipText("Back To Main Menu");
        Back.setBorder(null);
        Back.setContentAreaFilled(false);
        Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Back.setFocusPainted(false);
        Back.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ModifyE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeleteE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ModifyV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeleteV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ShortPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(AddV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DeleteV, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ModifyV, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddE, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DeleteE, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ModifyE, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ShortPath, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(372, 372, 372))
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Back");
        jMenuItem1.setToolTipText("");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(GraphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GraphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GraphPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GraphPanelMouseClicked
        // TODO add your handling code here:
        if (choice == 1) { //AddVertex
            int x = evt.getX();

            int y = evt.getY();
            String s = "V" + Integer.toString(OOM.G.getV().size());

            Vertex V1 = new Vertex(s, x, y);
            try {
                OOM.G.searchVertex(V1);
                OOM.G.addVertex(V1);
                repaint();
            } catch (Invalid ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        } else if (choice == 2) { //AddEdge
            System.out.println("IN Add Edge");
            Vertex V1 = new Vertex("X", evt.getX(), evt.getY());
            try {
                V1 = OOM.G.searchVertex(V1.getX(), V1.getY());
                if (From != null) {
                    int h = From.getX() - V1.getX() * From.getX() - V1.getX();
                    h = h + From.getY() - V1.getY() * From.getY() - V1.getY();
                    OOM.G.checkEdge(From.getName(), V1.getName());

                    String f = JOptionPane.showInputDialog("Please Provide The Weight for this edge");
                    try {
                        double w = Double.parseDouble(f);
                        OOM.G.addEdge(From.getName(), V1.getName(), w);
                        From = null;
                    } catch (Exception e) {

                    }

                } else {
                    From = V1;
                }
                System.out.println(From + " " + V1);
                repaint();
            } catch (Invalid e) {
                From = null;
                repaint();

            }
        } else if (choice == 4) { //Delete Vertex
            Vertex V1 = new Vertex("X", evt.getX(), evt.getY());
            try {
                V1 = OOM.G.searchVertex(V1.getX(), V1.getY());
                int input = JOptionPane.showConfirmDialog(null, "Do you want to Delete this Vertex");
                if (input == 0) {
                    OOM.G.deleteVertex(V1);
                    repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "You Cancelled Delete Operation");
                    repaint();
                }
            } catch (Invalid e) {
                repaint();
            }
        } else if (choice == 5) { //Delete Edge
            System.out.println("IN Delete Edge");
            Vertex V1 = new Vertex("X", evt.getX(), evt.getY());
            try {
                V1 = OOM.G.searchVertex(V1.getX(), V1.getY());
                if (From != null) {
                    try {
                        OOM.G.checkEdge(From.getName(), V1.getName());
                        From = null;
                    } catch (Invalid e) {
                        int input = JOptionPane.showConfirmDialog(null, "Do you want to Delete this Edge");
                        if (input == 0) {
                            OOM.G.deleteEdge(From.getName(), V1.getName());
                            From = null;
                            repaint();
                        } else {
                            JOptionPane.showMessageDialog(null, "You Cancelled Delete Operation");
                            From = null;
                            repaint();
                        }
                    }
                } else {
                    From = V1;
                }
                System.out.println(From + " " + V1);
                repaint();
            } catch (Invalid e) {
                From = null;
                repaint();

            }
        } else if (choice == 6) {
            System.out.println("IN Modify Edge");
            Vertex V1 = new Vertex("X", evt.getX(), evt.getY());
            try {
                V1 = OOM.G.searchVertex(V1.getX(), V1.getY());
                if (From != null) {
                    try {
                        OOM.G.checkEdge(From.getName(), V1.getName());
                        From = null;
                    } catch (Invalid e) {
                        int input = JOptionPane.showConfirmDialog(null, "Do you want to Modify this Edge");
                        if (input == 0) {
                            String f = JOptionPane.showInputDialog("Please Provide new Weight for this edge");
                            try {
                                double h = Double.parseDouble(f);
                                OOM.G.deleteEdge(From.getName(), V1.getName());
                                OOM.G.addEdge(From.getName(), V1.getName(), h);

                            } catch (Exception re) {
                                JOptionPane.showMessageDialog(null, "Enter weight in number");
                            }

                            From = null;
                            repaint();
                        } else {
                            JOptionPane.showMessageDialog(null, "You Cancelled Modify Operation");
                            From = null;
                            repaint();
                        }
                    }
                } else {
                    From = V1;
                }
                System.out.println(From + " " + V1);
                repaint();
            } catch (Invalid e) {
                From = null;
                repaint();
            }
        } else if (choice == 7)//Short Path
        {
            System.out.println("IN Short Path");
            Vertex V1 = new Vertex("X", evt.getX(), evt.getY());
            try {
                V1 = OOM.G.searchVertex(V1.getX(), V1.getY());
                if (From != null) {

                    try {
                        OOM.G.printPath(From.getName(), V1.getName(), 1);
                        To = V1;
                        if (From.getName().equals(To.getName())) {
                            JOptionPane.showMessageDialog(null, "Please Select Destination Different From Source", "Alert!", JOptionPane.WARNING_MESSAGE);
                            To = null;
                        }

                        repaint();
                    } catch (FileNotFoundException ex) {
                        From = null;
                        To = null;
                        JOptionPane.showMessageDialog(null, "Some Error Occured");
                    } catch (Invalid ee) {
                        From = null;
                        To = null;
                        JOptionPane.showMessageDialog(null, ee.getMessage());
                    }
                } else {
                    From = V1;
                    To = null;
                }
                System.out.println(From + " " + V1);
                repaint();
            } catch (Invalid e) {
                From = null;
                To = null;
                repaint();
            }

        }

    }//GEN-LAST:event_GraphPanelMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        choice = 1;
        ButtonGroup G1;
        G1 = new ButtonGroup();
        G1.add(AddE);
        G1.add(AddV);
        G1.add(DeleteE);
        G1.add(DeleteV);
        G1.add(ModifyE);
        G1.add(ModifyV);
        G1.add(ShortPath);

        repaint();
    }//GEN-LAST:event_formWindowOpened

    private void GraphPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GraphPanelMouseDragged
        // TODO add your handling code here:
        if (choice == 3) { //ModifyVertex
            Vertex V1 = new Vertex("X", evt.getX(), evt.getY());
            try {
                OOM.G.searchVertex(V1.getX(), V1.getY());
                From = null;
            } catch (Invalid e) {
                From = V1;
                if (To == null) {
                    From = null;
                }
            }

            repaint();
        }
    }//GEN-LAST:event_GraphPanelMouseDragged

    private void GraphPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GraphPanelMouseReleased
        // TODO add your handling code here:
        if (choice == 3) { //Modify Vertex
            Vertex V1 = new Vertex("X", evt.getX(), evt.getY());
            try {
                OOM.G.searchVertex(V1.getX(), V1.getY());
                repaint();
            } catch (Invalid e) {
                if (To == null) {
                    From = null;
                    repaint();
                } else {
                    OOM.G.getVert().get(To.getName()).setX(V1.getX());
                    OOM.G.getVert().get(To.getName()).setY(V1.getY());
                    From = null;
                    repaint();
                }
            }
        }
    }//GEN-LAST:event_GraphPanelMouseReleased

    private void GraphPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GraphPanelMousePressed
        // TODO add your handling code here:
        if (choice == 3) { //ModifyVertex
            Vertex V1 = new Vertex("X", evt.getX(), evt.getY());
            try {
                V1 = OOM.G.searchVertex(V1.getX(), V1.getY());
                To = V1;
            } catch (Invalid e) {
                To = null;
            }
        }
    }//GEN-LAST:event_GraphPanelMousePressed

    private void ModifyEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyEActionPerformed
        // TODO add your handling code here:
        if (ModifyE.isSelected()) {
            Label.setText("Modify Edge By Selecting FromVertex and To Vertex");
            choice = 6;
            From = null;
            To = null;
            repaint();
        }

    }//GEN-LAST:event_ModifyEActionPerformed

    private void AddVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddVActionPerformed
        // TODO add your handling code here:
        if (AddV.isSelected()) {
            Label.setText("Add Vertex By Clicking on the Panel");
            choice = 1;
            From = null;
            To = null;
            repaint();
        }
    }//GEN-LAST:event_AddVActionPerformed

    private void DeleteVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteVActionPerformed
        // TODO add your handling code here:
        if (DeleteV.isSelected()) {
            Label.setText("Delete Vertex By Clicking on the Vertex");
            choice = 4;
            From = null;
            To = null;
        }
        repaint();

    }//GEN-LAST:event_DeleteVActionPerformed

    private void ModifyVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyVActionPerformed
        // TODO add your handling code here:
        if (ModifyV.isSelected()) {
            Label.setText("Modify Vertex By Dragging Vertex");
            choice = 3;
            From = null;
            To = null;
            repaint();
        }

    }//GEN-LAST:event_ModifyVActionPerformed

    private void AddEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEActionPerformed
        // TODO add your handling code here:
        if (AddE.isSelected()) {
            Label.setText("Add Edge By Selecting FromVertex & ToVertex");
            choice = 2;
            From = null;
            To = null;
            repaint();
        }
    }//GEN-LAST:event_AddEActionPerformed

    private void DeleteEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteEActionPerformed
        // TODO add your handling code here:
        if (DeleteE.isSelected()) {
            Label.setText("Delete Edge By Selecting FromVertex & ToVertex");
            choice = 5;
            From = null;
            To = null;
            repaint();
        }
    }//GEN-LAST:event_DeleteEActionPerformed

    private void ShortPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShortPathActionPerformed
        // TODO add your handling code here:
        if (ShortPath.isSelected()) {
            Label.setText("Select From Vertex & To Vertex");
            choice = 7;
            From = null;
            To = null;
            repaint();
        }
    }//GEN-LAST:event_ShortPathActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(VisualGraphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualGraphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualGraphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualGraphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualGraphics().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AddE;
    private javax.swing.JRadioButton AddV;
    private javax.swing.JButton Back;
    private javax.swing.JRadioButton DeleteE;
    private javax.swing.JRadioButton DeleteV;
    private javax.swing.JPanel GraphPanel;
    private javax.swing.JLabel Label;
    private javax.swing.JRadioButton ModifyE;
    private javax.swing.JRadioButton ModifyV;
    private javax.swing.JRadioButton ShortPath;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
