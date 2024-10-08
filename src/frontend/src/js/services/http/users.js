import Axios from 'axios';
import { ENDPOINTS, getFullUrl } from '../endpoints';
import { Toast } from '../../main';
import { ROUTES } from '../../../navigation/routes';

export const getUsers = async () => {
  const response = await Axios.get(getFullUrl(ENDPOINTS.alunos));
  return response.data;
};

export const getUserById = async (id) => {
  const response = await Axios.get(getFullUrl(ENDPOINTS.alunosById(id)));

  return response.data;
};


export const createUser = async (user) => {
  try {
    const response = await Axios.post(getFullUrl(ENDPOINTS.alunos), user);
    console.log(response);

    if (response.data) {
      Toast.fire({
        icon: 'success',
        title: 'Registration successful',
      });
      return response.data;
    } else {
      throw new Error('User not created');
    }
  } catch (error) {
    Toast.fire({
      icon: 'error',
      title: 'Error creating user',
    });
    console.error(`Registration error: ${error.response?.data}`);
    throw error;
  }
};


export const userLogin = async (email, password) => {
  try {
    const payload = {
      email: email,
      senha: password,
    };

    const response = await Axios.post(getFullUrl(ENDPOINTS.login), payload);
    console.log(response);
    if (response.status === 200) {
      Toast.fire({
        icon: 'success',
        title: 'Login realizado com sucesso',
      });

      window.location.href = `${ROUTES['/restaurants']}`;
      return response;
    }
  } catch (error) {
    Toast.fire({
      icon: 'error',
      title: error.response.data,
    });
    console.error(`Login error: ${error.response?.data}`);
  }
};

export const emailToken = async (email) => {
  try {
    const payload = {
      email: email,
    };

    console.log('Sending email token request:', payload);

    const response = await Axios.post(getFullUrl(ENDPOINTS.emailVerification), payload);
    console.log('Email token response:', response);

    if (response.status === 200) {
      Toast.fire({
        icon: 'success',
        title: 'Token sent successfully',
      });

      return response;
    }
  } catch (error) {
    Toast.fire({
      
      icon: 'error',
      title: 'Erro ao enviar token',
    });
    console.error(`Token sending error: ${error.response?.data}`);
  }
};