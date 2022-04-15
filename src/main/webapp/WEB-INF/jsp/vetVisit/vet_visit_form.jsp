<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../include/header.jsp" />

<style>
    h1{
        color: white;
        text-align: center;
        margin: 30px;
    }
</style>

<c:if test="${empty form.id}">
    <h1>Create New Vet Visit</h1>
</c:if>

<c:if test="${not empty form.id}">
    <h1>Edit Vet Visit</h1>
</c:if>

<div id="formContainer">
    <div id="formDiv" class="col-4">
        <form action="/vetvisit/registerSubmitVetVisit" method="post">
            <input type="hidden" name="id" value="${form.id}">
            <select class="form-select mb-3" id="addPetSelect" name="petId">
                <c:if test="${empty form.id}">
                    <option selected>Choose Pet...</option>
                </c:if>
                <c:if test="${not empty form.id}">
                    <option selected value="${pet.id}">${pet.name}</option>
                </c:if>
                <!-- Iterates over each pet to populate the dropdown  -->
                <c:forEach items="${pets}" var="pet">
                    <option value="${pet.id}" name="petId">${pet.name}</option>
                </c:forEach>
            </select>
            <label for="date">Date of Visit</label>
            <input id="date" type="date" name="date" placeholder="Date" class="form-control form-control-lg mb-3" value="${form.date}">
            <input type="text" name="vaccines" placeholder="Vaccines" class="form-control form-control-lg mb-3" value="${form.vaccines}">
            <input type="text" name="notes" placeholder="Notes" class="form-control form-control-lg mb-3" value="${form.notes}">
            <input type="text" name="weight" placeholder="Weight in lbs" class="form-control form-control-lg mb-3" value="${form.weight}">
            <select class="form-select mb-3" id="addVetSelect" name="vetId">
                <c:if test="${empty form.id}">
                    <option selected>Which vet did your pet see?</option>
                </c:if>
                <c:if test="${not empty form.id}">
                    <option selected value="${vet.id}">${vet.firstName} ${vet.lastName}</option>
                </c:if>
                <!-- Iterates over each vet to populate the dropdown  -->
                <c:forEach items="${vets}" var="vet">
                    <option value="${vet.id}" name="vetId">${vet.firstName} ${vet.lastName} - ${vet.clinic}</option>
                </c:forEach>
            </select>

            <button type="submit" class="btn btn-dark">Save Vet Visit</button>
        </form>
    </div>
</div>



<jsp:include page="../include/footer.jsp" />