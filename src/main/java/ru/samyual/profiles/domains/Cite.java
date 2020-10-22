package ru.samyual.profiles.domains;

import java.util.List;
import java.util.Random;

public class Cite {

    private final String text;
    private final int lineNumber;

    public Cite(Random random, List<String> cites) {
        lineNumber = random.nextInt(10);
        text = cites.get(lineNumber);
    }

    public String getText() {
        return text;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}
