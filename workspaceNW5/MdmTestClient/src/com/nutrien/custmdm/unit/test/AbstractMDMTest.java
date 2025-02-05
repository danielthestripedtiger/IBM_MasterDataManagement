package com.nutrien.custmdm.unit.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.xml.bind.DatatypeConverter;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.BeforeClass;

public abstract class AbstractMDMTest {
	
	private static final String ENV_PROP = "environment.properties";
	public static String fileName = "";
	static File file= null;
	static FileWriter fw = null;
	static BufferedWriter bw = null;
	
	protected static Properties envProps;
	
	@BeforeClass
	public static void loadClientOpts() {
		
//		System.out.println("@BeforeClass initializing properties");
		
		envProps = new Properties();
		InputStream input = null;

		try {

			input = AbstractMDMTest.class.getClassLoader().getResourceAsStream(ENV_PROP);
			// load a properties file
			envProps.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	
	/**
	 * This method will send JSON request via rest at a given end point
	 * 
	 * @param request
	 * @return
	 */
	protected static String sendRequestViaRest(String request) {
		String output = "";
		try {

			final String ENV = envProps.getProperty("environment");		
			String url = envProps.getProperty( ENV + ".mdm_rest_endpoint");
			String username = envProps.getProperty( ENV + ".username");
			String password = envProps.getProperty( ENV + ".password");
			String userPass = username+":"+password;
            
            String encoding = DatatypeConverter.printBase64Binary(userPass.getBytes("UTF-8"));
			
			HttpPut putRequest = new HttpPut(url);
			putRequest.addHeader("Content-Type", "application/xml");
			putRequest.addHeader("Accept", "application/xml");
			putRequest.setHeader("Authorization", "Basic " + encoding);
			
			StringEntity requestEntity = new StringEntity(request, "utf-8");
			putRequest.setEntity(requestEntity);

			HttpClient client = HttpClientBuilder.create().build();
			HttpResponse response = client.execute(putRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String respStr = "";
			while ((output = br.readLine()) != null) {
//				System.out.println(output);
				if(output != null)
					respStr += output;
			}
			
			return respStr;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	
	/**
	 * This method will send webservice requests
	 * 
	 * @param request
	 * @return
	 */
	protected static String sendRequestXML(String request) {

		final String ENV = envProps.getProperty("environment");
		String url = envProps.getProperty( ENV + ".mdm_virtual_endpoint");
		String username = envProps.getProperty( ENV + ".username");
		String password = envProps.getProperty( ENV + ".password");
		
		request = request.replace("<userName></userName>", "<userName>"+username+"</userName>");
		request = request.replace("<userPassword></userPassword>", "<userPassword>"+password+"</userPassword>");
		
		HttpPost post = new HttpPost(url);
		HttpClient client = HttpClientBuilder.create().build();
		StringBuffer result = new StringBuffer();
		try {
			StringEntity requestEntity = new StringEntity(request, "UTF-8");
			post.setEntity(requestEntity);
		    post.addHeader("SOAPAction", "");
			
		    HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(
			        new InputStreamReader(response.getEntity().getContent()));

			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			System.out.println(result.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();
	}
	
	

}
