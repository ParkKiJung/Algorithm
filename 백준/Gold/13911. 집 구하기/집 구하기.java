import java.util.*;
import java.io.*;

public class Main {
    static int nodeNum, macNum, starNum, macLimit, startLimit;
    static int[] info;
    static List<Edge>[] edges;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nodeNum = Integer.parseInt(st.nextToken());


        int edgeNum = Integer.parseInt(st.nextToken());
        edges = new ArrayList[nodeNum + 1];
        info = new int[nodeNum + 1];

        for (int i = 1; i <= nodeNum; i++) {
            edges[i] = new ArrayList<>();
        }


        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            edges[a].add(new Edge(b, dist));
            edges[b].add(new Edge(a, dist));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        macNum = Integer.parseInt(st.nextToken());
        macLimit = Integer.parseInt(st.nextToken());

        int answer = Integer.MAX_VALUE;
        int[][] distance = new int[2][nodeNum + 1];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < macNum; i++) {
            int macPos = Integer.parseInt(st.nextToken());
            info[macPos] = 1;
            distance[0][macPos] = 0;
            pq.add(new Node(macPos, 1, 0));
        }

        st = new StringTokenizer(br.readLine());
        starNum = Integer.parseInt(st.nextToken());
        startLimit = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < starNum; i++) {
            int starPos = Integer.parseInt(st.nextToken());
            info[starPos] = 2;
            distance[1][starPos] = 0;
            pq.add(new Node(starPos, 2, 0));
        }



        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int pos = cur.pos;
            int kind = cur.kind;
            int dist = cur.dist;

            if (dist > answer || dist > distance[kind - 1][pos]) continue;
            if (distance[0][pos] != Integer.MAX_VALUE && distance[1][pos] != Integer.MAX_VALUE && info[pos] == 0) {
                answer = Math.min(answer, distance[0][pos] + distance[1][pos]);
            }


            for (Edge next : edges[pos]) {
                int newDist = dist + next.dist;
                int limit;
                if (kind == 1) limit = macLimit;
                else limit = startLimit;
                if (newDist > limit || newDist >= answer) continue;
                if (distance[kind - 1][next.to] > newDist) {
                    distance[kind - 1][next.to] = newDist;
                    pq.add(new Node(next.to, kind, newDist));
                }


            }


        }

        if (answer == Integer.MAX_VALUE) answer = - 1;
        System.out.println(answer);
    }
}

class Node implements Comparable<Node> {
    int pos;
    int kind;
    int dist;

    @Override
    public int compareTo(Node n) {
        return this.dist - n.dist;
    }

    public Node(int pos, int kind, int dist) {
        this.pos = pos;
        this.kind = kind;
        this.dist = dist;
    }
}

class Edge {
    int to;
    int dist;

    public Edge(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }
}