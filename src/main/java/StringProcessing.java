import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

public class StringProcessing {

    public List<String> strings = new ArrayList<>() {{
        add("asdada");
        add("aWEqwqe");
        add("as");
        add("RREe");
    }};

    public String processing(List<String> values, int maxDuplicates) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(String str: values){
            map.put(str, stringDuplicates(str));
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if (entry.getValue() <= maxDuplicates){
                list.add(entry.getKey());
            }
        }
        String s = list.stream()
                .max(Comparator.comparingInt(String::length)).get();

        for(int i = 0; i < values.size(); i++){
            if (values.get(i)==s){
                if (i == 0){
                    s = values.get(i+1);
                } else if (i == values.size()){
                    s = values.get(i-1);
                } else {
                    s = values.get(i-1).concat(" " + values.get(i+1));
                }
            }
        }
        return s;
    }


    public int stringDuplicates(String string) {
        int currentValueDuplicates = 0;
        char[] chars = string.toCharArray();
        Set<Character> set = new HashSet<>();
        List<Character> list = new ArrayList<>();
        for (char aChar : chars) {
            list.add(aChar);
        }
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) == list.get(j) && !set.contains(list.get(i))) {
                    set.add(list.get(i));
                    currentValueDuplicates++;
                }
            }
        }
//        System.out.println(list);
        return currentValueDuplicates;
    }
}
