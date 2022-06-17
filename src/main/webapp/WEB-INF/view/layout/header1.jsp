<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><decorator:title default="MasterLayout"></decorator:title> </title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap styles -->
<link href='<c:url value="/resources/css/bootstrap.css" />' rel="stylesheet" />
<!-- Customize styles -->
<link href="<c:url value="/resources/style.css"/>" rel="stylesheet" />
<!-- font awesome styles -->
<link href="<c:url value="/resources/font-awesome/css/font-awesome.css" />" rel="stylesheet">


<!-- Favicons -->
<link rel="shortcut icon" href="<c:url value="/resources/ico/favicon.ico" />">
</head>
<body>
	<!-- 
	Upper Header Section 
-->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="topNav">
			<div class="container">
				<div class="alignR">

					<a class="active" href="<c:url value="/"/>">
						Trang Chủ
					</a>
                                        <c:if test="${empty taikhoan}"> 
                                            <a href="<c:url value="/user/dangnhap"/>"> Đăng nhập </a>
                                        </c:if>
                                        <c:if test="${not empty taikhoan}"> 
                                            <a href="<c:url value="/user/dangxuat"/>"> Đăng xuất </a>
                                        </c:if>
					  <a href="<c:url value="/user/dangky"/>"> Đăng kí </a>
                                          <a href="<c:url value="/lienhe"/>">Liên hệ</a>
					    <a href="<c:url value="/sanphams"/>"> Sản phẩm </a>
				</div>
			</div>
		</div>
	</div>

	<!--
Lower Header Section 
-->
	<div class="container">
		<div id="gototop"></div>
	<%@include file="/WEB-INF/view/layout/header.jsp"%>	
			<decorator:body></decorator:body>	
	
	<%@include file="/WEB-INF/view/layout/footer.jsp"%>
	</div>
	<!-- /container -->
	
	

	<div class="copyright">
		<div class="container">
			<p class="pull-right">
				<a href="#"><img src="<c:url value="/resources/img/maestro.png" />" alt="payment"></a>
				<a href="#"><img src="<c:url value="/resources/img/mc.png" />" alt="payment"></a> <a
					href="#"><img src="<c:url value="/resources/img/pp.png" />" alt="payment"></a> <a
					href="#"><img src="<c:url value="/resources/img/visa.png" />" alt="payment"></a> <a
					href="#"><img src="<c:url value="/resources/img/disc.png" />" alt="payment"></a>
			</p>
			<p>Copyright &copy; 2021</p>
		</div>
	</div>
	<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.easing-1.3.min.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.scrollTo-1.4.3.1-min.js"/>"></script>
	<script src="<c:url value="/resources/js/shop.js"/>"></script>
</body>
</html>
