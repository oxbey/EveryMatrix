import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

public class StringProcessing {

    public List<String> strings = new ArrayList<>() {{
        add("as");
        add("RREe");
        add("aWEqwqe");
        add("dGTygy");
        add("asdadaxxwert");
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
        String maxLengthString = list.stream()
                .max(Comparator.comparingInt(String::length)).get();

        String concatString = null;
        System.out.println(maxLengthString);
        for(int i = 0; i < values.size(); i++){
            if (values.get(i)==maxLengthString){
                if (i == 0){
                    concatString = values.get(i + 1);
                } else if (i == values.size()-1) {
                    concatString = values.get(i - 1);
                } else {
                    concatString = values.get(i-1).concat(values.get(i+1));
                }
            }
        }
        return concatString;
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
        return currentValueDuplicates;
    }

    public List<String> autoGeneration(int size){
        List<String> stringList = new ArrayList<>(){{
            for (int i = 0; i < size; i++) {
                add(RandomStringUtils.randomAlphabetic(2,20));
            }
        }};
        return stringList;
    }
}
