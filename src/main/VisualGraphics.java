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
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static main.VisualGraphics.anim;
//import static main.VisualGraphics.ax;
//import static main.VisualGraphics.ax1;
//import static main.VisualGraphics.ax2;
//import static main.VisualGraphics.ay;
//import static main.VisualGraphics.ay1;
//import static main.VisualGraphics.ay2;
import static main.VisualGraphics.hg;
//import static main.VisualGraphics.style1;
import static main.VisualGraphics.*;

/**
 *
 * @author harsh
 */
class visual extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        gg.setStroke(new BasicStroke((float) 1.2));
        for (Vertex A : OOM.G.getV()) {
            gg.setColor(Color.black);
            gg.fillOval(A.getX() - 8, A.getY() - 8, 16, 16);
            gg.setColor(Color.BLUE);
            gg.drawString(A.getName(), A.getX() - 10, A.getY() - 10);
        }
        for (Vertex A : OOM.G.getV()) {
            int x = A.getX();
            int y = A.getY();
            for (String B : OOM.G.getEdges().get(A.getName())) {
                int x1 = OOM.G.getVert().get(B).getX();
                int y1 = OOM.G.getVert().get(B).getY();
                gg.setColor(Color.red);
                gg.setStroke(new BasicStroke(2));
//                if(OOM.G.getEdges().get(B).contains(A.getName()))

                gg.drawLine(x, y, x1, y1);

                gg.setColor(Color.red);

            }
        }
        for (Vertex A : OOM.G.getV()) {
            int x = A.getX();
            int y = A.getY();
            for (String B : OOM.G.getEdges().get(A.getName())) {
                int x1 = OOM.G.getVert().get(B).getX();
                int y1 = OOM.G.getVert().get(B).getY();
                gg.setColor(Color.red);
                gg.setStroke(new BasicStroke(2));
                int dist = (x - x1) * (x - x1) + (y - y1) * (y - y1);
                dist = (int) Math.sqrt(dist);
                int t1x = (x1 * 50 + x * (dist - 50)) / dist;
                int t1y = (y1 * 50 + y * (dist - 50)) / dist;
                int t2x = (x1 * 30 + x * (dist - 30)) / dist;
                int t2y = (y1 * 30 + y * (dist - 30)) / dist;

                gg.setColor(Color.BLUE);
                int w = (int) OOM.G.getWeight(A.getName(), B);
                gg.setStroke(new BasicStroke(4));
                gg.drawString(Integer.toString(w), (t1x + t2x) / 2, (t1y + t2y) / 2 + 20);

            }
        }
        gg.setStroke(new BasicStroke(3));
        gg.setColor(Color.red);
        if (VisualGraphics.From != null) {
            if (VisualGraphics.choice == 2 || VisualGraphics.choice == 6) {
                gg.drawOval(VisualGraphics.From.getX() - 15, VisualGraphics.From.getY() - 15, 30, 30);
            }
            if (VisualGraphics.choice == 3 || VisualGraphics.choice == 5) {
                gg.setColor(Color.BLUE);
                gg.drawOval(VisualGraphics.From.getX() - 15, VisualGraphics.From.getY() - 15, 30, 30);
            }
            if (VisualGraphics.choice == 7 || choice == 8) {
                gg.setColor(Color.ORANGE);
                gg.drawOval(VisualGraphics.From.getX() - 15, VisualGraphics.From.getY() - 15, 30, 30);
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
                    gg.setColor(Color.red);
                    gg.drawOval(VisualGraphics.To.getX() - 15, VisualGraphics.To.getY() - 15, 30, 30);
                    gg.setColor(Color.green);
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
                            gg.drawLine(x, y, x1, y1);

                        }
                    }

                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "Some Error Occured");
                }

            }
        }
        if (choice == 8 && anim == 1) {
//            File file = new File("/home/harsh/NetBeansProjects/OOM/src/main/Path");
//            try {
//                Scanner scan = new Scanner(file);
//                String s = scan.nextLine();
//                s = s.substring(0, s.length() - 1);
//                String[] inputs = s.split("-->");
//                gg.setColor(Color.red);
//                gg.drawOval(VisualGraphics.To.getX() - 15, VisualGraphics.To.getY() - 15, 30, 30);
//                gg.setColor(Color.green);
//                if (inputs.length > 1) {
//                    for (int i = 0; i < inputs.length - 1; i++) {
//                        if (!(OOM.G.getVert().containsKey(inputs[i]) && OOM.G.getVert().containsKey(inputs[i + 1]))) {
//                            break;
//                        }
//
//                        int x = OOM.G.getVert().get(inputs[i]).getX();
//                        int y = OOM.G.getVert().get(inputs[i]).getY();
//                        int x1 = OOM.G.getVert().get(inputs[i + 1]).getX();
//                        int y1 = OOM.G.getVert().get(inputs[i + 1]).getY();
////                            gg.setStroke(new BasicStroke(1.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f, 10.0, 0.0f));
//
////final static float dash1[] = {10.0f}
//                        gg.drawLine(x, y, x1, y1);
//
//                    }
//                }
//
//            } catch (FileNotFoundException ex) {
//                JOptionPane.showMessageDialog(this, "Some Error Occured");
//            }
//            int R = (int) (Math.random() * 256);
//            int G = (int) (Math.random() * 256);
//            int B = (int) (Math.random() * 256);
//            Color randomColor;
//            randomColor = new Color(R, G, B);
//            gg.setColor(randomColor);
            for (chlte A : animaa) {
                gg.setColor(Color.black);
                gg.setStroke(new BasicStroke(2));
                if (A.style == 1 && A.getH() != null) {
//                ax=ax;
//                ay=ay;
                    gg.drawOval(A.ax - 6, A.ay - 6, 12, 12);
                }
                if (A.style == 2 && A.getH() != null) {
//                ax=ax2;
//                ay=ay2;
                    gg.setColor(Color.GREEN);
                    gg.drawRect(A.ax - 6, A.ay - 6, 12, 12);
                }
                if (A.style == 4 && A.getH() != null) {
//                ax = ax4;
//                ay = ay4;
                    gg.setStroke(new BasicStroke(3));
                    gg.setColor(Color.blue);
                    gg.drawLine(A.ax, A.ay, A.ax - 12, A.ay);
                    gg.drawLine(A.ax, A.ay, A.ax, A.ay + 12);
                    gg.drawLine(A.ax, A.ay, A.ax + 12, A.ay);
                    gg.drawLine(A.ax, A.ay, A.ax, A.ay - 12);
                }
                if (A.style == 3 && A.getH() != null) {
//                ax=ax3;
//                ay=ay3;
                    gg.setStroke(new BasicStroke(3));
                    gg.setColor(Color.pink);

                    gg.drawLine(A.ax - 9, A.ay - 9, A.ax + 9, A.ay + 9);
                    gg.drawLine(A.ax - 9, A.ay + 9, A.ax + 9, A.ay - 9);

                }
                if (A.style == 5 && A.getH() != null) {
//                ax=ax5;
//                ay=ay5;
                    gg.setColor(Color.MAGENTA);
                    gg.setStroke(new BasicStroke(2));
//                gg.setColor(Color.black);
                    int X[] = {A.ax, A.ax, A.ax + 9, A.ax};
                    int Y[] = {A.ay, A.ay + 9, A.ay, A.ay - 9};
                    gg.drawPolygon(X, Y, X.length);
                }
            }

        }
    }
}

