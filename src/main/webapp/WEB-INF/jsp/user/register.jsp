<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<div id="formContainer">
    <div id="formDiv" class="col-4">
        <form action="/user/registerSubmit" method="post" id="registerForm" class="col-12 needs-validation" novalidate>
            <h3>I am a...</h3>
            <div class="mb-3 form-check form-check-inline">
                <input value="user" type="radio" id="typeIdUser" name="user" class="form-check-input">
                <label class="form-check-label" for="typeIdUser">
                    Pet Owner
                </label>
            </div>
            <div class="mb-3 form-check form-check-inline">
                <input value="vet" type="radio" id="typeIdVet" name="vet" class="form-check-input">
                <label class="form-check-label" for="typeIdVet">
                    Veterinarian
                </label>
            </div>
            <div class="mb-3">
                <input type="email" class="form-control form-control-lg" id="emailId" name="email" placeholder="email">
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



<jsp:include page="../include/footer.jsp" />

