<jsp:useBean id="profile" scope="request" type="ikvych.resume.entity.Profile"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" language="java" %>

<div class="card mb-3">
    <img src="<c:url value="/static/1365475066city-lights-and-brigde-at-night.jpg"/>"
         class="card-img-top backGroundPhoto" alt="image">
    <div class="d-flex justify-content-center" style="padding-left: 3%; padding-right: 3%">
        <div class="col-5 col-md-3 userPhotoCol">
            <img src="<c:url value="${profile.largePhoto}"/>"
                 class="rounded-circle userPhoto" alt="image">
        </div>
        <div class="col d-none d-md-block" style="margin-top: -6%">
            <h2 class="userName">${profile.firstName} ${profile.lastName}</h2>
        </div>
    </div>

    <div class="card-body">
        <div class="row">
            <div class="col d-md-none text-center">
                <h2 class="userName-md">${profile.firstName} ${profile.lastName}</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-3 d-none d-md-block">
            </div>
            <div class="col-12 col-sm-8 p-4 d-none d-md-block" style="margin-top: -9%">
                <h4>${profile.objective}</h4>
                <span>${profile.summary}</span>
            </div>
        </div>
        <div class="row">
            <div class="col-12 d-md-none">
                <h4 class="text-center">${profile.objective}</h4>
                <span>${profile.summary}</span>
            </div>
        </div>
    </div>
</div>



