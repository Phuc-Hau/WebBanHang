<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/assets/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="/assets/vendors/css/vendor.bundle.base.css">

<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="/assets/css/style.css">
<!-- End layout styles -->
<link rel="shortcut icon" href="/assets/images/favicon.ico" />

<link rel="stylesheet" href="/assets/css/buttonUpload.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- CSS -->
<link rel="stylesheet" href="/assets/css/sach.css">

</head>
<body>
 <jsp:include page="/view/partials/header.jsp"></jsp:include>

	<div class="content-wrapper">
		<div class="page-header">
			<h3 class="page-title">
				<span class="page-title-icon bg-gradient-primary text-white me-2">
					<i class="mdi mdi-border-color"></i>
				</span> Chỉnh sửa người dùng
			</h3>
		</div>

		<div class="col-lg-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">

					<form:form class="form-sample" method="post"
						modelAttribute="edituser" enctype="multipart/form-data">
						<form:input path="iduser" type="hidden" />
						<form:input path="idcutomer" type="hidden" />
						<form:input path="username" type="hidden" />
						<div class="row">
							<div class="col-md-3">

								<div class="avatar-upload">

									<div class="avatar-edit">
										<label
											style="position: absolute; width: 212px; height: 212px; left: -4px; top: 40px; opacity: 0;"
											for="upload"></label> <input id="upload" type="file"
											onchange="readURL(this);" name="imgs"
											accept=".png, .jpg, .jpeg" />

									</div>
									<div class="avatar-preview" style="right: 180px; top: 50px;">
										<img width="200px" height="200px" id="imageResult"
											src="/file/user/${user.img }" alt=""> <label
											style="margin-top: 25px; margin-left: 26px;" for="upload">Upload
											ảnh đại diện</label>
									</div>
								</div>

							</div>
							<div class="col-md-9">

								<div class="row">
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">User Name</label>
											<div class="col-sm-9">
												<span class="form-control">${user.username}</span>
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Full Name</label>
											<div class="col-sm-9">
												<form:input path="name" type="text" class="form-control" />
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Gmail</label>
											<div class="col-sm-9">
												<form:input path="email" type="email" class="form-control" />
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">PassWord</label>
											<div class="col-sm-9">
												<form:input path="password" minlength="8" type="password"
													class="form-control" />
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Tỉnh / Thành phố </label>
											<div class="col-sm-9">

												<select  id="provin" class="form-control" name="calc_shipping_provinces" required="">

													<option value="">Tỉnh / Thành phố</option>

												</select> 
											</div>
										</div>
										
										
									</div>
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Quận / Huyện </label>
											<div class="col-sm-9">

												<select class="form-control" name="calc_shipping_district" required="">

													<option value="">Quận / Huyện</option>

												</select> 
												
											</div>
										</div>
										
									</div>

									<input class="billing_address_1" id="address_1" name="provinces" type="hidden" value="${edituser.provinces }">
									<input class="billing_address_2" id="address_2" name="district" type="hidden" value="${edituser.district }">
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Date of Birth</label>
											<div class="col-sm-9">
												<form:input path="birthday" type="date" class="form-control" />
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Sex</label>
											<div class="col-sm-4">
												<div class="form-check">
													<label class="form-check-label"> <form:radiobutton
															path="sex" checked="checked" class="form-check-input"
															name="membershipRadios" id="membershipRadios1"
															value="true" /> Male
													</label>
												</div>
											</div>

											<div class="col-sm-5">
												<div class="form-check">
													<label class="form-check-label"> <form:radiobutton
															path="sex" class="form-check-input"
															name="membershipRadios" id="membershipRadios2"
															value="false" /> Female
													</label>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="exampleTextarea1">Address</label>
									<form:textarea path="address" class="form-control"
										id="exampleTextarea1" rows="4" />
								</div>
							</div>

						</div>


						<button type="submit" formaction="/account/user/update"
							class="btn btn-gradient-success btn-rounded btn-fw">
							<i class="mdi mdi-content-save"></i>Update
						</button>
						<button type="submit" formaction="/account/changinformation"
							class="btn btn-gradient-warning btn-rounded btn-fw">
							<i class="mdi mdi-reload btn-icon-prepend"></i> Reset
						</button>
						<button type="submit" formaction="/product/index"
							class="btn btn-gradient-primary btn-rounded btn-fw">
							<i class="mdi mdi-exit-to-app"></i> Cancel
						</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://web8802.com/wp-content/themes/hienads/assets/js/quanhuyen.js"></script>

	<script src="/js/procvince.js"></script>
	<script src="/js/uploatfile.js"></script>

	<script src="/assets/vendors/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page -->
	<script src="/assets/vendors/chart.js/Chart.min.js"></script>
	<script src="/assets/js/jquery.cookie.js" type="text/javascript"></script>
	<!-- End plugin js for this page -->
	<!-- inject:js -->
	<script src="/assets/js/off-canvas.js"></script>
	<script src="/assets/js/hoverable-collapse.js"></script>
	<script src="/assets/js/misc.js"></script>

  <jsp:include page="/view/partials/footer.jsp"></jsp:include>
</body>
</html>