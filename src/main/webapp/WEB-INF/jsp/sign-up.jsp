<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row d-flex justify-content-center" style="margin-top: 5%">
    <div class="col-12 col-lg-5">
        <div class="card">
            <div class="card-header">
                Sign-in
            </div>
            <div class="card-body">
                <form:form action="sign-up" method="post" modelAttribute="signUpForm">
                    <div class="form-group">
                        <label for="firstName">First name</label>
                        <input type="text" name="firstName" class="form-control" id="firstName" aria-describedby="firstNameHelper">
                        <form:errors path="firstName" cssClass="alert alert-danger" element="div"/>
                        <small id="firstNameHelper" class="form-text text-muted">We'll never share your email with anyone
                            else.</small>
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last name</label>
                        <input type="text" name="lastName" class="form-control" id="lastName" aria-describedby="lastNameHelper">
                        <form:errors path="lastName" cssClass="alert alert-danger" element="div"/>
                        <small id="lastNameHelper" class="form-text text-muted">We'll never share your email with anyone
                            else.</small>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" name="password" class="form-control" id="password">
                        <form:errors path="password" cssClass="alert alert-danger" element="div"/>
                    </div>
                    <div class="form-group">
                        <label for="passwordConfirm">Password</label>
                        <input type="password" name="passwordConfirm" class="form-control" id="passwordConfirm">
                        <form:errors path="passwordConfirm" cssClass="alert alert-danger" element="div"/>
                    </div>
                    <div class="form-row d-flex justify-content-between">
                        <button type="submit" class="btn btn-success">Submit</button>
                        <button type="submit" class="btn btn-primary">Sign-up with Facebook</button>
                    </div>
                </form:form>
            </div>
        </div>

    </div>
</div>


