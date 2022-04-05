<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="formContainer">
    <div id="formDiv" class="col-4">
        <h2>Already have an account?</h2>
        <form class="col-12" id="loginForm">
            <div class="mb-3">
                <input type="text" class="form-control form-control-lg" id="emailInput" placeholder="email">
            </div>
            <div class="mb-3">
                <input type="password" class="form-control form-control-lg" id="passwordInput" placeholder="password">
            </div>
            <button type="submit" class="btn btn-dark">Login</button>
        </form>
    </div>
</div>