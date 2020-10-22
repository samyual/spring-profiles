package ru.samyual.profiles.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.samyual.profiles.domains.Cite;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Configuration
public class Config {

    @Value("${filename}")
    private String filename;

    @Bean
    public Random getRandom() {
        return new Random();
    }

    @Bean
    public List<String> getCites() {
        List<String> cites = new ArrayList<>();
        try (LineNumberReader reader = new LineNumberReader(new FileReader(filename))) {
            for (int i = 0; i < 10; i++) {
                cites.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.unmodifiableList(cites);
    }

    @Bean
    @Scope("prototype")
    public Cite getCite(Random random, List<String> cites) {
        return new Cite(random, cites);
    }
}
