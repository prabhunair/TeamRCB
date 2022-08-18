package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Payload {
	
	public static String jsonPayload() throws Exception
	{		
		  //Fetch the json file from the project path	
		  byte[] fileContent = Files.readAllBytes(Paths.get("TeamRCB.json"));

	      //convert byte array to string
	      String body = new String(fileContent);
	      
	      return body;

	}
	

}
