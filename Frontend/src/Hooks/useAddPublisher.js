import { useContext } from "react";
import { AddPublisherContext } from "Contexts/AddPublisherContext";

export default function useAddPublisher(){
  return useContext(AddPublisherContext)
}