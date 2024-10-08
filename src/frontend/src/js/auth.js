import Axios from 'axios';
import { emailToken } from './services/http/users';
import { ROUTES } from '../navigation/routes';


document.getElementById('forgotSubmit').addEventListener('click', async function (event) {
    event.preventDefault();
    var emailValue = document.getElementById('forgotEmail').value.trim();
    if (emailValue !== "") {
        try {
            await emailToken(emailValue);
            
            
            console.log("Email token sent for:", emailValue);
            showEnterCodeForm();
        } catch (error) {
            
            console.error("Error sending email token:", error);
            alert("Error sending email token. Please try again.");
        }
    } else {
        alert("Enter the email before proceeding");
    }
});
document.getElementById('enterCodeSubmit').addEventListener('click', async function (event) {
    event.preventDefault();
    var enterCodeValue = document.getElementById('enterCode').value.trim();
    
    if (enterCodeValue !== "") {
        
        showNewPasswordForm();
    } else {
        alert("Digite o código antes de prosseguir");
    }
});

document.getElementById('newPasswordSubmit').addEventListener('click', async function (event) {
    event.preventDefault();
    var newPasswordValue = document.getElementById('newPassword').value.trim();

    if (newPasswordValue !== "") {
        
        console.log("Nova senha salva:", newPasswordValue);

        window.location.href = "/restaurants";
    } else {
        alert("Por favor, digite uma senha nova antes de sair");
    }
});

function showEnterCodeForm() {
    document.getElementById('forgotForm').style.display = 'none';
    document.getElementById('enterCodeForm').style.display = 'block';
}

function showNewPasswordForm() {
    document.getElementById('enterCodeForm').style.display = 'none';
    document.getElementById('newPasswordForm').style.display = 'block';
}
