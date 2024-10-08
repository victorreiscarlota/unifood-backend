import Axios from "axios";
import { ENDPOINTS, getFullUrl } from "../endpoints";

export const getRestaurants = async () => {
  const response = await Axios.get(getFullUrl(ENDPOINTS.cantinas));

  return response.data;
};

export const getRestaurantById = async (id) => {
  const response = await Axios.get(getFullUrl(ENDPOINTS.cantinaPorId(id)));

  return response.data;
  
};
