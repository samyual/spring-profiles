package ru.samyual.profiles.domains;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FileProcessor implements CommandLineRunner {

    private final ApplicationContext context;

    public FileProcessor(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) {
        for (int i = 0; i < 10; i++) {
            final Cite cite = context.getBean(Cite.class);
            System.out.println(cite.getLineNumber() + " - " + cite.getText());
        }
    }
}
