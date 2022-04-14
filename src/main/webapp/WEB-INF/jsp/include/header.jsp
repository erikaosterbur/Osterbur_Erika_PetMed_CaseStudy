<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PetMed: Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200;400&family=Questrial&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
    <link rel="stylesheet" href="../../../pub/css/register.css">
    <link rel="stylesheet" href="../../../pub/css/index.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
<%--<ul class="nav justify-content-center">--%>
<%--    <li>--%>
<%--        <a href="#">Home</a>--%>
<%--    </li>--%>
<%--    <li>--%>
<%--        <a href="#">Add New Pet</a>--%>
<%--    </li>--%>


    <ul class="nav justify-content-center">
        <li>
            <sec:authorize access="!isAuthenticated()">
                <a href="/index">PetMed</a>
            </sec:authorize>
        </li>
        <li>
            <sec:authorize access="!isAuthenticated()">
                <a href="/login/login">Login</a>
            </sec:authorize>
        </li>
        <li>
            <sec:authorize access="!isAuthenticated()">
                <a href="/register">Register</a>
            </sec:authorize>
        </li>
        <li>
            <sec:authorize access="isAuthenticated()">
                <a href="/user/home">Home</a>
            </sec:authorize>
        </li>
        <li>
            <sec:authorize access="isAuthenticated()">
                <a href="/pet/register">Add New Pet</a>
            </sec:authorize>
        </li>
        <li>
            <sec:authorize access="isAuthenticated()">
                <a href="/vetvisit/register">Add New Vet Visit</a>
            </sec:authorize>
        </li>
        <li>
            <sec:authorize access="isAuthenticated()">
                <a href="/login/logout">Logout</a>
            </sec:authorize>
        </li>
    </ul>





