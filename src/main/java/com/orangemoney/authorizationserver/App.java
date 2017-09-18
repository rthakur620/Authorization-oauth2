package com.orangemoney.authorizationserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner
{
	
	
	public void run(String... args) throws Exception {
		
		 System.out.println( "Hello World!" );
	}
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
       
    }
}
