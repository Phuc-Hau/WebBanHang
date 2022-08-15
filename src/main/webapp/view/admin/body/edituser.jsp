<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

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

				<form:form class="form-sample" method="post" enctype="multipart/form-data" modelAttribute="edituser">
					<form:input path="iduser" type="hidden" />
					<form:input path="idcutomer" type="hidden" />
					<form:input path="username" type="hidden" />
					<div class="row">
						<div class="col-md-3">

							<div class="avatar-upload">
								<div class="avatar-edit">
									<label style="position: absolute; width: 212px; height: 212px; left: -4px; top: 40px; opacity: 0;"
										for="upload"></label> 
									<input id="upload" type="file" onchange="readURL(this);" name="imgs" accept=".png, .jpg, .jpeg" />

								</div>
								<div class="avatar-preview" style="right: 180px; top: 50px;">
									<img width="200px" height="200px" id="imageResult" src="/file/user/${edituser.img}" alt=""> 
									<label style="margin-top: 25px; margin-left: 26px;" for="upload">Uploat ảnh đại diện</label>
								</div>
							</div>

						</div>
						<div class="col-md-9">

							<div class="row">
								<div class="col-md-6">
									<div class="form-group row">
										<label class="col-sm-3 col-form-label">User Name</label>
										<div class="col-sm-9">
											<span class="form-control">${edituser.username}</span>
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
										<label class="col-sm-3 col-form-label">Gender</label>
										<div class="col-sm-9">
											<form:select path="sex" class="form-control">
												<form:option value="Male">Male</form:option>
												<form:option value="Female"> Female</form:option>
											</form:select>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group row">
										<label class="col-sm-3 col-form-label">Rule</label>
										<div class="col-sm-9">
											<form:select path="rules" class="form-control">
												<form:option value="0">Admin</form:option>
												<form:option value="1">Người dùng</form:option>
											</form:select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group row">
										<label class="col-sm-3 col-form-label">Tỉnh / Thành phố</label>
										<div class="col-sm-9">
											<select id="provin" class="form-control" name="calc_shipping_provinces" required="">
												<option value="">Tỉnh / Thành phố</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group row">
										<label class="col-sm-3 col-form-label">Quận / Huyện</label>
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
										<label class="col-sm-3 col-form-label">Status</label>
										<div class="col-sm-4">
											<div class="form-check">
												<label class="form-check-label"> 
												<form:radiobutton path="status" checked="checked" class="form-check-input"
														name="membershipRadios" id="membershipRadios1"
														value="true" /> Hoạt Động
												</label>
											</div>
										</div>

										<div class="col-sm-5">
											<div class="form-check">
												<label class="form-check-label"> 
												<form:radiobutton path="status" class="form-check-input"
														name="membershipRadios" id="membershipRadios2"
														value="false" /> Tắc hoạt động
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

					<button type="submit" formaction="/admin/user/update"
						class="btn btn-gradient-success btn-rounded btn-fw">
						<i class="mdi mdi-content-save"></i>Update
					</button>

					<button type="button"
						class="btn btn-gradient-warning btn-rounded btn-fw">
						<i class="mdi mdi-reload btn-icon-prepend"></i> Reset
					</button>
					<button type="submit" formaction="/admin/userlist"
						class="btn btn-gradient-primary btn-rounded btn-fw">
						<i class="mdi mdi-exit-to-app"></i> Cancel
					</button>
					
				</form:form>
			</div>
		</div>



	</div>

</div>