<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/views/common/taglib.jsp"/>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>오늘의 소개팅 목록</title>
<style>
* {margin: 0; padding: 0;}
 
div.mainContent {
  margin: 20px;
}
 
ul {
  list-style-type: none;
  width: 500px;
}
 
h3 {
  font: bold 20px/1.5 Helvetica, Verdana, sans-serif;
}
 
li img {
  float: left;
  margin: 0 15px 0 0;
}
 
/* li p { */
  font: 200 12px/1.5 Verdana, Times New Roman, serif;
}
 
li {
  padding: 10px;
  overflow: auto;
}
 
li:hover {
  background: #eee;
  cursor: pointer;
}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/user/inc/header.jsp" flush="false" />
<div class="mainContent">
<c:out escapeXml="true" value="${todayList}"/>
	<ul>
		<li>
   			<img style="width: 180; height: 180;" src="/upload/human1.jpg" />
	     	<h3>lovemoongi</h3>
	     	<p>서울</p>
	     	<p>기획자</p>
	     	<p>165</p>
   		</li>
	</ul>
</div>
<jsp:include page="/WEB-INF/views/user/inc/footer.jsp" flush="false" />
</body>
</html>