<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" href="/media/fav/favicon.ico" type="image/x-icon">
    <title>WebResume</title>
    <jsp:include page="../section/css.jsp" />
</head>
<body>
<jsp:include page="../section/header.jsp" />
<jsp:include page="../section/nav.jsp" />
<section class="main">
    <sitemesh:write property='body' />
</section>
<jsp:include page="../section/footer.jsp" />
<jsp:include page="../section/js.jsp" />
</body>
</html>
