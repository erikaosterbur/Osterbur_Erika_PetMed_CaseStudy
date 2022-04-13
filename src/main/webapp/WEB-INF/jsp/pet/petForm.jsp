<jsp:include page="../include/header.jsp" />

<h1>Pet Profile</h1>

<div id="formContainer">
    <div id="formDiv" class="col-4">
        <form action="/pet/registerSubmitPet" method="post">
            <input type="hidden" name="id" value="${form.id}">
            <input type="text" name="name" placeholder="Enter pet's name" class="form-control form-control-lg mb-3" value="${form.name}">
            <select class="form-select mb-3" id="addPetTypeSelect" name="type">
                <option selected value="${form.type}">Type...</option>
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
            <input type="text" name="breed" placeholder="Enter pet breed" class="form-control form-control-lg mb-3" value="${form.breed}">
            <input type="date" name="birthday" placeholder="Enter pet birthday" class="form-control form-control-lg mb-3" value="${form.birthday}">
            <button type="submit" class="btn btn-dark">Save Pet</button>
        </form>
    </div>
</div>



<jsp:include page="../include/footer.jsp" />