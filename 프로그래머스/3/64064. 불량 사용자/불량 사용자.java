import java.util.*;

class Solution {
    
    // user_id 길이 8이하
    // banned_id 길이 8이하
    // 조합으로...?
    static String[] users;
    static String[] bans;
    static boolean[] used;
    static Set<Set<String>> result = new HashSet<>();
    
    
    public int solution(String[] user_id, String[] banned_id) {
        users =  user_id;
        bans = banned_id;
        used = new boolean[users.length];
        
        comb(0, new ArrayList<>());
        
        return result.size();
        
    }
    
    
    
    static void comb(int depth, List<String> selected) {
        if (depth == bans.length) {
            if (isMatch(selected)) {
                result.add(new HashSet<>(selected));
            }
            
            return;
        }
        
        for (int i = 0; i < users.length; i++) {
            if (!used[i]) {
                used[i] = true;
                selected.add(users[i]);
                comb(depth + 1, selected);
                used[i] = false;
                selected.remove(selected.size() - 1);
            }
        }
          
    }
    
    static boolean isMatch(List<String> selected) {
        for (int i = 0; i < bans.length; i++) {
            if (!isSame(bans[i], selected.get(i))) return false;
        }
        return true;
    }
    
    static boolean isSame(String ban, String user) {
        if (ban.length() != user.length()) return false;
        for (int i = 0; i < ban.length(); i++) {
            if (ban.charAt(i) != '*' && ban.charAt(i) != user.charAt(i)) return false;
        }
        
        return true;
        
    }
        
    
}