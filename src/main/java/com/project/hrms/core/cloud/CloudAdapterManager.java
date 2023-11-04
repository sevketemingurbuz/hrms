package com.project.hrms.core.cloud;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.project.hrms.core.utilities.results.DataResult;
import com.project.hrms.core.utilities.results.ErrorDataResult;
import com.project.hrms.core.utilities.results.SuccessDataResult;

@Component
@Service
public class CloudAdapterManager implements CloudAdapterService {

	private final Cloudinary cloudinary;

	
	public CloudAdapterManager() {  //Parametresiz constructor olduğuna dikkat et
		
		
		Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("cloud_name","dzoe8fwkq" );
        valuesMap.put("api_key", "657476774255188" );
        valuesMap.put("api_secret","EKa9_p-DVT9B1WMMBcmKMAt0q6s" );
        cloudinary = new Cloudinary(valuesMap);
        
	}

	
	
	@Override
	public DataResult<Map<String, String>> uploadPhoto(MultipartFile multipartFile) {
		
		File file;
		
		try {
			file = convert(multipartFile);
			
			
			@SuppressWarnings("unchecked")
			Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			file.delete();
			
			return new SuccessDataResult<>(result);
		} catch (IOException e) {
			
			e.printStackTrace();
			
			return new ErrorDataResult<>("File can't upload"); //error sonucunu cathch bloğuna çektik yukarıda zaten return olduğundan kızmadı.
		}
		
		
		
	}
	
	
	
	private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }
}
