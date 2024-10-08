import { ROUTES } from '../navigation/routes';

document.addEventListener('DOMContentLoaded', () => {
  const storedUser = localStorage.getItem('loggedUser');

  if (storedUser) {
    const user = JSON.parse(storedUser);

    document.querySelector('.user-info-name').innerText = user.name || '';
    document.querySelector('.user-info-email').innerText = user.email || '';
    document.querySelector('.user-info-phone').innerText = user.phone || '';
    document.querySelector('.user-info-cpf').innerText = user.cpf || '';
  } else {
    window.location.href = `${ROUTES['/']}`;
  }
});