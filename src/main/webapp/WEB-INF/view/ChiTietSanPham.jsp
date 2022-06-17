<%-- 
    Document   : ChiTietSanPham
    Created on : May 27, 2021, 2:39:22 PM
    Author     : TUAN TU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
<style>
	.product-content{
		overflow-x: hidden;
	}
</style>
</head>
<body>
<!-- 
Body Section 
-->
	<div class="row product-content">
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
    <ul class="breadcrumb">
    <li><a href="<c:url value="/home" />">Trang chủ</a> <span class="divider">/</span></li>
    <li><a href="<c:url value="/sanphams" />">Sản phẩm</a> <span class="divider">/</span></li>
    <li class="active">Chi tiết sản phẩm</li>
    </ul>	
	<div class="well well-small">
	<div class="row-fluid">
			<div class="span5">
			<div id="myCarousel" class="carousel slide cntr">
                <div class="carousel-inner">
                  <div class="item active">
                   <a href="#"> <img src="<c:url value="${ sanpham.image }"/>" alt="" style="width:100%"></a>
                  </div>
                </div>
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
            </div>
			</div>
			<div class="span7">
				<h3>${ sanpham.tenSP }</h3>
				<hr class="soft"/>
				
				<form class="form-horizontal qtyFrm" method="get" action="<c:url value="/cart/add/${sanpham.maSP}"/>"/>
				  <div class="control-group">
					<label class="control-label"><span>${ sanpham.gia } ₫</span></label>
					<div class="controls">
<!--                                            <div><input type="number" min="0" value="0" class="span6"></div>-->
					</div>
				  </div>
				
				  
				  <h4></h4>
				  <p>Số lượng tồn: ${ sanpham.soLuong }
				  <p>
				  <button type="submit" class="shopBtn"><span class=" icon-shopping-cart"></span> Thêm giỏ hàng</button>
				</form>
			</div>
			</div>
				<hr class="softn clr"/>


            <ul id="productDetail" class="nav nav-tabs">
              <li class="active"><a href="#home" data-toggle="tab">Chi tiết sản phẩm</a></li>
              
            </ul>
            <div id="myTabContent" class="tab-content tabWrapper">
            <div class="tab-pane fade active in" id="home">
			  	${ sanpham.moTa }
			</div>

            </div>
</div>
</div>
</div> <!-- Body wrapper -->
</body>
