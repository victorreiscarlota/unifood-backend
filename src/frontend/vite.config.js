import { resolve } from "path";
import { defineConfig } from "vite";

export default defineConfig({
  build: {
    rollupOptions: {
      input: {
        main: resolve(__dirname, "index.html"),
        home: resolve(__dirname, "src/home.html"),
        orders: resolve(__dirname, "src/orders.html"),
        register: resolve(__dirname, "src/register.html"),
        restaurant: resolve(__dirname, "src/restaurant.html"),
        restaurants: resolve(__dirname, "src/restaurants.html"),
        "user-profile": resolve(__dirname, "src/user-profile.html"),
      },
    },
  },
});
