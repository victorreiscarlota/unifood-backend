export const ENDPOINTS = {
  cantinas: '/cantinas',
  alunos: '/alunos',
  alunosPorId: (id) => `/alunos/${id}`,
  cantinaPorId: (id) => `/cantinas/${id}`,
  login: '/login/aluno',
  emailVerification: '/email/send-verification', 
  send: '/email/send',
  verification: '/email/send-verification',
};

export const getFullUrl = (endpoint) =>
  import.meta.env.VITE_PUBLIC_BACKEND_BASE_URL + endpoint;
