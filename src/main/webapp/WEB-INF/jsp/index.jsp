<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />

    <h1>Welcome, ${user.firstName} ${user.lastName}</h1>


    <div class="headline">
        <h1 class="animate__animated animate__fadeInUp">PetMed</h1>
        <h2 class="animate__animated animate__fadeInDown">take the stress out of managing your pets' medical records</h2>
    </div>

    <div class="container">
        <img src="../../pub/images/puppy-at-vet.jpg" alt="puppy at the vet office" class="imgContainer"/>
        <h2 class="textContainer">Create profiles for each of your pets</h2>
    </div>

    <div class="container">
        <h2 class="textContainer">Log vet visits to organize your pets' medical records</h2>
        <img src="../../pub/images/puppy-meds.jpg" alt="puppy receiving medicine from syringe" class="imgContainer"/>
    </div>

    <div class="container">
        <img src="../../pub/images/vet-and-puppy.jpg" alt="veterinarian posing with puppy" class="imgContainer"/>
        <h2 class="textContainer">Keep track of which vets your pet sees</h2>
    </div>


    <div id="login">
        <jsp:include page="login/loginForm.jsp" />
    </div>

    <div id="register">
        <jsp:include page="./user/register.jsp" />
    </div>


<jsp:include page="include/footer.jsp" />