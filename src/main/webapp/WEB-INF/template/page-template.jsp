<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" href="/static/favicon.ico" type="image/x-icon">
    <title>WebResume</title>
    <jsp:include page="../section/css.jsp" />
</head>
<body>
<section class="container-xl container-fluid p-0">
    <jsp:include page="../section/header.jsp" />
</section>
<jsp:include page="../section/nav.jsp" />
<section class="container-xl container-fluid p-0">
    <sitemesh:write property='body' />
</section>
<jsp:include page="../section/footer.jsp" />
<jsp:include page="../section/js.jsp" />
<sitemesh:write property='page.js-init' />
</body>
</html>