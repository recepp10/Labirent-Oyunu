package labirent;

import java.util.ArrayList;
class Path {

    int u;
    int v;

    public Path(int u, int v) {
        this.u = u;
        this.v = v;
    }

    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

}
public class Gargamel extends Dusman {

  public static ArrayList<Path> yol = new ArrayList<Path>();
    public static ArrayList<Integer> yol2 = new ArrayList<Integer>();
   
    private int kaynak = 3;
    private int hedef = 128;

    public int getKaynak() {
        return kaynak;
    }

    public void setKaynak(int kaynak) {
        this.kaynak = kaynak;
    }

    public int getHedef() {
        return hedef;
    }  

    public void setHedef(int hedef) {
        this.hedef = hedef;
    }

    public static void dijkstra(int[][] buyukMatris, int sourceVertex, int hedef) {
        int gecici = 0;

        int vertexCount = buyukMatris.length;
        boolean[] visitedVertex = new boolean[vertexCount];
        int[] distance = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[sourceVertex] = 0;

        for (int i = 0; i < vertexCount; i++) {

            int u = findMinDistance(distance, visitedVertex);

            visitedVertex[u] = true;

            for (int v = 0; v < vertexCount; v++) {

                if (!visitedVertex[v] && buyukMatris[u][v] != 0 && (distance[u] + buyukMatris[u][v] < distance[v])) {

                    distance[v] = distance[u] + buyukMatris[u][v];

                    yol.add(new Path(u, v));

                }

            }

        }
        yol2.add(hedef);
        for (int i = yol.size() - 1; i >= 0; i--) {

            if (yol.get(i).v == hedef) {

                gecici = yol.get(i).u;
                hedef = gecici;
                yol2.add(yol.get(i).u);
                if (hedef == sourceVertex) {
                    break;
                }

            }
        }


    }

    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {

        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {

            if (!visitedVertex[i] && distance[i] <= minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;

            }

        }
        return minDistanceVertex;
    }

 

    public Gargamel() {

    }

    public static ArrayList<Path> getYol() {
        return yol;
    }

    public static void setYol(ArrayList<Path> yol) {
        Gargamel.yol = yol;
    }

    public static ArrayList<Integer> getYol2() {
        return yol2;
    }

    public static void setYol2(ArrayList<Integer> yol2) {
        Gargamel.yol2 = yol2;
    }

    public ArrayList<String> getCumleler() {
        return cumleler;
    }

    public void setCumleler(ArrayList<String> cumleler) {
        this.cumleler = cumleler;
    }

    public ArrayList<String> getNumaralar() {
        return numaralar;
    }

    public void setNumaralar(ArrayList<String> numaralar) {
        this.numaralar = numaralar;
    }

    public static int[][] getMaze() {
        return maze;
    }

    public static void setMaze(int[][] maze) {
        Karakter.maze = maze;
    }

    public void yoluCiz(int x, int y) {
        
        
        Karakter karakter = new Karakter();

        int sayac = 0;
        int[][] buyukMatris = new int[143][143];

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                buyukMatris[sayac][0] = karakter.maze[i][j];
                sayac++;
            }

        }

        for (int i = 0; i < sayac; i++) {

            if ((i - 1) % 13 != 12 && i - 1 >= 0) {
                if (buyukMatris[i - 1][0] == 1) {
                    buyukMatris[i][i - 1] = 1;
                }
            }
            if ((i + 1) % 13 != 0) {
                if (buyukMatris[i + 1][0] == 1) {
                    buyukMatris[i][i + 1] = 1;
                }
            }
            if ((i + 13) <= 142) {
                if (buyukMatris[i + 13][0] == 1) {
                    buyukMatris[i][i + 13] = 1;
                }
            }
            if ((i - 13) >= 0) {
                if (buyukMatris[i - 13][0] == 1) {
                    buyukMatris[i][i - 13] = 1;
                }
            }

        }
        for (int i = 0; i < sayac; i++) {
            buyukMatris[i][0] = 0;

        }
        kaynak = x;
        hedef = y;

        dijkstra(buyukMatris,kaynak, hedef);
    }
}
