package segerfast.philip.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SelectionPrompt<T> {

    private final String promptText;
    private final List<T> values = new ArrayList<>();
    private final List<String> descriptions = new ArrayList<>();

    public SelectionPrompt(String promptText) {
        this.promptText = promptText;
    }

    public void add(T item, String description) {
        values.add(item);
        descriptions.add(description);
    }

    public T prompt() {
        if(descriptions.isEmpty())
            throw new NullPointerException("The SelectionPrompt doesn't have any elements.");

        System.out.println(promptText);
        for(int i = 0; i < descriptions.size(); i++) {
            System.out.printf("%d: %s%n", i+1, descriptions.get(i));
        }
        int selectedIndex = Utils.getIntInput(1, descriptions.size()) - 1;

        return values.get(selectedIndex);
    }

}
