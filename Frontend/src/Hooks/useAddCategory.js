import { useContext } from "react";
import { AddCategoryContext } from "Contexts/AddCategoryContext";

export default function useAddCategory(){
  return useContext(AddCategoryContext)
}