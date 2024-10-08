import { createUser, userLogin } from './services/http/users';
import { ROUTES } from '../navigation/routes';
import { Toast } from './main';

const loginButton = document.querySelector('#logar-btn');
const registerButton = document.querySelector('#registrar-btn');
const container = document.querySelector('.container');

registerButton.addEventListener('click', () => {
  container.classList.add('modo-de-registro');
});

loginButton.addEventListener('click', () => {
  container.classList.remove('modo-de-registro');
});

document.querySelector('#registerSubmit').addEventListener('click', async () => {

    const email = document.querySelector('#registerEmail').value;
    const senha = document.querySelector('#registerPassword').value;
    const nome = document.querySelector('#registerName').value;
    const telefone = document.querySelector('#registerPhone').value;
    const cpf = document.querySelector('#registerCpf').value;

    try {
      const user = await createUser({ email, senha, nome, telefone, cpf });
      localStorage.setItem('user', JSON.stringify(user));
      window.location.href = `${ROUTES['/restaurants']}`;
    } catch (error) {
      console.error(`Registration error: ${error}`);
    }
  });

document.querySelector('#loginSubmit').addEventListener('click', function(event) {
  event.preventDefault();

  const email = document.querySelector('#loginEmail').value;
  const senha = document.querySelector('#loginPassword').value;

  try {
    userLogin(email, senha);
  }
  catch (error) {
    console.error(`Login error: ${error}`);
  }
});

document.querySelector('#registerSubmit').addEventListener('click', async () => {
  try {
    const email = document.querySelector('#registerEmail').value;
    const senha = document.querySelector('#registerPassword').value;
    const nome = document.querySelector('#registerName').value;
    const telefone = document.querySelector('#registerPhone').value;
    const cpf = document.querySelector('#registerCpf').value;

    const user = await createUser({ email, senha, nome, telefone, cpf });
    localStorage.setItem('user', JSON.stringify(user));
    window.location.href = `${ROUTES['/restaurants']}`;
  } catch (error) {
    console.error(`Registration error: ${error}`);
  }
});

document.querySelector('#loginSubmit').addEventListener('click', async (event) => {
  event.preventDefault();

  const email = document.querySelector('#loginEmail').value;
  const senha = document.querySelector('#loginPassword').value;

  try {
    await userLogin(email, senha);
  } catch (error) {
    console.error(`Login error: ${error}`);
  }
});
const forgotSubmitButton = document.querySelector('#forgotsubmit');

forgotSubmitButton.addEventListener('click', () => {
  console.log('Clicked forgotSubmitButton'); 
  window.location.href = '/src/forgot-password.html'; 
});



// document.querySelector('#loginSubmit').addEventListener('click', async () => {

//   const email = document.querySelector('#loginEmail').value;
//   const senha = document.querySelector('#loginPassword').value;

//   try {
//     const user = await userLogin({ email, senha });
//     localStorage.setItem('user', JSON.stringify(user));
//     console.log("Usuario Logado", user);
//     if (user) {
//       window.location.href = `${ROUTES['/restaurants']}`;
//     }
//   } catch (error) {
//     console.error(`Login error: ${error}`);
//   }
// });


// const loginForm = document.querySelector('.form-logar');
// const emailInput = document.querySelector('#login-input-email');
// const passwordInput = document.querySelector('#login-input-password');

// loginForm.addEventListener('submit', async (event) => {
//   event.preventDefault();

//   const email = emailInput.value;
//   const password = passwordInput.value;

//   try {
//     const user = await userLogin(email, password);
//     localStorage.setItem('loggedUser', JSON.stringify(user));
//     event.target.reset();
//     loginButton.disabled = true;

//     setTimeout(() => {
//       window.location.replace(`${ROUTES['/']}`);
//       loginButton.disabled = false;
//     }, 3000)
//     Toast.fire({
//       icon: 'success',
//       title: 'Login realizado com sucesso',
//     });
//   } catch (error) {
//     Toast.fire({
//       icon: 'error',
//       title: 'Erro! Erro ao realizar login',
//     });
//   }
// });