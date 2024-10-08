import { getRestaurants } from "./services/http/restaurants";

async function loadRestaurants() {
  try {
    const restaurants = await getRestaurants();

    const produtosDiv = document.getElementById("produtos");

    const imageElements = restaurants.map((restaurant) => {
      const cartaoDiv = document.createElement("div");
      cartaoDiv.classList.add("cartao");
      cartaoDiv.onclick = () =>
        window.location.replace(`/restaurant/${restaurant?.id}`);

      const imgElement = document.createElement("img");
      imgElement.src = restaurant.image;

      cartaoDiv.appendChild(imgElement);

      return cartaoDiv;
    });

    imageElements.forEach((element) => {
      produtosDiv.appendChild(element);
    });
  } catch (error) {
    // Handle errors here
  }
}

loadRestaurants(); // Call the async function