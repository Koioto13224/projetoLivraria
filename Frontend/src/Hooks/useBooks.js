import { useContext } from "react";

import { ProductsContext } from "Contexts/ProductsContext";

export default function useBooks(){
  return useContext(ProductsContext)
}