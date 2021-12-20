import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

public class StringProcessing {

    public List<String> strings = new ArrayList<>() {{
        add("asdada");
        add("aWEqwqe");
        add("as");
        add("RREe");
    }};
    char[] chars = strings.get(0).toCharArray();

    public String processing(List<String> values, int maxDuplicates) {
        Map<String, Integer> map = new HashMap<>();
        for(String str: values){
            map.put(str, stringDuplicates(str));
        }
        map.values().stream()
                .filter((currentDuplicates)-> currentDuplicates<=maxDuplicates);

        return null;
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
        System.out.println(list);
        return currentValueDuplicates;
    }
}
