<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" language="java" %>

<div class="card mb-3">
    <img src="<c:url value="/media/coverPhoto/1365475066city-lights-and-brigde-at-night.jpg"/>"
         class="card-img-top backGroundPhoto" alt="image">
    <div class="d-flex justify-content-center" style="padding-left: 3%; padding-right: 3%">
        <div class="col-5 col-md-3 userPhotoCol">
            <img src="<c:url value="/media/avatar/96809630-3b4c-4963-9010-411262d162bc.jpg"/>"
                 class="rounded-circle userPhoto" alt="image">
        </div>
        <%--        <div class="col-sm-4 col-4 d-sm-none border userPhotoCol">
                    <img src="<c:url value="/media/avatar/96809630-3b4c-4963-9010-411262d162bc.jpg"/>"
                         class="rounded-circle userPhoto-sm" alt="image">
                </div>--%>
        <div class="col d-none d-md-block" style="margin-top: -6%">
            <h2 class="userName">John Kvych</h2>
        </div>
    </div>

    <div class="card-body">
        <div class="row">
            <div class="col d-md-none text-center">
                <h2 class="userName-md">John Kvych</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-3 d-none d-md-block">
            </div>
            <div class="col-12 col-sm-8 p-4 d-none d-md-block" style="margin-top: -9%">
                <h4>Junior Java Developer</h4>
                <span>One Java professional course with developing web application blog (Link to demo is provided)</span>
            </div>
        </div>
        <div class="row">
            <div class="col-12 d-md-none">
                <h4 class="text-center">Junior Java Developer</h4>
                <span>One Java professional course with developing web application blog (Link to demo is provided)</span>
            </div>
        </div>
    </div>
</div>



