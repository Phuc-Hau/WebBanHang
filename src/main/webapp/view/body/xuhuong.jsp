<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<div style="margin-top: 10px;">
	<div class="row"
		style="background: #FCDDEF; padding: 12px; border-bottom: 1px solid rgb(244, 244, 244); display: flex;">
		<img src="/image/ico_dealhot.png" alt=""> <span
			style="font-size: 17px; font-weight: bold;">Xu Hướng Mua Sắp</span>
	</div>
	<div class="row"
		style="min-height: 50px; background: white;">

	<c:forEach var="item" items="${product}">
		<div class="hotsp col-sm-2" >
			<div class="">
				<a href="/product/sanpham/${item.id}"> <!-- anh -->
					<div>
						<img style="margin-top: 3px;width: 175px;" src="/file/AnhWebBanHang/${item.imgs.get(0).image}"
							class="col-sm-12" alt="">
					</div> <!-- Title -->
					<h2>
						<a class="sachxuhuong">${item.name}</a>
					</h2> <!-- Gia -->
					<div class="xuhuong">
						<span style="color: red;">${item.price}<span
							style="font-size: 16px;">đ</span></span> <span
							style="text-align: right; font-size: 11px;">đã bán 1k2</span>
					</div>
				</a>
			</div>
		</div>
		</c:forEach>

	</div>

	<div class="xemthem">
		<a style="margin: 0 auto; margin-bottom: 15px;"
			href="./xuhuongsp.html" class="btn btn-danger">Xem Thêm</a>
	</div>
	<div style="background-color: white; margin: 0 -15px;"
		class="controllxuhuong">
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link"
					href="#">Previous</a></li>

				<li class="page-item  {{getPageCount==$index+1}}"
					>
					<a class="page-link" href="#">
						{{gu}}{{$index+1}} </a>
				</li>

				<li class="page-item"><a class="page-link"
					href="#">Next</a></li>
			</ul>
		</nav>
	</div>

</div>