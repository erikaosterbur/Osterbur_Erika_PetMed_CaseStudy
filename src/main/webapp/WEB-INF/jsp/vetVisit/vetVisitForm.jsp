<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../include/header.jsp" />

<h1>Create a New Vet Visit</h1>

<div id="formContainer">
    <div id="formDiv" class="col-4">
        <form action="/vetvisit/registerSubmitVetVisit" method="post">
            <select class="form-select mb-3" id="addPetSelect" name="petId">
                <option selected>Choose Pet...</option>
                <!-- Iterates over each pet to populate the dropdown  -->
                <c:forEach items="${pets}" var="pet">
                    <option value="${pet.id}" name="petId">${pet.name}</option>
                </c:forEach>
            </select>
            <input type="date" name="date" placeholder="Date" class="form-control form-control-lg mb-3">
            <input type="text" name="vaccines" placeholder="Vaccines" class="form-control form-control-lg mb-3">
            <input type="text" name="notes" placeholder="Notes" class="form-control form-control-lg mb-3">
            <input type="text" name="weight" placeholder="Weight" class="form-control form-control-lg mb-3">
            <select class="form-select mb-3" id="addVetSelect" name="vetId">
                <option selected>Which vet did your animal see?</option>
                <!-- Iterates over each vet to populate the dropdown  -->
                <c:forEach items="${vets}" var="vet">
                    <option value="${vet.id}" name="vetId">${vet.firstName} ${vet.lastName}</option>
                </c:forEach>
            </select>

            <button type="submit" class="btn btn-dark">Save New Vet Visit</button>
        </form>
    </div>
</div>



<jsp:include page="../include/footer.jsp" />