<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<c:if test="${empty form.id}">
    <h1>Create New Vet Visit</h1>
</c:if>

<div id="formContainer">
    <div id="formDiv" class="col-4">
        <form action="/vetVisit/registerSubmitVetVisit" method="post" id="vetVisitRegister">
            <input type="hidden" name="id" value="${form.id}">

            <label for="addPetSelect">Which pet went to the vet?</label>
            <select class="form-select mb-3" id="addPetSelect" name="petId">
                <c:if test="${empty form.id}">
                    <option selected></option>
                </c:if>
                <c:if test="${not empty form.id}">
                    <option selected value="${pet.id}">${pet.name}</option>
                </c:if>
                <!-- Iterates over each pet to populate the dropdown  -->
                <c:forEach items="${pets}" var="pet">
                    <option value="${pet.id}" name="petId">${pet.name}</option>
                </c:forEach>
            </select>
            <c:forEach items="${bindingResult.getFieldErrors('petId')}" var="error">
                <div style="color: red;">
                        ${error.getDefaultMessage()}
                </div>
            </c:forEach>

            <label for="date">Date of Visit</label>
            <input id="date" type="date" name="date" placeholder="Date" class="form-control form-control-lg mb-3" value="${form.date}">
            <c:forEach items="${bindingResult.getFieldErrors('date')}" var="error">
                <div style="color: red;">
                        ${error.getDefaultMessage()}
                </div>
            </c:forEach>

            <input type="text" name="vaccines" placeholder="Vaccines" class="form-control form-control-lg mb-3" value="${form.vaccines}">
            <c:forEach items="${bindingResult.getFieldErrors('vaccines')}" var="error">
                <div style="color: red;">
                        ${error.getDefaultMessage()}
                </div>
            </c:forEach>

            <input type="text" name="notes" placeholder="Notes" class="form-control form-control-lg mb-3" value="${form.notes}">
            <c:forEach items="${bindingResult.getFieldErrors('notes')}" var="error">
                <div style="color: red;">
                        ${error.getDefaultMessage()}
                </div>
            </c:forEach>

            <input type="text" name="weight" placeholder="Weight in lbs" class="form-control form-control-lg mb-3" value="${form.weight}">
            <c:forEach items="${bindingResult.getFieldErrors('weight')}" var="error">
                <div style="color: red;">
                        Enter a valid weight in number form (if your pet was not weighed, put NA)
                </div>
            </c:forEach>

            <label for="addVetSelect">Which vet did your pet see?</label>
            <select class="form-select mb-3" id="addVetSelect" name="vetId">
                <c:if test="${empty form.id}">
                    <option selected></option>
                </c:if>
                <c:if test="${not empty form.id}">
                    <option selected value="${vet.id}">${vet.firstName} ${vet.lastName}</option>
                </c:if>
                <!-- Iterates over each vet to populate the dropdown  -->
                <c:forEach items="${vets}" var="vet">
                    <option value="${vet.id}" name="vetId">${vet.firstName} ${vet.lastName} - ${vet.clinic}</option>
                </c:forEach>
            </select>
            <c:forEach items="${bindingResult.getFieldErrors('vetId')}" var="error">
                <div style="color: red;">
                        ${error.getDefaultMessage()}
                </div>
            </c:forEach>

            <button type="submit" class="btn btn-dark">Save Vet Visit</button>
        </form>
    </div>
</div>

<jsp:include page="../include/footer.jsp" />