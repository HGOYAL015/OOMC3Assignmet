/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import javax.swing.JOptionPane;
import static main.Vertex.*;
import static main.Path.*;

/**
 *
 * @author harsh
 */
//class Invalid extends Exception
//{
//    Invalid(String s)
//    {
//        super(s);
//    }
//}
class VertexCompare implements Comparator<Vertex> {

    public int compare(Vertex m1, Vertex m2) {
        return m1.getName().compareTo(m2.getName());
    }
}

class StringCompare implements Comparator<String> {

    public int compare(String m1, String m2) {
        return m1.compareTo(m2);
    }
}

public class Graph {

    private ArrayList<Vertex> V = new ArrayList<Vertex>();
    private HashMap<String, ArrayList<String>> Edges = new HashMap<>();
    private HashMap<String, Vertex> Vert = new HashMap<String, Vertex>();
    private ArrayList<ArrayList<String>> E = new ArrayList<ArrayList<String>>();
    private HashMap<String, Integer> map = new HashMap<String, Integer>();
    private HashMap<String, Double> WeightMap = new HashMap<String, Double>();
    private Path P = new Path();

    public void printPath(String s, String d, int t) throws Invalid, FileNotFoundException {
        if (t == 0) {
            P.printAllPaths(s, d);
        } else {
            P.printPath1(s, d);
        }
    }

    public void checkEdge(String from, String to) throws Invalid {

        ArrayList<String> temp = Edges.get(from);
        for (String A : temp) {
            if (A.equals(to)) {

                throw new Invalid("This Edge Already Exists");

            }
        }

    }

    public double getWeight(String from, String to) {
        return WeightMap.get(from + "?" + to);

    }

    public void addEdge(String from, String to, Double Weight) {

        this.Edges.get(from).add(to);
        this.WeightMap.put(from + "?" + to, Weight);
        System.out.println(Edges);
//        System.out.println(E);
//        System.out.println(E.get(g));
    }

    public void deleteEdge(String from, String to) {

        this.Edges.get(from).remove(to);
        WeightMap.remove(from + "?" + to);
//        System.out.println(WeightMap);
//        System.out.println(E.get(g));
    }

    public void showEdges() {
        sortVertex();
        for (Vertex A : V) {

            ArrayList<String> temp = Edges.get(A.getName());
            Collections.sort(temp, new StringCompare());
            for (String B : temp) {
                System.out.println(A.getName() + " " + B + " " + Math.round(WeightMap.get(A.getName() + "?" + B)));
            }

        }
    }

    public ArrayList<String> getEdgeList(String from) {
        int g = map.get(from) - 1;
        return E.get(g);

    }

    public void sortVertex() {
        VertexCompare Compare = new VertexCompare();
        Collections.sort(V, Compare);
    }

    public void printVertex() {
        for (Vertex A : V) {
            System.out.println(A.getName() + " " + Math.round(A.getX()) + " " + Math.round(A.getY()));
        }
    }

    public void addVertex(Vertex e) {
        V.add(e);
        map.put(e.getName(), V.size());
        ArrayList<String> temp = new ArrayList<String>();
        OOM.G.Edges.put(e.getName(), temp);
        OOM.G.Vert.put(e.getName(), e);

        E.add(temp);

    }

    public void searchVertex(Vertex e) throws Invalid {
        for (Vertex A : V) {

            if (A.getName().equals(e.getName()) || (A.getX() == e.getX() && A.getY() == e.getY())) {
                throw new Invalid("Vertex is Already Present");

            }
        }
    }

    public Vertex searchVertex(String name) throws Invalid {
        int flag = 0;
        for (Vertex A : V) {
            if (A.getName().equals(name)) {
                flag = 1;
                return A;
            }

        }
        if (flag == 0) {
            throw new Invalid("Vertex with name: " + name + " Not Found\n");

        }
        return null;
    }

    public void deleteVertex(Vertex e) {
//        for (Vertex A : V) {
//
//            if (A.getName().equals(e.getName())) {
//                {
//                    V.remove(A);
//                    this.Edges.remove(e.getName());
//                    this.Vert.remove(e.getName());                                   
//                }
//            }
//        }
        V.remove(e);
        this.Edges.remove(e.getName());
        this.Vert.remove(e.getName());
        for (Vertex A : V) {
            ArrayList<String> temp = Edges.get(A.getName());
            temp.remove(e.getName());
        }

    }

    public ArrayList<Vertex> getV() {
        return V;
    }

    public HashMap<String, ArrayList<String>> getEdges() {
        return Edges;
    }

    public HashMap<String, Vertex> getVert() {
        return Vert;
    }

    public HashMap<String, Double> getWeightMap() {
        return WeightMap;
    }

    public ArrayList<ArrayList<String>> getE() {
        return E;
    }

    public HashMap<String, Integer> getMap() {
        return map;
    }

}
