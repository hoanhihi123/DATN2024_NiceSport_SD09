<%@ page contentType="text/html;charset=UTF-8"%>

<!-- Left Panel -->
    <aside id="left-panel" class="left-panel ">
        <nav class="navbar navbar-expand-sm navbar-default">
            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
<%--                    <li class="">--%>
<%--                        <a href="dashboard_2.html"><i class="menu-icon fa fa-laptop"></i>Dashboard </a>--%>
<%--                    </li>--%>
                    <li class="menu-title">Quản lý</li><!-- /.menu-title -->
                    <li class="menu-item-has-children dropdown active">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-cogs"></i>Quản lý thuộc tính</a>
                        <ul class="sub-menu children dropdown-menu">
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="fa fa-puzzle-piece"></i><a href="/san-pham/hien-thi">Giày</a></li>
                                <li><i class="fa fa-gear"></i><a href="/chat-lieu/hien-thi">Chất liệu</a></li>
                                <li><i class="fa fa-eraser"></i><a href="/mau-sac/hien-thi">Màu sắc</a></li>
                                <li><i class="fa fa-id-badge"></i><a href="/thuong-hieu/hien-thi">Thương hiệu</a></li>
                                <li><i class="fa fa-arrows-h"></i><a href="/kich-thuoc/hien-thi">Kích cỡ</a></li>
                                <li><i class="fa fa-inbox"></i><a href="/kieu-dang/hien-thi" >Kiểu dáng</a></li>
                                <li><i class="fa fa-suitcase"></i><a href="/nha-sx/hien-thi">NSX</a></li>
                            </ul>
                        </ul>

                    </li>
<%--                    <li class="menu-item-has-children dropdown">--%>
<%--                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-print" ></i>Quản lý hóa đơn</a>--%>
<%--                        <ul class="sub-menu children dropdown-menu">--%>
<%--                            <li><i class="fa fa-puzzle-piece"></i><a href="ui-buttons.html">Xuất hóa đơn</a></li>--%>
<%--                            <li><i class="fa fa-id-badge"></i><a href="ui-badges.html">Quản lý hóa đơn</a></li>--%>
<%--                        </ul>--%>
<%--                    </li>--%>
                    <li>
                        <a href="/hoa-don/hien-thi" aria-expanded="false">
                            <i class="menu-icon fa fa-print"></i>Quản lý hóa đơn
                        </a>

                        <a href="/admin/quanLySanPham/hien-thi" aria-expanded="false">
                            <i class="menu-icon fa fa-print"></i>Quản lý sản phẩm
                        </a>
                    </li>

<%--                    <li class="">--%>
<%--                        <a href="#"> <i class="menu-icon fa fa-pencil-square-o" ></i>Quản lý khách hàng</a>--%>
<%--                    </li>--%>
<%--                    <li class="">--%>
<%--                        <a href="/nhan-vien/hien-thi" > <i class="menu-icon fa fa-users" ></i>Quản lý nhân viên</a>--%>
<%--                    </li>--%>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-leaf" ></i>Quản lý khuyến mãi</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-tag"></i><a href="/dot-khuyen-mai/hien-thi">Đợt giảm giá</a></li>
                            <li><i class="menu-icon fa fa-tags"></i><a href="/phieu-giam-gia/hien-thi">Phiếu giảm giá</a></li>
                        </ul>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="menu-icon fa fa-user"></i>Quản lý tài khoản
                        </a>
                        <ul class="sub-menu children dropdown-menu">
                            <li class="">
                                <a href="/khach-hang/hien-thi">
                                    <i class="fa fa-pencil-square-o"></i>Quản lý khách hàng
                                </a>
                            </li>
                            <li class="">
                                <a href="/nhan-vien/hien-thi">
                                    <i class="fa fa-users"></i>Quản lý nhân viên
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="menu-title">Thống kê</li><!-- /.menu-title -->
                    <li>
                        <a href="/thong-ke" aria-expanded="false"> <i class="menu-icon fa fa-bar-chart-o"></i>Thống kê doanh thu</a>
<%--                        <ul class="sub-menu children dropdown-menu">--%>
<%--                            <li><i class="fa fa-puzzle-piece"></i><a href="ui-buttons.html">Hàng ngày</a></li>--%>
<%--                            <li><i class="fa fa-id-badge"></i><a href="ui-badges.html">Hàng tháng</a></li>--%>
<%--                            <li><i class="fa fa-bars"></i><a href="ui-tabs.html">Hàng năm</a></li>--%>
<%--                        </ul>--%>
                    </li>
                    <li class="menu-title">Bán hàng</li><!-- /.menu-title -->
                    <li class="">
                        <a href="/ban-hang/view"> <i class="menu-icon fa fa-file-text-o"></i>Bán hàng tại quầy</a>
                    </li>


                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
    </aside>
    <!-- /#left-panel -->