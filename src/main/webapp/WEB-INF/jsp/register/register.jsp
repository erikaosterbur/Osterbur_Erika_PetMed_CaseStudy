<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />
<style>
    h1{
        color: white;
        text-align: center;
        margin: 30px;
    }
</style>

<h1>Register your new account</h1>

<div id="formContainer">
    <div id="formDiv" class="col-4">
            <form action="/registerSubmitUser" method="post" id="petOwnerRegister" class="col-12">
                <div class="mb-3">
                    <input type="email" class="form-control form-control-lg" id="userEmailId" name="email" placeholder="email">
                    <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                        <div style="color: red;">
                                ${error.getDefaultMessage()}
                        </div>
                    </c:forEach>
                    <div class="col-12 m-4 pt-2" id="emailMessage"></div>
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control form-control-lg" id="userFirstNameId" name="firstName" placeholder="first name">
                    <c:forEach items="${bindingResult.getFieldErrors('firstName')}" var="error">
                        <div style="color: red;">
                                ${error.getDefaultMessage()}
                        </div>
                    </c:forEach>
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control form-control-lg" id="userLastNameId" name="lastName" placeholder="last name">
                    <c:forEach items="${bindingResult.getFieldErrors('lastName')}" var="error">
                        <div style="color: red;">
                                ${error.getDefaultMessage()}
                        </div>
                    </c:forEach>
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control form-control-lg" id="userPasswordId" name="password" placeholder="password">
                    <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                        <div style="color: red;">
                                ${error.getDefaultMessage()}
                        </div>
                    </c:forEach>
                    <div class="col-12 m-4 pt-2" id="passwordMessage"></div>
                </div>
                <div class="mb-3">
                    <input onkeyup='check();' type="password" class="form-control form-control-lg" id="userConfirmPasswordId" name="confirmPassword" placeholder="reenter password">
                        <div style="color: red;">
                                ${notMatch}
                        </div>
                </div>
                <div class="col-12 m-4 pt-2" id="message"></div>
                <div class="d-flex justify-content-center">
                    <button type="submit" class="btn btn-dark">Register</button>
                </div>
            </form>
    </div>
</div>



<jsp:include page="../include/footer.jsp" />