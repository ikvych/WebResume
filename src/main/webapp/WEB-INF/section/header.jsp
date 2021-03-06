<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="/">
        <i class="d-inline-block align-top fa fa-address-book-o fa-lg"></i>
        Bootstrap
    </a>
    <form class="form-inline" action="/search" method="get">
        <input class="form-control mr-sm-2" name="query" type="search" value="${query}" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    <a href="/sign-in" class="btn btn-outline-success my-2 my-sm-0" type="submit">Sign-in</a>
    <a href="/sign-up" class="btn btn-outline-success my-2 my-sm-0" type="submit">Sign-up</a>
</nav>

