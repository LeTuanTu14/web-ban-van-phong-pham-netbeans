<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<title>Trang chủ - TLP</title>
<body>
	<!-- 
Body Section 
-->
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">
                                    <c:forEach var="l" items="${loais}">
                                        <c:url var="showUrl" value="/sanpham/sanphamsLoai">
                                            <c:param name="tenLoai" value="${l.tenLoai}" /></c:url>
                                            <c:url var="showCcUrl" value="/sanpham/sanphamsLoai?tenLoai=${l.tenLoai}" />
					<li><a href="${showUrl}"><span
							class="icon-chevron-right"></span>${l.tenLoai}</a></li>

                                    </c:forEach>
                                        <li><a href="<c:url value="/sanphams"/>"><span
							class="icon-chevron-right"></span>Tất cả Sản Phẩm</a></li>
					<li style="border: 0">&nbsp;</li>
					
				</ul>
			</div>

			<div class="well well-small">
				<a href="#"><img src="<c:url value="/resources/img/paypal.jpg" />"
					alt="payment method paypal"></a>
			</div>
                        

		</div>
		<div class="span9">
			<div class="well np">
				<div id="myCarousel" class="carousel slide homCar">
					<div class="carousel-inner">
						<div class="item">
							<img style="width: 100%"
								src="<c:url value="/resources/img/van-phong-pham-gia-re.png" />"
								alt="bootstrap ecommerce templates">
							<div class="carousel-caption">
								<h4></h4>
								<p>
									<span></span>
								</p>
							</div>
						</div>
						<div class="item">
							<img style="width: 100%" src="<c:url value="/resources/img/van-phong-pham.jpg" />"
								alt="bootstrap ecommerce templates">
							<div class="carousel-caption">
								<h4></h4>
								<p>
									<span></span>
								</p>
							</div>
						</div>
						<div class="item active">
							<img style="width: 100%" src="<c:url value="/resources/img/van-phong-pham-38(1).jpg" />"
								alt="bootstrap ecommerce templates">
							<div class="carousel-caption">
								<h4></h4>
								<p>
									<span></span>
								</p>
							</div>
						</div>
						
					</div>
					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
						href="#myCarousel" data-slide="next">&rsaquo;</a>
				</div>
			</div>
<!--
New Products
-->
			<div class="well well-small">
				<h3>Sản Phẩm Mới</h3>
				<hr class="soften" />
				
				<div class="row-fluid">
					<ul class="thumbnails">
                                            <c:forEach var="spNew" items="${spNews}">
						<li class="span4">
							<div class="thumbnail">

								<a class="zoomTool" href="<c:url value="/chitietsanpham/${spNew.maSP}"/>"
									title="add to cart">Xem chi tiết
                                                                </a> <a href="<c:url value="/chitietsanpham/${spNew.maSP}"/>"><img
									src="<c:url value="${spNew.image}" />" alt="" style="height: 200px; width: 200px"></a>
								<div class="caption cntr">
									<p>${spNew.tenSP}</p>
									<p>
										<strong> ${spNew.gia} đ</strong>
									</p>
									<h4>
										<a class="shopBtn" href="<c:url value="/cart/add/${spNew.maSP}"/>" title="add to cart"> Thêm giỏ hàng </a>
									</h4>
									
									<br class="clr">
								</div>
							</div>
						</li>
                                            </c:forEach>
						
					</ul>
				</div>
			</div>
			<!--
	Featured Products
	-->
			<div class="well well-small">
				<h3>
					Sản Phẩm Bán Chạy
				</h3>
				<hr class="soften" />
				<div class="row-fluid">
					<ul class="thumbnails">
                                            <c:forEach var="spHot" items="${spHots}">
						<li class="span4">
							<div class="thumbnail">

								<a class="zoomTool" href="<c:url value="/chitietsanpham/${spHot.maSP}"/>"
									title="add to cart">Xem chi tiết
									</a> <a href="<c:url value="/chitietsanpham/${spHot.maSP}"/>"><img
									src="<c:url value="${spHot.image}" />" alt="" style="height: 200px; width: 200px"></a>
								<div class="caption cntr">
									<p>${spHot.tenSP}</p>
									<p>
										<strong> ${spHot.gia} đ</strong>
									</p>
									<h4>
										<a class="shopBtn" href="<c:url value="/cart/add/${spHot.maSP}"/>" title="add to cart"> Thêm giỏ hàng</a>
									</h4>
									
									<br class="clr">
								</div>
							</div>
						</li>
                                            </c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
