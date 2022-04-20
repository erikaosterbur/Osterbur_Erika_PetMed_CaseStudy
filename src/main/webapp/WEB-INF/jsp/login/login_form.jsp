<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<h1>Welcome Back!</h1>
<div id="formContainer">
    <div id="formDiv" class="col-4">
        <h2>Login</h2>
        <form class="col-12" id="loginForm" action="/login/loginSubmit" method="post">
            <div class="mb-3">
                <input type="text" class="form-control form-control-lg" id="emailInput" placeholder="email" name="username">
            </div>
            <div class="mb-3">
                <input type="password" class="form-control form-control-lg" id="passwordInput" placeholder="password" name="password">
            </div>
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-dark">Login</button>
            </div>
        </form>
    </div>
</div>

<jsp:include page="../include/footer.jsp" />
