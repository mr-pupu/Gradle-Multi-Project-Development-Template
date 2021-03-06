package com.github.vkuzel.gmpdt.app.core_module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
@ComponentScan("com.github.vkuzel.gmpdt.app")
public class CoreModuleApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CoreModuleApplication.class);

    @Autowired
    private List<Speaker> allSpeakersInProject;

    @Autowired
    private ResourceManager dependencyManager;

    public static void main(String[] args) {
        SpringApplication.run(CoreModuleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Speakers introduction: ");
        allSpeakersInProject.forEach(speaker -> log.info("I am {}", speaker.getName()));

        List<Resource> resources = dependencyManager.findIndependentProjectResourcesFirst("res.txt");
        resources.forEach(resource -> {
            try {
                log.info("Resource in {}", resource.getURL());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        });
    }
}
