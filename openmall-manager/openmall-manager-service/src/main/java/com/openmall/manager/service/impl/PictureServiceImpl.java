package com.openmall.manager.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.openmall.common.pojo.FtpBean;
import com.openmall.common.utils.FtpUtil;
import com.openmall.common.utils.IDUtils;
import com.openmall.manager.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService {
	@Autowired
	FtpBean ftpBean;

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map uploadPicture(MultipartFile uploadFile) {
		Map resultMap = new HashMap<>();
		try {
			//生成一个新的文件名
			//取原始文件名
			String oldName = uploadFile.getOriginalFilename();
			//生成新文件名
			//UUID.randomUUID();
			String newName = IDUtils.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			//图片上传
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile(
					ftpBean.getIp(), 
					ftpBean.getPort(), 
					ftpBean.getUsername(),
					ftpBean.getPassword(), 
					ftpBean.getBasePath(), imagePath, newName, uploadFile.getInputStream());
			//返回结果
			if(!result) {
				resultMap.put("error", 1);
				resultMap.put("message", "文件上传失败");
				return resultMap;
			}
			resultMap.put("error", 0);
			resultMap.put("url", ftpBean.getImagerUrl() + imagePath + "/" + newName);
			return resultMap;
			
		} catch (Exception e) {
			resultMap.put("error", 1);
			resultMap.put("message", "文件上传发生异常");
			return resultMap;
		}
	}

}
