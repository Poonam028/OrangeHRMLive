import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	List<HashMap<String, String>> getJsonDataToHashMap() throws IOException
	{
		//reading the Json to string 
	String JsonContent=	FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//java//Website//data//PurchaseOrder.Json"), StandardCharsets.UTF_8);
	
	//Convert String content to hashmap
	ObjectMapper mapper = new ObjectMapper();
	
	//readvalue method helps to convert string content to hashmap
	List<HashMap<String, String>>data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>(){
	});
	return data;
	}
}
