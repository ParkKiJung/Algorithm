import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static Pos[] poses;
    static int[] parent;
    static List<Edge> edges = new ArrayList<>();
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        parent = new int[N];
        poses = new Pos[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            st = new StringTokenizer(br.readLine());
            poses[i] = new Pos(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        for (int i = 0; i < N - 1; i++) {
            Pos p1 = poses[i];
            for (int j = i + 1; j < N; j++) {
                Pos p2 = poses[j];
                edges.add(new Edge(i, j, getDist(p1.x, p1.y, p2.x, p2.y)));
            }
        }

        System.out.printf("%.2f", MST());
    }

    static double MST() {
        Collections.sort(edges);
        double sum = 0;
        int selectedEdges = 0;
        for (Edge edge : edges) {
            int a = edge.a;
            int b = edge.b;
            int aRoot = find(a);
            int bRoot = find(b);

            if (aRoot != bRoot) {
                union(aRoot, bRoot);
                selectedEdges++;
                sum += edge.dist;
                if (selectedEdges == N - 1) return sum;
            }

        }

        return sum;
    }

    static double getDist(double x1, double y1, double x2, double y2) {
        double dist1 = Math.pow(x1 - x2, 2);
        double dist2 = Math.pow(y1 - y2, 2);
        return Math.sqrt(dist1 + dist2);
    }
    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) parent[aRoot] = bRoot;
    }
}

class Pos {
    double x;
    double y;

    public Pos(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge>{
    int a;
    int b;
    double dist;

    public Edge(int a, int b, double dist) {
        this.a = a;
        this.b = b;
        this.dist = dist;
    }

    @Override
    public int compareTo(Edge e) {
        return Double.compare(this.dist, e.dist);
    }
}