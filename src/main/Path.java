/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import static main.OOM.*;
import static main.Graph.*;
import static main.Vertex.*;
import main.Invalid.*;

/**
 *
 * @author harsh
 */
public class Path {

    private int flag = 0;
    private Double[] cost;
    private int length;
    private Integer[] visited;
    private Integer[] parent;
    private HashMap<String, Integer> tempMap;
    private HashMap<Integer, String> tempMap1;

    public void printAllPaths(String s, String d) throws Invalid, FileNotFoundException {

        PrintStream o = new PrintStream(new File("/home/harsh/NetBeansProjects/OOM/src/main/Path"));
        PrintStream console = System.out;
        System.setOut(o);

        boolean[] isVisited = new boolean[OOM.G.getV().size()];
        tempMap = new HashMap<String, Integer>();
        int i = 0;
        for (Vertex A : OOM.G.getV()) {
            isVisited[i] = false;
            this.tempMap.put(A.getName(), i);

            ++i;
        }
        ArrayList<String> pathList = new ArrayList<String>();
        //add source to path[] 
        pathList.add(s);

        flag = 0;
        //Call recursive utility 
        printAllPathsUtil(s, d, isVisited, pathList);
        if (flag == 0) {
            throw new Invalid("There Exists No path for given Set");
        }
    }

    private void printAllPathsUtil(String s, String d, boolean[] visited, ArrayList<String> pathList) {
        int g = this.tempMap.get(s);
        visited[g] = true;
        if (d.equals(s)) {
//            System.out.println(pathList);
            for (String G : pathList) {
                if (G.equals(d)) {
                    System.out.println(G + ".");
                } else {
                    System.out.print(G + "-->");
                }
            }
            visited[g] = false;
            flag = 1;
            return;
        }

        for (String A : OOM.G.getEdges().get(s)) {
            int h = this.tempMap.get(A);

            if (!visited[h]) {
                pathList.add(A);
                printAllPathsUtil(A, d, visited, pathList);
                pathList.remove(A);
            }
        }
        visited[g] = false;

    }

    public void reset(String s) {
        for (int i = 0; i < OOM.G.getV().size(); i++) {
            this.cost[i] = Integer.MAX_VALUE * (1.0);
            this.visited[i] = 0;
            this.parent[i] = i;
        }
        int i = 0;
        for (Vertex A : OOM.G.getV()) {
            visited[i] = 0;
            this.tempMap.put(A.getName(), i);
            this.tempMap1.put(i, A.getName());
            ++i;
        }
        int g = this.tempMap.get(s);
        this.cost[g] = 0.0;
    }

    public void init() {
        this.cost = new Double[OOM.G.getV().size()];
        this.length = OOM.G.getV().size();
        visited = new Integer[length];
        parent = new Integer[length];
        tempMap = new HashMap<String, Integer>();
        tempMap1 = new HashMap< Integer, String>();

    }

    public int indexMin() {
        double min = Integer.MAX_VALUE * (1.0);
        int min_index = -1;

        for (int v = 0; v < this.length; v++) {
            if (this.visited[v] == 0 && this.cost[v] < min) {
                min = cost[v];
                min_index = v;
            }
        }
        return min_index;
    }

    public void Djsktra() throws Invalid {
        for (int i = 0; i < this.length; i++) {
            int x = this.indexMin();
            if (x == -1 || cost[x] == (Integer.MAX_VALUE * (1.0))) {
                continue;
            }
            this.visited[x] = 1;
            String s = this.tempMap1.get(x);
            ArrayList<String> temp = OOM.G.getEdges().get(s);
            Collections.sort(temp, new StringCompare());
            for (String A : temp) {
                int g = this.tempMap.get(A);

                double w = OOM.G.getWeight(s, A);
//                System.out.println(V.getName() + " " + x + " " + g);
                if (visited[g] == 0 && (cost[x] + w < cost[g])) {
                    parent[g] = x;
                    cost[g] = cost[x] + w;

                }
            }
        }
    }

    public void printPathShort(String from, String to, int flag) throws Invalid {
        if (from.equals(to)) {
            System.out.print(to + "-->");
            return;
        } else {
            int x = this.tempMap.get(to);
            x = parent[x];
            String s = this.tempMap1.get(x);
//            System.out.print(from + " " + to + " " + s + "\n");
            if (s.equals(to)) {
                throw new Invalid("No path Exists between the given Set");
            }

            printPathShort(from, s, 1);

            if (flag == 0) {
                System.out.print(to + ".\nCost:" + Math.round(this.cost[this.tempMap.get(to)]));
            } else {
                System.out.print(to + "-->");

            }

        }
    }

    public void printPath1(String from, String to) throws Invalid, FileNotFoundException {
        System.out.println(from + " " + to);
        PrintStream o = new PrintStream(new File("/home/harsh/NetBeansProjects/OOM/src/main/Path"));
        PrintStream console = System.out;
        init();
        reset(from);
        this.Djsktra();
        System.setOut(o);
        int flag = 0;
        this.printPathShort(from, to, flag);
        System.setOut(console);
    }

    public void printPath1(String from, String to, String ff) throws Invalid, FileNotFoundException {
        System.out.println(from + " " + to);
        PrintStream o = new PrintStream(new File("/home/harsh/NetBeansProjects/OOM/src/main/" + ff));
        PrintStream console = System.out;
        init();
        reset(from);
        this.Djsktra();
        System.setOut(o);
        int flag = 0;
        this.printPathShort(from, to, flag);
        System.setOut(console);
    }
}
