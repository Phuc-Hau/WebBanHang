<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>Shop cart</title>

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>


<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" />
<!-- Google Fonts Roboto -->

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" />
<!-- MDB -->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

	<!-- CSS -->
<link rel="stylesheet" href="/assets/css/sach.css">

	<style>
@media ( min-width : 1025px) {
	.h-custom {
		min-height: 130vh !important;
	}
}

.card-registration .select-input.form-control[readonly]:not([disabled])
	{
	font-size: 1rem;
	line-height: 2.15;
	padding-left: .75em;
	padding-right: .75em;
}

.card-registration .select-arrow {
	top: 13px;
}

.bg-grey {
	background-color: #eae8e8;
}

@media ( min-width : 992px) {
	.card-registration-2 .bg-grey {
		border-top-right-radius: 16px;
		border-bottom-right-radius: 16px;
	}
}

@media ( max-width : 991px) {
	.card-registration-2 .bg-grey {
		border-bottom-left-radius: 16px;
		border-bottom-right-radius: 16px;
	}
}
</style>
</head>
<body style="background: white;">

	<!-- header -->
	<jsp:include page="/view/partials/header.jsp"></jsp:include>

	<section class="h-100 h-custom" style="background-color: #d2c9ff;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12">
					<div class="card card-registration card-registration-2"
						style="border-radius: 15px;">
						<div class="card-body p-0">
							<div class="row g-0">
								<div class="col-lg-8" >
									<div class="p-5" style="height: 570px; overflow: auto;">
										<div
											class="d-flex justify-content-between align-items-center mb-5">
											<h1 class="fw-bold mb-0 text-black">Giỏ Hàng</h1>
											<h6 class="mb-0 text-muted">${amountcart} sản phẩm</h6>
										</div>
										
										<c:forEach var="item" items="${cart}">
										<hr class="my-4">
										<!-- sp -->
										<form method="post" action="/account/cartpay" class="row mb-4 d-flex justify-content-between align-items-center">
											<input type="hidden" name="id" value="${item.id}">
											
											<div class="col-md-2 col-lg-2 col-xl-2">
												<img
													src="/file/AnhWebBanHang/${item.product.imgs.get(0).image}"
													class="img-fluid rounded-3" alt="Cotton T-shirt">
											</div>
											<div class="col-md-3 col-lg-3 col-xl-3">
												<h6 class="text-black">${item.product.name}</h6>
												<h6 class="text-muted mb-0">${item.product.price-item.product.price*item.product.sale} VND</h6>
											</div>
											
											<div class="col-md-3 col-lg-3 col-xl-2 d-flex">
												<button type="submit" class="btn btn-link px-2" formmethod="get" formaction="/account/cart/pre">
													<i class="fas fa-minus"></i>
												</button>

												<input id="form1" style="width: 50px" min="0" name="quantity" value="${item.quantity}"
													type="number" class="form-control form-control-sm" />

												<button type="submit" class="btn btn-link px-2" formmethod="get" formaction="/account/cart/plus">
													<i class="fas fa-plus"></i>
												</button>
												
											</div>
											<div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
												<h6 class="mb-0">${item.quantity*(item.product.price-(item.product.price*item.product.sale)) } VND</h6>
											</div>
											<div class="col-md-1 col-lg-1 col-xl-1 text-end">
												<button style="border: none; background: white;" type="submit" formaction="/account/cart/delete" class="text-muted">
													<i class="fas fa-times"></i>
												</button>
											</div>
										</form>
										
										</c:forEach>
									</div>
									<div style="margin-left: 45px; margin-bottom: 20px;" class="pt-5">
											<h6 class="mb-0">
												<a href="/product/index" class="text-body"><i
													class="fas fa-long-arrow-alt-left me-2"></i>Quay lại shop</a>
											</h6>
									</div>
								</div>
								<form:form method="post" action="/account/cart/newpay" class="col-lg-4 bg-grey">
									<div class="p-5">
										<h3 class="fw-bold mb-5 mt-2 pt-1">Tổng Đơn Hàng</h3>
										<hr class="my-4">

										<div class="d-flex justify-content-between mb-4">
											<h5 class="text-uppercase">${amountsum} sản phẩm</h5>
											<h5>${pricesum } VND</h5>
										</div>
										
										<div class="d-flex justify-content-between mb-4">
											<h5 class="text-uppercase">Phí giao hàng</h5>
											<h5>20000 VND</h5>
										</div>


										
										<h5 class="text-uppercase mb-3">Mã giảm giá</h5>

										<div class="mb-5">
											<div class="form-outline">
												<input type="text" id="form3Examplea2"
													class="form-control form-control-lg" /> <label
													class="form-label" for="form3Examplea2">Nhập mã
													giảm giá</label>
											</div>
										</div>

										<hr class="my-4">

										<div class="d-flex justify-content-between mb-5">
											<h5 class="text-uppercase">Tổng giá</h5>
											<h5>${pricesum +20.000} VND</h5>
										</div>

										<button type="submit"   class="btn btn-dark btn-block btn-lg"
											data-mdb-ripple-color="dark">Đặt Hàng</button>

									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- footer -->
	<jsp:include page="/view/partials/footer.jsp"></jsp:include>



</body>
</html>