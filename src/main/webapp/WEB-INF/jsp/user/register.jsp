<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<%--<div id="formContainer">--%>
<%--    <div id="formDiv" class="col-4">--%>
<%--            <ul class="tab-group">--%>
<%--                <li class="tab active"><a href="#petOwnerRegister">Pet Owner Registration</a></li>--%>
<%--                <li class="tab"><a href="#vetRegister">Veterinarian Registration</a></li>--%>
<%--            </ul>--%>
<%--        <form action="/user/registerSubmit" method="post" id="petOwnerRegister" class="col-12 needs-validation" novalidate>--%>
<%--            <div class="mb-3">--%>
<%--                <input type="email" class="form-control form-control-lg" id="userEmailId" name="email" placeholder="email">--%>
<%--                <div class="invalid-feedback">Please provide a valid email</div>--%>
<%--            </div>--%>
<%--            <div class="mb-3">--%>
<%--                <input type="text" class="form-control form-control-lg" id="userFirstNameId" name="firstName" placeholder="first name" required>--%>
<%--                <div class="invalid-feedback">Please provide a first name</div>--%>
<%--            </div>--%>
<%--            <div class="mb-3">--%>
<%--                <input type="text" class="form-control form-control-lg" id="userLastNameId" name="lastName" placeholder="last name" required>--%>
<%--                <div class="invalid-feedback">Please provide a last name</div>--%>
<%--            </div>--%>
<%--            <div class="mb-3">--%>
<%--                <input type="password" class="form-control form-control-lg" id="userPasswordId" name="password" placeholder="password" required>--%>
<%--                <div class="invalid-feedback">Please provide a password</div>--%>
<%--            </div>--%>
<%--            <div class="mb-3">--%>
<%--                <input onkeyup='check();' type="password" class="form-control form-control-lg" id="userConfirmPasswordId" name="confirmPassword" placeholder="reenter password" required>--%>
<%--            </div>--%>
<%--            <div class="col-12 m-4 pt-2" class="message"></div>--%>
<%--            <button type="submit" class="btn btn-dark">Register</button>--%>
<%--        </form>--%>
<%--        <form action="/user/registerSubmit" method="post" id="vetRegister" class="col-12 needs-validation" novalidate>--%>
<%--            <div class="mb-3">--%>
<%--                <input type="email" class="form-control form-control-lg" id="vetEmailId" name="email" placeholder="email">--%>
<%--                <div class="invalid-feedback">Please provide a valid email</div>--%>
<%--            </div>--%>
<%--            <div class="mb-3">--%>
<%--                <input type="text" class="form-control form-control-lg" id="vetFirstNameId" name="firstName" placeholder="first name" required>--%>
<%--                <div class="invalid-feedback">Please provide a first name</div>--%>
<%--            </div>--%>
<%--            <div class="mb-3">--%>
<%--                <input type="text" class="form-control form-control-lg" id="vetLastNameId" name="lastName" placeholder="last name" required>--%>
<%--                <div class="invalid-feedback">Please provide a last name</div>--%>
<%--            </div>--%>
<%--            <div class="mb-3">--%>
<%--                <input type="text" class="form-control form-control-lg" id="vetClinicId" name="clinic" placeholder="clinic name" required>--%>
<%--                <div class="invalid-feedback">Please provide a clinic name</div>--%>
<%--            </div>--%>
<%--            <div class="mb-3">--%>
<%--                <input type="password" class="form-control form-control-lg" id="vetPasswordId" name="password" placeholder="password" required>--%>
<%--                <div class="invalid-feedback">Please provide a password</div>--%>
<%--            </div>--%>
<%--            <div class="mb-3">--%>
<%--                <input onkeyup='check();' type="password" class="form-control form-control-lg" id="vetConfirmPasswordId" name="confirmPassword" placeholder="reenter password" required>--%>
<%--            </div>--%>
<%--            <div class="col-12 m-4 pt-2" class="message"></div>--%>
<%--            <button type="submit" class="btn btn-dark">Register</button>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>

<section class="loginWrapper">

    <ul class="tabs">
        <li class="active">Pet Owner</li>
        <li>Veterinarian</li>
    </ul>

    <ul class="tab__content">

        <li class="active">
            <div class="content__wrapper">
                <form method="POST" action="/user/registerSubmitUser">
                    <input type="name" name="firstName" placeholder="First Name">
                    <input type="name" name="lastName" placeholder="Last Name">
                    <input type="email" name="email" placeholder="email">
                    <input type="pass" name="password" placeholder="Password">
                    <input type="repass" name="confirmPassword" placeholder="Confirm Password">
                    <input type="submit" value="Register" name="register">
                </form>
            </div>
        </li>

        <li>
            <div class="content__wrapper">
                <form method="POST" action="/user/registerSubmitVet">
                    <input type="name" name="firstName" placeholder="First Name">
                    <input type="name" name="lastName" placeholder="Last Name">
                    <input type="email" name="email" placeholder="email">
                    <input type="name" name="clinic" placeholder="Clinic Name">
                    <input type="pass" name="password" placeholder="Password">
                    <input type="repass" name="confirmPassword" placeholder="Confirm Password">
                    <input type="submit" value="Register" name="register">
                </form>
            </div>
        </li>

    </ul>

</section>


<jsp:include page="../include/footer.jsp" />

