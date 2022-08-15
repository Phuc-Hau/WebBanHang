<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<div style="margin-top: 10px; position: relative;">
	<div class="row"
		style="background: oldlace; padding: 12px; border-bottom: 1px solid rgb(244, 244, 244); display: flex;">
		<img
			src="https://frontend.tikicdn.com/_desktop-next/static/img/giasoc.svg"
			alt="flash deal"> <img width="21"
			src="https://frontend.tikicdn.com/_desktop-next/static/img/dealFlashIcon.svg"
			alt="flash deal"> <img
			src="https://frontend.tikicdn.com/_desktop-next/static/img/homnay.svg"
			alt="flash deal">
		<div class="ccRlPb" style="position: absolute; right: 10px;">
			<span>01</span>: <span class="min">32</span>: <span>09</span>
		</div>
	</div>

	<!-- Sản phẩm Sale -->
	<div class="row items" style="min-height: 50px; background: white;">

		<c:forEach var="item" items="${product}">
			<div class="col-sm-3 hotsp">
				<a class="asale" href="/product/sale/${item.id}">

					<div class="sp">
						<!-- anh -->
						<div>
							<img style="margin-top: 3px;" src="/file/AnhWebBanHang/${item.imgs.get(0).image}" class="col-sm-12"
								alt="">
						</div>
						<!-- Title -->
						<h2>
							<span class="sachtitle">${item.name}</span>
						</h2>

						<!-- Gia -->
						<div class="salegia">
							<span
								style="color: rgba(0, 0, 0, .13); font-size: 16px; text-decoration: line-through;">${item.price}đ</span>
							<span style="color: red;">${item.price-item.price*item.sale}  <span
								style="margin-left: -5px; font-size: 16px;">đ</span>
							</span> <span class="DTL">${item.sale*100}% </span>
						</div>
						<!-- Thanh sale -->
						<div class="sale-item__lower-wrapper">
							<div class="sale-item__lower-left">
								<div class="sale-progress-bar">
									<div class="sale-progress-bar__text">Đã bán price</div>
									<div class="sale-progress-bar__complement-wrapper">
										<!-- Thay đổi -->
										<div class="sale-progress-bar__complement-sizer"
											style="width: 50%;" id="thanhgia">
											<div class="sale-progress-bar__complement-color"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</a>
			</div>
		</c:forEach>

	</div>
</div>
