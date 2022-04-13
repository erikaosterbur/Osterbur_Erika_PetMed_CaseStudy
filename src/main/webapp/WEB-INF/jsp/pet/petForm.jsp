<jsp:include page="../include/header.jsp" />

<h1>Create a New Pet Profile</h1>

<div id="formContainer">
    <div id="formDiv" class="col-4">
        <form action="/pet/registerSubmitPet" method="post">
            <input type="text" name="name" placeholder="Name" class="form-control form-control-lg mb-3">
            <input type="text" name="type" placeholder="Type" class="form-control form-control-lg mb-3">
            <input type="text" name="breed" placeholder="Breed" class="form-control form-control-lg mb-3">
            <input type="date" name="birthday" placeholder="Birthday" class="form-control form-control-lg mb-3">
            <button type="submit" class="btn btn-dark">Save New Pet</button>
        </form>
    </div>
</div>



<jsp:include page="../include/footer.jsp" />