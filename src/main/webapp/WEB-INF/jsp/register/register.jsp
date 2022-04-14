<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../include/header.jsp" />

<div id="formContainer">
    <div id="formDiv" class="col-4">
        <h2>Register Your New Account</h2>
            <div class="content__wrapper">
                <form action="/registerSubmitUser" method="post" id="petOwnerRegister" class="col-12 needs-validation" novalidate>
                    <div class="mb-3">
                        <input type="email" class="form-control form-control-lg" id="userEmailId" name="email" placeholder="email">
                        <div class="invalid-feedback">Please provide a valid email</div>
                    </div>
                    <div class="mb-3">
                        <input type="text" class="form-control form-control-lg" id="userFirstNameId" name="firstName" placeholder="first name" required>
                        <div class="invalid-feedback">Please provide a first name</div>
                    </div>
                    <div class="mb-3">
                        <input type="text" class="form-control form-control-lg" id="userLastNameId" name="lastName" placeholder="last name" required>
                        <div class="invalid-feedback">Please provide a last name</div>
                    </div>
                    <div class="mb-3">
                        <input type="password" class="form-control form-control-lg" id="userPasswordId" name="password" placeholder="password" required>
                        <div class="invalid-feedback">Please provide a password</div>
                    </div>
                    <div class="mb-3">
                        <input onkeyup='check();' type="password" class="form-control form-control-lg" id="userConfirmPasswordId" name="confirmPassword" placeholder="reenter password" required>
                    </div>
                    <div class="col-12 m-4 pt-2" id="message"></div>
                    <div class="d-flex justify-content-center">
                        <button type="submit" class="btn btn-dark">Register</button>
                    </div>
                </form>
            </div>
    </div>
</div>



<jsp:include page="../include/footer.jsp" />