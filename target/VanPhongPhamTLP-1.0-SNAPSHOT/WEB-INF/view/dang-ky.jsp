<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
</head>
<body>
    <h3>Đăng ký tài khoản</h3>
    <c:url var="saveUrl" value="/user/saveAcc" />
                                                        <form:form action="${saveUrl}" modelAttribute="user" method="POST">
                                                            <form:hidden path="id" />
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
									<label class="control-label" for="inputTen">Họ và tên</label>
									<div class="controls">
										<form:input class="span3" path="hoTen" placeholder="Họ và tên" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="inputDiaChi">Địa chỉ</label>
									<div class="controls">
										<form:textarea class="span3" path="diaChi" placeholder="Địa chỉ" />
									</div>
								</div>
								<div class="control-group">
									<div class="controls">
										<input type="submit" value="Đăng ký" style="width: 100px"/>
									</div>
								</div>
							</form:form>
</body>