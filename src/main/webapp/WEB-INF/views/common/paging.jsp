<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/views/common/taglib.jsp"/>
 
<c:set var="page" value="1" />
<c:if test="${!empty currentPage}"><c:set var="page" value="${currentPage}" /></c:if>
<c:set var="indexPerPage" value="10" />
<c:if test="${!empty indexPerPage}"><c:set var="indexPerPage" value="${indexPerPage}" /></c:if>
<div class="paging">
    <custom:paging name="paging" recordsPerPage="${recordsPerPage}" totalRecordCount="${totalRecordCount}" currentPage="${page}" indexPerPage="${indexPerPage}">
        <%-- First --%>
        <c:if test="${!empty paging.firstPage.href}">
            <span class="btn"><a href="${paging.firstPage.href}" class="first">처음</a></span>
        </c:if>
 
        <%-- Prev --%>
        <c:if test="${!empty paging.previousPage.href}">
            <span class="btn"><a href="${paging.previousPage.href}" class="prev">이전</a> </span>
        </c:if>
 
        <%-- Numbering --%>
        <span class="num">
            <c:forEach var="numbering" items="${paging.pages}" varStatus="status">
              <c:choose>
                <c:when test="${numbering.index eq paging.currentPage}">
                    <strong class="on">${numbering.index}</strong>
                </c:when>
    
                <c:otherwise>
                    <a href="${numbering.href}" title="${numbering.index} 페이지">${numbering.index}</a>
                </c:otherwise>
              </c:choose>
            </c:forEach>
        </span>
        
        <%-- Next --%>
        <c:if test="${!empty paging.nextPage.href}">
            <span class="btn"><a href="${paging.nextPage.href}" class="next">다음</a></span>
        </c:if>
 
        <%-- Last --%>
        <c:if test="${!empty paging.lastPage.href}">
            <span class="btn"><a href="${paging.lastPage.href}" class="last">마지막</a></span>
        </c:if>
    </custom:paging>
</div>
	