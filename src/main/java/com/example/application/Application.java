package com.example.application;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.aot.hint.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportRuntimeHints;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets and some
 * desktop browsers.
 *
 */
@SpringBootApplication
@Theme(value = "hilla-aot-demo")
@ImportRuntimeHints(Application.Hints.class)
public class Application extends SpringBootServletInitializer implements AppShellConfigurator {

	static class Hints implements RuntimeHintsRegistrar {

		@Override
		public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
			var reflections = hints.reflection();
			var memberCategories = MemberCategory.values();
			reflections.registerType(
					TypeReference.of("dev.hilla.push.PushConfigurer.EmbeddedAtmosphereInitializer.class"),
					memberCategories);
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
