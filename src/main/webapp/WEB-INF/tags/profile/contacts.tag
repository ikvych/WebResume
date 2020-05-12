<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" language="java" %>
<jsp:useBean id="profile" scope="request" type="ikvych.resume.entity.Profile"/>

<div class="card mb-3">

    <div class="card-body">

        <div class="row  p-1">
            <div class="col-md-3 col-12" style="margin-bottom: 2%">
                <h4><i class="fa fa-address-book fa-lg" style="color: #727272" aria-hidden="true"></i> Contacts</h4>
            </div>
            <div class="col-md-9 col-12">
                <div class="row">
                    <c:if test="${profile.phone != null}">
                        <div class="col-12 col-md-4">
                            <h6><i class="fa fa-phone contacts"></i> ${profile.phone} </h6>
                        </div>
                    </c:if>
                    <c:if test="${profile.email != null}">
                        <div class="col-12 col-md-4">
                            <h6><i class="fa fa-envelope contacts"></i> ${profile.email} </h6>
                        </div>
                    </c:if>
                    <c:if test="${profile.contacts.skype != null}">
                        <div class="col-12 col-md-4">
                            <h6><i class="fa fa-skype contacts"></i> ${profile.contacts.skype}</h6>
                        </div>
                    </c:if>
                    <c:if test="${profile.contacts.linkedin != null}">
                        <div class="col-12 col-md-4">
                            <a href="https://${profile.contacts.linkedin}"><h6><i class="fa fa-linkedin contacts"></i>
                                    ${profile.contacts.linkedin} </h6></a>
                        </div>
                    </c:if>
                    <c:if test="${profile.contacts.github != null}">
                        <div class="col-12 col-md-4">
                            <a href="https://${profile.contacts.github}">
                                <h6><i class="fa fa-github contacts"></i> ${profile.contacts.github} </h6>
                            </a>
                        </div>
                    </c:if>
                    <c:if test="${profile.contacts.stackoverflow != null}">
                        <div class="col-12 col-md-4">
                            <a href="https://${profile.contacts.stackoverflow}">
                                <h6><i class="fa fa-stack-overflow contacts"></i> ${profile.contacts.stackoverflow}
                                </h6>
                            </a>
                        </div>
                    </c:if>
                    <c:if test="${profile.contacts.facebook != null}">
                        <div class="col-12 col-md-4">
                            <a href="https://${profile.contacts.facebook}">
                                <h6><i class="fa fa-facebook contacts"></i> ${profile.contacts.facebook}</h6>
                            </a>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>

    </div>
</div>