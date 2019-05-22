public class Solution {
    HashMap<Character, Integer> map = new HashMap<>();
    ArrayList<Character> list = new ArrayList<>();   //用于保存每一个新加入的字符,且ArrayList为Character型
    
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
        list.add(ch);
    }
    
    public char FirstAppearingOnce() {
        char c  = '#';
        for (char key : list) {
            if (map.get(key) == 1) {
                c = key;
                break;
            }
        }
        return c;
    }
}
//Model 2
import java.util.LinkedHashMap;
import java.util.Map;
 
public class Solution {
    private Map<Character, Integer> map = new LinkedHashMap<>();
     
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
    }
     
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Map.Entry<Character, Integer> set : map.entrySet()) {
            if (set.getValue() == 1) {
                return set.getKey();
            }
        }
        return '#';
    }
}
