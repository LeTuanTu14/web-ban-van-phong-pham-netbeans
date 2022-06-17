<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<header id="header">
	<div class="row">
		<div class="span4">
<!--			<h1>
				<a class="logo" href="<c:url value="/"/>"><span>Twitter Bootstrap
						ecommerce template</span> <img
					src="<c:url value="/assets/user/img/logo-bootstrap-shoping-cart.png" />"
					alt="bootstrap sexy shop"> </a>
			</h1>-->
		</div>
	 	<div class="span4">
			<!-- <div class="offerNoteWrapper">
				<h1 class="dotmark">
					<i class="icon-cut"></i> Twitter Bootstrap shopping cart HTML
					template is available @ $14
				</h1>
			</div>  -->
		</div>  
		<div class="span4 alignR">
			<p>
				<br> <strong> Hỗ Trợ (24/7) : 0800 1234 678 </strong><br>
				<br>
			</p>
			<span class="btn btn-mini">[${ Cart.size() } ] <span
				class="icon-shopping-cart"></span></span> 
				<span class="btn btn-warning btn-mini">vnd</span> 
				<span class="btn btn-mini">$</span>
		</div>
	</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a data-target=".nav-collapse" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="nav-collapse">
				<ul class="nav">
					<li class="active"><a href="<c:url value="/"/>">Trang Chủ </a></li>
					<li class=""><a href="<c:url value="/sanphams"/>">Sản Phẩm</a></li>
					<li class=""><a href="<c:url value="/cart/myCart"/>">Giỏ Hàng</a></li>
					<li class=""><a href="<c:url value="/lienhe"/>">Liên Hệ</a></li>
                                        <li class=""><a href="<c:url value="/quanly"/>">Quản lý</a></li>
				</ul>
                                <form action="<c:url value="/sanpham/timkiem"/>" class="navbar-search pull-left">
                                    <input type="text" placeholder="Tìm kiếm" class="search-query span2" name="theSearchName">
				</form>
				<ul class="nav pull-right">
                                    <li class=""><a href="<c:url value="/user/dangnhap"/>">Đăng Nhập</a></li>

				</ul>
			</div>
		</div>
	</div>
</div>
