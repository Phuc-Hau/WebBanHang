<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Chi tiết sản phẩm</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="https://kit.fontawesome.com/54a9f8f1bb.js"
	crossorigin="anonymous"></script>
<!-- Google Fonts Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" />

</head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- CSS -->
<link rel="stylesheet" href="/assets/css/sach.css">

<style>
.btn-primary {
	background-color: orangered;
}

.bg-secondary {
	background-color: #d9d9d9 !important;
}

h3.line-through {
	text-decoration: line-through;
}

input[type='number'] {
	-moz-appearance: textfield;
}

input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
}
</style>


</head>
<body>
	<!-- header -->
	<jsp:include page="/view/partials/header.jsp"></jsp:include>

	<div class="container-fluid py-5">
		<div class="row px-xl-5">
			<div class="col-lg-5 pb-5">
				<div id="product-carousel" class="carousel slide"
					data-ride="carousel">
					<div class="carousel-inner border">
						<div class="carousel-item active">
							<img class="w-100 h-100"
								src="/file/AnhWebBanHang/${chitiet.imgs.get(0).image}"
								alt="Image">
						</div>
						<div class="carousel-item">
							<img class="w-100 h-100"
								src="/file/AnhWebBanHang/${chitiet.imgs.get(1).image}"
								alt="Image">
						</div>
						<div class="carousel-item">
							<img class="w-100 h-100"
								src="/file/AnhWebBanHang/${chitiet.imgs.get(2).image}"
								alt="Image">
						</div>
						<div class="carousel-item">
							<img class="w-100 h-100"
								src="/file/AnhWebBanHang/${chitiet.imgs.get(3).image}"
								alt="Image">
						</div>
					</div>
					<a class="carousel-control-prev" href="#product-carousel"
						data-slide="prev"> <i class="fa fa-2x fa-angle-left text-dark"></i>
					</a> <a class="carousel-control-next" href="#product-carousel"
						data-slide="next"> <i
						class="fa fa-2x fa-angle-right text-dark"></i>
					</a>
				</div>
			</div>

			<div class="col-lg-7 pb-5">
				<h3 class="font-weight-semi-bold">${chitiet.name}</h3>
				<div class="d-flex mb-3">
					<div class="text-primary mr-2">
						4.9 <small class="fa-solid fa-star"></small> <small
							class="fas fa-star"></small> <small class="fas fa-star"></small>
						<small class="fas fa-star-half-alt"></small> <small
							class="far fa-star"></small>
					</div>
					<small class="pt-1">(50 Reviews)</small> |
					<div class="text-primary mr-2">51</div>
					<small class="pt-1">Đánh giá </small> |
					<div class="text-primary mr-2">500</div>
					<small class="pt-1">Đã bán </small>
				</div>
				<h3>Giá sản phẩm</h3>
				<h3 class="line-through font-weight-semi-bold mb-4">${chitiet.price }</h3>
				<h3>Giá sale</h3>
				<h3 class=" font-weight-semi-bold mb-4">${chitiet.price-(chitiet.sale*chitiet.price) }</h3>


				<form:form action="/account/newcart" method="post">
					<input type="hidden" name="id" value="${chitiet.id}"/>

					<div class="d-flex align-items-center mb-4 pt-2">

						<div class="col-md-3 col-lg-3 col-xl-2 d-flex">
							<a class="btn btn-primary px-2"
								onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
								<i class="fas fa-minus"></i>
							</a> 
							
							<input type="number" name="quantity"  min="1" value="1"  
							style="width: 40px; height: 40px; text-align: center;" class="form-control form-control-sm" /> 
								
							<a class="btn btn-primary px-2"
								onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
								<i class="fas fa-plus"></i>
							</a>
						</div>
						<button style="margin-left: 20px" class="btn btn-primary px-3">
							<i class="fa fa-shopping-cart mr-1"></i> Add To Cart
						</button>
					</div>
				</form:form>
				<div class="d-flex pt-2">
					<p class="text-warning font-weight-medium mb-0 mr-2">Share on:</p>
					<div class="d-inline-flex">
						<a class="text-warning px-2" href=""> <i
							class="fab fa-facebook-f"></i>
						</a> <a class="text-warning px-2" href=""> <i
							class="fab fa-twitter"></i>
						</a> <a class="text-warning px-2" href=""> <i
							class="fab fa-linkedin-in"></i>
						</a> <a class="text-warning px-2" href=""> <i
							class="fab fa-pinterest"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="row px-xl-5">
			<div class="col">
				<div
					class="nav nav-tabs justify-content-center border-secondary mb-4">
					<a class="nav-item nav-link active" data-toggle="tab"
						href="#tab-pane-1" style="color: black;">Description</a> <a style="color: black;" class="nav-item nav-link"
						data-toggle="tab" href="#tab-pane-2">Information</a> <a style="color: black;"
						class="nav-item nav-link" data-toggle="tab" href="#tab-pane-3">Reviews
						(0)</a>
				</div>
				<div class="tab-content">
					<div class="tab-pane fade show active" id="tab-pane-1">
						<h4 class="mb-3">Product Description</h4>
						<p>Eos no lorem eirmod diam diam, eos elitr et gubergren diam
							sea. Consetetur vero aliquyam invidunt duo dolores et duo sit.
							Vero diam ea vero et dolore rebum, dolor rebum eirmod consetetur
							invidunt sed sed et, lorem duo et eos elitr, sadipscing kasd
							ipsum rebum diam. Dolore diam stet rebum sed tempor kasd eirmod.
							Takimata kasd ipsum accusam sadipscing, eos dolores sit no ut
							diam consetetur duo justo est, sit sanctus diam tempor aliquyam
							eirmod nonumy rebum dolor accusam, ipsum kasd eos consetetur at
							sit rebum, diam kasd invidunt tempor lorem, ipsum lorem elitr
							sanctus eirmod takimata dolor ea invidunt.</p>
						<p>Dolore magna est eirmod sanctus dolor, amet diam et eirmod
							et ipsum. Amet dolore tempor consetetur sed lorem dolor sit lorem
							tempor. Gubergren amet amet labore sadipscing clita clita diam
							clita. Sea amet et sed ipsum lorem elitr et, amet et labore
							voluptua sit rebum. Ea erat sed et diam takimata sed justo. Magna
							takimata justo et amet magna et.</p>
					</div>
					<div class="tab-pane fade" id="tab-pane-2">
						<h4 class="mb-3">Additional Information</h4>
						<p>Eos no lorem eirmod diam diam, eos elitr et gubergren diam
							sea. Consetetur vero aliquyam invidunt duo dolores et duo sit.
							Vero diam ea vero et dolore rebum, dolor rebum eirmod consetetur
							invidunt sed sed et, lorem duo et eos elitr, sadipscing kasd
							ipsum rebum diam. Dolore diam stet rebum sed tempor kasd eirmod.
							Takimata kasd ipsum accusam sadipscing, eos dolores sit no ut
							diam consetetur duo justo est, sit sanctus diam tempor aliquyam
							eirmod nonumy rebum dolor accusam, ipsum kasd eos consetetur at
							sit rebum, diam kasd invidunt tempor lorem, ipsum lorem elitr
							sanctus eirmod takimata dolor ea invidunt.</p>
						<div class="row">
							<div class="col-md-6">
								<ul class="list-group list-group-flush">
									<li class="list-group-item px-0">Sit erat duo lorem duo ea
										consetetur, et eirmod takimata.</li>
									<li class="list-group-item px-0">Amet kasd gubergren sit
										sanctus et lorem eos sadipscing at.</li>
									<li class="list-group-item px-0">Duo amet accusam eirmod
										nonumy stet et et stet eirmod.</li>
									<li class="list-group-item px-0">Takimata ea clita labore
										amet ipsum erat justo voluptua. Nonumy.</li>
								</ul>
							</div>
							<div class="col-md-6">
								<ul class="list-group list-group-flush">
									<li class="list-group-item px-0">Sit erat duo lorem duo ea
										consetetur, et eirmod takimata.</li>
									<li class="list-group-item px-0">Amet kasd gubergren sit
										sanctus et lorem eos sadipscing at.</li>
									<li class="list-group-item px-0">Duo amet accusam eirmod
										nonumy stet et et stet eirmod.</li>
									<li class="list-group-item px-0">Takimata ea clita labore
										amet ipsum erat justo voluptua. Nonumy.</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="tab-pane-3">
						<div class="row">
							<div class="col-md-6">
								<h4 class="mb-4">1 review for "Colorful Stylish Shirt"</h4>
								<div class="media mb-4">
									<img src="" alt="Image" class="img-fluid mr-3 mt-1"
										style="width: 45px;">
									<div class="media-body">
										<h6>
											John Doe<small> - <i>01 Jan 2045</i></small>
										</h6>
										<div class="text-primary mb-2">
											<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
												class="fas fa-star"></i> <i class="fas fa-star-half-alt"></i>
											<i class="far fa-star"></i>
										</div>
										<p>Diam amet duo labore stet elitr ea clita ipsum, tempor
											labore accusam ipsum et no at. Kasd diam tempor rebum magna
											dolores sed sed eirmod ipsum.</p>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<h4 class="mb-4">Leave a review</h4>
								<small>Your email address will not be published.
									Required fields are marked *</small>
								<div class="d-flex my-3">
									<p class="mb-0 mr-2">Your Rating * :</p>
									<div class="text-primary">
										<i class="far fa-star"></i> <i class="far fa-star"></i> <i
											class="far fa-star"></i> <i class="far fa-star"></i> <i
											class="far fa-star"></i>
									</div>
								</div>
								<form>
									<div class="form-group">
										<label for="message">Your Review *</label>
										<textarea id="message" cols="30" rows="5" class="form-control"></textarea>
									</div>
									<div class="form-group">
										<label for="name">Your Name *</label> <input type="text"
											class="form-control" id="name">
									</div>
									<div class="form-group">
										<label for="email">Your Email *</label> <input type="email"
											class="form-control" id="email">
									</div>
									<div class="form-group mb-0">
										<input type="submit" value="Leave Your Review"
											class="btn btn-primary px-3">
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Shop Detail End -->
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<!-- footer -->

	<script type="text/javascript"></script>

	<jsp:include page="/view/partials/footer.jsp"></jsp:include>
</body>

</html>