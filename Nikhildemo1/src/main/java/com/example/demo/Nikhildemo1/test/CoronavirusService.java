package com.example.demo.Nikhildemo1.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class CoronavirusService {
	private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";


	@PostConstruct
	public void fetchVirusData() throws IOException, InterruptedException {

		
		  HttpClient client=HttpClient.newHttpClient(); HttpRequest
		  request=HttpRequest.newBuilder().uri(URI.create(VIRUS_DATA_URL)).build();
		  HttpResponse<String> httpResponse=client.send(request,
		  HttpResponse.BodyHandlers.ofString()); String s=httpResponse.body();
		  StringReader csvBodyReader=new StringReader(httpResponse.body());
		  
		  
		 

		
		  Scanner sc = new Scanner(new File("C:\\Users\\HP\\Desktop\\out1text.csv"));
		  
		  sc.useDelimiter(","); 
		  while (sc.hasNext())
		  { System.out.print(sc.next());
		  //find and returns
		  
		  } 
		  sc.close();
		 
		// closes the scanner

		// Iterable<CSVRecord>
		// records=(CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader));
		/*
		 * String s=httpResponse.body();
		 * 
		 * File file1=new File("out.text");
		 * 
		 * FileWriter fw=new FileWriter(file1); PrintWriter pw=new PrintWriter(fw);
		 * 
		 * for(int i=0;i<s.length();i++) { pw.print(s.charAt(i)); } pw.close();
		 */

		// System.out.println(s);
		
		  File file1=new File("out1text");
		  
		  FileWriter fw=new FileWriter(file1); PrintWriter pw=new PrintWriter(fw);
		  
		 for(int i=0;i<s.length();i++) { pw.print(s.charAt(i)); } pw.close();
		 

	}

}
