package com.webbanhang.service;

import java.io.File;

import com.webbanhang.jpa.model.Fluctuation;
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
	 * Tính tỉ lệ
	 * @param last truyền giá trị trước
	 * @param next truyền giá trị sau
	 * @return Fluctuation
	 */
	Fluctuation fluctuation(float last, float next);
	
}