class chlte {

    int ax;
    int ay;
    int style = 1;
    ArrayList<P> hg = new ArrayList<P>();
    Thread h = null;

    chlte(int x, int y, ArrayList<P> hg, int s, Thread h) {
        this.ax = x;
        this.ay = y;
        this.hg = hg;
        this.h = h;
        this.style = s;
//        h.start();
    }

    public int getAx() {
        return ax;
    }

    public void setAx(int ax) {
        this.ax = ax;
    }

    public int getAy() {
        return ay;
    }

    public void setAy(int ay) {
        this.ay = ay;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public ArrayList<P> getHg() {
        return hg;
    }

    public void setHg(ArrayList<P> hg) {
        this.hg = hg;
    }

    public Thread getH() {
        return h;
    }

    public void setH(Thread h) {
        this.h = h;
        if (h != null) {
            h.start();
        } else {
            System.out.println("OHH ye kya hain");
        }
    }

}

class P {

    int x;
    int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    P(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class VisualGraphics extends javax.swing.JFrame implements Runnable {

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
    static int anim = 0;
    static ArrayList<P> k = new ArrayList<P>();
    static ArrayList<P> hg = new ArrayList<P>();

    static ArrayList<chlte> animaa = new ArrayList<chlte>();

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
        AnimateR = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        Circle = new javax.swing.JRadioButton();
        Square = new javax.swing.JRadioButton();
        Cross = new javax.swing.JRadioButton();
        Plus = new javax.swing.JRadioButton();
        Triangle = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
                .addContainerGap(714, Short.MAX_VALUE))
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

        AnimateR.setBackground(java.awt.Color.gray);
        AnimateR.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        AnimateR.setText("Animation");
        AnimateR.setToolTipText("Click On BUtton to Animate Your Path");
        AnimateR.setBorder(null);
        AnimateR.setBorderPainted(true);
        AnimateR.setContentAreaFilled(false);
        AnimateR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AnimateR.setFocusPainted(false);
        AnimateR.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AnimateR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnimateRActionPerformed(evt);
            }
        });

        Circle.setBackground(java.awt.Color.gray);
        Circle.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        Circle.setSelected(true);
        Circle.setText("Circle");
        Circle.setToolTipText("Select Style");
        Circle.setBorder(null);
        Circle.setBorderPainted(true);
        Circle.setContentAreaFilled(false);
        Circle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Circle.setFocusPainted(false);
        Circle.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Circle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CircleActionPerformed(evt);
            }
        });

        Square.setBackground(java.awt.Color.gray);
        Square.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        Square.setText("Square");
        Square.setToolTipText("Select Style");
        Square.setBorder(null);
        Square.setBorderPainted(true);
        Square.setContentAreaFilled(false);
        Square.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Square.setFocusPainted(false);
        Square.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Square.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SquareActionPerformed(evt);
            }
        });

        Cross.setBackground(java.awt.Color.gray);
        Cross.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        Cross.setText("Cross");
        Cross.setToolTipText("Select Style");
        Cross.setBorder(null);
        Cross.setBorderPainted(true);
        Cross.setContentAreaFilled(false);
        Cross.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cross.setFocusPainted(false);
        Cross.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Cross.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrossActionPerformed(evt);
            }
        });

        Plus.setBackground(java.awt.Color.gray);
        Plus.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        Plus.setText("Plus");
        Plus.setToolTipText("Select Style");
        Plus.setBorder(null);
        Plus.setBorderPainted(true);
        Plus.setContentAreaFilled(false);
        Plus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Plus.setFocusPainted(false);
        Plus.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Plus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlusActionPerformed(evt);
            }
        });

        Triangle.setBackground(java.awt.Color.gray);
        Triangle.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        Triangle.setText("Triangle");
        Triangle.setToolTipText("Select Style");
        Triangle.setBorder(null);
        Triangle.setBorderPainted(true);
        Triangle.setContentAreaFilled(false);
        Triangle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Triangle.setFocusPainted(false);
        Triangle.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Triangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TriangleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
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
                            .addComponent(DeleteV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ShortPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AnimateR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Circle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Square, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Cross, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Plus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Triangle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AnimateR, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Circle, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Square, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Cross, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Plus, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Triangle, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
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
                .addContainerGap(19, Short.MAX_VALUE)
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
            String s = JOptionPane.showInputDialog("Please Provide Name of Vertex");

            try {
                if (s == null || s.isEmpty()) {
                    throw new Invalid("Please Enter Correct Name Of vertex");
                }
                Vertex V1 = new Vertex(s, x, y);
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
            aisehi();

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

        } else if (choice == 8) {
            System.out.println("IN Animaa Path");
            Vertex V1 = new Vertex("X", evt.getX(), evt.getY());
            try {
                V1 = OOM.G.searchVertex(V1.getX(), V1.getY());
                if (ffrom != null) {

                    try {
                        OOM.G.printPath(ffrom.getName(), V1.getName(), 1, "sss");
                        too = V1;
                        if (ffrom.getName().equals(too.getName())) {
                            JOptionPane.showMessageDialog(null, "Please Select Destination Different From Source", "Alert!", JOptionPane.WARNING_MESSAGE);
                            too = null;
                        }
                        From = ffrom;
                        

                        k = new ArrayList<P>();

//                        Label.setText("No Mouse Operation is Possible on Below Panel");
                        File file = new File("/home/harsh/NetBeansProjects/OOM/src/main/sss");
                        try {
                            Scanner scan = new Scanner(file);
                            String s = scan.nextLine();
                            s = s.substring(0, s.length() - 1);
                            String[] inputs = s.split("-->");

                            if (inputs.length > 1) {
                                for (int i = 0; i < inputs.length; i++) {
                                    if (!(OOM.G.getVert().containsKey(inputs[i]))) {
                                        break;
                                    }

                                    int x = OOM.G.getVert().get(inputs[i]).getX();
                                    int y = OOM.G.getVert().get(inputs[i]).getY();
//                            gg.setStroke(new BasicStroke(1.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f, 10.0, 0.0f));

//final static float dash1[] = {10.0f}
                                    k.add(new P(x, y));

                                }
                            }

                        } catch (FileNotFoundException ex) {
                            JOptionPane.showMessageDialog(this, "Some Error Occured");
                            this.dispose();
                        }
                        hg = new ArrayList<P>();
                        for (int i = 0; i < k.size() - 1; i++) {
                            int a = k.get(i + 1).getX();
                            int b = k.get(i + 1).getY();
                            int x = k.get(i).getX();
                            int y = k.get(i).getY();
                            hg.add(new P(x, y));
                            int dis = (a - x) * (a - x) + (b - y) * (b - y);
                            dis = (int) Math.sqrt(dis);
                            for (int j = 1; j < dis; j++) {
                                int xa = ((dis - j) * x + (j) * a) / dis;
                                int ya = ((dis - j) * y + (j) * b) / dis;
                                hg.add(new P(xa, ya));
                            }
                            hg.add(new P(a, b));
                        }
                        Thread gg = new Thread(this);
                        chlte HH = new chlte(k.get(0).getX(), k.get(0).getY(), hg, 1, null);
                        this.animaa.add(HH);
                        anim = 1;
                        HH.setH(gg);
                        Circle.setSelected(true);
                        System.out.print(HH + "\n" + animaa + "\n");

                        JOptionPane.showMessageDialog(null, "You Can Select Animation Style from left");
                        repaint();

                    } catch (FileNotFoundException ex) {
                        ffrom = null;
                        too = null;
                        From=null;

                        JOptionPane.showMessageDialog(null, "Some Error Occured");
                    } catch (Invalid ee) {
                        From=null;
                        ffrom = null;
                        too = null;
                        JOptionPane.showMessageDialog(null, ee.getMessage());
                    }
                } else {

                    ffrom = V1;
                    From=ffrom;

                    too = null;
//                    aisehi();
                }
                System.out.println(From + " " + V1);
                repaint();
            } catch (Invalid e) {
                From=null;
                ffrom = null;
                too = null;
                repaint();
            }

        }

    }//GEN-LAST:event_GraphPanelMouseClicked
    public Vertex ffrom = null;
    public Vertex too = null;
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        choice = 1;
        ButtonGroup G1, G2;
        G1 = new ButtonGroup();
        G1.add(AddE);
        G1.add(AddV);
        G1.add(DeleteE);
        G1.add(DeleteV);
        G1.add(ModifyE);
        G1.add(ModifyV);
        G1.add(ShortPath);
        G1.add(AnimateR);

        G2 = new ButtonGroup();
        G2.add(Circle);
        G2.add(Square);
        G2.add(Cross);
        G2.add(Plus);
        G2.add(Triangle);

        aisehi();

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

