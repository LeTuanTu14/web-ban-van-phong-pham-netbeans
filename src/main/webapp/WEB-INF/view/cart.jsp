<%-- 
    Document   : cart
    Created on : May 17, 2021, 4:24:26 PM
    Author     : TUAN TU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Giỏ hàng</title>
        <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
    </head>
    <body>

<div class="row">
	<div class="span12">
    
	<div class="well well-small">
		<h1>Giỏ hàng <small class="pull-right"> ${ Cart.size() } Sản phẩm trong giỏ hàng </small></h1>
	<hr class="soften"/>	

	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>Hình ảnh</th>
                  <th>Sản phẩm</th>
                  <th>Giá bán</th>
                  <th>Số lượng </th>
                  <th>Xóa </th>
                  <th>Tổng tiền</th>
				</tr>
              </thead>
              <tbody>
                  <c:url var="update" value="/resources/img/update.jpg" />
                  <c:url var="delete" value="/resources/img/delete.jpg" />
				<c:forEach var="item" items="${ Cart }">
					<tr>
	                  <td><img width="100" src="<c:url value="${ item.value.sanPham.image }"/>" alt=""></td>
	                  <td>${ item.value.sanPham.tenSP }</td>
	                  
	                  <td>${item.value.sanPham.gia} ₫</td>
	                  <td>
                              <form action="<c:url value="/cart/update"/>" method="POST">
                                  <input type="hidden" name="id" value="${ item.key }"/>
                                  <input name="sl" type="number" min="1" max="${ item.value.sanPham.soLuong }" class="span1" style="max-width:34px" placeholder="1" id="appendedInputButtons" size="16" type="text" value="${ item.value.soLuong }">
                                  <button type="submit">Cập nhật</button>
                              </form>
                              
			  </td>
	                  <td>
	                  	<a href="<c:url value="/cart/delete/${ item.key }"/>" onclick="if (!(confirm('Bạn có muốn xóa Sản Phẩm khỏi giỏ hàng không?'))) return false" class="btn btn-mini btn-danger" type="button">
	                  		<img src="${delete}" style="height: 35px; width: 35px"/>
	                  	</a>
	                  </td>
	                  <td>${ item.value.tongTien } ₫</td>
	                </tr>
				</c:forEach>
                        <br/>
                        <table class="table table-bordered table-condensed">
                            <tbody>
                                <tr>
                                    <td style="text-align: right"><h3>Tổng cộng: ${ TotalPriceCart } VND </h3></td>
                                </tr>
                            </tbody>
                            
                        </table>
		</tbody>
            </table><br/>
			
	<a href="<c:url value="/sanphams"/>" class="shopBtn btn-large"> Tiếp tục mua sắm </a>
	<a href="<c:url value="/cart/dathang"/>" class="shopBtn btn-large pull-right">Đặt hàng</a>

</div>
</div>
</div>
    </body>
</html>
