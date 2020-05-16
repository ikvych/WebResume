<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row col-12">
    <p>Найдено <strong>${page.totalElements }</strong> профилей</p>
</div>
<jsp:include page="search.jsp"/>
