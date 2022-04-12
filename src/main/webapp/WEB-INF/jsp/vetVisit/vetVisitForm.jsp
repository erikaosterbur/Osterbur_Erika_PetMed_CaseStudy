<jsp:include page="../include/header.jsp" />

<h1>Create a New Vet Visit</h1>

<div id="formContainer">
    <div id="formDiv" class="col-4">
        <form action="/vetvisit/registerSubmitVetVisit" method="post">
            <input type="date" name="date" placeholder="Date" class="form-control form-control-lg mb-3">
            <input type="text" name="vaccines" placeholder="Vaccines" class="form-control form-control-lg mb-3">
            <input type="text" name="notes" placeholder="Notes" class="form-control form-control-lg mb-3">
            <input type="text" name="weight" placeholder="Weight" class="form-control form-control-lg mb-3">
            <input type="text" name="petId" placeholder="petId" class="form-control form-control-lg mb-3">
            <input type="text" name="vetId" placeholder="vetId" class="form-control form-control-lg mb-3">
            <button type="submit" class="btn btn-dark">Save New Vet Visit</button>
        </form>
    </div>
</div>



<jsp:include page="../include/footer.jsp" />