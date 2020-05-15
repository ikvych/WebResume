<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" language="java" %>
<jsp:useBean id="profile" scope="request" type="ikvych.resume.entity.Profile"/>


<div class="card " style="margin-top: 1em">
    <div class="card-body">
        <div class="row">
            <div class="col-md-3 col-12" style="margin-bottom: 2%">
                <div class="btn-group">
                    <i class="fa fa-info-circle fa-2x" style="color: #727272"></i><a class="text-dark" style="margin-left: 1em" href="/edit/profile"><h4> Info</h4></a>
                </div>
            </div>
            <div class="col-md-9 col-12">
                <div class="card-body p-2">
                    <div class="card-text ">
                        <c:if test="${profile.city != null && profile.country != null}">
                        <p>${profile.city}, ${profile.country}</p>
                        </c:if>
                        <c:if test="${profile.age != null && profile.birthDay != null}">
                        <p>Age:${profile.age}, BirthDay:${profile.birthDay}</p>
                        </c:if>
                        <c:if test="${profile.info != null}">
                        <p>${profile.info}</p>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>