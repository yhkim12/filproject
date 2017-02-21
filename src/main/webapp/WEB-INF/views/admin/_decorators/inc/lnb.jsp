<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true"%>
<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li id="lnb_li_member">
                        <a href="/admin/member/list"><i class="fa fa-fw fa-dashboard"></i> 회원정보</a>
                    </li>
                    <li id="lnb_li_board" class="active">
                        <a href="/admin/board/list"><i class="fa fa-fw fa-bar-chart-o"></i> 게시판</a>
                    </li>
                    <!-- 
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo" class="" aria-expanded="true"><i class="fa fa-fw fa-arrows-v"></i> Dropdown <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse in" aria-expanded="true">
                            <li>
                                <a href="#">Dropdown Item</a>
                            </li>
                            <li>
                                <a href="#">Dropdown Item</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="tables.html"><i class="fa fa-fw fa-table"></i> Tables</a>
                    </li>
                    <li>
                        <a href="forms.html"><i class="fa fa-fw fa-edit"></i> Forms</a>
                    </li>
                    <li>
                        <a href="bootstrap-elements.html"><i class="fa fa-fw fa-desktop"></i> Bootstrap Elements</a>
                    </li>
                    <li>
                        <a href="bootstrap-grid.html"><i class="fa fa-fw fa-wrench"></i> Bootstrap Grid</a>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo" class="" aria-expanded="true"><i class="fa fa-fw fa-arrows-v"></i> Dropdown <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse in" aria-expanded="true">
                            <li>
                                <a href="#">Dropdown Item</a>
                            </li>
                            <li>
                                <a href="#">Dropdown Item</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="blank-page.html"><i class="fa fa-fw fa-file"></i> Blank Page</a>
                    </li>
                    <li>
                        <a href="index-rtl.html"><i class="fa fa-fw fa-dashboard"></i> RTL Dashboard</a>
                    </li> -->
                </ul>
            </div>
            
<script>

//lnb active, remove
var url = $(location).attr('href');
$('li[id^=lnb_li_]').removeClass();
if (url.indexOf('/member/') > 0) {
	$('#lnb_li_member').addClass('active');
} else if (url.indexOf('/board/') > 0) {
	$('#lnb_li_board').addClass('active');
}

</script>