import { Toast } from "./main";

export function addToCart(item) {
  try {
    const prevCart = JSON?.parse?.(localStorage?.getItem?.("cart"));

    let newCart = structuredClone(prevCart) || [];

    const foundItem = newCart?.find?.((found) => found.id === item.id);
    if (foundItem) {
      foundItem.quantity += 1;
      localStorage.setItem("cart", JSON.stringify(newCart));
      return Toast.fire({
        icon: "success",
        title: "Adicionado ao carrinho",
      });
    }

    newCart.push({ ...item, quantity: 1 });
    localStorage.setItem("cart", JSON.stringify(newCart));
    return Toast.fire({
      icon: "success",
      title: "Adicionado ao carrinho",
    });
  } catch (error) {
    return Toast.fire({
      icon: "error",
      title: "Erro! Erro ao adicionar ao carrinho",
    });
  }
}
