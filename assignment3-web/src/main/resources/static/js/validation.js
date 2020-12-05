let form = document.getElementById('form');
let pw1 = document.getElementById('password');
let pw2 = document.getElementById('password2');

form.addEventListener('submit', (event) =>{
    if (pw1.value !== pw2.value){
        event.preventDefault();
        document.getElementById('pw-error').innerHTML = "Passwords do not match";
    }
});