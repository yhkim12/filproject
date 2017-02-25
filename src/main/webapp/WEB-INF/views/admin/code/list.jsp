<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/views/common/taglib.jsp"/>

<script>


console.log('${totalRecordCount}');
</script>

<c:forEach varStatus="status" var="list" items="${codeList}">
aaa
	${list.cd}, ${list.up_cd}, ${list.cd_nm}
</c:forEach>
	
<jsp:directive.include file="/WEB-INF/views/common/paging.jsp"/>
