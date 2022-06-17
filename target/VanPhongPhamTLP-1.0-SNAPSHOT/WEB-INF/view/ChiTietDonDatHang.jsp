<%-- 
    Document   : ChiTietDonDatHang
    Created on : May 29, 2021, 12:14:38 PM
    Author     : TUAN TU
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi Tiết Đơn Đặt Hàng</title>
    </head>
<body>
    <h3>Chi Tiết Đơn Đặt Hàng</h3>
    <br/>
    <table>
        <tr>
            <td>ID:</td>
            <td>${dondathang.id}</td>
        </tr>
        <tr>
            <td>User:</td>
            <td>${dondathang.user}</td>
        </tr>
        <tr>
            <td>Họ tên:</td>
            <td>${dondathang.hoTen}</td>
        </tr>
        <tr>
            <td>Số điện thoại:</td>
            <td>${dondathang.sdt}</td>
        </tr>
        <tr>
            <td>Địa chỉ:</td>
            <td>${dondathang.diaChi}</td>
        </tr>
        <tr>
            <td>Số lượng:</td>
            <td>${dondathang.soLuong}</td>
        </tr>
        <tr>
            <td>Tổng tiền:</td>
            <td>${dondathang.tongTien} VND</td>
        </tr>
        <tr>
            <td>Ghi chú:</td>
            <td>${dondathang.ghiChu}</td>
        </tr>
    </table>
        <a>Danh sách sản phẩm:</a>
        <br/>
        <table>
            <c:forEach var="sp" items="${sanphamddh}">
                <tr>
                    <td>---------</td>
                    <td>---------</td>
                </tr>
                <tr>
                    <td>ID Sản Phẩm:</td>
                    <td>${sp.maSP}</td>
                </tr>
                <tr>
                    <td>Tên Sản Phẩm:</td>
                    <td>${sp.tenSP}</td>
                </tr>
                <tr>
                    <td>Số lượng:</td>
                    <td>${sp.soLuong}</td>
                </tr>
                <tr>
                    <td>Tiền:</td>
                    <td>${sp.gia}</td>
                </tr>
                
            </c:forEach>
            <tr></tr>
        </table>
        <h4>Tổng tiền: ${dondathang.tongTien} VND</h4>
        <br/><!-- comment -->
        <a href="<c:url value="/dondathang/list"/>">List Đơn đặt hàng</a>
</body>
