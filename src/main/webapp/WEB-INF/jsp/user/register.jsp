<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="formContainer">
    <div id="formDiv" class="col-4">
        <h2>New here?</h2>
        <form action="/user/registerSubmit" method="post" id="registerForm" class="col-12 needs-validation" novalidate>
            <div class="mb-3">
                <input type="email" class="form-control form-control-lg" id="emailId" name="email" placeholder="email" required>
                <div class="invalid-feedback">Please provide a valid email</div>
            </div>
            <div class="mb-3">
                <input type="text" class="form-control form-control-lg" id="firstNameId" name="firstName" placeholder="first name" required>
                <div class="invalid-feedback">Please provide a first name</div>
            </div>
            <div class="mb-3">
                <input type="text" class="form-control form-control-lg" id="lastNameId" name="lastName" placeholder="last name" required>
                <div class="invalid-feedback">Please provide a last name</div>
            </div>
            <div class="mb-3">
                <input type="password" class="form-control form-control-lg" id="passwordId" name="password" placeholder="password" required>
                <div class="invalid-feedback">Please provide a password</div>
            </div>
            <div class="mb-3">
                <input onkeyup='check();' type="password" class="form-control form-control-lg" id="confirmPasswordId" name="confirmPassword" placeholder="reenter password" required>
            </div>
            <div class="col-12 m-4 pt-2" id="message"></div>
            <button type="submit" class="btn btn-dark">Register</button>
        </form>
    </div>
</div>

