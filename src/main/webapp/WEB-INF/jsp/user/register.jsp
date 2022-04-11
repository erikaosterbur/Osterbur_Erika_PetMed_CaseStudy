<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<h1>Welcome! Register Your Account Below</h1>

<div id="formContainer">
    <div id="formDiv" class="col-4">
            <div class="content__wrapper">
                <form action="/user/registerSubmitUser" method="post" id="petOwnerRegister" class="col-12 needs-validation" novalidate>
                    <ul class="tab-group">
                        <li class="petOwner active">Pet Owner</li>
                        <li class="vet">Veterinarian</li>
                    </ul>
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
                    <div class="col-12 m-4 pt-2" id="message1"></div>
                    <button type="submit" class="btn btn-dark">Register</button>
                </form>
            </div>

            <div class="content__wrapper">
                <form action="/user/registerSubmitVet" method="post" id="vetRegister" class="col-12 needs-validation" style="display: none;" novalidate>
                    <ul class="tab-group">
                        <li class="petOwner">Pet Owner</li>
                        <li class="active vet">Veterinarian</li>
                    </ul>
                    <div class="mb-3">
                        <input type="email" class="form-control form-control-lg" id="vetEmailId" name="email" placeholder="email">
                        <div class="invalid-feedback">Please provide a valid email</div>
                    </div>
                    <div class="mb-3">
                        <input type="text" class="form-control form-control-lg" id="vetFirstNameId" name="firstName" placeholder="first name" required>
                        <div class="invalid-feedback">Please provide a first name</div>
                    </div>
                    <div class="mb-3">
                        <input type="text" class="form-control form-control-lg" id="vetLastNameId" name="lastName" placeholder="last name" required>
                        <div class="invalid-feedback">Please provide a last name</div>
                    </div>
                    <div class="mb-3">
                        <input type="text" class="form-control form-control-lg" id="vetClinicId" name="clinic" placeholder="clinic name" required>
                        <div class="invalid-feedback">Please provide a clinic name</div>
                    </div>
                    <div class="mb-3">
                        <input type="password" class="form-control form-control-lg" id="vetPasswordId" name="password" placeholder="password" required>
                        <div class="invalid-feedback">Please provide a password</div>
                    </div>
                    <div class="mb-3">
                        <input onkeyup='check();' type="password" class="form-control form-control-lg" id="vetConfirmPasswordId" name="confirmPassword" placeholder="reenter password" required>
                    </div>
                    <div class="col-12 m-4 pt-2" id="message2"></div>
                    <button type="submit" class="btn btn-dark">Register</button>
                </form>
            </div>
    </div>
</div>

<script src="../../../pub/js/register.js"></script>
<jsp:include page="../include/footer.jsp" />

