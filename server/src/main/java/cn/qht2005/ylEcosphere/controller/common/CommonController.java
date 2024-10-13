package cn.qht2005.ylEcosphere.controller.common;

import cn.qht2005.ylEcosphere.constant.MessageConstant;
import cn.qht2005.ylEcosphere.exception.BaseException;
import cn.qht2005.ylEcosphere.result.Result;
import cn.qht2005.ylEcosphere.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * 通用接口
 */
@RestController
@RequestMapping("/admin/common")
@Slf4j
public class CommonController {
	@Autowired
	private AliOssUtil aliOssUtil;
	/**
	 *  文件上传
	 */
	@PostMapping("/upload")
	public Result<String> upload(MultipartFile file) {
		log.info("文件上传:{}", file);
		// 获取原始文件名
		String originalFilename = file.getOriginalFilename();
		// 获取文件后缀
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		// 利用UUID拼接文件名
		String fileName = UUID.randomUUID() + suffix;
		String url = null;
		try {
			// 上传文件
			url = aliOssUtil.upload(file.getBytes(), fileName);
		} catch (Exception e) {
			log.error("文件上传失败:{}", e.toString());
			throw new BaseException(MessageConstant.FILE_UPLOAD_FAILED);
		}
		return Result.success(url);
	}

}
