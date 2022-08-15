package com.webbanhang.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface ConvenientService {
	/**
	 * đổi trạng thái email sang trạng thái ẩn
	 * @param star email cần chuyển
	 * @return email đã ẩn
	 */
	String emailToStar(String star);

	/**
	 * lấy một số bất kỳ với 6 chữ số
	 * @return trả về số bất kỳ
	 */
	String ranDomCapCha();

	/**
	 * lưu file
	 * @param file truyền file
	 * @param path truyền đường dẫn
	 * @return null
	 */
	File saveFile(MultipartFile file, String path);
	
}
