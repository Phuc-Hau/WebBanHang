<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
body {
	overflow-x: hidden;
}
</style>
<title>Tập hóa online</title>

<!-- Angularjs -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.0/angular.min.js"></script>

<!-- Bootstrap 4 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" href="/assets/css/sach.css">

<!-- JS -->
<script src="/js/app.js"></script>

<!-- simple slick -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/kenwheeler/slick@1.8.1/slick/slick-theme.css"
	defer>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"
	defer>
<script src="/js/Slick/slick.min.js" defer></script>




<style>
.controllxuhuong {
	display: none;
}
</style>


</head>
<body ng-app="myapp" style="background-color: #efefef;">

	<!-- header -->
	<jsp:include page="/view/partials/header.jsp"></jsp:include>

	<!-- main -->
	<article>
		<div style="padding: 0px 148px;">
			<div class="row">
				<!-- slideshow-->
				<jsp:include page="/view/partials/slideshow.jsp"></jsp:include>
			</div>

			<!-- body -->
			<article>
				<!--Fash Sale  -->
				<jsp:include page="/view/body/fashsale.jsp"></jsp:include>
				<!-- Xu hướng mua sắm -->
				<jsp:include page="/view/body/xuhuong.jsp"></jsp:include>
			</article>
		</div>
	</article>

	<!-- footer -->
	<jsp:include page="/view/partials/footer.jsp"></jsp:include>


</body>

</html>