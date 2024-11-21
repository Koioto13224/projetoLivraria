import { useContext } from "react";
import { UpdateProductContext } from "Contexts/UpdateProduct";

export default function useUpdateProduct(){
  return useContext(UpdateProductContext)
}