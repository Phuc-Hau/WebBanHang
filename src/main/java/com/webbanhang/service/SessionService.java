package com.webbanhang.service;

public interface SessionService {

	/**
	 * Đọc giá trị của attribute trong session
	 *
	 * @param name tên attribute
	 * @return giá trị đọc được hoặc null nếu không tồn tại
	 */
	<T> T get(String name) ;

	/**
	 * Thay đổi hoặc tạo mới attribute trong session
	 *
	 * @param name  tên attribute
	 * @param value giá trị attribute
	 */
	void set(String name, Object value) ;

	/**
	 * Xóa attribute trong session
	 *
	 * @param name tên attribute cần xóa
	 */
	void remove(String name) ;

}
