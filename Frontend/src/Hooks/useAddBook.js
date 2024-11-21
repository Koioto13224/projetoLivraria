import { useContext } from "react";

import { AddBookContext } from "Contexts/AddBookContext";

export default function useAddBook(){
  return useContext(AddBookContext)
}