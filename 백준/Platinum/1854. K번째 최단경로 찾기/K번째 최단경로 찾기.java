import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K;
    static List<Edge>[] edges;
    static PriorityQueue<Integer>[] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N + 1];
        dist = new PriorityQueue[N + 1];

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
            dist[i] = new PriorityQueue<>(Comparator.reverseOrder());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            edges[start].add(new Edge(to, dist));
        }

        dijkstra();

        for (int i = 1; i <= N; i++) {
            if (dist[i].size() < K) sb.append("-1\n");
            else sb.append(dist[i].peek()).append("\n");
        }

        System.out.print(sb);

    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        dist[1].add(0);

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.pos].size() == K && cur.dist > dist[cur.pos].peek()) {
                continue;
            }

            for (Edge next : edges[cur.pos]) {
                int newDist = cur.dist + next.dist;
                Node n = new Node(next.to, newDist);

                if (dist[next.to].size() < K ) {
                    dist[next.to].add(newDist);
                    pq.add(n);
                } else if (dist[next.to].peek() > newDist) {
                    dist[next.to].poll();
                    dist[next.to].add(newDist);
                    pq.add(n);
                }
            }

        }

    }
}

class Node implements Comparable<Node> {
    int pos;
    int dist;

    public Node(int pos, int dist) {
        this.pos = pos;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node n) {
        return this.dist - n.dist;
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