<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>


<div class="content-wrapper">
	<div class="page-header">
		<h3 class="page-title">
			<span class="page-title-icon bg-gradient-primary text-white me-2">
				<i class="mdi mdi-cart"></i>
			</span> Product Tables
		</h3>

	</div>

	<div class="grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<div class="form-group">
					<label for="exampleSelectGender">Group Product</label> 
					
					
					<form action="/admin/productlist">
						<select name="group" onchange="this.form.submit()" class="form-control">
						<option value="0">ALL</option>
						<c:forEach var="group" items="${groupproduct}">
							<option value="${group.id}">${group.name}</option>
						</c:forEach>
						</select>
					</form>
					
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>IMG</th>
							<th>Name</th>
							<th>Amount</th>
							<th>Price</th>
							<th>Sale</th>
							<th>Date</th>
							<th>Status</th>
							<th><i class="mdi mdi-border-color"></i></th>
						</tr>
					</thead>
					<tbody>
						<c:set var="count" scope="session" value="1" />
						<c:forEach var="item" items="${adminlistproduct}">
							<tr>
								<td>${count}</td>
								<td class="py-1"><img
									src="/file/AnhWebBanHang/${item.imgs.get(0).image}"
									alt="image" /></td>
								<td>${item.name}</td>
								<td>${item.amount }</td>
								<td>${item.price }đ</td>
								<td class="text-danger">${item.sale }<i
									class="mdi mdi-arrow-down"></i></td>
								<td>27/10/2022</td>
								<td><c:choose>
										<c:when test="${item.status}">
											<div class="form-check form-check-success">
												<label class="form-check-label"> <input type="radio"
													class="form-check-input" id="ExampleRadio2" checked="">
													<i class="input-helper"></i></label>
											</div>
										</c:when>
										<c:otherwise>
											<div class="form-check form-check-danger">
												<label class="form-check-label"> <input type="radio"
													class="form-check-input" id="ExampleRadio4" checked="">
													<i class="input-helper"></i></label>
											</div>
										</c:otherwise>
									</c:choose></td>
								<td><a href="/admin/product/edit/${item.id}">Edit</a></td>
							</tr>
							<c:set var="count" scope="session" value="${count+1}" />
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>