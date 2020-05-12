<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags/edit" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row" >
        <div class="col-12">
            <resume:tab-header selected="skills" />

            <div class="card border-top-0">
                <form:form action="/edit/skills" method="post" modelAttribute="skills">
                    <div class="card-body">
                        <h4 class="card-title" style="margin-top: 10px">Practical skills</h4>
                        <c:forEach var="skill" items="${skills.items}" varStatus="status">
                            <resume:skills index="${status.index}" skill="${skill}"/>
                        </c:forEach>
                        <a href="" class="text-primary">+ add skills</a><br/>
                        <button type="submit" class="btn btn-dark" style="margin-top: 1em">Save</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
