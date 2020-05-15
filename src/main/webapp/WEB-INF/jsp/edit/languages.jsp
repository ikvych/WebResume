<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags/edit" %>

<div class="container">
    <div class="row" style="height: 100vh">
        <div class="col-12">
            <resume:tab-header selected="languages"/>
            <div class="card border-top-0">
                <form:form action="/edit/languages" method="post" modelAttribute="languages">
                    <div class="card-body">
                        <h4 class="card-title" style="margin-top: 10px">Level of knowledge of foreign languages</h4>
                        <div id="EditContainer">
                            <c:forEach var="language" items="${languages.items}" varStatus="status">
                                <resume:language index="${status.index}" language="${language}"/>
                            </c:forEach>
                        </div>
                        <div class="row-12">
                            <div class="col-xs-12">
                                <a href="javascript:addSkills()">+ add skills</a>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-dark" style="margin-top: 1em">Save</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<script id="ui-block-template" type="text/x-handlebars-template">
    <resume:language index="{{blockIndex}}"/>
</script>
