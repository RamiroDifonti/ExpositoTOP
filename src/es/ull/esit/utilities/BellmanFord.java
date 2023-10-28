package es.ull.esit.utilities;

import java.util.ArrayList;

public class BellmanFord {

    /**
     *
     */
    private static final int INFINITY = 999999;
    /**
     *
     */
    private final int[][] distanceMatrix;
    /**
     *
     */
    private ArrayList<Integer> edges1 = null;
    /**
     *
     */
    private ArrayList<Integer> edges2 = null;
    /**
     *
     */
    private final int nodes;
    /**
     *
     */
    private final ArrayList<Integer> path;
    /**
     *
     */
    private int[] distances = null;
    /**
     *
     */
    private int value;

    /**
     * @brief Constructo de la clase BellmanFord
     * @param distanceMatrix : int[][]
     * @param nodes : int
     * @param path : ArrayList<Integer>
     */
    public BellmanFord(int[][] distanceMatrix, int nodes, ArrayList<Integer> path) {
        this.distanceMatrix = distanceMatrix;
        this.nodes = nodes;
        this.path = path;
        this.calculateEdges();
        this.value = BellmanFord.INFINITY;
    }

    /**
     * @brief Calcula los bordes para el eje i y para el eje j
     * @return void
     */
    private void calculateEdges() {
        this.edges1 = new ArrayList<>();
        this.edges2 = new ArrayList<>();
        for (int i = 0; i < this.nodes; i++) {
            for (int j = 0; j < this.nodes; j++) {
                if (this.distanceMatrix[i][j] != Integer.MAX_VALUE) {
                    this.edges1.add(i);
                    this.edges2.add(j);
                }
            }
        }
    }

    /**
     * @brief Devuelve el atributo distances
     * @return int[] distancia
     */
    public int[] getDistances() {
        return this.distances;
    }

    /**
     * @brief Devuelve el atributo value
     * @return int value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * @brief Resuelve mediante BellmanFord, guarda el resultado en value
     * @return void
     */
    public void solve() {
        int numEdges = this.edges1.size();
        int[] predecessor = new int[this.nodes];
        this.distances = new int[this.nodes];
        for (int i = 0; i < this.nodes; i++) {
            this.distances[i] = BellmanFord.INFINITY;
            predecessor[i] = -1;
        }
        this.distances[0] = 0;
        for (int i = 0; i < (this.nodes - 1); i++) {
            for (int j = 0; j < numEdges; j++) {
                int u = this.edges1.get(j);
                int v = this.edges2.get(j);
                if (this.distances[v] > this.distances[u] + this.distanceMatrix[u][v]) {
                    this.distances[v] = this.distances[u] + this.distanceMatrix[u][v];
                    predecessor[v] = u;
                }
            }
        }
        this.path.add(this.nodes - 1);
        int pred = predecessor[this.nodes - 1];
        while (pred != -1) {
            this.path.add(pred);
            pred = predecessor[pred];
        }
        this.value = -this.distances[this.nodes - 1];
    }
}
