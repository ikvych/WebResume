<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row d-flex justify-content-center" style="margin-top: 5%">
    <div class="col-12 col-lg-5">
        <div class="card">
            <div class="card-header">
                Sign-in
            </div>
            <div class="card-body">
                <form action="sign-in-handler" method="post">
                    <div class="form-group">
                        <label for="uid">User name</label>
                        <input type="text" name="uid" class="form-control" id="uid" aria-describedby="uidHelper">
                        <small id="uidHelper" class="form-text text-muted">We'll never share your email with anyone
                            else.</small>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" name="password" class="form-control" id="password">
                    </div>
                    <div class="form-group form-check">
                        <input type="checkbox" name="remember-me" class="form-check-input" id="exampleCheck1">
                        <label class="form-check-label" for="exampleCheck1">Check me out</label>
                    </div>
                    <div class="form-row d-flex justify-content-between">
                        <button type="submit" class="btn btn-success">Submit</button>
                        <button type="submit" class="btn btn-primary">Sign-in with Facebook</button>
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>


