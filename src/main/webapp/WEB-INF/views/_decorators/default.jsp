<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true"%>
<jsp:directive.include file="/WEB-INF/views/common/taglib.jsp"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8" />
    <title>PS&M Casegrapher</title>
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<meta content="IE=edge" http-equiv="X-UA-Compatible" />

	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" />
	<link rel="stylesheet" href="/css/style.css" />
	<link rel="stylesheet" href="/css/theme/default.css" id="theme" />
	<link rel="stylesheet" href="/css/font-awesome/css/font-awesome.css" /><!-- 폰트는 호출 경로와 사용 경로가 같아야 함. -->
	<link rel="stylesheet" href="/js/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/js/bootstrap/css/bootstrap-theme.min.css" />
	<link rel="stylesheet" href="/css/caseoclock.css" />
	<link rel="stylesheet" type="text/css" media="screen" href="/resources/js/jquery-ui/jquery-ui.css" />

	<script type="text/ecmascript" src="/js/jquery/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="/js/jquery-ui/jquery-ui.js"></script>
	<script type="text/javascript" src="/js/jquery-ui/jquery-ui.min.js"></script>
	
	<script type="text/javascript" src="/js/bootstrap/js/bootstrap.min.js"></script>

	<script type="text/javascript" src="/js/ajax.js"></script>
	<script type="text/javascript" src="/js/pace/pace.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
</head>
<body data-spy="scroll" class="pace-done">
	<div class="pace  pace-inactive hide pace-inactive">
		<div class="pace-progress" data-progress-text="100%" data-progress="99" style="width: 100%;">
			<div class="pace-progress-inner"></div>
		</div>
		<div class="pace-activity"></div>
	</div>
	<div id="page-loader" class="fade in hide">
		<span class="spinner"></span>
	</div>
	<div id="page-container" class="fade page-sidebar-fixed page-header-fixed in">
		<%@include file="/WEB-INF/views/_decorators/inc/header.jsp" %>
		<%@include file="/WEB-INF/views/_decorators/inc/gnb.jsp" %>
		<%@include file="/WEB-INF/views/_decorators/inc/lnb.jsp" %>
		<div class="container" id="ajax-content">
		<sitemesh:write property="body"/>
		</div>
		<%-- begin scroll to top btn - 사용시 fade class 제거 --%>
		<a href="javascript:;" class="btn btn-icon btn-circle btn-success btn-scroll-to-top fade" data-click="scroll-top"><i class="fa fa-angle-up"></i></a>
	</div>
</body>
</html>