//        anim = 0;
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

//        aisehi();
//        anim = 0;
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

        aisehi();
        anim = 0;
        if (ModifyE.isSelected()) {
            Label.setText("Modify Edge By Selecting FromVertex and To Vertex");
            choice = 6;
            From = null;
            To = null;
            repaint();
        } else {
            Label.setText("Please Select An Operation from Menu");
            choice = 0;
            repaint();
        }

    }//GEN-LAST:event_ModifyEActionPerformed

    private void AddVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddVActionPerformed
        // TODO add your handling code here:

        aisehi();
        anim = 0;
        if (AddV.isSelected()) {
            Label.setText("Add Vertex By Clicking on the Panel");
            choice = 1;
            From = null;
            To = null;
            repaint();
        } else {
            Label.setText("Please Select An Operation from Menu");
            choice = 0;
            repaint();
        }
    }//GEN-LAST:event_AddVActionPerformed

    private void DeleteVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteVActionPerformed
        // TODO add your handling code here:

        aisehi();
        anim = 0;
        if (DeleteV.isSelected()) {
            Label.setText("Delete Vertex By Clicking on the Vertex");
            choice = 4;
            From = null;
            To = null;
        } else {
            Label.setText("Please Select An Operation from Menu");
            choice = 0;
        }

        repaint();

    }//GEN-LAST:event_DeleteVActionPerformed

    private void ModifyVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyVActionPerformed
        // TODO add your handling code here:

        aisehi();
        anim = 0;
        if (ModifyV.isSelected()) {
            Label.setText("Modify Vertex By Dragging Vertex");
            choice = 3;
            From = null;
            To = null;
            repaint();
        } else {
            Label.setText("Please Select An Operation from Menu");
            choice = 0;
            repaint();
        }
