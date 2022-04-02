$(document).ready(function() {

    $('#registerForm').on("submit", function(event){
        let emailId = $('#emailId').val();
        let passwordId = $('#passwordId').val();
        let confirmPasswordId = $('#confirmPasswordId').val();

        const emailRegex = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        const passwordRegex = /^(?=.*\d)(?=.*[A-Za-z])([^\s]){8,20}$/;
        if(
            emailRegex.test(emailId) &&
            passwordRegex.test(passwordId) &&
            passwordId === confirmPasswordId
        )
        {
            alert("Success!");
        } else if(!emailRegex.test(emailId)){
            alert("Not a valid email!");
        } else if(!passwordRegex.test(passwordId)){
            alert("Password must contain at least one letter, one number, and be between 8 and 20 characters");
        } else if(passwordId !== confirmPasswordId){
            alert("Passwords do not match");
        }
    });

});

// Disabling form submissions if there are invalid fields
(function () {
    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    let forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
        .forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }

                form.classList.add('was-validated')
            }, false)
        })
})();

let check = function() {
    if (document.getElementById('passwordId').value ===
        document.getElementById('confirmPasswordId').value) {
        document.getElementById('message').style.color = 'green';
        document.getElementById('message').innerHTML = 'Passwords match!';
    } else {
        document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = 'Passwords do not match';
    }
}