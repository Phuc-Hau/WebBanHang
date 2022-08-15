<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<link rel="stylesheet"
	href="/assets/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="/assets/vendors/css/vendor.bundle.base.css">

<link rel="stylesheet" href="/assets/css/style.css">
<!-- End layout styles -->
<link rel="shortcut icon" href="/assets/images/favicon.ico" />
<body>
	<div class="container-scroller">

		<!-- partial -->
		<jsp:include page="/view/admin/partials/navbar.jsp"></jsp:include>

		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_sidebar.html -->
			<jsp:include page="/view/admin/partials/sidebar.jsp"></jsp:include>

			<!-- body -->
			<div class="main-panel">
				<!-- body:home.jsp -->
				<jsp:include page="/view/admin/body/listproduct.jsp"></jsp:include>
				
				<!-- partial:partials/_footer.html -->
				<jsp:include page="/view/admin/partials/footer.jsp"></jsp:include>

			</div>
		</div>
		<!-- page-body-wrapper ends -->
	</div>



	<script src="/assets/vendors/js/vendor.bundle.base.js"></script>

	<script src="/assets/vendors/chart.js/Chart.min.js"></script>
	<script src="/assets/js/jquery.cookie.js" type="text/javascript"></script>

	<script src="/assets/js/off-canvas.js"></script>
	<script src="/assets/js/hoverable-collapse.js"></script>
	<script src="/assets/js/misc.js"></script>


</body>
</html>