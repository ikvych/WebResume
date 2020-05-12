<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="resume" tagdir="/WEB-INF/tags/edit" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row" >
        <div class="col-12">
            <resume:tab-header selected="practical" />

            <div class="card border-top-0">
                <form:form action="/edit/practical" method="post" modelAttribute="practicals">
                    <div class="card-body">
                        <h4 class="card-title" style="margin-top: 10px">Practical skills</h4>
                        <c:forEach var="practical" items="${practicals.items}" varStatus="status">
                            <resume:practical index="${status.index}" practical="${practical}"/>
                        </c:forEach>
                        <a href="" class="text-primary">+ add skills</a><br/>
                        <button type="submit" class="btn btn-dark" style="margin-top: 1em">Save</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
