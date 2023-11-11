<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Nhúng các file CSS và JavaScript của Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container">
        <!-- Tạo một thanh điều hướng với logo và các liên kết -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">
                <img src="logo.png" alt="Logo" height="50">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Trang chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Sản phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Giới thiệu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Liên hệ</a>
                    </li>
                    <!-- Tạo một nút đăng nhập trên thanh điều hướng -->
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/account/login.jsp'/>">Đăng nhập</a>
                    </li>
                </ul>
            </div>
        </nav>
        
        <!-- Tạo một băng chuyền hình ảnh với các ưu đãi và khuyến mãi -->
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="banner1.jpg" class="d-block w-100" alt="Banner 1">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>Giảm giá 50% tất cả các loại giày</h3>
                        <p>Chỉ áp dụng trong tháng 11</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="banner2.jpg" class="d-block w-100" alt="Banner 2">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>Mua 2 tặng 1</h3>
                        <p>Chỉ áp dụng cho các sản phẩm có giá trị từ 500.000 VND trở lên</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="banner3.jpg" class="d-block w-100" alt="Banner 3">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>Miễn phí giao hàng</h3>
                        <p>Chỉ áp dụng cho các đơn hàng từ 300.000 VND trở lên</p>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Trước</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Sau</span>
            </a>
        </div>
        <!-- Tạo một phần giới thiệu về web bán giày -->
        <div class="jumbotron">
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <c:if test="${session.getAttribute(user) != null}">
                <p>Welcome back, <c:out value='${user.email}'/></p>
            </c:if>
            <h1 class="display-4">Chào mừng bạn đến với web bán giày của chúng tôi!</h1>
            <p class="lead">Chúng tôi là một cửa hàng chuyên cung cấp các loại giày chất lượng cao, đa dạng về mẫu mã và giá cả. Chúng tôi cam kết mang đến cho bạn những trải nghiệm mua sắm tuyệt vời nhất.</p>
            <hr class="my-4">
            <p>Để biết thêm thông tin về các sản phẩm và dịch vụ của chúng tôi, bạn có thể truy cập vào các liên kết bên dưới hoặc liên hệ với chúng tôi qua số điện thoại, email hoặc mạng xã hội.</p>
            <a class="btn btn-primary btn-lg" href="#" role="button">Xem sản phẩm</a>
            <a class="btn btn-secondary btn-lg" href="#" role="button">Giới thiệu</a>
        </div>
        <!-- Tạo một phần hiển thị các sản phẩm nổi bật -->
        <div class="row">
            <div class="col-12">
                <h2 class="text-center">Sản phẩm nổi bật</h2>
            </div>
            <!-- Tạo một card cho mỗi sản phẩm -->
            <div class="col-md-4 col-sm-6">
                <div class="card">
                    <img src="product1.jpg" class="card-img-top" alt="Product 1">
                    <div class="card-body">
                        <h5 class="card-title">Giày thể thao nam</h5>
                        <p class="card-text">Giày thể thao nam màu đen, chất liệu da, kiểu dáng thời trang, phù hợp cho mọi hoạt động.</p>
                        <p class="card-text"><strong>Giá: 400.000 VND</strong></p>
                        <a href="#" class="btn btn-primary">Mua ngay</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-sm-6">
                <div class="card">
                    <img src="product2.jpg" class="card-img-top" alt="Product 2">
                    <div class="card-body">
            
