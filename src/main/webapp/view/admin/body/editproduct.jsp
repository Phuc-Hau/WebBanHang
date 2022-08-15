<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div class="content-wrapper">
	<div class="page-header">
		<h3 class="page-title">
			<span class="page-title-icon bg-gradient-primary text-white me-2">
				<i class="mdi mdi-border-color"></i>
			</span> Chỉnh sửa sản phẩm
		</h3>
	</div>

	<div class="col-lg-12 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">

				<form:form class="form-sample" method="post"
					modelAttribute="product" enctype="multipart/form-data">

					<form:input path="id" type="hidden" />
					<div class="row">
						<div class="col-md-6">
							<div class="form-group row">
								<label class="col-sm-3 col-form-label">Name</label>
								<div class="col-sm-9">
									<form:input path="name" type="text" class="form-control" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group row">
								<label class="col-sm-3 col-form-label">Price</label>
								<div class="col-sm-9">
									<form:input path="price" type="text" class="form-control" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6">
							<div class="form-group row">
								<label class="col-sm-3 col-form-label">Amount</label>
								<div class="col-sm-9">
									<form:input path="amount" type="text" class="form-control" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group row">
								<label class="col-sm-3 col-form-label">Sale</label>
								<div class="col-sm-9">
									<form:input path="sale" min="0" type="number"
										class="form-control" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6">
							<div class="form-group row">
								<label class="col-sm-3 col-form-label">Date</label>
								<div class="col-sm-9">
									<form:input path="date" type="text" class="form-control" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group row">
								<label class="col-sm-3 col-form-label">Status</label>
								<div class="col-sm-4">
									<div class="form-check">
										<label class="form-check-label"> <form:radiobutton
												path="status" checked="checked" class="form-check-input"
												name="membershipRadios" id="membershipRadios1" value="true" />
											Hoạt Động
										</label>
									</div>
								</div>

								<div class="col-sm-5">
									<div class="form-check">
										<label class="form-check-label"> <form:radiobutton
												path="status" class="form-check-input"
												name="membershipRadios" id="membershipRadios2" value="false" />
											Tắc hoạt động
										</label>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group row">
							<label class="col-sm-3 col-form-label">Group Product</label>
							<div class="col-sm-9">
								<select name="groups" class="form-control">
									<c:forEach var="group" items="${groupproduct}">
										<option value="${group.id}">${group.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>

					</div>


					<button type="submit" formaction="/admin/product/update"
						class="btn btn-gradient-success btn-rounded btn-fw">
						<i class="mdi mdi-content-save"></i>Update
					</button>

					<button type="button"
						class="btn btn-gradient-warning btn-rounded btn-fw">
						<i class="mdi mdi-reload btn-icon-prepend"></i> Reset
					</button>
					<button type="submit" formaction="/admin/productlist"
						class="btn btn-gradient-primary btn-rounded btn-fw">
						<i class="mdi mdi-exit-to-app"></i> Cancel
					</button>

				</form:form>
			</div>
		</div>



	</div>

</div>