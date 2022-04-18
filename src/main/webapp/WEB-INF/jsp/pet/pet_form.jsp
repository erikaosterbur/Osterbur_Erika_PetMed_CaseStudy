<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<style>
    h1{
        color: white;
        text-align: center;
        margin: 30px;
    }
    label{
        color: white;
    }
</style>

<c:if test="${empty form.id}">
    <h1>Create New Pet Profile</h1>
</c:if>

<c:if test="${not empty form.id}">
    <h1>Edit Pet Profile</h1>
</c:if>

<div id="formContainer">
    <div id="formDiv" class="col-4">
        <form action="/pet/registerSubmitPet" method="post" id="petRegister">

            <input type="hidden" name="id" value="${form.id}">

            <c:if test="${not empty form.id}">
                <label for="petName">Name</label>
            </c:if>
            <input type="text" name="name" placeholder="Enter pet's name" class="form-control form-control-lg mb-3" value="${form.name}" id="petName">

            <c:forEach items="${bindingResult.getFieldErrors('name')}" var="error">
                <div style="color: red;">
                        ${error.getDefaultMessage()}
                </div>
            </c:forEach>

            <div id="formSelect">
                <label for="addPetTypeSelect">Type</label>
                <select class="form-select mb-3" id="addPetTypeSelect" name="type">
                    <c:if test="${empty form.id}">
                        <option selected></option>
                    </c:if>
                    <c:if test="${not empty form.id}">
                        <option selected value="${form.type}">${form.type}</option>
                    </c:if>
                    <option value="Dog" name="Dog">Dog</option>
                    <option value="Cat" name="Cat">Cat</option>
                    <option value="Rabbit" name="Rabbit">Rabbit</option>
                    <option value="Hedgehog" name="Hedgehog">Hedgehog</option>
                    <option value="Hamster" name="Hamster">Hamster</option>
                    <option value="Gerbil" name="Gerbil">Gerbil</option>
                    <option value="Ferret" name="Ferret">Ferret</option>
                    <option value="Chinchilla" name="Chinchilla">Chinchilla</option>
                    <option value="Sugar Glider" name="Sugar Glider">Sugar Glider</option>
                    <option value="Bird" name="Bird">Bird</option>
                    <option value="Rat" name="Rat">Rat</option>
                    <option value="Guinea Pig" name="Guinea Pig">Guinea Pig</option>
                    <option value="Snake" name="Snake">Snake</option>
                    <option value="Turtle" name="Turtle">Turtle</option>
                    <option value="Bearded Dragon" name="Bearded Dragon">Bearded Dragon</option>
                    <option value="Chameleon" name="Chameleon">Chameleon</option>
                    <option value="Fish" name="Fish">Fish</option>
                    <option value="Other" name="Other">Other</option>
                </select>
                <c:forEach items="${bindingResult.getFieldErrors('type')}" var="error">
                    <div style="color: red;">
                            ${error.getDefaultMessage()}
                    </div>
                </c:forEach>
            </div>

            <c:if test="${not empty form.id}">
                <label for="petBreed">Breed</label>
            </c:if>
            <input type="text" name="breed" placeholder="Enter pet breed" class="form-control form-control-lg mb-3" value="${form.breed}" id="petBreed">
            <c:forEach items="${bindingResult.getFieldErrors('breed')}" var="error">
                <div style="color: red;">
                        ${error.getDefaultMessage()}
                </div>
            </c:forEach>

            <label for="birthday" style="color: white">Date of birth</label>
            <input id="birthday" type="date" name="birthday" placeholder="Enter pet birthday" class="form-control form-control-lg mb-3" value="${form.birthday}">
            <c:forEach items="${bindingResult.getFieldErrors('birthday')}" var="error">
                <div style="color: red;">
                        ${error.getDefaultMessage()}
                </div>
            </c:forEach>

            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-dark">Save Pet</button>
            </div>
        </form>
    </div>
</div>



<script>
    $(document).ready(function() {
        let select = $('#addPetTypeSelect');
        select.change(function(){
            if(select.val() === 'Other'){
                select.removeAttr("name");
                $('#formSelect').append(
                    `<input type="text" name="type" placeholder="Enter pet type" class="form-control form-control-lg mb-3">`
                )
            }
        });
    });
</script>


<jsp:include page="../include/footer.jsp" />
