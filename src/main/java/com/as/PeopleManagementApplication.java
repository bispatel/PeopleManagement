package com.as;

import java.util.Arrays;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PeopleManagementApplication {
	 private int maxUploadSizeInMb = 10 * 1024 * 1024; // 10 MB

	public static void main(String[] args) {
		SpringApplication.run(PeopleManagementApplication.class, args);
	}
	
	 @Bean
	    public CommandLineRunner run(ApplicationContext appContext) {
	        return args -> {

	            String[] beans = appContext.getBeanDefinitionNames();
	            Arrays.stream(beans).sorted().forEach(System.out::println);

	        };
	    }

	 //Tomcat large file upload connection reset
   @Bean
   public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {

       TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();

       tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
           if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
               //-1 means unlimited
               ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
           }
       });

       return tomcat;

   }
}
