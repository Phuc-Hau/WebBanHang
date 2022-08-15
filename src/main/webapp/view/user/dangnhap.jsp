<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org/">
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>

    <link rel="stylesheet" type="text/css" href="/assets/css/passmabaomat.css">

</head>
<body>
<div class="_4-u5 _30ny">
    <form:form action="/account/login" class="_9vtf"
               data-testid="royal_login_form" modelAttribute="user" method="post"
               onsubmit="" id="u_0_k_Ft">

        <div
                class="mvl ptm uiInterstitial _9np_ uiInterstitialLarge uiBoxWhite">
            <div
                    class="uiHeader uiHeaderBottomBorder mhl mts uiHeaderPage interstitialHeader">
                <div class="clearfix uiHeaderTop">
                    <div>
                        <h2 class="uiHeaderTitle" aria-hidden="true">Đăng Nhập</h2>
                    </div>
                </div>
            </div>
            <div class="phl ptm uiInterstitialContent">
                <div>
                    <div class="clearfix">
                        <div class="_9okt olo">
                            <form:input style="margin-top: 0px; border: none" type="text"
                                        class="yu inputtext _55r1 _9oku _9o1w" name="id" value=""
                                        path="username" placeholder="User Name"></form:input>

                        </div>
                        <div class="_9okt olo">
                            <form:input style="margin-top: 0px; border: none"
                                        type="password" class="yu inputtext _55r1 _9oku _9o1w"
                                        name="passwordd" path="password" placeholder="Password"></form:input>

                        </div>
                        <div>
                            <span class="checkmark">Remember Me</span>
                            <input name="remember" value="true" type="checkbox" checked>

                        </div>
                        <span style="color: red"> ${mess} </span><br>
                        <button
                                class="sauo _42ft _42fu _9nq0 textPadding20px selected _42g-"
                                id="btn_continue" type="submit">Đăng Nhập
                        </button>

                        <div class="_6ltj">
                            <a href="/account/forgetpass">Quên mật khẩu?</a>
                        </div>


                        <a href="/oauth2/authorization/google" class="sauo">

                            <svg width="52" height="52" role="img"><title>Google's Logo</title>
                                <g id="Google-Button" stroke="none" stroke-width="1" fill="none"
                                   fill-rule="evenodd">
                                    <rect x="0" y="0" width="52" height="52" rx="2" style="fill: none;"></rect>
                                    <g id="logo_googleg_48dp"
                                       transform="translate(13.65, 13.65) scale(1.4300000000000002)">
                                        <path d="M17.64,9.20454545 C17.64,8.56636364 17.5827273,7.95272727 17.4763636,7.36363636 L9,7.36363636 L9,10.845 L13.8436364,10.845 C13.635,11.97 13.0009091,12.9231818 12.0477273,13.5613636 L12.0477273,15.8195455 L14.9563636,15.8195455 C16.6581818,14.2527273 17.64,11.9454545 17.64,9.20454545 L17.64,9.20454545 Z"
                                              id="Shape" fill="#4285F4"></path>
                                        <path d="M9,18 C11.43,18 13.4672727,17.1940909 14.9563636,15.8195455 L12.0477273,13.5613636 C11.2418182,14.1013636 10.2109091,14.4204545 9,14.4204545 C6.65590909,14.4204545 4.67181818,12.8372727 3.96409091,10.71 L0.957272727,10.71 L0.957272727,13.0418182 C2.43818182,15.9831818 5.48181818,18 9,18 L9,18 Z"
                                              id="Shape" fill="#34A853"></path>
                                        <path d="M3.96409091,10.71 C3.78409091,10.17 3.68181818,9.59318182 3.68181818,9 C3.68181818,8.40681818 3.78409091,7.83 3.96409091,7.29 L3.96409091,4.95818182 L0.957272727,4.95818182 C0.347727273,6.17318182 0,7.54772727 0,9 C0,10.4522727 0.347727273,11.8268182 0.957272727,13.0418182 L3.96409091,10.71 L3.96409091,10.71 Z"
                                              id="Shape" fill="#FBBC05"></path>
                                        <path d="M9,3.57954545 C10.3213636,3.57954545 11.5077273,4.03363636 12.4404545,4.92545455 L15.0218182,2.34409091 C13.4631818,0.891818182 11.4259091,0 9,0 C5.48181818,0 2.43818182,2.01681818 0.957272727,4.95818182 L3.96409091,7.29 C4.67181818,5.16272727 6.65590909,3.57954545 9,3.57954545 L9,3.57954545 Z"
                                              id="Shape" fill="#EA4335"></path>
                                        <path d="M0,0 L18,0 L18,18 L0,18 L0,0 Z" id="Shape"></path>
                                    </g>
                                </g>
                            </svg>
                            <div>Google</div>
                        </a>
                    </div>

                </div>
            </div>
            <div class="hu uiInterstitialBar uiBoxGray topborder"
                 style="margin-top: 28px; margin-bottom: 19px;">
                <div class="clearfix">
                    <div class="rfloat _ohf" style="margin-left: 122px">
                        <button formaction="/product/index"
                                style="padding: 0px; width: 100px;"
                                class="_42ft _42fu _9nq1 textPadding29px selected _42g-"
                                type="submit" id="skip_button">Hủy
                        </button>
                        <button formaction="/account/signup" value="1"
                                class="_42ft _42fu _9nq0 _9nq023 textPadding20px selected _42g-"
                                name="btn_continue" type="submit">Tạo
                            tài khoản mới
                        </button>
                    </div>
                    <div class="pts"></div>
                </div>
            </div>
        </div>

    </form:form>
</div>

</body>
</html>