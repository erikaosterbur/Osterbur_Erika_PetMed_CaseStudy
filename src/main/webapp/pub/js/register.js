$(document).ready(function() {

    const emailRegex = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    const passwordRegex = /^(?=.*\d)(?=.*[A-Za-z])([^\s]){8,20}$/;

    $('#petOwnerRegister').on("submit", function(event){
        let userEmailId = $('#userEmailId').val();
        let userPasswordId = $('#userPasswordId').val();
        let userConfirmPasswordId = $('#userConfirmPasswordId').val();

        if(
            emailRegex.test(userEmailId) &&
            passwordRegex.test(userPasswordId) &&
            userPasswordId === userConfirmPasswordId
        )
        {
            alert("Success!");
        } else if(!emailRegex.test(userEmailId)){
            alert("Not a valid email!");
        } else if(!passwordRegex.test(userPasswordId)){
            alert("Password must contain at least one letter, one number, and be between 8 and 20 characters");
        } else if(userPasswordId !== userConfirmPasswordId){
            alert("Passwords do not match");
        }
    });

    $('#vetRegister').on("submit", function(event){
        let vetEmailId = $('#vetEmailId').val();
        let vetPasswordId = $('#vetPasswordId').val();
        let vetConfirmPasswordId = $('#vetConfirmPasswordId').val();

        if(
            emailRegex.test(vetEmailId) &&
            passwordRegex.test(vetPasswordId) &&
            vetPasswordId === vetConfirmPasswordId
        )
        {
            alert("Success!");
        } else if(!emailRegex.test(vetEmailId)){
            alert("Not a valid email!");
        } else if(!passwordRegex.test(vetPasswordId)){
            alert("Password must contain at least one letter, one number, and be between 8 and 20 characters");
        } else if(vetPasswordId !== vetConfirmPasswordId){
            alert("Passwords do not match");
        }
    });

});

// Disabling form submissions if there are invalid fields
(function () {
    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    let form1 = document.getElementById('petOwnerRegister')

    // Loop over them and prevent submission
    Array.prototype.slice.call(form1)
        .forEach(function (form) {
            form1.addEventListener('submit', function (event) {
                if (!form1.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }

                form1.classList.add('was-validated')
            }, false)
        })
})();

// Disabling form submissions if there are invalid fields
(function () {
    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    let form2 = document.getElementById('vetRegister')

    // Loop over them and prevent submission
    Array.prototype.slice.call(form2)
        .forEach(function (form) {
            form2.addEventListener('submit', function (event) {
                if (!form2.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }

                form2.classList.add('was-validated')
            }, false)
        })
})();

let check = function() {
    if (document.getElementById('userPasswordId').value ===
        document.getElementById('userConfirmPasswordId').value) {
        document.getElementsByClassName('message1').style.color = 'green';
        document.getElementsByClassName('message1').innerHTML = 'Passwords match!';
    } else {
        document.getElementsByClassName('message1').style.color = 'red';
        document.getElementsByClassName('message1').innerHTML = 'Passwords do not match';
    }
    if (document.getElementById('vetPasswordId').value ===
        document.getElementById('vetConfirmPasswordId').value) {
        document.getElementsByClassName('message2').style.color = 'green';
        document.getElementsByClassName('message2').innerHTML = 'Passwords match!';
    } else {
        document.getElementsByClassName('message2').style.color = 'red';
        document.getElementsByClassName('message2').innerHTML = 'Passwords do not match';
    }
}