//        AnimateR.setSelected(false);
//        AnimateR.setEnabled(false);

    }//GEN-LAST:event_ModifyVActionPerformed

    private void AddEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEActionPerformed
        // TODO add your handling code here:

        aisehi();
        anim = 0;
        if (AddE.isSelected()) {
            Label.setText("Add Edge By Selecting FromVertex & ToVertex");
            choice = 2;
            From = null;
            To = null;
            repaint();
        } else {
            Label.setText("Please Select An Operation from Menu");
            choice = 0;
            repaint();
        }
//        AnimateR.setSelected(false);
//        AnimateR.setEnabled(false);
    }//GEN-LAST:event_AddEActionPerformed

    private void DeleteEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteEActionPerformed
        // TODO add your handling code here:

        aisehi();
        anim = 0;
        if (DeleteE.isSelected()) {
            Label.setText("Delete Edge By Selecting FromVertex & ToVertex");
            choice = 5;
            From = null;
            To = null;
            repaint();
        } else {
            Label.setText("Please Select An Operation from Menu");
            choice = 0;
            repaint();
        }
//        AnimateR.setSelected(false);
//        AnimateR.setEnabled(false);
    }//GEN-LAST:event_DeleteEActionPerformed

    private void ShortPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShortPathActionPerformed
        // TODO add your handling code here:

        aisehi();
        anim = 0;
        if (ShortPath.isSelected()) {
            Label.setText("Select From Vertex & To Vertex");
            choice = 7;
            From = null;
            To = null;
            repaint();
        } else {
            Label.setText("Please Select An Operation from Menu");
            choice = 0;
            repaint();
        }
