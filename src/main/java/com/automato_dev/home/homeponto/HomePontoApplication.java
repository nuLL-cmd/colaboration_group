package com.automato_dev.home.homeponto;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class HomePontoApplication {

	public static void main(String[] args) {

		SpringApplication springApplication = new SpringApplication(HomePontoApplication.class);
		springApplication.setBanner(new CustomBanner());
		springApplication.run(args);
	}

		/*
	 * https://stackoverflow.com/questions/44026687/show-custom-variable-in-spring-boot-banner
	 * */
	private static class CustomBanner implements Banner {
	       
		private static final String[] BANNER = {
		
			"ooooo   ooooo   .oooooo.   ooo        ooooo oooooooooooo         ooooooooo.     .oooooo.   ooooo      ooo ooooooooooooo   .oooooo.",   
			"`888'   `888'  d8P'  `Y8b  `88.       .888' `888'     `8         `888   `Y88.  d8P'  `Y8b  `888b.     `8' 8'   888   `8  d8P'  `Y8b",  
			" 888     888  888      888  888b     d'888   888                  888   .d88' 888      888  8 `88b.    8       888      888      888", 
			" 888ooooo888  888      888  8 Y88. .P  888   888oooo8             888ooo88P'  888      888  8   `88b.  8       888      888      888", 
			" 888     888  888      888  8  `888'   888   888         8888888  888         888      888  8     `88b.8       888      888      888", 
			" 888     888  `88b    d88'  8    Y     888   888       o          888         `88b    d88'  8       `888       888      `88b    d88'", 
			"o888o   o888o  `Y8bood8P'  o8o        o888o o888ooooood8         o888o         `Y8bood8P'  o8o        `8      o888o      `Y8bood8P'\n\n",                                                                                                                                                                                                                                                  
                                                                                                                                                                                                                                                                 
		};

		private static final String SPRING_BOOT = " :: VERSÂO SPRING :: ";
		private static final String ORGANIZACAO = " :: ORGANIZAÇÂO   :: ";
		private static final String PROJETO     = " :: PROJETO       :: ";
		private static final String PERFIL_AIVO = " :: PERFIL ATIVO  :: ";

		@Override
		public void printBanner(final Environment environment, final Class<?> sourceClass, final PrintStream printStream) {
			String padding = "";
			for (String line : BANNER) {
				printStream.println(line);
			}
			printStream.println(AnsiOutput.toString(AnsiColor.YELLOW, ORGANIZACAO, AnsiColor.DEFAULT, padding, AnsiStyle.FAINT,
					   environment.getProperty("app.organization")));
			printStream.println(AnsiOutput.toString(AnsiColor.YELLOW, PROJETO, AnsiColor.DEFAULT, padding, AnsiStyle.FAINT,
				   environment.getProperty("app.name")));
			printStream.println(AnsiOutput.toString(AnsiColor.YELLOW, PERFIL_AIVO, AnsiColor.DEFAULT, padding, AnsiStyle.FAINT,
					environment.getProperty("spring.profiles.active")));
			printStream.println(AnsiOutput.toString(AnsiColor.YELLOW, SPRING_BOOT, AnsiColor.DEFAULT, padding, AnsiStyle.FAINT,
					SpringBootVersion.getVersion()));
			printStream.println();
		}

	}


}
