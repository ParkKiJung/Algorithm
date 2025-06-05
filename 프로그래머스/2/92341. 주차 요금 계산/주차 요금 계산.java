import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<Integer, Integer> info = new HashMap<>(); // 차량 번호 및 누적 시간
        Map<Integer, Integer> parking = new HashMap<>(); // 들어간 차량번호 및 누적 시간
        List<Car> list = new ArrayList<>();
        int dTime = fees[0];
        int dFee = fees[1];
        int uTime = fees[2];
        int uFee = fees[3];
        
        for (String record : records) {
            String[] arr = record.split(" ");
            String time = arr[0];
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3, 5));
            int second = 60 * hour + minute;
            
            int num = Integer.parseInt(arr[1]);
            String cmd = arr[2];
            
            if (cmd.equals("IN")) {
                parking.put(num, second);
            } else {
                int diff = second - parking.get(num);
                parking.remove(num);
                int sum = info.getOrDefault(num, 0) + diff;
                info.put(num, sum);
                
            }
            
        }
        
        int lTime = 60 * 23 + 59;
        // 들어가고 안 나온 차들은 23:59 출차로 간주
        for (Integer key : parking.keySet()) {
            int diff = lTime - parking.get(key);
            int sum = info.getOrDefault(key, 0) + diff;
            info.put(key, sum);
        }
        
        for (Integer key : info.keySet()) {
            int fee = dFee;
            double oTime = info.get(key) - dTime;
            if (oTime < 0) oTime = 0;
            fee += Math.ceil(oTime / uTime) * uFee;
            list.add(new Car(key, fee));
        }
        
        Collections.sort(list);
        
        answer = new int[list.size()];
        int idx = 0;
        for (Car car : list) {
            answer[idx++] = car.fee;
        }
        
        
        return answer;
        
    }
}

class Car implements Comparable<Car> {
    int num; // 차량번호
    int fee; // 
    
    Car(int num, int fee) {
        this.num = num;
        this.fee = fee;
    }
    
    @Override
    public int compareTo(Car c) {
        return this.num - c.num;
    }
}