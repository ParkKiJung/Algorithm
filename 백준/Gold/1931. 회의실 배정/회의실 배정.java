import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Meeting(start, end));

        }

        int time = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Meeting meeting = pq.poll();
            if (meeting.start >= time) {
                cnt++;
                time = meeting.end;
            }
        }

        System.out.println(cnt);
    }
}

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting m) {
        // 회의 끝나는 시간이 같다면 빨리 시작하는거 선택
        if (this.end == m.end) return this.start - m.start;
        return this.end - m.end;
    }
}