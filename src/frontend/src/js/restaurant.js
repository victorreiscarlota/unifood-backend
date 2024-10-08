import { addToCart } from "./cart";
import { getRestaurantById } from "./services/http/restaurants";



const getRestaurant = async () => {
  try {
    const currentUrl = window.location.href.split("/");
    console.log("currentUrl", currentUrl.at(-1));
    const restaurant = await getRestaurantById(currentUrl.at(-1));

    const hero = document.querySelector(".hero");
    const logo = document.querySelector(".restaurant-logo");

    if (logo) {
      logo.src =
        restaurant.image ||
        "https://images.unsplash.com/photo-1514933651103-005eec06c04b?auto=format&fit=crop&q=80&w=75&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";
    }

    hero.appendChild(
      Object.assign(document.createElement("p"), {
        textContent: restaurant.nome,
      })
    );

    const menu = document.querySelector(".menu");

    const menuItems = restaurant?.produtos?.map?.((item) => {
      const itemDom = document.createElement("div");
      itemDom.classList.add("menu--item");

      const itemTitle = document.createElement("h3");
      itemTitle.textContent = item.nome;

      const itemDesc = document.createElement("p");
      itemDesc.textContent = item.descricao;

      const itemPrice = document.createElement("p");
      itemPrice.textContent = item.preco;

      const addToCartButton = Object.assign(document.createElement("button"), {
        class: "add-to-cart--btn",
        onclick: () => addToCart(item),
        textContent: "Adicionar ao carrinho",
      });

      const cardFooter = document.createElement("div");
      cardFooter.classList.add("menu--item--footer");

      cardFooter.appendChild(itemPrice);
      cardFooter.appendChild(addToCartButton);

      itemDom.appendChild(itemTitle);
      itemDom.appendChild(itemDesc);
      itemDom.appendChild(cardFooter);
      return itemDom;
    });

    menuItems.forEach((menuItem) => menu.appendChild(menuItem));

    console.log(restaurant);
  } catch (error) {}
};

getRestaurant();
