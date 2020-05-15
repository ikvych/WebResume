<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags/edit" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<resume:tab-header selected="skills"/>

<div class="card border-top-0">
    <form:form action="/edit/skills" method="post" modelAttribute="skills">
        <div class="card-body">
            <div class="row-12 text-center">
                <h4 class="card-title" style="margin-top: 10px">Practical skills</h4>
            </div>
            <div id="EditContainer">
                <c:forEach var="skill" items="${skills.items}" varStatus="status">
                    <resume:skills index="${status.index}" skill="${skill}"/>
                </c:forEach>
            </div>
            <div class="row-12">
                <div class="col-xs-12">
                    <a href="javascript:addSkills()">+ add skills</a>
                </div>
            </div>
            <div class="row-12">
                <button type="submit" class="btn btn-dark" style="margin-top: 1em">Save</button>
            </div>
        </div>
    </form:form>
</div>

<script id="ui-block-template" type="text/x-handlebars-template">
    <resume:skills index="{{blockIndex}}"/>
</script>
