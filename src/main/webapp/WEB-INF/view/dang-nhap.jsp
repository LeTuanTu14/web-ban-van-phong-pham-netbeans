<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<head>
<title>Đăng nhập</title>
</head>
<body>
<c:url var="loginUrl" value="/user/checkAcc" />	
                                            <c:if test="${empty taikhoan}"> 
							<h3>Đăng nhập</h3>
                                                        <c:if test="${not empty err}"> 
                                                            <h5 style="color: red">Đăng nhập thất bại !</h5>
                                                        </c:if>
							<form:form action="${loginUrl}" modelAttribute="user" method="POST">
								<div class="control-group">
									<label class="control-label" for="inputEmail">Email</label>
									<div class="controls">
										<form:input class="span3" type="email" path="email"
											placeholder="Email" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="inputPassword">Mật khẩu</label>
									<div class="controls">
										<form:input class="span3" type="password" path="passWord"
											placeholder="Mật khẩu" />
									</div>
								</div>
								<div class="control-group">
									<div class="controls">
										<button type="submit" class="defaultBtn">Đăng nhập</button>
										
									</div>
								</div>
							</form:form>
                                            </c:if>
                                            <c:if test="${not empty taikhoan}">
                                                <h3>Tài khoản: ${taikhoan.email}</h3>
                                                <a href="<c:url value="/user/dangxuat"/>">Đăng xuất</a>
                                            </c:if>
</body>		