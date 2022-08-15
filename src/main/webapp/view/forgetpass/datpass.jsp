<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/assets/css/passmabaomat.css">

</head>
<body>
	<div class="_4-u5 _30ny" style="margin-top: 196px;">
		<form:form method="post" action="/account/updatepassword" onsubmit="" id="u_0_a_oY">
			<div class="mvl ptm uiInterstitial _9np_ uiInterstitialLarge uiBoxWhite">
				<div class="uiHeader uiHeaderBottomBorder mhl mts uiHeaderPage interstitialHeader">
					<div class="clearfix uiHeaderTop">
						<div>
							<h2 class="uiHeaderTitle" aria-hidden="true">Chọn mật khẩu mới</h2>
						</div>
					</div>
				</div>
				<div class="phl ptm uiInterstitialContent">
					<div class="mvm uiP _9nq2 marginBottom16px fsm">Tạo mật khẩu mới có tối thiểu 6 ký tự. Mật khẩu mạnh là mật khẩu được kết hợp từ các ký tự, số và dấu câu.</div>
					<div>
						<div class="clearfix">
							<div class="_9okt">
								<input style="margin-top: 0px; border: none" type="text" class="yu inputtext _55r1 _9oku _9o1w" id="password_new" name="password_new" placeholder="Mật khẩu mới" autocomplete="off" aria-label="Mật khẩu mới" aria-describedby="password_new_status">
								<button class="_42ft _4jy0 _9okv _4jy3 _517h _51sy" id="password_new_show" type="button">Ẩn</button>
							</div>
							<button class="_42ft mls _4jy0 _9ok7 _4jy3 _517h _51sy" type="button" id="4" tabindex="0">?</button>
						</div>
						<div class="_9ok8" id="password_new_status">
							<span class="accessible_elem">Xem thẻ trợ giúp để biết phản hồi về mật khẩu</span>
						</div>
					</div>
				</div>
				<div class="hu uiInterstitialBar uiBoxGray topborder" style="margin-bottom: 19px; margin-top: 79px;">
					<div class="clearfix">
						<div class="rfloat _ohf" style="margin-left: 267px">
							<button style=" padding: 0px; width: 100px;" class="_42ft _42fu _9nq1 textPadding29px selected _42g-" type="button" id="skip_button">Bỏ qua</button>
							<button  value="1" class="_42ft _42fu _9nq0 textPadding20px selected _42g-" id="btn_continue" name="btn_continue" type="submit">Tiếp tục</button>
						</div>
						<div class="pts"></div>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	
</body>
</html>