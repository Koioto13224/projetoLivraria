import { useContext } from "react";
import { CategoriesContext } from "Contexts/CategoriesContext";

export default  function useCategories(){
  return useContext(CategoriesContext)
}