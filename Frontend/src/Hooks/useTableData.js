import { useState } from "react";

import tabelaMocked from "Mocks/tabelaMocked";

export default function useTableData(){
  const [data, setData] = useState(tabelaMocked)

  return data
}