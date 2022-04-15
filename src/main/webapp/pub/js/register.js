// $(document).ready(function() {
//
//     const emailRegex = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
//     const passwordRegex = /^(?=.*\d)(?=.*[A-Za-z])([^\s]){8,20}$/;
//
//     $('#petOwnerRegister').on("submit", function(event){
//         let userEmailId = $('#userEmailId').val();
//         let userPasswordId = $('#userPasswordId').val();
//         let userConfirmPasswordId = $('#userConfirmPasswordId').val();
//
//         if(
//             emailRegex.test(userEmailId) &&
//             passwordRegex.test(userPasswordId) &&
//             userPasswordId === userConfirmPasswordId
//         )
//         {
//             console.log("Success!");
//         } else if(!emailRegex.test(userEmailId)){
//             alert("Not a valid email!");
//         } else if(!passwordRegex.test(userPasswordId)){
//             alert("Password must contain at least one letter, one number, and be between 8 and 20 characters");
//         } else if(userPasswordId !== userConfirmPasswordId){
//             alert("Passwords do not match");
//         }
//     });
// });
//
// // Disabling form submissions if there are invalid fields
// (function () {
//     'use strict'
//
//     // Fetch all the forms we want to apply custom Bootstrap validation styles to
//     let form1 = document.getElementById('petOwnerRegister')
//
//     // Loop over them and prevent submission
//     Array.prototype.slice.call(form1)
//         .forEach(function (form) {
//             form1.addEventListener('submit', function (event) {
//                 if (!form1.checkValidity()) {
//                     event.preventDefault()
//                     event.stopPropagation()
//                 }
//
//                 form1.classList.add('was-validated')
//             }, false)
//         })
// })();


let check = function() {
    if (document.getElementById('userPasswordId').value ===
        document.getElementById('userConfirmPasswordId').value) {
        document.getElementById('message').style.color = 'green';
        document.getElementById('message').innerHTML = 'Passwords match!';
    } else {
        document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = 'Passwords do not match';
    }
}