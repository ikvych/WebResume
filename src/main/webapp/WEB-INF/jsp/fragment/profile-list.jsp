<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach var="profile" items="${profiles}">
    <div class="card">
        <div class="row no-gutters">
            <div class="col-md-2">
                <a href="/${profile.uid }">
                    <img alt="${profile.firstName} ${profile.lastName}" src="${profile.smallPhoto }" class="photo">
                </a>
            </div>
            <div class="col-md-10">
                <div class="card-body">
                    <div class="card-title d-flex justify-content-between">
                        <h5>${profile.firstName} ${profile.lastName}</h5>
                        <a href="/${profile.uid}" class="btn btn-primary visible-xs-block" style="margin-top: 15px;">Детали</a>
                    </div>
                    <strong>${profile.objective }</strong>
                    <p>${profile.city },${profile.country }</p>
                    <blockquote>
                        <small>${profile.summary }</small>
                    </blockquote>
                </div>
            </div>
        </div>
    </div>
</c:forEach>