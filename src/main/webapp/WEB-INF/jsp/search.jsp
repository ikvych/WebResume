<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row profiles">
    <div id="profileContainer" class="col-12" data-profile-total="${page.totalPages }" data-profile-number="${page.number}">
        <jsp:include page="fragment/profile-list.jsp" />
    </div>
    <div class="col-12 text-center">
        <c:if test="${page.number < page.totalPages - 1}">
            <div id="loadMoreContainer" class="col-xs-12 text-center">
                <a href="javascript:moreProfiles('${query}');" class="btn btn-primary">Load more</a>
            </div>
            <div id="loadMoreIndicator" class="col-xs-12 text-center" style="display:none;">
                <img src="<c:url value="/static/large-loading_v1.gif"/>" alt="loading..."/>
            </div>
        </c:if>
    </div>
</div>