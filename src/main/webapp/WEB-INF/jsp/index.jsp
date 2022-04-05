<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PetMed</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200;400&family=Questrial&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
    <link rel="stylesheet" href="../../pub/css/index.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>

    <ul class="nav justify-content-center">
        <li>
            <a href="#login">Login</a>
        </li>
        <li>
            <a href="#register">Register</a>
        </li>
    </ul>

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
        <jsp:include page="./user/login.jsp" />
    </div>

    <div id="register">
        <jsp:include page="./user/register.jsp" />
    </div>



</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="../../pub/js/landing.js"></script>
<script src="../../pub/js/register.js"></script>
</html>