//        AnimateR.setSelected(false);
//        AnimateR.setEnabled(false);
    }//GEN-LAST:event_ShortPathActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

        aisehi();
        anim = 0;
        anim = 0;
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        anim = 0;
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

//    visual GraphPanel;
    @Override
    public void run() {
//        initComponents();
        System.out.println(" I am Called");
        System.out.println(this);
        ArrayList<P> hh = null;
        for (chlte B : animaa) {
            if (Thread.currentThread().equals(B.h)) {
                hh = B.hg;
                System.out.println(" I am Calleddsds");

            }
        }
        while (anim == 1 && hh != null && hh.size() >= 2) {
            for (P A : hh) {
                int ax = 0;
                int ay = 0;
//                System.out.println("I amin " + x + "  ; " + y);

//            System.out.println("I amin " + ax + "  ; " + ay);
                try {
                    for (chlte B : animaa) {
                        if (Thread.currentThread().equals(B.h)) {
                            B.setAx(A.getX());
                            B.setAy(A.getY());
                        }
                    }
                    sleep((long) 10);
                    repaint();

                    if (anim == 0) {
                        Thread.currentThread().interrupt();
                    }
                } catch (InterruptedException ex) {
                    System.out.print("Thread is Dead Now");
                    return;
                }

            }
        }

    }

    public void aisehi() {
        anim = 0;
        ffrom=null;
        From=null;
        too=null;
        To=null;
        for (chlte A : animaa) {
            if (A.h != null) {
                A.h.interrupt();
                A.h = null;
            }
        }

    }
    private void AnimateRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnimateRActionPerformed
        // TODO add your handling code here:
        if (AnimateR.isSelected()) {
            choice = 8;
            anim = 1;

            Label.setText("Select From Vertex & To Vertex");

            choice = 8;
//            GraphPanel.repaint();

        } else if (!AnimateR.isSelected()) {
            System.out.print("bye");
            anim = 0;

            aisehi();
            repaint();
        }
    }//GEN-LAST:event_AnimateRActionPerformed

    private void CircleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CircleActionPerformed
        // TODO add your handling code here:
        if (Circle.isSelected()) {
            if (animaa.size() >= 1) {
                animaa.get(animaa.size() - 1).style = 1;
            }
            repaint();
        } else {

        }
        repaint();
    }//GEN-LAST:event_CircleActionPerformed

    private void SquareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SquareActionPerformed
        // TODO add your handling code here:
        if (Square.isSelected()) {
            if (animaa.size() >= 1) {
                animaa.get(animaa.size() - 1).style = 2;
            }
            repaint();
        } else {

        }
        repaint();
    }//GEN-LAST:event_SquareActionPerformed

    private void CrossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrossActionPerformed
        // TODO add your handling code here:
        if (Cross.isSelected()) {
            if (animaa.size() >= 1) {
                animaa.get(animaa.size() - 1).style = 3;
            }
        } else {

            repaint();
        }
    }//GEN-LAST:event_CrossActionPerformed

    private void PlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlusActionPerformed
        // TODO add your handling code here:
        if (Plus.isSelected()) {
            if (animaa.size() >= 1) {
                animaa.get(animaa.size() - 1).style = 4;
            }
            repaint();
        } else {

            repaint();
        }
    }//GEN-LAST:event_PlusActionPerformed

    private void TriangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TriangleActionPerformed
        // TODO add your handling code here:
        if (Triangle.isSelected()) {
            if (animaa.size() >= 1) {
                animaa.get(animaa.size() - 1).style = 5;
            }
            repaint();
        } else {

            repaint();
        }

    }//GEN-LAST:event_TriangleActionPerformed

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
    private javax.swing.JRadioButton AnimateR;
    private javax.swing.JButton Back;
    private javax.swing.JRadioButton Circle;
    private javax.swing.JRadioButton Cross;
    private javax.swing.JRadioButton DeleteE;
    private javax.swing.JRadioButton DeleteV;
    private javax.swing.JPanel GraphPanel;
    private javax.swing.JLabel Label;
    private javax.swing.JRadioButton ModifyE;
    private javax.swing.JRadioButton ModifyV;
    private javax.swing.JRadioButton Plus;
    private javax.swing.JRadioButton ShortPath;
    private javax.swing.JRadioButton Square;
    private javax.swing.JRadioButton Triangle;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

}
