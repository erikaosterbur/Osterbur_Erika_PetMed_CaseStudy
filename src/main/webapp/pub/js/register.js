// $(document).ready(function() {
//
//     $('#petOwnerRegister').on("submit", function(event){
//         let userEmailId = $('#userEmailId').val();
//         let userPasswordId = $('#userPasswordId').val();
//         let userConfirmPasswordId = $('#userConfirmPasswordId').val();
//
//         const emailRegex = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
//         const passwordRegex = /^(?=.*\d)(?=.*[A-Za-z])([^\s]){8,20}$/;
//         if(
//             emailRegex.test(userEmailId) &&
//             passwordRegex.test(userPasswordId) &&
//             userPasswordId === userConfirmPasswordId
//         )
//         {
//             alert("Success!");
//         } else if(!emailRegex.test(userEmailId)){
//             alert("Not a valid email!");
//         } else if(!passwordRegex.test(userPasswordId)){
//             alert("Password must contain at least one letter, one number, and be between 8 and 20 characters");
//         } else if(userPasswordId !== userConfirmPasswordId){
//             alert("Passwords do not match");
//         }
//     });
//
// });
//
// // Disabling form submissions if there are invalid fields
// (function () {
//     'use strict'
//
//     // Fetch all the forms we want to apply custom Bootstrap validation styles to
//     let forms = document.querySelectorAll('.needs-validation')
//
//     // Loop over them and prevent submission
//     Array.prototype.slice.call(forms)
//         .forEach(function (form) {
//             form.addEventListener('submit', function (event) {
//                 if (!form.checkValidity()) {
//                     event.preventDefault()
//                     event.stopPropagation()
//                 }
//
//                 form.classList.add('was-validated')
//             }, false)
//         })
// })();
//
// let check = function() {
//     if (document.getElementById('userPasswordId').value ===
//         document.getElementById('userConfirmPasswordId').value) {
//         document.getElementsByClassName('message').style.color = 'green';
//         document.getElementsByClassName('message').innerHTML = 'Passwords match!';
//     } else {
//         document.getElementsByClassName('message').style.color = 'red';
//         document.getElementsByClassName('message').innerHTML = 'Passwords do not match';
//     }
// }