<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true"%>
<jsp:directive.include file="/WEB-INF/views/common/taglib.jsp"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8" />
    <title>FIL Casegrapher</title>
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<meta content="IE=edge" http-equiv="X-UA-Compatible" />

	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" />

    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet"><!-- Bootstrap Core CSS -->
    <link href="/bootstrap/css/sb-admin.css" rel="stylesheet"><!-- Custom CSS -->
	<link href="/bootstrap/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"><!-- Custom Fonts -->

	<link rel="stylesheet" type="text/css" media="screen" href="/js/jquery-ui/jquery-ui.css" />

	<script type="text/ecmascript" src="/js/jquery/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="/js/jquery-ui/jquery-ui.min.js"></script>
	
    <script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script><!-- Bootstrap Core JavaScript -->

	<script type="text/javascript" src="/js/ajax.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
</head>
<body>
<div id="wrapper">
	 <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
		    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		    </button>
		    <a class="navbar-brand" href="index.html">SB Admin</a>
		</div>
		
			<%@include file="/WEB-INF/views/admin/_decorators/inc/header.jsp" %>
            <%@include file="/WEB-INF/views/admin/_decorators/inc/lnb.jsp" %>
       </nav>
            <div id="page-wrapper">
            	<div class="container-fluid">
            		<sitemesh:write property="body"/>
            	</div>
            </div>
            <!-- /.navbar-collapse -->
        
</div>
</body>
</html>
